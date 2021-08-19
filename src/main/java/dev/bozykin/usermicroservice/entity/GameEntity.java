package dev.bozykin.usermicroservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "games")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID winner;
    private UUID looser;
    @Column(name = "\"scoreGained\"")
    private double scoreGained;
    @Column(name = "\"scoreLost\"")
    private double scoreLost;
    @Column(name = "\"createdOn\"")
    private OffsetDateTime createdOn;

}
