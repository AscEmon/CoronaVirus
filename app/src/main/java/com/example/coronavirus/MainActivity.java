package com.example.coronavirus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView Bangladesh,World,aware,emergency;
    String totalDeaths,todayCase,todayDeath,todayRecov;
    TextView affet,cas,deat,recov;
    ImageView webs,fbs;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         pieChart = (PieChart) findViewById(R.id.piechart);
        affet=findViewById(R.id.TotalAffected);
        cas=findViewById(R.id.todayAffected);
        deat=findViewById(R.id.todayDeaths);
        recov=findViewById(R.id.todayRecov);



        fetchData();



        Bangladesh=findViewById(R.id.bangladesh);
        World=findViewById(R.id.world);
        aware=findViewById(R.id.publicAwareness);
        emergency=findViewById(R.id.Emergency);
        webs=findViewById(R.id.web);
        fbs=findViewById(R.id.fb);
        Bangladesh.setOnClickListener(this);
        World.setOnClickListener(this);
        aware.setOnClickListener(this);
        emergency.setOnClickListener(this);
        webs.setOnClickListener(this);
        fbs.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.bangladesh:
                Intent bang=new Intent(MainActivity.this, Bangladesh_activity.class);
                startActivity(bang);
                break;
            case R.id.world:
                Intent world=new Intent(MainActivity.this, world_activity.class);
                startActivity(world);
                break;
            case R.id.publicAwareness:
                Intent awareness=new Intent(MainActivity.this, Awareness_activity.class);
                startActivity(awareness);
                break;

            case R.id.Emergency:
                Intent emer=new Intent(MainActivity.this, Emergency_contact.class);
                startActivity(emer);
                break;

            case R.id.web:

                Uri uri = Uri.parse("http://www.ringersoft.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.fb:
                String YourPageURL = "https://www.facebook.com/RingerSoft24x7/";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(YourPageURL));
                startActivity(browserIntent);
                break;

        }

    }

    private void fetchData() {

        String url  = "https://corona.lmao.ninja/v2/countries/bangladesh";






        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());


                           totalDeaths= jsonObject.getString("cases");
                           todayRecov=jsonObject.getString("recovered");
                            todayCase=jsonObject.getString("todayCases");
                            todayDeath=jsonObject.getString("todayDeaths");


                            affet.setText( "মোট আক্রান্ত - "+totalDeaths);
                            cas.setText("আজ আক্রান্ত\n\t\t\t\t\t"+todayCase);
                            deat.setText("আজ মৃত্যু\n\t\t\t\t"+todayDeath);
                            recov.setText("সুস্থ হয়েছে \n\t\t"+todayRecov);

                            pieChart.addPieSlice(new PieModel("Cases",Integer.parseInt(totalDeaths), Color.parseColor("#FFA726")));
                            pieChart.addPieSlice(new PieModel("Recoverd",Integer.parseInt(todayRecov), Color.parseColor("#66BB6A")));
                            pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(todayDeath), Color.parseColor("#EF5350")));
                            pieChart.startAnimation();





                        } catch (JSONException e) {
                            e.printStackTrace();




                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {




                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }

}
