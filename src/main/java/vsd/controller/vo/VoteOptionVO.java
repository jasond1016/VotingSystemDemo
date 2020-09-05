package vsd.controller.vo;

/**
 * @author JasonW
 * @date 2020/8/16
 */
public class VoteOptionVO {
    Long optionSeq;

    String description;

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

    @Override
    public String toString() {
        return "VoteOptionVO{" +
                "optionSeq=" + optionSeq +
                ", description='" + description + '\'' +
                '}';
    }
}
