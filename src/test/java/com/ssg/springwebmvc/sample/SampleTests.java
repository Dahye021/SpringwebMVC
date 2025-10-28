package com.ssg.springwebmvc.sample;

import com.ssg.springwebmvc.service.SampleService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

// JUnit 버전에서 Spring-test를 사용하기 위한 설정 어노테이션
@ExtendWith(SpringExtension.class)
// 스프링의 설정 정보를 로딩하기 위한 스프링의 루트 컨텍스트 파일을 지정
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
class SampleTests {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SampleService sampleService;
    // DB 커넥션 확인
    @Test
    public void TestDataSource() throws Exception {
        Connection connection = dataSource.getConnection();
        log.info(connection);
        Assertions.assertNotNull(connection);
        connection.close();
    }

    // 서비스 객체 구동 확인
    @Test
    public void testSampleService() {
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }
}
