package old.br.com.schumaker.carla.lexer.o3;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import old.br.com.schumaker.carla.files.O3FileLine;

/**
 *
 * @author Hudson Schumaker
 */
@Data
@ToString
@AllArgsConstructor
public class O3VariableTable implements IO3VariableTable {
   private List<O3FileLine> lines;
}