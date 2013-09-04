package tempest;

public class AABB extends PhysicsComponent
{
    private Vector3 Position;
    private Vector3 Scale;
    private float LastCollisionTime;
    
    public AABB()
    {
        Position = new Vector3();
        Scale = new Vector3();
        Velocity = new Vector3();
        Acceleration = new Vector3(1.0f, 1.0f, 0.0f);
        Direction = new Vector3();
        LastCollisionTime = 0.0f;
    }
    
    @Override
    public boolean CheckCollision(IPhysicsComponent obj)
    {
        Vector3 norm = new Vector3();
        LastCollisionTime = SweptAABB(this, (AABB)obj, norm);
        return LastCollisionTime <= 0.0f || LastCollisionTime >= 1.0f ? false : true;
    }
    
    private float SweptAABB(AABB obj1, AABB obj2, Vector3 normal)
    {
        Vector3 InvEntry = new Vector3();
        Vector3 InvExit = new Vector3();
        
        // Find the distance between the objects on the near and far sides for both x and y
        if(obj1.Velocity.getX() > 0.0f)
        {
            InvEntry.setX(obj2.Position.getX() - (obj1.Position.getX() + obj1.Scale.getX()));
            InvExit.setX((obj2.Position.getX() + obj2.Scale.getX()) - obj1.Position.getX());
        }
        else
        {
            InvEntry.setX((obj2.Position.getX() + obj2.Scale.getX()) - obj1.Position.getX());
            InvExit.setX(obj2.Position.getX() - (obj1.Position.getX() + obj1.Scale.getX()));
        }
        
        if(obj1.Velocity.getY() > 0.0f)
        {
            InvEntry.setY(obj2.Position.getY() - (obj1.Position.getY() + obj1.Scale.getY()));
            InvExit.setY((obj2.Position.getY() + obj2.Scale.getY()) - obj1.Position.getY());
        }
        else
        {
            InvEntry.setY((obj2.Position.getY() + obj2.Scale.getY()) - obj1.Position.getY());
            InvExit.setY(obj2.Position.getY() - (obj1.Position.getY() + obj1.Scale.getY()));
        }
        
        // Find time of collision and time of leaving for each axis (if statement is to prevent divide by zero)
        Vector3 Entry = new Vector3();
        Vector3 Exit = new Vector3();
        
        if(obj1.Velocity.getX() == 0.0f)
        {
            Entry.setX(Float.MIN_VALUE);
            Exit.setX(Float.MAX_VALUE);
        }
        else
        {
            Entry.setX(InvEntry.getX() / obj1.Velocity.getX());
            Exit.setX(InvExit.getX() / obj1.Velocity.getX());
        }
        
        if(obj1.Velocity.getY() == 0.0f)
        {
            Entry.setY(Float.MIN_VALUE);
            Exit.setY(Float.MAX_VALUE);
        }
        else
        {
            Entry.setY(InvEntry.getY() / obj1.Velocity.getY());
            Exit.setY(InvExit.getY() / obj1.Velocity.getY());
        }
        
        // Find the earliest and latest times of collision
        float entryTime = Math.max(Entry.getX(), Entry.getY());
        float exitTime = Math.min(Exit.getX(), Exit.getY());
        
        // If there was no collision
        if(entryTime > exitTime || Entry.getX() < 0.0f && Entry.getY() < 0.0f || Entry.getX() > 1.0f || Entry.getY() > 1.0f)
        {
            normal.setX(0.0f);
            normal.setY(0.0f);
            return 1.0f;
        }
        // If there was a collision
        else
        {
            // Calculate normal of collided surface
            if(Entry.getX() > Entry.getY())
            {
                if(InvEntry.getX() < 0.0f)
                {
                    normal.setX(1.0f);
                    normal.setY(0.0f);
                }
                else
                {
                    normal.setX(-1.0f);
                    normal.setY(0.0f);
                }
            }
            else
            {
                if(InvEntry.getY() < 0.0f)
                {
                    normal.setX(0.0f);
                    normal.setY(1.0f);
                }
                else
                {
                    normal.setX(0.0f);
                    normal.setY(-1.0f);
                }
            }
            // Return the time of collision
            return entryTime;
        }
    }
    
    // Getters
    public float ColTime()
    {
        return LastCollisionTime;
    }
}