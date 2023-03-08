package com.ldr.common.tools;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @summary【日期时间】工具(对于新日期时间类绝大部分情况直接使用即可,没有必封装方法)
 * @author 高振中
 * @date 2021-03-05 20:20:20
 **/
public class DateUtils {

	public static final DateTimeFormatter FORMAT_ALL = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public static final DateTimeFormatter FORMAT_HMS = DateTimeFormatter.ofPattern("HH:mm:ss");
	public static final DateTimeFormatter FORMAT_YMD = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	/**
	 * (LocalDateTime)-->String(yyyy-MM-dd HH:mm:ss)
	 */
	public static String formatAll(LocalDateTime time) { return FORMAT_ALL.format(time); }

	/**
	 *  (LocalDateTime)-->String(yyyy-MM-dd)
	 */
	public static String formatYmd(LocalDateTime time) { return FORMAT_YMD.format(time); }

	/**
	 *  (LocalDateTime)-->String(HH:mm:ss)
	 */
	public static String formatHms(LocalDateTime time) { return FORMAT_HMS.format(time); }

	/**
	 *  (LocalTime)-->String(HH:mm:ss)
	 */
	public static String formatHms(LocalTime time) { return FORMAT_HMS.format(time); }

	/**
	 *  (LocalDate)-->String(yyyy-MM-dd)
	 */
	public static String formatYmd(LocalDate date) { return FORMAT_YMD.format(date); }

	/**
	 *  String(yyyy-MM-dd HH:mm:ss)-->(LocalDateTime)
	 */
	public static LocalDateTime parse(String dateTime) { return LocalDateTime.parse(dateTime, FORMAT_ALL); }

	/**
	 *  String(yyyy-MM-dd)-->(LocalDate)
	 */
	public static LocalDate parseYmd(String date) { return LocalDate.parse(date, FORMAT_YMD); }

	/**
	 *  (LocalDateTime)-->(LocalDate)
	 */
	public static LocalDate toLocalDate(LocalDateTime dateTime) { return dateTime.toLocalDate(); }

	/**
	 *  (LocalDateTime)-->(LocalTime)
	 */
	public static LocalTime toLocalTime(LocalDateTime dateTime) { return dateTime.toLocalTime(); }

	/**
	 *  (LocalDate)-->(LocalDateTime)
	 */
	public static LocalDateTime toLocalDateTime(LocalDate date) {  return date.atStartOfDay(); }
//	return LocalDateTime.of(date, LocalTime.MIDNIGHT);
}
