package com.epam.training.auction.common;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 28.10.15.
 */
public class AuctionTransferObjectTest {

    private static final long ID = 1;
    private static final String AUCTION_TITLE = "title";

    @Test
    public void checkIfBuilderBuildsValidAuction(){
        UserTransferObject seller = new UserTransferObject(1, "seller", "pass");

        AuctionTransferObject target = AuctionTransferObject.getBuilder(AUCTION_TITLE, seller).setId(ID).build();
        assertEquals("Id of auction was not set correctly", ID, target.getId());
        assertEquals("Title of auction was not set correctly", AUCTION_TITLE, target.getTitle());
        assertEquals("Seller of auction was not set correctly", seller, target.getSeller());
    }
}
