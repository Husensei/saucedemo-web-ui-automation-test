package stepDefinition;

import io.cucumber.java.*;

import static helper.Utility.startDriver;
import static helper.Utility.quitDriver;

public class Hooks {

    @BeforeAll
    public static void setUp() {
    }

    @AfterAll
    public static void tearDown() {
    }

    @Before
    public void beforeTest() {
        startDriver();
    }

    @After
    public void afterTest() throws InterruptedException {
        Thread.sleep(3000);
        quitDriver();
    }
}