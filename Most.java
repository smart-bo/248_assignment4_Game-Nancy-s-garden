import java.util.Scanner;
public class Most {

	public static void main(String[] args) {
		System.out.print("Please enter hour:");
		Scanner keyboard = new Scanner(System.in);
		int hour = keyboard.nextInt();
		if (hour<2)
		{
		System.out.print("Hour should be >=2. The End");
		}
		else { 
		int i,j,k;
		//Output the upper triangle
		for(i=0; i<hour/2+hour%2; i++)
		{
		for (j=0;j<i;j++)
		{
		System.out.print(' ');
		}
		for (j=0;j<hour
		-
		2*i;j++)
		{
		System.out.print('*');
		}
		System.out.print('\n');
		}
		//Output the lower triangle
		int m=hour/2+hour%2;
		for (i=1; i<m; i++)
		{
		for (j=0; j<m
		-
		1
		-
		i; j++)
		{
		System.out.print(' ');
		}

		for (k=j; k<hour
		-
		j; k++)
		{
		System.out.print('*');
		}
		System.out.print('\n');
		}
		}
		
		
		
	}

}
