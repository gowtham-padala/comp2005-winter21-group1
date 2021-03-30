import java.util.Random;

public class Dice {
	
	private Random randomNumber;
	private int randint;

	public Dice() {
		randint=1;// TODO Auto-generated constructor stub
	}
	public void roll() {
		randomNumber = new Random();
		randint = randomNumber.nextInt(6)+1;
	}
	public int getRandint() {
		return randint;
	}	

}
