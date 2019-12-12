
public class Player {
	private String name;
	private Garden garden;
	
	public Player(String a,int b) {
		name=a;
		garden=new Garden(b);
	}
	public String getName() {
		return name;
	}
	public int howManyFlowersPossible() {
		return garden.countPossibleFlowers();
	}
	public int howManyTreesPossible() {
		return garden.countPossibleTrees();
	}
	public char whatIsPlanted(int r, int c) {
		return garden.getInLocation(r, c);
	}
	public void plantTreeInGarden(int r, int c) {
		garden.plantTree(r, c);
	}
	public void plantFlowerInGarden(int r, int c) {
		garden.plantFlower(r, c);
	}
	public void eatHere(int r, int c) {
		garden.removeFlower(r, c);
	}
	public boolean isGardenFull() {
		return garden.gardenFull();
	}
	public void showGarden() {
		System.out.println("\n\n"+garden.toString());
	}
	

}