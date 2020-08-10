package br.com.schumaker.carla.build;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author schumaker
 */
public class Terninal implements Zsh {

    @Override
    public void executeCommnad(String command) {
        new Thread(() -> {
            Process process = null;
            try {
                process = Runtime.getRuntime().exec(command);
                InputStream is = process.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                process.destroy();
            }
        }).start();
    }
}
