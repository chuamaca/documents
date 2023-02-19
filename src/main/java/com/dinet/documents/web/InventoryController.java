package com.dinet.documents.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataConsolidateFunction;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFPivotTable;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dinet.documents.web.model.InventoryListModel;
import com.dinet.documents.web.model.InventoryModel;
import com.dinet.documents.web.model.InventoryModelHeader;
import com.dinet.documents.web.model.InventoryResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/inventory")
@Slf4j
public class InventoryController {

	
	
	@GetMapping(produces = { "application/json" })
	public ResponseEntity<String> getAll() throws Exception {
		File file = new File("D:\\MaestroDynamica.xlsx");
		log.info("->> GetMapping: " + file);
		return new ResponseEntity<String>("Hola", HttpStatus.OK);
	}
	
	
	@PostMapping
    public ResponseEntity<Object> transforme(@RequestBody InventoryListModel inventoryModel) throws IOException  {
		log.info("->> Inicio: " + inventoryModel);
		
		String json = "{\"header\":[\"reporte\",\"ubicacion\",\"articulo\",\"descripcion\",\"estatus_inventario\",\"cantidad\",\"almacen\",\"status_ubicacion\",\"cantidad_consignada\",\"area\",\"zona_movimiento\",\"familia\"]}";
		log.info("->> json: " + json);
		Gson gson = new Gson();
        InventoryModelHeader headermodel = gson.fromJson(json, InventoryModelHeader.class);
        List<String> headerList = headermodel.getHeader();
        
        InventoryListModel response = inventoryModel;
        log.info("->> response: " + response);
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.valueToTree(response);
        log.info("->> node: " + node);
        JsonNode nodehdr = mapper.valueToTree(headerList);

        JsonNode header = nodehdr;//.get("header");
    	System.out.println("Ingresa a Header: " + header);
    	log.info("Ingresa a Header: " + header);
		Iterator<JsonNode> it = header.iterator();

		//Archivo Origen
		//File file = new File("\\\\172.16.163.11\\wmsdev2_1\\LES\\files\\reports\\A1034\\Copia\\MaestroDynamica.xlsx");
		//File file = new File("C:\\report");
		File file = new File("C:\\report\\Plantilla\\MaestroDynamica.xlsx");
		log.info("->>File Master: " + file);
		FileInputStream inputStream = new FileInputStream(file);
		log.info("->>File inputStream: " + inputStream);
		
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		log.info("->> wb: " + wb);
		/*
		 
	 	XSSFSheet sheet2 = wb.getSheet("Resumen"); 
		 XSSFSheet sheet = wb.createSheet("Data Reporte");
		 * */
		 
		XSSFSheet sheet = wb.getSheet("Data Reporte");
		//XSSFSheet sheet2 = wb.createSheet("Resumen");
		log.info("->> sheet: " + sheet);
		Row row = sheet.createRow(0);
		log.info("->> row: " + row);
		int colNum = 0;
		while(it.hasNext()) {
			Cell cell = row.createCell(colNum++);
			cell.setCellValue(it.next().asText());
		}
		
		JsonNode body = node.get("inventariolist");
		System.out.println("Ingresa a Body: " + body);
		log.info("Ingresa a Body: " + body);
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
			Cell cantidad_consignadaCell = bodyRow.createCell(colNum++);
			Cell areaCell = bodyRow.createCell(colNum++);
			Cell zona_movimientoCell = bodyRow.createCell(colNum++);
			Cell familiaCell = bodyRow.createCell(colNum++);
			
			
			reporteCell.setCellValue(rowNode.get("reporte").asText());
			ubicacionCell.setCellValue(rowNode.get("ubicacion").asText());
			articuloCell.setCellValue(rowNode.get("articulo").asText());
			descripcionCell.setCellValue(rowNode.get("descripcion").asText());
			estatus_inventarioCell.setCellValue(rowNode.get("estatus_inventario").asText());
			cantidadCell.setCellValue(rowNode.get("cantidad").asDouble());
			almacenCell.setCellValue(rowNode.get("almacen").asText());
			status_ubicacionCell.setCellValue(rowNode.get("status_ubicacion").asText());
			cantidad_consignadaCell.setCellValue(rowNode.get("cantidad_consignada").asText());
			areaCell.setCellValue(rowNode.get("area").asText());
			zona_movimientoCell.setCellValue(rowNode.get("zona_movimiento").asText());
			familiaCell.setCellValue(rowNode.get("familia").asText());
			
			colNum = 0;
		}
		
			
	 	XSSFSheet sheet1 = wb.getSheetAt(0); 
        
        
        /* Get the reference for Pivot Data */
        AreaReference a=new AreaReference("A:L",SpreadsheetVersion.EXCEL2007);
        /* Find out where the Pivot Table needs to be placed */
        XSSFSheet pivot_sheet=wb.createSheet();
        CellReference b=new CellReference("A1");
        /* Create Pivot Table */
        XSSFPivotTable pivotTable = pivot_sheet.createPivotTable(a,b,sheet1);
        /* Add filters */
        //pivotTable.addReportFilter(0);
        pivotTable.addRowLabel(10);
        pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 5);
        
        /* Write Pivot Table to File */
		
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		LocalDateTime now = LocalDateTime.now();  
		//String filename = "\\\\172.16.163.11\\wmsdev2_1\\LES\\files\\reports\\A1034\\Inventory_"+ dtf.format(now) +".xlsx";
		String filename = "C:\\report\\Stock_"+ dtf.format(now) +".xlsx";
		//String filename = "D:\\Inventory_"+ dtf.format(now) +".xlsx";
		log.info("Ingresa a FileName SAVE: " + filename);
		System.out.println("RUTA: " + filename);
		System.out.println("Nombre Archivo  "+filename);
		
		
		FileOutputStream outputStream = new FileOutputStream(filename.toString());
		wb.write(outputStream);
		wb.close();
		outputStream.close();
		
		System.out.println(" Excel file generated");
		
		String responsevalue= filename.toString();
		
		InventoryResponse rs= new InventoryResponse(responsevalue,now,"OK");
		log.info("respuesta: " + rs);
		System.out.println("respuesta: "+rs);
		return new ResponseEntity<Object>(new InventoryResponse(rs.getRuta(),rs.getFecha(),rs.getMensaje()),HttpStatus.OK);
        
        //return new ResponseEntity(new InventoryResponse)
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
