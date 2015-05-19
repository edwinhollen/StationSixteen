package com.edwinhollen.stationsixteen.components;

import com.edwinhollen.stationsixteen.ComponentEntitySystem;

/**
 * Created by Edwin on 5/19/2015.
 */
public class ImageComponent extends ComponentEntitySystem.Component {
    public String imageName = null;
    public ImageComponent(String imageName){
        this.imageName = imageName;
    }
}
