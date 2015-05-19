package com.edwinhollen.stationsixteen;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.List;

/**
 * Created by Edwin on 5/18/2015.
 */
public interface EntitiesRenderable {
    void render(List<ComponentEntitySystem.Entity> entities, GameContainer gc, Graphics g);
}
