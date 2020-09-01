package br.com.schumaker.halogenx64;

import br.com.schumaker.carla.files.O3AsmFile;
import br.com.schumaker.carla.io.AsmFileWriter;
import br.com.schumaker.carla.lexer.o3.O3Atom;
import br.com.schumaker.carla.lexer.o3.O3Function;
import br.com.schumaker.carla.lexer.o3.O3FunctionStatement;
import br.com.schumaker.carla.lexer.o3.O3Variable;

/**
 *
 * @author Hudson Schumaker
 */
public class HalogenX64Machinery {

    public static final String SPACES_2 = "  ";
    private final AsmFileWriter writer;
    private final HalogenX64Function hx64Fucntion = new HalogenX64Function();

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
        this.createUninitilizedData();
        this.createSectionText();
        this.writeFile();
    }

    public void createInitializedData() {
        var variables = o3Atom.getVaribleTable().getVariables();
        for (var var : variables) {
            this.resolveVaribleTypeValueAndAdd(var);
        }
    }

    public void createUninitilizedData() {
        for (var func : o3Atom.getFunctions()) {
            var statement = (O3FunctionStatement) func.getStatement();
            for (var call : statement.getFunctionCalls()) {
                if (call.isHasReturn()) {
                    if (call.getO3return().isReturnToVariable()) {
                        var b = call.getO3return().getFunctionName();
                        var c = call.getO3return().getInternalName();
                        var d = call.getO3return().getVariableName();
                        var f = call.getO3return().getType();

                        var i = 9;
                    } else {

                    }
                }
            }
        }
    }

    public void createSectionText() {
        var functions = o3Atom.getFunctions();
        for (var func : functions) {
            if (func.isMain()) {
                this.resolveFunctionMainAndAdd(func);
            } else {
                this.resolveFunctionAndAdd(func);
            }
        }
    }

    public void writeFile() {
        writer.write(o3AsmFile);
    }

    public void resolveVaribleTypeValueAndAdd(O3Variable o3Var) {
        Halogenx64Variable hx64Variable = new Halogenx64Variable();
        this.o3AsmFile.getSectionData().addLine(hx64Variable.resolveTypeValue(o3Var));
    }

    public void resolveFunctionMainAndAdd(O3Function o3Func) {
        this.o3AsmFile.getSectionText().addLine(hx64Fucntion.resolveFunctionMain(o3Func));
    }

    public void resolveFunctionAndAdd(O3Function o3Func) {
        this.o3AsmFile.getSectionText().addLine(hx64Fucntion.resolveFunction(o3Func));
    }
}
