package br.com.schumaker.carla.io;

import br.com.schumaker.carla.exception.CloseStreamsException;
import br.com.schumaker.carla.exception.WriteMakefileException;
import br.com.schumaker.carla.files.O3AsmFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Hudson Schumaker
 */
public class AsmFileWriter {

    private String workspace;

    public AsmFileWriter(String workspace) {
        this.workspace = workspace;
    }

    public void write(O3AsmFile o3asmfile) {
        var file = this.createAsmFile(o3asmfile.getName());

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);

            // Header
            bw.write(o3asmfile.getHeader().getAmsHeader());

            // Extern
            for (String line : o3asmfile.getExtern().getExternLines()) {
                bw.write(line);
            }

            // Section .data
            for (String line : o3asmfile.getSectionData().getSectionDataLines()) {
                bw.write(line);
            }

            // Section .text
            for (String line : o3asmfile.getSectionText().getSectionTextLines()) {
                bw.write(line);
            }

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

    public File createAsmFile(String atomName) {
        return new File(this.workspace
                + System.getProperty("file.separator")
                + atomName + "." + O3AsmFile.EXT);
    }
}
