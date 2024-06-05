package my.junw.jlab1demo.demoProperties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "work")
public class WorkProperties {

    /**
     * 特别优秀的完成工作的次数，单位：次。
     */
    private Integer goodJobTimes;

    /**
     * 完成工作的次数，单位：次。
     */
    private Integer completedJobTimes;

    private String desc;

    // ... 省略 set/get 方法
    // 快捷键 Alt + Ins
    public Integer getGoodJobTimes() {
        return goodJobTimes;
    }

    public void setGoodJobTimes(Integer goodJobTimes) {
        this.goodJobTimes = goodJobTimes;
    }

    public Integer getCompletedJobTimes() {
        return completedJobTimes;
    }

    public void setCompletedJobTimes(Integer completedJobTimes) {
        this.completedJobTimes = completedJobTimes;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
