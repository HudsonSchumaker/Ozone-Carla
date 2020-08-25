package br.com.schumaker.carla.files;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Data;

/**
 *
 * @author Hudson Schumaker
 */
@Data
public final class O3AsmFileHeader implements IO3AsmFileSection {

    public static final String BITS = "bits 64";
    public static final String HEADER
            = "; O3 Ozone Project.\n"
            + "; O3 programing language.\n"
            + "; file generated by X64Halogen.\n";

    private String amsHeader;

    public O3AsmFileHeader() {
        this.generateHeader();
    }

    /**
     * Create the header and put bits directive.
     *          
     */
    public void generateHeader() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        amsHeader = HEADER + "; " + LocalDateTime.now().format(formatter) + "\n" + BITS + "\n\n";
    }
}
