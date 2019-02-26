package demo.project.system.seller.domain;

public class SellerType {
    private static final long SerialVersionUID=1L;

    private int sellerTypeId;

    private String sellerTypeName;

    private int sellerTypeScore;

    public int getSellerTypeId() {
        return sellerTypeId;
    }

    public String getSellerTypeName() {
        return sellerTypeName;
    }

    public int getSellerTypeScore() {
        return sellerTypeScore;
    }

    public void setSellerTypeId(int sellerTypeId) {
        this.sellerTypeId = sellerTypeId;
    }

    public void setSellerTypeName(String sellerTypeName) {
        this.sellerTypeName = sellerTypeName;
    }

    public void setSellerTypeScore(int sellerTypeScore) {
        this.sellerTypeScore = sellerTypeScore;
    }
}
