package tempest;

public abstract class Entity extends GameObject
{   
    protected PhysicsComponent Physics;
    
    @Override
    void update()
    {
        this.move();
    }

    @Override
    void fixedUpdate()
    {
        this.Physics.update();
    }
    
    abstract void move();
}
