package part02;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jukebox implements IJukebox{
	
	private static ArrayList<AudioTrack> allTracks = new ArrayList<AudioTrack>();	
	private AudioPlayer player = new AudioPlayer();
	
	public Jukebox(AudioPlayer player) {
		
	}
	
	public String getTrackList() {
		/** Gets list of all tracks by the track title **/
		String output = "";
		
		if(allTracks.size() <= 0 ) {
			return null;
		}
		
		for(int i = 0; i < allTracks.size(); i++) {			
			String trackTitle = allTracks.get(i).getTitle();
			int trackCode = allTracks.get(i).trackCode;
			output += trackCode + ", " + trackTitle + ", " + allTracks.get(i).getEncoding() + System.lineSeparator();
		}
		
		return output;	
	}
	
	public boolean playTrack(AudioTrack trk) {

		if(trk == null) {
			System.out.println("That isnt a valid Track");
			return false;
		}else {
			trk.plays += 1;
			boolean trackPlayer = player.play(trk);
			if(trackPlayer == true) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public String shuffle(ArrayList<AudioTrack> list) {
		if(!list.isEmpty() || list == null) {
			int size = list.size();
			int data[] = new int[size];
			Random rand = new Random();
			
			int count = 0;
			do {
				int randNum;
				
				for(int i = 0; i < data.length; i++) {
					randNum = rand.nextInt(size - 1);
					randNum++;
					if(randNum != data[i]) {
						data[i] = randNum;
						count++;
					}
				}
			}while(count < size);

			return list.get(data[0]).getTitle();
		}else {
			return "Test";
		}
		
	}
	
	public void addTrack(AudioTrack trk) {
		boolean trackInList = true;
	
		if(trk == null) {
			System.out.println("This is not a valid track");
		}else {
			if(allTracks.isEmpty()) {
				allTracks.add(trk);
			}else {
				for(int i = 0; i < allTracks.size(); i++) {

					if(!trk.getTitle().toLowerCase().contentEquals(allTracks.get(i).getTitle().toLowerCase())) {
						trackInList = false;
					}else {
						trackInList = true;						
					}
				}
				if(trackInList == false) {
					allTracks.add(trk);
					trackInList = true;
				}
			}	
		}
	}		
	
	public AudioTrack[] getTracks() {
		AudioTrack[] trackArray = {};
		trackArray = allTracks.toArray(trackArray);
		if(trackArray != null) {
			return trackArray;
		}else {
			return null;
		}
	}
	
	

}
