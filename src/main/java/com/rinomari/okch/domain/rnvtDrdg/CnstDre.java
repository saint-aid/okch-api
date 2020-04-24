package com.rinomari.okch.domain.rnvtDrdg;

import com.rinomari.okch.domain.common.AbstractTbl;
import com.rinomari.okch.domain.common.Code;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "MG_CNST_DRE") // 준설
@TableGenerator(name = "SEQ_DRE", table = "CM_SEQ", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_VALUE", pkColumnValue = "DRE_SEQ", allocationSize = 1)
public class CnstDre extends AbstractTbl {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_DRE")
    @ApiModelProperty(value = "준설작업 일련번호")
    @Column(name = "DRE_SN")
    private Long dreSn;

	/*@ApiModelProperty(value = "공사대장 일련번호")
	@Column(name = "CNT_SN")
	private String cntSn;*/

    //@ManyToOne(cascade = CascadeType.ALL)
    //(fetch=FetchType.EAGER)//연관관계 주인
    //@JsonBackReference // 자식(순환참조 해결),
    //@JsonManagedReference
    @ManyToOne(cascade = CascadeType.REMOVE)
    //@JsonIgnoreProperties("cnstDre") //null 속성 무시해서 배열형태 만듦
    @JoinColumn(name="CNT_SN" )
    private CnstLdg cnstLdg;

    @Temporal(TemporalType.DATE)
    @ApiModelProperty(value = "준설계획일")
    @Column(name = "DRE_PCT_DT")
    private Date drePctDt;

    @Temporal(TemporalType.DATE)
    @ApiModelProperty(value = "준설시행일")
    @Column(name = "DRE_DT")
    private Date dreDt;

    @ApiModelProperty(value = "준설방법")
    @Column(name = "DRE_MTHD")
    private String dreMthd;

    @NotFound(action= NotFoundAction.IGNORE)
    @ApiModelProperty(value = "준설방법")
    @ManyToOne
    @JoinColumnsOrFormulas({ @JoinColumnOrFormula(column = @JoinColumn(referencedColumnName = "CDE", name = "DRE_MTHD", insertable = false, updatable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "GRP_CDE", value = "'DRDG_MTHD_CDE'")) })
    private Code dreMthdCode;

    @ApiModelProperty(value = "준설구분")
    @Column(name = "DRE_DIV")
    private String dreDiv;

    @NotFound(action=NotFoundAction.IGNORE)
    @ApiModelProperty(value = "준설구분")
    @ManyToOne
    @JoinColumnsOrFormulas({ @JoinColumnOrFormula(column = @JoinColumn(referencedColumnName = "CDE", name = "DRE_DIV", insertable = false, updatable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "GRP_CDE", value = "'DRE_DIV_CDE'")) })
    private Code dreDivCode;

    @ApiModelProperty(value = "준설토사처리")
    @Column(name = "DRE_SOIL_PRC")
    private String dreSoilPrc;

    @NotFound(action=NotFoundAction.IGNORE)
    @ApiModelProperty(value = "준설방법")
    @ManyToOne
    @JoinColumnsOrFormulas({ @JoinColumnOrFormula(column = @JoinColumn(referencedColumnName = "CDE", name = "DRE_SOIL_PRC", insertable = false, updatable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "GRP_CDE", value = "'DRDG_SPMD_CDE'")) })
    private Code dreSoilPrcCode;

    @ApiModelProperty(value = "퇴적깊이")
    @Column(name = "SED_DEP")
    private String sedDep;

    @ApiModelProperty(value = "준설량비용")
    @Column(name = "DRE_COST")
    private String dreCost;

    @ApiModelProperty(value = "준설작업량")
    @Column(name = "DRE_WRK_AMT")
    private String dreWrkAmt;

    @ApiModelProperty(value = "비고")
    @Column(name = "REMARK")
    private String remark;

    /*public void setCnstLdgs(CnstLdg cnstLdgs) {
		if(this.cnstLdgs != null)
	        this.cnstLdgs.getCnstDre().remove(this);

		this.cnstLdgs = cnstLdgs;

		//무한루프에 빠지지 않도록 체크
		if(!cnstLdgs.getCnstDre().contains(this)) {
			cnstLdgs.getCnstDre().add(this);
		}
	}*/
}
