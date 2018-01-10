package slowinski.radoslaw.gymlogger.utilities;

public class ApiMappings {
    private static final String API_VERSION = "/api/v1";

    public static final String USER_V1 = API_VERSION + "/user";
    public static final String LOGS_V1 = API_VERSION + "/logs";

    public static final String TRAINING_LOG_MAPPING = "/training";
    public static final String EXERCISE_LOG_MAPPING = TRAINING_LOG_MAPPING + "/{trainingLog}/exercise";
    public static final String SERIES_LOG_MAPPING = EXERCISE_LOG_MAPPING + "/{exerciseLog}/series";

}

