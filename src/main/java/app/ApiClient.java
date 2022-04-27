package app;

import io.restassured.response.Response;
import org.json.JSONObject;

import static app.Urls.LOGIN_URL;
import static app.Urls.FILES_GET_ARTIFACTS_URL;
import static app.Urls.FILES_FOLDER_URL;
import static app.Urls.FILES_GET_ANALYSES_URL;
import static app.Urls.FILES_GET_RUNS_URL;
import static app.Urls.FILES_COUNT_URL;
import static utils.PropertiesLoader.DEFAULT_LIMIT;
import static utils.PropertiesLoader.DEFAULT_FILE_ID;
import static utils.PropertiesLoader.DEFAULT_FILTER;
import static utils.PropertiesLoader.DEFAULT_FOLDER_ID;
import static utils.PropertiesLoader.DEFAULT_RUN_ID;
import static utils.PropertiesLoader.AUTH_BASIC;
import static utils.PropertiesLoader.EXPIRATION_TIME_FOR_TOKEN;
import static utils.PropertiesLoader.LOGIN_FROM;

import java.util.HashMap;


/*class contains requests for available end points */
public class ApiClient extends BaseRequests {

    /*method sets up auth token for executing requests*/
    public Response setToken() {
        //set up headers
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", AUTH_BASIC);
        //set up body
        JSONObject body = new JSONObject();
        body.put("expiry", EXPIRATION_TIME_FOR_TOKEN);
        body.put("login_from", LOGIN_FROM);

        //execute request
        Response response = post(LOGIN_URL, headers, body);
        String token = response.jsonPath().getString("token");
        //set up token
        super.setToken(token);
        return response;
    }

    public Response login() {
        Response response = this.setToken();
        return response;
    }

    /*
    required parameter, not NULL: limit
    optional parameters: param 1:  breadcrumbs; param 2: offset
    */
    public Response getFilesFromRootFolder(String limit, String... optionalParams) {
        //set up headers
        HashMap<String, String> headers = new HashMap<>();
        //set up queryParams
        // set default value if limit is NULL
        limit = setUpLimit(limit);
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("limit", limit);

        // Option for optional params
        if (optionalParams.length > 0 && optionalParams[0] != null) {
            queryParams.put("breadcrumbs", optionalParams[0]);
        }
        if (optionalParams.length > 1 && optionalParams[1] != null) {
            queryParams.put("offset", optionalParams[1]);
        }
        //execute request
        return get(FILES_FOLDER_URL, headers, queryParams);
    }

    /*
   required parameter, not NULL: folderID, limit
   optional parameters: param 1:  breadcrumbs;
   */
    public Response getFilesFromSpecificFolder(String folderID, String limit, String... optionalParams) {
        //set up headers
        HashMap<String, String> headers = new HashMap<>();
        //set up queryParams
        // set default value if folderID is NULL
        folderID = setUpFolderID(folderID);
        // set default value if limit is NULL
        limit = setUpLimit(limit);
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("folder_id", folderID);
        queryParams.put("limit", limit);

        // Option for optional params
        if (optionalParams.length > 0 && optionalParams[0] != null) {
            queryParams.put("breadcrumbs", optionalParams[0]);
        }
        //execute request
        return get(FILES_FOLDER_URL, headers, queryParams);
    }

    /*
    required parameter, not NULL: folderID
    */
    public Response getFilesCount(String folderID) {
        //set up headers
        HashMap<String, String> headers = new HashMap<>();
        //set up queryParams
        // set default value if folderID is NULL
        folderID = setUpFolderID(folderID);
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("folder_id", folderID);
        //execute request
        return get(FILES_COUNT_URL, headers, queryParams);
    }


    /*
    required parameter, not NULL: fileID
    */
    public Response getRuns(String fileID) {
        // set default value if fileID is NULL
        fileID = setUpFileID(fileID);
        //set up url
        String url = String.format(FILES_GET_RUNS_URL, fileID);
        //set up headers
        HashMap<String, String> headers = new HashMap<>();
        //set up queryParams
        HashMap<String, String> queryParams = new HashMap<>();
        //execute request
        return get(url, headers, queryParams);
    }

    /*
    required parameter, not NULL: runID, filter
    */
    public Response getAnalyses(String runID, String filter) {
        // set default value if runID is NULL
        runID = setUpRunID(runID);
        //set up url
        String url = String.format(FILES_GET_ANALYSES_URL, runID);
        //set up headers
        HashMap<String, String> headers = new HashMap<>();

        //set up queryParams
        // set default value if filter is NULL
        filter = setUpFilter(filter);
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("filter", filter);
        //execute request
        return get(url, headers, queryParams);
    }

    /*
    required parameter: runID
    */
    public Response getArtifacts(String runID) {
        // set default value if runID is NULL
        runID = setUpRunID(runID);
        //set up url
        String url = String.format(FILES_GET_ARTIFACTS_URL, runID);
        //set up headers
        HashMap<String, String> headers = new HashMap<>();
        //set up queryParams
        HashMap<String, String> queryParams = new HashMap<>();
        //execute request
        return get(url, headers, queryParams);
    }

    /* Method sets up default value for runID*/
    private String setUpRunID(String runID) {
        // Option for params you would like to hide from code but they are mandatory for HTTP request
        if (null == runID) {
            runID = DEFAULT_RUN_ID;
        }
        return runID;
    }

    /* Method sets up default value for filter*/
    private String setUpFilter(String filter) {
        // Option for params you would like to hide from code but they are mandatory for HTTP request
        if (null == filter) {
            filter = DEFAULT_FILTER;
        }
        return filter;
    }

    /* Method sets up default value for fileID*/
    private String setUpFileID(String fileID) {
        // Option for params you would like to hide from code but they are mandatory for HTTP request
        if (null == fileID) {
            fileID = DEFAULT_FILE_ID;
        }
        return fileID;
    }

    /* Method sets up default value for folderID*/
    private String setUpFolderID(String folderID) {
        // Option for params you would like to hide from code but they are mandatory for HTTP request
        if (null == folderID) {
            folderID = DEFAULT_FOLDER_ID;
        }
        return folderID;
    }

    /* Method sets up default value for limit*/
    private String setUpLimit(String limit) {
        // Option for params you would like to hide from code but they are mandatory for HTTP request
        if (null == limit) {
            limit = DEFAULT_LIMIT;
        }
        return limit;
    }

}
