package com.innoventes.jukebox.constants;

public class ApiConstants {

    private static final String VERSION = "v1";

    public static final String AUTHENTICATION_BASE_PATH = "/api/" + VERSION + "/auth";

    public static final String API_SIGN_IN = "/signIn";

    public static final String API_ENCRYPT = "/encrypt/{var}";

    public static final String ALBUM_BASE_PATH = "/api/" + VERSION + "/album";

    public static final String API_ALBUM_SORT_BY_PRICE = "/sort/price";

    public static final String API_ALBUM_SORT_BY_DATE = "/sort/date";

    public static final String MUSICIAN_BASE_PATH = "/api/" + VERSION + "/musician";

    public static final String MUSICIAN_SORT_BY_NAME = "/sort/name";




}
