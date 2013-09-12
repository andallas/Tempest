package tempest;

public class PhysicsComponent
{
    private Vector2 Position;
    private Vector2 Velocity;
    private float Mass;
    
    public PhysicsComponent(Vector2 pos, Vector2 vel, float mass)
    {
        this.Position = pos;
        this.Velocity = vel;
        this.Mass = mass;
    }
    
    public void update()
    {        
        this.Velocity.mult(0.975f);
        if((this.Velocity.X() < 0.1f && this.Velocity.X() > 0f) || (this.Velocity.X() > -0.1f && this.Velocity.X() < 0f))
            this.Velocity.X(0f);
        if((this.Velocity.Y() < 0.1f && this.Velocity.Y() > 0f) || (this.Velocity.Y() > -0.1f && this.Velocity.Y() < 0f))
            this.Velocity.Y(0f);
    }
        
    public Vector2 addImpulse(Vector2 force)
    {
        force.mult(this.Mass);
        force.mult(Clock.DELTA_TIME());
        return this.Velocity.add(force);
    }
    
    // Getters
    public Vector2 Position()
    {
        return Position;
    }
}