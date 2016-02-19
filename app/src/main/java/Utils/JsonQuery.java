package Utils;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.util.ArrayList;



public class JsonQuery {

    JSONArray jsonArray = new JSONArray();
    ArrayList<StoreJson> storeMovieData = new ArrayList<>();

    public static final String POSTER_URL = "http://image.tmdb.org/t/p/w185";
    public static final String POSTER_URL_342 = "http://image.tmdb.org/t/p/w342";


    public ArrayList<StoreJson> getStoreMovieData (JSONArray jsonArray) {


            this.jsonArray = jsonArray;
    Log.v("JSONprocessor", "RESULTS: " + jsonArray);

    try {
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject movie = jsonArray.getJSONObject(i);
        String title = movie.getString("original_title");
        String poster = movie.getString("poster_path");
        String overview = movie.getString("overview");
        String release = movie.getString("release_date");
        double popularity = movie.getDouble("popularity");
        double votes = movie.getDouble("vote_count");
        double votesAverage = movie.getDouble("vote_average");

        String posterLarge = POSTER_URL_342 + poster;
        String posterThumb = POSTER_URL + poster;

        storeMovieData.add(new StoreJson(title,
                posterThumb, posterLarge, overview, release, popularity,
                votes, votesAverage

        ));
    }

        Log.v("JSONprocessor", "storeMovieData Length: " + storeMovieData.size());
        Log.v("JSONprocessor", "NewStore Length: " + storeMovieData.get(2).getPosterItem());
    }catch (JSONException e) {
            e.printStackTrace();

            }
        return storeMovieData;
    }
}
