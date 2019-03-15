# -*- utf-8 -*-


class Node:
    def __init__(self, prev, item, next):
        self.prev = prev
        self.item = item
        self.next = next


class LinkedList:
    def __init__(self):
        self.head = Node(None, None, None)
        self.tail = Node(self.head,None,None)
        self.head.next = self.tail
        self.first = self.last = None
        self.size = 0

    def __node(self, item):
        if self.size == 0:
            return None
        p = self.first
        while p != self.tail:
            if p.item == item:
                return p
            p = p.next
        return None

    def __unlink(self, node):
        node.prev.next = node.next
        node.next.pre = node.prev

    def add(self, item):
        p = Node(self.last, item, self.tail)
        if p.prev is None:
            self.first = p
            self.last = p
            p.prev = self.head
            self.head.next = p
            self.tail.prev = p
        else:
            self.tail.prev = p
            self.last.next = p
            self.last = p
        self.size += 1

    def index_of(self, item):
        p = self.first
        if p is None:
            return -1
        index = 0
        while p != self.tail:
            if p.item == item:
                return index
            index += 1
        return -1

    def remove(self, item):
        if self.size == 0:
            return
        self.__unlink(self.__node(item))
        self.size -= 1

    def insert(self, index, item):
        
