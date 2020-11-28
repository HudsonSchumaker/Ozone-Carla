package br.com.schumaker.carla.io;

import lombok.Data;

@Data
public class O3SourceFile {
    public static final String EXT = "o3";

    private String name;
    private String path;
}
