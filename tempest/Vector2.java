package tempest;

public class Vector2
{
    // Attributes
    private float X;
    private float Y;
    
    public Vector2()
    {
        X = 0.0f;
        Y = 0.0f;
    }
    
    public Vector2(float x, float y)
    {
        X = x;
        Y = y;
    }
    
    public Vector2(int x, int y)
    {
        X = (float)x;
        Y = (float)y;
    }
    
    public Vector2(Vector2 vec)
    {
        X = vec.getX();
        Y = vec.getY();
    }
    
    // Getters
    public float getX() { return X; }
    public float getY() { return Y; }
    // Setters
    public void setX(float value)   { X = value; }
    public void setX(int value)     { X = (float)value; }
    public void setX(double value)  { X = (float)value; }
    public void setY(float value)   { Y = value; }
    public void setY(int value)     { Y = (float)value; }
    public void setY(double value)  { Y = (float)value; }
    
    // Static
    public static Vector2 Add(Vector2 left, Vector2 right)
    {
        return new Vector2(left.getX() + right.getX(),
                           left.getY() + right.getY());
    }
    
    public static Vector2 Sub(Vector2 left, Vector2 right)
    {
        return new Vector2(left.getX() - right.getX(),
                           left.getY() - right.getY());
    }
    
    public static Vector2 Mult(Vector2 left, Vector2 right)
    {
        return new Vector2(left.getX() * right.getX(),
                           left.getY() * right.getY());
    }
    
    public static Vector2 Mult(Vector2 vec, float value)
    {
        float x = vec.getX() * value;
        float y = vec.getY() * value;
        return new Vector2(x, y);
    }
    
    public static Vector2 Mult(Vector2 vec, int value)
    {
        float x = (float)(vec.getX() * value);
        float y = (float)(vec.getY() * value);
        return new Vector2(x, y);
    }
    
    public static Vector2 Mult(Vector2 vec, double value)
    {
        float x = (float)(vec.getX() * value);
        float y = (float)(vec.getY() * value);
        return new Vector2(x, y);
    }
    
    public static Vector2 Div(Vector2 left, Vector2 right)
    {
        return new Vector2(left.getX() / right.getX(),
                           left.getY() / right.getY());
    }
    
    public static Vector2 Div(Vector2 vec, float value)
    {
        float inverseValue = 1.0f / value;
        float x = (float)(vec.getX() * inverseValue);
        float y = (float)(vec.getY() * inverseValue);
        return new Vector2(x, y);
    }
    
    public static Vector2 Div(Vector2 vec, int value)
    {
        float inverseValue = (float)(1.0f / value);
        float x = (float)(vec.getX() * inverseValue);
        float y = (float)(vec.getY() * inverseValue);
        return new Vector2(x, y);
    }
    
    public static Vector2 Div(Vector2 vec, double value)
    {
        float inverseValue = (float)(1.0f / value);
        float x = (float)(vec.getX() * inverseValue);
        float y = (float)(vec.getY() * inverseValue);
        return new Vector2(x, y);
    }
    
    public static float Dot(Vector2 vec1, Vector2 vec2)
    {
        return (vec1.getX() * vec2.getX()) +
               (vec1.getY() * vec2.getY());
    }
    
    public static float Cross(Vector2 vec1, Vector2 vec2)
    {
        return (vec1.getX() * vec2.getY()) - (vec1.getY() * vec2.getX());
    }
    
    public static double Magnitude(Vector2 vec)
    {
        return Math.sqrt((vec.getX() * vec.getX()) + (vec.getY() * vec.getY()));
    }
    
    public static Vector2 Normalize(Vector2 vec)
    {
        // Multiply by the inverse length to save on divides
        double inverseLength = 1.0 / Vector2.Magnitude(vec);
        vec.setX(vec.getX() * inverseLength);
        vec.setY(vec.getY() * inverseLength);
        
        return vec;
    }
    
    public static double angle(Vector2 vec1, Vector2 vec2)
    {
        float dot = Vector2.Dot(Vector2.Normalize(vec1), Vector2.Normalize(vec2));
        return Math.acos(dot);
    }
    
    // Utility
    public Vector2 add(Vector2 vec)
    {
        X += vec.getX();
        Y += vec.getY();
        return this;
    }
    
    public Vector2 sub(Vector2 vec)
    {
        X -= vec.getX();
        Y -= vec.getY();
        return this;
    }
    
    public Vector2 mult(Vector2 vec)
    {
        X *= vec.getX();
        Y *= vec.getY();
        return this;
    }
    
    public Vector2 mult(float value)
    {
        X *= value;
        Y *= value;
        return this;
    }
    
    public Vector2 mult(int value)
    {
        X *= (float)value;
        Y *= (float)value;
        return this;
    }
    
    public Vector2 mult(double value)
    {
        X *= (float)value;
        Y *= (float)value;
        return this;
    }
    
    public Vector2 div(Vector2 vec)
    {
        X /= vec.getX();
        Y /= vec.getY();
        return this;
    }
    
    public Vector2 div(float value)
    {
        float inverseValue = 1.0f / value;
        X *= inverseValue;
        Y *= inverseValue;
        return this;
    }
    
    public Vector2 div(int value)
    {
        float inverseValue = (float)(1.0f / value);
        X *= inverseValue;
        Y *= inverseValue;
        return this;
    }
    
    public Vector2 div(double value)
    {
        float inverseValue = (float)(1.0f / value);
        X *= inverseValue;
        Y *= inverseValue;
        return this;
    }
    
    public float dot(Vector2 vec)
    {
        return (X * vec.getX()) + (Y * vec.getY());
    }
    
    public float cross(Vector2 vec)
    {
        return (X * vec.getY()) - (Y * vec.getX());
    }
    
    public double magnitude()
    {
        return Math.sqrt((X * X) + (Y * Y));
    }
    
    public void normalize()
    {
        // Multiply by the inverse length to save on divides
        double inverseLength = 1.0f / Vector2.Magnitude(this);
        X *= inverseLength;
        Y *= inverseLength;
    }
    
    public double angle(Vector2 vec)
    {
        float dot = this.dot(Vector2.Normalize(vec));
        return Math.acos(dot);
    }
    
    public String toString()
    {
        return "X: " + X + " Y: " + Y;
    }
}