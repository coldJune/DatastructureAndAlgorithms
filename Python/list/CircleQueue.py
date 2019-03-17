# -*- coding: UTF-8 -*-

import random


class CircleQueue:
    def __init__(self):
        self.__capacity = 5
        self.__items = [0] * self.__capacity
        self.__size = 0
        self.__head = self.__tail = 0

    def enqueue(self, item):
        if (self.__tail+1) % self.__capacity == self.__head:
            raise IndexError("队列满")
        self.__items[self.__tail] = item
        self.__tail = (self.__tail + 1) % self.__capacity
        self.__size += 1

    def dequeue(self):
        if self.__tail == self.__head:
            raise IndexError("队列空")
        re = self.__items[self.__head]
        self.__head = (self.__head + 1) % self.__capacity
        self.__size -= 1
        return re

    def display(self):
        index = self.__head
        for i in range(self.__size):
            print(self.__items[(index + i) % self.__capacity], end= " ")
        print()

    def size(self):
        return self.__size


if __name__ == '__main__':
    cq = CircleQueue()
    cq.enqueue(1)
    cq.enqueue(2)
    print("队列大小：%d" % cq.size())
    cq.display()
    print("出队：%d" % cq.dequeue())
    print("队列大小：%d" % cq.size())
    cq.display()
    for i in range(30):
        try:
            rnd = random.randint(1, 101)
            if rnd % 2 == 0:
                cq.enqueue(i)
                print("入队:", end="")
                cq.display()
            else:
                cq.dequeue()
                print("出队:", end="")
                cq.display()
        except IndexError as e:
            print(e.args[0])

