package com.edwinhollen.stationsixteen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edwin on 5/19/2015.
 */
public class Animation {
    public final List<String> frames;
    public final boolean loop;
    public final int delay;
    public Animation(List<String> frames, int delay, boolean loop){
        this.frames = frames;
        this.delay = delay;
        this.loop = loop;
    }
}
