package com.edwinhollen.stationsixteen;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A game using Slick2d
 */
public class Game extends BasicGame {
    public final Path CONFIG_PATH = Paths.get(System.getProperty("user.home"), ".config/", "stationsixteen");

    private ConfigLoader.Config config;
    private Scene currentScene;

    public Game() throws SlickException {
        super("A Slick2d game");
        this.config = ConfigLoader.load(Paths.get(CONFIG_PATH.toString(), "config.json"), true);

        AppGameContainer app = new AppGameContainer(this);
        app.setDisplayMode(config.resolutionX, config.resolutionY, config.fullscreen);
        app.setVSync(config.vsync);
        app.setForceExit(false);
        app.start();
    }

    public void render(GameContainer container, Graphics g) throws SlickException {
        currentScene.render(container, g);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        this.currentScene = new GameScene();
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        currentScene.update(container, delta);
    }

}
