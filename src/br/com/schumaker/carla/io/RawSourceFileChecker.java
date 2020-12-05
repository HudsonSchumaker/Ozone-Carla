package br.com.schumaker.carla.io;

import br.com.schumaker.carla.utils.StringUtils;

import java.util.ArrayList;

/**
 *
 * @author Hudson Schumaker
 */
public class RawSourceFileChecker {
    public void doCheck(O3File file) {
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
        var newLines = new ArrayList<FileLine>();
        for (FileLine line : file.getLines()) {
            if (!line.getData().trim().startsWith(";")) {
                newLines.add(line);
            }
        }
        file.setLines(newLines);
    }

    public void removeBlankLines(O3File file) {
        var newLines = new ArrayList<FileLine>();
        for (FileLine line : file.getLines()) {
            if (!StringUtils.isBlankString(line.getData())) {
                newLines.add(line);
            }
        }
        file.setLines(newLines);
    }
}
