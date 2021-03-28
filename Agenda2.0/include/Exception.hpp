#ifndef EXCEPTION_HPP
#define EXCEPTION_HPP

#include<iostream>
#include<string>
using namespace std;

class Exception{
    public:
    string getObj() const;
    void setObj(string);
    private:
    string obj;
};

class LimitedAuthorityException:public Exception{
    public:
    LimitedAuthorityException(const string);
};

class AlreadyExistedException:public Exception{
    public:
    AlreadyExistedException(const string);
};

class VaildtyCheckException:public Exception{
    public:
    VaildtyCheckException(const string);
};

class HaveNotExistedException:public Exception{
    public:
    HaveNotExistedException(const string);
};

class UserNoAvailableException:public Exception{
    public:
    UserNoAvailableException(const string);
};

#endif