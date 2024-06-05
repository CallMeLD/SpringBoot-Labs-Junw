package my.junw.jlab1democonfigname;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
/**
 * 读取指定配置文件 @PropertySource / 多个配置文件  @PropertySources
 * 可以与下列两个注解搭配使用
 *      - @ConfigurationProperties(prefix = "work")
 *      - @Value("${work.good-job-times}")
 */
@SpringBootApplication
@PropertySources({ @PropertySource("classpath:application.yml"),
        @PropertySource("classpath:rpc.yml") })
public class JLab1DemoConfignameApplication {

    public static void main(String[] args) {
        // 启动 Spring Boot 应用
        SpringApplication.run(JLab1DemoConfignameApplication.class, args);
    }

    @Component
    public class ValueCommandLineRunner implements CommandLineRunner {

        private final Logger logger = LoggerFactory.getLogger(getClass());

        @Value("${application-test}")
        private String applicationTest;

        @Value("${rpc-test}")
        private String rpcTest;

        @Override
        public void run(String... args) {
            logger.info("applicationTest:" + applicationTest);
            logger.info("rpcTest:" + rpcTest);
        }

    }
}
