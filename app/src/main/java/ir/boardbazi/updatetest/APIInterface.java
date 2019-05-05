package ir.boardbazi.updatetest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIInterface {

    @GET("gwn/api/start?v="+BuildConfig.VERSION_CODE+"&app=topchef")
    @Headers("User-Agent:<update>")
    Call<BodyResponse> getUpdate();
}
