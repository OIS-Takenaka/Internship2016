package ois.internship.model.entity;

import java.io.Serializable;

public class AccountEntity extends BaseEntity implements Serializable {

    public final static int FREE_MEMBER = 0;
    public final static int PAY_MEMBER = 1;

    // 顧客情報
    private int memberInfo = FREE_MEMBER;
    private int point = 1000;

    public void setMemberInfo(int memberInfo) {
        this.memberInfo = memberInfo;
    }
    public int getMemberInfo() {
        return memberInfo;
    }
    public int getPoint() {
        return memberInfo;
    }
}
