#ifndef AGENDASERVICE_H
#define AGENDASERVICE_H

#include <list>
#include <string>
#include "Storage.hpp"

class AgendaService {
 public:
  /**
   * constructor
   */
  AgendaService();

  /**
   * destructor
   */
  ~AgendaService();

  /**
   * check if the username match password
   * @param userName the username want to login
   * @param password the password user enter
   * @return if success, true will be returned
   */
  bool userLogIn(const std::string &userName, const std::string &password);

  /**
   * regist a user
   * @param userName new user's username
   * @param password new user's password
   * @param email new user's email
   * @param phone new user's phone
   * @return if success, true will be returned
   */
  bool userRegister(const std::string &userName, const std::string &password,
                    const std::string &email, const std::string &phone);

  /**
   * delete a user
   * @param userName user's username
   * @param password user's password
   * @return if success, true will be returned
   */
  bool deleteUser(const std::string &userName, const std::string &password);

  /**
   * list all users from storage
   * @return a user list result
   */
  std::list<User> listAllUsers(void) const;

  /**
   * create a meeting
   * @param userName the sponsor's userName
   * @param title the meeting's title
   * @param participator the meeting's participator
   * @param startData the meeting's start date
   * @param endData the meeting's end date
   * @return if success, true will be returned
   */
  bool createMeeting(const std::string &userName, const std::string &title,
                     const std::string &startDate, const std::string &endDate,
                     const std::vector<std::string> &participator);

  /**
   * add a participator to a meeting
   * @param userName the sponsor's userName
   * @param title the meeting's title
   * @param participator the meeting's participator
   * @return if success, true will be returned
   */
  bool addMeetingParticipator(const std::string &userName,
                              const std::string &title,
                              const std::string &participator);

  /**
   * remove a participator from a meeting
   * @param userName the sponsor's userName
   * @param title the meeting's title
   * @param participator the meeting's participator
   * @return if success, true will be returned
   */
  bool removeMeetingParticipator(const std::string &userName,
                                 const std::string &title,
                                 const std::string &participator);

  /**
   * quit from a meeting
   * @param userName the current userName. need to be the participator (a sponsor can not quit his/her meeting)
   * @param title the meeting's title
   * @return if success, true will be returned
   */
  bool quitMeeting(const std::string &userName, const std::string &title);

  /**
   * search a meeting by username and title
   * @param userName as a sponsor OR a participator
   * @param title the meeting's title
   * @return a meeting list result
   */
  std::list<Meeting> meetingQuery(const std::string &userName,
                                  const std::string &title) const;
  /**
   * search a meeting by username, time interval
   * @param userName as a sponsor OR a participator
   * @param startDate time interval's start date
   * @param endDate time interval's end date
   * @return a meeting list result
   */
  std::list<Meeting> meetingQuery(const std::string &userName,
                                  const std::string &startDate,
                                  const std::string &endDate) const;

  /**
   * list all meetings the user take part in
   * @param userName user's username
   * @return a meeting list result
   */
  std::list<Meeting> listAllMeetings(const std::string &userName) const;

  /**
   * list all meetings the user sponsor
   * @param userName user's username
   * @return a meeting list result
   */
  std::list<Meeting> listAllSponsorMeetings(const std::string &userName) const;

  /**
   * list all meetings the user take part in and sponsor by other
   * @param userName user's username
   * @return a meeting list result
   */
  std::list<Meeting> listAllParticipateMeetings(
      const std::string &userName) const;

  /**
   * delete a meeting by title and its sponsor
   * @param userName sponsor's username
   * @param title meeting's title
   * @return if success, true will be returned
   */
  bool deleteMeeting(const std::string &userName, const std::string &title);

  /**
   * delete all meetings by sponsor
   * @param userName sponsor's username
   * @return if success, true will be returned
   */
  bool deleteAllMeetings(const std::string &userName);

  /**
   * start Agenda service and connect to storage
   */
  void startAgenda(void);

  /**
   * quit Agenda service
   */
  void quitAgenda(void);

 private:
  std::shared_ptr<Storage> m_storage;
};

#endif
