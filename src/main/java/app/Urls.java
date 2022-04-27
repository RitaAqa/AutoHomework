package app;

/* class contains available endpoints*/
public class Urls {

    public static final String LOGIN_URL = "/api/v1/login";
    public static final String FILES_FOLDER_URL = "/api/metagenid/v2/files";
    public static final String FILES_COUNT_URL = "/api/metagenid/v2/files/count";
    public static final String FILES_GET_RUNS_URL = "/api/metagenid/v1/files/%s/runs";
    public static final String FILES_GET_ANALYSES_URL = "/api/metagenid/v1/runs/%s/analysis";
    public static final String FILES_GET_ARTIFACTS_URL = "/api/metagenid/v1/runs/%s/artifacts";
}

