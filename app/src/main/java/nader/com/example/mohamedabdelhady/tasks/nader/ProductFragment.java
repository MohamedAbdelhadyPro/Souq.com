package nader.com.example.mohamedabdelhady.tasks.nader;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ProductFragment extends android.support.v4.app.Fragment {


    public ProductFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_product, container, false);
    }

}
