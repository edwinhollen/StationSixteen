package com.edwinhollen.stationsixteen.components;

import com.edwinhollen.stationsixteen.ComponentEntitySystem;

/**
 * Created by fubar on 5/18/15.
 */
public class PhysicsComponent extends ComponentEntitySystem.Component {
	public double velocityX = 0;
	public double velocityY = 0;

	public PhysicsComponent(double velocityX, double velocityY) {
		this.velocityX = velocityX;
		this.velocityY = velocityY;
	}
}
