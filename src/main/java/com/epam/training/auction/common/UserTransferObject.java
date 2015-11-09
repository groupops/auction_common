package com.epam.training.auction.common;

import java.io.Serializable;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 28.10.15.
 */
public final class UserTransferObject implements Serializable {

    private long id;
    private String username;
    private String password;

    public UserTransferObject(long id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserTransferObject(String username, String password){
        this.username = username;
        this.password = password;
    }

    public long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTransferObject that = (UserTransferObject) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        return !(password != null ? !password.equals(that.password) : that.password != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return String.format("User(id: %d, username: %s, password: %s)", id, username, password);
    }

}
