package br.com.schumaker.carla.files;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Hudson Schumaker
 */
@Data
public class O3AsmSectionData implements IO3AsmFileSection {

    public static final String SECTION_DATA = "section .data";
    private List<String> sectionDataLines = new ArrayList<>();
                
    public O3AsmSectionData() {
        sectionDataLines.add(SECTION_DATA);
    }

    public void addLine(String line) {
        this.sectionDataLines.add("\t" + line);
    }
}
