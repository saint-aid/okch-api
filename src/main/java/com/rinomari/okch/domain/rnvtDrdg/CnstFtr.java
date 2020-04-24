package com.rinomari.okch.domain.rnvtDrdg;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rinomari.okch.domain.common.AbstractTbl;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "MG_CNST_FTR") // 공사시설
@TableGenerator(name = "SEQ_FTR", table = "CM_SEQ", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_VALUE", pkColumnValue = "CNT_FTR_SEQ", allocationSize = 1)
public class CnstFtr extends AbstractTbl {

    @Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_FTR")
    @ApiModelProperty(value = "관련시설 일련번호")
    @Column(name = "FTR_SN")
    private Long ftrSn;

	/*@ApiModelProperty(value = "공사대장 일련번호")
	@Column(name = "CNT_SN")
	private String cntSn;*/

    @ApiModelProperty(value = "지형지물부호")
    @Column(name = "FTR_CDE")
    private String ftrCde;

    @ApiModelProperty(value = "시설물 관리번호")
    @Column(name = "FTR_IDS")
    private String ftrIds;

    //@JsonBackReference
    @JsonIgnoreProperties("cnstFtr") //null 속성 무시해서 배열형태 만듦
    @ManyToOne
    @JoinColumn(name="CNT_SN" )
    private CnstLdg cnstLdg;

}
