package Casio.Dao;

import java.math.BigDecimal;
import java.util.Vector;

import Casio.Models.CartEntity;

public class CartDao {
	public Vector<CartEntity> items;

	public CartDao()  {
		items = new Vector<CartEntity>();
	}
	public CartEntity getItems(int i){
		return (CartEntity)items.get(i);
	}
	public CartEntity lookup(String code) {
		for(int i=0;i<items.size();i++) {
			CartEntity item=(CartEntity)items.get(i);
			if(code.equals(item.getmaSp()))
					return item;
		}
		return null;
	}
	public int GetSize() {
		return items.size();
	}
	public void addItem(String c,int q, BigDecimal giagoc,int km, BigDecimal gia, String hinh) {
		items.add(new CartEntity(c,q, giagoc,km,gia,hinh));
	}
	public void RemoveItem(String code) {
		for(int i=0;i<items.size();i++)
		{
			CartEntity item=(CartEntity)items.get(i);
			if(code.equals(item.getmaSp()))
				items.removeElementAt(i);;
		}
	}
}
