package com.jachs.javapoet;

import java.io.File;
import java.io.IOException;

import javax.lang.model.element.Modifier;

import org.junit.Before;
import org.junit.Test;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Demo {
	//物理文件存放路径
	private String path="e:\\a";
	private File file=new File(path);
	
	@Test
	public void test1() throws IOException {
		String className="HelloWorld";
		
		MethodSpec main = MethodSpec.methodBuilder("main")
			    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
			    .returns(void.class)
			    .addParameter(String[].class, "args")
			    .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
			    .build();

			TypeSpec helloWorld = TypeSpec.classBuilder(className)
			    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
			    .addMethod(main)
			    .build();

			JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
			    .build();

			javaFile.writeTo(file);
	}
	
	@Test
	public void test2() throws IOException {
		String className="ForEach";
		
		MethodSpec main = MethodSpec.methodBuilder("main")
			    .addCode(""
			        + "int total = 0;\n"
			        + "for (int i = 0; i < 10; i++) {\n"
			        + "  total += i;\n"
			        + "}\n")
			    .build();
		
		TypeSpec helloWorld = TypeSpec.classBuilder(className)
			    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
			    .addMethod(main)
			    .build();
		
		JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
			    .build();
		
		javaFile.writeTo(file);
	}
}
