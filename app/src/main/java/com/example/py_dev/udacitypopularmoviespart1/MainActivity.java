package com.example.py_dev.udacitypopularmoviespart1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import CustomAdapter.ImageAdapter;
import CustomAdapter.SpinnerItemAdapter;
import Utils.JsonQuery;
import Utils.StoreJson;
public class MainActivity extends Activity {


    Context mContext;
    RequestQueue requestQueue;
    ArrayList<StoreJson> storeMovieData = new ArrayList<>();
    GridView gridView;
    String sortBy = SORT_BY_POPULARITY;

    //API KEY REMOVED ON MAKING PUBLIC !! //
    public static final String BASE_URL = "http://api.themoviedb.org/3/discover/movie?api_key=?????";
    public static final String SORT_BY_POPULARITY = "http://api.themoviedb.org/3/discover/movie?api_key=???&sort_by=popularity.desc";
    public static final String SORT_BY_VOTES = "http://api.themoviedb.org/3/discover/movie?api_key=???&sort_by=vote_count.desc";

    Spinner spinner;
    String[] items={"","Votes","Popularity"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gridView = (GridView) findViewById(R.id.gridView);
        ImageAdapter adapter = (new ImageAdapter(mContext, storeMovieData.size(), storeMovieData));
        gridView.setAdapter(adapter);
        requestQueue = Volley.newRequestQueue(MainActivity.this);

        // Run JsonArray 1st time to populate adapter
        getJsonArray(BASE_URL);

    }

    // Original Json Request
    private ArrayList<StoreJson> getJsonArray(String url){

        this.sortBy = url;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("results");
                            JsonQuery jsonQuery = new JsonQuery();
                            storeMovieData = jsonQuery.getStoreMovieData(jsonArray);



                            setContentView(R.layout.activity_main);
                            gridView = (GridView) findViewById(R.id.gridView);
                            ImageAdapter adapter = (new ImageAdapter(MainActivity.this, storeMovieData.size(), storeMovieData));
                            adapter.notifyDataSetChanged();
                            gridView.setAdapter(adapter);

                            spinner = (Spinner) findViewById(R.id.spinner);
                            spinner.setAdapter(new SpinnerItemAdapter(MainActivity.this, R.layout.custom_spinner, items));

                            // Activate Listener for visual layout of movie posters
                            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    int VOTES = 1;
                                    int POPULARITY = 2;

                                    if (position == VOTES) {

                                        getJsonArray(SORT_BY_VOTES);
                                        ImageAdapter adapter = new ImageAdapter(MainActivity.this, storeMovieData.size(), storeMovieData);
                                        adapter.notifyDataSetChanged();
                                        gridView.setAdapter(adapter);


                                    } else if (position == POPULARITY) {

                                        getJsonArray(SORT_BY_POPULARITY);
                                        ImageAdapter adapter = new ImageAdapter(MainActivity.this, storeMovieData.size(), storeMovieData);
                                        adapter.notifyDataSetChanged();
                                        gridView.setAdapter(adapter);

                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                    getJsonArray(BASE_URL);
                                }
                            });

                            // Set gridView listener
                            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                public void onItemClick(AdapterView<?> parent, View v,
                                                        int position, long id) {
                                    StoreJson getItemId = storeMovieData.get(position);
                                    Intent detailIntent = new Intent(MainActivity.this, DetailsActivity.class);

                                    detailIntent.putExtra("title", getItemId.getTitleItem());
                                    detailIntent.putExtra("poster_large", getItemId.getPosterItemLarge());
                                    detailIntent.putExtra("overview", getItemId.getOverView());
                                    detailIntent.putExtra("release", getItemId.getReleaseDate());
                                    detailIntent.putExtra("popularity", getItemId.getPopularityItem());
                                    detailIntent.putExtra("votes", getItemId.getVotesItems());
                                    detailIntent.putExtra("votes_average", getItemId.getVoteItemsAverageItems());
                                    startActivity(detailIntent);


                                    Toast.makeText(MainActivity.this, "" + storeMovieData.get(position).getTitleItem(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            });


                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("ERROR", error.getMessage());

                    }
                }
        );
        this.requestQueue.add(jsonObjectRequest);
        return storeMovieData;
    }
}

