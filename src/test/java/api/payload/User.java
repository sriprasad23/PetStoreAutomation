package api.payload;

/*
 Notes: this class is called POJO class Plain old java object
 
 1. initialise all the variables as required in post request in application
 2. For each variable we have to create 1 setter and 1 getter Methods
 3. Select all the variables declared > source > Generate Setter and Getter > select all > Generate
 4. Automaticaly setter and getter method applied to the variables declared 
 5. cut and paste the variables top of the calss 
 
 */


public class User {

	int id;
	String username;
	String firstname;
	String lastname;
	String email;
	String password;
	String phone;
	int userStatus=0;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	
}
