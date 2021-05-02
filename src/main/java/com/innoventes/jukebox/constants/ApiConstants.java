package com.innoventes.jukebox.constants;

public class ApiConstants {

    private static final String VERSION = "v1";

    public static final String BASE_URL = "/api/" + VERSION;

    public static final String AUTHENTICATION_BASE_PATH = BASE_URL + "/auth";

    public static final String API_SIGN_IN = BASE_URL + "/auth/signIn";

    public static final String API_ENCRYPT = BASE_URL + "/auth/encrypt/{var}";

    public static final String ALBUM_BASE_PATH = BASE_URL + "/album";

    public static final String API_ALBUM_SORT_BY_PRICE = BASE_URL + "/album/sort/price";

    public static final String API_ALBUM_SORT_BY_DATE =  BASE_URL + "/album/sort/date";

    public static final String MUSICIAN_BASE_PATH = BASE_URL + "/musician";

    public static final String MUSICIAN_SORT_BY_NAME = BASE_URL + "/musician/sort/name";




}
