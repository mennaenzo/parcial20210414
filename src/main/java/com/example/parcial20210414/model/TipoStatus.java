package com.example.parcial20210414.model;

public enum TipoStatus {
    BAJA("Clase Baja"),
    MEDIA("Clase Media"),
    ALTA("Clase Alta");

    private String descripcion;

    TipoStatus(String descripcion) {
        this.descripcion = descripcion;
    }

    public static TipoStatus find(final String value) {
        for (TipoStatus v : values()) {
            if (v.toString().equalsIgnoreCase(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException(String.format("TipoStatus Invalido: %s", value));
    }

    public String getDescripcion() {
        return descripcion;
    }
}
