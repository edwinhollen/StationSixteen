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
public class ComponentEntitySystem implements Updateable, Renderable{
    private List<System> systems = new ArrayList<>();
    private List<Entity> entities = new ArrayList<>();

    private HashMap<System, List<Entity>> organizedEntities = new HashMap<>();

    @Override
    public void render(GameContainer gc, Graphics g) {
        organizedEntities.forEach((system, relevantEntities) -> system.render(relevantEntities, gc, g));
    }

    @Override
    public void update(GameContainer gc, int dt) {
        organizedEntities.clear();
        systems.forEach(system ->{
            organizedEntities.put(system, entities.parallelStream().filter(e -> e.getComponentsAsClasses().containsAll(system.acceptedComponents)).collect(Collectors.toCollection(ArrayList::new)));
        });
        organizedEntities.forEach((system, relevantEntities) -> system.update(relevantEntities, gc, dt));
    }

    public void addSystem(System system){
        systems.add(system);
    }

    public void addEntity(Entity e){
        entities.add(e);
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
