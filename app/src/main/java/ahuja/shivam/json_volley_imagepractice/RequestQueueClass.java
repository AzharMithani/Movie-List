package ahuja.shivam.json_volley_imagepractice;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by root on 18/7/17.
 */

public class RequestQueueClass extends Application {
    public static RequestQueueClass mInstance;
    public RequestQueue mRequestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
    mRequestQueue=getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if(mRequestQueue ==null)
        {
            mRequestQueue =Volley.newRequestQueue(this);
        }
        return mRequestQueue;
    }
}
