package sn.ipsl.gestionedt_sallesdecours_ipsl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AjoutEDT_niveau extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    final String global_class="globalclass";
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_edt_niveau);
        final Button valider= findViewById(R.id.valider);

        String[] classe=new String[]{"Selectionner la classe","CPI1","CPI2","ING1_INF0","ING2_INF0","ING3_INF0"
                ,"ING1_CIVIL","ING2_CIVIL","ING3_CIVIL","ING1_MECA","ING2_MECA","ING3_MECA"};
        spinner=findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,classe);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinner.getSelectedItem().toString() != "Selectionner la classe"){
                    Intent ordre4=new Intent(getApplicationContext(),AjoutEDT.class);
                    ordre4.putExtra(global_class,spinner.getSelectedItem().toString());
                    startActivity(ordre4);

                }
            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = String.valueOf(adapterView.getItemIdAtPosition(i));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}