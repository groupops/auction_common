package com.epam.training.auction.service;

import com.epam.training.auction.common.UserTransferObject;

public interface UserService {
    UserTransferObject getUserByName(String username);
    void addUser(UserTransferObject user);
}
