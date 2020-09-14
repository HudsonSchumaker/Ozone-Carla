package old.br.com.schumaker.carla.files;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Hudson Schumaker
 */
@Data
public class O3AsmSectionBss implements IO3AsmFileSection {

    public static final String SECTION_BSS = "\nsection .bss\n";
    private List<String> sectionBssLines = new ArrayList<>();
    
    public O3AsmSectionBss() {
        this.sectionBssLines.add(SECTION_BSS);
    }

    @Override
    public void addLine(String line) {
        this.sectionBssLines.add("\t" + line);
    }
}
