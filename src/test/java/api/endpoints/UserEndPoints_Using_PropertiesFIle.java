package api.endpoints;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
/*__________________________________________________________________________________________________________________________________________
 Notes:
 UserEndPoints_Using_PropertiesFIle.java class
 by using properties file Routes are mapped
 Created to perform Create, Read, Update, Delete requests to the user API
 Method created for getting URL's from properties file --> ResourceBundle
 String post_url=getURL().getString("post_url"); is added with each method to get Url from Properies file
 	String Name, getString, post .--> based on properties file url name copied here
 __________________________________________________________________________________________________________________________________________*/

public class UserEndPoints_Using_PropertiesFIle {
	
	//Method created for getting URL's from properties file
	
	static ResourceBundle getURL()
	{
	ResourceBundle routes = ResourceBundle.getBundle("routes"); // Load the properties
	return routes;
	}

	public static Response createUser(User payload)	
	{
	
	String post_url=getURL().getString("post_url");
		
     Response response = given()
    		 		.contentType(ContentType.JSON)
    		 		.accept(ContentType.JSON)
    		 		.body(payload)
    		 .when()
    		 		.post(post_url);
		
     return response;
		
	}
	
	public static Response readUser(String userName)	
	{
	
		String get_url=getURL().getString("get_url");
		
     Response response = given()
    		 			.pathParam("username", userName)
    		 .when()
    		 		.get(get_url);
		
     return response;
		
	}
	
	public static Response updateUser(String userName, User payload)	
	{
	
		String update_url=getURL().getString("update_url");
		
     Response response = given()
    		 		.contentType(ContentType.JSON)
    		 		.accept(ContentType.JSON)
    		 		.pathParam("username", userName)
    		 		.body(payload)
    		 .when()
    		 		.put(update_url);
		
     return response;
		
	}
	
	public static Response deleteUser(String userName)	
	{
	
		String delete_url=getURL().getString("delete_url");	
		
     Response response = given()
    		 			.pathParam("username", userName)
    		 .when()
    		 		.delete(delete_url);
		
     return response;
		
	}
}
