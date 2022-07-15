package sn.ipsl.gestionedt_sallesdecours_ipsl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class AjoutEDT_Final extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    final String global_class="globalclass";
    final String global_date="globaldate";
    final String global_heur="globalheur";
    final String global_cours="globalcours";
    final String global_nbheur="globalnbheur";
    private Spinner spinner;
    DAO dao= new DAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_edt_final);
        final Button addEDT= findViewById(R.id.ajout_final);

        System.out.println(Find_sall_libre());
        String[] classe=new String[]{"sall 1"};
//        for (String x:list){
//            classe[classe.length]=x;
//        }
        spinner=findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,classe);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        String date = null, heur = null, cours = null, nbheur = null, cla = null;
        Intent recupere=getIntent();
        if (recupere!=null){
            date=recupere.getStringExtra(global_date);
            heur=recupere.getStringExtra(global_heur);
            cours=recupere.getStringExtra(global_cours);
            nbheur=recupere.getStringExtra(global_nbheur);
            cla=recupere.getStringExtra(global_class);
        }

        String finalCla = cla;
        String finalHeur = heur;
        String finalCours = cours;
        String finalDate = date;
        String finalNbheur = nbheur;
        int finalNbheur1=Integer.parseInt(finalNbheur);
        String[] jma = date.split("/");
        int jour=Integer.parseInt(jma[0]);
        int mois=Integer.parseInt(jma[1]);
        int annee=Integer.parseInt(jma[2]);
        int[] m={0,3,3,6,1,4,6,2,5,0,3,5};
        int numj=(jour+(annee-1900)+((annee-1900)/4)+m[mois-1])%7;
        addEDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModelEdt u = new ModelEdt(finalCla, finalHeur, finalCours, finalDate,spinner.getSelectedItem().toString(), finalNbheur1,numj);
                dao.addEdt(u).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AjoutEDT_Final.this, "Utilisateur ajouter avec succes", Toast.LENGTH_SHORT).show();
                        Intent ordre1= new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(ordre1);
                    }
                });

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public List<String> Find_sall_libre(){

        List<String> toutles_sall = null;
//        List<String> toutles_sallOQP = null;
//        List<String> toutles_sallLibre= null;
//        String date = null, heur = null;
//
//        Intent recupere=getIntent();
//        if (recupere!=null){
//            date=recupere.getStringExtra(global_date);
//            heur=recupere.getStringExtra(global_heur);
//
//        }

//
//        dao.getsall().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()) {
//                    for (QueryDocumentSnapshot document : task.getResult()) {
//                        ModelSalle u =document.toObject(ModelSalle.class);
//                        toutles_sall.add(u.getNomSalle());
//                    }
//                }
//            }
//        });

//        dao.getsallOQP(date,heur).addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()) {
//                    for (QueryDocumentSnapshot document : task.getResult()) {
//                        ModelEdt u =document.toObject(ModelEdt.class);
//                        toutles_sallOQP.add(u.getSall());
//                    }
//                }
//            }
//        });

//        for (String u:toutles_sall){
//            String res="ok";
//            for (String v:toutles_sallOQP){
//                if (v==u){
//                    res="ko";
//                }
//            }
//            if (res=="ok"){
//                toutles_sallLibre.add(u);
//            }
//        }
        return toutles_sall;
    }
}