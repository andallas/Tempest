package tempest;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

public class Game
{
    private String TITLE;
    private ArrayList<GameObject> objects;
    private Clock clock;
    private Input input;
    
    public Game()
    {
        TITLE = "Game";
        clock = new Clock();
        input = new Input();
        objects = new ArrayList<>();
        init();
    }
    
    public Game(String title)
    {
        TITLE = title;
        clock = new Clock();
        input = new Input();
        objects = new ArrayList<>();
        init();
    }
    
    public final void init()
    {
        Player ball = new Player(new Vector3(Display.getWidth() / 2, Display.getHeight() / 2, 0.0f), new Vector3(32, 32, 0), new Vector3(0, 0, 0));
        objects.add(ball);
    }
    
    public void getInput()
    {
        input.update();
    }
    
    public void update()
    {
        clock.update();
        for(GameObject go : objects)
            go.update();
    }
    
    public void render()
    {
        for(GameObject go : objects)
            go.render();
    }
    
    // Getters
    public String getTitle() { return TITLE; }
    
    // Setters
    public void setTitle(String value) { TITLE = value; }
}