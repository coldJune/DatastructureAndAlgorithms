# -*- coding:utf-8 -*-

import random


class BinarySearch:
    def __init__(self, arr):
        self.__arr__ = sorted(arr)

    def binary_search(self, item):
        arr = self.__arr__
        high = len(a)
        low = 0
        while low <= high:
            mid = low + ((high-low) >> 2)
            if item < arr[mid]:
                high = mid - 1
            elif item > arr[mid]:
                low = mid + 1
            else:
                return mid
        return -1

    def display(self):
        print(self.__arr__)


if __name__ == '__main__':
    a = [random.randint(1, 100) for i in range(10)]
    print(a)
    bs = BinarySearch(a)
    bs.display()
    print(bs.binary_search(a[2]))
