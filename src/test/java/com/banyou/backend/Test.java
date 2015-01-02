package com.banyou.backend;

import java.io.File;

public class Test {
public static void main(String[] args) {
	
	System.out.println(System.getProperty("user.home"));
	
	System.out.println(new File("~").getAbsolutePath());
}
}
