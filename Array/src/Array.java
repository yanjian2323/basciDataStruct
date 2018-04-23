// 实现一个动态数组的类,自动扩容和缩容
public class Array<E> {
    private E[] data;
    // 存放元素的个数
    private int size;
    private void resize(int capacity){
        // 重新开辟空间
        E[] newData = (E[])new Object[capacity];
        // 把原来的值复制到新空间
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }
    public Array(){
        // 默认容器大小是10
        this(10);
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return data.length;
    }
    // 在指定索引位置插入元素
    public void add(int index, E e){
        if (index < 0 || index > size){
            // 不能有间隔的空间，保证连续
            throw new IllegalArgumentException("add fail,index must be index >= 0 and index <=size");
        }
        // 超过容器的大小
        if (size == data.length) {
            // 扩容
            resize(data.length * 2);
        }
        for(int i = size; i > index; i--){
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;
    }
    // 尾部插入元素
    public void addLast(E e){
        add(size, e);
    }
    // 首部插入元素
    public void addFirst(E e){
        add(0, e);
    }
    // 得到索引位置的元素
    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed,index is illegal");
        }
        return data[index];
    }
    // 设置索引位置元素的值
    public void set(int index, E e){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed,index is illegal");
        }
        data[index] = e;
    }
    // 是否包含某个元素
    public boolean contain(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] ==  e) {
                return true;
            }
        }
        return false;
    }
    // 寻找某个元素的索引，没找到返回-1
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] ==  e) {
                return i;
            }
        }
        return -1;
    }
    // 删除索引处的元素，返回删除的这个元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed,index is illegal");
        }
        E ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        size--;
        data[size] = null;
        // 避免复杂度震荡
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }
    // 删除第一个元素
    public E removeFirst(){
        return remove(0);
    }
    // 删除最后一个元素
    public E removeLast(){
        return remove(size - 1);
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("size = %d, capacity = %d,", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                sb.append(String.format("%d]", data[i]));
            } else {
                sb.append(String.format("%d,",data[i]));
            }
        }
        return sb.toString();
    }
}
