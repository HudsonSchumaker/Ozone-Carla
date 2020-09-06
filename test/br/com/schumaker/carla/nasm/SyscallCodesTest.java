package br.com.schumaker.carla.nasm;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Hudson Schumaker
 */
public class SyscallCodesTest {
    
    @Test
    public void testGetMacOsSysCallMap() {
        // Preaparation
        var write = "WRITE";
        var code = "0x02000004";
        var tested = new SyscallCodes();
        
        // Test
        var result = tested.getMacOsSysCallMap();
        
        // Assertion
        Assert.assertEquals(code, result.get(write));
    }
}
