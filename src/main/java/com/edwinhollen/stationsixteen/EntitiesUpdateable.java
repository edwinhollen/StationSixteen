package com.edwinhollen.stationsixteen;

import org.newdawn.slick.GameContainer;

import java.util.List;

/**
 * Created by Edwin on 5/18/2015.
 */
public interface EntitiesUpdateable{
    void update(List<ComponentEntitySystem.Entity> entities, GameContainer gc, int dt);
}
