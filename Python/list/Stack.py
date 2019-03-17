# -*- coding: UTF-8 -*-


class Stack:
    def __init__(self):
        self.__size = 0
        self.__capacity = 10
        self.__items = [0] * self.__capacity

    def get_top(self):
        if self.__size == 0:
            return None
        return self.__items[self.__size-1]

    def pop(self):
        if self.__size == 0:
            return None
        re = self.__items[self.__size-1]
        self.__size -= 1
        return re

    def push(self, item):
        if self.__size == self.__capacity:
            return
        self.__items[self.__size] = item
        self.__size += 1

    def size(self):
        return self.__size

    def display(self):
        for i in range(self.__size):
            print(self.__items[i], end=" ")
        print()


if __name__ == '__main__':
    s = Stack()
    print("栈内元素个数:%d" % s.size(), end="\n")
    s.push(1)
    s.push(2)
    print("栈内元素个数:%d" % s.size(), end="\n")
    s.display()
    s.pop()
    print("栈顶元素:%d" % s.get_top(), end="\n")
    print("栈内元素个数:%d" % s.size(), end="\n")
    s.display()
    for i in range(10):
        s.push(i)
    s.display()
