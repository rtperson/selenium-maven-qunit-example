/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chyernobog.seleniumtest;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleniumException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roger
 */
public class SeleniumHelloWorldIntegrationTests {

    public static final String LOCALHOST = "localhost";
    public static final int SELENIUM_PORT = 4444;
    public static final String SELENIUM_BROWSER_START_COMMAND = "*firefox";
    public static final String SELENIUM_BROWSER_URL = "http://localhost:8080/";
    private DefaultSelenium selenium;

    public SeleniumHelloWorldIntegrationTests() {
    }

    @Before
    public void setUp() {
        selenium = createSeleniumClient(SELENIUM_BROWSER_URL);
        selenium.start();
    }

    @After
    public void tearDown() {
        selenium.stop();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void testHelloWorld() {
        try {
            selenium.open(SELENIUM_BROWSER_URL + "/Seleniumtest/");
            String s = selenium.getText("//h1");
            assertEquals("Hello Worldddddd!", s);
        } catch (SeleniumException e) {
            fail(e.getMessage());
        }

    }

    private DefaultSelenium createSeleniumClient(String url) {
        return new DefaultSelenium(LOCALHOST, SELENIUM_PORT,
                SELENIUM_BROWSER_START_COMMAND, SELENIUM_BROWSER_URL);
    }
}
