package nader.com.example.mohamedabdelhady.tasks.nader;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class PicassoC {
    static String imgs;



    public static void downloadImage(Context c, String url, ImageView img)
    {

        if(url != null && url.length()>0)
        {
            Picasso.with(c).load(url).placeholder(R.drawable.account).into(img);
        }
        else
        {
            Picasso.with(c).load(R.drawable.account).into(img);

        }
    }
}
