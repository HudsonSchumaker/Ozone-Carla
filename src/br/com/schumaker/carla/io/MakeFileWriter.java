package br.com.schumaker.carla.io;

import br.com.schumaker.carla.exception.CloseStreamsException;
import br.com.schumaker.carla.exception.WriteMakefileException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author schumaker
 */
public class MakeFileWriter implements Writer {
    
    private static final String ALL = "all:";
    private static final String CLEAR = "clear:";
    
    @Override
    public void write(String fileName) {
        var file = new File(System.getProperty("user.dir") + "/Makefile");
        
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);

            bw.write(ALL);
            bw.newLine();
            bw.write("\t" + System.getProperty("user.dir") 
                    + "/nasm" 
                    + "/nasm"
                    + " -f macho64 " + fileName + ".asm");
            bw.newLine();
            bw.write("\tld -macosx_version_min 10.12 -no_pie -lSystem -o " 
                    + fileName + " " + fileName + ".o");
            bw.newLine();
            bw.write("\t./" + fileName);
            bw.newLine();
            bw.write(CLEAR);
            bw.newLine();
            bw.write("\trm " + fileName + ".o");
            
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
}