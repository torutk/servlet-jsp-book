package book.bean;

import java.io.Serializable;

public class Item implements Serializable {
    private Product product;
    private int count;

    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
