package com.kahlua17.momo.domain.user.service;

import com.kahlua17.momo.domain.user.entity.User;
import com.kahlua17.momo.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String uuid, String nickname) {
        User user = new User();
        user.setUuid(uuid);
        user.setNickname(nickname);
        return userRepository.save(user);
    }
}
