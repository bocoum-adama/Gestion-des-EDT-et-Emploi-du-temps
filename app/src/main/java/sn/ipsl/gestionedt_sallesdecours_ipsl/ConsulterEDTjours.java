package sn.ipsl.gestionedt_sallesdecours_ipsl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ConsulterEDTjours extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    final String global_jour="globaljour";
    private Spinner spinner;
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

        String[] classa=new String[]{"Selectionner la classe","CPI1","CPI2","ING1_INF0","ING2_INF0","ING3_INF0"
                ,"ING1_CIVIL","ING2_CIVIL","ING3_CIVIL","ING1_MECA","ING2_MECA","ING3_MECA"};
        spinner=findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,classa);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        lundi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre1= new Intent(getApplicationContext(),ConsulterEDT.class);
                ordre1.putExtra(global_jour,"1:"+spinner.getSelectedItem().toString());
                startActivity(ordre1);
            }
        });
        mardi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre1= new Intent(getApplicationContext(),ConsulterEDT.class);
                ordre1.putExtra(global_jour,"2:"+spinner.getSelectedItem().toString());
                startActivity(ordre1);
            }
        });
        mercredi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre1= new Intent(getApplicationContext(),ConsulterEDT.class);
                ordre1.putExtra(global_jour,"3:"+spinner.getSelectedItem().toString());
                startActivity(ordre1);
            }
        });
        jeudi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre1= new Intent(getApplicationContext(),ConsulterEDT.class);
                ordre1.putExtra(global_jour,"4:"+spinner.getSelectedItem().toString());
                startActivity(ordre1);
            }
        });
        vendredi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre1= new Intent(getApplicationContext(),ConsulterEDT.class);
                ordre1.putExtra(global_jour,"5:"+spinner.getSelectedItem().toString());
                startActivity(ordre1);
            }
        });
        samedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordre1= new Intent(getApplicationContext(),ConsulterEDT.class);
                ordre1.putExtra(global_jour,"6:"+spinner.getSelectedItem().toString());
                startActivity(ordre1);
            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}