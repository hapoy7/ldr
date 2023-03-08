package com.ldr.manage.sys.role;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.multipart.MultipartFile;

import com.ldr.common.tools.DateUtils;

/**
 * @类说明 【角色】导入导出
 * @author 高振中
 * @date 2021-02-20 11:34:58
 **/
public class RoleExcel {

	/**
	 * @方法说明 【角色】导出
	 **/
	public static HSSFWorkbook bookFile(final List<Role> list) {
		HSSFWorkbook workBook = new HSSFWorkbook();
		String[] header = { "主键", "角色名称", "备注", "排序号", "创建时间" };
		HSSFSheet sheet = workBook.createSheet("test");
		int count = 0;
		Row row = sheet.createRow(count++);
		int column = 0;
		for (String head : header) {
			row.createCell(column++).setCellValue(head);
		}
		for (Role role : list) {
			row = sheet.createRow(count++);
			column = 0;
			row.createCell(column++).setCellValue(role.getRoleId());
			row.createCell(column++).setCellValue(role.getName());
			if (role.getRemark() != null)
				row.createCell(column++).setCellValue(role.getRemark());
			else
				row.createCell(column++);
			if (role.getOrderNum() != null)
				row.createCell(column++).setCellValue(role.getOrderNum());
			else
				row.createCell(column++);
			row.createCell(column).setCellValue(role.getCreateTime().format(DateUtils.FORMAT_ALL));
		}
		return workBook;
	}

	/**
	 * @方法说明 【角色】导入
	 **/
	public static List<Role> list(final MultipartFile file) throws IOException {
		List<Role> list = new ArrayList<>();
		HSSFWorkbook workBook = new HSSFWorkbook(file.getInputStream());
		HSSFSheet sheet = workBook.getSheetAt(0);
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			HSSFRow row = sheet.getRow(i);
			Role role = new Role();
			int j = 0;
			HSSFCell cell;
			cell = row.getCell(j++); if (cell != null && !cell.getCellType().equals(CellType.BLANK)) role.setRoleId((long) cell.getNumericCellValue());
			cell = row.getCell(j++); if (cell != null && !cell.getCellType().equals(CellType.BLANK)) role.setName(cell.getStringCellValue());
			cell = row.getCell(j++); if (cell != null && !cell.getCellType().equals(CellType.BLANK)) role.setRemark(cell.getStringCellValue());
			cell = row.getCell(j++); if (cell != null && !cell.getCellType().equals(CellType.BLANK)) role.setOrderNum(Double.valueOf(cell.getNumericCellValue()).intValue());
			cell = row.getCell(j); if (cell != null && !cell.getCellType().equals(CellType.BLANK)) role.setCreateTime(LocalDateTime.parse(cell.getStringCellValue(), DateUtils.FORMAT_ALL));
			role.setDr((byte)0);
			list.add(role);
		}
		workBook.close();
		return list;
	}
}
