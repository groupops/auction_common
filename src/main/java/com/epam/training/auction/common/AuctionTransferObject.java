package com.epam.training.auction.common;

import java.time.LocalDateTime;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 28.10.15.
 */
public final class AuctionTransferObject {

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

    private AuctionTransferObject(long id, String title, UserTransferObject seller){
        this.id = id;
        this.title = title;
        this.seller = seller;
    }

    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if (!(other instanceof AuctionTransferObject)) return false;
        AuctionTransferObject otherAuction = (AuctionTransferObject)other;
        if (this.getId() != otherAuction.getId()) return false;
        if (!this.getTitle().equals(otherAuction.getTitle())) return false;
        if (!this.getDescription().equals(otherAuction.getDescription())) return false;
        if (this.isActive() != otherAuction.isActive()) return false;
        if (!this.getSeller().equals(otherAuction.getSeller())) return false;
        if (!this.getWinner().equals(otherAuction.getWinner())) return false;
        if (this.getFinalPrice() != otherAuction.getFinalPrice()) return false;
        if (!this.getCreatedAt().equals(otherAuction.getCreatedAt())) return false;
        if (!this.getUpdatedAt().equals(otherAuction.getUpdatedAt())) return false;
        return true;
    }


    @Override
    public int hashCode(){
        if (cachedHashCode != 0) return cachedHashCode;
        cachedHashCode = 13;
        cachedHashCode +=  17 * this.getId();
        cachedHashCode +=  17 * this.getTitle().hashCode();
        cachedHashCode +=  23 * this.getDescription().hashCode();
        cachedHashCode +=  29 * (this.isActive() ? 1 : 0);
        cachedHashCode +=  31 * this.getSeller().hashCode();
        cachedHashCode +=  37 * this.getWinner().hashCode();
        cachedHashCode +=  41 * Double.valueOf(this.getFinalPrice()).hashCode();
        cachedHashCode +=  43 * this.getCreatedAt().hashCode();
        cachedHashCode +=  47 * this.getUpdatedAt().hashCode();
        return cachedHashCode;
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


        private AuctionBuilder(long id, String title, UserTransferObject seller){
            this.id = id;
            this.title = title;
            this.description = "";
            this.isActive = true;
            this.seller = seller;
            this.winner = null;
            this.finalPrice = 0.0;
            this.createdAt = LocalDateTime.now();
            this.updatedAt = null;
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
            AuctionTransferObject auction = new AuctionTransferObject(this.id, this.title, this.seller);
            auction.description = this.description;
            auction.isActive = this.isActive;
            auction.winner = this.winner;
            auction.finalPrice = this.finalPrice;
            auction.createdAt = this.createdAt;
            auction.updatedAt = this.updatedAt;
            return auction;
        }
    }

    public static AuctionBuilder getBuilder(long id, String title, UserTransferObject seller) {
        AuctionBuilder builder = new AuctionBuilder(id, title, seller);
        return builder;
    }
}
