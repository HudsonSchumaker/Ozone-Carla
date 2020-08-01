package br.com.schumaker.carla.files;

import br.com.schumaker.carla.io.O3FileReader;
import br.com.schumaker.carla.lexer.Lexer;
import java.util.ArrayList;
import java.util.List;

/**
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
        
        this.setFunctionHeaders(file);
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
            if (Lexer.isFunctionHeader(line.getData())) {
                line.setFunctionHeader(true);
            }
        }
    }
}
