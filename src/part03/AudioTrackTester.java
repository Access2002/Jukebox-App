package part03;

import part02.AudioTrack;
import part02.Genre;

public class AudioTrackTester {

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
		testCase4();
		testCase7();
		testCase8();
		testCase9();
		testCase10();
		testCase11();
		testCase12();
		testCase13();
	}
	
	public static void testCase1() {
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 3, Genre.OTHER, "mp3");
		System.out.println(trk.getDetails());
	}
	
	public static void testCase2() {
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 3, Genre.OTHER, "mp3");
		System.out.println(trk.getTitle());
	}
	public static void testCase3() {
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 3, Genre.OTHER, "mp3");
		System.out.println(trk.getArtist());
	}
	public static void testCase4() {
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 3, Genre.OTHER, "mp3");
		System.out.println(trk.getDuration());
	}
	public static void testCase5() {
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 3, Genre.OTHER, "mp3");
		System.out.println(trk.getEncoding());
	}
	public static void testCase6() {
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 3, Genre.OTHER, "mp3");
		System.out.println(trk.getStyle());
	}
	public static void testCase7() {
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 3, Genre.OTHER, "mp3");
		System.out.println(trk.getPlays());
	}
	
	public static void testCase8() {
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 3, Genre.OTHER, "mp3");
		System.out.println(trk.setTitle("Bruce Wayne"));
	}
	
	public static void testCase9() {
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 3, Genre.OTHER, "mp3");
		System.out.println(trk.setArtist("404Vincent"));
	}
	
	public static void testCase10() {
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 3, Genre.OTHER, "mp3");
		System.out.println(trk.setDuration(4));
	}
	
	public static void testCase11() {
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 3, Genre.OTHER, "mp3");
		System.out.println(trk.setStyle(Genre.CLASSICAL));
	}
	
	public static void testCase12() {
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 3, Genre.OTHER, "mp3");
		System.out.println(trk.setEncoding("wav"));
	}
	
	public static void testCase13() {
		AudioTrack trk = new AudioTrack("Perfect", "Logic", 3, Genre.OTHER, "mp3");
		System.out.println(trk.trackCode());
	}
	

}
