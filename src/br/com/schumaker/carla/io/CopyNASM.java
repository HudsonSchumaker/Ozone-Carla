package br.com.schumaker.carla.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author schumaker
 */
public final class CopyNASM {

    /**
     * This method is responsible for copy the NASM zipped compiler file. 
     * @throws IOException
     */
    public void copyNASMZipFile() throws IOException {
        var origin = getClass().getResourceAsStream("/resource/nasm.zip");
        var destination = Path.of(System.getProperty("user.dir") + "/nasm.zip");
        Files.copy(origin, destination, StandardCopyOption.REPLACE_EXISTING);
    }
}
