package com.edwinhollen.stationsixteen;

import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Edwin on 5/18/2015.
 */
public class ConfigLoader {
    public static Config load(Path configPath, boolean clean){
        if(clean) try {
            Files.deleteIfExists(configPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!Files.exists(configPath)) try {
            configPath.toFile().getParentFile().mkdirs();
            Files.createFile(configPath);
            FileOutputStream out = new FileOutputStream(configPath.toFile());
            OutputStreamWriter outWriter = new OutputStreamWriter(out);
            outWriter.append((new Gson()).toJson(new Config()));
            outWriter.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read
        try {
            return (new Gson()).fromJson(new String(Files.readAllBytes(configPath)), Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Config();
    }

    public static void clean(Path configPath){

    }

    public static class Config{
        public int resolutionX = 800;
        public int resolutionY = 600;
        public boolean vsync = false;
        public boolean fullscreen = false;
    }
}
