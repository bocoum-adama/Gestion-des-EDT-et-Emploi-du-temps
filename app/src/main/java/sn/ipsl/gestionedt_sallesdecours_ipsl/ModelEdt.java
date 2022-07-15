package sn.ipsl.gestionedt_sallesdecours_ipsl;

public class ModelEdt {
    private String classe ,heure,cours,date,sall;
    private int nombre_heur,numjour;

    public ModelEdt() {
    }

    public ModelEdt(String classe, String heure, String cours, String date, String sall, int nombre_heur,int numjour) {
        this.classe = classe;
        this.heure = heure;
        this.cours = cours;
        this.date = date;
        this.sall = sall;
        this.nombre_heur = nombre_heur;
        this.numjour = numjour;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getCours() {
        return cours;
    }

    public void setCours(String cours) {
        this.cours = cours;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNombre_heur() {
        return nombre_heur;
    }

    public void setNombre_heur(int nombre_heur) {
        this.nombre_heur = nombre_heur;
    }

    public String getSall() {
        return sall;
    }

    public void setSall(String sall) {
        this.sall = sall;
    }

    public int getNumjour() {
        return numjour;
    }

    public void setNumjour(int numjour) {
        this.numjour = numjour;
    }

    @Override
    public String toString() {
        return "ModelEdt{" +
                "classe='" + classe + '\'' +
                ", heure='" + heure + '\'' +
                ", cours='" + cours + '\'' +
                ", date='" + date + '\'' +
                ", sall='" + sall + '\'' +
                ", nombre_heur=" + nombre_heur +
                '}';
    }
}
