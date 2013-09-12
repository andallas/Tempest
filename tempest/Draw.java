package tempest;

import static org.lwjgl.opengl.GL11.*;
import org.newdawn.slick.opengl.Texture;

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
    
    public static void Rect(Vector2 pos, Vector2 scale, Texture tex)
    {
        glPushMatrix();
            glEnable(GL_TEXTURE_2D);
            glEnable(GL_BLEND);
            glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
            glColor4f(1f, 1f, 1f, 1f);
            glTranslatef(pos.X(), pos.Y(), 0f);
            float halfWidth = scale.X() / 2;
            float halfHeight = scale.Y() / 2;
            
            tex.bind();
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            
            glBegin(GL_QUADS);
            {
                glTexCoord2f(0f, 1f);
                glVertex2f(-halfWidth, -halfHeight);
                glTexCoord2f(1f, 1f);
                glVertex2f( halfWidth, -halfHeight);
                glTexCoord2f(1f, 0f);
                glVertex2f( halfWidth,  halfHeight);
                glTexCoord2f(0f, 0f);
                glVertex2f(-halfWidth, halfHeight);
            }
            glEnd();
        glPopMatrix();
    }
}