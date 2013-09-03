package com.base.game.uncategorized;

import static org.lwjgl.opengl.GL11.*;

public class Draw
{
    public static void Rect(float x, float y, float width, float height, float rot)
    {
        glPushMatrix();
        glTranslatef(x, y, 0.0f);
        glRotatef(rot, 0.0f, 0.0f, 1.0f);
        float halfWidth = width / 2;
        float halfHeight = height / 2;
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