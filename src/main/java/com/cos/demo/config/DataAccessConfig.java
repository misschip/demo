package com.cos.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.cos.demo.repository")
public class DataAccessConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(
        		// 이 파일에서 설정이 필요한 부분은 아래 classpath 부분임. 그 외는 그냥 레퍼런스 문서 복붙!
        		// src/main/resources/mapper/member.xml 파일이 있음
        		new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

/*

* @Configuration 어노테이션
   : 자바코드를 통환 환경설정에 쓰임. @Configuration은 클래스에 붙는 어노테이션이고, 컨터이너에게 해당 클래스가 Bean 구성 클래스임을 알려준다.
     Bean 구성 클래스란 @Bean이 붙은 메서드가 하나 이상 존재함을 의미한다. 참고로, @Bean은 @Component와 달리 애플리케이션 개발자가 직접
           제어가 불가능한 외부 라이브러리 등을 Bean으로 만드는 경우에 사용된다.
           

* MyBatis-Spring에서 mapper를 자동으로 검색하고 등록하는 방법
	1. XML 파일에 <mybatis:scan/> 사용
		ex)  <mybatis:scan base-package="com.cos.demo.repository" />
	2. @MapperScan 어노테이션 : @Configuration 과 함께 사용
		ex) 위 코드 참조
 


*/