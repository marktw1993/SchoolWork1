import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class test {
	// This program is for your testing and will not be graded.
	// Try to test as many cases as you can and make sure your program is correct.
	// Your work will be graded by 10 test cases. 
	
	@Test
	public void test1(){
		dp_lcs lcs = new dp_lcs("atom", "ant");
		String str = lcs.returnLCS();
		System.out.println(str);
		assertEquals(str, "at");
	}
	
	@Test
	public void test2(){
		dp_lcs lcs = new dp_lcs("abbda", "bda");
		String str = lcs.returnLCS();
		System.out.println(str);
		assertEquals(str, "bda");
	}
	
	@Test
	public void test3(){
		dp_lcs lcs = new dp_lcs("abbdadd", "bdadd");
		String str = lcs.returnLCS();
		System.out.prhttp://marketplace.eclipse.org/marketplace-client-intro?mpc_install=3233881intln(str);
		assertEquals(str, "bdadd");
	}
	
	@Test
	public void test4(){
		dp_lcs lcs = new dp_lcs("abcd", "abcd");
		String str = lcs.returnLCS();
		System.out.println(str);
		assertEquals(str, "abcd");
	}
	
	@Test
	public void test5(){
		dp_lcs lcs = new dp_lcs("abbdaaaare", "bdarare");
		String str = lcs.returnLCS();
		System.out.println(str);
		assertEquals(str, "bdaare");
	}
	@Test
	public void test6(){
		dp_lcs lcs = new dp_lcs("abcdeabab123", "ad321baddd");
		String str = lcs.returnLCS();
		System.out.println(str);
		assertEquals(str, "abaa");
	}
}