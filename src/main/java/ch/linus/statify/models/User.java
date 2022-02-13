package ch.linus.statify.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
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

    @OneToMany(mappedBy = "user")
    private List<CustomProperty> defaultProperties;
}
