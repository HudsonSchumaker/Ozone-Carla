package old.br.com.schumaker.carla.files;

import br.com.schumaker.carla.exception.FunctionMainNotFoundException;
import java.util.ArrayList;
import java.util.List;
import old.br.com.schumaker.carla.io.O3FileReader;
import old.br.com.schumaker.carla.lexer.LexerHelper;

/**
 * This class builds O3Files
 *
 * @see O3File
 * @author Hudson Schumaker
 */
public class O3FileBuilder implements FileBuilder<O3File> {

    @Override
    public O3File build(String path) throws Exception {
        var o3FileReader = new O3FileReader();
        var lines = o3FileReader.read(path);

        var file = new O3File(
                O3FileUtils.getName(path),
                O3FileUtils.getClearPath(path),
                this.createLines(lines));

        if (!LexerHelper.containsFunctionMain(file)) {
            throw new FunctionMainNotFoundException();
        }

        this.setFunctionHeaders(file);
        this.setConditionalStatements(file);
        this.setLoopStatements(file);
        this.setVariableDeclarations(file);
        this.setFunctionCalls(file);
        return file;
    }

    /**
     * Creates the O3FileLine from the rawLines read form a .o3 source file.
     *
     * @param rawLines
     * @return A list of O3FileLine
     */
    public List<O3FileLine> createLines(List<String> rawLines) {
        var lines = new ArrayList<O3FileLine>();
        for (int l = 0, n = 1; l < rawLines.size(); l++, n++) {
            lines.add(new O3FileLine(rawLines.get(l), n));
        }
        return lines;
    }

    /**
     * Sets the O3FileLines that have a function header.
     *
     * @param file
     */
    public void setFunctionHeaders(O3File file) {
        for (O3FileLine line : file.getLines()) {
            if (LexerHelper.isFunctionHeader(line.getData())) {
                line.setFunctionHeader(true);
            }
        }
    }

    /**
     *
     * @param file
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
     *
     * @param file
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
     *
     * @param file
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
     *
     * @param file
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

    public void setReturnStatements(O3File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
