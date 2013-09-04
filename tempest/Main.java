package tempest;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class Main
{
    public enum Context
    {
        GL_2D,
        GL_3D
    };
    
    public static String TITLE = "Tempest v0.0.1";
    private static Game game;
    
    public static void main(String[] args)
    {
        // Initialization
        initDisplay();
        initGL(GL_2D);
        initGame();
        
        // Loop
        gameLoop();
        
        // Clean up
        cleanUp();
    }
    
    private static void initGame()
    {
        game = new Game(TITLE);
    }
    
    private static void gameLoop()
    {
        while(!Display.isCloseRequested())
        {
            getInput();
            update();
            render();
        }
    }
    
    private static void getInput()
    {
        game.getInput();
    }
    
    private static void update()
    {
        game.update();
    }
    
    private static void render()
    {
        glClear(GL_COLOR_BUFFER_BIT);
        
        game.render();

        Display.update();
        Display.sync(60);
    }
    
    private static void initGL(int context)
    {
        switch(context)
        {
            case GL_2D:
                glMatrixMode(GL_PROJECTION);
                glLoadIdentity();
                
                // Set the view frustrum
                glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
                
                glMatrixMode(GL_MODELVIEW);
                
                // Set the background color
                glClearColor(0, 0.529f, 0.8f, 1);
                
                glDisable(GL_DEPTH_TEST);
            break;
            case GL_3D:
                System.out.println("No 3D context yet");
            break;
        }
    }
    
    private static void initDisplay()
    {
        try
        {
            Display.setDisplayMode(new DisplayMode(640, 480));
            Display.setTitle(TITLE);
            Display.create();
            Display.setVSyncEnabled(true);
            Keyboard.create();
        }
        catch (LWJGLException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void cleanUp()
    {
        Display.destroy();
        Keyboard.destroy();
    }
}