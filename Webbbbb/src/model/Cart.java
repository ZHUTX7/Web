package model;

import java.util.*;

public class Cart {
	private List<Goods> items=new ArrayList<Goods>();
	public void add(Goods goods){
		if (goods.getGoods_id()!=0)
			items.add(goods);
		//将Goods对象放入购物车，其中哈希表下标值为Goods的ID，值为Goods的对象
	   
	}
	
	public void delete(int no){//删除购物车中其中一项物品
		items.remove(no);
	}
	
	
	public void delAll(){  //清空购物车
		items.clear();
	}
	public double sumPrice() {
		  double sum=0;
		  for (int i=0; i<items.size(); i++) {	
			  sum=sum+items.get(i).goods_price;
		  }
		  return sum;
	}
}
