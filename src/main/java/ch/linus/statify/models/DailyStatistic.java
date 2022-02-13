package ch.linus.statify.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DailyStatistic {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private UUID dailyStatsId;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User user = null;

    @ManyToMany(mappedBy = "dailyStatistics")
    private List<Activity> activities = new ArrayList<>();

    @OneToMany(mappedBy = "dailyStatistic")
    private List<CustomProperty> customProperties = new ArrayList<>();
}
