package tempest;

import static org.lwjgl.opengl.GL11.*;

public class Draw
{
    public static void Rect(Vector2 pos, Vector2 scale)
    {
        glPushMatrix();
        glTranslatef(pos.X(), pos.Y(), 0.0f);
        float halfWidth = scale.X() / 2;
        float halfHeight = scale.Y() / 2;
        glBegin(GL_QUADS);
        {
            glVertex2f(-halfWidth, -halfHeight);
            glVertex2f(-halfWidth,  halfHeight);
            glVertex2f( halfWidth,  halfHeight);
            glVertex2f( halfWidth, -halfHeight);
        }
        glEnd();
        glPopMatrix();
    }
    
    public static void Rect(Vector2 pos, Vector2 scale, Vector3 color)
    {
        glPushMatrix();
        glColor4f(color.X(), color.Y(), color.Z(), 1.0f);
        glTranslatef(pos.X(), pos.Y(), 0.0f);
        float halfWidth = scale.X() / 2;
        float halfHeight = scale.Y() / 2;
        glBegin(GL_QUADS);
        {
            glVertex2f(-halfWidth, -halfHeight);
            glVertex2f(-halfWidth,  halfHeight);
            glVertex2f( halfWidth,  halfHeight);
            glVertex2f( halfWidth, -halfHeight);
        }
        glEnd();
        glPopMatrix();
    }
    
    public static void Rect(Vector2 pos, Vector2 scale, Vector2 rot, Vector3 color)
    {
        glPushMatrix();
        glColor4f(color.X(), color.Y(), color.Z(), 1.0f);
        glTranslatef(pos.X(), pos.Y(), 0.0f);
        glRotatef(rot.X(), rot.Y(), 0.0f, 1.0f);
        float halfWidth = scale.X() / 2;
        float halfHeight = scale.Y() / 2;
        glBegin(GL_QUADS);
        {
            glVertex2f(-halfWidth, -halfHeight);
            glVertex2f(-halfWidth,  halfHeight);
            glVertex2f( halfWidth,  halfHeight);
            glVertex2f( halfWidth, -halfHeight);
        }
        glEnd();
        glPopMatrix();
    }
}