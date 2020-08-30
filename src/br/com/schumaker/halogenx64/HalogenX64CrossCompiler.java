package br.com.schumaker.halogenx64;

import br.com.schumaker.carla.build.Terninal;
import br.com.schumaker.carla.io.CopyNASM;
import br.com.schumaker.carla.io.CopyO3oLib;
import br.com.schumaker.carla.io.MakeFileWriter;
import br.com.schumaker.carla.io.Zip;
import br.com.schumaker.carla.o3.O3SyntaxLibrary;
import java.io.IOException;

/**
 *
 * @author Hudson Schumaker
 */
public class HalogenX64CrossCompiler {

    private String atomName;

    public HalogenX64CrossCompiler(String atomName) {
        this.atomName = atomName;
    }

    public void execCompilation() throws IOException {
        this.copyNASM();
        this.copyOLibs();
        this.createMakefileFile();
        this.callMakefileFile();
    }

    public void callMakefileFile() {
        var bash = new Terninal();
//        String[] commands = {"cd " + atomName, "make", "make clear", "rm Makefile",
//            "clear",
//            "echo ----------------------------------------------------------------",
//            "./" + atomName, "exit"};

        String[] commands = {"cd " + atomName, "make",
            "clear",
            "echo ----------------------------------------------------------------",
            "./" + atomName, "exit"};
        bash.executeCommand(commands);
    }

    public void copyNASM() throws IOException {
        new CopyNASM().copyNASMZipFile(atomName);
        new Zip().unzipFile(atomName);
    }

    public void copyOLibs() throws IOException {
        var copy = new CopyO3oLib(atomName);
        copy.copyOByName(O3SyntaxLibrary.PRINT_O);
        copy.copyOByName(O3SyntaxLibrary.STRINGS_O);
    }

    public void createMakefileFile() {
        new MakeFileWriter().write(atomName);
    }
}
