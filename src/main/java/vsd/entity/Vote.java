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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
