package sn.ipsl.gestionedt_sallesdecours_ipsl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConsulterEDTjours extends AppCompatActivity {

    final String global_jour="globaljour";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_edtjours);
        Button lundi=(Button) findViewById(R.id.lundi);
        Button mardi=(Button) findViewById(R.id.mardi);
        Button mercredi=(Button) findViewById(R.id.mercredi);
        Button jeudi=(Button) findViewById(R.id.jeudi);
        Button vendredi=(Button) findViewById(R.id.vendredi);
        Button samedi=(Button) findViewById(R.id.samedi);

        lundi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre1= new Intent(getApplicationContext(),ConsulterEDT.class);
                ordre1.putExtra(global_jour,"1");
                startActivity(ordre1);
            }
        });
        mardi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre1= new Intent(getApplicationContext(),ConsulterEDT.class);
                ordre1.putExtra(global_jour,"2");
                startActivity(ordre1);
            }
        });
        mercredi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre1= new Intent(getApplicationContext(),ConsulterEDT.class);
                ordre1.putExtra(global_jour,"3");
                startActivity(ordre1);
            }
        });
        jeudi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre1= new Intent(getApplicationContext(),ConsulterEDT.class);
                ordre1.putExtra(global_jour,"4");
                startActivity(ordre1);
            }
        });
        vendredi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre1= new Intent(getApplicationContext(),ConsulterEDT.class);
                ordre1.putExtra(global_jour,"5");
                startActivity(ordre1);
            }
        });
        samedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre1= new Intent(getApplicationContext(),ConsulterEDT.class);
                ordre1.putExtra(global_jour,"6");
                startActivity(ordre1);
            }
        });



    }
}