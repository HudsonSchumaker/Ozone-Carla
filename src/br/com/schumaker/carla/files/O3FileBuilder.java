package br.com.schumaker.carla.files;

import br.com.schumaker.carla.io.O3FileReader;
import br.com.schumaker.carla.lexer.LexerHelper;
import java.util.ArrayList;
import java.util.List;

/**
 * This class builds O3Files 
 * @see O3File
 * 
 * @author schumaker
 */
public class O3FileBuilder implements FileBuilder<O3File> {
    
    @Override
    public O3File build(String path) throws Exception {
        var o3FileReader = new O3FileReader();
        var lines = o3FileReader.read(path);
        
        var file = new O3File(
                FileUtils.getName(path), 
                FileUtils.getClearPath(path), 
                this.createLines(lines));
        
        if (!LexerHelper.containsFunctionMain(file)) {
            throw new RuntimeException("no function main");
        }
        
        this.setFunctionHeaders(file);
        this.setConditionalStatements(file);
        this.setLoopStatements(file);
        this.setVariableDeclarations(file);
        return file;
    }
    
    private List<O3FileLine> createLines(List<String> rawLines) {
        var lines = new ArrayList<O3FileLine>();
        for (int l = 0, n = 1; l < rawLines.size(); l++, n++) {
            lines.add(new O3FileLine(rawLines.get(l), n));
        }
        return lines;
    }
    
    private void setFunctionHeaders(O3File file) {
        for (O3FileLine line : file.getLines()) {
            if (LexerHelper.isFunctionHeader(line.getData())) {
                line.setFunctionHeader(true);
            }
        }
    }
    
    private void setConditionalStatements(O3File file) {
        for (O3FileLine line : file.getLines()) {
            if (LexerHelper.isConditionalStatement(line.getData())) {
                line.setConditionalStatement(true);
            }
        }
    }
    
    private void setLoopStatements(O3File file) {
        for (O3FileLine line : file.getLines()) {
            if (LexerHelper.isLoopStatement(line.getData())) {
                line.setLoopStatement(true);
            }
        }
    }
    
    private void setVariableDeclarations(O3File file) {
        for (O3FileLine line : file.getLines()) {
            if (LexerHelper.isVariableDeclaration(line.getData())) {
                line.setVariableDeclaration(true);
            }
        }
    }
    
    private void setReturnStatements(O3File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
