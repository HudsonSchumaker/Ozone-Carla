package br.com.schumaker.carla.io.impl;

import br.com.schumaker.carla.o3.impl.O3Keyword;
import br.com.schumaker.carla.utils.StringUtils;

import java.util.ArrayList;

/**
 * This class has methods do check and clean the source file.
 *
 * @author Hudson Schumaker
 */
public class RawSourceFileChecker {

    public void doCheck(O3File file) {
        this.removeComments(file);
        this.removeBlankLines(file);
        this.setInternalLineNumbers(file);
    }

    /**
     * Set the line numbers.
     *
     * @param file O3File source
     */
    public void setInternalLineNumbers(O3File file) {
        for (int l = 0; l < file.getLines().size(); l++) {
            file.getLines().get(l).setInternalNumber(l);
        }
    }

    /**
     * Remove comment lines.
     *
     * @param file O3File source
     */
    public void removeComments(O3File file) {
        var newLines = new ArrayList<O3FileLine>();
        for (O3FileLine line : file.getLines()) {
            if (!line.getData().trim().startsWith(O3Keyword.COMMENT)) {
                newLines.add(line);
            }
        }
        file.setLines(newLines);
    }

    /**
     * Remove blank and empty lines.
     *
     * @param file O3File source
     */
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
