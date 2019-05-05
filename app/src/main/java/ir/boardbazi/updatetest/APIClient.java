package ir.boardbazi.updatetest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static final String BASE_URL = "http://adak-tech.ir/" ;
    private static Retrofit retrofit = null ;

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(getBaseUrl())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit ;
    }

}