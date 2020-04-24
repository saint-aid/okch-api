package com.rinomari.okch.domain.complaints;

import com.rinomari.okch.domain.common.AbstractTbl;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "MG_CMPT_FTR") // 공사시설
@TableGenerator(name = "SEQ_CMPT_FTR", table = "CM_SEQ", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_VALUE", pkColumnValue = "CMPT_FTR_SEQ", allocationSize = 1)
public class CmptFtr extends AbstractTbl {

    @Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_CMPT_FTR")
    @ApiModelProperty(value = "민원시설 일련번호")
    @Column(name = "FTR_SN")
    private Long ftrSn;

    @ApiModelProperty(value = "지형지물부호")
    @Column(name = "FTR_CDE")
    private String ftrCde;

//	@NotFound(action=NotFoundAction.IGNORE)
//	@ApiModelProperty(value = "시설구분(지형지물부호명)")
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumnsOrFormulas({ @JoinColumnOrFormula(column = @JoinColumn(referencedColumnName = "CDE", name = "FTR_CDE", insertable = false, updatable = false)),
//			@JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "GRP_CDE", value = "'FTR_CDE'")) })
//	private Code ftrCode;

    @ApiModelProperty(value = "시설물 관리번호")
    @Column(name = "FTR_IDS")
    private Long ftrIds;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CMPT_SN")
    private Cmpt cmpt ;
}
