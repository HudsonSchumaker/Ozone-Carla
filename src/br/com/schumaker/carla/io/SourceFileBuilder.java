package br.com.schumaker.carla.io;

import java.util.ArrayList;
import java.util.List;

/**
 * This class builds O3 SourceFiles.
 *
 * @see SourceFile
 * @author Hudson Schumaker
 */
public class SourceFileBuilder implements FileBuilder<SourceFile> {

    @Override
    public SourceFile build(String path) throws Exception {
        var o3FileReader = new SourceFileReader();
        var lines = o3FileReader.read(path);



        return null;
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
}
