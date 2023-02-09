package com.dinet.documents.web.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class InventoryModel {
	
	private String reporte;
	private String ubicacion;
	private String articulo;
	private String descripcion;
	private String estatus_inventario;
	private String cantidad;
	private String almacen;
	private String status_ubicacion;
	private String cantidad_consiganada;
	private String area;
	private String zona_movimiento;
	private String familia;
	
	

}




