package com.edwinhollen.stationsixteen;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.List;

/**
 * Created by Edwin on 5/18/2015.
 */
public class GameScene extends Scene {
    private ComponentEntitySystem ces;
    public GameScene(){
        ces = new ComponentEntitySystem();
		ces.addSystem(new PhysicsSystem());

	    ComponentEntitySystem.Entity e = new ComponentEntitySystem.Entity();
	    e.addComponent(new PhysicsComponent());

	    ces.addEntity(e);

    }

	@Override
	public void render(GameContainer gc, Graphics g) {
		ces.render(gc, g);
	}

	@Override
	public void update(GameContainer gc, int dt) {
		ces.update(gc, dt);
	}
}
