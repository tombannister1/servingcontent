package com.studios519.service;
import com.studios519.model.User;
/**
 * Created by tomba on 15/03/2017.
 */
public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}