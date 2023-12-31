package com.yedam.app;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ex230613ApplicationTests {

	@Autowired
	StringEncryptor jasyptStringEncryptor;
	//메소드 리턴 / 변수명으로 등록.
	//Jasy
	
	@Test
	void propertiesEncrypt() {
		//application.properties #datasource
		String[] strArray={"oracle.jdbc.OracleDriver",
							"jdbc:oracle:thin:@127.0.0.1:1521/xe",
							"hr",
							"hr"};
		for(String str:strArray) {
			String enyStr = jasyptStringEncryptor.encrypt(str);
			System.out.println(enyStr);
		}
	}
}
