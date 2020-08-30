package br.com.schumaker.carla.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * This class contains method(s) to get ASM lib file(s).
 *
 * @author Hudson Schumaker
 */
public class CopyO3aLib {

    public static final String C_LIB_A_PATH = "/resource/a";

    /**
     * This method is responsible for copy the NASM source .asm file.
     *
     * @throws IOException
     */
    public void copyAByName(String name) throws IOException {
        var origin = getClass().getResourceAsStream(C_LIB_A_PATH + "/" + name);
        var destination = Path.of(System.getProperty("user.dir") + "/" + name);
        Files.copy(origin, destination, StandardCopyOption.REPLACE_EXISTING);
    }
}
