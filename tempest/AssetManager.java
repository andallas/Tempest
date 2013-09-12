package tempest;

import java.io.IOException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class AssetManager
{
    private static AssetManager assetManager = new AssetManager();
    
    private AssetManager()
    {}
    
    public static AssetManager Instance()
    {
        return assetManager;
    }
    
    public Texture Texture(String path) throws IOException
    {
        Texture texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("src/Resources/img/" + path));
        return texture;
    }
}
