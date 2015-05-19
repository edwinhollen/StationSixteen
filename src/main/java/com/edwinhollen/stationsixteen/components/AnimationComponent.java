package com.edwinhollen.stationsixteen.components;

import com.edwinhollen.stationsixteen.ComponentEntitySystem;

import java.time.Instant;

/**
 * Created by Edwin on 5/19/2015.
 */
public class AnimationComponent extends ComponentEntitySystem.Component {
    public String animationName = null;
    public int currentFrame;
    public long lastFrame = Instant.now().toEpochMilli();
    public AnimationComponent(String animationName){
        this.animationName = animationName;
    }
}
