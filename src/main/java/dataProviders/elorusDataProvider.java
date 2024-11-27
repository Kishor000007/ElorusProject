package dataProviders;

import org.testng.annotations.DataProvider;

import generic.WebActionUtil;
import generic.basetest;

public class elorusDataProvider {
	@DataProvider
	public Object[][] elorusAddContactData() throws Throwable {
		Object[][] data = new Object[1][6];
		data[0][0] = WebActionUtil.getData(basetest.ExcelPath, "ElorusLogin", 1, 0);
		data[0][1] = WebActionUtil.getData(basetest.ExcelPath, "ElorusLogin", 1, 1);
		data[0][2] = WebActionUtil.getData(basetest.ExcelPath, "ElorusContact", 1, 0);
		data[0][3] = WebActionUtil.getData(basetest.ExcelPath, "ElorusContact", 1, 1);
		data[0][4] = WebActionUtil.getData(basetest.ExcelPath, "ElorusContact", 1, 2);
		data[0][5] = WebActionUtil.getData(basetest.ExcelPath, "ElorusContact", 1, 3);
		return data;
	}
}

