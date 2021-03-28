#ifndef USER_H
#define USER_H

#include <initializer_list>
#include <string>
class User {
 public:
  /**
  * @brief the default constructor
  */
  User() = default;

  /**
  * constructor with arguments
  */
  User(const std::string &t_userName, const std::string &t_userPassword,
       const std::string &t_userEmail, const std::string &t_userPhone);

  /**
  * @brief copy constructor
  */
  User(const User &t_user);

  /**
  * @brief get the name of the user
  * @return   return a string indicate the name of the user
  */
  std::string getName() const;

  /**
  * @brief set the name of the user
  * @param   a string indicate the new name of the user
  */
  void setName(const std::string &t_name);

  /**
  * @brief get the password of the user
  * @return   return a string indicate the password of the user
  */
  std::string getPassword() const;

  /**
  * @brief set the password of the user
  * @param   a string indicate the new password of the user
  */
  void setPassword(const std::string &t_password);

  /**
  * @brief get the email of the user
  * @return   return a string indicate the email of the user
  */
  std::string getEmail() const;

  /**
  * @brief set the email of the user
  * @param   a string indicate the new email of the user
  */
  void setEmail(const std::string &t_email);

  /**
  * @brief get the phone of the user
  * @return   return a string indicate the phone of the user
  */
  std::string getPhone() const;

  /**
  * @brief set the phone of the user
  * @param   a string indicate the new phone of the user
  */
  void setPhone(const std::string &t_phone);

 private:
  std::string m_name;
  std::string m_password;
  std::string m_email;
  std::string m_phone;
};

#endif
