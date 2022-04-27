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
        logger.info("Test setup");
        apiClient = new ApiClient();
        apiClient.setToken();
    }

    @Test
    public void testLoginIsSuccessfull() {
        logger.info("Test Login");
        assertNotNull(apiClient.login().jsonPath().getString("token"));
    }

    @Test
    public void testGetFilesFromRootFolder() {
        logger.info("Test GetFilesFromRootFolder");
        assertEquals(apiClient.getFilesFromRootFolder(null).statusCode(), 200, "status code is 200");
        assertEquals(apiClient.getFilesFromRootFolder(null).jsonPath().get("total").toString(), "20", "Default numbers of record is selected");
        assertEquals(apiClient.getFilesFromRootFolder("10", "1", "0").jsonPath().get("total").toString(), "10", "Custom (10) numbers of record is selected");
    }

    @Test
    public void testGetFilesFromSpecificFolder() {
        logger.info("Test GetFilesFromSpecificFolder");
        assertEquals(apiClient.getFilesFromSpecificFolder(null, null).jsonPath().get("breadcrumbs[0].id").toString(), "84c966d5-8dce-429d-8f92-44d5e28b1581","Default folder is selected");
    }

    @Test
    public void testGetFilesCount() {
        logger.info("Test GetFilesCount");
        assertNotNull(apiClient.getFilesCount("84c966d5-8dce-429d-8f92-44d5e28b1581"));
        assertNotNull(apiClient.getFilesCount(null).jsonPath().getString("total"));
    }

    @Test
    public void testGetGetRuns() {
        logger.info("Test GetGetRuns");
        assertNotNull(apiClient.getRuns(null));
    }

    @Test
    public void testGetAnalyses() {
        logger.info("Test GetAnalyses");
        assertNotNull(apiClient.getAnalyses(null, "total"));
    }

    @Test
    public void testGetArtifacts() {
        logger.info("Test GetArtifacts");
        assertNotNull(apiClient.getArtifacts(null));
    }

}
