package com.app.guideuniversitaire.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.app.guideuniversitaire.R;
import com.app.guideuniversitaire.entities.Universites;
import com.app.guideuniversitaire.global;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class UniversityActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);
        listView = (ListView) findViewById(R.id.list);
        List<Universites> result = ((global) getApplication()).getDaoSession().getUniversitesDao().loadAll();

        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (Universites item : result) {
            Map<String, String> datum = new HashMap<String, String>(2);
            datum.put("title", item.getNom());
            datum.put("id", item.getId().toString());
            data.add(datum);
        }
        final SimpleAdapter adapter = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2,
                new String[]{"title", "id"},
                new int[]{android.R.id.text1,
                        android.R.id.text2});

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                HashMap<String, String> u = (HashMap<String, String>) adapterView.getItemAtPosition(position);


                Intent intent = new Intent(getApplicationContext(), DelShowUniversityActivity.class);
                intent.putExtra("id", ((global) getApplication()).getDaoSession().getUniversitesDao().loadByRowId(Long.parseLong((String) new Vector(u.values()).get(0))).getId());
                startActivity(intent);
                finish();
            }
        });
    }
}
