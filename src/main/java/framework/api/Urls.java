package framework.api;

/**
 * class contains available endpoints
 */
public class Urls {

    public static final String LOGIN_URL = "/framework/api/v1/login";
    public static final String FILES_FOLDER_URL = "/framework/api/metagenid/v2/files";
    public static final String FILES_COUNT_URL = "/framework/api/metagenid/v2/files/count";
    public static final String FILES_RUNS_URL = "/framework/api/metagenid/v1/files/%s/runs";
    public static final String FILES_ANALYSES_URL = "/framework/api/metagenid/v1/runs/%s/analysis";
    public static final String FILES_ARTIFACTS_URL = "/framework/api/metagenid/v1/runs/%s/artifacts";
}

