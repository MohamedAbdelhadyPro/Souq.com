package nader.com.example.mohamedabdelhady.tasks.nader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    ImageView ProdImage;
    TextView ProdTitle,ProdPrice,ProdDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ProdImage = findViewById(R.id.ProdImage);
        ProdTitle = findViewById(R.id.Prodtitle);
        ProdPrice = findViewById(R.id.Prodprice);
        ProdDesc = findViewById(R.id.Proddesc);



        String title = getIntent().getExtras().getString("title");
        String price = getIntent().getExtras().getString("price");
        String description = getIntent().getExtras().getString("description");
        String img = getIntent().getExtras().getString("img");

        ProdTitle.setText(title);
        ProdPrice.setText(price);
        ProdDesc.setText(description);
        PicassoC.downloadImage(this,img,ProdImage);
    }
}
