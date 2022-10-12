package study.design_pattern.behavior.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum GradeGroup {
    ONLYEMPLOYEE("비회원 신입 직원", Arrays.asList(Grade.NEWEMPLOYEE)),
    ONLYOLDEMPLOYEE("비회원 직원", Arrays.asList(Grade.EMPLOYEE)),
    ONLYVIP("VVIP", Arrays.asList(Grade.VIP)),
    ONLYNORMAL("일반회원", Arrays.asList(Grade.NORMAL)),
    VIPNEWEMPLOYEE("VIP 신입 직원", Arrays.asList(Grade.NEWEMPLOYEE, Grade.VIP)),
    VIPOLDEMPLOYEE("VIP 직원", Arrays.asList(Grade.EMPLOYEE, Grade.VIP)),
    NORMALEMPLOYEE("일반회원 신입 직원", Arrays.asList(Grade.EMPLOYEE, Grade.NORMAL)),
    NORMALOLDEMPLOYEE("일반회원 직원", Arrays.asList(Grade.EMPLOYEE, Grade.NORMAL)),
    NEWMEMBER("신규회원", new ArrayList<>());

    private String gradeName;
    private List<Grade> gradeList;

    GradeGroup(String gradeName, List<Grade> gradeList) {
        this.gradeName = gradeName;
        this.gradeList = gradeList;
    }
}
