package sn.ipsl.gestionedt_sallesdecours_ipsl;

public class User {

    String prenom;
    String nom;
    String matricule;
    String role;
    String email;
    String mdp;

    public User() {
    }

    public User(String prenom, String nom, String matricule, String role, String email, String mdp) {
        this.prenom = prenom;
        this.nom = nom;
        this.matricule = matricule;
        this.role = role;
        this.email = email;
        this.mdp = mdp;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "User{" +
                "prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
