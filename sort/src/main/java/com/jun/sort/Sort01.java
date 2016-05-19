package com.jun.sort;

import java.util.*;

/**
*@author jun
*@date 2016/5/19
*@version 1.0
*/

public class Sort01{
	int a[];
	/*
	*—°‘Ò≈≈–Ú
	*
	*/
	public void selection(){
		int i;
		int j;
		
		for(i=0;i<a.length-1;i++){
			int min=i;
			for(j=i+1;j<a.length;j++){
				if(a[min]>a[j]){
					min=j;
				}
			}
			swap(a,i,min);
		}
	}
	/**
	*≤Â»Î≈≈–Ú
	*
	*/
	public void insertion(){}
	private void swap(int a[],int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	public void rand(int n){
		a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=(int)(Math.random()*100);
		}
	}
	public void print(){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"  ");
		}
	}
}