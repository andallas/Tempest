package tempest;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

public class Game
{
    private static Game game = new Game();
    
    private String TITLE;
    public  ArrayList<GameObject> objects;
    
    private Game()
    {}
    
    public static Game Instance()
    {
        return game;
    }
    
    public void start(String title)
    {
        TITLE = title;
        Clock.Instance().start();
        Input.Instance().start();
        objects = new ArrayList<>();
        init();
    }
    
    public final void init()
    {
        Player ball = new Player(new Vector2(Display.getWidth() / 2, Display.getHeight() / 2), new Vector2(32, 32), new Vector2(0, 0));
        objects.add(ball);
    }
    
    public void getInput()
    {
        Input.Instance().update();
    }
    
    public void update()
    {
        Clock.Instance().update();
        for(GameObject go : objects)
        {
            go.update();
            go.fixedUpdate();
        }
    }
    
    public void render()
    {
        for(GameObject go : objects)
            go.render();
    }
    
    // Getters
    public String TITLE() { return TITLE; }
    
    // Setters
    public void TITLE(String value) { TITLE = value; }
}