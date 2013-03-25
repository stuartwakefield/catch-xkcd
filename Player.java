class Ball extends Throwable {}

class Player {
	
	private Player other;
	private String name;
	private Ball ball;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void playWith(Player other, Ball ball) {
	
		// the player might already know they are playing with the other person
		if(this.other != other) {
			this.other = other;
			
			// check the other player knows they are playing
			other.playWith(this, null);
			
			// this player currently has the ball
			if(ball != null) {
				this.ball = ball;
				
				// Let's begin
				System.out.println(this.name + " has the ball...");
				System.out.println(this.name + ": 'Lets play!!'");
				other.prepare();
			}
		}
	}
	
	public void prepare() {
		try {
			System.out.println(this.name + ": 'Throw the ball!'");
			other.throwBall();
			
		} catch(Ball received) {
			System.out.println(this.name + " caught ball!");
			
			// this player now has the ball
			this.ball = received;
			
			System.out.println(this.name + ": 'Are you ready??'");
			
			other.prepare();
		}
	}
	
	public void throwBall() throws Ball {

		// collect the ball
		Ball ball = this.ball;
		
		// no sharing of the ball is allowed only one player can have it at 
		// a time
		this.ball = null;
		
		// throw the ball
		System.out.println(this.name + " threw ball...");
		throw ball;
	}
	
	public static void main(String[] args) {
	
		System.out.println("Setting up player a");
		Player a = new Player("a");
		
		System.out.println("Setting up player b");
		Player b = new Player("b");
		
		
		a.playWith(b, new Ball());
		
	}
	
}