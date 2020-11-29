package br.com.schumaker.carla.io;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SourceFile {
    public static final String EXT = "o3";

    private String name;
    private String path;
    private List<FileLine> lines;
}
