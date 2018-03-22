package lab1.tr;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestTriangle {
	private Triangle tri;
	
	private int a,b,c;
	private String s;
	
	public TestTriangle(int a,int b,int c,String s){
		this.a=a;
		this.b=b;
		this.c=c;
		this.s=s;
	}
	
	
	@Before
	public void setup(){
		tri=new Triangle();
	}
	
	@Test
	public void testEquilateral(){
		assertEquals("Equilateral triangle",tri.triangle(3,3,3));
	}
	@Test
	public void testIsosceles(){
		assertEquals("Isosceles triangle",tri.triangle(3,3,4));
	}
	@Test
	public void testScalene(){
		assertEquals("Scalene triangle",tri.triangle(3,4,5));
	}
	@Test
	public void testNotTriangle(){
		assertEquals("Not triangle",tri.triangle(3, 4, 8));
	}
	
	//≤Œ ˝ªØ≤‚ ‘
	@Parameters
	public static Collection<Object[]> getResult(){
		return Arrays.asList(new Object[][]{
			{3,3,3,"Equilateral triangle"},
			{3,3,4,"Isosceles triangle"},
			{3,4,5,"Scalene triangle"},
			{3,4,8,"Not triangle"}
		});
	}
	
	@Test
	public void testTriangle(){
		assertEquals(this.s,tri.triangle(a, b, c));
	}


}
