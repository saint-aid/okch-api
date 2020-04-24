package com.rinomari.okch.domain.complaints;

import com.rinomari.okch.domain.common.AbstractTbl;
import com.rinomari.okch.domain.rnvtDrdg.CnstLdg;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "MG_CMPT_MNG")
@TableGenerator(name = "SEQ_CMPT", table = "CM_SEQ", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_VALUE", pkColumnValue = "CMPT_SEQ", allocationSize = 1)
public class Cmpt extends AbstractTbl {
    @Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_CMPT")
    @ApiModelProperty(value = " 일련번호")
    @Column(name = "CMPT_SN")
    private Long cmptSn;

    @ApiModelProperty(value = "처리구역")
    @Column(name = "TRT_ARA")
    private String trtAra;

//	@NotFound(action=NotFoundAction.IGNORE)
//	@ApiModelProperty(value = "행정읍/면/동명: 처리구역")
//	@ManyToOne
//	@JoinColumnsOrFormulas({ @JoinColumnOrFormula(column = @JoinColumn(referencedColumnName = "CDE", name = "TRT_ARA", insertable = false, updatable = false)),
//			@JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "GRP_CDE", value = "'HJD_CDE'")) })
//	private Code hjdCode;

//    @Convert(converter = HjdCodeConverter.class)
//    private HjdCodeStatus hjdCode;

    @ApiModelProperty(value = "민원종류")
    @Column(name = "CIV_PET_TYP")
    private String civPetTyp;

//	@NotFound(action=NotFoundAction.IGNORE)
//	@ApiModelProperty(value = "민원종류")
//	@ManyToOne
//	@JoinColumnsOrFormulas({ @JoinColumnOrFormula(column = @JoinColumn(referencedColumnName = "CDE", name = "CIV_PET_TYP", insertable = false, updatable = false)),
//			@JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "GRP_CDE", value = "'CMP_ACTY_CDE'")) })
//	private Code cmpActyCde;

    @ApiModelProperty(value = "접수유형")
    @Column(name = "RCP_TYP")
    private String rcpTyp;

    @ApiModelProperty(value = "접수일")
    @Temporal(TemporalType.DATE)
    @Column(name = "RCP_DT")
    private Date rcpDt;

    @ApiModelProperty(value = "접수자")
    @Column(name = "RCP_ID")
    private String rcpId;

    @ApiModelProperty(value = "민원내용")
    @Column(name = "CIV_CON")
    private String civCon;

    @ApiModelProperty(value = "민원인성명")
    @Column(name = "CIV_PET_NAM")
    private String civPetNam;

    @ApiModelProperty(value = "처리구역담당자")
    @Column(name = "TRT_MNG_ID")
    private String trtMngId;

    @ApiModelProperty(value = "민원인연락처")
    @Column(name = "CIV_PET_TEL")
    private String civPetTel;

    @ApiModelProperty(value = "비고")
    @Column(name = "REMARK")
    private String remark;

    @ApiModelProperty(value = "민원지 상세주소")
    @Column(name = "CIV_LOC_ADDR")
    private String civLocAddr;

    @ApiModelProperty(value = "민원지산일반구분")
    @Column(name = "CIV_LOC_DIV")
    private String civLocDiv;

    @ApiModelProperty(value = "민원지본번")
    @Column(name = "CIV_LOC_MAIN")
    private String civLocMain;

    @ApiModelProperty(value = "민원지부번")
    @Column(name = "CIV_LOC_SUB")
    private String civLocSub;

    @ApiModelProperty(value = "민원지X좌표")
    @Column(name = "CIV_LOC_X")
    private String civLocX;

    @ApiModelProperty(value = "민원지Y좌표")
    @Column(name = "CIV_LOC_Y")
    private String civLocY;

    @ApiModelProperty(value = "민원지행정읍면동")
    @Column(name = "CIV_LOC_HJD")
    private String civLocHjd;

    @ApiModelProperty(value = "민원지도로명코드")
    @Column(name = "CIV_LOC_ROAD")
    private String civLocRoad;

    @ApiModelProperty(value = "민원지시도")
    @Column(name = "CIV_LOC_SIDO")
    private String civLocSido;

    @ApiModelProperty(value = "민원지시군구")
    @Column(name = "CIV_LOC_GUGUN")
    private String civLocGugun;

    @ApiModelProperty(value = "처리자성명")
    @Column(name = "PRC_NAM")
    private String prcNam;

    @ApiModelProperty(value = "처리내용")
    @Column(name = "PRC_NPRC_CON")
    private String prcNprcCon;

    @ApiModelProperty(value = "처리일자")
    @Temporal(TemporalType.DATE)
    @Column(name = "PRC_DT")
    private Date prcDt;

    @ApiModelProperty(value = "공사번호")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CNT_SN")
    private CnstLdg cnstLdg;

    @ApiModelProperty(value = "시설코드")
    @Column(name = "FTR_CDE")
    private String ftrCde;

    @ApiModelProperty(value = "시설구분코드")
    @Column(name = "FTR_IDS")
    private Long ftrIds;

    @ApiModelProperty(value = "사용여부")
    @Column(name = "USE_YN")
    private String useYn;

    @OneToMany(mappedBy="cmpt", cascade=CascadeType.ALL)
    private List<CmptFtr> cmptFtrs =  new ArrayList<CmptFtr>();

    public void addCmptFtrs(CmptFtr cmptFtr) {
        cmptFtrs.add(cmptFtr);
        cmptFtr.setCmpt(this);
    }

//	public void setCmptFtrs(List<CmptFtr> cmptFtrs) {
//		this.cmptFtrs = cmptFtrs;
//
//		if(cmptFtrs != null)
//			for(CmptFtr cmptFtr : cmptFtrs)
//				cmptFtr.setCmpt(this);
//	}

}
