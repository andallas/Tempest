package tempest;

public abstract class Entity extends GameObject
{   
    @Override
    void update()
    {
        this.move();
    }

    abstract void move();
}
