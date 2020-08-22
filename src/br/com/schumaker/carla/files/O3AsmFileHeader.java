package br.com.schumaker.carla.files;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Hudson Schumaker
 */
public class O3AsmFileHeader {

    public static final String BITS = "bits 64";
    public static final String HEADER
            = "; O3 Ozone Project.\n"
            + "; O3 programing language.\n"
            + "; file generate by X64Halogen.\n";
    
    /**
     * Create the header and put bits directive.
     * @return asm header.
     */
    public String generateHeader() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return HEADER + "; " + LocalDateTime.now().format(formatter) + "\n" + BITS;
    }
}
