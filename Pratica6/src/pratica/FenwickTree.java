package pratica;

public class FenwickTree {

    private int value;

    private int leftSize;

    private FenwickTree left;

    private FenwickTree right;


    public FenwickTree(int value) {
        this.value = value;
        leftSize = 0;
        left = null;
        right = null;

    }

    public FenwickTree(int leftSize, FenwickTree left, FenwickTree right) {
        this.leftSize = leftSize;
        this.left = left;
        this.right = right;
        value = left.value + right.value;

    }

    public FenwickTree(int value, int leftSize, FenwickTree left, FenwickTree right) {
        this.value = value;
        this.leftSize = leftSize;
        this.left = left;
        this.right = right;
    }

    static FenwickTree allZeros(int n) {
        if (n == 0) return null;
        if (n == 1) return new FenwickTree(0);
        int m = n / 2;
        return new FenwickTree(0, n - m, allZeros(n - m), allZeros(m));
    }

    private final boolean isLeaf() {
        if (this.left == null && this.right == null) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String output = "[" + value + ", " + leftSize;

        if (left != null)
            output += ", " + left.toString();

        if (right != null)
            output += ", " + right.toString();

        return output + "]";

    }


    public Integer size() {


        if (this.isLeaf())
            return 1;
        else
            return leftSize + right.size();


    }


    public void increment(int i, int delta) {

        value += delta;

        if (this.isLeaf())
            return;

        if (i < leftSize) {
            left.increment(i, delta);
        } else {
            right.increment(i - leftSize, delta);
        }


    }

    public int prefixSum(int upto) {


        if (this.isLeaf()) {

            if (upto > 0)
                return value;
            else
                return 0;

        }

        if (upto < leftSize)
            return left.prefixSum(upto);
        else
            return left.value + right.prefixSum(upto - leftSize);


    }

    public  int between ( int lo, int hi ){

        int prefixLo = prefixSum(lo);

        int prefixHi =  prefixSum(hi);

        // integral de a até b = integral de c até b - integral de c até a

        return  prefixHi - prefixLo;

        
    }

}






