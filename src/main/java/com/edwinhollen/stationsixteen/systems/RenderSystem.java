package com.edwinhollen.stationsixteen.systems;

import com.edwinhollen.stationsixteen.ComponentEntitySystem;
import com.edwinhollen.stationsixteen.EntitiesRenderable;
import com.edwinhollen.stationsixteen.ResourceManager;
import com.edwinhollen.stationsixteen.components.AnimationComponent;
import com.edwinhollen.stationsixteen.components.ImageComponent;
import com.edwinhollen.stationsixteen.components.PositionComponent;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Edwin on 5/19/2015.
 */
public class RenderSystem extends ComponentEntitySystem.System {
    public RenderSystem(){
        super(Arrays.asList(
                PositionComponent.class
        ));
    }
    @Override
    public void render(List<ComponentEntitySystem.Entity> entities, GameContainer gc, Graphics g) {
        entities.stream().forEach(entity ->{
            PositionComponent pos = (PositionComponent) entity.getComponentByClass(PositionComponent.class);
            Image imageToDraw = null;
            try{
                ImageComponent ic = (ImageComponent) entity.getComponentByClass(ImageComponent.class);
                imageToDraw = ResourceManager.getImage(ic.imageName);
            }catch(IndexOutOfBoundsException ignored){}
            try{
                AnimationComponent ac = (AnimationComponent) entity.getComponentByClass(AnimationComponent.class);
                imageToDraw = ResourceManager.getAnimationFrame(ac.animationName, ac.currentFrame);
            }catch(IndexOutOfBoundsException ignored){}

            if(Objects.isNull(imageToDraw)) return;

            try{
	            g.drawImage(imageToDraw, Math.round(pos.x), Math.round(pos.y));
            }catch(RuntimeException ignore){

            }
        });
    }

	@Override
	public void update(List<ComponentEntitySystem.Entity> entities, GameContainer gc, int dt) {

	}
}
