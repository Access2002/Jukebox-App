package part02;

public class MP3Player extends AudioPlayer{

	@Override
	public boolean play(AudioTrack trk) {
		if(trk.getEncoding() == "mp3") {
			return true;
			
		}else {
			return false;
		}
		
	}
	
}
