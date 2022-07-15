package sn.ipsl.gestionedt_sallesdecours_ipsl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;

public class AddUser extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{

    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        final Button adduser= findViewById(R.id.aj);
        final EditText pre=(EditText) findViewById(R.id.pre);
        final EditText nom=(EditText) findViewById(R.id.nom);
        final EditText matri=(EditText) findViewById(R.id.matricul);
        final EditText email=(EditText) findViewById(R.id.em);
        final EditText mdp=(EditText) findViewById(R.id.mdp);

//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item,rol);

        spinner=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.role,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);



        DAO dao= new DAO();
       adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User u = new  User(pre.getText().toString(),nom.getText().toString(),
                        matri.getText().toString(),spinner.getSelectedItem().toString(),
                        email.getText().toString(),mdp.getText().toString());
                dao.add(u).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddUser.this, "Utilisateur ajouter avec succes", Toast.LENGTH_SHORT).show();
                        pre.setText("");
                        nom.setText("");
                        matri.setText("");
                        email.setText("");
                        mdp.setText("");

                    }
                });

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