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

    public static final String SECTION_TEXT = "\nsection .text";
    private List<String> sectionTextLines = new ArrayList<>();
    private List<String> exitCallLines = new ArrayList<>();

    public O3AsmSectionText() {
        this.sectionTextLines.add(SECTION_TEXT);
        this.addEntryPoint();
        this.addMainFunction();
        this.setUpStack();
        this.setUpExitCall();    
    }
    
    public void addLine(String line) {
        sectionTextLines.add("\t" + line);
    }

    public void addEntryPoint() {
        this.sectionTextLines.add("\n\tglobal _main");
    }

    public void addMainFunction() {
        this.sectionTextLines.add("\n\n");
        this.sectionTextLines.add("_main:");
        this.sectionTextLines.add("\n");
    }

    public void setUpStack() {
        this.sectionTextLines.add("\n");
        this.sectionTextLines.add("\tpush      rbp");
        this.sectionTextLines.add("\n");
        this.sectionTextLines.add("\tmov       rbp, rsp");
    }

    public void setUpExitCall() {
        this.exitCallLines.add("\n");
        this.exitCallLines.add("\tmov     rax, 0x02000001");
        this.exitCallLines.add("\n");
        this.exitCallLines.add("\txor     rdi, rdi");
        this.exitCallLines.add("\n");
        this.exitCallLines.add("\tsyscall");
        this.exitCallLines.add("\n");
    }
}
