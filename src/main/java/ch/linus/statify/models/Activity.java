package ch.linus.statify.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private UUID activityId;

    @ManyToOne
    @JoinColumn
    private User owner;

    @ManyToMany
    @JoinTable
    private List<DailyStatistic> dailyStatistics;

    @Column
    private String description;
}
