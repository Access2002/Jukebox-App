package part01;

public class AudioPlayer implements IPlayer {

	public AudioPlayer() {
		
	}
	
	public boolean play(AudioTrack trk) {
		if(trk == null) {
			return false;
		}else {
			return true;
		}
		
	}
}
