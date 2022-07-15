package sn.ipsl.gestionedt_sallesdecours_ipsl;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class DAO {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    CollectionReference link = db.collection("user");
    CollectionReference links = db.collection("salledecours");
    CollectionReference link1= db.collection("edt");



    public Task<Void> add(User e)
    {
        return link.document().set(e);
    }
    public Task<Void> addsall(ModelSalle m) {
        return links.document().set(m);
    }
    public Task<Void> addEdt(ModelEdt edt)
    {
        return link1.document().set(edt);
    }
    public Task<QuerySnapshot> connect(String e)
    {
        return link.whereEqualTo("email", e).get();

    }
    public Task<QuerySnapshot> getsall()
    {
        return links.get();

    }

    public Task<QuerySnapshot> getsallOQP(String a,String b)
    {
        return link1.whereEqualTo("date", a).whereEqualTo("heure",b).get();

    }

    public Task<QuerySnapshot> getedt(int a)
    {
        return link1.whereEqualTo("numjour",a).get();

    }

}
