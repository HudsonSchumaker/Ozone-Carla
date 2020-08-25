package br.com.schumaker.halogenx64;

import br.com.schumaker.carla.files.O3AsmFile;
import br.com.schumaker.carla.io.AsmFileWriter;
import br.com.schumaker.carla.lexer.o3.O3Atom;
import br.com.schumaker.carla.lexer.o3.O3Variable;

/**
 *
 * @author Hudson Schumaker
 */
public class HalogenX64Machinery {

    private static final String SPACES_2 = "  ";
    private final X64O3Variable2AsmMapper mapper = new X64O3Variable2AsmMapper();
    private final AsmFileWriter writer;

    private String workspace;
    private O3Atom o3Atom;
    private O3AsmFile o3AsmFile;

    public HalogenX64Machinery(String workspace, O3Atom o3Atom, O3AsmFile o3AsmFile) {
        this.o3Atom = o3Atom;
        this.o3AsmFile = o3AsmFile;
        this.workspace = workspace;
        this.writer = new AsmFileWriter(this.workspace);
    }

    public void processO3AsmFile() {
        this.createInitializedData();
        this.writeFile();
    }

    public void createInitializedData() {
        var variables = o3Atom.getVaribleTable().getVariables();
        for (var var : variables) {
            this.resolveTypeValueAndAdd(var);
        }
    }

    public void writeFile() {
       writer.write(o3AsmFile);
    }

    public void resolveTypeValueAndAdd(O3Variable o3Var) {
        StringBuffer buffer = new StringBuffer();

        // internal name
        buffer.append(o3Var.getInternalName());
        buffer.append(SPACES_2);

        // type
        buffer.append(mapper.getAsmType(o3Var.getTypeValue().getType().getName()));
        buffer.append(SPACES_2);

        // value
        var value = o3Var.getTypeValue().getValue();
        if (value instanceof String) {
            buffer.append(value);
            buffer.append(" , 0x0");
        } else {
            buffer.append(value);
        }
        buffer.append("\n");
        this.o3AsmFile.getSectionData().addLine(buffer.toString());
    }
}
