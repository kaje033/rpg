package solarion.solarion.Db;

public class user {
    private String u_uuid;
    private String u_name;
    private String title;
    private String title_color;
    private int agility;
    private int strength;
    private int health;
    private int skill;
    private int Intellect;

    public String getU_uuid() {
        return u_uuid;
    }
    public void setU_uuid(String u_uuid) {
        this.u_uuid = u_uuid;
    }

    public String getU_name() {
        return u_name;
    }
    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String get_title() {
        return title;
    }
    public void set_title(String title) {
        this.title = title;
    }

    public String get_title_color() {
        return title_color;
    }
    public void set_title_color(String title_color) {
        this.title_color = title_color;
    }

    public int get_agility() {return agility;}
    public void set_agility(int agility) {this.agility = agility;}

    public int get_strength() {return strength;}
    public void set_strength(int strength) {this.strength = strength;}

    public int get_health() {return health;}
    public void set_health(int health) {this.health = health;}

    public int get_skill() {return skill;}
    public void set_skill(int skill) {this.skill = skill;}

    public int get_Intellect() {return Intellect;}
    public void set_Intellect(int Intellect) {this.Intellect = Intellect;}

}
