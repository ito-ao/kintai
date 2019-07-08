package mod;

public class User {

	private int userId;
	private String name;
	private String pass;

	public User(int userId, String name, String pass) {
		this.userId = userId;
		this.name = name;
		this.pass = pass;
	}

	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

}
