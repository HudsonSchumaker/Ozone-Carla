package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3File;
import br.com.schumaker.carla.files.O3FileLine;
import java.util.ArrayList;

/**
 *
 * @author schumaker
 */
public class PreChecker {
    
    public void removeComments(O3File file) {
       var newLines = new ArrayList<O3FileLine>();
       for (O3FileLine line : file.getLines()) {
           if (!line.getData().startsWith(";")) {
               newLines.add(line);
           }
       }
       file.setLines(newLines);
    }
    
    public void removeBlankLines(O3File file) {
        var newLines = new ArrayList<O3FileLine>();
        for (O3FileLine line : file.getLines()) {
           if (!isBlankString(line.getData())) {
               newLines.add(line);
           }
       }
       file.setLines(newLines);
    }
    
    public boolean checkFunctionMain(O3File file) {
        for (O3FileLine line : file.getLines()) {
            if (line.getData().contains("f: main()")) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isBlankString(String string) {
        return string == null || string.trim().isEmpty();
    }
}