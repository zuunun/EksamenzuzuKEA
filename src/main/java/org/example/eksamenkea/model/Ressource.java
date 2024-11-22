package org.example.eksamenkea.model;

public class Ressource {
    private int ressource_id;
    private String materialhardware;
    private double cost;

    public Ressource(int ressource_id, String materialhardware, int cost) {
        this.ressource_id = ressource_id;
        this.materialhardware = materialhardware;
        this.cost = cost;
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

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Ressource{" +
                "ressource_id=" + ressource_id +
                ", materialhardware='" + materialhardware + '\'' +
                ", cost=" + cost +
                '}';
    }
}
