import java.awt.Color;

public class Player {
	private String name;
	private Color color;
	public static String playerName=null;
	public static final int HUMAN_PLAYER = 0;
    public static final int COMPUTER_PLAYER = 1;     
    public static final int COMPUTER_LEVEL_BEGINNER = 1;   
    public static final int COMPUTER_LEVEL_EXPERT = 2;


	public Player(String name, Color color) {
		this.name=name;
		playerName=name;
		this.color=color;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Color getColor() {
		return color;
	}



	public void setColor(Color color) {
		this.color = color;
	}
	public static int nameToType(String var0) {
        if (var0.equals("Human")) {
            return 0;
        } else {
            return 1;
        }
    }	
}
