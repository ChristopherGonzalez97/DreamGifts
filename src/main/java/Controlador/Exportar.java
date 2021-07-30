/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Venta;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author MADICAP
 */
public class Exportar {
    public void ExportarVentas(ArrayList<Venta> ventas) throws FileNotFoundException, IOException
    {
        
        
        
        JFileChooser excelFileChooser = new JFileChooser();
    
        excelFileChooser.setDialogTitle("Guardar como...");
        
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
        excelFileChooser.setFileFilter(fnef);
        XSSFWorkbook excel=null;
       FileOutputStream ExcelFOS=null;
       BufferedOutputStream BOS=null;
           int excelChooser= excelFileChooser.showSaveDialog(null);
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");  
           
            
        if(excelChooser==JFileChooser.APPROVE_OPTION)
        {   
              excel = new XSSFWorkbook(); 
              XSSFSheet sheet = excel.createSheet("Ventas");

               CellStyle cellStyle3 = excel.createCellStyle();
              cellStyle3.setBorderBottom(BorderStyle.MEDIUM);
              cellStyle3.setBorderLeft(BorderStyle.MEDIUM);
              cellStyle3.setBorderRight(BorderStyle.MEDIUM);
              cellStyle3.setBorderTop(BorderStyle.MEDIUM);
              cellStyle3.setAlignment(HorizontalAlignment.CENTER);  
              cellStyle3.setFillForegroundColor(IndexedColors.BLACK.getIndex());
              cellStyle3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
              Font font3 = excel.createFont();
              font3.setFontHeightInPoints((short)12);
              font3.setColor(IndexedColors.WHITE.getIndex());
              font3.setBold(true);
              cellStyle3.setFont(font3);
              
              CellStyle cellStyle = excel.createCellStyle();
              cellStyle.setBorderBottom(BorderStyle.MEDIUM);
              cellStyle.setBorderLeft(BorderStyle.MEDIUM);
              cellStyle.setBorderRight(BorderStyle.MEDIUM);
              cellStyle.setBorderTop(BorderStyle.MEDIUM);
              cellStyle.setAlignment(HorizontalAlignment.CENTER);  
              cellStyle.setFillForegroundColor(IndexedColors.BLACK.getIndex());
              cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
              Font font = excel.createFont();
              font.setFontHeightInPoints((short)12);
              font.setColor(IndexedColors.WHITE.getIndex());
              font.setBold(true);
              
              cellStyle.setFont(font);  
              CellStyle cellStyle2 = excel.createCellStyle();
              cellStyle.setBorderBottom(BorderStyle.MEDIUM);
              cellStyle.setBorderLeft(BorderStyle.MEDIUM);
              cellStyle.setBorderRight(BorderStyle.MEDIUM);
              cellStyle.setBorderTop(BorderStyle.MEDIUM);
              cellStyle.setAlignment(HorizontalAlignment.CENTER);  
              Font font2 = excel.createFont();
              font2.setFontHeightInPoints((short)10);
              font2.setColor(IndexedColors.BLACK.getIndex());
              cellStyle2.setFont(font2);  
              
              
              
              
              XSSFRow row = sheet.createRow(0);
              XSSFCell cell = row.createCell(0);
              cell.setCellStyle(cellStyle3);
              cell.setCellValue("Ventas");
              sheet.addMergedRegion(new CellRangeAddress(0,0,0,15));
              int fila =1;
              row =sheet.createRow(fila);
              cell=row.createCell(0);
              cell.setCellValue("Id de venta");
              cell.setCellStyle(cellStyle);
              cell=row.createCell(1);
              cell.setCellValue("Cliente");
              cell.setCellStyle(cellStyle);
              cell=row.createCell(2);
              cell.setCellValue("Telefono");
              cell.setCellStyle(cellStyle);
              cell=row.createCell(3);
              cell.setCellValue("Pack");
              cell.setCellStyle(cellStyle);
              cell=row.createCell(4);
              cell.setCellValue("Fecha de la venta");
              cell.setCellStyle(cellStyle);
              cell=row.createCell(5);
              cell.setCellValue("Valor de la venta");
              cell.setCellStyle(cellStyle);                  
              cell=row.createCell(6);
              cell.setCellValue("Red Social");
              cell.setCellStyle(cellStyle);
              
              cell=row.createCell(7);
              cell.setCellValue("Destinatario");
              cell.setCellStyle(cellStyle);
              cell=row.createCell(8);
              cell.setCellValue("Comuna");
              cell.setCellStyle(cellStyle);
              cell=row.createCell(9);
              cell.setCellStyle(cellStyle);
              cell.setCellValue("Direccion");
             
              cell=row.createCell(10);
              cell.setCellStyle(cellStyle);
              cell.setCellValue("Banco");
              cell=row.createCell(11);
              cell.setCellStyle(cellStyle);
              cell.setCellValue("Fecha de transferencia");
              cell=row.createCell(12);
              cell.setCellStyle(cellStyle);
              cell.setCellValue("Codigo de transferencia");
              cell=row.createCell(13);
              cell.setCellStyle(cellStyle);
              cell.setCellValue("Estado");
              for(Venta v:ventas)
              {
                  fila++;
                  row =sheet.createRow(fila);
                  cell=row.createCell(0);
                  cell.setCellValue(v.getVtaIdVenta());
                  cell.setCellStyle(cellStyle2);
                  cell=row.createCell(1);
                  cell.setCellValue(v.getCliIdCliente().getNombreCompleto());
                  cell.setCellStyle(cellStyle2);
                  cell=row.createCell(2);
                  cell.setCellValue(v.getVtaTelefono());
                  cell.setCellStyle(cellStyle2);
                  cell=row.createCell(3);
                  cell.setCellValue(v.getPckIdPack().getPckNombre());
                  cell.setCellStyle(cellStyle2);
                  cell=row.createCell(4);
                  cell.setCellValue(dateFormat.format(v.getVtaFechaVenta()));
                  cell.setCellStyle(cellStyle2);
                  cell=row.createCell(5);
                  cell.setCellValue(v.getVtaTotal());
                  cell.setCellStyle(cellStyle2);                  
                  cell=row.createCell(6);
                  cell.setCellValue(v.getRrssRrsIdRrss().getRrsNombre());
                  cell.setCellStyle(cellStyle2);                  
                  cell=row.createCell(7);
                  cell.setCellValue(v.getVtaNombreDestinatario());
                  cell.setCellStyle(cellStyle2);
                  cell=row.createCell(8);
                  cell.setCellValue(v.getComunaIdComuna().getComNombre());
                  cell.setCellStyle(cellStyle2);
                  cell=row.createCell(9);
                  cell.setCellStyle(cellStyle2);
                  cell.setCellValue(v.getVtaDireccionDestinatario());
                  cell=row.createCell(10);
                  cell.setCellStyle(cellStyle2);
                  cell.setCellValue(v.getBanIdBanco().getBanNombre());  
                  cell=row.createCell(11);
                  cell.setCellStyle(cellStyle2);
                  cell.setCellValue(dateFormat.format(v.getVtaFechaTransferencia()));
                  cell=row.createCell(12);
                  cell.setCellStyle(cellStyle2);
                  cell.setCellValue(v.getVtaCodigoTransferencia());
                  cell=row.createCell(13);
                  cell.setCellStyle(cellStyle2);
                  cell.setCellValue(v.getEstadoVentaIdEstado().getEstDescripcion());
                  
              }
              sheet.autoSizeColumn(0);
              sheet.autoSizeColumn(1);
              sheet.autoSizeColumn(2);
              sheet.autoSizeColumn(3);
              sheet.autoSizeColumn(4);
              sheet.autoSizeColumn(5);
              sheet.autoSizeColumn(6);
              sheet.autoSizeColumn(7);
              sheet.autoSizeColumn(8);
              sheet.autoSizeColumn(9);
              sheet.autoSizeColumn(10);
              sheet.autoSizeColumn(11);
              sheet.autoSizeColumn(12);
              sheet.autoSizeColumn(13);
              sheet.autoSizeColumn(14);
              sheet.autoSizeColumn(15);
              ExcelFOS = new FileOutputStream(excelFileChooser.getSelectedFile()+".xlsx");
              BOS = new BufferedOutputStream(ExcelFOS);
              excel.write(BOS);
              BOS.close();
              ExcelFOS.close();
              excel.close();
        }
       
        
    }
}
