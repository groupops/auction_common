package com.epam.training.auction.common;

import org.junit.Test;

import java.time.LocalDateTime;

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
        String description = "Some Description";
        UserTransferObject winner = new UserTransferObject(2, "winner", "pass");
        double final_price = 10.0;
        boolean isActive = false;
        LocalDateTime createdAt = LocalDateTime.of(2015, 10, 30, 15, 3, 0);
        LocalDateTime updatedAt = LocalDateTime.of(2015, 10, 30, 15, 5, 0);

        AuctionTransferObject target = AuctionTransferObject.getBuilder(AUCTION_TITLE, seller)
                .setId(ID)
                .setDescription(description)
                .setWinner(winner)
                .setFinalPrice(final_price)
                .setIsActive(isActive)
                .setCreatedAt(createdAt)
                .setUpdatedAt(updatedAt)
                .build();

        assertEquals("Id of auction was not set correctly", ID, target.getId());
        assertEquals("Title of auction was not set correctly", AUCTION_TITLE, target.getTitle());
        assertEquals("Description of auction was not set correctly", description, target.getDescription());
        assertEquals("Seller of auction was not set correctly", seller, target.getSeller());
        assertEquals("Winner of auction was not set correctly", winner, target.getWinner());
        assertTrue("Final price of auction was not set correctly", final_price == target.getFinalPrice());
        assertEquals("IsActive of auction was not set correctly", isActive, target.isActive());
        assertEquals("CreatedAt of auction was not set correctly", createdAt, target.getCreatedAt());
        assertEquals("UpdatedAt of auction was not set correctly", updatedAt, target.getUpdatedAt());
    }

    @Test
    public void testEqualsMethodIfAllFieldsAreEqual(){
        UserTransferObject seller = new UserTransferObject(1, "seller", "pass");
        String description = "Some Description";
        UserTransferObject winner = new UserTransferObject(2, "winner", "pass");
        boolean isActive = false;
        LocalDateTime createdAt = LocalDateTime.of(2015, 10, 30, 15, 3, 0);
        LocalDateTime updatedAt = LocalDateTime.of(2015, 10, 30, 15, 5, 0);

        AuctionTransferObject auction_1 = AuctionTransferObject.getBuilder(AUCTION_TITLE, seller)
                .setId(ID)
                .setDescription(description)
                .setWinner(winner)
                .setIsActive(isActive)
                .setCreatedAt(createdAt)
                .setUpdatedAt(updatedAt)
                .build();
        AuctionTransferObject auction_2 = AuctionTransferObject.getBuilder(AUCTION_TITLE, seller)
                .setId(ID)
                .setDescription(description)
                .setWinner(winner)
                .setIsActive(isActive)
                .setCreatedAt(createdAt)
                .setUpdatedAt(updatedAt)
                .build();
        assertTrue("Equals method is not not correct", auction_1.equals(auction_2));
        assertTrue("Equals method is not not reflexive", auction_2.equals(auction_1));
    }

    @Test
    public void testEqualsMethodWithMinimalObjects(){
        UserTransferObject seller = new UserTransferObject(1, "seller", "pass");
        AuctionTransferObject auction_1 = AuctionTransferObject.getBuilder(AUCTION_TITLE, seller)
                .build();
        AuctionTransferObject auction_2 = AuctionTransferObject.getBuilder(AUCTION_TITLE, seller)
                .build();
        assertTrue("Equals method is not not correct", auction_1.equals(auction_2));
        assertTrue("Equals method is not not reflexive", auction_2.equals(auction_1));
    }


    @Test
    public void checkIfEqualObjectsHaveEqualHashCodes(){
        UserTransferObject seller = new UserTransferObject(1, "seller", "pass");
        String description = "Some Description";
        UserTransferObject winner = new UserTransferObject(2, "winner", "pass");
        boolean isActive = false;
        LocalDateTime createdAt = LocalDateTime.of(2015, 10, 30, 15, 3, 0);
        LocalDateTime updatedAt = LocalDateTime.of(2015, 10, 30, 15, 5, 0);

        AuctionTransferObject auction_1 = AuctionTransferObject.getBuilder(AUCTION_TITLE, seller)
                .setId(ID)
                .setDescription(description)
                .setWinner(winner)
                .setIsActive(isActive)
                .setCreatedAt(createdAt)
                .setUpdatedAt(updatedAt)
                .build();
        AuctionTransferObject auction_2 = AuctionTransferObject.getBuilder(AUCTION_TITLE, seller)
                .setId(ID)
                .setDescription(description)
                .setWinner(winner)
                .setIsActive(isActive)
                .setCreatedAt(createdAt)
                .setUpdatedAt(updatedAt)
                .build();
        assertEquals("Hash codes of equal objects are not equal", auction_1.hashCode(), auction_2.hashCode());
    }

    @Test
    public void checkIfUnEqualObjectsHaveDifferentHashCodes(){
        UserTransferObject seller = new UserTransferObject(1, "seller", "pass");
        String description = "Some Description";
        UserTransferObject winner = new UserTransferObject(2, "winner", "pass");
        boolean isActive = false;
        LocalDateTime createdAt = LocalDateTime.of(2015, 10, 30, 15, 3, 0);
        LocalDateTime updatedAt = LocalDateTime.of(2015, 10, 30, 15, 5, 0);

        AuctionTransferObject auction_1 = AuctionTransferObject.getBuilder(AUCTION_TITLE, seller)
                .setId(ID)
                .setDescription(description)
                .setWinner(winner)
                .setIsActive(isActive)
                .setCreatedAt(createdAt)
                .setUpdatedAt(updatedAt)
                .build();
        AuctionTransferObject auction_2 = AuctionTransferObject.getBuilder(AUCTION_TITLE, seller)
                .setId(ID)
                .setDescription(description)
                .setWinner(winner)
                .setIsActive(isActive)
                .setCreatedAt(createdAt)
                .setUpdatedAt(null)
                .build();
        assertNotEquals("Hash codes of unequal objects are equal when they should be different.", auction_1.hashCode(), auction_2.hashCode());
    }
}
