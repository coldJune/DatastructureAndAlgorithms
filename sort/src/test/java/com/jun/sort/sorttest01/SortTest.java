package com.jun.sort.sorttest01;

import com.jun.sort.*;

import java.util.*;

import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
*@author jun
*@date 2016/5/19
*@version 1.0
*/

public class SortTest extends TestCase{
	public SortTest(String testName){
		super(testName);
	}
	
	public void testSelectSort() throws Exception{
		Sort01 ss = new Sort01();
		ss.rand(10);
		System.out.println("-------------select排序前-------");
		ss.print();
		ss.selection();
		System.out.println("\n-------------select排序后-------");
		ss.print();
		System.out.println();
	}
}