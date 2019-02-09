package com.app.guideuniversitaire.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.guideuniversitaire.R;
import com.app.guideuniversitaire.entities.Universites;
import com.app.guideuniversitaire.global;

public class AddUniversityActivity extends AppCompatActivity {

    private EditText nom, presidence, adr, ville, email, tel;
    private Button addU;
    long result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_add);

        this.nom = (EditText) findViewById(R.id.nom);
        this.presidence = (EditText) findViewById(R.id.president);
        this.adr = (EditText) findViewById(R.id.adr);
        this.ville = (EditText) findViewById(R.id.ville);
        this.email = (EditText) findViewById(R.id.email);
        this.tel = (EditText) findViewById(R.id.tel);
        this.addU = (Button) findViewById(R.id.addU);
        this.addU.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                result = ((global) getApplication()).getDaoSession().getUniversitesDao().insert(
                        new Universites(null, nom.getText().toString(), presidence.getText().toString(), adr.getText().toString(), ville.getText().toString(), email.getText().toString(), tel.getText().toString())
                );
                Intent intent = new Intent(getApplicationContext(), UniversityActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
