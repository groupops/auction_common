package com.epam.training.auction.common;

import java.io.Serializable;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 29.10.15.
 */
public interface UsersService extends Serializable {
    /**
     * @return id of created user
     */
    Long addUser(UserTransferObject user);

    UserTransferObject getUserByName(String userName);

    UserTransferObject getUserById(long id);
}