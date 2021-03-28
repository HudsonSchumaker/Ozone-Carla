package br.com.schumaker.carla.io.impl;

import br.com.schumaker.carla.exception.FunctionMainNotFoundException;
import br.com.schumaker.carla.io.FileBuilder;
import br.com.schumaker.carla.lexer.impl.LexerHelper;
import br.com.schumaker.carla.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class builds O3 SourceFiles.
 *
 * @author Hudson Schumaker
 * @see O3File
 */
public class SourceFileBuilder implements FileBuilder<O3File, O3FileLine> {

    @Override
    public O3File build(String path) throws Exception {
        var o3FileReader = new SourceFileReader();
        var lines = o3FileReader.read(path);
        var file = new O3File(FileUtils.getName(path), FileUtils.getClearPath(path), this.createLines(lines));

        // check if the source file has a function main
        this.checkForMainFunction(file);
        // set the source file lines attributes
        this.setFunctionHeaders(file);
        this.setConditionalStatements(file);
        this.setLoopStatements(file);
        this.setVariableDeclarations(file);
        this.setFunctionCalls(file);
        this.setReturnStatements(file);
        return file;
    }

    /**
     * Creates the FileLine from the rawLines read form a .o3 source file.
     * @param rawLines Lines from the physical file. Ex: foo.o3
     * @return A list of FileLine
     */
    @Override
    public List<O3FileLine> createLines(List<String> rawLines) {
        var lines = new ArrayList<O3FileLine>();
        for (int l = 0, n = 1; l < rawLines.size(); l++, n++) {
            lines.add(new O3FileLine(rawLines.get(l).trim(), n));
        }
        return lines;
    }

    /**
     * Sets the FileLines that have a function header.
     * @param file SourceFile param
     */
    public void setFunctionHeaders(O3File file) {
        for (O3FileLine line : file.getLines()) {
            if (LexerHelper.isFunctionHeader(line.getData())) {
                line.setFunctionHeader(true);
            }
        }
    }

    /**
     * Set flag for conditionals.
     *
     * @param file SourceFile param
     */
    public void setConditionalStatements(O3File file) {
        for (O3FileLine line : file.getLines()) {
            if (!line.isFunctionHeader()) {
                if (LexerHelper.isConditionalStatement(line.getData())) {
                    line.setConditionalStatement(true);
                }
            }
        }
    }

    /**
     * Set flag for loops.
     * @param file SourceFile param
     */
    public void setLoopStatements(O3File file) {
        for (O3FileLine line : file.getLines()) {
            if (!line.isFunctionHeader()) {
                if (LexerHelper.isLoopStatement(line.getData())) {
                    line.setLoopStatement(true);
                }
            }
        }

    }

    /**
     * Set flag for variable declarations.
     * @param file SourceFile param
     */
    public void setVariableDeclarations(O3File file) {
        for (O3FileLine line : file.getLines()) {
            if (!line.isFunctionHeader()) {
                if (LexerHelper.isVariableDeclaration(line.getData())) {
                    line.setVariableDeclaration(true);
                }
            }
        }
    }

    /**
     * Set flag for function calls.
     * @param file SourceFile param
     */
    public void setFunctionCalls(O3File file) {
        for (O3FileLine line : file.getLines()) {
            if (!line.isFunctionHeader()) {
                if (LexerHelper.isAnExpression(line.getData())) {
                    line.setFunctionCall(true);
                }
            }
        }
    }

    /**
     * Set flag for return.
     * @param file SourceFile param
     */
    public void setReturnStatements(O3File file) {
        for (O3FileLine line : file.getLines()) {
            if (!line.isFunctionHeader()) {
                if (LexerHelper.isReturnStatement(line.getData())) {
                    line.setReturnStatement(true);
                }
            }
        }
    }

    /**
     * Set flag for main function.
     * @param file SourceFile param
     */
    public void checkForMainFunction(O3File file) {
        for (O3FileLine line : file.getLines()) {
            if (LexerHelper.containsFunctionMain(line.getData())) {
                return;
            }
        }
        throw new FunctionMainNotFoundException();
    }
}
