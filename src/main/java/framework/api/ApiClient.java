package framework.api;

import io.restassured.response.Response;
import org.json.JSONObject;

import static utils.PropertiesLoader.DEFAULT_LIMIT;
import static utils.PropertiesLoader.AUTH_BASIC;
import static utils.PropertiesLoader.EXPIRATION_TIME_FOR_TOKEN;
import static utils.PropertiesLoader.LOGIN_FROM;

import java.util.HashMap;


/**
 * class contains requests for available endpoints
 */
public class ApiClient extends BaseRequests {

    /**
     * string for building dynamic custom url. Depends on items ID
     */
    private String url;

    /**
     * method sets up auth token for executing requests
     *
     * @return Response object
     * @throws Exception if token is NULL
     */
    public Response setToken() throws Exception {
        //set up headers
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", AUTH_BASIC);

        //set up body
        JSONObject body = new JSONObject();
        body.put("expiry", EXPIRATION_TIME_FOR_TOKEN);
        body.put("login_from", LOGIN_FROM);

        //execute request
        Response response = post(Urls.LOGIN_URL, headers, body);
        String token = response.jsonPath().getString("token");

        if (token == null) {
            throw new Exception("Token is empty");
        }
        //set up token
        super.setToken(token);
        return response;
    }

    /**
     * method execute login request
     *
     * @return Response object
     */
    public Response login() {
        Response response = null;
        try {
            response = this.setToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * method execute getFilesFromRootFolder request
     *
     * @param optionalParams (optional parameters: param 1 - limit (has default value), param 2 - breadcrumbs; param 3: offset)
     * @return Response object
     */
    public Response getFilesFromRootFolder(String... optionalParams) {
        //set up queryParams
        HashMap<String, String> queryParams = new HashMap<>();
        // Option for optional params
        int length = optionalParams.length;
        switch (length) {
            case 3:
                queryParams.put("offset", optionalParams[2]);
            case 2:
                queryParams.put("breadcrumbs", optionalParams[1]);
            case 1:
                queryParams.put("limit", optionalParams[0]);
                break;
            // set default value if limit is NULL
            case 0:
                queryParams.put("limit", setUpLimit());
        }
        //execute request
        return get(Urls.FILES_FOLDER_URL, queryParams);
    }

    /**
     * method execute getFilesFromSpecificFolder request
     *
     * @param folderID
     * @param optionalParams (param 1 - limit, param 2 - breadcrumbs)
     * @return Response object
     */
    public Response getFilesFromSpecificFolder(String folderID, String... optionalParams) {
        //set up queryParams
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("folder_id", folderID);
        // Option for optional params
        int length = optionalParams.length;
        switch (length) {
            case 2:
                queryParams.put("breadcrumbs", optionalParams[1]);
            case 1:
                queryParams.put("limit", optionalParams[0]);
                break;
            case 0:
                // set default value for limit if it isn't specified
                queryParams.put("limit", setUpLimit());
        }
        //execute request
        return get(Urls.FILES_FOLDER_URL, queryParams);
    }

    /**
     * method execute getFilesCountByFolderID request
     *
     * @param folderID
     * @return Response object
     */
    public Response getFilesCountByFolderID(String folderID) {
        //set up queryParams
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("folder_id", folderID);
        //execute request
        return get(Urls.FILES_COUNT_URL, queryParams);
    }

    /**
     * method execute getRunsByFileID request
     *
     * @param fileID
     * @return Response object
     */
    public Response getRunsByFileID(String fileID) {
        //set up url with specified fileID
        url = String.format(Urls.FILES_RUNS_URL, fileID);
        //set up queryParams
        HashMap<String, String> queryParams = new HashMap<>();
        //execute request
        return get(url, queryParams);
    }

    /**
     * method execute getAnalysesByRunID request
     *
     * @param runID
     * @param optionalParams (param 1 - filter)
     * @return Response object
     */
    public Response getAnalysesByRunID(String runID, String... optionalParams) {
        //set up url with specified runID
        url = String.format(Urls.FILES_ANALYSES_URL, runID);
        //set up queryParams
        HashMap<String, String> queryParams = new HashMap<>();
        // Option for optional params
        int length = optionalParams.length;
        switch (length) {
            case 1:
                queryParams.put("filter", optionalParams[0]);
        }
        //execute request
        return get(url, queryParams);
    }


    /**
     * method execute getArtifactsByRunID request
     *
     * @param runID
     * @return Response object
     */
    public Response getArtifactsByRunID(String runID) {
        //set up url with specified runID
        url = String.format(Urls.FILES_ARTIFACTS_URL, runID);
        //set up queryParams
        HashMap<String, String> queryParams = new HashMap<>();
        //execute request
        return get(url, queryParams);
    }

    /**
     * Method returns default value for limit
     *
     * @return default value for limit
     */
    private String setUpLimit() {
        // Option for params you would like to hide from code but they are mandatory for HTTP request
        return DEFAULT_LIMIT;
    }
}
