package ahuja.shivam.json_volley_imagepractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private MyAdapter myadapter;
    private JsonArrayRequest jsonarrayrequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=(ListView)findViewById(R.id.myLIstView);

       jsonarrayrequest= new JsonArrayRequest("https://api.androidhive.info/json/movies.json", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ArrayList<Movie> arrayList=new ArrayList<>();
                for(int i=0;i<response.length();i++)
                {
                    Movie movie=new Movie();
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        movie.setTitle(jsonObject.getString("title"));
                        movie.setImage(jsonObject.getString("image"));
                        movie.setRating(jsonObject.getDouble("rating"));
                        movie.setReleaseYear(jsonObject.getInt("releaseYear"));
                        ArrayList<String> arrayList1 =new ArrayList<String>();
                        JSONArray jsonArray=jsonObject.getJSONArray("genre");
                        for(int i1=0;i1<jsonArray.length();i1++)
                        {
                            arrayList1.add(jsonArray.getString(i1));
                        }
                        movie.setGenre(arrayList1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    arrayList.add(movie);
                }
                myadapter=new MyAdapter(MainActivity.this,arrayList);
                 mListView.setAdapter(myadapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueueClass.mInstance.getRequestQueue().add(jsonarrayrequest);
    }
}
