package CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.py_dev.udacitypopularmoviespart1.R;


public class SpinnerItemAdapter extends ArrayAdapter<String> {

    Context mContext;
    String[] items;
    int layout;


    public SpinnerItemAdapter(Context context, int textViewResourceId, String[] items){
        super(context, textViewResourceId, items);

        this.items = items;
    }


    public View getCustomView(int position, View convertView, ViewGroup parent){
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.custom_spinner, parent, false);
            TextView textView = (TextView) layout.findViewById(R.id.textView2);
            textView.setText(items[position]);
            textView.setTextSize(12);
            return layout;
        }


        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
}
