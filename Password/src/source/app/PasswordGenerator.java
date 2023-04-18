package source.app;

public class PasswordGenerator {
	
	private char numberToAscii(int num) {
		char ch = (char) num;
		return ch;
	}

	private int generateNumber() {
		int num = (int) (Math.random() * (125 - 33) + 33);
		if (num == 34 || num == 39 || num == 92 || num == 96) {
			num++;
			return num;
		}
		return num;
	}

	public String passwordComplete(int size) {
		String password = "";
		int random;
		while (size > 0) {
			random = generateNumber();
			password = password + numberToAscii(random);
			size--;
		}
		return password;
	}

	public String passwordAlphaNumeric(int size) {
		String password = "";
		String dictionary = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		while (size > 0) {
			int random = (int) (Math.random() * (dictionary.length()));
			password = password + dictionary.charAt(random);
			size --;
		}
		return password;
	}
}
