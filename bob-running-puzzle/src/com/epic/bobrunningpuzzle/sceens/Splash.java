package com.epic.bobrunningpuzzle.sceens;

import com.epic.bobrunningpuzzle.BobRunningPuzzle;
import com.epic.bobrunningpuzzle.tween.SpriteAccessar;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GwtModuleGenerator;


public class Splash implements Screen{

	private SpriteBatch batch;
	private Sprite splash;
	private TweenManager tweenManager;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		tweenManager.update(delta);
		
		batch.begin();
		splash.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		tweenManager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteAccessar());
		
		Texture splashTexture= new Texture("img/splash.png"); //Texture splashTexture= new Texture(Gdx.files.internal("img/splash.png"));
		splash = new Sprite(splashTexture);
		splash.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		
		Tween.set(splash, SpriteAccessar.ALPHA).target(0).start(tweenManager); //<=> .start()
		//Tween.to(splash, SpriteAccessar.ALPHA, 2).target(1).start(tweenManager);
		//Tween.to(splash, SpriteAccessar.ALPHA, 2).target(0).delay(3).start(tweenManager);
		Tween.to(splash, SpriteAccessar.ALPHA, 2).target(1).repeatYoyo(1, 2).setCallback(new TweenCallback() {
			@Override
			public void onEvent(int type, BaseTween<?> source) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
				
			}
		}).start(tweenManager);

	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		batch.dispose();
		splash.getTexture().dispose(); //FIXME isto devia ficar aqui? ou o spash devia ter um metudo dispose?
	}

}
