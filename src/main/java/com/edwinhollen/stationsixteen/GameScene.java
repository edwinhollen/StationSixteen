package com.edwinhollen.stationsixteen;

import com.edwinhollen.stationsixteen.components.AnimationComponent;
import com.edwinhollen.stationsixteen.components.ImageComponent;
import com.edwinhollen.stationsixteen.components.PhysicsComponent;
import com.edwinhollen.stationsixteen.components.PositionComponent;
import com.edwinhollen.stationsixteen.systems.PhysicsSystem;
import com.edwinhollen.stationsixteen.systems.RenderSystem;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * Created by Edwin on 5/18/2015.
 */
public class GameScene extends Scene {
    private ComponentEntitySystem ces;
    public GameScene(){
        ces = new ComponentEntitySystem();
		ces.addSystem(new PhysicsSystem());
		ces.addSystem(new RenderSystem());

		for(int i = 0; i < 100; i++){
			ComponentEntitySystem.Entity e = new ComponentEntitySystem.Entity();
			e.addComponent(new PositionComponent());
			e.addComponent(new PhysicsComponent(Math.random()*0.02, Math.random()*0.02));
			e.addComponent(new ImageComponent("character_idle.png"));
			ces.addEntity(e);
		}

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
