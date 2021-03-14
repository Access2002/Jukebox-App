package part01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JukeboxTester{
	
	static ArrayList<AudioTrack> playlist = new ArrayList<AudioTrack>();
		
	public static void main(String[] args) {		
		
		AudioPlayer player = new AudioPlayer();
		Jukebox jbox = new Jukebox(player);

		String[] options = {"Display all Tracks", "Track By Artist",  "Add Track", "Play Track",  "Create a playlist",  "Shuffle", "Display Top 10", "Exit"};
		final int QUIT = options.length;
		Menu menu = new Menu("jukebox", options);
		
		int choice = 0;
		do {
			try {
				choice = menu.getUserChoice();
				processChoice(choice, jbox);
			}catch(InputMismatchException ex) {
				System.out.println("Please enter a number");
			}

		}while(choice != QUIT);
		
	}
	
	/**
	 * This processes the users choice in the main menu
	 * @param choice
	 * @param jbox
	 */
	
	private static void processChoice(int choice, Jukebox jbox) {
		Scanner input = new Scanner(System.in);
		
		
		switch(choice) {
		case 1: 
			String trackList = jbox.getTrackList();
			if(trackList == null) {
				System.out.println("There are no tracks currently");
				break;
			}
			System.out.println(trackList + System.lineSeparator());
			break;
			
		case 2:
			trackByArtist(jbox, input);
			break;
			
		case 3: 
			addNewTrack(jbox, input);
			break;
		case 4:
			playTrack(jbox, input);
			break;
		case 5:
			playlist = createPlaylist(jbox, input);
			for(int i = 0; i < playlist.size(); i++) {
				System.out.print("[" + playlist.get(i).getTitle() + " ], ");
			}
			break;
		case 6:
			if(playlist.isEmpty() || playlist == null) {
				System.out.println("You Must create a playlist first");
				break;
			}else {
				String shuffledSong = jbox.shuffle(playlist);
				System.out.println(shuffledSong);
				break;
			}

			
		case 7:
			displayTop10(jbox);
			break;
		case 8:
			System.out.print("Goodbye");
			break;
		default:
			System.out.println("Please enter a valid input");
			break;
		}
	}
	
	private static int userIntInput(Scanner input) {
		int value = 0;
		boolean done = false;
		do {
			try {
				value = input.nextInt();
			}catch(InputMismatchException ex){
				System.out.println("Please enter a number");
				input.next();
				break;
			}
			return value;
		}while(done != true);
		
		return 0;
	}
	
	// private String userStringChoice() {}
	
    private static void trackByArtist(Jukebox jbox, Scanner input) {
        
        AudioTrack[] trackArray = jbox.getTracks();
        ArrayList<String> trackArtists = new ArrayList<String>();
       
        
        for(int i = 0; i < trackArray.length; i++) {
            boolean artistPresent = false;
            for(int j = 0; j < trackArtists.size(); j++) {
                if(trackArray[i].artist.equals(trackArtists.get(j))) {
                    artistPresent = true;
                }
            }
            if(artistPresent == false) {
            	trackArtists.add(trackArray[i].artist);
            }
        }
       
        
        for(int i = 0; i < trackArtists.size(); i++) {
        	System.out.println((i+1) +". " + trackArtists.get(i));
        }
        
        
        int choice = 0;
        boolean done = false;
        do {
        	try {
        		System.out.println("Select an Artist");
        		choice = input.nextInt();
        		done = true;
        	}catch(InputMismatchException ex) {
        		System.out.println("Enter a Number");
        		input.next();
        	}
        }while(done != true);
        
            for(int i = 0; i < trackArray.length; i++) {
        		if(trackArray[i].getArtist().contentEquals(trackArtists.get(choice-1))) {
            		System.out.println(trackArray[i].getTitle());
            	}
            }
        }
    
	/**
	 * This lists all the possible genres that a song can be categorised into
	 */
    
	private static void genreList() {
		Genre style[] = Genre.values();
		for(int i = 0; i < style.length; i++) {
			System.out.println((i + 1) + "." + style[i]);
		}
	}
	
	/**
	 * Takes a jukebox and scanner as parameters and asks the user for inputs and sends the inputs to the Jukebox for the track to be added
	 * @param jbox
	 * @param input
	 */
	

	private static void addNewTrack(Jukebox jbox, Scanner input) {
		AudioTrack trk = new AudioTrack(null, null, 0, null, null);
		System.out.println("Enter the title of the track");

		String title = input.nextLine();
		trk.title = title;
		
		System.out.println("Enter the artist of the track");
		String artist = input.nextLine();
		trk.artist = artist;
		
		System.out.println("Enter the duration of the track (in minutes)");
		int duration = input.nextInt();
		trk.duration = duration;
		
		System.out.println("Select the Genre of the track");
		
		genreList();
		
		int styleChoice = input.nextInt();
		switch(styleChoice) {
		case 1:
			trk.style = Genre.ROCK;
		case 2:
			trk.style = Genre.POP;
		case 3:
			trk.style = Genre.DANCE;
		case 4:
			trk.style = Genre.JAZZ;
		case 5:
			trk.style = Genre.CLASSICAL;
		case 6:
			trk.style = Genre.OTHER;
		}
		
		System.out.println("Select the genre of the track");
		System.out.println("1. MP3");
		System.out.println("2. WAV");
		
		int encodingChoice = input.nextInt();
		switch(encodingChoice) {
		case 1:
			trk.encoding = "wav";
		case 2:
			trk.encoding = "mp3";
		}

		jbox.addTrack(trk);
		System.out.println("Track added!");

	}
	

	
	/**
	 * This asks the user for a track and the track selected gets sent to the jukebox
	 * @param jbox
	 * @param input
	 */
	private static void playTrack(Jukebox jbox, Scanner input) {
		AudioTrack trackArray[] = jbox.getTracks();
		
		for(int i = 0; i < trackArray.length; i++) {
			System.out.println((i+1) + ". " + trackArray[i].getTitle() + ", " + trackArray[i].plays);
		}
		
		System.out.println("Select a track to play");
		int choice = 0; 
		try {
			choice = input.nextInt();
			System.out.println("Array is out of bounds");			
		}catch(InputMismatchException ex){
			System.out.println(ex + ", Please Enter a Number!");
		}
		
		if(choice > 0) {
			boolean playTrack = jbox.playTrack(trackArray[choice-1]);
			if(playTrack == true) {
				System.out.println(trackArray[choice-1].getTitle() + " has been played");
			}else {
				System.out.println(trackArray[choice-1].getTitle() + " couldnt be played");
			}
		}


	}
	
	
	/**
	 * This creates a playlist and asks the user to put songs into the playlist
	 * @param jbox
	 * @param input
	 * @return
	 */
	private static ArrayList<AudioTrack> createPlaylist(Jukebox jbox, Scanner input) { // Finish Playlist implementation
		ArrayList<AudioTrack> playlist = new ArrayList<AudioTrack>();
		AudioTrack[] trackList = jbox.getTracks();
		int exit = trackList.length;
		
		int choice = 0;
		do {
			for(int i = 0; i < trackList.length; i++) {
				System.out.println((i+1) + ". " + trackList[i].getTitle());
			}
			
			System.out.println((exit+1) + ". Exit");
			
			System.out.println("Select a track > ");
			choice = input.nextInt();
			if(choice == exit+1) {
				break;
			}else {
				playlist.add(trackList[choice-1]);
			}
			
		}while(choice != exit+1);

		return playlist;
	}
	
	/**
	 * This displays the top 10 tracks ordered by number of plays
	 * @param jbox
	 */
	private static void displayTop10(Jukebox jbox) {
		AudioTrack[] trackList = jbox.getTracks();
		ArrayList<AudioTrack> tracksInOrder = new ArrayList<AudioTrack>();
		boolean sorted;
		
		AudioTrack temp;
		for(int i = 0; i < trackList.length; i++) {
			for(int j = 1; j < trackList.length - i; j++) {
				if(trackList[j-1].getPlays() < trackList[j].getPlays()) {
					temp = trackList[j-1];
					trackList[j - 1] = trackList[j];
					trackList[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(trackList[i].getTitle() + ", " + trackList[i].getPlays());
			
		}

	}

}
