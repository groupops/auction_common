package com.epam.training.auction.common;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 28.10.15.
 */
public final class BiddingRaceException extends RuntimeException {
    private double otherBid;
    private UserTransferObject otherBidder;

    public BiddingRaceException(UserTransferObject otherBidder, double otherBid){
        super("Sorry your bid was not accepted because some one else had an equal or higher bid than you. Please try again with a higher bid.");
        this.otherBid = otherBid;
    }

    public double getOtherBid(){return otherBid;}

    public UserTransferObject getOtherBidder(){
        return otherBidder;
    }

}
