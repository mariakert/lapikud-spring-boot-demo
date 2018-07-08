package ee.lapikud.springboot.members;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class Lapik {

    public enum Team {
        SOFTWARE,
        HELPDESK,
        EVENTS,
        MARKETING;

        public static Team fromString(final String enumString) {
            try {
                return Team.valueOf(enumString.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(String.format("Specified team (%s) doesn't exist", enumString));
            }
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "First name cannot be null")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @NotNull(message = "Birth date cannot be null")
    private LocalDate birthDate;

    @NotNull(message = "Joining date cannot be null")
    private LocalDate joiningDate;

    @NotEmpty(message = "Member must belong to at least one team")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Team.class, fetch = FetchType.EAGER)
    private Set<Team> teams;

}
