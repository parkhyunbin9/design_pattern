package study.design_pattern.behavior.strategy;

import java.util.List;

public enum Grade {
    NEWEMPLOYEE("신입사원"),
    EMPLOYEE("사원"),
    VIP("VIP"),
    NORMAL("일반회원"),
    NEW("신규회원");

    private String grade;

    Grade(String grade) {
                this.grade = grade;
    }


}
