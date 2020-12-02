package br.com.schumaker.carla.io;

import java.util.ArrayList;
import java.util.List;

/**
 * This class builds O3 SourceFiles.
 *
 * @author Hudson Schumaker
 * @see SourceFile
 */
public class SourceFileBuilder implements FileBuilder<SourceFile> {

    @Override
    public SourceFile build(String path) throws Exception {
        var o3FileReader = new SourceFileReader();
        var lines = o3FileReader.read(path);

        var file = new SourceFile(
                FileUtils.getName(path),
                FileUtils.getClearPath(path),
                this.createLines(lines));

        //TODO :
        // setFunctionHeaders,
        // setConditionalStatements,
        // setLoopStatements,
        // setVariableDeclarations,
        // setFunctionCalls,
        // setReturnStatements

        return file;
    }

    /**
     * Creates the O3FileLine from the rawLines read form a .o3 source file.
     *
     * @param rawLines Lines from the physical file. Ex: foo.o3
     * @return A list of O3FileLine
     */
    @Override
    public List<FileLine> createLines(List<String> rawLines) {
        var lines = new ArrayList<FileLine>();
        for (int l = 0, n = 1; l < rawLines.size(); l++, n++) {
            lines.add(new FileLine(rawLines.get(l), n));
        }
        return lines;
    }

    /**
     * Sets the O3FileLines that have a function header.
     *
     * @param file SourceFile param
     */
    public void setFunctionHeaders(SourceFile file) {
        for (FileLine line : file.getLines()) {
            if (LexerHelper.isFunctionHeader(line.getData())) {
                line.setFunctionHeader(true);
            }
        }
    }

    /**
     *
     * @param file SourceFile param
     */
    public void setConditionalStatements(SourceFile file) {
        for (FileLine line : file.getLines()) {
            if (!line.isFunctionHeader()) {
                if (LexerHelper.isConditionalStatement(line.getData())) {
                    line.setConditionalStatement(true);
                }
            }
        }
    }

    /**
     *
     * @param file SourceFile param
     */
    public void setLoopStatements(SourceFile file) {
        for (FileLine line : file.getLines()) {
            if (!line.isFunctionHeader()) {
                if (LexerHelper.isLoopStatement(line.getData())) {
                    line.setLoopStatement(true);
                }
            }
        }
    }

    /**
     *
     * @param file SourceFile param
     */
    public void setVariableDeclarations(SourceFile file) {
        for (FileLine line : file.getLines()) {
            if (!line.isFunctionHeader()) {
                if (LexerHelper.isVariableDeclaration(line.getData())) {
                    line.setVariableDeclaration(true);
                }
            }
        }
    }

    /**
     *
     * @param file SourceFile param
     */
    public void setFunctionCalls(SourceFile file) {
        for (FileLine line : file.getLines()) {
            if (!line.isFunctionHeader()) {
                if (LexerHelper.isAnExpression(line.getData())) {
                    line.setFunctionCall(true);
                }
            }
        }
    }

    public void setReturnStatements(SourceFile file) {
        for (FileLine line : file.getLines()) {
            if(!line.isFunctionHeader()) {

            }
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
