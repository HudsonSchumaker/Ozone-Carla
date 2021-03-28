package br.com.schumaker.carla.io;

import br.com.schumaker.carla.io.impl.O3File;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface FileBuilder<F, L> {

    F build(String path) throws Exception;

    /**
     * Creates the FileLine from the rawLines read form a .o3 source file.
     *
     * @param rawLines Lines from the physical file. Ex: foo.o3
     * @return A list of FileLine
     */
    List<L> createLines(List<String> rawLines);

    /**
     * Sets the FileLines that have a function header.
     *
     * @param file SourceFile param
     */
    void setFunctionHeaders(O3File file);

    /**
     * Set flag for conditionals.
     *
     * @param file SourceFile param
     */
    void setConditionalStatements(O3File file);

    /**
     * Set flag for loops.
     *
     * @param file SourceFile param
     */
    void setLoopStatements(O3File file);

    /**
     * Set flag for variable declarations.
     *
     * @param file SourceFile param
     */
    void setVariableDeclarations(O3File file);
}
