package br.com.schumaker.carla.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * This class contains method(s) to get O lib file(s).
 * @author schumaker
 */
public class CopyO3oLib {

    public static final String C_LIB_O_PATH = "/resource/o";

    /**
     * This method is responsible for copy the object(s) .o file.
     * @throws IOException
     */
    public void copyOByName(String name) throws IOException {
        var origin = getClass().getResourceAsStream(C_LIB_O_PATH + "/" + name);
        var destination = Path.of(System.getProperty("user.dir") + "/" + name);
        Files.copy(origin, destination, StandardCopyOption.REPLACE_EXISTING);
    }
}
