package vsd.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author JasonW
 * @date 2020/8/15
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditEntity {

    @Column(name = "create_time", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdTime;
}
