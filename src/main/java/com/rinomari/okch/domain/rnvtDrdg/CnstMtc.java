package com.rinomari.okch.domain.rnvtDrdg;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

@Getter @Setter
@Entity
@Table(name = "MG_CNST_MTC") // 보수개량신설 포함
@TableGenerator(name = "SEQ_MTC", table = "CM_SEQ", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_VALUE", pkColumnValue = "MTC_SEQ", allocationSize = 1)
public class CnstMtc extends AbstractTbl {

    @Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_MTC")
    @ApiModelProperty(value = "보수작업 일련번호")
    @Column(name = "MTC_SN")
    private Long mtcSn;

	/*@Column(name= "CNT_SN")
	@ApiModelProperty(value = "공사대장 일련번호")
	private String cntSn;*/

    //대장테이블과 N:1
    //(fetch=FetchType.EAGER)//연관관계 주인
    //@JsonBackReference // 자식(순환참조 해결),

    //@JsonManagedReference //부모
    //@ManyToOne(cascade = CascadeType.REMOVE) // 부모와 자식 테이블 같이 삭제만 됨
    //@ManyToOne(cascade = CascadeType.ALL )//영속성 전이: 부모테이블을 자식테이블에 영속성 전이
    @ManyToOne(cascade=CascadeType.REMOVE)
    @JsonIgnoreProperties("cnstMtc") //null 속성 무시해서 배열형태 만듦
    @JoinColumn(name="CNT_SN")
    private CnstLdg cnstLdg;

    @ApiModelProperty(value = "복구방법")
    @Column(name = "RCV_MTHD")
    private String rcvMthd;

    @ApiModelProperty(value = "유지보수사유")
    @Column(name = "MTC_RSN")
    private String mtcRsn;

    @ApiModelProperty(value = "작업방법")
    @Column(name = "WRK_MTHD")
    private String wrkMthd;

    @NotFound(action= NotFoundAction.IGNORE)
    @ApiModelProperty(value = "작업방법")
    @ManyToOne
    @JoinColumnsOrFormulas({ @JoinColumnOrFormula(column = @JoinColumn(referencedColumnName = "CDE", name = "WRK_MTHD", insertable = false, updatable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "GRP_CDE", value = "'WRK_MTHD'")) })
    private Code wrkMthdCode;

    @ApiModelProperty(value = "유지보수방법")
    @Column(name = "MTC_MTHD")
    private String mtcMthd;

    @ApiModelProperty(value = "관련민원")
    @Column(name = "REL_CIV")
    private String relCiv;

    @ApiModelProperty(value = "포장종류")
    @Column(name = "PCK_KIND")
    private String pckKind;

    @NotFound(action=NotFoundAction.IGNORE)
    @ApiModelProperty(value = "포장종류")
    @ManyToOne
    @JoinColumnsOrFormulas({ @JoinColumnOrFormula(column = @JoinColumn(referencedColumnName = "CDE", name = "PCK_KIND", insertable = false, updatable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "GRP_CDE", value = "'PCK_KIND'")) })
    private Code pckKindCode;

    @ApiModelProperty(value = "비고")
    @Column(name = "REMARK")
    private String remark;

    @ApiModelProperty(value = "신설작업포함")
    @Column(name = "FND_CHK")
    private String fndChk;

    @ApiModelProperty(value = "보수작업포함")
    @Column(name = "MTC_CHK")
    private String mtcChk;

    @ApiModelProperty(value = "개량작업포함")
    @Column(name = "IMP_CHK")
    private String impChk;

	/*public void setMember(Member member) {
	    if(this.member != null)
	        this.member.getOrders().remove(this);
	    this.member = member;
	    member.getOrders().add(this);
	}*/

	/*public void setCnstLdg(CnstLdg cnstLdg) {
		if(this.cnstLdg != null)
		{
	        this.cnstLdg.getCnstMtcs().remove(this);
	        this.cnstLdg.getCnstDres().remove(this);
	        this.cnstLdg.getCnstFtrs().remove(this);
		}
		this.cnstLdg = cnstLdg;
		//cnstLdgs.getCnstMtc().add(this);

		//무한루프에 빠지지 않도록 체크
		if(!cnstLdg.getCnstMtcs().contains(this)) {
			cnstLdg.getCnstMtcs().add(this);
		}
	}*/
}
