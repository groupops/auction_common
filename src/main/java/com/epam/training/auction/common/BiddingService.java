package com.epam.training.auction.common;

import java.io.Serializable;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 29.10.15.
 */
public interface BiddingService extends Serializable {

    UserBidTransferObject getMaxBid(long auctionId);

    void bid(long auctionId, long bidPrice, long userId) throws BiddingRaceException;

}
