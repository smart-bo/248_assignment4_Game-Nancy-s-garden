



public class Final {

	public static int alternatingSum(int[] a) {
	int sum=a[0];
	for(int i=1;i<a.length;i++) {
			if(i%2==1) sum-=a[i];
			else sum+=a[i];
			}
	return sum;
		}
	

	//public static boolean reverseSame(int a,int b) {
	//	int newn=0;
	//	while(a>0) {
	//		newn=newn*10;
	//		newn+=a%10;
	//		a=a/10;
	//	}
	//	if (newn==b)
	//		return true;
	//	else return false;

	//	}

	
	
	
	public static void main(String[] args) {
		int[]a= {1,6,9,16,9,7,4,9,13};
		System.out.print(alternatingSum(a));
		//System.out.print(reverseSame(24567,76542));
	}

}
