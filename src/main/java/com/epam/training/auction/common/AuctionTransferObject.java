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
    public boolean equals(Object auction) {
        if (this == auction) return true;
        if (auction == null || getClass() != auction.getClass()) return false;

        AuctionTransferObject that = (AuctionTransferObject) auction;

        if (id != that.id) return false;
        if (isActive != that.isActive) return false;
        if (Double.compare(that.finalPrice, finalPrice) != 0) return false;
        if (cachedHashCode != that.cachedHashCode) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (seller != null ? !seller.equals(that.seller) : that.seller != null) return false;
        if (winner != null ? !winner.equals(that.winner) : that.winner != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        return !(updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + (seller != null ? seller.hashCode() : 0);
        result = 31 * result + (winner != null ? winner.hashCode() : 0);
        temp = Double.doubleToLongBits(finalPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + cachedHashCode;
        return result;
    }

    @Override
    public String toString(){
        return String.format("Auction(id: %d, title: %s, active: %s)", id, title, (isActive ? "Yes" : "No"));
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
            this.title = title;
            this.seller = seller;
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
        return new AuctionBuilder(title, seller);
    }
}
