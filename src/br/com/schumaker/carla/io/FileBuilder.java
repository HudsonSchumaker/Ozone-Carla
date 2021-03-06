package br.com.schumaker.carla.io;

import br.com.schumaker.carla.io.impl.O3File;

import java.util.List;

/**
 * @param <F> File
 * @param <L> Line
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
     * Sets the Class Headers.
     *
     * @param file SourceFile param
     */
    void setClassHeaders(O3File file);

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

    /**
     * Set flag for constant declarations.
     *
     * @param file SourceFile param
     */
    void setConstantDeclarations(O3File file);

    /**
     * Set flag for function calls.
     *
     * @param file SourceFile param
     */
    void setFunctionCalls(O3File file);

    /**
     * Set flag for return.
     *
     * @param file SourceFile param
     */
    void setReturnStatements(O3File file);

    /**
     * Set flag for main function.
     *
     * @param file SourceFile param
     */
    void checkForMainFunction(O3File file);

}
