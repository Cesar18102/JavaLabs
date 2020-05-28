package oleh.kyrychenko.lab2.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ConcretePlane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Person> crew = new HashSet<Person>();

    private Integer buildYear;

    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }

    public Plane getPlane() {
        return plane;
    }
    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Set<Person> getCrew() { return crew; }
    public void setCrew(Set<Person> crew) { this.crew = crew; }

    public Integer getBuildYear() { return buildYear; }
    public void setBuildYear(Integer buildYear) { this.buildYear = buildYear; }
}
