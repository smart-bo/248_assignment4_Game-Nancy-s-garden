//------------------------------------------
// Assignment4
// Written by: Zhang Bo   ID:40108654
// For COMP 248 Q 2182 - Fall 2018
//------------------------------------------

/*This program is used to run a play which allow players plants in their gardens. Who full the garden first,is the winner.
 *Then it prints out all the gardens.
 *    1: choose size of garden and numbers of players; 
 *    2: Roll dices to decide the first player,then plant something according the number of dice ;
 *    3: the one who full the garden first, win.
 *    4: Print out the result;
 *    5: if player choose illegal place, give a notice and let them try again .
 * */

import java.util.Scanner;
public class LetsPlay {
	public static void main(String[] args) {
	Scanner keyboard=new Scanner(System.in);
	System.out.println("              -------****-------****-------****-------****-----****-----"+
			"\n"+"                     Welcome to Crazy Nancy's Garden Game!"+"\n"+
			"              -------****-------****-------****-------****-----****-----"+"\n");
	System.out.print("To win this game you need some luck with the dice and a bit of strategy.\r\n" + 
			"Your garden is an NxN lot. You can plant flowers or trees. A flower takes one spot. A\r\n" + 
			"tree takes 4 spots (2x2).\r\n" + 
			"You roll the dice and based on the outcome you get to plant a pre-set number of trees\r\n" + 
			"and flowers.\r\n\n" + 
			"Rolls and their outcome:\r\n" + 
			"---------------------\r\n" + 
			"  3: plan a tree (2x2) and a flower (1x1)\r\n" + 
			"  6: plant 2 flowers (2 times 1x1)\r\n" + 
			"  12: plant 2 trees (2 times 2x2)\r\n" + 
			"  5 or 10: the rabbit will eat something that you have planted - might be a flower or\r\n" + 
			"part of a tree(1x1)\r\n" + 
			"  Any other EVEN rolls: plant a tree (2x2)\r\n" + 
			"  Any other ODD rolls: plant a flower (1x1)\r\n\n" + 
			"Minimum number of players: 2.\r\n" + 
			"Minimum garden size: 3x3.\r\n" + 
			"You can only plant in empty locations. To plant a tree you give the top left\r\n" + 
			"coordinates of the 2x2 space\r\n" + 
			"and I will check to make sure all 4 locations are free.\r\n" + 
			"Okay .. Let's start the game! May the best gardener win!!!\r\n\n" + 
			"\nThe default garden size is a 4x4 square. You can use this default board size or\r\n" + 
			"change the size\r\n" + 
			"Enter 0 to use the default garden size or -1 to enter your own size: ");
	int def;//default garden size.
	int size = 0;//store garden size.
	int round=0;//calculate number of round.	
	do{def=keyboard.nextInt();
		if( def==0)size=3;
	    else if (def==-1) {			    		        
		    System.out.print("What size board would you like? (minimum size 3) ");
		    size=keyboard.nextInt();
		    
		    }
	    else { 
	    	System.out.println("Sorry but " +def+" is not a legal choice. Enter your choice:");
			}}
	while(def!=-1&&def!=0);
		
	
	int nplayer;//number of players
	do{
		System.out.print("How many gardeners will there be (minimum 2 required to play, max allowed 10)?");
		nplayer=keyboard.nextInt();
	     if(nplayer<2||nplayer>10) {
		  System.out.println("** Sorry but "+nplayer+" is not a legal number of players.");}
		  else System.out.println("Great, "+nplayer+" players it will be!\n");
	
	}while (nplayer<2||nplayer>10);
	
		String[]player=new String[nplayer];
	for(int i=1;i<=nplayer;i++) {
		
		System.out.print("--> Name of player "+i+" (no spaces allowed): ");
		player[i-1]=keyboard.next();
		
	}
	System.out.println("\n"+"Let's see who goes first ...");
	
	Dice dice=new Dice();
	int[] eachdice=new int[nplayer];
	int max=0;
	boolean redice=false;//need redice or not.
	int i;
	
	do{
		for(i=0;i<nplayer;i++) {
	       redice=false;
	       eachdice[i]=dice.rollDice();
	       System.out.println(player[i]+" rolled at a "+eachdice[i]);	      
	       for (int y=0;y<i;y++) {
		   if (eachdice[i]==eachdice[y]) {
		       System.out.println("We will start over as "+eachdice[i]+" was rolled by a as well.\n");
		       redice=true;			       
		       break;}
	       }
	       if (i!=0&&eachdice[i]>eachdice[max])
		        max=i;
	       if (redice==true)break;
		}					
	}
	while(redice==true);	
	System.out.println(player[max]+" goes first. ");
	System.out.println("\nTime to play!!!!\r\n" + 
			"------------------\n");
	
	Player []players=new Player[nplayer];
	String[]runplayer=new String[nplayer];
	
	runplayer[0]=player[max];
	players[0]=new Player(player[max],size);
    for (int z=1;z<nplayer;z++) {
    
	if(max+z<nplayer) runplayer[z]=player[max+z];
	else runplayer[z]=player[z-nplayer+max];	
	players[z]=new Player(runplayer[z],size);
    }
    String winner=null;	
	int dicenum=0;	//store dice number.
	int column1;//store the garden point player chose.
	int column2;
	boolean full;
  do {	
	  full=false;
	for (int z=0;z<nplayer;z++ ) {
		dicenum=dice.rollDice();
		round++;
	    System.out.println(runplayer[z]+" you rolled "+dicenum+
			"(Die 1: "
			+ ""+dice.geta()+"  "+"Die 2: "+dice.getb()+")");
	    boolean reEnter;
	if(dicenum==3) {
		System.out.println("You must plant a tree (2x2) and a flower (1x1)." );
		players[z].showGarden();
		System.out.println("Let's start with the tree. You have "+players[z].howManyTreesPossible() +" places to do this.");
		if(players[z].howManyTreesPossible()==0)
			System.out.print("** Sorry no room left to plant a tree - You miss a turn"+"\n");
		else{
			System.out.print("Enter coordinates as row column: ");
		
		do{
		column1=keyboard.nextInt();
		column2=keyboard.nextInt();
		reEnter=false;
		if(column1+1>=size||column2+1>=size)
	    {
		System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+
	         "\n"+"or your tree will be off the grid. Try again");
		reEnter=true;
	    }
			 
		else if(players[z].whatIsPlanted(column1, column2)!='-'||players[z].whatIsPlanted(column1, column2+1)!='-'
				||players[z].whatIsPlanted(column1+1, column2)!='-'||players[z].whatIsPlanted(column1+1, column2+1)!='-')
		    {
			System.out.println("** Sorry that location is already taken up by a "+players[z].whatIsPlanted(column1, column2));
			System.out.println("Please enter a new set of coordinates:");
			reEnter=true;
		    }
		else if(players[z].whatIsPlanted(column1, column2)=='-'&&players[z].whatIsPlanted(column1, column2+1)=='-'
				&&players[z].whatIsPlanted(column1, column2)=='-'&&players[z].whatIsPlanted(column1+1, column2+1)=='-')
			   players[z].plantTreeInGarden(column1, column2);
			if(players[z].isGardenFull())
				{full=true;winner=players[z].getName();break;}
		}   
		while (reEnter);
		
		if(full)break;
		System.out.println("You still have a flower (1x1) flower to plant.");
		players[z].showGarden();
		System.out.println("You now have "+players[z].howManyFlowersPossible()+" places to do this.");		
		System.out.print("Enter coordinates as row column: ");
		do{
			column1=keyboard.nextInt();
		    column2=keyboard.nextInt();
		    reEnter=false;
		if(column1>=size||column2>=size){
				  System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+
			         "\n"+"Try again");
				    reEnter=true;
			    }      
		else if(players[z].whatIsPlanted(column1, column2)=='-'){ 
		   players[z].plantFlowerInGarden(column1, column2);
		   if(players[z].isGardenFull())
		   {full=true;winner=players[z].getName();break;}
		 }
		else if(column1>=size||column2>=size){
		  System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+
	         "\n"+"Try again");
		    reEnter=true;
	    }
		else 
		  {System.out.println("** Sorry that location is already taken up by a "
		                   +players[z].whatIsPlanted(column1, column2));
		  System.out.println("Please enter a new set of coordinates:");
		    reEnter=true;}
		}
		while (reEnter);
			  }
		if(full)break;
	}
	
	else if (dicenum==6) {
		System.out.println("You must plant 2 flowers (1x1)" );
		System.out.println("You have "+players[z].howManyFlowersPossible()+" places to do this." );
		players[z].showGarden();
		System.out.print("First flower - Enter coordinates as row column: ");
		do{
			column1=keyboard.nextInt();
		    column2=keyboard.nextInt();
		    reEnter=false;
		    
		if(column1>=size||column2>=size){
				  System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+
			         "\n"+"Try again");
				    reEnter=true;
			    }
		else if(players[z].whatIsPlanted(column1, column2)=='-') {
		  players[z].plantFlowerInGarden(column1, column2);
		  if(players[z].isGardenFull())
		   {full=true;winner=players[z].getName();break;}
		   }
		
		else 
		  {System.out.println("** Sorry that location is already taken up by a "
		                   +players[z].whatIsPlanted(column1, column2));
		  System.out.println("Please enter a new set of coordinates:");
		  reEnter=true;}
		}
		while (reEnter);
		if(full)break;
		players[z].showGarden();
		System.out.print("Second flower - Enter coordinates as row column: ");
		do{
			column1=keyboard.nextInt();
		    column2=keyboard.nextInt();
		    reEnter=false;
		
		if(column1>=size||column2>=size){
			  System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+
		         "\n"+"Try again");
			    reEnter=true;
		    }
		else if(players[z].whatIsPlanted(column1, column2)=='-') {
			  players[z].plantFlowerInGarden(column1, column2);
			  if(players[z].isGardenFull())
			    {full=true;winner=players[z].getName();break;}
			}
		else 
		  {System.out.println("** Sorry that location is already taken up by a "
		                   +players[z].whatIsPlanted(column1, column2));
		  System.out.println("Please enter a new set of coordinates:");
		  reEnter=true;}
		}
		while (reEnter);
		if(full)break;
	}
	else if (dicenum==12)	{			
		System.out.println("You must plant 2 trees (2x2)");
		players[z].showGarden();
		System.out.println("You have "+players[z].howManyTreesPossible()+" places to do this." );
		if(players[z].howManyTreesPossible()==0)
			System.out.print("** Sorry no room left to plant a tree - You miss a turn"+"\n");
		
		else {
			System.out.print("Enter coordinates as row column: ");			
		System.out.print("First tree - Enter coordinates as row column: ");
		do{
			column1=keyboard.nextInt();
			column2=keyboard.nextInt();
			reEnter=false;
			if(column1+1>=size||column2+1>=size)
		    {
			System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+
		         "\n"+"or your tree will be off the grid. Try again");
			reEnter=true;
		    }
				 
			else if(players[z].whatIsPlanted(column1, column2)!='-'||players[z].whatIsPlanted(column1, column2+1)!='-'
					||players[z].whatIsPlanted(column1+1, column2)!='-'||players[z].whatIsPlanted(column1+1, column2+1)!='-')
			    {
				System.out.println("** Sorry that location is already taken up by a "+players[z].whatIsPlanted(column1, column2));
				System.out.println("Please enter a new set of coordinates:");
				reEnter=true;
			    }
			else if(players[z].whatIsPlanted(column1, column2)=='-'&&players[z].whatIsPlanted(column1, column2+1)=='-'
					&&players[z].whatIsPlanted(column1, column2)=='-'&&players[z].whatIsPlanted(column1+1, column2+1)=='-') {
				   players[z].plantTreeInGarden(column1, column2);
				   players[z].showGarden();
			     if(players[z].isGardenFull())
		         {full=true;winner=players[z].getName();break;}}
			}   
			while (reEnter);	
		if(full)break;
		if(players[z].howManyTreesPossible()==0)
			System.out.print("** Sorry no room left to plant a tree - You miss a turn"+"\n");
		
		else 
		{			
		System.out.print("Second tree - Enter coordinates as row column: ");
		do{
			column1=keyboard.nextInt();
			column2=keyboard.nextInt();
			reEnter=false;
			if(column1+1>=size||column2+1>=size)
		    {
			System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+
		         "\n"+"or your tree will be off the grid. Try again");
			reEnter=true;
		    }
				 
			else if(players[z].whatIsPlanted(column1, column2)!='-'||players[z].whatIsPlanted(column1, column2+1)!='-'
					||players[z].whatIsPlanted(column1+1, column2)!='-'||players[z].whatIsPlanted(column1+1, column2+1)!='-')
			    {
				System.out.println("** Sorry that location is already taken up by a "+players[z].whatIsPlanted(column1, column2));
				System.out.println("Please enter a new set of coordinates:");
				reEnter=true;
			    }
			else if(players[z].whatIsPlanted(column1, column2)=='-'&&players[z].whatIsPlanted(column1, column2+1)=='-'
					&&players[z].whatIsPlanted(column1, column2)=='-'&&players[z].whatIsPlanted(column1+1, column2+1)=='-') {
				   players[z].plantTreeInGarden(column1, column2);
			    if(players[z].isGardenFull())
	             {full=true;winner=players[z].getName();break;}
			  }
			}   
			while (reEnter);
		   }
		}
		if(full)break;
	}
	
	else if (dicenum==5||dicenum==10) {
		  players[z].showGarden();		
		  int a; int b;				   
			  a=(int)(Math.random()*size);
		      b=(int)(Math.random()*size);
		     
		  if(players[z].whatIsPlanted(a, a)!='-') { 
		      System.out.println("The rabbit ate whatever was planted in location ("+a+","+b+")" );
		      players[z].eatHere(a, b);		
		      players[z].showGarden();}		
	}
				   	
	else if (dicenum==2||dicenum==4||dicenum==8) {
		System.out.println("You must plant a tree (2x2)" );
		players[z].showGarden();
		System.out.println("and have "+players[z].howManyTreesPossible()+" places to do this." );
		if(players[z].howManyTreesPossible()==0)
			System.out.print("** Sorry no room left to plant a tree - You miss a turn"+"\n");
		else 
		 {
			System.out.print("Enter coordinates as row column: ");			
		
		do{
			column1=keyboard.nextInt();
			column2=keyboard.nextInt();
			reEnter=false;
			if(column1+1>=size||column2+1>=size)
		    {
			System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+
		         "\n"+"or your tree will be off the grid. Try again");
			reEnter=true;
		    }
				 
			else if(players[z].whatIsPlanted(column1, column2)!='-'||players[z].whatIsPlanted(column1, column2+1)!='-'
					||players[z].whatIsPlanted(column1+1, column2)!='-'||players[z].whatIsPlanted(column1+1, column2+1)!='-')
			    {
				System.out.println("** Sorry that location is already taken up by a "+players[z].whatIsPlanted(column1, column2));
				System.out.println("Please enter a new set of coordinates:");
				reEnter=true;
			    }
			else if(players[z].whatIsPlanted(column1, column2)=='-'&&players[z].whatIsPlanted(column1, column2+1)=='-'
					&&players[z].whatIsPlanted(column1, column2)=='-'&&players[z].whatIsPlanted(column1+1, column2+1)=='-') 
			      {
				   players[z].plantTreeInGarden(column1, column2);
			        if(players[z].isGardenFull())
                       {full=true;winner=players[z].getName();break;}
			        }
			}   
			while (reEnter);
		}
		if(full)break;
	}		   
	
	
	else {
	   System.out.println("You must plant a flower (1x1)" );
	   players[z].showGarden();
	   System.out.println("" );
	   System.out.println("You now have "+players[z].howManyFlowersPossible()+" places to do this.");		
		System.out.print("Enter coordinates as row column: ");
		do{
			column1=keyboard.nextInt();
		    column2=keyboard.nextInt();
		    reEnter=false;
	  
		if(column1>=size||column2>=size){
			  System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+
		         "\n"+"Try again");
			    reEnter=true;
		    }
		else if(players[z].whatIsPlanted(column1, column2)=='-') {
			  players[z].plantFlowerInGarden(column1, column2);
			
			  if(players[z].isGardenFull())
	           {full=true;winner=players[z].getName();break;}
			}
		else 
		  {System.out.println("** Sorry that location is already taken up by a "
		                   +players[z].whatIsPlanted(column1, column2));
		  System.out.println("Please enter a new set of coordinates:");
		  reEnter=true;}
		}
		while (reEnter);
	     }
	    System.out.println();
	    if(full)break;	
       }	
     }
  while(full==false);
  System.out.println("\n\nFINAL RESULTS\n"+ "-------------"+"\n"
  		             + "Here are the gardens after "+round+" rounds.");
  for(i=0;i<nplayer;i++) {
	  System.out.println(players[i].getName()+"'s garden");
	  players[i].showGarden();
     }
  System.out.println("And the winner is ..... "+winner+"!!!!!"+"\n"
		             +"What a beautiful garden you have."+"\n");
  System.out.println("Hope you had fun!!!!");

  keyboard.close();
	}
}
