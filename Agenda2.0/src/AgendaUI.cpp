#include<iostream>
#include<string>
#include<iomanip>
#include"../include/AgendaUI.hpp"
#include"../include/Exception.hpp"
#include"../include/Log.hpp"
using namespace std;
const int SPACE_ = 25;
int Log::index = 0;

AgendaUI::AgendaUI()
{
    startAgenda();
}

void AgendaUI::OperationLoop(void)
{
    char operation;
    do
    {
        cout<<"-----------------------Agenda-----------------------"<<endl \
            <<"Action : "<<endl\
            << "l      - log in Agenda by user name and password"<<endl \
            << "r      - register an Agenda account"<<endl \
            << "q      - quit Agenda"<<endl \
            <<"-----------------------Agenda-----------------------"<<endl;
        cout<<endl<<"Agenda :~$";
        cin>>operation;
        switch(operation)
        {
            case 'l':
                userLogIn();
                break;
            case 'r':
                userRegister();
                break;
            case 'q':
                quitAgenda();
                break;
            default:
            cout<<"[error] unexpected input!"<<endl;
            break;
        }
    } while (operation != 'q');
}

void AgendaUI::startAgenda()
{
    m_agendaService.startAgenda();
}

string AgendaUI::getOperation()
{
    string operation;
    cout<<"-----------------------Agenda-----------------------"<<endl \
        <<"Action: "<<endl \
        <<"o     - log out Agenda"<<endl \
        <<"dc    - delete Agenda account"<<endl \
        <<"lu    - list all Agenda users"<<endl \
        <<"cm    - create a meeting"<<endl \
        <<"amp   - add a meeting participator"<<endl \
        <<"rmp   - remove a meeting participator"<<endl \
        <<"rqm   - request to quit meeting"<<endl \
        <<"la    - list all meetings"<<endl \
        <<"las   - list all sponsor meetings"<<endl \
        <<"lap   - list all participator meetings"<<endl \
        <<"qm    - query meeting by title"<<endl \
        <<"qt    - query meeting by time interval"<<endl \
        <<"dm    - delete meeting by title"<<endl \
        <<"da    - delete all meetings"<<endl
        <<"-----------------------Agenda-----------------------"<<endl;
        cout<<endl<<"Agenda@"<<m_userName<<" :~#";
        cin>>operation;
        return operation;    
}

bool AgendaUI::executeOperation(std::string t_operation)
{
    if(t_operation == "o")
    {
        userLogOut();
        return false;
    }
    else if(t_operation == "dc")
    {
        if(deleteUser())
        return false;
        return true;
    }
    else if(t_operation == "lu")
    {
        listAllUsers();
        return true;
    }
    else if(t_operation == "cm")
    {
        createMeeting();
        return true;
    }
    else if(t_operation == "amp")
    { 
        string title,partname;
        cout<<"[add participator] [meeting title] [participator username]"<<endl \
            <<"[add participator] ";
        cin>>title>>partname;
        bool m;
        try
        {
            m = m_agendaService.addMeetingParticipator(m_userName,title,partname);
        }
        catch(LimitedAuthorityException e)
        {
            cout<<"[add participator] error! "<<"You dont have the access to add participator in this meeting"<<endl;
        }
        catch(AlreadyExistedException e)
        {
            cout<<"[add participator] error! "<<e.getObj()<<" has already existed"<<endl;
        }
        catch(HaveNotExistedException e)
        {
            cout<<"[add participator] error! "<<e.getObj()<<" has not existed"<<endl;
        }
        catch(UserNoAvailableException e)
        {
            cout<<"[add] participator] error! "<<e.getObj()<<" is not available at that time interval"<<endl;
        }
        
        if(m = true)
        {
            m_log.write(m_userName,title + partname,"addMeetingParticipator","succeed");
            cout<<"[add participator] succeed!"<<endl;
        }
        else
        {
            m_log.write(m_userName,title + partname,"addMeetingParticipator","fail");
        }
        return true;
    }
    else if(t_operation == "rmp")
    {
        string title,partname;
        cout<<"[remove participator] [meeting title] [participator username]"<<endl \
            <<"[remove participator] ";
        cin>>title>>partname;
        bool m;
        try
        {
            m = m_agendaService.removeMeetingParticipator(m_userName,title,partname);
        }
        catch(HaveNotExistedException e)
        {
            cout<<"[remove paericipator] error! "<<e.getObj()<<" is not existed"<<endl;
        }
        catch(LimitedAuthorityException e)
        {
            cout<<"[remove paericipator] error! "<<e.getObj()<<" dont have the access to remove participator in this meeting"<<endl;
        }
        if(m == true)
        {
            m_log.write(m_userName,title + partname,"removeMeetingParticipator","succeed");
            cout<<"[remove participator] succeed!"<<endl;
        }
        else
        {
            m_log.write(m_userName,title + partname,"removeMeetingParticipator","fail");
        }
        return true;
    }
    else if(t_operation == "rqm")
    {
        string title;
        cout<<"[quit meeting] [meeting title]"<<endl \
            <<"[quit meeting] ";
        cin>>title;
        cout<<"[quit meeting] Are you sure to quit this meeting? (y/n)"<<endl;
        char c;
        cin >> c;
        if(c == 'y')
        {
            try
            {
                if(m_agendaService.quitMeeting(m_userName,title) == true)
                {
                    m_log.write(m_userName,title,"quitMeeting","succeed");
                    cout<<"[quit meeting] succeed!"<<endl;
                }
                else
                {
                    m_log.write(m_userName,title,"quitMeeting","fail");
                    cout<<"[quit meeting] error! you are no in this meeting"<<endl;
                }
            }
            catch(HaveNotExistedException e)
            {
                m_log.write(m_userName,title,"quitMeeting","fail");
                cout<<"[quit meeting] error! "<<e.getObj()<<" is not existed"<<endl;
            }
        }
        
        return true;
    }
    else if(t_operation == "la")
    {
        listAllMeetings();
        return true;
    }
   else if(t_operation == "las")
    {
        listAllSponsorMeetings();
        return true;
    }
    else if(t_operation == "lap")
    {
        listAllParticipateMeetings();
        return true;
    }
    else if(t_operation == "qm")
    {
        queryMeetingByTitle();
        return true;
    }
    else if(t_operation == "qt")
    {
        queryMeetingByTimeInterval();
        return true;
    }
    else if(t_operation == "dm")
    {
        deleteMeetingByTitle();
        return true;
    }
    else if(t_operation == "da")
    {
        deleteAllMeetings();
    }
    else
    {
        cout<<"[error] unexcepted input!"<<endl;
        return true;
    }
    return true;
}

void AgendaUI::userLogIn()
{
    string userName,passWord;
    cout<<"[log in] [username] [password]"<<endl;
    cout<<"[log in] ";
    cin>>userName>>passWord;
    if(m_agendaService.userLogIn(userName,passWord) == true)
    {
        m_userName = userName;
        m_userPassword = passWord;
        cout<<"[log in] succeed!"<<endl;
        m_log.write(userName,userName+" "+passWord,"userLogIn","succeed");
        while(executeOperation(getOperation()) == true);
    }
    else
    {
        m_log.write("*anon",userName+" "+passWord,"userLogIn","fail");
        cout<<"[log in] Password error or user doesn't exist"<<endl;
    }
}

void AgendaUI::userRegister()
{
    string userName,passWord,email,phone;
    cout<<"[register] attention! all of your personal information should not include <\">,<,>"<<endl;
    cout<<"[register] and your username should not include <&>"<<endl;
    cout<<"[register] [username] [password] [email] [phone]"<<endl;
    cout<<"[register] ";
    cin>>userName>>passWord>>email>>phone;
    try
    {
        m_agendaService.userRegister(userName,passWord,email,phone);
        
            m_log.write(userName,userName+" "+passWord+" "+email+" "+phone,"userRegister","succeed");
            cout<<"[register] succeed!"<<endl;
            m_userName = userName;
            m_userPassword = passWord;
            while(executeOperation(getOperation()) == true);
            return;  
    }
    catch(AlreadyExistedException e)
    {
        m_log.write("*anon",userName+" "+passWord+" "+email+" "+phone,"userRegister","fail");
        cout<<"[register] failed! "<<e.getObj()<<" has been register!"<<endl;
    }
    catch(VaildtyCheckException e)
    {
        m_log.write("*anon",userName+" "+passWord+" "+email+" "+phone,"userRegister","fail");
        cout<<"[register] failed! "<<e.getObj()<<" is not valid!"<<endl;
    }
}

void AgendaUI::userLogOut()
{
    m_log.write(m_userName,"*non","userLogOut","succeed");
    m_userName = "";
    m_userPassword = "";
    cout<<"[user log out] success!"<<endl;
}

void AgendaUI::quitAgenda()
{
    cout<<"[quit agenda] are you sure to quit agenda? [y/n]"<<endl;
    cout<<"[quit agenda] ";
    char c;
    cin>>c;
    if(c == 'y')
    {
        m_log.write("*anon","*non","quitAgenda","succeed");
        m_agendaService.quitAgenda();
        cout<<"[quit agenda] success!"<<endl;
    }
    else
    {
        m_log.write("*anon","*non","quitAgenda","fail");
        cout<<"[quit agenda] fail to quit!"<<endl;
    }
}

bool AgendaUI::deleteUser()
{
    cout<<"[delete agenda account] are you sure to delete your account? [y/n]"<<endl;
    cout<<"[delete agenda account] ";
    char c;
    cin>>c;
    if(c == 'y')
    {
        m_agendaService.deleteUser(m_userName,m_userPassword);
        m_log.write(m_userName,"*non","deleteUser","succeed");
        m_userName = "";
        m_userPassword = "";
        cout<<"[delete agenda account] success!"<<endl;
        return true;
    }
    else
    {
        m_log.write(m_userName,"*non","deleteUser","fail");
        cout<<"[delete agenda account] fail!"<<endl;
        return false;
    }
    
} 

void AgendaUI::listAllUsers()
{
    list<User> userList = m_agendaService.listAllUsers();
    cout<<"[list all users]"<<endl;
    cout<<left<<setw(SPACE_)<<"name"<<setw(SPACE_)<<"email"<<setw(SPACE_)<<"phone"<<endl;
    for(auto iter = userList.begin(); iter != userList.end(); iter++)
    {
        cout<<left<<setw(SPACE_)<<iter->getName()<<setw(SPACE_)<<iter->getEmail()<<setw(SPACE_)<<iter->getPhone()<<endl;
    }
    m_log.write(m_userName,"*non","listAllUsers","succeed");
}

void AgendaUI::createMeeting()
{
    int num;
    string input;
    string title,startDate,endDate;
    vector<string> participators;
    participators.clear();
    cout<<"[create meeting] [the number of participators]"<<endl \
        <<"[create meeting] ";
    cin>>num;
    input +=( num+'0');
    for(int i = 1; i <= num; i++)
    {
        string partname;
        cout<<"[create meeting] [please enter the participator "<<i<<" ]"<<endl \
            <<"[create meeting] ";
        cin >> partname;
        input = input + " " + partname;
        participators.push_back(partname);
    }
    cout<<"[create meeting] [title] [start time(yyyy-mm-dd/hh:mm)] [end time(yyyy-mm-dd/hh:mm)]"<<endl \
        <<"[create meeting] ";
    cin>>title>>startDate>>endDate;
    input = input + " " + title + " " + startDate + " " + endDate;
    bool m;
    try
    {
        m = m_agendaService.createMeeting(m_userName,title,startDate,endDate,participators);
    }
    catch(AlreadyExistedException e)
    {
        cout<<"[create meeting] error! "<<e.getObj()<<" has already existed!"<<endl;
    }
    catch(VaildtyCheckException e)
    {
        cout<<"[create meeting] error! "<<e.getObj()<<" is invaild"<<endl;
    }
    catch(HaveNotExistedException e)
    {
         cout<<"[create meeting] error! "<<e.getObj()<<" has not existed"<<endl;
    }
    catch(UserNoAvailableException e)
    {
         cout<<"[create meeting] error! "<<e.getObj()<<" is not available at that time interval"<<endl;
    }
    if(m == true)
    {
        m_log.write(m_userName,input,"createMeeting","succeed");
        cout<<"[create meeting] succeed!"<<endl;
    }
    else
    {
        m_log.write(m_userName,input,"createMeeting","fail");
    }
}

void AgendaUI::listAllMeetings()
{
    list<Meeting> meetingList = m_agendaService.listAllMeetings(m_userName);
    cout<<"[list all meetings]"<<endl;
    m_log.write(m_userName,"*non","listAllMeetings","succeed");
    printMeetings(meetingList);
}

void AgendaUI::listAllSponsorMeetings()
{
    list<Meeting> meetingList = m_agendaService.listAllSponsorMeetings(m_userName);
    cout<<"[list all sponsor meetings]"<<endl;
    m_log.write(m_userName,"*non","listAllSponsorMeetings","succeed");
    printMeetings(meetingList);
}

void AgendaUI::listAllParticipateMeetings()
{
    list<Meeting> meetingList = m_agendaService.listAllParticipateMeetings(m_userName);
    m_log.write(m_userName,"*non","listAllParticipateMeetings","succeed");
    cout<<"[list all participator meetings]"<<endl;
    printMeetings(meetingList);
}

void AgendaUI::queryMeetingByTitle()
{
    string meeting;
    cout<<"[query meetings] [title]"<<endl \
        <<"[query meetings] ";
    cin>>meeting;
    list<Meeting> meetingList = m_agendaService.meetingQuery(m_userName,meeting);
    printMeetings(meetingList);
    m_log.write(m_userName,meeting,"queryMeetingByTitle","succeed");
}

void AgendaUI::queryMeetingByTimeInterval()
{
    string startDate,endDate;
    cout<<"[query meeting] [start time(yyyy-mm-dd/hh:mm)] [end time(yyyy-mm-dd/hh:mm)]"<<endl \
        <<"[query meeting] ";
    cin>>startDate>>endDate;
    list<Meeting> meetingList;
    try
    {
        meetingList = m_agendaService.meetingQuery(m_userName,startDate,endDate);
        printMeetings(meetingList);
        m_log.write(m_userName,startDate + " " + endDate,"queryMeetingByTimeInterval","succeed");
    }
    catch(VaildtyCheckException e)
    {
        m_log.write(m_userName,startDate + " " + endDate,"queryMeetingByTimeInterval","fail");
        cout<<"[query meeting] error! "<<e.getObj()<<" is invaild"<<endl;
    }
}

void AgendaUI::deleteMeetingByTitle()
{
    string title;
    cout<<"[delete meeting] [title]"<<endl \ 
        <<"[delete meeting] ";
    cin>>title;
    cout<<"[delete meeting] are you sure to delete this meeting? [y/n]"<<endl;
    cout<<"[delete meeting] ";
    char c;
    cin>>c;
    if(c == 'y')
    {
        if(m_agendaService.deleteMeeting(m_userName,title) == true)
        {
            m_log.write(m_userName,title,"deleteMeetingByTitle","succeed");
            cout<<"[delete meeting] succeed!"<<endl;
        }
        else
        {
            m_log.write(m_userName,title,"deleteMeetingByTitle","fail");
            cout<<"[delete meeting] delete meeting failed!"<<endl;
        }
    }
    else
    {
        m_log.write(m_userName,title,"deleteMeetingByTitle","fail");
        cout<<"[delete meeting] delete meeting failed!"<<endl;
    }
}

void AgendaUI::deleteAllMeetings()
{
    cout<<"[delete all meetings] are you sure to delete all meetings? [y/n]"<<endl;
    cout<<"[delete all meetings] ";
    char c;
    cin>>c;
    if(c == 'y')
    {
        m_agendaService.deleteAllMeetings(m_userName);
        cout<<"[delete all meetings] succeed!"<<endl;
        m_log.write(m_userName,"*non","deleteAllMeetings","succeed");
    }
    else
    {
        cout<<"[delete all meetings] fail to delete!"<<endl;
        m_log.write(m_userName,"*non","deleteAllMeetings","fail");
    }
}

void AgendaUI::printMeetings(list<Meeting> t_meetings)
{
    if(t_meetings.size() == 0)
    {
        cout<<"[no meeting]"<<endl;
        return;
    }
    cout<<left<<setw(SPACE_)<<"title"<<setw(SPACE_)<<"sponsor"<<setw(SPACE_)<<"start time"<<setw(SPACE_)<<"end time"<<setw(SPACE_)<<"participators"<<endl;
    for(auto iter = t_meetings.begin(); iter != t_meetings.end(); iter++)
    {
        cout<<left<<setw(SPACE_)<<iter->getTitle()
            <<setw(SPACE_)<<iter->getSponsor()
            <<setw(SPACE_)<<Date::dateToString(iter->getStartDate())
            <<setw(SPACE_)<<Date::dateToString(iter->getEndDate());
        vector<string> part = iter->getParticipator();
        for(auto jter = part.begin(); jter != part.end(); jter++)
        {
            cout<<*jter;
            if(jter != part.end()-1)
            {
                cout<<",";
            }
        }
        cout<<endl;
    }
}