package br.com.schumaker.halogenx64;

import br.com.schumaker.carla.files.O3AsmFile;
import br.com.schumaker.carla.io.AsmFileWriter;
import br.com.schumaker.carla.lexer.o3.O3Atom;
import br.com.schumaker.carla.lexer.o3.O3Function;
import br.com.schumaker.carla.lexer.o3.O3FunctionCall;
import br.com.schumaker.carla.lexer.o3.O3FunctionStatement;
import br.com.schumaker.carla.lexer.o3.O3Variable;
import br.com.schumaker.carla.lexer.utils.StringUtils;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hudson Schumaker
 */
public class HalogenX64Machinery {

    public static final String SPACES_1 = " ";
    public static final String SPACES_2 = "  ";
    private final AsmFileWriter writer;
    private final Halogenx64Variable hx64Variable = new Halogenx64Variable();
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
        this.createUninitializedData();
        this.createSectionText();
        this.writeFile();
    }

    public void createInitializedData() {
        var variables = o3Atom.getVaribleTable().getVariables();
        for (var var : variables) {
            if (var.isInitialized()) {
                this.resolveVaribleTypeValueAndAdd(var);
            }
        }
    }

    /**
     * Create the uninitialized variables and also check the function calls to
     * create a reserved space in memory to hold the function returned data.
     */
    public void createUninitializedData() {
        Set<String> functionReturnMemorySpaces = new HashSet<>();
        for (var func : o3Atom.getFunctions()) {
            var statement = (O3FunctionStatement) func.getStatement();
            for (var call : statement.getFunctionCalls()) {
                functionReturnMemorySpaces.add(this.createFunctionReturnMemorySpace(call));
            }
        }

        for (String line : functionReturnMemorySpaces) {
            if (!StringUtils.isBlankString(line)) {
                this.o3AsmFile.getSectionBss().addLine(line);
            }
        }

        var variables = o3Atom.getVaribleTable().getVariables();
        for (var var : variables) {
            if (!var.isInitialized()) {
                this.createMemorySpaceAndAdd(var);
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
        this.o3AsmFile.getSectionData().addLine(hx64Variable.resolveTypeValueData(o3Var));
    }

    public void createMemorySpaceAndAdd(O3Variable o3Var) {
        this.o3AsmFile.getSectionBss().addLine(hx64Variable.resolveTypeValueBss(o3Var));
    }

    public void resolveFunctionMainAndAdd(O3Function o3Func) {
        this.o3AsmFile.getSectionText().addLine(hx64Fucntion.resolveFunctionMain(o3Func));
    }

    public void resolveFunctionAndAdd(O3Function o3Func) {
        this.o3AsmFile.getSectionText().addLine(hx64Fucntion.resolveFunction(o3Func));
    }

    public String createFunctionReturnMemorySpace(O3FunctionCall call) {
        if (call.isHasReturn()) {
            if (call.getO3return().isReturnToVariable()) {
                return "r_" + call.getO3return()
                        .getInternalName()
                        + ":"
                        + SPACES_1
                        + "resq 1\n";
            }
        }
        return "";
    }
}
