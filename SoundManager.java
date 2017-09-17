package com.Tetris.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

// Stores/ plays the music
public class SoundManager {
	public static Music background;
	
	public static void create(){
		background = Gdx.audio.newMusic(Gdx.files.internal("[Royalty Free Music] Wolf - Upbeat 8-bit Electronic.mp3"));
		
	}
	public static void dispose(){
		background.dispose();
	}
}
