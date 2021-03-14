package part01;

public enum Genre {
		
	ROCK(0), POP(1), DANCE(2), JAZZ(3), CLASSICAL(4), OTHER(5);
	
	String[] name = {"Rock and Roll", "Easy Listening Pop",
			"Techno Dance", "Smooth Jazz", "Classical", 
			"Unknown Genre"};
	
	private int gNum;
	
	Genre(int num){
		this.gNum = num;
	}
	

	
	public String toString() {
		return this.name[gNum];
	}
}
