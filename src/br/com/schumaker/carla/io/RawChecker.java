package br.com.schumaker.carla.io;

import br.com.schumaker.carla.io.impl.O3File;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface RawChecker {

    /**
     * Set the line numbers.
     *
     * @param file O3File source
     */
    void setInternalLineNumbers(O3File file);

    /**
     * Remove comment lines.
     *
     * @param file O3File source
     */
    void removeComments(O3File file);

    /**
     * Remove blank and empty lines.
     *
     * @param file O3File source
     */
    void removeBlankLines(O3File file);

    /**
     * Check for more than one function main.
     *
     * @param files O3File source files list.
     */
    void checkForFunctionMain(List<O3File> files);
}
