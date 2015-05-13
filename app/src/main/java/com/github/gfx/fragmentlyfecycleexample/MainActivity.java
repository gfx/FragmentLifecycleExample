package com.github.gfx.fragmentlyfecycleexample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends AppCompatActivity {

    public static class MyFragment extends Fragment {

        static final String TAG = MyFragment.class.getSimpleName();


        public MyFragment() {

        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            Log.d(TAG, "onAttach");
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.d(TAG, "onCreate");
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            Log.d(TAG, "onCreateView");
            return inflater.inflate(R.layout.fragment_my, container, false);
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Log.d(TAG, "onActivityCreated");
        }

        @Override
        public void onStart() {
            super.onStart();
            Log.d(TAG, "onStart");
        }

        @Override
        public void onResume() {
            super.onResume();
            Log.d(TAG, "onResume");
        }

        @Override
        public void onPause() {
            super.onPause();
            Log.d(TAG, "onPause");
        }

        @Override
        public void onStop() {
            super.onStop();
            Log.d(TAG, "onStop");
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            Log.d(TAG, "onDestroyView");
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.d(TAG, "onDestroy");
        }

        @Override
        public void onDetach() {
            super.onDetach();
            Log.d(TAG, "onDetach");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Fragment fragment = new MyFragment();
        FragmentTransaction txn = getSupportFragmentManager().beginTransaction();
        txn.replace(R.id.container, fragment);
        txn.detach(fragment);
        txn.commit();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentTransaction txn = getSupportFragmentManager().beginTransaction();
                txn.attach(fragment);
                txn.commit();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        FragmentTransaction txn = getSupportFragmentManager()
                                .beginTransaction();
                        txn.detach(fragment);
                        txn.commit();
                    }
                }, 2000);

            }
        }, 2000);

        Log.d("MainActivity", "onCreate finished");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
