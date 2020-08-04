package br.com.schumaker.carla.files;

import br.com.schumaker.carla.exception.FileNotSupportedException;
import br.com.schumaker.carla.io.O3FileReader;
import br.com.schumaker.carla.test.O3TestHelper;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author schumaker
 */
public class O3FileReaderTest {
    
    @Test
    public void testRead() throws Exception {
        // Preparation    
        var tmpFile = O3TestHelper.createTempFileO3();
 
        // Test
        var tested = new O3FileReader();
        var result = tested.read(tmpFile.getAbsolutePath());
        
        // Assertion
        assertEquals("f: main() {", result.get(4));
    }
    
    @Test(expected = FileNotFoundException.class)
    public void testReadFail() throws Exception {
        // Preparation    
        var tmpFile = new File("/hh/hhh");
 
        // Test
        var tested = new O3FileReader();
        
        // Will Fail
        var result = tested.read(tmpFile.getAbsolutePath());
    }
    
    @Test(expected = FileNotSupportedException.class)
    public void testReadWrongFileType() throws Exception {
        // Preparation    
        var tmpFile = O3TestHelper.createTempFile();
 
        // Test
        var tested = new O3FileReader();
        var result = tested.read(tmpFile.getAbsolutePath());
        
        // Assertion
        assertEquals("f: main() {", result.get(4));
    }
    
    @Test
    public void testFileExists() throws Exception  {
        // Preparation    
        var tmpFile = O3TestHelper.createTempFileO3();
 
        // Test
        var tested = new O3FileReader();
        var result = tested.fileExists(tmpFile.getAbsolutePath());
        
        // Assertion
        Assert.assertTrue(result);
    }
    
    @Test
    public void testValidExtensionFalse() {
        // Preparation    
        var fakePath = "/Lib/core/nasm/main.cpp";
 
        // Test
        var tested = new O3FileReader();
        var result = tested.validExtension(fakePath);
        
        // Assertion
        Assert.assertFalse(result);
    }
    
    @Test
    public void testValidExtensionTrue() {
        // Preparation    
        var fakePath = "/Lib/core/nasm/main.o3";
 
        // Test
        var tested = new O3FileReader();
        var result = tested.validExtension(fakePath);
        
        // Assertion
        Assert.assertTrue(result);
    }
}