package com.epam.training.auction.common;

import java.io.Serializable;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 29.10.15.
 */
public final class UserBidTransferObject implements Serializable {
    private UserTransferObject user;
    private long bid;
    private long auctionId;

    public UserBidTransferObject(UserTransferObject user, long auctionId, long bid){
        this.user = user;
        this.auctionId = auctionId;
        this.bid = bid;
    }

    public long getBid(){
        return bid;
    }

    public long getAuctionId() {
        return auctionId;
    }

    public UserTransferObject getUser(){
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBidTransferObject that = (UserBidTransferObject) o;

        if (bid != that.bid) return false;
        return !(user != null ? !user.equals(that.user) : that.user != null);

    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (int) (bid ^ (bid >>> 32));
        return result;
    }

    @Override
    public String toString(){
        return String.format("UserBidTransferObject(%s, %d)", getUser().getUsername(), getBid());
    }
}