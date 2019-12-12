
public class Pair {

		int first, second
		;
		public Pair(){ 
		first = second = 0;
		}
		public Pair(int f, int s){ 
		first = f; second = s;}
		int getFirst() { 
		return first;
		}
		int getSecond() { 
		return second;
		}
		void setFirst(int f) { 
		first = f;
		}
		void setSecond(int s) { 
		second = s;
		}
		void printPair() { 
		System.out.println("Pair: " + first + ", " + second);
		}
		

		public static void main(String[] args)
		{
		int i = 5;
		Pair c1 = new Pair();
		Pair c2 = new Pair(2, 3);
		c1.printPair();
		c1.setSecond(i);
		c1.printPair();
		c2.printPair();
		c2.setFirst(i * 3);
		c2.printPair();
		System.out.println(c1.getFirst());
		Pair c3 = c2;
		c3.setFirst(i * 4);
		c2.printPair();
		c3.printPair();
		if (c2 == c3)
		System.out.print("here 1 ");
		c3 = new Pair(4, 3);
		if (c2 == c3)
		System.out.print("here 2");
		}
		

}
