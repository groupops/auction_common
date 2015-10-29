package com.epam.training.auction.common;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 29.10.15.
 */
public final class UserBid {
    private UserTransferObject user;
    private double bid;

    public UserBid(UserTransferObject user, double bid){
        this.user = user;
        this.bid = bid;
    }

    public double getBid(){
        return bid;
    }

    public UserTransferObject getUser(){
        return user;
    }

    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if (!(other instanceof UserBid)) return false;
        UserBid otherUserBid = (UserBid)other;
        if (this.getBid() != otherUserBid.getBid()) return false;
        if (!this.getUser().equals(otherUserBid.getUser())) return false;
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
        return String.format("UserBid(%s, %lf)", getUser().getUsername(), getBid());
    }
}