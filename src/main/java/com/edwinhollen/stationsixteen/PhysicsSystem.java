package com.edwinhollen.stationsixteen;

import org.newdawn.slick.GameContainer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fubar on 5/18/15.
 */
public class PhysicsSystem extends ComponentEntitySystem.System implements EntitiesUpdateable {

	public PhysicsSystem() {
		super(Arrays.asList(PhysicsComponent.class));
	}

	@Override
	public void update(List<ComponentEntitySystem.Entity> entities, GameContainer gc, int dt) {

	}
}
