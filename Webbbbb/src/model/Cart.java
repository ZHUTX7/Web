package model;

import java.util.*;

public class Cart {
	private List<Goods> items=new ArrayList<Goods>();
	public void add(Goods goods){
		if (goods.getGoods_id()!=0)
			items.add(goods);
		//��Goods������빺�ﳵ�����й�ϣ���±�ֵΪGoods��ID��ֵΪGoods�Ķ���
	   
	}
	
	public void delete(int no){//ɾ�����ﳵ������һ����Ʒ
		items.remove(no);
	}
	
	
	public void delAll(){  //��չ��ﳵ
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
