package my.junw.jlab1demo;

import my.junw.jlab1demo.demoProperties.WorkProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class JLab1DemoApplication {

    public static void main(String[] args) {
        // SpringApplication.run 会调用所有实现了 ApplicationRunner、CommandLineRunner 的类的run方法
        SpringApplication.run(JLab1DemoApplication.class, args);
    }

    @Component
    @Order(2) // 排序：加载顺序
    public class WorkPropertiesCommandLineRunner implements CommandLineRunner {
        private final Logger logger = LoggerFactory.getLogger(getClass());

        @Autowired
        private WorkProperties workProperties;

        @Override
        public void run(String... args) {
            logger.info("goodJobTimes:" + workProperties.getGoodJobTimes());
            logger.info("completedJobTimes:" + workProperties.getCompletedJobTimes());
            logger.info("desc:" + workProperties.getDesc());
        }

    }

    @Component
    @Order(1)
    public class ValueCommandLineRunner implements CommandLineRunner {
        private final Logger logger = LoggerFactory.getLogger(getClass());

        @Value("${work.good-job-times}")
        private Integer goodJobTimes;

        @Value("${work.completed-job-times}")
        private Integer completedJobTimes;

        @Value("${work.desc}")
        private String desc;
        @Override
        public void run(String... args) {
            logger.info("goodJobTimes:" + goodJobTimes);
            logger.info("completedJobTimes:" + completedJobTimes);
            logger.info("desc:" + desc);
        }
    }
}
