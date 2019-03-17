# -*- coding: UTF-8 -*-


class Node:
    def __init__(self, prev, item, next):
        self.prev = prev
        self.item = item
        self.next = next


class LinkedList:
    def __init__(self):
        self.__head = Node(None, None, None)
        self.__tail = Node(self.__head,None,None)
        self.__head.next = self.__tail
        self.__first = self.__last = None
        self.__size = 0

    def __node(self, item):
        if self.__size == 0:
            return None
        p = self.__first
        while p != self.__tail:
            if p.item == item:
                return p
            p = p.next
        return None

    def __unlink(self, node):
        node.prev.next = node.next
        node.next.pre = node.prev
        if node == self.__last:
            self.__last = self.__last.prev
        if node == self.__first:
            self.__first = self.__first.next
        if node == self.__first == self.__last:
            self.__first = self.__last = None

    def add(self, item):
        p = Node(self.__last, item, self.__tail)
        if p.prev is None:
            self.__first = p
            self.__last = p
            p.prev = self.__head
            self.__head.next = p
            self.__tail.prev = p
        else:
            self.__tail.prev = p
            self.__last.next = p
            self.__last = p
        self.__size += 1

    def index_of(self, item):
        p = self.__first
        if p is None:
            return -1
        index = 0
        while p != self.__tail:
            if p.item == item:
                return index
            p = p.next
            index += 1
        return -1

    def remove(self, item):
        if self.__size == 0:
            return
        self.__unlink(self.__node(item))
        self.__size -= 1

    def insert(self, index, item):
        if index < 0 or index > self.__size:
            return
        p = self.__first
        for i in range(index):
            p = p.next
        n = Node(p.prev, item, p)
        if p == self.__first:
            self.__head.next = n
            p.prev = n
            self.__first = n
        elif p == self.__tail:
            self.__tail.prev.next = n
            self.__tail.prev = n
            self.__last = n
        else:
            p.prev.next = n
            p.prev = n

        self.__size += 1

    def get(self, index):
        if index < 0 or index >= self.__size:
            return None
        p = self.__first
        for i in range(index):
            p = p.next
        return p.item

    def size(self):
        return self.__size

    def get_first(self):
        return self.__first.item

    def get_last(self):
        return self.__last.item

    def prev(self, item):
        index = self.index_of(item)
        if index == -1 or index == 0:
            return None
        return self.__node(item).prev.item

    def succ(self, item):
        index = self.index_of(item)
        if index == -1 or index == self.__size - 1:
            return None
        return self.__node(item).next.item

    def display(self):
        p = self.__first
        while p.next != self.__tail:
            print(p.item, end="->")

            p = p.next
        print(p.item)

    def clear(self):
        ne = p = self.__first
        while ne != self.__tail:
            ne = p.next
            p.item = None
            p.prev = None
            p.next = None
        self.__size = 0
        self.__first = self.__last = None
        self.__head.next = self.__tail
        self.__tail.prev = self.__head


if __name__ == '__main__':
    ll = LinkedList()
    ll.add(1)
    print("链表的大小:", end="")
    print(ll.size(), end="\n")
    print("链表的头:", end="")
    print(ll.get_first(), end="\n")
    print("链表的尾", end="")
    print(ll.get_last(), end="\n")
    print("1的下标:", end='')
    print(ll.index_of(1), end='\n')
    ll.display()
    print()

    ll.insert(0, 2)
    print("链表的大小:", end="")
    print(ll.size(), end="\n")
    print("链表的头:", end="")
    print(ll.get_first(), end="\n")
    print("链表的尾:", end="")
    print(ll.get_last(), end="\n")
    print("2的下标:", end='')
    print(ll.index_of(2), end='\n')
    ll.display()
    print()

    ll.insert(2, 3)
    print("链表的大小:", end="")
    print(ll.size(), end="\n")
    print("链表的头:", end="")
    print(ll.get_first(), end="\n")
    print("链表的尾", end="")
    print(ll.get_last(), end="\n")
    print("3的下标:", end='')
    print(ll.index_of(3), end='\n')
    ll.display()
    print()

    ll.insert(1, 4)
    print("链表的大小:", end="")
    print(ll.size(), end="\n")
    print("链表的头:", end="")
    print(ll.get_first(), end="\n")
    print("链表的尾", end="")
    print(ll.get_last(), end="\n")
    print("3的下标:", end='')
    print(ll.index_of(3), end='\n')
    print("2的前驱:", end='')
    print(ll.prev(2), end='\n')
    print("3的后继:", end='')
    print(ll.succ(3), end='\n')
    print("4的前驱:", end='')
    print(ll.prev(4), end='\n')
    print("4的后继:", end='')
    print(ll.succ(4), end='\n')
    ll.display()
    print()
