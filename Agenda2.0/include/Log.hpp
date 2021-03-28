#include<iostream>
#include<ctime>
#include<fstream>
using namespace std;

#ifndef LOG_HPP
#define LOG_HPP

class Log
{
    public:
    bool write(string userName, string userInput, string functionName, string result)  const;

    static int index;
};

#endif