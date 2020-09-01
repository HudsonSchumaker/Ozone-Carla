package br.com.schumaker.carla.lexer.o3;

import br.com.schumaker.carla.files.O3FileLine;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Hudson Schumaker
 */
@Data
@AllArgsConstructor
public class O3VariableTable implements IO3VariableTable {
   private List<O3FileLine> lines;
}