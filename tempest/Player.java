package tempest;

public class Player extends Entity
{   
    private Vector2 Velocity;
    
    public Player(Vector2 position, Vector2 scale, Vector2 rot)
    {
        this.Position = position;
        this.Scale = scale;
        this.Rotation = rot;
        this.Physics = new PhysicsComponent(this.Position, new Vector2(), 1.75f);
        this.Velocity = new Vector2();
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
        Draw.Rect(this.Position, this.Scale, this.Rotation, new Vector3(0.8f, 0.15f, 0.0f));
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