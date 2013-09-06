package tempest;

public class Player extends Entity
{   
    private PhysicsComponent Physics;
    private Vector3 Velocity;
    
    public Player(Vector3 position, Vector3 scale, Vector3 rot)
    {
        this.Position = position;
        this.Scale = scale;
        this.Rotation = rot;
        this.Physics = new PhysicsComponent(this.Position, new Vector3(), 1f);
        this.Velocity = new Vector3();
    }
    
    @Override public void update()
    {
        if(Input.getKeyDown("W"))
        {
            this.Velocity = Physics.addForce(new Vector3(0, 10000, 0));
        }
        else if(Input.getKeyDown("S"))
        {
            this.Velocity = Physics.addForce(new Vector3(0, -10000, 0));
        }
        if(Input.getKeyDown("A"))
        {
            this.Velocity = Physics.addForce(new Vector3(-10000, 0, 0));
        }
        else if(Input.getKeyDown("D"))
        {
            this.Velocity = Physics.addForce(new Vector3(10000, 0, 0));
        }

        super.update();
    }
    
    @Override public void render()
    {
        tempest.Draw.Rect(this.Position, this.Scale, this.Rotation, new Vector3(0.8f, 0.15f, 0.0f));
    }
    
    @Override
    void move()
    {
        this.Position.add(this.Velocity.mult(Clock.DeltaTime()));
    }
}