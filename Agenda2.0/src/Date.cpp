
////// my code 

#include<iostream>
#include"../include/Date.hpp"
using namespace std;

Date::Date()
{
    m_year = m_month = m_day = m_hour = m_minute = 0; 
}

Date::Date(int t_year, int t_month, int t_day, int t_hour, int t_minute)
{
    m_year = t_year;
    m_month = t_month;
    m_day = t_day;
    m_hour = t_hour;
    m_minute = t_minute;
}

Date::Date(const std::string &dateString)
{
    Date t = stringToDate(dateString);
    m_year = t.m_year;
    m_month = t.m_month;
    m_day = t.m_day;
    m_hour = t.m_hour;
    m_minute = t.m_minute;
}

int Date::getYear(void) const
{
    return m_year;
}
void Date::setYear(const int t_year)
{
    m_year = t_year;
}


int Date::getMonth(void) const
{
    return m_month;
}
void Date::setMonth(const int t_month)
{
    m_month = t_month;
}


int Date::getDay(void) const
{
    return m_day;
}
void Date::setDay(const int t_day)
{
    m_day = t_day;
}

int Date::getHour(void) const
{
    return m_hour;
}
void Date::setHour(const int t_hour)
{
    m_hour = t_hour;
}

int Date::getMinute(void) const
{
    return m_minute;
}
void Date::setMinute(const int t_minute)
{
    m_minute = t_minute;
}

bool Date::isValid(const Date &t_date)
{
    if(t_date.m_year < 1000 || t_date.m_year > 9999 || t_date.m_day < 1)
    {
        return false;
    }

    switch(t_date.m_month)
    {
        case 4: case 6: case 9: case 11:
        if(t_date.m_day > 30)
        {
            return false;
        }
        break;

        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
        if(t_date.m_day > 31)
        {
            return false;
        }
        break;

        case 2:
        if(t_date.m_year % 400 == 0 || t_date.m_year % 4 == 0 && t_date.m_year % 100 != 0)
        {
            if(t_date.m_day > 29)
            {
                return false;
            }
        }
        else
        {
            if(t_date.m_day > 28)
            {
                return false;
            }
        }
        break;

        default:
            return false;
    }

    if(t_date.m_hour > 23 || t_date.m_hour < 0 || t_date.m_minute > 59 || t_date.m_minute < 0)
    {
        return false;
    }

    return true;
}

bool isNum(const char c)
{
    return (c >= '0' && c <= '9');
}

Date Date::stringToDate(const std::string &t_dateString)
{
    if(t_dateString.length()== 16 && isNum(t_dateString[0]) && isNum(t_dateString[1])
        && isNum(t_dateString[2]) && isNum(t_dateString[3])
        && isNum(t_dateString[5]) && isNum(t_dateString[6]) && isNum(t_dateString[8])
        && isNum(t_dateString[9]) && isNum(t_dateString[11]) && isNum(t_dateString[12])
        && isNum(t_dateString[14]) && isNum(t_dateString[15]) && t_dateString[4] == '-'
        && t_dateString[7] == '-' && t_dateString[10] == '/' && t_dateString[13] == ':')
    {
        int year = 1000*(t_dateString[0]-'0') + 100*(t_dateString[1]-'0') + 10*(t_dateString[2]-'0') + (t_dateString[3]-'0');
        int month = 10*(t_dateString[5]-'0') + (t_dateString[6]-'0');
        int day = 10*(t_dateString[8]-'0') + (t_dateString[9]-'0');
        int hour = 10*(t_dateString[11]-'0') + (t_dateString[12]-'0');
        int minute = 10*(t_dateString[14]-'0') + (t_dateString[15]-'0');
        Date t(year,month,day,hour,minute);
        
        return t;
    }
    else
    {
        Date t;
        return t;
    }
} 

string Date::dateToString(const Date &t_date)
{
    if(!Date::isValid(t_date))
    {
        return "0000-00-00/00:00";
    }
    else
    {
        string t;
        string year;
        int y = t_date.getYear();
        int l = 1000;
        for(int i = 0; i < 4; i++)
        {
            year[i] = y / l + '0';
            y = y % l;
            l = l / 10;
        }
        t = t + year[0] + year[1] + year[2] + year[3];
        t += '-';

        string month;
        month[0] = t_date.getMonth()/10 + '0';
        month[1] = t_date.getMonth()%10 + '0';
        t = t + month[0] + month[1];
        t += '-';

        string day;
        day[0] = t_date.getDay()/10 + '0';
        day[1] = t_date.getDay()%10 + '0';
        t = t + day[0] + day[1];
        t += '/';

        string hour;
        hour[0] = t_date.getHour()/10 + '0';
        hour[1] = t_date.getHour()%10 + '0';
        t = t + hour[0] + hour[1];
        t += ':';

        string minute;
        minute[0] = t_date.getMinute()/10 + '0';
        minute[1] = t_date.getMinute()%10 + '0';
        t = t + minute[0] + minute[1];
 
        return t;
    }
}

Date& Date::operator=(const Date &t)
{
    m_year = t.m_year;
    m_month = t.m_month;
    m_day = t.m_day;
    m_hour = t.m_hour;
    m_minute = t.m_minute;
    return *this;
}

bool Date::operator==(const Date &t) const
{
    return (m_year == t.m_year && m_month == t.m_month && m_day == t.m_day && m_hour == t.m_hour && m_minute == t.m_minute);
}

bool Date::operator>(const Date &t_date) const
{
    if(m_year > t_date.m_year) return true;
    else if(m_year < t_date.m_year) return false;
    else
    {
        if(m_month > t_date.m_month) return true;
        else if(m_month < t_date.m_month) return false;
        else
        {
            if(m_day > t_date.m_day) return true;
            else if(m_day < t_date.m_day) return false;
            else
            {
                if(m_hour > t_date.m_hour) return true;
                else if(m_hour < t_date.m_hour) return false;
                else
                {
                    if(m_minute > t_date.m_minute) return true;
                    else if(m_minute < t_date.m_minute) return false;
                    else
                    {
                        return false;
                    }
                }
            }
        }
    }
}

bool Date::operator<(const Date &t_date) const
{
    return (!(*this >= t_date));
}

bool Date::operator>=(const Date &t_date) const
{
    return ((*this > t_date) || (*this == t_date));
}

bool Date::operator<=(const Date &t_date) const
{
    return (!(*this > t_date));
}