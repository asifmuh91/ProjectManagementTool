package dao;

import datastore.DataStore;
import entities.User;

public class UserDao {
    public static User[] getUsers(){
        return DataStore.getUsers();
    }
}
