package griffith;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	Clip clip;
	
	URL soundURL[] = new URL [30];
	
	//constructor for url's
	public Sound(){
		
		soundURL[0] = getClass().getResource("/intro.wav");//intro soundtrack
		soundURL[1] = getClass().getResource("/wallbounce1.wav");//wallbounce1
		soundURL[2] = getClass().getResource("/wallbounce2.wav");//wallbounce2
		soundURL[3] = getClass().getResource("/paddlebounce1.wav");//paddlebounce1
		soundURL[4] = getClass().getResource("/paddlebounce2.wav");//paddlebounce2
		soundURL[5] = getClass().getResource("/cpusong.wav");//cpu song
		soundURL[6] = getClass().getResource("/DTsong.wav"); //double trouble song
		soundURL[7] = getClass().getResource("/pvp.wav"); //pvp song
		
	}
	
	//this method opens the audio file
	public void setFile(int i) {
		
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			
			clip = AudioSystem.getClip();
			
			clip.open(ais);
		}
		
		catch(Exception e){}
		
	}
	
	public void play() {
		clip.start();
	}
	
	public void loop() {
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);	
	}
	
	public void stop() {
		clip.stop();
	}
	
}
