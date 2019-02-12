package com.app.guideuniversitaire.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.guideuniversitaire.R;
import com.app.guideuniversitaire.entities.Universites;
import com.app.guideuniversitaire.global;

public class DelShowUniversityActivity extends AppCompatActivity {
    TextView univName, univPresident, univAdr, univVille, univEmail, inivTel;
    Button ls, del;
    Long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_del_show);
        ls = findViewById(R.id.univ_ls);
        del = findViewById(R.id.univ_del);
        univName = (TextView) findViewById(R.id.uni_name);
        univPresident = (TextView) findViewById(R.id.uni_president);
        univAdr = (TextView) findViewById(R.id.uni_adr);
        univVille = (TextView) findViewById(R.id.uni_ville);
        univEmail = (TextView) findViewById(R.id.uni_email);
        inivTel = (TextView) findViewById(R.id.uni_tel);
        final Universites universites = ((global) getApplication()).getDaoSession().getUniversitesDao().loadByRowId(getIntent().getExtras().getLong("id"));
        id = universites.getId();
        univName.setText(universites.getNom());
        univPresident.setText(universites.getPresident());
        univAdr.setText(universites.getAdresse());
        univVille.setText(universites.getVille());
        univEmail.setText(universites.getEmail());
        inivTel.setText(universites.getTel());
        del.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ((global) getApplication()).getDaoSession().getUniversitesDao().delete(universites);
                Intent intent = new Intent(getApplicationContext(), UniversityActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ls.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UniversityActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.etablissement_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_etab:
                Intent intent = new Intent(this, AddEtablissementActivity.class);
                intent.putExtra("idU", this.id);
                startActivity(intent);
                return true;
            case R.id.del_etab:
                Intent intent3 = new Intent(this, EtablissementActivity.class);
                intent3.putExtra("idU", this.id);
                startActivity(intent3);
                return true;
            case R.id.ls_etab:
                Intent intent2 = new Intent(this, EtablissementActivity.class);
                intent2.putExtra("idU", this.id);
                startActivity(intent2);
                return true;
            case R.id.q_etab:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
