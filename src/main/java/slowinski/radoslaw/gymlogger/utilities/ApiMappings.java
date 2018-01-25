package slowinski.radoslaw.gymlogger.utilities;

public class ApiMappings {
    // POST
    public static final String API_REGISTRATION = "/registration";
    // GET
    public static final String API_GET_TRAINING = "/training/{trainingLogId}";
    public static final String API_GET_EXERCISE = "/training/exercise/{exerciseLogId}";
    public static final String API_GET_SERIES = "/training/exercise/series/{seriesLogId}";
    // POST
    public static final String API_POST_TRAINING = "/training";
    public static final String API_POST_EXERCISE = "/training/{trainingLogId}/exercise";
    public static final String API_POST_SERIES = "/training/exercise/{exerciseLogId}/series";
    // DELETE
    public static final String API_DELETE_TRAINING = "/training/{trainingLogId}";
    public static final String API_DELETE_EXERCISE = "/training/exercise/{exerciseLogId}";
    public static final String API_DELETE_SERIES = "/training/exercise/series/{seriesLogId}";
    private static final String API_VERSION_V1 = "/api/v1";
    // ------------USER--------------------------------------------------
    public static final String USER = API_VERSION_V1 + "/user";
    // ------------LOGS--------------------------------------------------
    public static final String API_LOGS = API_VERSION_V1 + "/logs";

}

