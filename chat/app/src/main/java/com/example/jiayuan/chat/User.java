package com.example.jiayuan.chat;

/**
 * Created by jiayuan on 2016/08/02.
 */
public class User {
   String name;
   String password;
   String mail;
   String sex;
   String age;
   String ID;

  public void setName(String name){
     this.name=name;
  }
   public void setPassword(String password){
       this.password=password;
    }
   public void setMail(String mail){
      this.mail=mail;
    }
   public String getName(){
        return ID;
   }
    public String getPassword(){
        return password;
    }
    public String getMail(){
        return mail;

    }
    public void setSex(String sex){
        this.sex=sex;
    }
    public String getSex(){
        return sex;
    }
    public void setAge(String age){
        this.age=age;
    }
    public String getAge(){
        return age;
    }

}
