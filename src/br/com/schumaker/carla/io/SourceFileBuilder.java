package br.com.schumaker.carla.io;

/**
 * This class builds O3 SourceFiles.
 *
 * @see SourceFile
 * @author Hudson Schumaker
 */
public class SourceFileBuilder implements FileBuilder<SourceFile> {

    @Override
    public SourceFile build(String path) throws Exception {
        var o3FileReader = new SourceFileReader();
        var lines = o3FileReader.read(path);



        return null;
    }
}
