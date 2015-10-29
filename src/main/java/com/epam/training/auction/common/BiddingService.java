package com.epam.training.auction.common;

import java.util.Optional;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 29.10.15.
 */
public interface BiddingService {

    Optional<UserBid> getMaxBid(long auctionId);

    void bid(long auctionId, double bidPrice, long userId);

}
