package com.epam.training.auction.common;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 28.10.15.
 */
public final class AuctionTransferObject implements Serializable {

    private long id;
    private String title;
    private String description;
    private boolean isActive;
    private UserTransferObject seller;
    private UserTransferObject winner;
    private double finalPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private int cachedHashCode = 0;

    private AuctionTransferObject(String title, UserTransferObject seller){
        this.title = title;
        this.seller = seller;
    }

    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if (!(other instanceof AuctionTransferObject)) return false;
        AuctionTransferObject otherAuction = (AuctionTransferObject)other;
        if (this.getId() != otherAuction.getId()) return false;
        if (!CommonUtils.areTwoObjectsEqual(this.getTitle(), otherAuction.getTitle())) return false;
        if (!CommonUtils.areTwoObjectsEqual(this.getDescription(), otherAuction.getDescription())) return false;
        if (this.isActive() != otherAuction.isActive()) return false;
        if (!CommonUtils.areTwoObjectsEqual(this.getSeller(), otherAuction.getSeller())) return false;
        if (!CommonUtils.areTwoObjectsEqual(this.getWinner(), otherAuction.getWinner())) return false;
        if (this.getFinalPrice() != otherAuction.getFinalPrice()) return false;
        if (!CommonUtils.areTwoObjectsEqual(this.getCreatedAt(), otherAuction.getCreatedAt())) return false;
        if (!CommonUtils.areTwoObjectsEqual(this.getUpdatedAt(), otherAuction.getUpdatedAt())) return false;
        return true;
    }


    @Override
    public int hashCode(){
        if (cachedHashCode != 0) return cachedHashCode;
        cachedHashCode = 13;
        cachedHashCode +=  17 * this.getId();
        cachedHashCode +=  17 * CommonUtils.getHashCode(this.getTitle());
        cachedHashCode +=  23 * CommonUtils.getHashCode(this.getDescription());
        cachedHashCode +=  29 * (this.isActive() ? 1 : 0);
        cachedHashCode +=  31 * CommonUtils.getHashCode(this.getSeller());
        cachedHashCode +=  37 * CommonUtils.getHashCode(this.getWinner());
        cachedHashCode += 41 * Double.valueOf(this.getFinalPrice()).hashCode();
        cachedHashCode +=  43 * CommonUtils.getHashCode(this.getCreatedAt());
        cachedHashCode +=  47 * CommonUtils.getHashCode(this.getUpdatedAt());
        return cachedHashCode;
    }

    @Override
    public String toString(){
        return String.format("Auction(id: %ld, title: %s, active: %s)", id, title, (isActive ? "Yes" : "No"));
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserTransferObject getSeller() {
        return seller;
    }

    public UserTransferObject getWinner() {
        return winner;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }


    // Builder
    public static final class AuctionBuilder {

        private long id;
        private String title;
        private String description;
        private boolean isActive;
        private UserTransferObject seller;
        private UserTransferObject winner;
        private double finalPrice;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;


        private AuctionBuilder(String title, UserTransferObject seller){
            this.id = 0;
            this.title = title;
            this.description = "";
            this.isActive = true;
            this.seller = seller;
            this.winner = null;
            this.finalPrice = 0.0;
            this.createdAt = LocalDateTime.now();
            this.updatedAt = null;
        }

        public AuctionBuilder setId(long id){
            this.id = id;
            return this;
        }

        public AuctionBuilder setDescription(String description){
            this.description = description;
            return this;
        }

        public AuctionBuilder setIsActive(boolean isActive){
            this.isActive = isActive;
            return this;
        }

        public AuctionBuilder setWinner(UserTransferObject winner){
            this.winner = winner;
            return this;
        }

        public AuctionBuilder setFinalPrice(double finalPrice){
            this.finalPrice = finalPrice;
            return this;
        }

        public AuctionBuilder setCreatedAt(LocalDateTime createdAt){
            this.createdAt = createdAt;
            return this;
        }

        public AuctionBuilder setUpdatedAt(LocalDateTime updatedAt){
            this.updatedAt = updatedAt;
            return this;
        }

        public AuctionTransferObject build(){
            AuctionTransferObject auction = new AuctionTransferObject(this.title, this.seller);
            auction.id = this.id;
            auction.description = this.description;
            auction.isActive = this.isActive;
            auction.winner = this.winner;
            auction.finalPrice = this.finalPrice;
            auction.createdAt = this.createdAt;
            auction.updatedAt = this.updatedAt;
            return auction;
        }
    }

    public static AuctionBuilder getBuilder(String title, UserTransferObject seller) {
        AuctionBuilder builder = new AuctionBuilder(title, seller);
        return builder;
    }
}
