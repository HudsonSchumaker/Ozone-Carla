package br.com.schumaker.carla.o3.core;

import br.com.schumaker.carla.o3.O3SyntaxFunctionTable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
public class O3CoreLibrary implements IO3CoreLibrary {

    private O3SyntaxFunctionTable syntaxFunctionTable;
    private List<IO3CoreFunction> coreLibrary = new ArrayList<>();
    
    public O3CoreLibrary() throws Exception {
        this.syntaxFunctionTable = new O3SyntaxFunctionTable();
        this.loadCoreFunctions();
    }
    
    @Override
    public void addCoreFunction(IO3CoreFunction coreFunction) {
        this.coreLibrary.add(coreFunction);
    }
    
    @Override
    public List<IO3CoreFunction> getCoreLibs() {
        return this.coreLibrary;
    }
    
    @Override
    public IO3CoreFunction getByName(String name) {
       return coreLibrary.stream()
                .parallel()
                .filter(v -> v.getO3Name().equals(name))        
                .findAny()
                .orElse(null);
    }
    
    private void loadCoreFunctions() throws Exception {
        // Print Lib
        this.coreLibrary.add(new O3Print(syntaxFunctionTable));
        this.coreLibrary.add(new O3PrintLn(syntaxFunctionTable));
        
        // Strings Lib
        this.coreLibrary.add(new O3UpperCase(syntaxFunctionTable));
        this.coreLibrary.add(new O3LowerCase(syntaxFunctionTable));
        this.coreLibrary.add(new O3CamelCase(syntaxFunctionTable));
        this.coreLibrary.add(new O3PascalCase(syntaxFunctionTable));
        this.coreLibrary.add(new O3SnakeCase(syntaxFunctionTable));
        this.coreLibrary.add(new O3KebabCase(syntaxFunctionTable));
    }
}