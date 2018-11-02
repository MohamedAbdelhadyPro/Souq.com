package nader.com.example.mohamedabdelhady.tasks.nader;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView mOnNavigationItemSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        mOnNavigationItemSelectedListener = findViewById(R.id.navigation);

        Fragment fragment = new HomeFragment();
        setFragment(fragment);

        mOnNavigationItemSelectedListener.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;

                switch (menuItem.getItemId()) {
                   case R.id.navigation_home:
                       fragment = new HomeFragment();
                        setFragment(fragment);
                        return true;
                    case R.id.navigation_dashboard:
                        fragment = new ProductFragment();
                        setFragment(fragment);
                        return true;

                    case R.id.navigation_MyCart:
                        fragment = new ProductFragment();
                        setFragment(fragment);
                        return true;
                    case R.id.navigation_MyAccount:
                        fragment = new HomeFragment();
                        setFragment(fragment);
                        return true;
                }
                return false;
            }
        });

    }

    protected void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

}
