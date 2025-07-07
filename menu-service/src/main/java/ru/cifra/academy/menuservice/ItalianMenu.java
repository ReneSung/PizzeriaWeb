package ru.cifra.academy.menuservice;

public class ItalianMenu {
    public ItalianMenu(String name, Double coast) {
        this.name = name;
        this.coast = coast;
    }

    private String name;
    private Double coast;

    public void setCoast(Double coast) {
        this.coast = coast;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCoast() {
        return this.coast;
    }
}
