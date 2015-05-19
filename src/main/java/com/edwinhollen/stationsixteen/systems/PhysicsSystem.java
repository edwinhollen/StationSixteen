package com.edwinhollen.stationsixteen.systems;

import com.edwinhollen.stationsixteen.ComponentEntitySystem;
import com.edwinhollen.stationsixteen.EntitiesUpdateable;
import com.edwinhollen.stationsixteen.components.PhysicsComponent;
import com.edwinhollen.stationsixteen.components.PositionComponent;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fubar on 5/18/15.
 */
public class PhysicsSystem extends ComponentEntitySystem.System {

	public PhysicsSystem() {
		super(Arrays.asList(
				PhysicsComponent.class,
				PositionComponent.class
		));
	}

	@Override
	public void update(List<ComponentEntitySystem.Entity> entities, GameContainer gc, int dt) {
		entities.parallelStream().forEach(entity ->{
			PhysicsComponent phys = (PhysicsComponent) entity.getComponentByClass(PhysicsComponent.class);
			PositionComponent pos = (PositionComponent) entity.getComponentByClass(PositionComponent.class);

			pos.x += (phys.velocityX * dt);
			pos.y += (phys.velocityY * dt);
		});
	}

	@Override
	public void render(List<ComponentEntitySystem.Entity> entities, GameContainer gc, Graphics g) {

	}
}
