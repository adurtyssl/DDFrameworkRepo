package com.test.rough;

import java.util.Date;

public class TestTimeStamp {

	public static void main(String[] args) {

			Date dt = new Date();
			String screenShotName = dt.toString() + ".jpg";
			System.out.println(screenShotName);

	}

}
