package sn.ipsl.gestionedt_sallesdecours_ipsl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ConsulterEDT extends AppCompatActivity {

    final String global_jour="globaljour";
    DAO dao= new DAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_edt);
        final TextView h8=(TextView) findViewById(R.id.h8);
        final TextView h9=(TextView) findViewById(R.id.h9);
        final TextView h10=(TextView) findViewById(R.id.h10);
        final TextView h11=(TextView) findViewById(R.id.h11);
        final TextView h12=(TextView) findViewById(R.id.h12);
        final TextView h15=(TextView) findViewById(R.id.h15);
        final TextView h16=(TextView) findViewById(R.id.h16);
        final TextView h17=(TextView) findViewById(R.id.h17);
        final TextView h18=(TextView) findViewById(R.id.h18);
        final TextView h19=(TextView) findViewById(R.id.h19);
        TextView[] tv={h8,h9,h10,h11,h12,h15,h16,h17,h18,h19};

//        int color = (0xff) << 24 | (0x0) << 16 | (0xff) << 8 | (0xff);
//        h8.setBackgroundColor(color);
        String j=null;
        Intent recupere=getIntent();
        if (recupere!=null){
            j=recupere.getStringExtra(global_jour);

        }
        int jr= Integer.parseInt(j);

        dao.getedt(jr).addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        ModelEdt u =document.toObject(ModelEdt.class);
                        String[] hr = u.getHeure().split(":");
                        int heur =Integer.parseInt(hr[0]);
                        for (int i=0;i<u.getNombre_heur();i++){
                            tv[heur-8].setText(u.getCours());
                            int color = (0xff) << 24 | (0xa6) << 16 | (0xca) << 8 | (0xf0);
                            tv[heur-8].setBackgroundColor(color);
                            heur=heur+1;
                        }
                    }
                }
            }
        });






    }


}