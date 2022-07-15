package sn.ipsl.gestionedt_sallesdecours_ipsl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminInterface extends AppCompatActivity {
    Button creerCompte,ajoutSalle,ajoutEDT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_interface);
        creerCompte=(Button) findViewById(R.id.btn_creercompte);
        ajoutSalle=(Button) findViewById(R.id.btn_ajout_salle);
        ajoutEDT=(Button) findViewById(R.id.btn_ajout_edt);
        creerCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre4=new Intent(getApplicationContext(),AddUser.class);
                startActivity(ordre4);
            }
        });
        ajoutSalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre5 = new Intent(getApplicationContext(),AddSalle.class);
                startActivity(ordre5);
            }
        });
        ajoutEDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre6 = new Intent(getApplicationContext(),AjoutEDT_niveau.class);
                startActivity(ordre6);
            }
        });
    }
}