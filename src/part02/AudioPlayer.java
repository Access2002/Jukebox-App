package part02;

public class AudioPlayer implements IPlayer {

	AudioTrack currentTrack;
	
	public AudioPlayer() {
		this.currentTrack = currentTrack;
	}
	
	public boolean play(AudioTrack trk) {
		if(trk == null) {
			return false;
		}else {
			currentTrack = trk;
			return true;
		}
		
	}
}
