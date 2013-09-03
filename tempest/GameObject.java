package tempest;

public abstract class GameObject
{
    // Attributes
    protected Vector3 Position;
    protected Vector3 Rotation;
    protected Vector3 Scale;
    
    // Utility
    abstract void update();
    abstract void render();
    
    // Getters
    public Vector3 position() { return Position; }
    public Vector3 rotation() { return Rotation; }    
    public Vector3 scale() { return Scale; }
    
    // Setters
    public void position(Vector3 vec) { Position = vec; }    
    public void rotation(Vector3 vec) { Rotation = vec; }    
    public void scale(Vector3 vec) { Scale = vec; }
}