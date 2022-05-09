package app.api;

/**
 * class contains available endpoints
 */
public class Urls {

    public static final String LOGIN_URL = "/app/api/v1/login";
    public static final String FILES_FOLDER_URL = "/app/api/metagenid/v2/files";
    public static final String FILES_COUNT_URL = "/app/api/metagenid/v2/files/count";
    public static final String FILES_RUNS_URL = "/app/api/metagenid/v1/files/%s/runs";
    public static final String FILES_ANALYSES_URL = "/app/api/metagenid/v1/runs/%s/analysis";
    public static final String FILES_ARTIFACTS_URL = "/app/api/metagenid/v1/runs/%s/artifacts";
}

