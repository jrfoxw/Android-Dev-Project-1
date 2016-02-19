package CustomAdapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Utils.StoreJson;


/**
 * Created by PY-DEV on 2/10/2016.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private int counter;
    private ArrayList<StoreJson> mItems;

    public ImageAdapter(Context c, int count, ArrayList<StoreJson> movieItems){
        this.mContext = c;
        this.counter = count;
        this.mItems = movieItems;


    }

    @Override
    public int getCount() {
        return counter;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        ImageView imageView;
        if (convertView == null){
            imageView = new ImageView(mContext);
//            imageView.setBackgroundColor(Color.BLACK);
            imageView.setLayoutParams(new GridView.LayoutParams(235, 385));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(8, 8, 8, 8);

            Log.v("JSONImageAdapter","WENT HERE!! :"+position);


        }else{
            imageView = (ImageView) convertView;

        }

        String mPoster = ""+mItems.get(position).getPosterItem();
        Log.v("JSONImageAdapter","mPoster Image = "+mPoster);
        Picasso.with(mContext).load(mItems.get(position).getPosterItem()).into(imageView);

        return imageView;

    }
}
