package vsd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author JasonW
 * @date 2020/8/15
 */
@Entity
@Table(name = "vote_option")
public class VoteOption extends AuditEntity {

    @Id
    @Column(name = "vote_option_id")
    Long voteOptionId;

    @Column(name = "vote_id")
    Long voteId;

    @Column(name = "option_seq")
    Long optionSeq;

    String description;

    public Long getVoteOptionId() {
        return voteOptionId;
    }

    public void setVoteOptionId(Long voteOptionId) {
        this.voteOptionId = voteOptionId;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public Long getOptionSeq() {
        return optionSeq;
    }

    public void setOptionSeq(Long optionSeq) {
        this.optionSeq = optionSeq;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
