
public class Garden {
	private char[][] garden;
	   
	   public Garden() {	   
		   garden=new char[3][3];		   
		   this.initializeGarden();}
	   public Garden(int size) {	   
		   garden=new char[size][size];		   
		   this.initializeGarden();}
	   
	   public int getsize() {
		   int size=garden.length;
		   return size;
	   }
	   private void initializeGarden() {
		   
		   for (int i=0;i<garden.length;i++) {
			   for(int y=0;y<garden.length;y++) {			   
				   garden[i][y]='-';
			   }
		   }
		   
	   }
	   public char  getInLocation(int r,int c) {
		   return this.garden[r][c];
	   }
	   public void plantFlower(int r,int c) {
		   garden[r][c]='f';
	   }
	   public void plantTree(int r,int c) {
		   garden[r][c]='t'; garden[r+1][c]='t'; garden[r][c+1]='t'; garden[r+1][c+1]='t';
	   }
	   public void   removeFlower(int r,int c) {
		   garden[r][c]='-';
	   }
	   public int  countPossibleTrees() {
		  int place=0;
		  for(int i=0;i<garden.length-1;i++) {
			 for(int y=0;y<garden.length-1;y++){
				 if (garden[i][y]=='-'&&garden[i+1][y]=='-'
						 &&garden[i][y+1]=='-'&&garden[i+1][y+1]=='-') {
					 place++;
				 }
			 }
		  }
			  return place;	   
	   }
	   public int  countPossibleFlowers() {
		   int place=0;
		   for(int i=0;i<garden.length;i++) {
				 for(int y=0;y<garden.length;y++){
					 if (garden[i][y]=='-')
						 place++;
				 }
	        }
		   return place;
	   }
	   public boolean  gardenFull() {
		   boolean full= true;
		   for(int i=0;i<garden.length;i++) {
				 for(int y=0;y<garden.length;y++){
					 if (garden[i][y]=='-') full=false;
					 else continue;}			 
		   }
		   return full;
	   }
	   public String toString() {
		   String draw=("  "+"|");
		   for(int i=0;i<garden.length;i++) {
				draw+=" ";
				draw+=i;
			}
			draw+='\n';
			draw+='\n';
			
			   for(int i=0;i<garden.length;i++) {
				   draw+=i;draw+=(" "+"|");
					 for(int y=0;y<garden.length;y++){	
						draw+=" ";
						draw+=(garden[i][y]);					
					 }
					 draw+='\n';
					 draw+='\n';
			   }		   
		   return draw;
	   }

}
