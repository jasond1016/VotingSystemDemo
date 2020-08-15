package vsd.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author JasonW
 * @date 2020/8/15
 */
@Entity
public class Vote extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String type;

    String title;

    Long creator;

    @Column(name = "end_time")
    LocalDateTime endTime;
}
