#include"../include/Log.hpp"


bool Log::write(string userName,string userInput,string functionName,string result) const
{
    time_t t;
    time(&t);
    char tmp[64];
    strftime(tmp,sizeof(tmp),"%Y-%m-%D %H:%M:%S",localtime(&t));

    ofstream log("tmp/log.txt",ios::app);
    if(!log.is_open())
    {
        cout<<endl<<"[INNER ERROR] FAILED TO OPEN LOG.TXT!"<<endl;
        return false;
    }
    Log::index++;
    log << Log::index <<". " \
        << "[user]:<" << userName << ">" \
        << "\t[input]:<" << userInput << ">" \
        << "\t[result]:<" << result << " to run " \
        << "fuction call in src/AgendaUI.cpp: " << functionName << ">" \
        << "\t[time]:" << tmp <<endl;
    log.close();
    return true;
}