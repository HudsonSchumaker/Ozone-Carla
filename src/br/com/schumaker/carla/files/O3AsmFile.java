package br.com.schumaker.carla.files;

import br.com.schumaker.carla.exception.AsmFilePreProcesserException;
import lombok.Data;

/**
 *
 * @author Hudson Schumaker
 */
@Data
public class O3AsmFile {

    public static final String EXT = "asm";
    private O3AsmFileHeader header;
    private O3AsmFileExtern extern;
    private O3AsmSectionData sectionData;
    private O3AsmSectionText sectionText;

    public O3AsmFile() {
        try {
            this.header = new O3AsmFileHeader();
            this.extern = new O3AsmFileExtern();
            this.sectionData = new O3AsmSectionData();
            this.sectionText = new O3AsmSectionText();
        } catch (Exception e) {
            throw new AsmFilePreProcesserException();
        }
    }
}
