package tempest;

import org.lwjgl.opengl.Display;

public class Ball extends GameObject
{   
    public Ball()
    {
        this.Position = new Vector3(Display.getWidth() / 2, Display.getHeight() / 2, 0.0f);
        this.Scale = new Vector3(32, 32, 0);
        this.Rotation = new Vector3();
    }

    public Ball(Vector3 position, Vector3 scale, Vector3 rot)
    {
        this.Position = position;
        this.Scale = scale;
        this.Rotation = rot;
    }
    
    @Override public void update()
    {
        
    }
    
    @Override public void render()
    {
        tempest.Draw.Rect(this.Position, this.Scale, this.Rotation, new Vector3(0.8f, 0.15f, 0.0f));
    }
}