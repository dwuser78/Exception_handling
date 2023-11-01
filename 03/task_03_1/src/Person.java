import java.util.Date;

public class Person {
    private String first_name;
    private String last_name;
    private String middle_name;
    private Date birth_date;
    private int phone;
    private String gender;

    public Person(String last_name, String first_name, String middle_name,
                  Date birth_date, int phone, String gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.birth_date = birth_date;
        this.phone = phone;
        this.gender = gender;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public int getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }
}
