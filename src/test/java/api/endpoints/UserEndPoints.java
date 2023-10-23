package api.endpoints;
import static io.restassured.RestAssured.*;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
/*__________________________________________________________________________________________________________________________________________
 Notes:
 UserEndPoints.java class
 Created to perform Create, Read, Update, Delete requests to the user API
 __________________________________________________________________________________________________________________________________________*/

public class UserEndPoints {
	

	public static Response createUser(User payload)	
	{ 
     Response response = given()  					// response 
    		 		.contentType(ContentType.JSON) // type of content body
    		 		.accept(ContentType.JSON)  // accept the content type
    		 		.body(payload)				// payload 
    		 .when()
    		 		.post(Routes.post_url);    // from routes class pass the post url 
		
     return response;							// response return to the response variable
		
	}
	
	// To Read 
	public static Response readUser(String userName)	
	{
     Response response = given()
    		 			.pathParam("username", userName)
    		 .when()
    		 		.get(Routes.get_url);
		
     return response;
		
	}
	
	// Update the user 
	public static Response updateUser(String userName, User payload)	
	{
     Response response = given()
    		 		.contentType(ContentType.JSON)
    		 		.accept(ContentType.JSON)
    		 		.pathParam("username", userName)
    		 		.body(payload)
    		 .when()
    		 		.put(Routes.update_url);
		
     return response;
		
	}
	
	public static Response deleteUser(String userName)	
	{
     Response response = given()
    		 			.pathParam("username", userName)
    		 .when()
    		 		.delete(Routes.delete_url);
		
     return response;
		
	}
}
