package nader.com.example.mohamedabdelhady.tasks.nader;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;


public class HomeFragment extends android.support.v4.app.Fragment {
    SwipeRefreshLayout swipeRefreshLayout;

    ArrayList<product> listData;
    RecyclerView List;
    EditText txtserch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_home, container, false);
       List = v.findViewById(R.id.ListData);
       List.setLayoutManager(new GridLayoutManager(getActivity(),2));
       txtserch = v.findViewById(R.id.txtSerch);

         getProductData getProductData = new getProductData();
         listData = getProductData.getdata(getActivity());
         productAdapter productAdapter = new productAdapter(getActivity(),listData);
         List.setAdapter(productAdapter);

        swipeRefreshLayout = v.findViewById(R.id.swip);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent,R.color.colorPrimary,R.color.colorPrimaryDark);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getProductData getProductData = new getProductData();
                        listData = getProductData.getdata(getActivity());
                        productAdapter productAdapter = new productAdapter(getActivity(),listData);
                        List.setAdapter(productAdapter);
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);

            }
        });

        txtserch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                getProductData getProductData = new getProductData();
                listData = getProductData.getdataBySerch(getActivity(),txtserch.getText().toString());
                productAdapter productAdapter = new productAdapter(getActivity(),listData);
                List.setAdapter(productAdapter);
            }
        });

        return v;
    }

}
