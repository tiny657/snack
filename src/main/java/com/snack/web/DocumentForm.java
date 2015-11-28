package com.snack.web;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class DocumentForm {
    @NotNull
    @Size(min = 1, max = 255)
    private String content;

    private Integer point;
    private Integer love;
    private Integer comment;
    private Integer sharing;

    @NotNull
    @Size(min = 1, max = 255)
    private String memberId;

    private Date regDate;
}
