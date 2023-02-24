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
		String valie= "{\"uts_header\":{\"origen\":\"ECOM\",\"dn\":\"6772465360\",\"fecha_creacion\":\"20200114000000\",\"fecha_de_ingreso\":\"20200114000000\",\"purchase_order\":\"APE00801688\",\"unidades\":\"2\",\"guia\":\"A1034000000001564483\",\"fecha_despacho\":\"20200114191255\",\"calle\":\"Avenida Del Ejercito 530\",\"numero\":\"Edificio de Herbalfie\",\"localidad\":\"150122\",\"solicitante\":\"Mylene\",\"telefono\":\"977350271\",\"total_lpn_quantity\":\"1\",\"detail\":[{\"nro_oc_cliente\":\"APE00801688\",\"ordnum\":\"6772465360\",\"prtnum\":\"FI4664250\",\"desc_talla\":\"M\",\"lngdsc\":\"M * M AAC FZ Hoodie     TINLEY * LEGINK\",\"inloadqty\":\"1\"},{\"nro_oc_cliente\":\"APE00801688\",\"ordnum\":\"6772465360\",\"prtnum\":\"FP8074230\",\"desc_talla\":\"S\",\"lngdsc\":\"S * W St Tracktop       NEGRO * BLACK\",\"inloadqty\":\"1\"}]}}";
		
			if(valie.contains("uts_headerp")){
            
	            String newJson = valie.replace("{\"uts_header\":","");
	            String newjson2 = newJson.substring(1, newJson.length()-1);
	            
	            String newjson3= "[{"+newjson2+"]";
	            System.out.println(newjson3);
           
            }else {
            	 String newJson = valie.replace("{\"uts_header\":","");
 	            String newjson2 = newJson.substring(1, newJson.length()-1);
 	            
 	            String jsonOk="[{\"origen\":\"NO ECOM\",\"dn\":\"6755231824\",\"fecha_creacion\":\"2023-02-21T15:21:06.236Z\",\"fecha_de_ingreso\":\"2023-02-21T15:21:06.236Z\",\"purchase_order\":\"L59099-001\",\"unidades\":10,\"guia\":\"A1034000000009315121\",\"fecha_despacho\":\"2023-02-21T15:21:06.236Z\",\"tpent\":\"\",\"calle\":\"AV ALFREDO MENDIOLA 3698\",\"numero\":\"111\",\"localidad\":\"040513\",\"solicitante\":\"ADIDAS KIDS MEGA PLAZA\",\"peso\":\"10\",\"telefono\":\"987654321\",\"complemento\":\"\",\"carrier\":\"Dinet\",\"region\":\"LIMA\",\"email\":\"cesarq@gmail.com\",\"soldto\":\"6720000917\",\"soldto_name\":\"ADIDAS KIDS MEGA PLAZA\",\"shipto\":\"6720000917\",\"shipto_name\":\"ADIDAS KIDS MEGA PLAZA\",\"shipto_addr_1\":\"CALL01\",\"shipto_addr_2\":\"CALL01\",\"shipto_addr_3\":\"CALL01\",\"shipto_city\":\"LIMA\",\"shipto_zip\":\"040513\",\"estimated_weight\":\"1\",\"total_lpn_quantity\":\"5\",\"detalle\":[{\"purchase_order\":\"L59099-001\",\"dn\":\"6755231824\",\"id\":\"\",\"brcd\":\"\",\"articulo\":\"DZ9347120\",\"talla_us\":\"M\",\"description\":\"M * 3S CSH CRW3P        NEGRO/NEGR * BLACKBLACKBLACK\",\"units\":\"10\"},{\"purchase_order\":\"L59099-001\",\"dn\":\"6755231824\",\"id\":\"\",\"brcd\":\"\",\"articulo\":\"DZ9347120\",\"talla_us\":\"M\",\"description\":\"M * 3S CSH CRW3P        NEGRO/NEGR * BLACKBLACKBLACK\",\"units\":\"10\"}]},{\"origen\":\"NO ECOM\",\"dn\":\"6755231824\",\"fecha_creacion\":\"2023-02-21T15:21:06.236Z\",\"fecha_de_ingreso\":\"2023-02-21T15:21:06.236Z\",\"purchase_order\":\"L59099-001\",\"unidades\":10,\"guia\":\"A1034000000009315121\",\"fecha_despacho\":\"2023-02-21T15:21:06.236Z\",\"tpent\":\"\",\"calle\":\"AV ALFREDO MENDIOLA 3698\",\"numero\":\"111\",\"localidad\":\"040513\",\"solicitante\":\"ADIDAS KIDS MEGA PLAZA\",\"peso\":\"10\",\"telefono\":\"987654321\",\"complemento\":\"\",\"carrier\":\"Dinet\",\"region\":\"LIMA\",\"email\":\"cesarq@gmail.com\",\"soldto\":\"6720000917\",\"soldto_name\":\"ADIDAS KIDS MEGA PLAZA\",\"shipto\":\"6720000917\",\"shipto_name\":\"ADIDAS KIDS MEGA PLAZA\",\"shipto_addr_1\":\"CALL01\",\"shipto_addr_2\":\"CALL01\",\"shipto_addr_3\":\"CALL01\",\"shipto_city\":\"LIMA\",\"shipto_zip\":\"040513\",\"estimated_weight\":\"1\",\"total_lpn_quantity\":\"5\",\"detalle\":[{\"purchase_order\":\"L59099-001\",\"dn\":\"6755231824\",\"id\":\"\",\"brcd\":\"\",\"articulo\":\"DZ9347120\",\"talla_us\":\"M\",\"description\":\"M * 3S CSH CRW3P        NEGRO/NEGR * BLACKBLACKBLACK\",\"units\":\"10\"},{\"purchase_order\":\"L59099-001\",\"dn\":\"6755231824\",\"id\":\"\",\"brcd\":\"\",\"articulo\":\"DZ9347120\",\"talla_us\":\"M\",\"description\":\"M * 3S CSH CRW3P        NEGRO/NEGR * BLACKBLACKBLACK\",\"units\":\"10\"}]}]";
 	            String jsonEdit="";
 	            String newjson3= "[{"+newjson2+"]";
 	            System.out.println(newjson3);
 	            System.out.println("Entro al Else");
            	
            }
		
		
		
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
        pivotTable.addRowLabel(4);
        pivotTable.addRowLabel(1);
        pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 5);
        
        //
        
       // XSSFSheet sheetPi = wb.getSheetAt(1);
       // XSSFPivotTable pivotTableNew = sheetPi.getPivotTables().get(i);
        
       // AreaReference dataArea = pivotTableNew.

        
        
        //
        
        
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
