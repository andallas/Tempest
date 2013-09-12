package tempest;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.opengl.Texture;

public class Player extends Entity
{   
    private Vector2 Velocity;
    private Texture texture;
    
    public Player(Vector2 position, Vector2 scale, Vector2 rot)
    {
        this.Position = position;
        this.Scale = scale;
        this.Rotation = rot;
        this.Physics = new PhysicsComponent(this.Position, new Vector2(), 1.75f);
        this.Velocity = new Vector2();
        try
        {
            this.texture = AssetManager.Instance().Texture("Player_00.png");
        }
        catch(IOException ex)
        {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override public void update()
    {
        if(Input.getKeyDown("W"))
        {
            this.Velocity.set(Physics.addImpulse(new Vector2(0f, 10f)));
        }
        else if(Input.getKeyDown("S"))
        {
            this.Velocity.set(Physics.addImpulse(new Vector2(0f, -10f)));
        }
        if(Input.getKeyDown("A"))
        {
            this.Velocity.set(Physics.addImpulse(new Vector2(-10f, 0f)));
        }
        else if(Input.getKeyDown("D"))
        {
            this.Velocity.set(Physics.addImpulse(new Vector2(10f, 0f)));
        }
        
        super.update();
    }
    
    @Override public void render()
    {
        //Draw.Rect(this.Position, this.Scale, this.Rotation, new Vector3(0.8f, 0.15f, 0.0f));
        Draw.Rect(this.Position, this.Scale, texture);
    }
    
    @Override
    void move()
    {
        this.Position.add(this.Velocity);
        this.Velocity.mult(0.975f);
        if((this.Velocity.X() < 0.1f && this.Velocity.X() > 0f) || (this.Velocity.X() > -0.1f && this.Velocity.X() < 0f))
            this.Velocity.X(0f);
        if((this.Velocity.Y() < 0.1f && this.Velocity.Y() > 0f) || (this.Velocity.Y() > -0.1f && this.Velocity.Y() < 0f))
            this.Velocity.Y(0f);
    }
}