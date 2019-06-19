package com.ne.searchviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    //declare the listview, searchview
    SearchView searchView;
    ListView listView;
    String [] Searchlist={"Ananth", "sakthi", "shanmugam", "vadivel", "amma","hema", "appa", "guna"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // intilize the searchview, listviw
        searchView=(SearchView) findViewById(R.id.searchview);
        listView=(ListView) findViewById(R.id.lstview);
        // create arrayadapter
        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,
                                              android.R.id.text1, Searchlist);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);

        setupSearchview();
    }

    private void setupSearchview() {
        searchView.setIconifiedByDefault(false);
        //type the below format, then click the redbulb and create implementation mthods of
        // onQueryTextChanges,onTextSubmit below the methods then follow the source code
        searchView.setOnQueryTextListener(this);

        searchView.setSubmitButtonEnabled(true);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText))  {
            listView.clearTextFilter();
        } else {
            listView.setFilterText(newText);
        }
        return true;
    }
}
