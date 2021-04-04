package br.com.schumaker.carla.o3.impl;

import br.com.schumaker.carla.io.impl.O3File;
import lombok.Data;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
@Data
public class O3Class {

    private String name;
    private List<O3Variable> variables;
    private List<O3Function> functions;
    private O3File o3File;

    public O3Class(String name, O3File file) {
        this.name = name;
        this.o3File = file;
    }
}
