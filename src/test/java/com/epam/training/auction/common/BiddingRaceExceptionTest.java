package com.epam.training.auction.common;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 30.10.15.
 */
public class BiddingRaceExceptionTest {

    @Test
    public void checkExists(){
        UserTransferObject user = new UserTransferObject(1, "user", "pass");
        long otherBid = 10;
        BiddingRaceException target = new BiddingRaceException(user, otherBid);
        assertEquals("User was not set on the exception.", user, target.getOtherBidder());
        assertTrue("Other Bid was not sett on the exception.", otherBid == target.getOtherBid());
    }
}
