package com.example.user.simplelistview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView LV_listView = (ListView) findViewById(R.id.UI_LV_listview);
        String[] phoneBrands = new String[]{"Nokia","Micromax","Oppo","Vivo","Motto","Lenova","apple","hp","Redmi","coolpad"};
        ArrayList<String> brands = new ArrayList<>();
        for(int i=0;i<10;i++){
            brands.add(phoneBrands[i]);
        }
        StableArrayAdapter stableArrayAdapter = new StableArrayAdapter(this,R.layout.listviewayout,brands);
        LV_listView.setAdapter(stableArrayAdapter);
    }
}
class StableArrayAdapter extends ArrayAdapter<String>{

    HashMap<String,Integer> mIdMap = new HashMap<>();

    public StableArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        for(int i=0;i<objects.size();++i){
            mIdMap.put(objects.get(i),i);
        }
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public long getItemId(int position) {
        String item = getItem(position);
        return mIdMap.get(item);
    }
}

