package utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import model.User;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by WWW on 21.06.2015.
 */
public class GmailUtils {
    private final static String EMAIL_ALREADY_USED = "You entered an email address that is already associated with an account.";

    public static boolean isUserExist(String userName) {
        RestAssured.baseURI = "https://accounts.google.com";
        Response resp =
        given().
            header("Content-Type", "application/json").

            body("{" +
                    "\"input01\":" +
                    "    {" +
                    "        \"Input\":\"GmailAddress\"," +
                    "        \"GmailAddress\":\"" + userName + "\"," +
                    "        \"FirstName\":\"\",\"LastName\":\"\"" +
                    "    }," +
                    "    \"Locale\":\"en\"" +
                    "}").
        when().
            post("/InputValidator?resource=SignUp");
        resp.prettyPrint();
        return resp.body().jsonPath().getString("input01.ErrorMessage").contains(EMAIL_ALREADY_USED);
    }

    //TODO: not implemented yet.  Gmail API will be used
    public static void registerUser(User user){

    }
}