package skiplist;

import java.util.Objects;

/**
 * @author yeweixiong
 * @date 2021/1/12 14:21
 */
public class SkipListNode<T extends Comparable<T>> {
    public int key;
    public T value;
    public SkipListNode<T> up, down, left, right; // 上下左右 四个指针

    public static final int HEAD_KEY = Integer.MIN_VALUE; // 负无穷
    public static final int TAIL_KEY = Integer.MAX_VALUE; // 正无穷

    public SkipListNode(int k, T v) {
        // TODO Auto-generated constructor stub
        key = k;
        value = v;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkipListNode<?> that = (SkipListNode<?>) o;
        return key == that.key &&
                Objects.equals(value, that.value) &&
                Objects.equals(up, that.up) &&
                Objects.equals(down, that.down) &&
                Objects.equals(left, that.left) &&
                Objects.equals(right, that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, up, down, left, right);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "key-value:" + key + "-" + value;
    }


    public static void main(String[] args) {
        System.out.println("中".getBytes().length);
    }
}
