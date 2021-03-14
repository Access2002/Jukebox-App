package part01;

import java.util.ArrayList;

public interface IJukebox {
	public String getTrackList();
	public boolean playTrack(AudioTrack trk);
	public String shuffle(ArrayList<AudioTrack> list);
	public void addTrack(AudioTrack trk);
	public AudioTrack[] getTracks();
}
