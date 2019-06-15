package com.notebook.idealabs.evershine;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment, new PlaceholderFragment()).commit();
        }
    }



        public static class PlaceholderFragment extends Fragment{
            private ArrayAdapter<String> ForecastAdapter;
            public PlaceholderFragment() {
            }
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container ,Bundle savedInstanceState){


                String[] ForecastData = {
                        "Today - Sunny - 88/63",
                        "Tomorrow - Foggy - 70/68",
                        "Weds - Cloudy - 72/63",
                        "thurs - Cloudy - 72/63",
                        "Fri - Snowy - 72/63",
                        "Sat - Cloudy - 72/63",
                        "Sun - Browsy - 72/63"
                };

                List<String> WeekForecast = new ArrayList<String>(Arrays.asList(ForecastData));

                ForecastAdapter = new ArrayAdapter<String>(
                        getActivity(),

                        R.layout.list_item_forecast,

                        R.id.list_item_forecast_textview,

                        WeekForecast
                );

                View rootView = inflater.inflate(R.layout.fragment_main, container, false);

                ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
                listView.setAdapter(ForecastAdapter);

                return rootView;

            }
        }
}
