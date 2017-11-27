package entity;

import java.util.List;

public class OrderdetailBean {
    private int id;
    private int orders_id;
    private int items_id;
    private int item_num;
    private ItemsBean itemsBean;

    public ItemsBean getItemsBean() {
        return itemsBean;
    }

    public void setItemsBean(ItemsBean itemsBean) {
        this.itemsBean = itemsBean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getItems_id() {
        return items_id;
    }

    public void setItems_id(int items_id) {
        this.items_id = items_id;
    }

    public int getItem_num() {
        return item_num;
    }

    public void setItem_num(int item_num) {
        this.item_num = item_num;
    }

    @Override
    public String toString() {
        return "OrderdetailBean{" +
                "id=" + id +
                ", orders_id=" + orders_id +
                ", items_id=" + items_id +
                ", item_num=" + item_num +
                '}';
    }
}
