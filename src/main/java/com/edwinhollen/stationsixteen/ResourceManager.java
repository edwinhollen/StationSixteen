package com.edwinhollen.stationsixteen;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Edwin on 5/19/2015.
 */
public class ResourceManager {
    private static Map<String, Image> loadedImages = new HashMap<>();
    private static Map<String, Animation> loadedAnimations = new HashMap<>();

    public static Image getImage(String imageFilename){
        return loadedImages.containsKey(imageFilename) ? loadedImages.get(imageFilename) : loadImage(imageFilename);
    }

    private static Image loadImage(String imageFilename){
        try {
            loadedImages.put(imageFilename, new Image(imageFilename));
            return loadedImages.get(imageFilename);
        } catch (SlickException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Image getAnimationFrame(String animationName, int frame){
        try{
            return getImage(loadedAnimations.get(animationName).frames.get(frame));
        }catch(NullPointerException e){
            return null;
        }
    }
}
