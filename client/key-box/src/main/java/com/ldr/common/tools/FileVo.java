package com.ldr.common.tools;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "文件对象")
public class FileVo {
	@ApiModelProperty("展示路径")
	private String fileUrl;// 展示路径
	@ApiModelProperty("储存路径")
	private String filePath;// 储存路径
	@ApiModelProperty("原始文件名")
	private String fileName;// 原始文件名
	@ApiModelProperty("文件大小")
	private String fileSize;// 文件大小
}
