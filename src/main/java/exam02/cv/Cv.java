package exam02.cv;

import java.util.List;

public class Cv {

    private String name;
    private List<Skill> skillList;

    public Cv(String name, List<Skill> skillList) {
        this.name = name;
        this.skillList = skillList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }
}
