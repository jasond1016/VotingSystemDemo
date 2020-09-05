package vsd.controller.vo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author JasonW
 * @date 2020/8/16
 */
public class VoteVO {
    String type;

    String title;

    List<VoteOptionVO> voteOptions;

    LocalDateTime endTime;

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

    public List<VoteOptionVO> getVoteOptions() {
        return voteOptions;
    }

    public void setVoteOptions(List<VoteOptionVO> voteOptions) {
        this.voteOptions = voteOptions;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "VoteVO{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", voteOptions=" + voteOptions +
                ", endTime=" + endTime +
                '}';
    }
}
