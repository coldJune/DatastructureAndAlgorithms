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
		
		ss.rand(10);
		System.out.println("-------------插入排序前-------");
		ss.print();
		ss.insertion();
		System.out.println("\n-------------插入排序后-------");
		ss.print();
		System.out.println();
		
		ss.rand(10);
		System.out.println("-------------冒泡排序前-------");
		ss.print();
		ss.bubble();
		System.out.println("\n-------------冒泡排序后-------");
		ss.print();
		System.out.println();
		
		ss.rand(10);
		System.out.println("-------------希尔排序前-------");
		ss.print();
		ss.shell();
		System.out.println("\n-------------希尔排序后-------");
		ss.print();
		System.out.println();
		
		ss.rand(10);
		System.out.println("-------------快速排序前-------");
		ss.print();
		ss.quicksort();
		System.out.println("\n-------------快速排序后-------");
		ss.print();
		System.out.println();
	}

	public void testMerge(){
		Sort01 sort = new Sort01();
		sort.rand(10);
		sort.print();
		sort.mergeSort();
		sort.print();
	}
}