package com.rinomari.okch.domain.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractTbl {

    @ApiModelProperty(value = "생성자")
    @Column(name = "REG_ID")
    @CreatedBy
    protected String regId;

    @ApiModelProperty(value = "생성일")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @CreatedDate //@CreationTimestamp
    @Column(name = "REG_DT")
    protected LocalDateTime regDt;

    @ApiModelProperty(value = "수정자")
    @Column(name = "MOD_ID", nullable=true)
    @LastModifiedBy
    protected String modId;

    @ApiModelProperty(value = "수정일")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @LastModifiedDate //@UpdateTimestamp
    @Column(name = "MOD_DT", nullable=true)
    protected LocalDateTime  modDt;

}
