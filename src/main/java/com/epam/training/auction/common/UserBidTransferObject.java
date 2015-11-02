package com.epam.training.auction.common;

import java.io.Serializable;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 29.10.15.
 */
public final class UserBidTransferObject implements Serializable {
    private UserTransferObject user;
    private long bid;

    public UserBidTransferObject(UserTransferObject user, long bid){
        this.user = user;
        this.bid = bid;
    }

    public long getBid(){
        return bid;
    }

    public UserTransferObject getUser(){
        return user;
    }

    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if (!(other instanceof UserBidTransferObject)) return false;
        UserBidTransferObject otherUserBidTransferObject = (UserBidTransferObject)other;
        if (this.getBid() != otherUserBidTransferObject.getBid()) return false;
        if (!this.getUser().equals(otherUserBidTransferObject.getUser())) return false;
        return true;
    }

    @Override
    public int hashCode(){
        int code = 17;
        code += 19 * Double.valueOf(getBid()).hashCode();
        code += 23 * getUser().hashCode();
        return code;
    }

    @Override
    public String toString(){
        return String.format("UserBidTransferObject(%s, %d)", getUser().getUsername(), getBid());
    }
}