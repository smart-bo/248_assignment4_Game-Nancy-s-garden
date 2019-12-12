
public class Dice {
	private int a;
	private int b;
	
	public Dice() {
	a=0;
	b=0;}
	
	public int geta() {
		return a;
	}
	public int getb() {
		return b;
	}
	public int rollDice() {
	   
	   a=(int)(Math.random()*6+1);	   
	   b=(int)(Math.random()*6+1);	 	   
	   return (a+b);
	}
	public String toString() {
		return (a+" and "+b);
	}
	

}
