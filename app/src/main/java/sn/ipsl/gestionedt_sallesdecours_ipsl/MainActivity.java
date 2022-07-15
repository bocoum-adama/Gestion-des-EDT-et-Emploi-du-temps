package sn.ipsl.gestionedt_sallesdecours_ipsl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button connexion= findViewById(R.id.aj2);
        final EditText email= (EditText) findViewById(R.id.email);
        final EditText mdp=(EditText) findViewById(R.id.motdp);

        DAO dao= new DAO();
        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dao.connect(email.getText().toString()).addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                User u =document.toObject(User.class);
                                String a =mdp.getText().toString().replaceAll("\\s+","");
                                System.out.println(u);
                                if ( a.equals(u.getMdp()) ){

                                    switch (u.getRole()){
                                        case "etudiant":
                                            Intent ordre1= new Intent(getApplicationContext(),ConsulterEDTjours.class);
                                            startActivity(ordre1);
                                            break;
                                        case "professeur":
                                            Intent ordre3= new Intent(getApplicationContext(),ConsulterEDTjours.class);
                                            startActivity(ordre3);
                                            break;
                                        case "CSP":
                                            Intent ordre2= new Intent(getApplicationContext(),AdminInterface.class);
                                            startActivity(ordre2);
                                            break;

                                    }

                                }else{
                                    mdp.setError("INCORRECTE");
                                }
                            }
                        } else {
                            email.setError("INCORRECTE");                        }
                    }
                });

            }
        });
    }
}