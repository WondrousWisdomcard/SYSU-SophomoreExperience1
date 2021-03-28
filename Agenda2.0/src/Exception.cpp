#include"../include/Exception.hpp"
#include<string.h>

string Exception::getObj() const
{
    return obj;
}
void Exception::setObj(string t)
{
    obj = t;
}

LimitedAuthorityException::LimitedAuthorityException(const string t)
{
    setObj(t);
}

AlreadyExistedException::AlreadyExistedException(const string t)
{
    setObj(t);
}

VaildtyCheckException::VaildtyCheckException(const string t)
{
    setObj(t);
}

HaveNotExistedException::HaveNotExistedException(const string t)
{
    setObj(t);
}

UserNoAvailableException::UserNoAvailableException(const string t)
{
    setObj(t);
}