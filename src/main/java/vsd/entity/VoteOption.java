package vsd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author JasonW
 * @date 2020/8/15
 */
@Entity
@Table(name = "vote_option")
public class VoteOption extends AuditEntity {

    @Column(name = "vote_option_id")
    Long voteOptionId;

    @Column(name = "vote_id")
    Long voteId;

    @Column(name = "option_seq")
    Long optionSeq;

    String description;
}
