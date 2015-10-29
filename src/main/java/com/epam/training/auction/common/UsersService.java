package com.epam.training.auction.common;

import java.util.Optional;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 29.10.15.
 */
public interface UsersService {
    void addUser(UserTransferObject user);

    Optional<UserTransferObject> getUserByName(String userName);

    Optional<UserTransferObject> getUserById(long id);
}