package com.jun.sort;

import java.util.*;

/**
*@author jun
*@date 2016/5/19
*@version 1.0
*/

public class Sort01{
	int a[];
	/**
	*选择排序
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
	*插入排序
	*
	*/
	public void insertion(){
		for(int i=a.length-1;i>0;i--){
			if(a[i-1]>a[i]){
				swap(a,i-1,i);
			}
		}
		for(int i=2;i<a.length;i++){
			int temp=a[i];
			int j=i;
			while(temp<a[j-1]){
				a[j]=a[j-1];
				j--;
			}
			a[j]=temp;
		}
	}
	/**
	*冒泡排序
	*/
	public void bubble(){
		for(int i=0;i<a.length-1;i++){
			for(int j=a.length-1;j>i;j--){
				if(a[j]<a[j-1]){
					swap(a,j,j-1);
				}
			}
		}
	}
	/**
	*希尔排序
	*/
	
	public void shell(){
		int h=1;
		for(;h<=(a.length-2)/9;h=h*3+1);
		for(;h>0;h/=3){
			for(int i=h;i<a.length;i++){
				int j=i;
				int temp=a[i];
				while(j>=h&&temp<a[j-h]){
					swap(a,j,j-h);
					j-=h;
				}
				a[j]=temp;
			}
		}
	}
	/**
	*快速排序
	*/
	public void quicksort(){
		
		quick(a,0,a.length-1);
		
	}

	/**
	 * 归并排序
	 */

	public void mergeSort(){
		mergeS(a, 0, a.length-1);

	}

	/**
	 * 计数排序
	 */
	public void countSort(){
		int max = 0;
		for(int i = 0; i <a.length; i++){
			if(a[i]>max){
				max = a[i];
			}
		}
		int[] temp = new int[a.length];
		int[] count = new int[max+1];
		for(int i = 0;i <a.length;i++){
			count[a[i]]+=1;
		}
		for(int i = 1;i <= max;i++){
			count[i] += count[i-1];
		}
		for(int i = 0; i<a.length;i++){
			int index = count[a[i]]-1;
			temp[index] = a[i];
			count[a[i]]--;
		}
		for(int i = 0;i<a.length;i++){
			a[i] = temp[i];
		}
	}
	private void mergeS(int[] a, int low, int high){
		if(low >= high){
			return;
		}
		int mid = low + (high - low)/2;
		mergeS(a, low, mid);
		mergeS(a, mid+1, high);
		merge(a, low, mid, high);
	}

	private void merge(int[] a, int low, int mid, int high){
		int[] temp = new int[high-low+1];
		int i = low;
		int j = mid+1;
		int k = 0;
		while(i<=mid && j<=high){
			if(a[i]<=a[j]){
				temp[k++] = a[i++];
			}else{
				temp[k++] = a[j++];
			}
		}
		//判断哪个还有剩余
		int start = i;
		int end = mid;
		if(j<=high){
			start = j;
			end = high;
		}
		while(start<=end){
			temp[k++]=a[start++];
		}
		for(i = 0;i <= high-low; ++i){
			a[low+i] = temp[i];
		}
	}
	private void quick(int[] a,int l,int r){
		if(r<=l)return;
		
		int i=partiton(a,l,r);
		quick(a,l,i-1);
		quick(a,i+1,r);
	}
	private int partiton(int[]a,int l,int r){
		int i=l-1;
		int j=r;
		int temp=a[r];
		for(;;){
			while(a[++i]<temp);
			while(temp<a[--j])if(j==l)break;
				
			if(i>=j)break;
			swap(a,i,j);
		}
		swap(a,i,r);
		return i;
		
	}
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
		System.out.println();
	}
}