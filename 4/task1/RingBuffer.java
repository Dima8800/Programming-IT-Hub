package task1;

import BaseTask.interfases.MyQueue;
import BaseTask.interfases.OrderQueuer;
import BaseTask.service.Parse;


public class RingBuffer<T> implements MyQueue, OrderQueuer {
    Parse p = new Parse();
    private final static int DEFAULT_SIZE = 1024;
    private Object[] buffer;
    private int head = 0;
    private int tail = 0;
    private int bufferSize;
    public RingBuffer(){
        this.bufferSize = DEFAULT_SIZE;
        this.buffer = new Object[bufferSize];
    }
    private Boolean empty() {
        return head == tail;
    }
    private Boolean full() {
        return (tail + 1) % bufferSize == head;
    }
    @Override
    public String getTotalTimeToCook() {
        Object[] all = getAll();
        String[] strArr = new String[all.length];
        for(int i = 0 ; i < all.length ; i ++){
            try {
                strArr[i] = all[i].toString();
            } catch (NullPointerException ex) {
                System.out.println(ex);
            }
        }
        int sum = 0;
        for (int i = 0; i < strArr.length; i++){
            sum += Integer.parseInt(strArr[i].split(" ")[1]);
        }
        return p.GenerateTime(sum);
    }


    public Object[] getAll() {
        if (empty()) {
            return new Object[0];
        }
        int copyTail = tail;
        int cnt = head < copyTail ? copyTail - head : bufferSize - head + copyTail;
        Object[] result = new String[cnt];
        if (head < copyTail) {
            for (int i = head; i < copyTail; i++) {
                result[i - head] = buffer[i];
            }
        } else {
            for (int i = head; i < bufferSize; i++) {
                result[i - head] = buffer[i];
            }
            for (int i = 0; i < copyTail; i++) {
                result[bufferSize - head + i] = buffer[i];
            }
        }
        head = copyTail;
        return result;
    }



    @Override
    public String serveOrder() {
        if (empty()) {
            return "null";
        }
        Object result = buffer[head];
        head = (head + 1) % bufferSize;
        String[] res = String.valueOf(result).split(" ");
        return p.GenerateServeOrder(res);
    }

    @Override
    public void addOrder(String[] all) {
        if (full()) {
            return;
        }
        buffer[tail] = all[0] + " " + all[1];
        tail = (tail + 1) % bufferSize;
    }

    @Override
    public void putInBack(String id, int time) {
        String[] arr = new String[2];
        arr[0] = id;
        arr[1] = Integer.toString(time);
        addOrder(arr);
    }
}
