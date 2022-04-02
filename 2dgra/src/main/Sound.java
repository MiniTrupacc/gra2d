package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	Clip clip;
	URL SoundURL[] = new URL[30];
	
	public Sound() {
		SoundURL[0] = getClass().getResource("/sound/akki.wav");
		SoundURL[1] = getClass().getResource("/sound/unlock.wav");
		SoundURL[2] = getClass().getResource("/sound/coin.wav");
		SoundURL[3] = getClass().getResource("/sound/powerup.wav");
	}
	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(SoundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		}catch(Exception e) {
			
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
