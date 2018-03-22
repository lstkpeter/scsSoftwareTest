package lab1.tr;

public class Triangle {
	public String triangle(int a,int b,int c)
	{
		if(a==b && b==c)
			return "Equilateral triangle";
		else if(a==b || b==c || a==c)
			return "Isosceles triangle";
		else if(a+b<c || a+c<b || b+c<a)
			return "Not triangle";
		return "Scalene triangle";
	}
}
