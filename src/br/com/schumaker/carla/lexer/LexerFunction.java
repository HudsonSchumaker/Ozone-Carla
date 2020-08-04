package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3File;
import br.com.schumaker.carla.files.O3FileLine;
import br.com.schumaker.carla.o3.O3Function;
import br.com.schumaker.carla.o3.O3Keyword;
import br.com.schumaker.carla.o3.O3Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * This class create the O³ functions representations.
 * @author schumaker
 */
public class LexerFunction {
    
    public List<O3Function> getFunctions(O3File file) {
        var headerLines = this.getHeaderLines(file);
        var functions = new ArrayList<O3Function>();
       
        for (O3FileLine line : headerLines) {
            functions.add(this.setStatement(line, file));
        }
        
        var lexerStatement = new LexerStatement();
        lexerStatement.getFunctionStatements(functions);
        
        return functions;
    }
    
    public O3Function setStatement(O3FileLine headerLine, O3File file) {
        var endBlock = "";
        var k = headerLine.getInternalNumber();
        var functionLines = new ArrayList<O3FileLine>();
        while(!endBlock.equals(O3Keyword.CLOSE_STATEMENT)) {
            functionLines.add(file.getLines().get(k));
            endBlock = file.getLines().get(k).getData();
            k++;
        }
       
        return new O3Function (this.getFunctionName(headerLine.getData()),
                this.isMainFunction(headerLine), 
                new O3Statement(functionLines));
    }
    

    public List<O3FileLine> getHeaderLines(O3File file) {
        var headerLines = new ArrayList<O3FileLine>();
        for (O3FileLine line : file.getLines()) {
            if (line.isFunctionHeader()) {
                headerLines.add(line);
            }
        }
        return headerLines;
    }
    
    public String getFunctionName(String data) {
        var name = data.substring(O3Keyword.FUNCTION.length(), data.length()).trim();
        name = name.substring(0, name.indexOf(O3Keyword.OPEN_EXPRESSION));
        return name;
    }
    
    public boolean isMainFunction(O3FileLine headerLine) {
        return headerLine.getData().contains("f: main()");
    }
}
