package tempest;

public abstract class PhysicsComponent implements IPhysicsComponent
{
    protected Vector3 Velocity;
    protected Vector3 Acceleration;
    protected Vector3 Direction;
    
    public void move(int dirRadian)
    {
        // Find current direction vector
        this.Direction.setX(Math.cos(dirRadian));
        this.Direction.setY(Math.cos(dirRadian));
        
        // Apply forward acceleration
        this.Velocity.add(Vector3.Mult(this.Acceleration, this.Direction));
        
        // Simulate friction
        this.Velocity.mult(0.99);
    }
}