package sn.ipsl.gestionedt_sallesdecours_ipsl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;

public class AddSalle extends AppCompatActivity {
    EditText nomSalle,emplacement,description;
    Button valider,retour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_salle);

        nomSalle=(EditText) findViewById(R.id.nomsalle);
        emplacement=(EditText) findViewById(R.id.emplacement);
        description=(EditText) findViewById(R.id.description);
        valider=(Button) findViewById(R.id.btn_valider);
        retour=(Button)findViewById(R.id.back);

        DAO dao= new DAO();

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModelSalle m= new ModelSalle(nomSalle.getText().toString(),emplacement.getText().toString(),
                         description.getText().toString());
                dao.addsall(m).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddSalle.this, "Salle ajoute avec succes", Toast.LENGTH_SHORT).show();
                        nomSalle.setText("");
                        emplacement.setText("");
                        description.setText("");

                    }
                });

            }
        });
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}