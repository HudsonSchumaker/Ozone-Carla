package br.com.schumaker.carla.build;

/**
 * Interface contract for create a Zsh terminal command executor.
 *
 * @author Hudson Schumaker
 */
public interface Zsh {

    void executeCommand(String command);
}
