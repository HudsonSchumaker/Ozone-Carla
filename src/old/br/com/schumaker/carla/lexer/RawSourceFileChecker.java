package old.br.com.schumaker.carla.lexer;

import java.util.ArrayList;
import old.br.com.schumaker.carla.files.O3File;
import old.br.com.schumaker.carla.files.O3FileLine;
import old.br.com.schumaker.carla.lexer.utils.StringUtils;

/**
 *
 * @author Hudson Schumaker
 */
public class RawSourceFileChecker {
    
    public void startCheck(O3File file) {
        this.removeComments(file);
        this.removeBlankLines(file);
        this.setInternalLineNumbers(file);
    }
    
    public void setInternalLineNumbers(O3File file) {
        for (int l = 0; l < file.getLines().size(); l++) {
            file.getLines().get(l).setInternalNumber(l);
        }
    }
    
    public void removeComments(O3File file) {
       var newLines = new ArrayList<O3FileLine>();
       for (O3FileLine line : file.getLines()) {
           if (!line.getData().trim().startsWith(";")) {
               newLines.add(line);
           }
       }
       file.setLines(newLines);
    }
    
    public void removeBlankLines(O3File file) {
        var newLines = new ArrayList<O3FileLine>();
        for (O3FileLine line : file.getLines()) {
           if (!StringUtils.isBlankString(line.getData())) {
               newLines.add(line);
           }
       }
       file.setLines(newLines);
    }
}