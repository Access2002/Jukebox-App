package part02;

public class WavPlayer extends AudioPlayer{
	
	@Override
	public boolean play(AudioTrack trk) {
		if(trk.getEncoding().toLowerCase() == "wav") {
			return true;
		}else {
			return false;
		}
	}
}
