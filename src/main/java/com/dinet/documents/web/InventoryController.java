package com.dinet.documents.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinet.documents.web.model.InventoryListModel;
import com.dinet.documents.web.model.InventoryModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.gson.Gson;


@RestController
@RequestMapping("/v1/inventory")
public class InventoryController {

	
	
	@GetMapping(produces = { "application/json" })
	public ResponseEntity<String> getAll() throws Exception {

		return new ResponseEntity<String>("Hola", HttpStatus.OK);

	}
	
	
	@PostMapping
    public ResponseEntity<Object> transforme(@RequestBody InventoryListModel inventoryModel) throws IOException  {

		InventoryListModel response = inventoryModel; 
       // Gson gson = new Gson();
       // String json = gson.toJson(response);
      

        ObjectMapper mapper = new ObjectMapper();
       // JsonNode node2 = mapper.createObjectNode();
       // JsonNode node2 = JsonNodeFactory.instance.objectNode();

        JsonNode node = mapper.valueToTree(response);

      
        
        JsonNode header = node.get("header");
    	System.out.println("Ingresa a Body: " + header);
		Iterator<JsonNode> it = header.iterator();
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Data Reporte");
		XSSFSheet sheet2 = wb.createSheet("Resumen");

		Row row = sheet.createRow(0);
		int colNum = 0;
		while(it.hasNext()) {
			Cell cell = row.createCell(colNum++);
			cell.setCellValue(it.next().asText());
		}
		JsonNode body = node.get("inventariolist");
		System.out.println("Ingresa a Body: " + body);
		int rowNum = 1;
		colNum = 0;
		int i = 0;
		JsonNode rowNode;
		while(i < body.size()) {
			
			rowNode = body.get(i++);
			Row bodyRow = sheet.createRow(rowNum++);
			Cell reporteCell = bodyRow.createCell(colNum++);
			Cell ubicacionCell = bodyRow.createCell(colNum++);
			Cell articuloCell = bodyRow.createCell(colNum++);
			Cell descripcionCell = bodyRow.createCell(colNum++);
			Cell estatus_inventarioCell = bodyRow.createCell(colNum++);
			Cell cantidadCell = bodyRow.createCell(colNum++);
			Cell almacenCell = bodyRow.createCell(colNum++);
			Cell status_ubicacionCell = bodyRow.createCell(colNum++);
			Cell cantidad_consiganadaCell = bodyRow.createCell(colNum++);
			Cell areaCell = bodyRow.createCell(colNum++);
			Cell zona_movimientoCell = bodyRow.createCell(colNum++);
			Cell familiaCell = bodyRow.createCell(colNum++);
			
			
			reporteCell.setCellValue(rowNode.get("reporte").asText());
			ubicacionCell.setCellValue(rowNode.get("ubicacion").asText());
			articuloCell.setCellValue(rowNode.get("articulo").asText());
			descripcionCell.setCellValue(rowNode.get("descripcion").asText());
			estatus_inventarioCell.setCellValue(rowNode.get("estatus_inventario").asText());
			cantidadCell.setCellValue(rowNode.get("reporte").asText());
			almacenCell.setCellValue(rowNode.get("ubicacion").asText());
			status_ubicacionCell.setCellValue(rowNode.get("articulo").asText());
			cantidad_consiganadaCell.setCellValue(rowNode.get("descripcion").asText());
			areaCell.setCellValue(rowNode.get("estatus_inventario").asText());
			zona_movimientoCell.setCellValue(rowNode.get("reporte").asText());
			familiaCell.setCellValue(rowNode.get("ubicacion").asText());
			
			colNum = 0;
		}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		   LocalDateTime now = LocalDateTime.now();  
		   
		
		String filename = "D:/Inventory_"+ dtf.format(now) +".xlsx";
		System.out.println("Nombre Archivo  "+filename);
		FileOutputStream outputStream = new FileOutputStream(filename.toString());
		wb.write(outputStream);
		wb.close();
		System.out.println(" Excel file generated");
        

        return new ResponseEntity<>("Se Genero el Archivo: " + filename, HttpStatus.OK);
    }
	
	/*
	 LISTA
	 @PostMapping
    public ResponseEntity<Object> transforme(@RequestBody InventoryListModel inventoryModel)  {

		InventoryListModel response = inventoryModel; 
        Gson gson = new Gson();
        String json = gson.toJson(response);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 @PostMapping
    public ResponseEntity<Object> transforme(@RequestBody List<InventoryModel> inventoryModel)  {

        List<InventoryModel> response = inventoryModel; 
        Gson gson = new Gson();
        String json = gson.toJson(response);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }
	 
	 
	 
	 */
	

	/*
	 @PostMapping
    public ResponseEntity<Object> transforme(@RequestBody InventoryModel inventoryModel)  {

        InventoryModel response = inventoryModel; 
        Gson gson = new Gson();
        String json = gson.toJson(response);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }
		
	 * */
		
		

}
