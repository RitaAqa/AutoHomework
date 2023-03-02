package api;

import static org.testng.Assert.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import framework.api.ApiClient;

/**
 * class contains API tests
 */
public class ExampleTestsAPI {

    ApiClient apiClient;
    static final Logger logger = LoggerFactory.getLogger(ExampleTestsAPI.class);

 /*   @BeforeClass(description = "Test setup")
    public void setUp() {
        apiClient = new ApiClient();
        try {
            apiClient.setToken();
        } catch (Exception e) {
            logger.error("Token is missed. Test cases are skipped");
            // stops test-cases execution as token is missed
            throw new SkipException("Testing is stopped");
        }
    }

    @Test(description = "Verify that login is successful")
    public void testLoginIsSuccessful() {
        assertNotNull(apiClient.login().jsonPath().getString("token"));
    }

    @Test(description = "Verify that files from root folder are returned")
    public void testGetFilesFromRootFolder() {
        assertNotNull(apiClient.getFilesFromRootFolder());
    }

    @Test(description = "Verify that custom number of files from root folder are returned")
    public void testGetCustomNumbersOfFilesFromRootFolder() {
        assertEquals(apiClient.getFilesFromRootFolder("10").jsonPath().get("total").toString(), "10", "Custom (10) number of records is selected");
    }

    @Test(description = "Verify that files from specific folder are selected")
    public void testGetFilesFromSpecificFolder() {
        assertEquals(apiClient.getFilesFromSpecificFolder("84c966d5-8dce-429d-8f92-44d5e28b1581").jsonPath().get("breadcrumbs[0].id").toString(), "84c966d5-8dce-429d-8f92-44d5e28b1581", "Default folder is selected");
    }

    @Test(description = "Verify that files count for specific folder is returned")
    public void testGetFilesCountByFolderID() {
        assertNotNull(apiClient.getFilesCountByFolderID("84c966d5-8dce-429d-8f92-44d5e28b1581").jsonPath().getString("total"));
    }

    @Test(description = "Verify that runs for specific fileID are returned")
    public void testGetRunsByFileID() {
        assertNotNull(apiClient.getRunsByFileID("7f4c7326-0a4e-4b56-a8d0-8ce002191672"));
    }

    @Test(description = "Verify that analyses for specific runID are returned")
    public void testGetAnalyses() {
        assertNotNull(apiClient.getAnalysesByRunID("437ef8e4-b595-4fd8-a2f5-64221831e925"));
    }

    @Test(description = "Verify that artifacts for specific runID are returned")
    public void testGetArtifacts() {
        assertNotNull(apiClient.getArtifactsByRunID("437ef8e4-b595-4fd8-a2f5-64221831e925"));
    }
*/
}
