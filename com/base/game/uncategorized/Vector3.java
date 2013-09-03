package com.base.game.uncategorized;

public class Vector3
{
    // Attributes
    private float X;
    private float Y;
    private float Z;
    
    public Vector3()
    {
        X = 0.0f;
        Y = 0.0f;
        Z = 0.0f;
    }
    
    public Vector3(float x, float y, float z)
    {
        X = x;
        Y = y;
        Z = z;
    }
    
    public Vector3(int x, int y, int z)
    {
        X = (float)x;
        Y = (float)y;
        Z = (float)z;
    }
    
    public Vector3(Vector3 vec)
    {
        X = vec.getX();
        Y = vec.getY();
        Z = vec.getZ();
    }
    
    // Getters
    public float getX() { return X; }
    public float getY() { return Y; }
    public float getZ() { return Z; }
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
    
    // Static
    public static Vector3 Add(Vector3 left, Vector3 right)
    {
        return new Vector3(left.getX() + right.getX(),
                           left.getY() + right.getY(),
                           left.getZ() + right.getZ());
    }
    
    public static Vector3 Sub(Vector3 left, Vector3 right)
    {
        return new Vector3(left.getX() - right.getX(),
                           left.getY() - right.getY(),
                           left.getZ() - right.getZ());
    }
    
    public static Vector3 Mult(Vector3 left, Vector3 right)
    {
        return new Vector3(left.getX() * right.getX(),
                           left.getY() * right.getY(),
                           left.getZ() * right.getZ());
    }
    
    public static Vector3 Div(Vector3 left, Vector3 right)
    {
        return new Vector3(left.getX() / right.getX(),
                           left.getY() / right.getY(),
                           left.getZ() / right.getZ());
    }
    
    public static float Dot(Vector3 vec1, Vector3 vec2)
    {
        return (vec1.getX() * vec2.getX()) +
               (vec1.getY() * vec2.getY()) +
               (vec1.getZ() * vec2.getZ());
    }
    
    public static Vector3 Cross(Vector3 vec1, Vector3 vec2)
    {
        return new Vector3((vec1.getY() * vec2.getZ()) - (vec1.getZ() * vec2.getY()),
                           (vec1.getZ() * vec2.getX()) - (vec1.getX() * vec2.getZ()),
                           (vec1.getX() * vec2.getY()) - (vec1.getY() * vec2.getX()));
    }
    
    public static double Magnitude(Vector3 vec)
    {
        return Math.sqrt((vec.getX() * vec.getX()) + (vec.getY() * vec.getY()) + (vec.getZ() * vec.getZ()));
    }
    
    public static Vector3 Normalize(Vector3 vec)
    {
        // Multiply by the inverse length to save on divides
        double inverseLength = 1.0 / Vector3.Magnitude(vec);
        vec.setX(vec.getX() * inverseLength);
        vec.setY(vec.getY() * inverseLength);
        vec.setZ(vec.getZ() * inverseLength);
        
        return vec;
    }
    
    public static double angle(Vector3 vec1, Vector3 vec2)
    {
        float dot = Vector3.Dot(Vector3.Normalize(vec1), Vector3.Normalize(vec2));
        return Math.acos(dot);
    }
    
    // Utility
    public Vector3 add(Vector3 vec)
    {
        X += vec.getX();
        Y += vec.getY();
        Z += vec.getZ();
        return this;
    }
    
    public Vector3 sub(Vector3 vec)
    {
        X -= vec.getX();
        Y -= vec.getY();
        Z -= vec.getZ();
        return this;
    }
    
    public Vector3 mult(Vector3 vec)
    {
        X *= vec.getX();
        Y *= vec.getY();
        Z *= vec.getZ();
        return this;
    }
    
    public Vector3 mult(float value)
    {
        X *= value;
        Y *= value;
        Z *= value;
        return this;
    }
    
    public Vector3 mult(int value)
    {
        X *= (float)value;
        Y *= (float)value;
        Z *= (float)value;
        return this;
    }
    
    public Vector3 mult(double value)
    {
        X *= (float)value;
        Y *= (float)value;
        Z *= (float)value;
        return this;
    }
    
    public Vector3 div(Vector3 vec)
    {
        X /= vec.getX();
        Y /= vec.getY();
        Z /= vec.getZ();
        return this;
    }
    
    public Vector3 div(float value)
    {
        X /= value;
        Y /= value;
        Z /= value;
        return this;
    }
    
    public Vector3 div(int value)
    {
        X /= (float)value;
        Y /= (float)value;
        Z /= (float)value;
        return this;
    }
    
    public Vector3 div(double value)
    {
        X /= (float)value;
        Y /= (float)value;
        Z /= (float)value;
        return this;
    }
    
    public float dot(Vector3 vec)
    {
        return (X * vec.getX()) + (Y * vec.getY()) + (Z * vec.getZ());
    }
    
    public Vector3 cross(Vector3 vec)
    {
        return new Vector3((Y * vec.getZ()) - (Z * vec.getY()),
                           (Z * vec.getX()) - (X * vec.getZ()),
                           (X * vec.getY()) - (Y * vec.getX()));
    }
    
    public double magnitude()
    {
        return Math.sqrt((X * X) + (Y * Y) + (Z * Z));
    }
    
    public void normalize()
    {
        // Multiply by the inverse length to save on divides
        double inverseLength = 1.0f / Vector3.Magnitude(this);
        X *= inverseLength;
        Y *= inverseLength;
        Z *= inverseLength;
    }
    
    public double angle(Vector3 vec)
    {
        float dot = this.dot(Vector3.Normalize(vec));
        return Math.acos(dot);
    }
}