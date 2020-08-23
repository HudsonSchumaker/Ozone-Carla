package br.com.schumaker.carla.files;

import br.com.schumaker.carla.o3.core.IO3CoreFunction;
import br.com.schumaker.carla.o3.core.O3CoreLibrary;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Hudson Schumaker
 */
@Data
public class O3AsmFileExtern implements IO3AsmFileSection {

    public static final String EXTERN = "extern";
    private List<String> externLines = new ArrayList<>();

    public void addLine(String line) {
        this.externLines.add(line);
    }

    public void addExternalMethod(String name) {
        var line = EXTERN + " _" + name;
        this.externLines.add(line);
    }

    /**
     * Used for now to make the process simple.
     *
     * @throws java.lang.Exception
     */
    public void addAllO3Lib() throws Exception {
        O3CoreLibrary coreLibrary = new O3CoreLibrary();
        List<IO3CoreFunction> functions = coreLibrary.getCoreLibs();
        for (var func : functions) {
            for (var name : func.getOverloadMethods()) {
                this.addExternalMethod(name);
            }
        }
    }
}
