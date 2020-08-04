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
         // Preparation
        String ext = "o3";
        String fullFilePath = "/Library/hs/core/src." + ext;
        File f = new File(fullFilePath);
        
        // Test
        String result = FileUtils.getFileExtension(f);
        
        // Assertion
        assertEquals(ext, result);
    }
    
    @Test
    public void testGetClearNameString() {
         // Preparation
        String clearName = "main";
        String fullFilePath = "/Library/hs/core/" + clearName + ".o3";
        
        // Test
        String result = FileUtils.getClearName(fullFilePath);
        
        // Assertion
        assertEquals(clearName, result);
    }
    
    @Test
    public void testGetClearNameFile() {
        // Preparation
        String clearName = "main";
        String fullFilePath = "/Library/hs/core/" + clearName + ".o3";
        File f = new File(fullFilePath);
        
        // Test
        String result = FileUtils.getClearName(f);
        
        // Assertion
        assertEquals(clearName, result);
    }
    
    @Test 
    public void testGetName() {
        // Preparation
        String name = "main.03";
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
        String fullFilePath = clearPath + "main.o3";
        
        // Test
        String result = FileUtils.getClearPath(fullFilePath);
        
        // Assertion
        assertEquals(clearPath, result);
    }
}
