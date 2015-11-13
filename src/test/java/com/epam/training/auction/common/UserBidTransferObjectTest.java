package com.epam.training.auction.common;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 30.10.15.
 */
public class UserBidTransferObjectTest {

    @Test
    public void testEquality(){
        UserTransferObject user = new UserTransferObject("user", "pass");
        long bid = 11;
        long auctionId = 123;
        UserBidTransferObject target = new UserBidTransferObject(user, auctionId, bid);

        assertEquals("User is not set correctly", user, target.getUser());
        assertTrue("Bid is not set correctly", bid == target.getBid());
        assertTrue("Auction id is not set correctly", auctionId == target.getAuctionId());
    }
}
