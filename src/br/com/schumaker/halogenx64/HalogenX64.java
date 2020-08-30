package br.com.schumaker.halogenx64;

import br.com.schumaker.carla.files.O3AsmFile;
import br.com.schumaker.carla.files.O3FileUtils;
import br.com.schumaker.carla.lexer.o3.O3Atom;
import java.io.IOException;

/**
 * This class orchestrates all the machine code creation.
 *
 * @author Hudson Schumaker
 */
public class HalogenX64 {

    private String workspacePath;
    private HalogenX64Workspace workspace;
    
    public HalogenX64() {
        this.workspace = new HalogenX64Workspace();
    }

    public void processO3Atom(O3Atom o3Atom) throws IOException {
        var atomName =  O3FileUtils.getClearName(o3Atom.getName());
        this.workspacePath = this.workspace.createWorkspace(atomName);
        
        var asmFile = this.createAsmFile(atomName);
        var machinery = new HalogenX64Machinery(workspacePath, o3Atom, asmFile);
        machinery.processO3AsmFile();
        
        var crossCompiler = new HalogenX64CrossCompiler(atomName);
        crossCompiler.execCompilation();
    }
    
    public O3AsmFile createAsmFile(String atomName) {
        return new O3AsmFile(atomName);
    }
}
