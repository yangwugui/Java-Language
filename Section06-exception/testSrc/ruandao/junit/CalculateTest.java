package ruandao.junit;

import org.junit.Assert;
import org.junit.Test;

import ruandao.junit.Calculate;


public class CalculateTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testJiecheng() {
		Calculate cal = new Calculate();
		int actual = cal.jiecheng(5);
		Assert.assertEquals(120, actual);
	}

}
