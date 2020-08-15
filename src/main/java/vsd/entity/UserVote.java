package vsd.entity;

import javax.persistence.*;

/**
 * @author JasonW
 * @date 2020/8/15
 */
@Entity
@Table(name = "user_vote")
public class UserVote extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "user_id")
    Long userId;

    @Column(name = "vote_id")
    Long voteId;

    @Column(name = "vote_option_id")
    Long voteOptionId;
}
