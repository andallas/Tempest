package com.base.game.uncategorized;

import java.util.ArrayList;

public class Game
{
    private String TITLE;
    private ArrayList<GameObject> objects;
    
    public Game()
    {
        TITLE = "Game";
        objects = new ArrayList<>();
    }
    
    public Game(String title)
    {
        TITLE = title;
        objects = new ArrayList<>();
    }
    
    public void getInput()
    {

    }
    
    public void update()
    {
        for(GameObject go : objects)
            go.update();
    }
    
    public void render()
    {
        for(GameObject go : objects)
            go.render();
    }
    
    // Getters
    public String getTitle()
    {
        return TITLE;
    }
    
    // Setters
    public void setTitle(String value)
    {
        TITLE = value;
    }
}