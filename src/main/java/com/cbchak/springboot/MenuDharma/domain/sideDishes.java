package com.cbchak.springboot.MenuDharma.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints=
@UniqueConstraint(columnNames = {"sideId", "goesWith"}))
@ToString
public class sideDishes {
    @Id
    private Integer sideId;
    @Column
    private String name;
    @Column
    private Integer goesWith;
}
