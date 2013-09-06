package tempest;

public class Vector4
{
    // Attributes
    private float X;
    private float Y;
    private float Z;
    private float W;
    
    public Vector4()
    {
        X = 0.0f;
        Y = 0.0f;
        Z = 0.0f;
        W = 0.0f;
    }
    
    public Vector4(float x, float y, float z, float w)
    {
        X = x;
        Y = y;
        Z = z;
        W = w;
    }
    
    public Vector4(int x, int y, int z, int w)
    {
        X = (float)x;
        Y = (float)y;
        Z = (float)z;
        W = (float)w;
    }
    
    public Vector4(Vector4 vec)
    {
        X = vec.getX();
        Y = vec.getY();
        Z = vec.getZ();
        W = vec.getW();
    }
    
    // Getters
    public float getX() { return X; }
    public float getY() { return Y; }
    public float getZ() { return Z; }
    public float getW() { return W; }
    // Setters
    public void setX(float value)   { X = value; }
    public void setX(int value)     { X = (float)value; }
    public void setX(double value)  { X = (float)value; }
    public void setY(float value)   { Y = value; }
    public void setY(int value)     { Y = (float)value; }
    public void setY(double value)  { Y = (float)value; }
    public void setZ(float value)   { Z = value; }
    public void setZ(int value)     { Z = (float)value; }
    public void setZ(double value)  { Z = (float)value; }
    public void setW(float value)   { W = value; }
    public void setW(int value)     { W = (float)value; }
    public void setW(double value)  { W = (float)value; }
    
    // Static
    public static Vector4 Add(Vector4 left, Vector4 right)
    {
        return new Vector4(left.getX() + right.getX(),
                           left.getY() + right.getY(),
                           left.getZ() + right.getZ(),
                           left.getW() + right.getW());
    }
    
    public static Vector4 Sub(Vector4 left, Vector4 right)
    {
        return new Vector4(left.getX() - right.getX(),
                           left.getY() - right.getY(),
                           left.getZ() - right.getZ(),
                           left.getW() - right.getW());
    }
    
    public static Vector4 Mult(Vector4 left, Vector4 right)
    {
        return new Vector4(left.getX() * right.getX(),
                           left.getY() * right.getY(),
                           left.getZ() * right.getZ(),
                           left.getW() * right.getW());
    }
    
    public static Vector4 Mult(Vector4 vec, float value)
    {
        float x = vec.getX() * value;
        float y = vec.getY() * value;
        float z = vec.getZ() * value;
        float w = vec.getW() * value;
        return new Vector4(x, y, z, w);
    }
    
    public static Vector4 Mult(Vector4 vec, int value)
    {
        float x = (float)(vec.getX() * value);
        float y = (float)(vec.getY() * value);
        float z = (float)(vec.getZ() * value);
        float w = (float)(vec.getW() * value);
        return new Vector4(x, y, z, w);
    }
    
    public static Vector4 Mult(Vector4 vec, double value)
    {
        float x = (float)(vec.getX() * value);
        float y = (float)(vec.getY() * value);
        float z = (float)(vec.getZ() * value);
        float w = (float)(vec.getW() * value);
        return new Vector4(x, y, z, w);
    }
    
    public static Vector4 Div(Vector4 left, Vector4 right)
    {
        return new Vector4(left.getX() / right.getX(),
                           left.getY() / right.getY(),
                           left.getZ() / right.getZ(),
                           left.getW() / right.getW());
    }
    
    public static Vector4 Div(Vector4 vec, float value)
    {
        float inverseValue = 1.0f / value;
        float x = (float)(vec.getX() * inverseValue);
        float y = (float)(vec.getY() * inverseValue);
        float z = (float)(vec.getZ() * inverseValue);
        float w = (float)(vec.getW() * inverseValue);
        return new Vector4(x, y, z, w);
    }
    
    public static Vector4 Div(Vector4 vec, int value)
    {
        float inverseValue = (float)(1.0f / value);
        float x = (float)(vec.getX() * inverseValue);
        float y = (float)(vec.getY() * inverseValue);
        float z = (float)(vec.getZ() * inverseValue);
        float w = (float)(vec.getW() * inverseValue);
        return new Vector4(x, y, z, w);
    }
    
    public static Vector4 Div(Vector4 vec, double value)
    {
        float inverseValue = (float)(1.0f / value);
        float x = (float)(vec.getX() * inverseValue);
        float y = (float)(vec.getY() * inverseValue);
        float z = (float)(vec.getZ() * inverseValue);
        float w = (float)(vec.getW() * inverseValue);
        return new Vector4(x, y, z, w);
    }
    
    public static float Dot(Vector4 vec1, Vector4 vec2)
    {
        return (vec1.getX() * vec2.getX()) +
               (vec1.getY() * vec2.getY()) +
               (vec1.getZ() * vec2.getZ()) +
               (vec1.getW() * vec2.getW());
    }
    
    public static double Magnitude(Vector4 vec)
    {
        return Math.sqrt((vec.getX() * vec.getX()) + (vec.getY() * vec.getY()) + (vec.getZ() * vec.getZ()) + (vec.getW() * vec.getW()));
    }
    
    public static Vector4 Normalize(Vector4 vec)
    {
        // Multiply by the inverse length to save on divides
        double inverseLength = 1.0 / Vector4.Magnitude(vec);
        vec.setX(vec.getX() * inverseLength);
        vec.setY(vec.getY() * inverseLength);
        vec.setZ(vec.getZ() * inverseLength);
        vec.setW(vec.getW() * inverseLength);
        
        return vec;
    }
    
    public static double angle(Vector4 vec1, Vector4 vec2)
    {
        float dot = Vector4.Dot(Vector4.Normalize(vec1), Vector4.Normalize(vec2));
        return Math.acos(dot);
    }
    
    // Utility
    public Vector4 add(Vector4 vec)
    {
        X += vec.getX();
        Y += vec.getY();
        Z += vec.getZ();
        W += vec.getW();
        return this;
    }
    
    public Vector4 sub(Vector4 vec)
    {
        X -= vec.getX();
        Y -= vec.getY();
        Z -= vec.getZ();
        W -= vec.getW();
        return this;
    }
    
    public Vector4 mult(Vector4 vec)
    {
        X *= vec.getX();
        Y *= vec.getY();
        Z *= vec.getZ();
        W *= vec.getW();
        return this;
    }
    
    public Vector4 mult(float value)
    {
        X *= value;
        Y *= value;
        Z *= value;
        W *= value;
        return this;
    }
    
    public Vector4 mult(int value)
    {
        X *= (float)value;
        Y *= (float)value;
        Z *= (float)value;
        W *= (float)value;
        return this;
    }
    
    public Vector4 mult(double value)
    {
        X *= (float)value;
        Y *= (float)value;
        Z *= (float)value;
        W *= (float)value;
        return this;
    }
    
    public Vector4 div(Vector4 vec)
    {
        X /= vec.getX();
        Y /= vec.getY();
        Z /= vec.getZ();
        W /= vec.getW();
        return this;
    }
    
    public Vector4 div(float value)
    {
        float inverseValue = 1.0f / value;
        X *= inverseValue;
        Y *= inverseValue;
        Z *= inverseValue;
        W *= inverseValue;
        return this;
    }
    
    public Vector4 div(int value)
    {
        float inverseValue = (float)(1.0f / value);
        X *= inverseValue;
        Y *= inverseValue;
        Z *= inverseValue;
        W *= inverseValue;
        return this;
    }
    
    public Vector4 div(double value)
    {
        float inverseValue = (float)(1.0f / value);
        X *= inverseValue;
        Y *= inverseValue;
        Z *= inverseValue;
        W *= inverseValue;
        return this;
    }
    
    public float dot(Vector4 vec)
    {
        return (X * vec.getX()) + (Y * vec.getY()) + (Z * vec.getZ()) + (W * vec.getW());
    }
    
    public double magnitude()
    {
        return Math.sqrt((X * X) + (Y * Y) + (Z * Z) + (W * W));
    }
    
    public void normalize()
    {
        // Multiply by the inverse length to save on divides
        double inverseLength = 1.0f / Vector4.Magnitude(this);
        X *= inverseLength;
        Y *= inverseLength;
        Z *= inverseLength;
        W *= inverseLength;
    }
    
    public double angle(Vector4 vec)
    {
        float dot = this.dot(Vector4.Normalize(vec));
        return Math.acos(dot);
    }
    
    public String toString()
    {
        return "X: " + X + " Y: " + Y + " Z: " + Z + " W: " + W;
    }
}