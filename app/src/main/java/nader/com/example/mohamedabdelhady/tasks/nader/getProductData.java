package nader.com.example.mohamedabdelhady.tasks.nader;

import android.content.Context;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class getProductData {

        ArrayList<product> listdata = new ArrayList<product>();

    public ArrayList getdata(Context context){
        Database db = new Database();
        Connection conn = db.ConnectDB();
        if (conn == null){
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }else {
           ResultSet resultData = db.select("select * from Product");
            try {
                while (resultData.next()){

                    product pro = new product();

                    pro.setId(resultData.getString(1));
                    pro.setTitle(resultData.getString(2));
                    pro.setDesc(resultData.getString(3));
                    pro.setPrice(resultData.getString(4));
                    pro.setPriceafterdisc(resultData.getString(5));
                    pro.setBrand(resultData.getString(6));
                    pro.setImage(resultData.getString(7));
                    pro.setRate(resultData.getString(8));

                    listdata.add(pro);
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listdata;
    }
    public ArrayList getdataBySerch(Context context,String txtserch){
        Database db = new Database();
        Connection conn = db.ConnectDB();
        if (conn == null){
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }else {
            ResultSet resultData = db.select("Select * From Product where tilte like '%"+txtserch+"%'");
            try {
                while (resultData.next()){

                    product pro = new product();

                    pro.setId(resultData.getString(1));
                    pro.setTitle(resultData.getString(2));
                    pro.setDesc(resultData.getString(3));
                    pro.setPrice(resultData.getString(4));
                    pro.setPriceafterdisc(resultData.getString(5));
                    pro.setBrand(resultData.getString(6));
                    pro.setImage(resultData.getString(7));
                    pro.setRate(resultData.getString(8));

                    listdata.add(pro);
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listdata;
    }

}
