package ch.linus.statify.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyStatistic {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private UUID dailyStatsId;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToMany(mappedBy = "dailyStatistics")
    private List<Activity> activities;

}
