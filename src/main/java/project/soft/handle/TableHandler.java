package project.soft.handle;

/**
 * Created by ypbai on 2014/12/25.
 */


public abstract interface TableHandler<T> {
    public void insertItem(T item);

    public void display();

    public void deleteItem(T item);

    public void updateItem(T item);

    public T getItem(T item);
}
