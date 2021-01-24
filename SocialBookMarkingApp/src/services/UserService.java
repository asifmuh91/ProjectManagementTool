package services;

import dao.BookmarkDao;
import dao.UserDao;
import datastore.DataStore;
import entities.BookMark;
import entities.User;

public class UserService {
    private UserService(){

    }
    private static volatile UserService userService = null;

    public static UserService getInstance(){
        if(userService==null){
            synchronized (UserService.class){
                if(userService == null){
                    userService = new UserService();
                }
            }
        }
        return userService;
    }

    public User createUser(long id, String email, String password, String firstName, String lastName, String gender, String userType){
        return new User(id, email,password,firstName,lastName,gender,userType);
    }

    public User[] getUsers(){
        return UserDao.getUsers();
    }

}
