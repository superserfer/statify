package ch.linus.statify.models.customproperties;

import ch.linus.statify.models.CustomProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CustomNumber extends CustomProperty {
    @Column
    private int intValue;
}
