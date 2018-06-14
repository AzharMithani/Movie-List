package ahuja.shivam.json_volley_imagepractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

/**
 * Created by root on 18/7/17.
 */

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Movie> movieArrayList;
    private LayoutInflater lif;

    public MyAdapter(Context mContext, ArrayList<Movie> movieArrayList) {
        this.mContext = mContext;
        this.movieArrayList = movieArrayList;
       lif=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return movieArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view=lif.inflate(R.layout.itemlayout,viewGroup,false);

        }
        TextView movietitle = (TextView) view.findViewById(R.id.movietitle);
        TextView moviegenre = (TextView) view.findViewById(R.id.moviegenre);
        TextView movieyear = (TextView) view.findViewById(R.id.movieyear);
        TextView movierating = (TextView) view.findViewById(R.id.movierating);
        ImageView movieicon = (ImageView) view.findViewById(R.id.movieicon);
        movietitle.setText(movieArrayList.get(i).getTitle());
        movieyear.setText("("+String.valueOf(movieArrayList.get(i).getReleaseYear())+")");
        movierating.setText(String.valueOf(movieArrayList.get(i).getRating()));

        String genre="";
        for (String str:movieArrayList.get(i).getGenre()) {
            genre=genre+","+str;
        }
       genre=genre.substring(1,genre.length());
        moviegenre.setText(genre);
        /*   for(int j=0;j<movieArrayList.get(i).getGenre().size();j++)
        {

        }
        if (movieArrayList.get(i).getGenre().contains(movieArrayList.get(i).getGenre().get(0)))
        {
            moviegenre.setText(movieArrayList.get(i).getGenre().get(0));
        }
        if (movieArrayList.get(i).getGenre().contains(movieArrayList.get(i).getGenre().get(1)))
        {
            moviegenre2.setText(movieArrayList.get(i).getGenre().get(1));
        }
        if (movieArrayList.get(i).getGenre().contains(movieArrayList.get(i).getGenre().get(2)))
        {
            moviegenre3.setText(movieArrayList.get(i).getGenre().get(2));
        }*/
        Glide.with(mContext).load(movieArrayList.get(i).getImage()).thumbnail(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(movieicon);

        return view;
    }
}
