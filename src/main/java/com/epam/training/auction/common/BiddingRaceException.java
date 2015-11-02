package com.epam.training.auction.common;

import java.io.Serializable;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 28.10.15.
 */
public final class BiddingRaceException extends RuntimeException implements Serializable {
    private long otherBid;
    private UserTransferObject otherBidder;

    public BiddingRaceException(UserTransferObject otherBidder, long otherBid){
        super("Sorry your bid was not accepted because some one else had an equal or higher bid than you. Please try again with a higher bid.");
        this.otherBid = otherBid;
        this.otherBidder = otherBidder;
    }

    public long getOtherBid(){return otherBid;}

    public UserTransferObject getOtherBidder(){
        return otherBidder;
    }

}
