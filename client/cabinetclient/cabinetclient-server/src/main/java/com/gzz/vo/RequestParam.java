package com.gzz.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RequestParam {
    //private User user;
    private List<String> keyIds;
    private String boxId;
}
