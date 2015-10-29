package com.epam.training.auction.common;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 28.10.15.
 */
public class UserTransferObject {

    private long id;
    private String username;
    private String password;

    public UserTransferObject(long id, String username, String password){
        this.id = id;
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
    public boolean equals(Object other){
        if (!(other instanceof UserTransferObject)) return false;
        UserTransferObject otherUser = (UserTransferObject)other;
        if (id != otherUser.id) return false;
        if (!username.equals(otherUser.username)) return false;
        if (!password.equals(otherUser.password)) return false;
        return true;
    }

    @Override
    public int hashCode(){
        int code = 31;
        code += 17 * id;
        code += 19 * username.hashCode();
        code += 23 * password.hashCode();
        return code;
    }

    @Override
    public String toString(){
        return String.format("User(id: %d, username: %s, password: %s)", id, username, password);
    }

}
