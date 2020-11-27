package br.com.schumaker.carla.build;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Hudson Schumaker
 */
public class TerminalMacOsTest {

    @Test
    public void testExecuteCommand() throws InterruptedException {
        // Preparation
        var path = System.getProperty("user.dir");
        var cmd = "pwd";

        // Test
        var tested = new TerminalMacOs();
        tested.executeCommand(new String[]{cmd});

        // Assertion
        Thread.sleep(500); // wait for clean the buffer.
        assertEquals(path, tested.getOut().get(0));
    }
}