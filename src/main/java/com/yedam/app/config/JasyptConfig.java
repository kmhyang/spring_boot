package com.yedam.app.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration
@EnableEncryptableProperties
public class JasyptConfig {
	//실행시키면서 환경변수 어떻게 불러오는지
	@Value("{jasypt.encryptor.password}")
	private String password;
	
	@Bean("jasyptStringEncryptor") //메소드를 실행한 결과를 빈에 등록. StringEncryptor:리턴된 결과값을 빈에 등록함.
    public StringEncryptor stringEncryptor() { //문자관련 암호화
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor(); //PBES : 알고리즘
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("password");
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256"); // 기준이 되는 값 시드?를 다르게 주어짐. 그걸 기반으로 복호화 작업을 함.
        													// 시드값은 프로젝트에 올라가면 안됨(툴에 저장) 
        													// -> 환경변수 : os입장에서 해당 프로세스를 실행시키기위해 참조하는 변수가 바로 이 환경변수
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        
        encryptor.encrypt(password);
        
        return encryptor;
    }
}
