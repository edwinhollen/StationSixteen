package com.edwinhollen.stationsixteen;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * Created by Edwin on 5/18/2015.
 */
public class GameScene extends Scene {
    private ComponentEntitySystem ces;
    public GameScene(){
        ces = new ComponentEntitySystem();

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
