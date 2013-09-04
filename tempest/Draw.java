package tempest;

import static org.lwjgl.opengl.GL11.*;

public class Draw
{
    public static void Rect(Vector3 pos, Vector3 scale)
    {
        glPushMatrix();
        glTranslatef(pos.getX(), pos.getY(), pos.getZ());
        float halfWidth = scale.getX() / 2;
        float halfHeight = scale.getY() / 2;
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
    
    public static void Rect(Vector3 pos, Vector3 scale, Vector3 color)
    {
        glPushMatrix();
        glColor4f(color.getX(), color.getY(), color.getZ(), 1.0f);
        glTranslatef(pos.getX(), pos.getY(), pos.getZ());
        float halfWidth = scale.getX() / 2;
        float halfHeight = scale.getY() / 2;
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
    
    public static void Rect(Vector3 pos, Vector3 scale, Vector3 rot, Vector3 color)
    {
        glPushMatrix();
        glColor4f(color.getX(), color.getY(), color.getZ(), 1.0f);
        glTranslatef(pos.getX(), pos.getY(), pos.getZ());
        glRotatef(rot.getX(), rot.getY(), rot.getZ(), 1.0f);
        float halfWidth = scale.getX() / 2;
        float halfHeight = scale.getY() / 2;
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