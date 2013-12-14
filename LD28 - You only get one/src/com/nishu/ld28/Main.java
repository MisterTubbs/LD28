package com.nishu.ld28;

import com.nishu.ld28.game.World;
import com.nishu.ld28.utilities.Constants;
import com.nishu.utils.Color4f;
import com.nishu.utils.GameLoop;
import com.nishu.utils.Screen;
import com.nishu.utils.ScreenTools;
import com.nishu.utils.Window;

public class Main extends Screen {
	
	private GameLoop loop;
	private World game;
	
	public Main(){
		loop = new GameLoop();
		loop.setScreen(this);
		loop.start(60);
	}

	@Override
	public void init() {
		game = new World();
	}

	@Override
	public void initGL() {
		ScreenTools.renderOrtho(0, Constants.WIDTH, 0, Constants.HEIGHT);
	}

	@Override
	public void render() {
		ScreenTools.clearScreen(false, Color4f.BLACK);
		game.render();
	}

	@Override
	public void update() {
		game.update();
	}

	@Override
	public void dispose() {
		Window.dispose();
		game.dispose();
	}
	
	public static void main(String[] args){
		Window.createWindow(Constants.WIDTH, Constants.HEIGHT, "LD28 - You only get one", false);
		new Main();
	}
}
