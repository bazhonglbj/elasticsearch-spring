/**
 * 
 */
package com.spring.boot.blog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bazhonglbj
 *
 */
@RestController
public class Hello{
	@RequestMapping("/hello")
	public String helloWorld(){
		return "Hello world";
	}

}
