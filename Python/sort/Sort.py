# -*- coding:utf-8 -*-

import random

class Sort:
    def __init__(self, a, n):
        self.__a = a
        self.__n = n

    def bubble(self):
        for i in range(self.__n):
            j = 1
            swap = False
            while j < self.__n:
                if self.__a[j-1] > self.__a[j]:
                    self.__a[j-1], self.__a[j] = self.__a[j], self.__a[j-1]
                    swap = True
                    #print(self.__a)
                j += 1
            if not swap:
                return

    def insert(self):
        for i in range(1, self.__n):
            temp = self.__a[i]
            j = i
            while temp < self.__a[j-1]:
                self.__a[j] = self.__a[j-1]
                j -= 1
            self.__a[j] = temp

    def selection(self):
        for i in range(self.__n):
            j = i
            min_index = i
            while j < self.__n:
                if self.__a[j] < self.__a[min_index]:
                    min_index = j
                j += 1
            self.__a[i], self.__a[min_index] = self.__a[min_index], self.__a[i]

    def merge_sort(self):
        self.__merge_sort_c(self.__a, 0, self.__n-1)

    def __merge_sort_c(self, a, start, end):
        if start >= end:
            return
        mid = start + ((end-start) >> 1)
        self.__merge_sort_c(a, start, mid)
        self.__merge_sort_c(a, mid + 1, end)
        self.__merge(a, start, mid, end)

    def __merge(self, a, start, mid, end):
        temp = [0] * (end - start + 1)
        i = start
        j = mid + 1
        k = 0
        while i <= mid and j <= end:
            if a[i] > a[j]:
                temp[k] = a[j]
                j += 1
            else:
                temp[k] = a[i]
                i += 1
            k += 1
        # s = i
        # e = mid
        # if j <= end:
        #     s = j
        #     e = end
        # temp[k:] = a[s:e+1]
        if i <= mid:
            temp[k:] = a[i:mid+1]
        else:
            temp[k:] = a[j: end+1]
        i = 0
        # while i <= end - start:
        #     a[start+i] = temp[i]
        #     i += 1
        a[start:end+1] = temp

    def display(self):
        print(self.__a)


if __name__ == '__main__':
    # print('---------冒泡-------')
    # sort = Sort([i * random.randint(1, 100) for i in range(10)], 10)
    # sort.display()
    # sort.bubble()
    # print()
    # sort.display()
    # print('---------插入-------')
    # sort = Sort([i * random.randint(1, 100) for i in range(10)], 10)
    # sort.display()
    # sort.insert()
    # print()
    # sort.display()
    # print('---------选择-------')
    # sort = Sort([i * random.randint(1, 100) for i in range(10)], 10)
    # sort.display()
    # sort.selection()
    # print()
    # sort.display()
    print('---------归并-------')
    sort = Sort([i * random.randint(1, 100) for i in range(10)], 10)
    sort.display()
    sort.merge_sort()
    print()
    sort.display()