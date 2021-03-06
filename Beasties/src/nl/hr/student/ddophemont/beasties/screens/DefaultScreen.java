package nl.hr.student.ddophemont.beasties.screens;

import java.util.ArrayList;

import nl.hr.student.ddophemont.beasties.IGameObject;
import nl.hr.student.ddophemont.beasties.IUpdatable;
import nl.hr.student.ddophemont.beasties.Beasties;
import nl.hr.student.ddophemont.beasties.beasts.Beast;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector3;

public abstract class DefaultScreen implements Screen, InputProcessor, IUpdatable {

	protected Game game;
	protected Vector3 touchPoint;
	
	protected ArrayList<IGameObject> gameObjects;
	
	public DefaultScreen( Game game ) {
		this.game = game;
		this.touchPoint = new Vector3();
		
		gameObjects = new ArrayList<IGameObject>();
		Gdx.input.setInputProcessor( this );
	}
	
	public void render(float delta) {
		Gdx.gl.glClearColor( 0, 0, 0, 1 );
		Gdx.gl.glClear( GL10.GL_COLOR_BUFFER_BIT );
		Beasties.camera.update();
	    Beasties.spriteBatch.setProjectionMatrix(Beasties.camera.combined);
		
		Beasties.spriteBatch.begin();
		for ( int i = 0; i < gameObjects.size(); i++ ) { 
			gameObjects.get(i).draw( delta );
			gameObjects.get(i).update( delta );
		}
		Beasties.spriteBatch.end();
	}

	@Override
	public void update( float delta ) {
		// Do nothing
	}

	@Override
	public void resize( int width, int height ) {
		
	}

	
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	
	public void addGameObject( ArrayList<IGameObject> gameObjects ) {
		for ( IGameObject go : gameObjects ) {
			this.gameObjects.add( go );
		}
	}
	
	public void addGameObject( IGameObject gameObject ) {
		this.gameObjects.add( gameObject );
	}
	
	public void removeGameObject( IGameObject gameObject ) {
		this.gameObjects.remove( gameObject );
	}
	
	public IGameObject getFirstGameObject( String nameSuperClass ) {
		for ( IGameObject g : gameObjects ) {
			if ( nameSuperClass.equals( g.getClass().getSuperclass().getSimpleName() ) ) {
				return g;
			}
		}
		return null;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchMoved(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
