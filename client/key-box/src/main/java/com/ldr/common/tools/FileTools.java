package com.ldr.common.tools;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ldr.common.base.utils.Tools;

import lombok.extern.slf4j.Slf4j;

/**
 * @summary【上传文件】工具
 * @author 高振中
 * @date 2021-03-08 20:20:20
 */
@Slf4j
@Component
public class FileTools {
	@Value(value = "${spring.rootpath}")
	private String rootPath;
	@Value(value = "${spring.rooturl}")
	private String rootUrl;
	private static final String MESSAGE = "保文件时出现IOException异常!";
	private static final String MESSAGE_1 = "从url读取文件流时发生IOException异常";
	private static final String MESSAGE_2 = "取扩展名异常！";

	/**
	 * 保存文件(MultipartFile)
	 */
	public FileVo saveFile(MultipartFile file, String target) {
		String fileName = Tools.uuid();// 生成主文件名
		String oriName = file.getOriginalFilename();// 原始文件名
		String extName = oriName.substring(oriName.lastIndexOf("."));// 扩展名
		String fullPath = rootPath + target + fileName + extName;// 完整路径
		try {
			Files.createDirectories(Paths.get(fullPath).getParent());
			file.transferTo(new File(fullPath));// 保存文件
		} catch (IOException e) {
			log.error(MESSAGE, e);
			throw new RuntimeException(MESSAGE);
		}
		return FileVo.builder().fileUrl(rootUrl + target + fileName + extName).filePath(target + fileName + extName).fileName(oriName).fileSize(getSize(file.getSize())).build();

	}

	/**
	 * 保存文件(File)
	 */
	public FileVo saveFile(File file, String target) {
		String uuid = Tools.uuid();// 生成主文件名
		String oriName = file.getName();// 原始文件名
		String extName = oriName.substring(oriName.lastIndexOf("."));// 扩展名
		String fullPath = rootPath + target + uuid + extName;// 完整路径
		try {
			Files.createDirectories(Paths.get(fullPath).getParent());
			Files.copy(file.toPath(), Paths.get(fullPath));
		} catch (IOException e) {
			log.error(MESSAGE, e);
			throw new RuntimeException(MESSAGE);
		}
		return FileVo.builder().fileUrl(rootUrl + target + uuid + extName).filePath(target + uuid + extName).fileName(oriName).fileSize(getSize(file.length())).build();
	}

	/**
	 * 从已知的文件路径保存获取文件并保存
	 */
	public FileVo saveFile(String srcUrl, String targetPath) {
		return saveFile(getFileBytes(srcUrl), targetPath);
	}

	/**
	 * 从输入流中获取数据
	 */
	public FileVo saveFile(byte[] bytes, String target) {
		String uuid = Tools.uuid();// 生成主文件名
		String extName = extName(bytes);
		String fullPath = rootPath + target + uuid + extName;// 完成路径
		try {
			Files.createDirectories(Paths.get(fullPath).getParent());
			Files.write(Paths.get(fullPath), bytes);// 保存文件
		} catch (IOException e) {
			log.error(MESSAGE, e);
			throw new RuntimeException(MESSAGE);
		}
		return FileVo.builder().fileUrl(rootUrl + target + uuid + extName).filePath(target + uuid + extName).fileName(uuid).fileSize(getSize(bytes.length)).build();
	}

	/**
	 * 删除文件
	 */
	public boolean deleteFile(String path) {
		return new File(rootPath + path).delete();
	}

	/**
	 * 从url读取文件流
	 */
	private static byte[] getFileBytes(String imgUrl) {
		ByteArrayOutputStream swapStream = null;
		try {
			URL url = new URL(imgUrl);
			URLConnection connection = url.openConnection();
			InputStream inStream = connection.getInputStream();
			swapStream = new ByteArrayOutputStream();
			byte[] buff = new byte[1024 << 3];
			int rc = 0;
			while ((rc = inStream.read(buff, 0, 100)) > 0)
				swapStream.write(buff, 0, rc);
		} catch (IOException e) {
			log.error(MESSAGE_1, e);
			throw new RuntimeException(MESSAGE_1);
		}
		assert swapStream != null;
		return swapStream.toByteArray();
	}

	/**
	 * 取扩展名
	 */
	private static String extName(byte[] data) {
		try {
			if (data[1] == 'P' && data[2] == 'N' && data[3] == 'G')
				return ".png";
			if (data[0] == 'G' && data[1] == 'I' && data[2] == 'F')
				return ".gif";
			if (data[6] == 'J' && data[7] == 'F' && data[8] == 'I' && data[9] == 'F')
				return ".jpg";
			return ".jpg";
		} catch (Exception e) {
			log.error(MESSAGE_2, e);
			throw new RuntimeException(MESSAGE_2);
		}
	}

	/**
	 * 计算文件大小
	 */
	private static String getSize(long size) {
		if (size >= 1024 * 1024)
			return size / (1024 * 1024) + "M";
		return size / 1024 + "K";
	}

}
