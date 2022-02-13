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
public class User {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private UUID userId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Date birthday;

    @OneToMany(mappedBy = "user")
    private List<DailyStatistic> dailyStatistics;

    @OneToMany(mappedBy = "owner")
    private List<Activity> activities;
}
