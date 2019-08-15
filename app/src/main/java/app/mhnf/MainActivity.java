package app.mhnf;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import app.mhnf.Fragment.CPFragment;
import app.mhnf.Fragment.FriendsFragment;
import app.mhnf.Fragment.BiodataFragment;
import mhnf.com.R;

/**
 * NIM : 10116369
 * Nama : Muhammad Habib Nur Fauzan
 * Kelas : IF-8
 * Tanggal Pengerjaan : 9 Agustus 2019
 */

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    //This is our viewPager
    private ViewPager viewPager;


    //Realm
    //Realm realm;
    //EditText nim,nama,alamat;

    //Fragments

    FriendsFragment friendsFragment;
    CPFragment CPFragment;
    BiodataFragment biodataFragment;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing Realm
        //Button button1 = (Button) findViewById(R.id.btnSimpan);
        //Button button2 = (Button) findViewById(R.id.btnLoad);
        //nim = (EditText) findViewById(R.id.editText);
        //nama = (EditText) findViewById(R.id.editText2);
        //alamat = (EditText) findViewById(R.id.editText3);

        //Realm.init(this);
        //realm = Realm.getDefaultInstance();

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        //Initializing the bottomNavigationView
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_contact:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.action_chat:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.action_call:
                                viewPager.setCurrentItem(2);
                                break;
                        }
                        return false;
                    }
                });


        //button1.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
          //      realm.beginTransaction();

            //    User user = realm.createObject(User.class,nim.getText().toString());
                //user.setNama(nama.getText().toString());
              //  user.setAlamat(alamat.getText().toString());

                //realm.commitTransaction();
          //  }
        //});


        //button2.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  Intent i = new Intent(MainActivity.this, LoadActivity.class);
                //startActivity(i);
            //}
        //});


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       /*  //Disable ViewPager Swipe

       viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });

        */

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        biodataFragment =new BiodataFragment();
        friendsFragment =new FriendsFragment();
        CPFragment =new CPFragment();
        adapter.addFragment(biodataFragment);
        adapter.addFragment(friendsFragment);
        adapter.addFragment(CPFragment);
        viewPager.setAdapter(adapter);
    }
}
