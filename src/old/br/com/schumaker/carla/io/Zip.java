package old.br.com.schumaker.carla.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author Hudson Schumaker
 */
public final class Zip {

    /**
     * This is method is responsible for unzip the NASM compiler file.
     *
     * @param atomName
     * @throws IOException
     */
    public void unzipFile(String atomName) throws IOException {
        this.createNASMDir(atomName);
        var nasmZip = this.createVirtualZipPath(atomName);
        var destDir = this.createDestinationDir(atomName);

        FileInputStream fis;
        byte[] buffer = new byte[2048];
        try {
            fis = new FileInputStream(nasmZip);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);

                if (!ze.isDirectory()) {
                    new File(newFile.getParent()).mkdirs();
                    FileOutputStream fos = new FileOutputStream(newFile);

                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                } else {
                    newFile.mkdir();
                }

                zis.closeEntry();
                ze = zis.getNextEntry();
            }

            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            throw e;
        }
    }

    public void createNASMDir(String workspace) {
        var dir = new File(System.getProperty("user.dir")
                + System.getProperty("file.separator")
                + workspace
                + System.getProperty("file.separator")
                + "nasm");
        
        dir.mkdir();
    }

    public String createVirtualZipPath(String workspace) {
        return System.getProperty("user.dir")
                + System.getProperty("file.separator")
                + workspace
                + System.getProperty("file.separator")
                + "nasm.zip";
    }

    public File createDestinationDir(String workspace) {
        return new File(System.getProperty("user.dir")
                + System.getProperty("file.separator")
                + workspace);
    }
}
