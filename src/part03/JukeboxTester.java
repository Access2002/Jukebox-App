package part03;

import java.util.ArrayList;

import part02.*;

public class JukeboxTester {

	public static void main(String[] args) {
		testCase1();
		testCase1();
		testCase2();
		testCase3();
		testCase5();
		testCase6();
		testCase7();
		testCase8();
	}

	public static void testCase1() {
		/**
		 * Tests to see if the Jukebox adds a song to the arrayList correctly
		 */
		AudioPlayer ap = new AudioPlayer();
		Jukebox jboxTest = new Jukebox(ap);
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 2, Genre.OTHER, "mp3");
		jboxTest.addTrack(trk);
		System.out.println(jboxTest.getTrackList());
	}
	
	public static void testCase2() {
		Jukebox jboxTest = new Jukebox(new AudioPlayer());
		jboxTest.addTrack(null);
	}
	
	public static void testCase3() {
		Jukebox jboxTest = new Jukebox(new AudioPlayer());
		System.out.println(jboxTest.getTrackList());
	}
	
	public static void testCase4() {
		Jukebox jboxTest = new Jukebox(new AudioPlayer());
		System.out.println(jboxTest.getTrackList());
	}
	
	public static void testCase5() {
		AudioPlayer ap = new AudioPlayer();
		Jukebox jboxTest = new Jukebox(ap);
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 2, Genre.OTHER, "mp3");
		System.out.println(jboxTest.playTrack(trk));
	}
	
	public static void testCase6() {
		AudioPlayer ap = new AudioPlayer();
		Jukebox jboxTest = new Jukebox(ap);
		System.out.println(jboxTest.playTrack(null));
	}
	
	public static void testCase7() {
		Jukebox jboxTest = new Jukebox(new AudioPlayer());
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 2, Genre.OTHER, "mp3");
		AudioTrack trk2 = new AudioTrack("Bruce Wayne", "404Vincent", 2, Genre.OTHER, "mp3");
		AudioTrack trk3 = new AudioTrack("The Search", "NF", 2, Genre.OTHER, "mp3");
		ArrayList<AudioTrack> playlist = new ArrayList<AudioTrack>();
		
		playlist.add(trk);
		playlist.add(trk2);
		playlist.add(trk3);
		
		System.out.println(jboxTest.shuffle(playlist));
	}
	
	public static void testCase8() {
	}
	
}
