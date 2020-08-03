package br.com.schumaker.carla.files;

import br.com.schumaker.carla.io.O3FileReader;
import br.com.schumaker.carla.test.O3TestHelper;
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
        var tmpFile = O3TestHelper.createTempFile();
 
        // Test
        var tested = new O3FileReader();
        var result = tested.read(tmpFile.getAbsolutePath());
        
        // Assertion
        assertEquals("f: main() {", result.get(4));
    }
}
