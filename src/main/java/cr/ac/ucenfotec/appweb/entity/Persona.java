package cr.ac.ucenfotec.appweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String first_LN;
    private String sec_LN;
    private Date birthday;
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_LN() {
        return first_LN;
    }

    public void setFirst_LN(String first_LN) {
        this.first_LN = first_LN;
    }

    public String getSec_LN() {
        return sec_LN;
    }

    public void setSec_LN(String sec_LN) {
        this.sec_LN = sec_LN;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
