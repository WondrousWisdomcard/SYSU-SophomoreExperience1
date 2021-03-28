#include<iostream>
#include"../include/AgendaService.hpp"
#include"../include/Exception.hpp"
using namespace std;

AgendaService::AgendaService()
{
    startAgenda();
}

AgendaService::~AgendaService()
{
    quitAgenda();
}

void AgendaService::startAgenda(void)
{
    m_storage = Storage::getInstance();
}

void AgendaService::quitAgenda(void)
{
    m_storage->sync();
}

bool AgendaService::userLogIn(const std::string &userName, const std::string &password)
{
    auto filter = [userName,password](const User &user)
    {
        if(user.getName() == userName && user.getPassword() == password)
        return true;
        else
        return false;
    };
    if(m_storage->queryUser(filter).size() > 0)
    return true;
    else
    return false;
}

bool AgendaService::userRegister(const std::string &userName, const std::string &password,const std::string &email, const std::string &phone)
{   
    bool sign = true;
    for(auto i = userName.begin(); i!= userName.end(); i++)
    {
        if(*i == '\"' || *i == ',' || *i == '&')
        {
            throw(VaildtyCheckException("user name: " + userName));
            sign = false;
        }
    }
    for(auto i = password.begin(); i!= password.end(); i++)
    {
        if(*i == '\"' || *i == ',' || *i == '&')
        {
            throw(VaildtyCheckException("password: " + password));
            sign = false;
        }
    }
    for(auto i = email.begin(); i!= email.end(); i++)
    {
        if(*i == '\"' || *i == ',' || *i == '&')
        {
            throw(VaildtyCheckException("email: " + email));
            sign = false;
        }
    }
    for(auto i = phone.begin(); i!= phone.end(); i++)
    {
        if(*i == '\"' || *i == ',' || *i == '&')
        {
            throw(VaildtyCheckException("phone: " + phone));
            sign = false;
        }
    }
    if(sign == true)
    {
        User newUser(userName,password,email,phone);
        auto filter = [userName](const User &user)
        {
            if(user.getName() == userName)
                return true;
            else
                return false;
        };
        if(m_storage->queryUser(filter).size() == 0)
        {
            m_storage->createUser(newUser);
            return true;
        }
        else 
            return false;
    }
    else return false;
}

bool AgendaService::deleteUser(const std::string &userName, const std::string &password)
{
    auto filter = [userName,password](const User &user)
    {
        if(user.getName() == userName && user.getPassword() == password)
        return true;
        else
        return false;
    };
    if(m_storage->deleteUser(filter) > 0)
    {
        list<Meeting> ParticipatorList = listAllParticipateMeetings(userName);
        for(auto iter = ParticipatorList.begin(); iter != ParticipatorList.end(); iter++)
        {
            removeMeetingParticipator(iter->getSponsor(),iter->getTitle(),userName);
            if((iter->getParticipator()).size() == 0)
            {
                deleteMeeting(iter->getSponsor(),iter->getTitle());
            }
        }
        deleteAllMeetings(userName);
        return true;
    }
    else
    {
        return false;
    }
}

std::list<User> AgendaService::listAllUsers(void) const
{
    auto filter = [](const User &users)
    {
        return true;
    };
    return m_storage->queryUser(filter);
}

bool AgendaService::createMeeting(const std::string &userName, const std::string &title,
                     const std::string &startDate, const std::string &endDate,
                     const std::vector<std::string> &participator)
{
    // 1. only title
    auto filter = [title](const Meeting &meeting)
    {
        if(meeting.getTitle() == title)
            return true;
        else
            return false;
    };
    if(m_storage->queryMeeting(filter).size() != 0)
    {
        throw(AlreadyExistedException("Meeting: "+title));
        return false;
    }

    // 2. validity of date
    Date startD(startDate);
    Date endD(endDate);
    if(!Date::isValid(startD) || !Date::isValid(endD) || startD >= endD)
    {
        throw(VaildtyCheckException("Date"));
        return false;
    } 

    // 3. registered sponsor
    auto filter1 = [userName](const User &user)
    {
        if(user.getName() == userName)
        {
            return true;
        }
        else
        {
            return false;
        }  
    };
    if(m_storage->queryUser(filter1).size() == 0)
    {
        return false;
    }

    // 4. available sponsor
    Date start(startDate),end(endDate);
    auto filter3 = [userName,start,end](const Meeting &meeting)
    {
        if( (start == meeting.getEndDate() && start > meeting.getStartDate()) || (end == meeting.getStartDate() && end < meeting.getEndDate() ))
        {
            return false;
        }
        if( (meeting.getSponsor() == userName || meeting.isParticipator(userName)) 
        && ( ( start <= meeting.getStartDate() && end >= meeting.getStartDate()) ||
             ( start <= meeting.getEndDate() && end >= meeting.getEndDate()) ||
             ( start >= meeting.getStartDate() && end <= meeting.getEndDate() )))
             return true;
        else
            return false;
    };
    list<Meeting> result = m_storage->queryMeeting(filter3);
    if(result.size() != 0)
    {
        throw(UserNoAvailableException("you: " + userName));
        return false;
    }

    // 5. registered participators
    for(auto iter = participator.begin(); iter != participator.end(); iter++)
    {
        string participatorName = *iter;
        auto filter2 = [participatorName](const User &user)
        {
            if(user.getName() == participatorName)
            {
                return true;
            }
            else
            {
                return false;
            }  
        };
        if(m_storage->queryUser(filter2).size() == 0)
        {
            throw(HaveNotExistedException("participator: " + *iter));
            return false;
        }
    }

    // 6. available participators
    for(auto iter = participator.begin(); iter != participator.end(); iter++)
    {
        auto filter4 = [iter,start,end](const Meeting &meeting)
        {
            if( (start == meeting.getEndDate() && start > meeting.getStartDate()) || (end == meeting.getStartDate() && end < meeting.getEndDate() ))
            {
                return false;
            }
            if( (meeting.getSponsor() == *iter|| meeting.isParticipator(*iter)) 
            && ( ( start <= meeting.getStartDate() && end >= meeting.getStartDate()) ||
                ( start <= meeting.getEndDate() && end >= meeting.getEndDate()) ||
                ( start >= meeting.getStartDate() && end <= meeting.getEndDate() )))
                return true;
            else
                return false;
        };
        list<Meeting> result = m_storage->queryMeeting(filter4);
        if(result.size() != 0)
        {
            throw(UserNoAvailableException("Participator: " + *iter));
            return false;
        }
    }

    // 7. participator as sponsor
    for(auto iter = participator.begin(); iter != participator.end(); iter++)
    {
        if(*iter == userName)
        {
            throw(AlreadyExistedException("You (as a sponsor)"));
            return false;
        }
    }

    // 8. same aprticipators
    for(auto iter = participator.begin(); iter != participator.end(); iter++)
    {
        int count = 0;
        for(auto jter = participator.begin(); jter != participator.end(); jter++)
        {
            if(*iter == *jter)
            {
                count++;
            }
        }
        if(count > 1)
        {
            throw(AlreadyExistedException("Participator: "+ *iter));
            return false;
        }
    }

    // 9. zero participator
    if(participator.size() == 0)
    {
        return false;
    }

    Meeting meeting(userName,participator,Date::stringToDate(startDate),Date::stringToDate(endDate),title);
    m_storage->createMeeting(meeting);
    return true;
}

bool AgendaService::addMeetingParticipator(const std::string &userName,
                              const std::string &title,
                              const std::string &participator)
{
    // 1. sponsor is also a participator
    if(userName == participator)
    {
        throw(AlreadyExistedException("You (as a sponsor)"));
        return false;
    }

    // 2. meeting exists
    auto filter = [userName,title](const Meeting &meeting)
    {
        if(meeting.getTitle() == title)
        {
            return true;
        }
        else
        {
            return false;
        }  
    };
    if(m_storage->queryMeeting(filter).size() == 0)
    {
        throw(HaveNotExistedException("Meeting: "+title));
        return false;
    }
    if(m_storage->queryMeeting(filter).begin()->getSponsor() != userName)
    {
        throw(LimitedAuthorityException("You: " + userName));
        return false;
    }

    // 3. registered participator
    auto filter1 = [participator](const User &user)
    {
        if(user.getName() == participator)
        return true;
        else
        {
            return false;
        } 
    };
    if(m_storage->queryUser(filter1).size() == 0)
    {
        throw(HaveNotExistedException("Participator: "+ participator));
        return false;
    }

    // 4. available participator
    Meeting theMeeting = m_storage->queryMeeting(filter).front();
    Date start = Date::dateToString(theMeeting.getStartDate());
    Date end = Date::dateToString(theMeeting.getEndDate());
    auto filter5 = [participator,start,end](const Meeting &meeting)
    {
        if( (start == meeting.getEndDate() && start > meeting.getStartDate()) || 
            (end == meeting.getStartDate() && end < meeting.getEndDate()) )
        return false;
        if( (meeting.getSponsor() == participator || meeting.isParticipator(participator)) \
        && ((start <= meeting.getStartDate() && end >= meeting.getStartDate()) || \
            (start <= meeting.getEndDate() && end >= meeting.getEndDate()) || \
            (start >= meeting.getStartDate() && end <= meeting.getEndDate() ) ) )
        return true;
        else
        return false;
    };
    list<Meeting> result = m_storage->queryMeeting(filter5);
    if(result.size() != 0)
    {
        throw(UserNoAvailableException("Participator: "+ participator));
        return false;
    }

    // 5. add
    auto switcher = [participator](Meeting &meeting)
    {
        meeting.addParticipator(participator);
    };
    if(m_storage->updateMeeting(filter, switcher) != 1)
    {
        return false;
    }
    else
    {
        return true;
    }
} 

bool AgendaService::removeMeetingParticipator(const std::string &userName,
                                 const std::string &title,
                                 const std::string &participator)
{
    // 1. participator exises
    auto filter = [userName,title,participator](const Meeting &meeting)
    {
        if(meeting.getTitle() == title)
        return true;
        else
        {
            return false;
        }
    };
    if(m_storage->queryMeeting(filter).size() == 0)
    {
        throw(HaveNotExistedException("Meeting: "+title));
        return false;
    }
    if(m_storage->queryMeeting(filter).begin()->getSponsor() != userName)
    {
        throw(LimitedAuthorityException("You"));
        return false;
    }
    if(m_storage->queryMeeting(filter).begin()->isParticipator(participator))
    {
        throw(HaveNotExistedException("Participator: "+participator));
        return false;
    }

    // 2. add successfully
    auto switcher = [participator](Meeting &meeting)
    {
        meeting.removeParticipator(participator);
    };
    if(m_storage->updateMeeting(filter, switcher) != 1)
    {
        return false;
    }

    // 3. remove empty meeting
    auto filter1 = [](const Meeting &meeting)
    {
        if(meeting.getParticipator().size() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    };
    m_storage->deleteMeeting(filter1);
    return true;
}

bool AgendaService::quitMeeting(const std::string &userName, const std::string &title)
{
    auto filter1 = [userName,title](const Meeting & meeting)
    {
        if(meeting.getTitle() == title)
        return true;
        else
        return false;
    };
    if(m_storage->queryMeeting(filter1).size() == 0)
    {
        throw(HaveNotExistedException("Meeting: " + title));
        return false;
    }
    auto filter = [userName,title](const Meeting & meeting)
    {
        if(meeting.getTitle() == title && meeting.isParticipator(userName))
        return true;
        else
        return false;
    };
    auto switcher = [userName](Meeting &meeting)
    {
        meeting.removeParticipator(userName);
    };
    if(m_storage->updateMeeting(filter, switcher) != 0)
    {
        auto filter1 = [](const Meeting & meeting)
        {
            if(meeting.getParticipator().size() == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        };
        m_storage->deleteMeeting(filter1);
        return true;
    }
    else
    {
        return false;
    }
}

std::list<Meeting> AgendaService::meetingQuery(const std::string &userName,
                                  const std::string &title) const
{
    auto filter = [userName,title](const Meeting &meeting)
    {
        if((meeting.getSponsor() == userName || meeting.isParticipator(userName)) && meeting.getTitle() == title)
        return true;
        else
        {
            return false;
        }
    };
    return m_storage->queryMeeting(filter);
}

std::list<Meeting> AgendaService::meetingQuery(const std::string &userName,
                                  const std::string &startDate,
                                  const std::string &endDate) const
{
    list<Meeting> result;
    result.clear();
    Date start(startDate),end(endDate);
    if(!Date::isValid(start) || !Date::isValid(end) || start > end)
    {
        throw(VaildtyCheckException("Date"));
        return result;
    }
    auto filter = [userName,start,end](const Meeting &meeting)
    {
        if( (meeting.getSponsor() == userName || meeting.isParticipator(userName)) \
        && ((start <= meeting.getStartDate() && end >= meeting.getStartDate()) || \
            (start <= meeting.getEndDate() && end >= meeting.getEndDate()) || \
            (start >= meeting.getStartDate() && end <= meeting.getEndDate() ) ) )
        return true;
        else
        return false;
    };
    return m_storage->queryMeeting(filter);
}

std::list<Meeting> AgendaService::listAllMeetings(const std::string &userName) const
{
    auto filter = [userName](const Meeting &meeting)
    {
        if(meeting.getSponsor() == userName || meeting.isParticipator(userName))
        {
            return true;
        }
        else
        {
            return false;
        }  
    };
    return m_storage->queryMeeting(filter);
}

std::list<Meeting> AgendaService::listAllSponsorMeetings(const std::string &userName) const
{
     auto filter = [userName](const Meeting &meeting)
    {
        if(meeting.getSponsor() == userName)
        {
            return true;
        }
        else
        {
            return false;
        }  
    };
    return m_storage->queryMeeting(filter);
}

std::list<Meeting> AgendaService::listAllParticipateMeetings(const std::string &userName) const
{
     auto filter = [userName](const Meeting &meeting)
    {
        if(meeting.isParticipator(userName))
        {
            return true;
        }
        else
        {
            return false;
        }  
    };
    return m_storage->queryMeeting(filter);
}

bool AgendaService::deleteMeeting(const std::string &userName, const std::string &title)
{
    auto filter1 = [userName,title](const Meeting &meeting)
    {
        if(meeting.getTitle() == title)
        {
            return true;
        }
        else
        {
            return false;
        }  
    };
    if(m_storage->queryMeeting(filter1).size() == 0)
    {
        throw(HaveNotExistedException("Meeting: "+title));
        return false;
    }
    auto filter = [userName,title](const Meeting &meeting)
    {
        if(meeting.getSponsor() == userName && meeting.getTitle() == title)
        {
            return true;
        }
        else
        {
            return false;
        }  
    };
    if(m_storage->deleteMeeting(filter) == 0)
    {
        throw(LimitedAuthorityException("You"));
        return false;
    }
    else
    {
        return true;
    }
}

bool AgendaService::deleteAllMeetings(const std::string &userName)
{
    auto filter = [userName](const Meeting &meeting)
    {
        if(meeting.getSponsor() == userName)
        {
            return true;
        }
        else
        {
            return false;
        }  
    };
    if(m_storage->deleteMeeting(filter) == 0)
    return false;
    else
    {
        return true;
    }
}