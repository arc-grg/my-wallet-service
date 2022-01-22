package com.wallet.controller;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.wallet.entity.AccountEntity;



public class ExcelGenerator 
{
	public static ByteArrayInputStream studentToExcel(List<AccountEntity> students) throws IOException
	{
		String[] columns = {"Name","AccountNumber","Amount","Gender"};
		try(
			Workbook workbook = new XSSFWorkbook();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			){
			Sheet sheet = workbook.createSheet("Students");
			
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
			
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
			
			//Row for Header-->
			Row headerRow = sheet.createRow(0);
			
			//Header
			for(int col=0; col<columns.length; col++)
			{
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(columns[col]);
				cell.setCellStyle(headerCellStyle);
			}
			
			int rowIdx =1;
			for(AccountEntity stud: students)
			{
				Row row = sheet.createRow(rowIdx++);
				
				row.createCell(0).setCellValue(stud.getUserName());
				row.createCell(1).setCellValue(stud.getAccountNumber());
				row.createCell(2).setCellValue(stud.getBalance());
				row.createCell(3).setCellValue(stud.getGender());
			}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
}
