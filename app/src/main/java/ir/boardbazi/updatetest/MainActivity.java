package ir.boardbazi.updatetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<BodyResponse> call = apiInterface.getUpdate();
        call.enqueue(new Callback<BodyResponse>() {
            @Override
            public void onResponse(Call<BodyResponse> call, Response<BodyResponse> response) {
                String s = String.valueOf(response.body().getCode())+"\n"+response.body().getDescription();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<BodyResponse> call, Throwable t) {

            }
        });
    }
}
