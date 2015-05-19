package com.edwinhollen.stationsixteen;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Edwin on 5/18/2015.
 */
public class ComponentEntitySystem implements Updateable, Renderable{
    private List<System> systems = new ArrayList<>();

    private int lastEntitiesHashcode;
    private List<Entity> entities = new ArrayList<>();
    private Map<System, List<Entity>> organizedEntities = new HashMap<>();

	public ComponentEntitySystem(){
        lastEntitiesHashcode = entities.hashCode();
	}

    public void addSystem(System system){
        systems.add(system);
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

	@Override
	public void render(GameContainer gc, Graphics g) {
		organizedEntities.entrySet().parallelStream().forEach(entry -> {
            if (entry.getKey() instanceof EntitiesRenderable)
                ((EntitiesRenderable) entry.getKey()).render(entry.getValue(), gc, g);
        });
	}

	@Override
	public void update(GameContainer gc, int dt) {
        if(entities.hashCode() != lastEntitiesHashcode){
            // re-organize entities
            organizedEntities.clear();
            systems.forEach(system -> {
                organizedEntities.put(system, entities.parallelStream().filter(e -> e.getComponentsAsClasses().containsAll(system.getAcceptedComponents())).collect(Collectors.toCollection(ArrayList::new)));
            });
        }
		organizedEntities.entrySet().parallelStream().forEach(entry -> {
            if (entry.getKey() instanceof EntitiesUpdateable)
                ((EntitiesUpdateable) entry.getKey()).update(entry.getValue(), gc, dt);
        });
	}


	public static abstract class System{
        private List<Class<? extends Component>> acceptedComponents;
	    public System(){};
        protected System(List<Class<? extends Component>> acceptedComponents){
            this.acceptedComponents = acceptedComponents;
        }
        public List<Class<? extends Component>> getAcceptedComponents(){
            return this.acceptedComponents;
        }
    }

    public static abstract class Component{

    }

    public static class Entity{
        private List<Component> components = new ArrayList<>();
	    private final String id = UUID.randomUUID().toString();

        public List<Component> getComponents(){
            return this.components;
        }

        public List<Component> getComponentsByClass(Class<? extends Component> requestedClass){
            return this.components.parallelStream().filter(requestedClass::isInstance).collect(Collectors.toList());
        }

        public Component getComponentByClass(Class<? extends Component> requestedClass){
            return this.getComponentsByClass(requestedClass).get(0);
        }

        public List<Class<? extends Component>> getComponentsAsClasses(){
            List<Class<? extends Component>> returnList = new ArrayList<>();
            this.components.forEach(component -> {
	            returnList.add(component.getClass());
            });
            return returnList;
        }

	    public void addComponent(Component component){
		    this.components.add(component);
	    }

	    public String getId(){
		    return this.id;
	    }
    }
}
