package com.example.ForumServer.service;

import com.example.ForumServer.pojo.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public boolean login(User user);
}
