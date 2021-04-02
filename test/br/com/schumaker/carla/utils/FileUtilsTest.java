package br.com.schumaker.carla.utils;

import br.com.schumaker.carla.test.TestHelper;
import br.com.schumaker.carla.utils.FileUtils;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test class for @FileUtils
 *
 * @author Hudson Schumaker
 */
public class FileUtilsTest {

    @Test
    public void testGetFilePathsFromRoot() {

    }

    @Test
    public void testFileExists() throws Exception {
        // Preparation
        var file = TestHelper.createTempFile();

        // Test
        var result = FileUtils.fileExists(file);

        // Assertions
        assertTrue(result);
    }

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
        var s = System.getProperty("file.separator");
        var clearPath = s + "Library" + s + "hs" + s + "core" + s;
        var fullFilePath = clearPath + "main.o3";

        // Test
        String result = FileUtils.getClearPath(fullFilePath);

        // Assertion
        assertEquals(clearPath, result);
    }
}
