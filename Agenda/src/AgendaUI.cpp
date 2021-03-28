#include<iostream>
#include<string>
#include<iomanip>
#include"../include/AgendaUI.hpp"
using namespace std;
const int SPACE_ = 25;

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
        deleteUser();
        return false;
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
        if(m_agendaService.addMeetingParticipator(m_userName,title,partname) == true)
        {
            cout<<"[add participator] succeed!"<<endl;
        }
        else
        {
            cout<<"[add participator] error!"<<endl;
        }
        return true;
    }
    else if(t_operation == "rmp")
    {
        string title,partname;
        cout<<"[remove participator] [meeting title] [participator username]"<<endl \
            <<"[remove participator] ";
        cin>>title>>partname;
        if(m_agendaService.removeMeetingParticipator(m_userName,title,partname) == true)
        {
            cout<<"[remove participator] succeed!"<<endl;
        }
        else
        {
            cout<<"[remove participator] error!"<<endl;
        }
        return true;
    }
    else if(t_operation == "rqm")
    {
        string title;
        cout<<"[quit meeting] [meeting title]"<<endl \
            <<"[quit meeting] ";
        cin>>title;
        if(m_agendaService.quitMeeting(m_userName,title) == true)
        {
            cout<<"[quit meeting] succeed!"<<endl;
        }
        else
        {
            cout<<"[quit meeting] error!"<<endl;
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
        while(executeOperation(getOperation()) == true);
    }
    else
    {
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
    for(auto i = userName.begin(); i != userName.end(); i++)
    {
        if(*i == '\"' || *i == ',' || *i == '&')
        {
            cout<<"[register] fail! please check the validty of your username!"<<endl;
        }
    }
    for(auto i = passWord.begin(); i != passWord.end(); i++)
    {
        if(*i == '\"' || *i == ',')
        {
            cout<<"[register] fail! please check the validty of your password!"<<endl;
        }
    }
    for(auto i = phone.begin(); i != phone.end(); i++)
    {
        if(*i == '\"' || *i == ',')
        {
            cout<<"[register] fail! please check the validty of your phone!"<<endl;
        }
    }
    for(auto i = email.begin(); i != email.end(); i++)
    {
        if(*i == '\"' || *i == ',')
        {
            cout<<"[register] fail! please check the validty of your email!"<<endl;
        }
    }
    if(m_agendaService.userRegister(userName,passWord,email,phone) == true)
    {
        cout<<"[register] succeed!"<<endl;
        m_userName = userName;
        m_userPassword = passWord;
        while(executeOperation(getOperation()) == true);
    }
    else
    {
        cout<<"[register] failed! this username has been register!"<<endl;
    }
}

void AgendaUI::userLogOut()
{
    m_userName = "";
    m_userPassword = "";
    cout<<"[user log out] success!"<<endl;
}

void AgendaUI::quitAgenda()
{
    m_agendaService.quitAgenda();
    cout<<"[quit agenda] success!"<<endl;
}

void AgendaUI::deleteUser()
{
    if(m_agendaService.deleteUser(m_userName,m_userPassword) == true)
    {
        m_userName = "";
        m_userPassword = "";
        cout<<"[delete agenda account] success!"<<endl;
    }
    else
    {
        cout<<"[delete agenda account] fail!"<<endl;
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
}

void AgendaUI::createMeeting()
{
    int num;
    string title,startDate,endDate;
    vector<string> participators;
    participators.clear();
    cout<<"[create meeting] [the number of participators]"<<endl \
        <<"[create meeting] ";
    cin>>num;
    for(int i = 1; i <= num; i++)
    {
        string partname;
        cout<<"[create meeting] [please enter the participator "<<i<<" ]"<<endl \
            <<"[create meeting] ";
        cin >> partname;
        participators.push_back(partname);
    }
    cout<<"[create meeting] [title] [start time(yyyy-mm-dd/hh:mm)] [end time(yyyy-mm-dd/hh:mm)]"<<endl \
        <<"[create meeting] ";
    cin>>title>>startDate>>endDate;
    if(m_agendaService.createMeeting(m_userName,title,startDate,endDate,participators) == true)
    {
        cout<<"[create meeting] succeed!"<<endl;
    }
    else
    {
        cout<<"[create meeting] error!"<<endl;
    }
}

void AgendaUI::listAllMeetings()
{
    list<Meeting> meetingList = m_agendaService.listAllMeetings(m_userName);
    cout<<"[list all meetings]"<<endl;
    printMeetings(meetingList);
}

void AgendaUI::listAllSponsorMeetings()
{
    list<Meeting> meetingList = m_agendaService.listAllSponsorMeetings(m_userName);
    cout<<"[list all sponsor meetings]"<<endl;
    printMeetings(meetingList);
}

void AgendaUI::listAllParticipateMeetings()
{
    list<Meeting> meetingList = m_agendaService.listAllParticipateMeetings(m_userName);
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
}

void AgendaUI::queryMeetingByTimeInterval()
{
    string startDate,endDate;
    cout<<"[query meeting] [start time(yyyy-mm-dd/hh:mm)] [end time(yyyy-mm-dd/hh:mm)]"<<endl \
        <<"[query meeting] ";
    cin>>startDate>>endDate;
    list<Meeting> meetingList = m_agendaService.meetingQuery(m_userName,startDate,endDate);
    printMeetings(meetingList);
}

void AgendaUI::deleteMeetingByTitle()
{
    string title;
    cout<<"[delete meeting] [title]"<<endl \ 
        <<"[delete meeting] ";
    cin>>title;
    if(m_agendaService.deleteMeeting(m_userName,title) == true)
    {
        cout<<"[delete meeting] succeed!"<<endl;
    }
    else
    {
        cout<<"[delete meeting] delete meeting failed!"<<endl;
    }
}

void AgendaUI::deleteAllMeetings()
{
    m_agendaService.deleteAllMeetings(m_userName);
    cout<<"[delete all meetings] succeed!"<<endl;
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