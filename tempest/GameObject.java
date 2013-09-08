package tempest;

public abstract class GameObject
{
    // Attributes
    protected Vector2 Position;
    protected Vector2 Rotation;
    protected Vector2 Scale;
    
    // Utility
    abstract void update();
    abstract void fixedUpdate();
    abstract void render();
    
    // Getters
    public Vector2 Position() { return Position; }
    public Vector2 Rotation() { return Rotation; }    
    public Vector2 Scale() { return Scale; }
    
    // Setters
    public void Position(Vector2 vec) { Position = vec; }    
    public void Rotation(Vector2 vec) { Rotation = vec; }    
    public void Scale(Vector2 vec) { Scale = vec; }
}