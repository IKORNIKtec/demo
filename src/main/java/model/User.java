package model;

/**
 * Created by WWW on 21.06.2015.
 */
public class User {
    private String email;
    private String password;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
