package com.app.guideuniversitaire.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.guideuniversitaire.R;
//import com.app.guideuniversitaire.global; // ((global)getApplication()).getDaoSession().getEtablissementDao()

public class MainActivity extends AppCompatActivity {

    private Button add, del, ls, q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.add = (Button) findViewById(R.id.add_univ);
        this.del = (Button) findViewById(R.id.del_univ);
        this.ls = (Button) findViewById(R.id.ls_univ);
        this.q = (Button) findViewById(R.id.exit);

        add.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), AddUniversityActivity.class);
                startActivity(intent);

            }
        });
        del.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UniversityActivity.class);
                startActivity(intent);

            }
        });
        ls.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), UniversityActivity.class);
                startActivity(intent);
            }
        });
        q.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.university_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.add_uni:
                Intent intent = new Intent(this, AddUniversityActivity.class);
                startActivity(intent);
                return true;
            case R.id.del_uni:
                Intent intent2 = new Intent(getApplicationContext(), UniversityActivity.class);
                startActivity(intent2);
                return true;
            case R.id.ls_uni:
                Intent intent3 = new Intent(getApplicationContext(), UniversityActivity.class);
                startActivity(intent3);
                return true;
            case R.id.q_uni:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
