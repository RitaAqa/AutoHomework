import static org.testng.Assert.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import app.ApiClient;

public class ExampleTests {

    ApiClient apiClient;
    static final Logger logger = LoggerFactory.getLogger(ExampleTests.class);

    @BeforeClass
    public void setUp() {

        apiClient = new ApiClient();
        apiClient.login();
    }

    @Test
    public void testLoginIsSuccessfull() {
        logger.info("Test Login");
        assertNotNull(apiClient.login().jsonPath().getString("token"));
    }

    @Test
    public void testGetFilesFromRootFolder() {
        logger.info("Test GetFilesFromRootFolder");
        assertNotNull(apiClient.getFilesFromRootFolder().jsonPath().getString("items"));
        assertEquals(apiClient.getFilesFromRootFolder().jsonPath().get("total").toString(), "580");

    }

    @Test
    public void testGetFilesFromSpecificFolder() {
        logger.info("Test GetFilesFromSpecificFolder");
        assertNotNull(apiClient.getFilesFromSpecificFolder("84c966d5-8dce-429d-8f92-44d5e28b1581"));
        assertEquals(apiClient.getFilesFromSpecificFolder("84c966d5-8dce-429d-8f92-44d5e28b1581").jsonPath().get("total").toString(), "59");

    }

    @Test
    public void testGetFilesCount() {
        logger.info("Test GetFilesCount");
        assertNotNull(apiClient.getFilesCount("84c966d5-8dce-429d-8f92-44d5e28b1581"));
        assertNotNull(apiClient.getFilesCount("84c966d5-8dce-429d-8f92-44d5e28b1581").jsonPath().getString("total"));
    }

    @Test
    public void testGetGetRuns() {
        logger.info("Test GetGetRuns");
        assertNotNull(apiClient.getRuns());
    }

    @Test
    public void testGetAnalyses() {
        logger.info("Test GetAnalyses");
        assertNotNull(apiClient.getGetAnalyses());
    }

    @Test
    public void testGetArtifacts() {
        logger.info("Test GetArtifacts");
        assertNotNull(apiClient.getGetArtifacts());
    }

}
