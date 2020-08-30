package br.com.schumaker.carla.io;

import br.com.schumaker.carla.exception.CloseStreamsException;
import br.com.schumaker.carla.exception.WriteMakefileException;
import br.com.schumaker.carla.o3.O3SyntaxLibrary;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Hudson Schumaker
 */
public class MakeFileWriter implements Writer {

    private static final String ALL = "all:";
    private static final String CLEAR = "clear:";

    @Override
    public void write(String atomName) {
        var file = this.createMakefileFile(atomName);

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);

            bw.write(ALL);
            bw.newLine();
            bw.write(this.getLineChmodNASM(atomName));
            bw.newLine();
            bw.write(this.getCompileLine(atomName));
            bw.newLine();
            bw.write(this.getLinkLine(atomName));
            bw.newLine();
            bw.write(CLEAR);
            bw.newLine();
            bw.write(this.getCleanLine());

        } catch (Exception e) {
            throw new WriteMakefileException();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                throw new CloseStreamsException();
            }
        }
    }

    public File createMakefileFile(String workspace) {
        return new File(System.getProperty("user.dir")
                + System.getProperty("file.separator")
                + workspace
                + System.getProperty("file.separator")
                + "Makefile");
    }

    public String getCompileLine(String atomName) {
        return "\t" + System.getProperty("user.dir")
                + System.getProperty("file.separator")
                + atomName
                + System.getProperty("file.separator")
                + "nasm"
                + System.getProperty("file.separator")
                + "nasm"
                + " -f macho64 " + atomName + ".asm";
    }

    /**
     * Supports OS Sierra or above.
     *
     * @param atomName
     * @return link line for makefile.
     */
    public String getLinkLine(String atomName) {
        return "\tld -macosx_version_min 10.12 -no_pie -lSystem -o "
                + atomName + " "
                + atomName + ".o "
                + O3SyntaxLibrary.PRINT_O + " "
                + O3SyntaxLibrary.STRINGS_O;
    }

    public String getLineChmodNASM(String atomName) {
        return "\tchmod 777 "
                + System.getProperty("user.dir")
                + System.getProperty("file.separator")
                + atomName
                + System.getProperty("file.separator")
                + "nasm"
                + System.getProperty("file.separator")
                + "*";
    }

    public String getCleanLine() {
        return "\trm -r nasm rm *.o rm *.asm rm *.c rm *.zip";
    }
}
