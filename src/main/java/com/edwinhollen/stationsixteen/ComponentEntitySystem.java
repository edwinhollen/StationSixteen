package com.edwinhollen.stationsixteen;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Edwin on 5/18/2015.
 */
public class ComponentEntitySystem {
    private List<System> systems = new ArrayList<>();
    private List<Entity> entities = new ArrayList<>();

    private HashMap<System, List<Entity>> organizedEntities = new HashMap<>();

    public void update(GameContainer container, int delta){
        organizedEntities.clear();
        systems.forEach(system ->{
            organizedEntities.put(system, entities.parallelStream().filter(e -> e.getComponentsAsClasses().containsAll(system.acceptedComponents)).collect(Collectors.toCollection(ArrayList::new)));
        });

        organizedEntities.forEach((system, relevantEntities) -> system.update(relevantEntities, container, delta));
    }

    public void render(GameContainer container, Graphics g){
        organizedEntities.forEach((system, relevantEntities) -> system.render(relevantEntities, container, g));
    }

    public abstract class System{
        private List<Class<Component>> acceptedComponents;
        public System(List<Class<Component>> acceptedComponents){
            this.acceptedComponents = acceptedComponents;
        }
        public abstract void update(List<Entity> entities, GameContainer container, int delta);
        public abstract void render(List<Entity> entities, GameContainer container, Graphics g);
    }

    public abstract class Component{

    }

    public class Entity{
        private List<Component> components = new ArrayList<>();

        public List<Component> getComponents(){
            return this.components;
        }

        public List<Class<? extends Component>> getComponentsAsClasses(){
            List<Class<? extends Component>> returnList = new ArrayList<>();
            this.components.forEach(component -> {
                returnList.add(component.getClass());
            });
            return returnList;
        }
    }
}
