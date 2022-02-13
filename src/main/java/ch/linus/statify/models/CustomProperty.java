package ch.linus.statify.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class CustomProperty {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private UUID customPropertyId;

    @Column
    private String name;

    /**
     * Should be null when used in daily statistics
     * Use this only to define default custom properties inside the user
     */
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private DailyStatistic dailyStatistic;
}
