package tempest;

import org.lwjgl.opengl.Display;

public class Ball extends Entity
{   
    public Ball()
    {
        this.Position = new Vector3(Display.getWidth() / 2, Display.getHeight() / 2, 0.0f);
        this.Scale = new Vector3(32, 32, 0);
        this.Rotation = new Vector3();
        this.PHYSICS = new AABB();
    }
    
    public Ball(Vector3 position)
    {
        this.Position = position;
        this.Scale = new Vector3(32, 32, 0);
        this.Rotation = new Vector3();
        this.PHYSICS = new AABB();
    }
    
    public Ball(Vector3 position, Vector3 scale)
    {
        this.Position = position;
        this.Scale = scale;
        this.Rotation = new Vector3();
        this.PHYSICS = new AABB();
    }
    
    
    @Override public void update()
    {
        if(Input.getKeyDown("A"))
            System.out.println("A Down");
        if(Input.getKeyUp("A"))
            System.out.println("A Release");
        if(Input.getKeyHeld("A"))
            System.out.println("A Held");

        float radianOrientation = 0.5f;
        PHYSICS.move(radianOrientation);
        this.Position.add(Vector3.Mult(PHYSICS.Velocity, Clock.DeltaTime()));
    }
    
    @Override public void render()
    {
        tempest.Draw.Rect(this.Position, this.Scale, this.Rotation, new Vector3(0.8f, 0.15f, 0.0f));
    }
}