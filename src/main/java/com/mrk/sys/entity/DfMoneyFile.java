package com.mrk.sys.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class DfMoneyFile {
    private String userNo;

    private Integer mon;

    private Integer monSn;

    private Integer groupNo;

    private Integer sn;

    private String writeSectNo;

    private String writeSn;

    private String businessPlaceCode;

    private Integer powerNo;

    private Integer transGroup;

    private String priceCode;

    private String tsFlag;

    private String elecTypeCode;

    private String tradeTypeCode;

    private String msMode;

    private String userMsType;

    private Integer writePower;

    private Integer chgPower;

    private Integer addPower;

    private Integer kbPower;

    private Integer sharePower;

    private Integer totalPower;

    private Integer totalMoney;

    private Integer numMoney;

    private Integer addMoney1;

    private Integer addMoney2;

    private Integer addMoney3;

    private Integer addMoney4;

    private Integer addMoney5;

    private Integer addMoney6;

    private Integer addMoney7;

    private Integer addMoney8;

    private String lineCode;

    private String transNo;

    @JSONField(format="yyyyMMdd")
    private String addTaxflag;
    
    @JSONField(format="yyyyMMdd")
    private Date writeDate;
    
    private Date computeDate;

    private String calculatorId;

    private String status;

    private String userType1;

    private String relaUserNo;

    private Integer partSn;

    private String haveExt;

    private String idFragment;

    private Integer shouldMoney;

    private Date createDate;

    private String creator;

    private Integer warrantNo;

    private Integer rpPower;

    private Integer rpMoney;

    private Integer addMoney9;

    private Integer addMoney10;

    private String fkFlag;

    private Integer priceMon;

    private String userType10;

    private String setAddress;

    private Integer ladderPower1;

    private Integer ladderPower2;

    private Integer ladderPower3;

    private Integer ladderMoney1;

    private Integer ladderMoney2;

    private Integer ladderMoney3;

    private String userType9;

    private String voltLevelCode;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public Integer getMon() {
        return mon;
    }

    public void setMon(Integer mon) {
        this.mon = mon;
    }

    public Integer getMonSn() {
        return monSn;
    }

    public void setMonSn(Integer monSn) {
        this.monSn = monSn;
    }

    public Integer getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(Integer groupNo) {
        this.groupNo = groupNo;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public String getWriteSectNo() {
        return writeSectNo;
    }

    public void setWriteSectNo(String writeSectNo) {
        this.writeSectNo = writeSectNo == null ? null : writeSectNo.trim();
    }

    public String getWriteSn() {
        return writeSn;
    }

    public void setWriteSn(String writeSn) {
        this.writeSn = writeSn == null ? null : writeSn.trim();
    }

    public String getBusinessPlaceCode() {
        return businessPlaceCode;
    }

    public void setBusinessPlaceCode(String businessPlaceCode) {
        this.businessPlaceCode = businessPlaceCode == null ? null : businessPlaceCode.trim();
    }

    public Integer getPowerNo() {
        return powerNo;
    }

    public void setPowerNo(Integer powerNo) {
        this.powerNo = powerNo;
    }

    public Integer getTransGroup() {
        return transGroup;
    }

    public void setTransGroup(Integer transGroup) {
        this.transGroup = transGroup;
    }

    public String getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(String priceCode) {
        this.priceCode = priceCode == null ? null : priceCode.trim();
    }

    public String getTsFlag() {
        return tsFlag;
    }

    public void setTsFlag(String tsFlag) {
        this.tsFlag = tsFlag == null ? null : tsFlag.trim();
    }

    public String getElecTypeCode() {
        return elecTypeCode;
    }

    public void setElecTypeCode(String elecTypeCode) {
        this.elecTypeCode = elecTypeCode == null ? null : elecTypeCode.trim();
    }

    public String getTradeTypeCode() {
        return tradeTypeCode;
    }

    public void setTradeTypeCode(String tradeTypeCode) {
        this.tradeTypeCode = tradeTypeCode == null ? null : tradeTypeCode.trim();
    }

    public String getMsMode() {
        return msMode;
    }

    public void setMsMode(String msMode) {
        this.msMode = msMode == null ? null : msMode.trim();
    }

    public String getUserMsType() {
        return userMsType;
    }

    public void setUserMsType(String userMsType) {
        this.userMsType = userMsType == null ? null : userMsType.trim();
    }

    public Integer getWritePower() {
        return writePower;
    }

    public void setWritePower(Integer writePower) {
        this.writePower = writePower;
    }

    public Integer getChgPower() {
        return chgPower;
    }

    public void setChgPower(Integer chgPower) {
        this.chgPower = chgPower;
    }

    public Integer getAddPower() {
        return addPower;
    }

    public void setAddPower(Integer addPower) {
        this.addPower = addPower;
    }

    public Integer getKbPower() {
        return kbPower;
    }

    public void setKbPower(Integer kbPower) {
        this.kbPower = kbPower;
    }

    public Integer getSharePower() {
        return sharePower;
    }

    public void setSharePower(Integer sharePower) {
        this.sharePower = sharePower;
    }

    public Integer getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(Integer totalPower) {
        this.totalPower = totalPower;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getNumMoney() {
        return numMoney;
    }

    public void setNumMoney(Integer numMoney) {
        this.numMoney = numMoney;
    }

    public Integer getAddMoney1() {
        return addMoney1;
    }

    public void setAddMoney1(Integer addMoney1) {
        this.addMoney1 = addMoney1;
    }

    public Integer getAddMoney2() {
        return addMoney2;
    }

    public void setAddMoney2(Integer addMoney2) {
        this.addMoney2 = addMoney2;
    }

    public Integer getAddMoney3() {
        return addMoney3;
    }

    public void setAddMoney3(Integer addMoney3) {
        this.addMoney3 = addMoney3;
    }

    public Integer getAddMoney4() {
        return addMoney4;
    }

    public void setAddMoney4(Integer addMoney4) {
        this.addMoney4 = addMoney4;
    }

    public Integer getAddMoney5() {
        return addMoney5;
    }

    public void setAddMoney5(Integer addMoney5) {
        this.addMoney5 = addMoney5;
    }

    public Integer getAddMoney6() {
        return addMoney6;
    }

    public void setAddMoney6(Integer addMoney6) {
        this.addMoney6 = addMoney6;
    }

    public Integer getAddMoney7() {
        return addMoney7;
    }

    public void setAddMoney7(Integer addMoney7) {
        this.addMoney7 = addMoney7;
    }

    public Integer getAddMoney8() {
        return addMoney8;
    }

    public void setAddMoney8(Integer addMoney8) {
        this.addMoney8 = addMoney8;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode == null ? null : lineCode.trim();
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo == null ? null : transNo.trim();
    }

    public String getAddTaxflag() {
        return addTaxflag;
    }

    public void setAddTaxflag(String addTaxflag) {
        this.addTaxflag = addTaxflag == null ? null : addTaxflag.trim();
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public Date getComputeDate() {
        return computeDate;
    }

    public void setComputeDate(Date computeDate) {
        this.computeDate = computeDate;
    }

    public String getCalculatorId() {
        return calculatorId;
    }

    public void setCalculatorId(String calculatorId) {
        this.calculatorId = calculatorId == null ? null : calculatorId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUserType1() {
        return userType1;
    }

    public void setUserType1(String userType1) {
        this.userType1 = userType1 == null ? null : userType1.trim();
    }

    public String getRelaUserNo() {
        return relaUserNo;
    }

    public void setRelaUserNo(String relaUserNo) {
        this.relaUserNo = relaUserNo == null ? null : relaUserNo.trim();
    }

    public Integer getPartSn() {
        return partSn;
    }

    public void setPartSn(Integer partSn) {
        this.partSn = partSn;
    }

    public String getHaveExt() {
        return haveExt;
    }

    public void setHaveExt(String haveExt) {
        this.haveExt = haveExt == null ? null : haveExt.trim();
    }

    public String getIdFragment() {
        return idFragment;
    }

    public void setIdFragment(String idFragment) {
        this.idFragment = idFragment == null ? null : idFragment.trim();
    }

    public Integer getShouldMoney() {
        return shouldMoney;
    }

    public void setShouldMoney(Integer shouldMoney) {
        this.shouldMoney = shouldMoney;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Integer getWarrantNo() {
        return warrantNo;
    }

    public void setWarrantNo(Integer warrantNo) {
        this.warrantNo = warrantNo;
    }

    public Integer getRpPower() {
        return rpPower;
    }

    public void setRpPower(Integer rpPower) {
        this.rpPower = rpPower;
    }

    public Integer getRpMoney() {
        return rpMoney;
    }

    public void setRpMoney(Integer rpMoney) {
        this.rpMoney = rpMoney;
    }

    public Integer getAddMoney9() {
        return addMoney9;
    }

    public void setAddMoney9(Integer addMoney9) {
        this.addMoney9 = addMoney9;
    }

    public Integer getAddMoney10() {
        return addMoney10;
    }

    public void setAddMoney10(Integer addMoney10) {
        this.addMoney10 = addMoney10;
    }

    public String getFkFlag() {
        return fkFlag;
    }

    public void setFkFlag(String fkFlag) {
        this.fkFlag = fkFlag == null ? null : fkFlag.trim();
    }

    public Integer getPriceMon() {
        return priceMon;
    }

    public void setPriceMon(Integer priceMon) {
        this.priceMon = priceMon;
    }

    public String getUserType10() {
        return userType10;
    }

    public void setUserType10(String userType10) {
        this.userType10 = userType10 == null ? null : userType10.trim();
    }

    public String getSetAddress() {
        return setAddress;
    }

    public void setSetAddress(String setAddress) {
        this.setAddress = setAddress == null ? null : setAddress.trim();
    }

    public Integer getLadderPower1() {
        return ladderPower1;
    }

    public void setLadderPower1(Integer ladderPower1) {
        this.ladderPower1 = ladderPower1;
    }

    public Integer getLadderPower2() {
        return ladderPower2;
    }

    public void setLadderPower2(Integer ladderPower2) {
        this.ladderPower2 = ladderPower2;
    }

    public Integer getLadderPower3() {
        return ladderPower3;
    }

    public void setLadderPower3(Integer ladderPower3) {
        this.ladderPower3 = ladderPower3;
    }

    public Integer getLadderMoney1() {
        return ladderMoney1;
    }

    public void setLadderMoney1(Integer ladderMoney1) {
        this.ladderMoney1 = ladderMoney1;
    }

    public Integer getLadderMoney2() {
        return ladderMoney2;
    }

    public void setLadderMoney2(Integer ladderMoney2) {
        this.ladderMoney2 = ladderMoney2;
    }

    public Integer getLadderMoney3() {
        return ladderMoney3;
    }

    public void setLadderMoney3(Integer ladderMoney3) {
        this.ladderMoney3 = ladderMoney3;
    }

    public String getUserType9() {
        return userType9;
    }

    public void setUserType9(String userType9) {
        this.userType9 = userType9 == null ? null : userType9.trim();
    }

    public String getVoltLevelCode() {
        return voltLevelCode;
    }

    public void setVoltLevelCode(String voltLevelCode) {
        this.voltLevelCode = voltLevelCode == null ? null : voltLevelCode.trim();
    }
}