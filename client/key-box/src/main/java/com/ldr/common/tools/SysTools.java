package com.ldr.common.tools;

import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * 系统工具
 * @author 高振中
 * @date 2021-03-10 20:20:20
 */
@Slf4j
public class SysTools {

	public static void main(String[] args) {
		String a = "love23next234csdn3423javaeye";
		log.info("num={}", getNum(a));
		a = "5Mb";
		log.info("num={}", getNum(a));
	}

	/**
	 * 从字符中提取数字
	 */
	public static Integer getNum(String string) {
		String str = Pattern.compile("[^0-9]").matcher(string).replaceAll("");// 把0~9以外的字符串全替换掉
		return Integer.valueOf(str);
	}
 
	public static void write(HttpServletResponse response, HSSFWorkbook workBook) throws IOException {
		response.reset();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename=workBook.xls");
		OutputStream out = response.getOutputStream();
		workBook.write(out);
		out.flush();
		out.close();
		workBook.close();
	}
}