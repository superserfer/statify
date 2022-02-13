package ch.linus.statify.models.customproperties;

import ch.linus.statify.models.CustomProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomString extends CustomProperty {
    @Column
    private String stringValue;
}
