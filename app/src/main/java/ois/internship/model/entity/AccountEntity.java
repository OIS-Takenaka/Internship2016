package ois.internship.model.entity;

public class AccountEntity {

    public final static int FREE_MEMBER = 0;
    public final static int PAY_MEMBER = 1;

    // 顧客情報
    private int memberInfo = FREE_MEMBER;

    public void setMemberInfo(int memberInfo) {
        this.memberInfo = memberInfo;
    }
    public int getMemberInfo() {
        return memberInfo;
    }
}
