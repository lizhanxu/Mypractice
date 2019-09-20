Stream API用来丰富集合操作， .stream() 方法将常规数组转化为流

fail-fast与fail-safe

Iterator   普通的顺序迭代器<br>
Spliterator 可切割迭代器，为了并发操作集合，将集合分成了好几段，每个线程执行一段，因此是线程安全的