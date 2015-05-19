package com.edwinhollen.stationsixteen;

import com.edwinhollen.stationsixteen.components.PhysicsComponent;
import com.edwinhollen.stationsixteen.components.PositionComponent;
import org.newdawn.slick.GameContainer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fubar on 5/18/15.
 */
public class PhysicsSystem extends ComponentEntitySystem.System implements EntitiesUpdateable {

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

			pos.x += phys.velocityX;
			pos.y += phys.velocityY;
		});
	}
}
