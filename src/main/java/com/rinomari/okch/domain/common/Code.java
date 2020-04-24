package com.rinomari.okch.domain.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Entity
@Table(name="CM_CDE")
public class Code extends AbstractTbl{

    @Id
    @ApiModelProperty(value = "그룹코드")
    @Column(name = "GRP_CDE")
    private String grpCde;

    @Id
    @ApiModelProperty(value = "코드")
    @Column(name = "CDE")
    private String cde;

    @ApiModelProperty(value = "코드명")
    @Column(name = "CDE_NAM")
    private String cdeNam;

    @ApiModelProperty(value = "사용여부")
    @Column(name = "USE_YN")
    private String useYn;

    @ApiModelProperty(value = "예약어1")
    @Column(name = "RSRV01")
    private String rsrv01;

    @ApiModelProperty(value = "예약어2")
    @Column(name = "RSRV02")
    private String rsrv02;

    @ApiModelProperty(value = "예약어3")
    @Column(name = "RSRV03")
    private String rsrv03;

    @ApiModelProperty(value = "비고")
    @Column(name = "REMARK")
    private String remark;

    @ApiModelProperty(value = "순서")
    @Column(name = "ORDR")
    private Integer ordr;

    @ApiModelProperty(value = "코드종류")
    @Column(name = "CDE_KND")
    private String cdeKnd;

}
