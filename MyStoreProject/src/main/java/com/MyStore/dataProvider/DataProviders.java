package com.MyStore.dataProvider;

import org.testng.annotations.DataProvider;

import com.MyStore.utility.NewExcelLibrary;

public class DataProviders {
	NewExcelLibrary obj = new NewExcelLibrary();

	//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

		@DataProvider(name = "credentials")
		public Object[][] getCredentials() {
			// Totals rows count
			int rows = obj.getRowCount("Credentials"); //worksheetName= Credentials
			// Total Columns
			int column = obj.getColumnCount("Credentials"); //worksheetName= Credentials
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Credentials", j, i + 2);
				}
			}
			return data;
		}

}