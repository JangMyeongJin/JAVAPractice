package practice;

public class ChosungTest {

	public static void main(String[] args) {
		char c;
		String word = "°¡³ª´Ù";
		
		c = word.charAt(0);
		
		System.out.println((c & 0xFFFF) >= 0xD7A3);

	}

}
