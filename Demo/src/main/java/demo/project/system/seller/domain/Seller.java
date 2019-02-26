package demo.project.system.seller.domain;

import demo.framework.web.domain.BaseDomain;

public class Seller extends BaseDomain {
    private static final Long SerialVersionUID=1L;
    private long sellerId;
    private String loginName;
    private String sellerName;
    private String sellerAddr;
    private String sellerDesc;
    private String sellerStatus;
    private String sellerConnect;
    private String sellerTypeName;
    private int sellerScore;
    private String sellerFlag;

    public void setSellerTypeName(String sellerTypeName) {
        this.sellerTypeName = sellerTypeName;
    }

    public String getSellerTypeName() {
        return sellerTypeName;
    }
    public long getSellerId() {
        return sellerId;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getSellerAddr() {
        return sellerAddr;
    }

    public String getSellerDesc() {
        return sellerDesc;
    }

    public String getSellerStatus() {
        return sellerStatus;
    }

    public String getSellerConnect() {
        return sellerConnect;
    }

    public int getSellerScore() {
        return sellerScore;
    }

    public String getSellerFlag(){return sellerFlag;}

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setSellerAddr(String sellerAddr) {
        this.sellerAddr = sellerAddr;
    }

    public void setSellerDesc(String sellerDesc) {
        this.sellerDesc = sellerDesc;
    }

    public void setSellerStatus(String sellerStatus) {
        this.sellerStatus = sellerStatus;
    }

    public void setSellerConnect(String sellerConnect) {
        this.sellerConnect = sellerConnect;
    }

    public void setSellerScore(int sellerScore) {
        this.sellerScore = sellerScore;
    }

    public void setSellerFlag(String sellerFlag){this.sellerFlag=sellerFlag;}

}
