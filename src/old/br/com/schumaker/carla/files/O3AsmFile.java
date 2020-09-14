package old.br.com.schumaker.carla.files;

import br.com.schumaker.carla.build.exception.AsmFilePreProcessorException;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author Hudson Schumaker
 */
@Data
@ToString
public class O3AsmFile {

    public static final String EXT = "asm";
    private String name;
    private O3AsmFileHeader header;
    private O3AsmFileExtern extern;
    private O3AsmSectionData sectionData;
    private O3AsmSectionBss sectionBss;
    private O3AsmSectionText sectionText;

    public O3AsmFile(String name) {
        this.name = name;
        try {
            this.header = new O3AsmFileHeader();
            this.extern = new O3AsmFileExtern();
            this.sectionData = new O3AsmSectionData();
            this.sectionBss = new O3AsmSectionBss();
            this.sectionText = new O3AsmSectionText();
        } catch (Exception e) {
            throw new AsmFilePreProcessorException();
        }
    }
}
