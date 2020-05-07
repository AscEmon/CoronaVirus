package com.example.coronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

public class Bangladesh_activity extends AppCompatActivity {
    TextView tvCases,tvRecovere,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths,tvAffectedCountries;
    PieChart pieChart;
    SimpleArcLoader simpleArcLoader;
    ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangladesh);
        tvCases = findViewById(R.id.tvCases1);
        tvRecovere = findViewById(R.id.tvRecovered1);
        tvCritical = findViewById(R.id.tvCritical1);
        tvActive = findViewById(R.id.tvActive1);
        tvTodayCases = findViewById(R.id.tvTodayCases1);
        tvTotalDeaths = findViewById(R.id.tvTotalDeaths1);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths1);
        tvAffectedCountries = findViewById(R.id.tvAffectedCountries1);

        simpleArcLoader = findViewById(R.id.loader1);

        scrollView = findViewById(R.id.scrollStats1);
        pieChart = findViewById(R.id.piechart1);


        fetchData();

    }
    private void fetchData() {

        String url  = "https://corona.lmao.ninja/v2/countries/bangladesh";



        simpleArcLoader.start();


        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());

                            tvCases.setText(jsonObject.getString("cases"));
                            tvRecovere.setText(jsonObject.getString("recovered"));
                            tvCritical.setText(jsonObject.getString("critical"));
                            tvActive.setText(jsonObject.getString("active"));
                            tvTodayCases.setText(jsonObject.getString("todayCases"));
                            tvTotalDeaths.setText(jsonObject.getString("deaths"));
                            tvTodayDeaths.setText(jsonObject.getString("todayDeaths"));
                            tvAffectedCountries.setText(jsonObject.getString("tests"));





                            pieChart.addPieSlice(new PieModel("Cases",Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#FFA726")));
                            pieChart.addPieSlice(new PieModel("Recoverd",Integer.parseInt(tvRecovere.getText().toString()), Color.parseColor("#66BB6A")));
                            pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(tvTotalDeaths.getText().toString()), Color.parseColor("#EF5350")));
                            pieChart.addPieSlice(new PieModel("Active",Integer.parseInt(tvActive.getText().toString()), Color.parseColor("#29B6F6")));
                            pieChart.startAnimation();

                            simpleArcLoader.setVisibility(View.GONE);


                            scrollView.setVisibility(View.VISIBLE);




                        } catch (JSONException e) {
                            e.printStackTrace();

                            simpleArcLoader.setVisibility(View.GONE);
                            scrollView.setVisibility(View.VISIBLE);

                            scrollView.setVisibility(View.VISIBLE);
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);

                scrollView.setVisibility(View.VISIBLE);
                Toast.makeText(Bangladesh_activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }
}
