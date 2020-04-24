package com.rinomari.okch.domain.rnvtDrdg;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rinomari.okch.domain.common.AbstractTbl;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "MG_CNST_LDG") //공사대장
@TableGenerator(name = "SEQ_LDG", table = "CM_SEQ", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_VALUE", pkColumnValue = "LDG_SEQ", allocationSize = 1)
public class CnstLdg extends AbstractTbl {
    @Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_LDG")
    @ApiModelProperty(value = "공사대장 일련번호")
    @Column(name = "CNT_SN")
    private Long cntSn;

    @ApiModelProperty(value = "공사번호")
    @Column(name = "CNT_IDN")
    private String cntIdn;

    @ApiModelProperty(value = "공사명")
    @Column(name = "CNT_NAM")
    private String cntNam;

    @ApiModelProperty(value = "총사업비")
    @Column(name = "CNT_TOT")
    private String cntTot;

    @ApiModelProperty(value = "공사주체")
    @Column(name = "CNT_OWNER")
    private String cntOwner;

    @ApiModelProperty(value = "도급자")
    @Column(name = "CNT_CNTRT")
    private String cntCntrt;

    @Temporal(TemporalType.DATE)
    @ApiModelProperty(value = "공사기간(시작)")
    @Column(name = "CNT_SDT")
    private Date cntSdt;

    @Temporal(TemporalType.DATE)
    @ApiModelProperty(value = "공사기간(종료)")
    @Column(name = "CNT_EDT")
    private Date cntEdt;

    @ApiModelProperty(value = "특이사항")
    @Column(name = "SPC_FACT")
    private String spcFact;

    @ApiModelProperty(value = "공사시점")
    @Column(name = "CNT_SPNT")
    private String cntSpnt;

    @ApiModelProperty(value = "공사종점")
    @Column(name = "CNT_EPNT")
    private String cntEpnt;

    @ApiModelProperty(value = "공사 총연장")
    @Column(name = "CNT_EXTSN")
    private String cntExtsn;

	/*@ApiModelProperty(value = "공사규모")
	@Column(name = "CNT_SCALE")
	private String cntScale;*/

    @ApiModelProperty(value = "처리구역")
    @Column(name = "DSP_IDN")
    private String dspIdn;

    //@JsonManagedReference
    @JsonIgnoreProperties("cnstLdg")
    @OneToMany(mappedBy="cnstLdg", cascade = CascadeType.ALL)
    private List<CnstFtr> cnstFtrs = new ArrayList<CnstFtr>();

    //@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "CNT_SN")
    //@JsonManagedReference // 부모(순환참조 해결),
    //@JsonBackReference
    @JsonIgnoreProperties("cnstLdg")
    @OneToMany(mappedBy="cnstLdg", cascade=CascadeType.ALL)
    private List<CnstMtc> cnstMtcs = new ArrayList<CnstMtc>();

    //@JsonManagedReference // 부모(순환참조 해결),
    //@JsonBackReference
    @JsonIgnoreProperties("cnstLdg")
    @OneToMany(mappedBy="cnstLdg", cascade=CascadeType.ALL)
    private List<CnstDre> cnstDres = new ArrayList<CnstDre>();

    //관련시설
    public void setCnstFtrs(List<CnstFtr> cnstFtrs) {
        this.cnstFtrs = cnstFtrs;

        if(cnstFtrs != null)
            for(CnstFtr cnstFtr : cnstFtrs)
                cnstFtr.setCnstLdg(this);
    }
    //개보수
    public void setCnstMtcs(List<CnstMtc> cnstMtcs) {
        this.cnstMtcs = cnstMtcs;

        if(cnstMtcs != null)
            for(CnstMtc cnstMtc : cnstMtcs)
                cnstMtc.setCnstLdg(this);
    }

    //준설
    public void setCnstDres(List<CnstDre> cnstDres) {
        this.cnstDres = cnstDres;

        if(cnstDres != null)
            for(CnstDre cnstDre : cnstDres)
                cnstDre.setCnstLdg(this);
    }
}
