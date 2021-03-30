import java.util.Random;

public class Dice {
	
	private Random randomNumber;
	private int number;

	public Dice() {
		number=1;
		randomNumber = new Random();
		// TODO Auto-generated constructor stub
	}
	public void roll() {
		number = randomNumber.nextInt(6)+1;
	}
	public int getRandint() {
		return number;
	}


}
