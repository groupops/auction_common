package com.epam.training.auction.common;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 29.10.15.
 */
public interface AuctionsService extends Serializable {

    List<AuctionTransferObject> getActiveAuctions();

    List<AuctionTransferObject> getArchivedAuctions();

    void addAuction(AuctionTransferObject auction);

    Optional<AuctionTransferObject> getAuctionById(long auctionId);

}
