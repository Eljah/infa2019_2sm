/**
 * Created by Ilya Evlampiev on 11.02.2019.
 */
public class SortedArrayContainer {

    private long[] array;
    private int capacity;

    public SortedArrayContainer(int max) {
        this.array = new long[max];
        this.capacity = -1;
    }

    public void insert(long value) {
        //this.array[++this.capacity] = value;
        if (this.capacity == -1) {
            this.capacity++;
            this.array[this.capacity] = value;
        } else {
            int initialCapasity = this.capacity;
            for (int i = 0; i <= initialCapasity; i++) {
                if (this.array[i] > value) {
                    insert(i, value);
                    break;
                }
            }
            if (this.array[this.capacity] > value) {
            } else {
                this.array[++this.capacity] = value;
            }
        }
    }

    public long readUnit(int index) {
        if (index <= this.capacity) {
            return this.array[index];
        } else {
            throw new IndexOutOfBoundsException("Our internal capacity index is smaller than requested in read unit operation");
        }
    }

    public void remove(int index) {
        if (index <= this.capacity) {
            for (int i = index; i < capacity; i++) {
                this.array[i] = this.array[i + 1];
            }
            this.array[capacity--] = 0;
        } else {
            throw new IndexOutOfBoundsException("Our internal capacity index is smaller than requested in remove operation");
        }
    }

    private void insert(int index, long value) {
        if (index <= this.capacity) {
            this.capacity++;
            for (int i = capacity; i > index; i--) {
                this.array[i] = this.array[i - 1];
            }
            this.array[index] = value;
        } else {
            throw new IndexOutOfBoundsException("Our internal capacity index is smaller than requested in remove operation");
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= this.capacity; i++) {
            stringBuilder.append(this.array[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

}
