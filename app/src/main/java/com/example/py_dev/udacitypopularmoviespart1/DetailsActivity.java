package com.example.py_dev.udacitypopularmoviespart1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();

        String title = extras.getString("title");
        String poster = extras.getString("poster_large");
        String overview = extras.getString("overview");
        String release = extras.getString("release");
        double popularity = extras.getDouble("popularity");
        double votes = extras.getDouble("votes");
        double votesAverage = extras.getDouble("votes_average");

        TextView titleText = (TextView) findViewById(R.id.titleView);
        ImageView posterView = (ImageView) findViewById(R.id.posterView);
        TextView overviewView = (TextView) findViewById(R.id.overviewView);
        TextView releaseView = (TextView) findViewById(R.id.releaseDateView);
        TextView popularityView = (TextView) findViewById(R.id.popularityView);
        TextView votesView = (TextView) findViewById(R.id.votesView);
        TextView votesAverageView = (TextView) findViewById(R.id.voteAverageView);

        if (title != null) {
            titleText.setText(title.toUpperCase());
            overviewView.setText(overview);
            releaseView.setText(release);
            popularityView.setText(""+popularity);
            votesView.setText(""+votes);
            votesAverageView.setText(""+votesAverage);

        }
        Picasso.with(DetailsActivity.this)
                .load(poster)
                .into(posterView);


    }
}
