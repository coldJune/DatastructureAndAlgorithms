# -*- utf-8 -*-


class ArrayList:

    def __init__(self):
        self.__capacity = 10
        self.__size = 0
        self.__items = [0]*self.__capacity

    def index_of(self, item):
        for i in range(self.__size):
            if item == self.__items[i]:
                return i
        return -1

    def add(self, item):
        if self.__size == self.__capacity:
            self.__expand()
        self.__items[self.__size] = item
        self.__size += 1

    def insert(self, index, item):
        if index > self.__size:
            return;
        if self.__size == self.__capacity:
            self.__expand()
        self.__items[index+1:self.__size+1] = self.__items[index:self.__size]
        self.__items[index] = item
        self.__size += 1

    def delete(self, item):
        for i in range(self.__size):
            if item == self.__items[i]:
                self.__items[i:self.__size-1] = self.__items[i+1:self.__size]
                self.__size -= 1

    def size(self):
        return self.__size

    def is_empty(self):
        return True if self.__size == 0 else False

    def display(self):
        for i in range(self.__size):
            print(self.__items[i], end=" ")
        print()

    def __expand(self):
        self.__capacity *= 2
        temp = [0]*self.__capacity
        temp[0:self.__size] = self.__items[:]
        self.__items = temp


if __name__ == '__main__':
    al = ArrayList()
    print(al.size())
    print(al.is_empty())
    al.add(1)
    al.insert(0, 2)
    al.insert(2, 3)
    al.display()
    print(al.size())
    al.delete(1)
    al.display()
    for i in range(10):
        al.insert(0, i)
    al.display()
