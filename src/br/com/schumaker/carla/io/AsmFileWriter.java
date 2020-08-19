package br.com.schumaker.carla.io;

import java.io.File;

/**
 *
 * @author schumaker
 */
public class AsmFileWriter implements Writer {
    
    @Override
    public void write(String fileName) {
        var file = new File(System.getProperty("user.dir") + "/" + fileName + ".asm");
    }
}
