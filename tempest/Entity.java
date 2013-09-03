package tempest;

public abstract class Entity extends GameObject
{
    protected float MAX_SPEED;
    protected PhysicsComponent PHYSICS;
    
    @Override
    public void update()
    {
        /*
        int radianOrientation = 100;
        
        // Find current direction vector
        this.direction.setX(Math.cos(radianOrientation));
        this.direction.setY(Math.cos(radianOrientation));
        
        // Apply forward acceleration
        this.velocity.add(Vector3.Mult(this.acceleration, this.direction));
        
        // Simulate friction
        this.velocity.mult(0.99);
        
        // Update position with our new calculated values
        this.Position.add(this.velocity);
        */
    }
}