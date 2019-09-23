各类集合中元素对null的要求



Stream API用来丰富集合操作， .stream() 方法将常规数组转化为流

fail-fast与fail-safe

Iterator   普通的顺序迭代器<br>
Spliterator 可切割迭代器，为了并发操作集合，将集合分成了好几段，每个线程执行一段，因此是线程安全的

List默认的排序算法为折半插入排序(二分法)

index都是从0开始的

####LinkedList  双向链表实现的双端队列
addAll 源码阅读

`//index   第一个新节点将插入在index位置`<br>
`public boolean addAll(int index, Collection<? extends E> c) {`
        
        checkPositionIndex(index);

        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;
        /**
         * pred 新节点的前指针
         * succ index是第一个新节点插入的位置索引，succ是index上的原节点
         */
        Node<E> pred, succ;
        
        //分为中间插入和末尾插入两种情况
        if (index == size) {  //在末尾插入
            succ = null;
            pred = last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }

        for (Object o : a) {
            @SuppressWarnings("unchecked") E e = (E) o;
            Node<E> newNode = new Node<>(pred, e, null);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;//这个newNode作为下一个newNode的前节点
        }

        if (succ == null) {  //在末尾插入
            last = pred;  //尾指针指向最后一个newNode
        } else {  //将succ接在最后一个newNode上
            pred.next = succ;
            succ.prev = pred;
        }

        size += numNew;
        modCount++;
        return true;
    }`