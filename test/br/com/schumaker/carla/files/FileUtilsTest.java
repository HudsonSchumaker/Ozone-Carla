package br.com.schumaker.carla.files;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author schumaker
 */
public class FileUtilsTest {
    
    @Test
    public void testGetFileExtension() {
        String ext = "png";
        String fullFilePath = "/Library/hs/core/photo." + ext;
        File f = new File(fullFilePath);
        String result = FileUtils.getFileExtension(f);
        assertEquals(ext, result);
    }
    
    @Test
    public void testGetClearNameString() {
        String clearName = "photo";
        String fullFilePath = "/Library/hs/core/" + clearName + ".png";
        String result = FileUtils.getClearName(fullFilePath);
        assertEquals(clearName, result);
    }
    
    @Test
    public void testGetClearNameFile() {
        String clearName = "photo";
        String fullFilePath = "/Library/hs/core/" + clearName + ".png";
        File f = new File(fullFilePath);
        String result = FileUtils.getClearName(f);
        assertEquals(clearName, result);
    }
    
    @Test 
    public void testGetName() {
        String name = "photo.png";
        String fullFilePath = "/Library/hs/core/" + name;
        String result = FileUtils.getName(fullFilePath);
        assertEquals(name, result);
    }
    
    @Test
    public void testGetClearPath() {
        String clearPath = "/Library/hs/core/";
        String fullFilePath = clearPath + "photo.png";
        File f = new File(fullFilePath);
        String result = FileUtils.getClearPath(fullFilePath);
        assertEquals(clearPath, result);
    }
}
