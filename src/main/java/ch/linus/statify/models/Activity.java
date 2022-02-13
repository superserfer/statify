package ch.linus.statify.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Activity {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private UUID activityId;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User owner = null;

    @ManyToMany
    @JoinTable
    @JsonIgnore
    private List<DailyStatistic> dailyStatistics = new ArrayList<>();

    @Column
    private String description;
}
