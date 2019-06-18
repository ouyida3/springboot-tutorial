package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	/**
	 * 没有引入web，因此启动后运行完则shutdown。
	 *
	 * 2019-06-18 11:10:44.309  INFO 8126 --- [       Thread-7] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
	 * Disconnected from the target VM, address: '127.0.0.1:59445', transport: 'socket'
	 *
	 * Process finished with exit code 0
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
