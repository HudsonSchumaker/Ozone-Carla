package br.com.schumaker.carla.o3.impl;

import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.o3.Statement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
public class O3Statement implements Statement {

    private List<O3FileLine> lines;
}
