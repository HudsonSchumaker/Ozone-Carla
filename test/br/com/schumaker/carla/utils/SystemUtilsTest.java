package br.com.schumaker.carla.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Hudson Schumaker
 */
public class SystemUtilsTest {

    @Test
    public void getHostNameTest() {
        // Test
        var result = SystemUtils.getHostName();

        // Assertion
        Assert.assertNotNull(result);
    }

    @Test
    public void getIpTest() {
        // Test
        var result = SystemUtils.getIp();

        // Assertion
        Assert.assertNotNull(result);
        Assert.assertTrue(result.contains("."));
    }

    @Test
    public void getInstallDirTest() {
        // Test
        var result = SystemUtils.getInstallDir();

        // Assertion
        Assert.assertNotNull(result);
    }

    @Test
    public void getOsNameTest() {
        // Test
        var result = SystemUtils.getOsName();

        // Assertion
        Assert.assertNotNull(result);
    }

    @Test
    public void getOsVersionTest() {
        // Test
        var result = SystemUtils.getOsVersion();

        // Assertion
        Assert.assertNotNull(result);
    }

    @Test
    public void getOsArchTest() {
        // Test
        var result = SystemUtils.getOsArch();

        // Assertion
        Assert.assertNotNull(result);
    }

    @Test
    public void getJavaVersionTest() {
        // Test
        var result = SystemUtils.getJavaVersion();

        // Assertion
        Assert.assertNotNull(result);
    }

    @Test
    public void getJavaVendorTest() {
        // Test
        var result = SystemUtils.getJavaVendor();

        // Assertion
        Assert.assertNotNull(result);
    }

    @Test
    public void getJvmName() {
        // Test
        var result = SystemUtils.getJvmName();

        // Assertion
        Assert.assertNotNull(result);
    }

    @Test
    public void getLoggedUserNameTest() {
        // Test
        var result = SystemUtils.getLoggedUserName();

        // Assertion
        Assert.assertNotNull(result);
    }

    @Test
    public void getNumberProcessors() {
        // Test
        var result = SystemUtils.getNumberProcessors();

        // Assertion
        Assert.assertNotNull(result);
    }
}
