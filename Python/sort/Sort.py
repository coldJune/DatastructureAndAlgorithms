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

    def display(self):
        print(self.__a)


if __name__ == '__main__':
    print('---------冒泡-------')
    sort = Sort([i * random.randint(1, 100) for i in range(10)], 10)
    sort.display()
    sort.bubble()
    print()
    sort.display()
    print('---------插入-------')
    sort = Sort([i * random.randint(1, 100) for i in range(10)], 10)
    sort.display()
    sort.insert()
    print()
    sort.display()
    print('---------选择-------')
    sort = Sort([i * random.randint(1, 100) for i in range(10)], 10)
    sort.display()
    sort.selection()
    print()
    sort.display()