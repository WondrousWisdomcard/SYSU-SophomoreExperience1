#include<iostream>
#include<fstream>
#include<sstream>
#include<algorithm>
#include"../include/Storage.hpp"
#include"../include/Path.hpp"

using namespace std;

Storage::Storage()
{
    readFromFile();
    m_dirty = false;
}

bool Storage::readFromFile(void)
{
    ifstream userin(Path::userPath);
    if(!userin.is_open())
    {
        cout<<endl<<"[INNER ERROR] FAILED TO OPEN USERS.CSV IN READ FROM FILE!"<<endl;
        return false;
    }
    stringstream buffer;
    buffer << userin.rdbuf();
    string userdata(buffer.str()); //datas in users.csv now are coped in string userdata

    while(userdata.length() != 0 && userdata[0] != '\n')
    {
        string::size_type FirstPos = 1;
        string::size_type LastPos = userdata.find(",")-1;
        string name = userdata.substr(FirstPos, LastPos-FirstPos);
        userdata = userdata.substr(LastPos+2,userdata.length());
        LastPos = userdata.find(",")-1;

        string password = userdata.substr(FirstPos, LastPos-FirstPos);
        userdata = userdata.substr(LastPos+2,userdata.length());
        LastPos = userdata.find(",")-1;

        string email = userdata.substr(FirstPos, LastPos-FirstPos);
        userdata = userdata.substr(LastPos+2,userdata.length());
        LastPos = userdata.find("\n")-1;

        string phone = userdata.substr(FirstPos, LastPos-FirstPos);
        userdata = userdata.substr(LastPos+2,userdata.length());

        User user(name,password,email,phone);
        m_userList.push_back(user);
    }
    userin.close();

    ifstream meetingin(Path::meetingPath);
    if(!meetingin.is_open())
    {
        cout<<endl<<"[INNER ERROR] FAILED TO OPEN MEETINGS.CSV IN READ FROM FILE!"<<endl;
        return false;
    }
    stringstream buffer2;
    buffer2 << meetingin.rdbuf();
    string meetingdata(buffer2.str());

    while(meetingdata.length() != 0)
    {
        string::size_type FirstPos = 1;
        string::size_type LastPos = meetingdata.find(",")-1;
        string sponsorName = meetingdata.substr(FirstPos, LastPos-FirstPos);
        meetingdata = meetingdata.substr(LastPos+2, meetingdata.length());
        LastPos = meetingdata.find(",")-1;

        string participatorsString = meetingdata.substr(FirstPos, LastPos-FirstPos);
        meetingdata = meetingdata.substr(LastPos+2, meetingdata.length());
        LastPos = meetingdata.find(",")-1;

        string StartDateString= meetingdata.substr(FirstPos, LastPos-FirstPos);
        meetingdata = meetingdata.substr(LastPos+2, meetingdata.length());
        LastPos = meetingdata.find(",")-1;
        
        string EndDateString = meetingdata.substr(FirstPos, LastPos-FirstPos);
        meetingdata = meetingdata.substr(LastPos+2, meetingdata.length());
        LastPos = meetingdata.find("\n")-1;\

        string meetingName = meetingdata.substr(FirstPos, LastPos-FirstPos);
        meetingdata = meetingdata.substr(LastPos+2, meetingdata.length());

        vector<string> participators;
        while(participatorsString.length() != 0)
        {
            string::size_type FirstPos = 0;
            string::size_type LastPos;
            for(LastPos = 0; LastPos < participatorsString.length(); LastPos++)
            {
                if(participatorsString[LastPos] == '&')
                {
                    break;
                }
            }
            participators.push_back(participatorsString.substr(FirstPos,LastPos));
            if(LastPos+1 <= participatorsString.length())
            {
                participatorsString = participatorsString.substr(LastPos+1,participatorsString.length());
            }
            else
            {
                participatorsString = "";
            }
        }
        Date start(StartDateString);
        Date end(EndDateString);
        Meeting meeting(sponsorName,participators,start,end,meetingName);
        m_meetingList.push_back(meeting);
    }
    meetingin.close();
    return true;
}

bool Storage::writeToFile(void)
{
    ofstream userout(Path::userPath);
    if(!userout.is_open())
    {
        cout<<endl<<"[INNER ERROR] FAILED TO OPEN USERS.CSV IN WRITE TO FILE!"<<endl;
        return false;
    }
    for(auto iter = m_userList.begin(); iter != m_userList.end(); iter++)
    {
        userout<<'"'<<iter->getName()<<'"'<<',' \
               <<'"'<<iter->getPassword()<<'"'<<',' \
               <<'"'<<iter->getEmail()<<'"'<<',' \
               <<'"'<<iter->getPhone()<<'"'<<endl;
    }
    userout.close();

    ofstream meetingout(Path::meetingPath);
    if(!meetingout.is_open())
    {
        cout<<endl<<"[INNER ERROR] FAILED TO OPEN MEETINGS.CSV IN WRITE TO FILE!"<<endl;
        return false;
    }
    for(auto jter = m_meetingList.begin(); jter != m_meetingList.end(); jter++)
    {
        meetingout<<'"'<<jter->getSponsor()<<'"'<<','<<'"';
        vector<string> participators = jter->getParticipator();
        for(auto kter = participators.begin(); kter !=participators.end(); kter++)
        {
            meetingout<<*kter;
            if(kter != participators.end()-1)
            {
                meetingout<<'&';
            }
            else
            {
                meetingout<<'"'<<',';
            }
        }
        meetingout<<'"'<<Date::dateToString(jter->getStartDate())<<'"'<<',' \
                  <<'"'<<Date::dateToString(jter->getEndDate())<<'"'<<',' \
                  <<'"'<<jter->getTitle()<<'"'<<endl;
    }
    meetingout.close();
    return true;
}

std::shared_ptr<Storage> Storage::getInstance(void)
{
    if(m_instance == nullptr)
    {
        m_instance.reset(new Storage());
    }
    return m_instance;
}

Storage::~Storage()
{
    sync();
}

std::shared_ptr<Storage> Storage::m_instance = nullptr;

void Storage::createUser(const User &t_user)
{
    m_dirty = true;
    m_userList.push_back(t_user);
}

std::list<User> Storage::queryUser(std::function<bool(const User &)> filter) const
{
    list<User> returnList;
    for(auto iter = m_userList.begin(); iter != m_userList.end(); iter++)
    {
        if(filter(*iter))
        {
            returnList.push_back(*iter);
        }
    }
    return returnList;
}

int Storage::updateUser(std::function<bool(const User &)> filter, std::function<void(User &)> switcher)
{
    m_dirty = true;
    int count = 0;
    for(auto iter = m_userList.begin(); iter != m_userList.end(); iter++)
    {
        if(filter(*iter))
        {
            switcher(*iter);
            count++;
        }
    }
    return count;
}

int Storage::deleteUser(std::function<bool(const User &)> filter)
{
    m_dirty = true;
    int count = 0;
    auto newEnd = remove_if(m_userList.begin(),m_userList.end(), filter);
    for(auto iter = newEnd; iter != m_userList.end(); iter++)
    {
        count++;
    }
    m_userList.erase(newEnd,m_userList.end());
    return count;
}

void Storage::createMeeting(const Meeting &t_meeting)
{
    m_dirty = true;
    m_meetingList.push_back(t_meeting);
}

std::list<Meeting> Storage::queryMeeting(std::function<bool(const Meeting &)> filter) const
{
    list<Meeting> returnList;
    for(auto iter = m_meetingList.begin(); iter != m_meetingList.end(); iter++)
    {
        if(filter(*iter))
        {
            returnList.push_back(*iter);
        }
    }
    return returnList;
}

int Storage::updateMeeting(std::function<bool(const Meeting &)> filter,std::function<void(Meeting &)> switcher)
{
    m_dirty = true;
    int count = 0;
    for(auto iter = m_meetingList.begin(); iter != m_meetingList.end(); iter++)
    {
        if(filter(*iter))
        {
            switcher(*iter);
            count++;
        }
    }
    return count;
}

int Storage::deleteMeeting(std::function<bool(const Meeting &)> filter)
{
    m_dirty = true;
    int count = 0;
    auto newEnd = remove_if(m_meetingList.begin(),m_meetingList.end(), filter);
    for(auto iter = newEnd; iter != m_meetingList.end(); iter++)
    {
        count++;
    }
    m_meetingList.erase(newEnd,m_meetingList.end());
    return count; 
}

bool Storage::sync(void)
{
    if(m_dirty)
    {
        writeToFile();
        m_dirty = false;
    }
    return true;
}
