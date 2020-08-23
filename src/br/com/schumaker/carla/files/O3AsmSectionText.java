package br.com.schumaker.carla.files;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Hudson Schumaker
 */
@Data
public class O3AsmSectionText {
    public static final String SECTION_TEXT = "section .data";
    private List<String> sectionTextLines = new ArrayList<>();
    
    public O3AsmSectionText() {
       this.sectionTextLines.add(SECTION_TEXT);
       this.addEntryPoint();
       this.addMainFunction();
       this.setUpStack();
    }
    
    public void addEntryPoint() {
        this.sectionTextLines.add("\n\tglobal _main");
    }
    
    public void addMainFunction() {
        this.sectionTextLines.add("\n");
        this.sectionTextLines.add("_main:");
    }
    
    public void setUpStack() {
        this.sectionTextLines.add("\n");
        this.sectionTextLines.add("\tpush      rbp");
        this.sectionTextLines.add("\n");
        this.sectionTextLines.add("\tmov       rbp, rsp");
    }
}
