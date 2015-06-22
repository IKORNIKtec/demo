package model;

import java.util.Date;

/**
 * Created by WWW on 21.06.2015.
 */
public class UserFactory {
    public static User getNewUser(){
        return new User("","");
    }

    public static User getExisingUser(){
        return new User("digicodeuser", "Digicode123!");
    }
}
