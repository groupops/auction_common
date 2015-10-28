package com.epam.training.auction.common;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 28.10.15.
 */
public class UserTransferObjectTest {
    @Test
    public void checkIfTwoEqualUsersAreEqual(){
        UserTransferObject u1 = new UserTransferObject(1, "username", "pass");
        UserTransferObject u2 = new UserTransferObject(1, "username", "pass");
        assertEquals("Two users that should be equal are not equal", u1, u2);
    }
}
