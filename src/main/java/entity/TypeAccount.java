package entity;

public class TypeAccount {
    private int typeAccountId;
    private String typeAccountName;

    public TypeAccount() {
    }

    public TypeAccount(int typeAccountId, String typeAccountName) {
        this.typeAccountId = typeAccountId;
        this.typeAccountName = typeAccountName;
    }

    public int getTypeAccountId() {
        return typeAccountId;
    }

    public void setTypeAccountId(int typeAccountId) {
        this.typeAccountId = typeAccountId;
    }

    public String getTypeAccountName() {
        return typeAccountName;
    }

    public void setTypeAccountName(String typeAccountName) {
        this.typeAccountName = typeAccountName;
    }
}
