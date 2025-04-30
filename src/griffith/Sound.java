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
		
		soundURL[0] = getClass().getResource("/sound/intro.wav");//cpu soundtrack
		soundURL[1] = getClass().getResource("/sound/paddlebounce1.wav");//wallbounce1
		soundURL[2] = getClass().getResource("/sound/paddlebounce2.wav");//wallbounce2
		soundURL[3] = getClass().getResource("/sound/paddlebounce1.wav");//paddlebounce1
		soundURL[4] = getClass().getResource("/sound/wallbounce2.wav");//paddlebounce2
		soundURL[5] = getClass().getResource("/sound/cpusong.wav");//cpu song
		soundURL[6] = getClass().getResource("/sound/DTsong.wav"); //double trouble song
		soundURL[7] = getClass().getResource("/sound/pvp.wav"); //pvp song
		soundURL[8] = getClass().getResource("/sound/DTPVP.wav");// DT PVP song
		
	}
	
	//this method opens the audio file
	public void setFile(int i) {
	    try {
	        AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
	        clip = AudioSystem.getClip();
	        clip.open(ais);
	    } catch (Exception e) {
	        System.out.println("Error loading sound file at index " + i + ": " + soundURL[i]);
	        e.printStackTrace(); 
	    }
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
