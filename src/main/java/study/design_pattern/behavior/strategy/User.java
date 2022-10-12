package study.design_pattern.behavior.strategy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class User {
    private String name;
    private List<Grade> gradeList = new ArrayList<>();


    protected User(){}

    public User(String name, List<Grade> gradeList) {
        this.name = name;
        this.gradeList = gradeList;
    }

    public User(String name) {
        this.name = name;
    }

    public Boolean isEmployee() {
        return gradeList.stream()
                .anyMatch(grade -> grade.equals(Grade.EMPLOYEE)
                        || grade.equals(Grade.NEWEMPLOYEE));
    }

    public Boolean isMember() {
        return gradeList.stream()
                .anyMatch(grade -> grade.equals(Grade.NORMAL)
                        || grade.equals(Grade.VIP)
                        || grade.equals(Grade.NEW));
    }
}
