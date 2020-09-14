package old.br.com.schumaker.halogenx64;

import old.br.com.schumaker.carla.files.O3FileUtils;
import old.br.com.schumaker.carla.io.Workspace;

/**
 *
 * @author Hudson Schumaker
 */
public class HalogenX64Workspace {
 
    private String workspacePath;
    public String createWorkspace(String atomName) {
        var cleanName = O3FileUtils.getClearName(atomName);
        System.out.println(System.getProperty("user.dir")+ System.getProperty("file.separator") + cleanName);
        workspacePath = System.getProperty("user.dir")+ System.getProperty("file.separator") + cleanName;
        System.out.println(Workspace.createWorkspace(cleanName));
        return workspacePath;
    }
}
