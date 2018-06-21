package example.hibernate.application.command;

public class CreateHeroCommand {
    private String name;
    private Integer life;
    private Integer power;

    public CreateHeroCommand(String name, Integer life, Integer power) {
        this.name = name;
        this.life = life;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public Integer getLife() {
        return life;
    }

    public Integer getPower() {
        return power;
    }
}
