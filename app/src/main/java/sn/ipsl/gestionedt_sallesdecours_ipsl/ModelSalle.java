package sn.ipsl.gestionedt_sallesdecours_ipsl;

public class ModelSalle {
    private String nomSalle,emplacement,description;

    public ModelSalle() {
    }

    public ModelSalle(String nomSalle, String emplacement, String description) {
        this.nomSalle = nomSalle;
        this.emplacement = emplacement;
        this.description = description;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ModelSalle{" +
                "nomSalle='" + nomSalle + '\'' +
                ", emplacement='" + emplacement + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
