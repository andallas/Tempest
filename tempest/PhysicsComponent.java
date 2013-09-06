package tempest;

public class PhysicsComponent
{
    private Vector3 Position;
    private Vector3 Velocity;
    private float Mass;
    
    public PhysicsComponent(Vector3 pos, Vector3 vel, float mass)
    {
        this.Position = pos;
        this.Velocity = vel;
        this.Mass = mass;
    }
    
    public Vector3 addForce(Vector3 force)
    {
        force.mult(this.Mass);
        force.mult(Clock.DeltaTime());
        return this.Velocity.add(force);
    }
    
    // Getters
    public Vector3 getPosition()
    {
        return Position;
    }

    // Setters
}
