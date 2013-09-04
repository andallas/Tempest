package tempest;

public abstract class PhysicsComponent implements IPhysicsComponent
{
    protected Vector3 Velocity;
    protected Vector3 Acceleration;
    protected Vector3 Direction;
    
    public void move(float dirRadian)
    {
        // Find current direction vector
        this.Direction.setX(Math.cos(dirRadian));
        this.Direction.setY(Math.sin(dirRadian));
        
        // Apply forward acceleration
        this.Velocity.add(Vector3.Mult(this.Direction, this.Acceleration.getX()));
        
        // Simulate friction
        this.Velocity.mult(0.99);
    }
}