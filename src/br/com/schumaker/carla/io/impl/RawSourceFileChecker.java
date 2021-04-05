package br.com.schumaker.carla.io.impl;

import br.com.schumaker.carla.exception.MoreThanOneFunctionMainException;
import br.com.schumaker.carla.io.RawChecker;
import br.com.schumaker.carla.lexer.impl.LexerHelper;
import br.com.schumaker.carla.o3.impl.O3Keyword;
import br.com.schumaker.carla.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class has methods to check and clean the source file.
 *
 * @author Hudson Schumaker
 */
public final class RawSourceFileChecker implements RawChecker {

    public void doCheck(O3File file) {
        this.removeComments(file);
        this.removeBlankLines(file);
        this.setInternalLineNumbers(file);
    }

    @Override
    public void setInternalLineNumbers(O3File file) {
        for (int l = 0; l < file.getLines().size(); l++) {
            file.getLines().get(l).setInternalNumber(l);
        }
    }

    @Override
    public void removeComments(O3File file) {
        var newLines = new ArrayList<O3FileLine>();
        for (O3FileLine line : file.getLines()) {
            if (!line.getData().trim().startsWith(O3Keyword.COMMENT)) {
                newLines.add(line);
            }
        }
        file.setLines(newLines);
    }

    @Override
    public void removeBlankLines(O3File file) {
        var newLines = new ArrayList<O3FileLine>();
        for (O3FileLine line : file.getLines()) {
            if (!StringUtils.isBlankString(line.getData())) {
                newLines.add(line);
            }
        }
        file.setLines(newLines);
    }

    @Override
    public void checkForFunctionMain(List<O3File> files) {
        int number = 0;
        for (O3File file : files) {
            for (O3FileLine line : file.getLines()) {
                if (LexerHelper.containsFunctionMain(line.getData())) {
                    if (++number > 1) {
                        throw new MoreThanOneFunctionMainException();
                    }
                }
            }
        }
    }
}
