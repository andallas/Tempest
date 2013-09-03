package tempest;

import java.util.ArrayList;
import org.lwjgl.opengl.Display;

public class Game
{
    private String TITLE;
    private ArrayList<GameObject> objects;
    public Clock clock;
    
    public Game()
    {
        TITLE = "Game";
        clock = new Clock();
        objects = new ArrayList<>();
        init();
    }
    
    public Game(String title)
    {
        TITLE = title;
        clock = new Clock();
        objects = new ArrayList<>();
        init();
    }
    
    public final void init()
    {
        Ball ball = new Ball(new Vector3(Display.getWidth() / 2, Display.getHeight() / 2, 0.0f));
        objects.add(ball);
    }
    
    public void getInput()
    {
        
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