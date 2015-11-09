package com.epam.training.auction.common;

import java.io.Serializable;
import java.util.Optional;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 29.10.15.
 */
public interface UsersService extends Serializable {
    /**
     * @return id of created user
     */
    Long addUser(UserTransferObject user);

    Optional<UserTransferObject> getUserByName(String userName);

    Optional<UserTransferObject> getUserById(long id);
}