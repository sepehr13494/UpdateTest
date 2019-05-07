package ir.boardbazi.updatetest;

import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Guideline guideline;
    RelativeLayout layout;
    ImageView menu_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk_show);

        menu_img = findViewById(R.id.menu_img);


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

        guideline = findViewById(R.id.guideline3);
        layout = findViewById(R.id.layout);
        guideline.setGuidelinePercent(0.4f);
        LayoutInflater.from(this).inflate(R.layout.test,layout);

        menu_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.removeAllViews();
                guideline.setGuidelinePercent(0.55f);
                LayoutInflater.from(MainActivity.this).inflate(R.layout.comments,layout);
            }
        });



    }
}
