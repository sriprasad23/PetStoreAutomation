package api.endpoints;

/*________________________________________________________________________________________________
 
 Notes: 
 Swagger: URI --> https://petstore.swagger.io						// Main url
 
 Create User (Post): https://petstore.swagger.io/v2/user			//---- v2/ --till her base url
 Get User (Get): https://petstore.swagger.io/v2/user/{username}  	// user/{username} -- End POint
 Update user (Put): https://petstore.swagger.io/v2/user/{username}
 Delete user (Delete): https://petstore.swagger.io/v2/user/{username}
 
 _______________________________________________________________________________________________*/


public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";  // acceess every where in the project
	
	// User Model
	// concatineting base ul + End points  it will combinley get as as url
	public static String post_url = base_url+"/user"; // concatinate previous and add remaining 
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	// Store Model = base url
	//all urls for Store model= base + endpoints
	// Pet Model = base url
	//all urls for Pet model = base + endpoints
}
