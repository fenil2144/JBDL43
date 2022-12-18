class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String s) {
		super(s);
	}
}


public class CustomException {
	
	public static void main(String args[]) {
		try {
			//checks if user is present,otherwise throw exception
			throw new UserNotFoundException("User Not Found");
		}
		catch(UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
