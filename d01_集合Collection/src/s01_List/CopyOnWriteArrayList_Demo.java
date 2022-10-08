package s01_List;


//    读写分离，写时复制:
//        读操作还是在原始数组中进行（可多线程同时读）
//        写操作在一个复制的数组上进行，结束之后需要把原始数组指向新的复制数组。
//        写操作需要加锁，防止并发写入时导致写入数据丢失。
//        写操作的同时允许读操作，大大提高了读操作的性能，因此很适合"读多写少"的应用场景。
//
//
//    缺点：
//        内存占用：在写操作时需要复制一个新的数组，使得内存占用为原来的两倍左右；
//        只能保证数据最终一致性，不能保证实时的一致性
public class CopyOnWriteArrayList_Demo {
    public static void main(String[] args) {

    }
}

//  实现线程安全的数组：
//    CopyOnWriteArrayList底层用lock实现锁，
//    vector用synchronized 进行同步                      太古老，不用了
//    Collections.synchronizedList(new ArrayList<>())  太古老，不用了
