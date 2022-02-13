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
public class CustomBoolean extends CustomProperty {
    @Column
    private boolean booleanValue;
}
