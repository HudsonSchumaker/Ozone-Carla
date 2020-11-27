package br.com.schumaker.carla.build;

/**
 * Interface contract for create a CMD terminal command executor.
 *
 * @author Hudson Schumaker
 */
public interface Cmd {
    void executeCommand(String[] commands);
}
