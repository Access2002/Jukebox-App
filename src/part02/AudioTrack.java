package part02;

public class AudioTrack implements ITrack{
	int trackCode;
	static int nextCode = 1;
	int plays;
	int duration;
	
	String title;
	String artist;
	String encoding;
	
	Genre style; 
	
	public AudioTrack(String title, String artist, int duration, Genre style, String encoding) {
		this.title = title;
		this.artist = artist;
		this.duration = duration;
		this.style = style;
		this.encoding = encoding;
		this.trackCode = useNextCode();
		this.plays = plays;
	}
	
	private int useNextCode() {
		trackCode = nextCode;
		nextCode++;
		return trackCode;
		
	}
	
	// Getters
	
	public String getDetails() {
		return this.title + System.lineSeparator() + this.trackCode + System.lineSeparator()
		+ this.artist + System.lineSeparator() + this.duration + " Minutes" + System.lineSeparator()
		+ this.style + System.lineSeparator() + this.encoding;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public String getStyle() {
		return style.name();
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public int getPlays() {
		return plays;
	}
	
	public int trackCode() {
		return trackCode;
	}
	
	// Setters
	
	public String setTitle(String title) {
		return this.title = title;
	}
	
	public String setArtist(String artist) {
		return this.artist = artist;
	}
	
	public int setDuration(int duration) {
		return this.duration = duration;
	}
	
	public Genre setStyle(Genre style) {
		return this.style = style;
	}
	
	public String setEncoding(String encoding) {
		return this.encoding = encoding;
	}
	
	public int setPlays(int plays) {
		return this.plays = plays;
	}
	
	
}
