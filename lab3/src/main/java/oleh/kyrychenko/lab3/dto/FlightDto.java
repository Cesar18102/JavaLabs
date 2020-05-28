package oleh.kyrychenko.lab3.dto;

import java.util.Set;

public class FlightDto {
    private Integer concretePlaneId;
    private Set<Integer> crew;

    public Integer getConcretePlaneId() {
        return concretePlaneId;
    }
    public void setConcretePlaneId(Integer concretePlaneId) {
        this.concretePlaneId = concretePlaneId;
    }

    public Set<Integer> getCrew() {
        return crew;
    }
    public void setCrew(Set<Integer> crew) {
        this.crew = crew;
    }
}
