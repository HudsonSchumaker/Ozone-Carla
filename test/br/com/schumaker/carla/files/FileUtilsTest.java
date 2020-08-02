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
         // Preparation
        String clearName = "photo";
        String fullFilePath = "/Library/hs/core/" + clearName + ".png";
        
        // Test
        String result = FileUtils.getClearName(fullFilePath);
        
        // Assertion
        assertEquals(clearName, result);
    }
    
    @Test
    public void testGetClearNameFile() {
        // Preparation
        String clearName = "photo";
        String fullFilePath = "/Library/hs/core/" + clearName + ".png";
        File f = new File(fullFilePath);
        
        // Test
        String result = FileUtils.getClearName(f);
        
        // Assertion
        assertEquals(clearName, result);
    }
    
    @Test 
    public void testGetName() {
        // Preparation
        String name = "photo.png";
        String fullFilePath = "/Library/hs/core/" + name;
        
        // Test
        String result = FileUtils.getName(fullFilePath);
        
        // Assertion
        assertEquals(name, result);
    }
    
    @Test
    public void testGetClearPath() {
        // Preparation
        String clearPath = "/Library/hs/core/";
        String fullFilePath = clearPath + "photo.png";
        
        // Test
        String result = FileUtils.getClearPath(fullFilePath);
        
        // Assertion
        assertEquals(clearPath, result);
    }
}
