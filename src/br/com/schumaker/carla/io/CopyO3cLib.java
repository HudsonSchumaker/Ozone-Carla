package br.com.schumaker.carla.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * This class contains method(s) to get C lib file(s).
 *
 * @author schumaker
 */
public class CopyO3cLib {

    public static final String C_LIB_C_PATH = "/resource/c";

    /**
     * This method is responsible for copy the c source .c file.
     *
     * @throws IOException
     */
    public void copyCByName(String name) throws IOException {
        var origin = getClass().getResourceAsStream(C_LIB_C_PATH + "/" + name);
        var destination = Path.of(System.getProperty("user.dir") + "/" + name);
        Files.copy(origin, destination, StandardCopyOption.REPLACE_EXISTING);
    }
}
