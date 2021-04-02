package br.com.schumaker.carla.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;

/**
 * @author Hudson Schumaker
 */
public class SystemUtils {

    private SystemUtils() {
    }

    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            System.err.println("error get host name.");
        }
        return "Unknown";
    }

    public static String getIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            System.err.println("error get ip.");
        }
        return "0.0.0.0";
    }

    public static String getTempDir() {
        return System.getProperty("java.io.tmpdir");
    }

    public static String getInstallDir() {
        return System.getProperty("user.dir");
    }

    public static String getOsLanguage() {
        return System.getProperty("user.language");
    }

    public static String getOsName() {
        return System.getProperty("os.name");
    }

    public static String getOsVersion() {
        return System.getProperty("os.version");
    }

    public static String getOsArch() {
        return System.getProperty("os.arch");
    }

    public static String getJavaVersion() {
        return System.getProperty("java.version");
    }

    public static String getJavaVendor() {
        return System.getProperty("java.vendor");
    }

    public static String getJvmName() {
        return System.getProperty("java.vm.name");
    }

    public static String getLoggedUserName() {
        return System.getProperty("user.name");
    }

    public static int getNumberProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static String getMaxJvmMemory() {
        long longMax = Runtime.getRuntime().maxMemory();
        String max = Long.toString(longMax);
        double doubleMax = Double.parseDouble(max);
        return toGB(doubleMax);
    }

    public static String getFreeJvmMemory() {
        long longFree = Runtime.getRuntime().freeMemory();
        String free = Long.toString(longFree);
        double doubleFree = Double.parseDouble(free);
        return toMB(doubleFree);
    }

    private static String toGB(double value) {
        DecimalFormat decimal = new DecimalFormat("0.00");
        return decimal.format(((value / 1024.0) / 1024.0) / 1024.0) + " GB";
    }

    private static String toMB(double value) {
        DecimalFormat decimal = new DecimalFormat("0.00");
        return decimal.format(((value / 1024.0) / 1024.0)) + " MB";
    }
}