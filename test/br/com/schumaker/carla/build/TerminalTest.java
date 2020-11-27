package br.com.schumaker.carla.build;

/**
 *
 * @author schumaker
 */
public class TerminalTest {

    @Test
    public void testExecuteCommand() throws InterruptedException {
        // Prepariton
        var path = System.getProperty("user.dir");
        var cmd = "pwd";

        // Test
        var tested = new Terminal();
        tested.executeCommand(cmd);

        // Assertion
        Thread.sleep(500); // wait for clean the buffer.
        assertEquals(path, tested.getReturns().get(0));
    }
}