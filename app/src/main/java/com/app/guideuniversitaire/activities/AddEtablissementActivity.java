package com.app.guideuniversitaire.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.guideuniversitaire.R;
import com.app.guideuniversitaire.entities.Etablissement;
import com.app.guideuniversitaire.entities.Universites;
import com.app.guideuniversitaire.global;

public class AddEtablissementActivity extends AppCompatActivity {
    EditText nom, typee, respo, adr, ville, tel, email;
    Button v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etablissement_add);
        nom = findViewById(R.id.nometab);
        typee = findViewById(R.id.typeetab);
        respo = findViewById(R.id.respo);
        adr = findViewById(R.id.adretab);
        ville = findViewById(R.id.villeetab);
        tel = findViewById(R.id.teletab);
        email = findViewById(R.id.emailetab);
        v = findViewById(R.id.addE);
        final Long idU = getIntent().getExtras().getLong("idU");
        v.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ((global) getApplication()).getDaoSession().getEtablissementDao().insert(new Etablissement(null, idU, nom.getText().toString(), typee.getText().toString(), respo.getText().toString(), adr.getText().toString(), ville.getText().toString(), email.getText().toString(), tel.getText().toString()));
                Intent intent = new Intent(getApplicationContext(), EtablissementActivity.class);
                intent.putExtra("idU", idU);
                startActivity(intent);
                finish();
            }
        });
    }
}
