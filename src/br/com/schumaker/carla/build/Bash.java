package br.com.schumaker.carla.build;

/**
 * Interface contract for create a Bash terminal command executor.
 *
 * @author Hudson Schumaker
 */
public interface Bash {
    void executeCommand(String[] commands);
}