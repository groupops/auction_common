package com.epam.training.auction.common;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 30.10.15.
 */
public class UserBidTransferObjectTest {

    @Test
    public void testEquality(){
        UserTransferObject user = new UserTransferObject(1, "user", "pass");
        long bid = 11;
        UserBidTransferObject target = new UserBidTransferObject(user, bid);

        assertEquals("User is not set correctly", user, target.getUser());
        assertTrue("Bid is not set correctly", bid == target.getBid());
    }
}
