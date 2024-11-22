package org.example.eksamenkea.model;

public class Ressource {
    private int ressource_id;
    private String materialhardware;
    private double costrate;

    public Ressource(int ressource_id, String materialhardware, double costrate) {
        this.ressource_id = ressource_id;
        this.materialhardware = materialhardware;
        this.costrate = costrate;
    }

    public int getRessource_id() {
        return ressource_id;
    }

    public void setRessource_id(int ressource_id) {
        this.ressource_id = ressource_id;
    }

    public String getMaterialhardware() {
        return materialhardware;
    }

    public void setMaterialhardware(String materialhardware) {
        this.materialhardware = materialhardware;
    }

    public double getCostrate() {
        return costrate;
    }

    public void setCostrate(double costrate) {
        this.costrate = costrate;
    }
}
