package br.com.schumaker.carla.io;

import br.com.schumaker.carla.exception.CopyNASMZipFileException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * This class contains method(s) to get NASM lib file.
 *
 * @author Hudson Schumaker
 */
public final class CopyNASM {

    public static final String NASM_ZIP = "nasm.zip";
    public static final String NASM_ZIP_PATH = "/resource/nasm.zip";

    /**
     * This method is responsible for copy the NASM zipped compiler file.
     *
     * @param atomName
     */
    public void copyNASMZipFile(String atomName) {
        try {
            var origin = getClass().getResourceAsStream(NASM_ZIP_PATH);
            var destination = Path.of(System.getProperty("user.dir")
                    + System.getProperty("file.separator")
                    + atomName
                    + System.getProperty("file.separator")
                    + NASM_ZIP);
            Files.copy(origin, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new CopyNASMZipFileException();
        }
    }
}
