package com.dinet.documents.web.model;

import java.time.LocalDateTime;

public class InventoryResponse {
	
	private final String ruta;
    private final LocalDateTime fecha;
    private final String mensaje;

    public InventoryResponse(String ruta, LocalDateTime now, String mensaje) {
        this.ruta = ruta;
        this.fecha = now;
        this.mensaje = mensaje;
    }


	public String getRuta() {
		return ruta;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}


	public String getMensaje() {
		return mensaje;
	}
    

}
