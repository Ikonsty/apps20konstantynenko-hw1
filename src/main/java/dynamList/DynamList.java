package dynamList;

public class DynamList {
    private int len = 0;
    private int actualLen = 0;
    private double[] lst;

    public DynamList(){

    }

    public void addNew(double el){
        if (this.len + 1 >= this.actualLen){
            doubleArr();
        }
        else {
            lst[len] = el;
        }
        this.len += 1;
    }

    public void doubleArr(){
        double[] result = new double[actualLen * 2];
        for (int n = 0; n < this.len; n++) {
            result[n] = this.lst[n];
        }
        this.lst = result;
        this.actualLen *= 2;
    }

    public int getLen() {
        return this.len;
    }

    public double getVal(int i) {
        return this.lst[i];
    }
}
