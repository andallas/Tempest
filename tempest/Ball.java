package tempest;

public class Ball extends Entity
{
    public static final Vector3 SCALE = new Vector3(32, 32, 0);
    
    public Ball(Vector3 position)
    {
        this.Position = position;
        this.Scale = SCALE;
        this.Rotation = new Vector3();
    }
    
    
    @Override public void update()
    {
        super.update();
    }
    
    @Override public void render()
    {
        super.render();
    }
}