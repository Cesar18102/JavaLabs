package oleh.kyrychenko.lab2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import oleh.kyrychenko.lab2.dto.PersonDto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<ConcretePlane> fliedPlanes = new HashSet<ConcretePlane>();

    private String fullName;

    @JsonFormat(pattern = "dd.MM.YYYY")
    private Date birthDate;

    public Person() { }

    public Person(PersonDto personDto) {
        setFullName(personDto.getFullName());
        setBirthDate(personDto.getBirthDate());
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<ConcretePlane> getFliedPlanes() { return fliedPlanes; }
    public void setFliedPlanes(Set<ConcretePlane> fliedPlanes) { this.fliedPlanes = fliedPlanes; }
}
