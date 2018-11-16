package nader.com.example.mohamedabdelhady.tasks.nader;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class productAdapter extends RecyclerView.Adapter<productAdapter.Holder> {

    Context context;
    ArrayList<product> listData;


    public productAdapter(Context contex, ArrayList<product> listData) {
        this.context = contex;
        this.listData = listData;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

       View v = LayoutInflater.from(context).inflate(R.layout.product_post,viewGroup,false);
        Holder holder = new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
    final product product = listData.get(i);
        holder.txtTitle.setText(product.getTitle());
        holder.txtPrice.setText(product.getPrice());
        holder.txtPiceAfterDisc.setText(product.getPriceafterdisc());
        PicassoC.downloadImage(context,product.getImage(), holder.productImage);
        holder.txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = product.getTitle();
                String price = product.getPrice();
                String description = product.getDesc();
                String img = product.getImage();

                Intent i = new Intent(context,DetailsActivity.class);
                i.putExtra("title",title);
                i.putExtra("price",price);
                i.putExtra("description",description);
                i.putExtra("img",img);
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView txtTitle,txtPrice,txtPiceAfterDisc;

        public Holder(View v) {
            super(v);
            productImage = v.findViewById(R.id.productImage);
            txtTitle = v.findViewById(R.id.txtTitle);
            txtPrice = v.findViewById(R.id.txtPrice);
            txtPiceAfterDisc = v.findViewById(R.id.txtPriceAfterDisc);
        }

    }

}
