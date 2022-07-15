package sn.ipsl.gestionedt_sallesdecours_ipsl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class AjoutEDT extends AppCompatActivity {

    final String global_class="globalclass";
    final String global_date="globaldate";
    final String global_heur="globalheur";
    final String global_cours="globalcours";
    final String global_nbheur="globalnbheur";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_edt);

        final Button valider1= (Button) findViewById(R.id.valider1);
        final TextView tv1=(TextView) findViewById(R.id.textViewcla);
        final EditText date=(EditText)findViewById(R.id.Datecours);
        final EditText heurecours=(EditText) findViewById(R.id.heurcours);
        final EditText cours=(EditText) findViewById(R.id.cours);
        final EditText nb_h=(EditText) findViewById(R.id.nombrheur);

        String classe= "";
        Intent recupere=getIntent();
        if (recupere!=null){
            classe=recupere.getStringExtra(global_class);
            tv1.setText(classe);
        }

        String finalClasse = classe;
        valider1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre4=new Intent(getApplicationContext(),AjoutEDT_Final.class);
                ordre4.putExtra(global_class, finalClasse);
                ordre4.putExtra(global_date, date.getText().toString());
                ordre4.putExtra(global_heur, heurecours.getText().toString());
                ordre4.putExtra(global_cours, cours.getText().toString());
                ordre4.putExtra(global_nbheur, nb_h.getText().toString());

                startActivity(ordre4);
            }
        });

    }
}