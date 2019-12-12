
public class driver {

	public static void main(String[] args) {
		
		Garden x=new Garden();
		x.creategarden(6);
		x.plantTree(2,2);
		System.out.println(x.countPossibleTrees());
		System.out.println(x.toString());
		// TODO Auto-generated method stub
		/*char[][] garden=new char[3][3];
		garden[0][0]='1';
		garden[0][1]='2';
		garden[0][2]='3';
		garden[1][0]='4';
		garden[1][1]='5';
		garden[1][2]='6';
		garden[2][0]='7';
		garden[2][1]='8';
		garden[2][2]='9';
		
		String draw=(" "+"|");
		for(int i=0;i<garden.length;i++) {
			draw+=" ";
			draw+=i;
		}
		draw+='\n';
		
		   for(int i=0;i<garden.length;i++) {
			   draw+=i;draw+='|';
				 for(int y=0;y<garden.length;y++){	
					draw+=" ";
					draw+=(garden[i][y]);					
				 }
				 draw+='\n' ;
		   }
      System.out.println(draw);
	}*/
	}
}
