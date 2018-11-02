package nader.com.example.mohamedabdelhady.tasks.nader;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFragment extends android.support.v4.app.Fragment {

    ArrayList<product> listData;
    RecyclerView List;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_home, container, false);
       List = v.findViewById(R.id.ListData);
       List.setLayoutManager(new GridLayoutManager(getActivity(),2));

         getProductData getProductData = new getProductData();
         listData = getProductData.getdata(getActivity());
         productAdapter productAdapter = new productAdapter(getActivity(),listData);
         List.setAdapter(productAdapter);

        return v;
    }

}
