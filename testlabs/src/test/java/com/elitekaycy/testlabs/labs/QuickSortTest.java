package com.elitekaycy.testlabs.labs;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import com.elitekaycy.testlabs.labs.simpleSort.QuickSort;

public class QuickSortTest {

  @Test
  public void unit_test_quicksort() {
    int[] arr = { 4, 3, 7, 1 };

    int[] result = QuickSort.sort(arr);

    int[] expected = { 1, 3, 4, 7 };

    assertEquals(arr[0], result[0]);
    for (int i = 0; i < result.length; i++) {
      assertEquals(expected[i], result[i]);
    }
  }

  @Test(dataProvider = "sortData")
  public void test_quicksort_with_data_providers(int[] arr) {
    int[] result = QuickSort.sort(arr);

    assertTrue(result[0] <= result[1]);
    assertTrue(result[0] <= result[result.length - 1]);
  }

  @DataProvider(name = "sortData")
  public Object[][] sortData() {

    return new Object[][] { { new int[] { 4, 3, 7, 1 } }, { new int[] { 17, 19, 12 } } };

  }

}
