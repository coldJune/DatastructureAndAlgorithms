# -*- coding:utf-8 -*-

import random


class BinarySearch:
    def __init__(self, arr):
        self.__arr__ = sorted(arr)

    def binary_search(self, item):
        arr = self.__arr__
        high = len(arr) - 1
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

    def first_equal(self, item):
        arr = self.__arr__
        high = len(arr) - 1
        low = 0
        while low <= high:
            mid = low + ((high - low) >> 2)
            if item < arr[mid]:
                high = mid - 1
            elif item > arr[mid]:
                low = mid + 1
            else:
                if mid == 0 or arr[mid - 1] != item:
                    return mid
                high = mid - 1
        return -1

    def last_eq(self, item):
        arr = self.__arr__
        high = len(arr) - 1
        low = 0
        while low <= high:
            mid = low + ((high - low) >> 2)
            if item < arr[mid]:
                high = mid - 1
            elif item > arr[mid]:
                low = mid + 1
            else:
                if mid == len(arr) - 1 or arr[mid + 1] != item:
                    return mid
                low = mid + 1
        return -1

    def last_lt(self, item):
        arr = self.__arr__
        high = len(arr) - 1
        low = 0
        while low <= high:
            mid = low + ((high - low) >> 2)
            if item <= arr[mid]:

                high = mid - 1
            else:
                if mid == len(arr) - 1 or arr[mid + 1] > item:
                    return mid
                low = mid + 1
        return -1

    def first_gt(self, item):
        arr = self.__arr__
        high = len(arr) - 1
        low = 0
        while low <= high:
            mid = low + ((high - low) >> 2)
            if item <= arr[mid]:
                if mid == 0 or arr[mid - 1] < item:
                    return mid
                high = mid - 1
            else:

                low = mid + 1
        return -1

    def display(self):
        print(self.__arr__)


if __name__ == '__main__':
    a = [1, 2, 2, 4, 4, 4, 5]
    print(a)
    bs = BinarySearch(a)
    bs.display()
    print(bs.binary_search(a[2]))
    print(bs.first_equal(2))
    print(bs.last_eq(4))
    print(bs.last_lt(3))
    print(bs.first_gt(3))