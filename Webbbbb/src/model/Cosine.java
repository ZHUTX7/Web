package model;
 
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import DAO.MyWordDB;
import DAO.WordDB;
 
public class Cosine {
	
	public static double getSimilarity(String doc1, String doc2) {
		if (doc1 != null && doc1.trim().length() > 0 && doc2 != null&& doc2.trim().length() > 0) {
			
			Map<Integer, int[]> AlgorithmMap = new HashMap<Integer, int[]>();
			
			//将两个字符串中的中文字符以及出现的总数封装到，AlgorithmMap中
			for (int i = 0; i < doc1.length(); i++) {
				char d1 = doc1.charAt(i);
				if(isHanZi(d1)){//标点和数字不处理
					int charIndex = getGB2312Id(d1);//保存字符对应的GB2312编码
					if(charIndex != -1){
						int[] fq = AlgorithmMap.get(charIndex);
						if(fq != null && fq.length == 2){
							fq[0]++;//已有该字符，加1
						}else {
							fq = new int[2];
							fq[0] = 1;
							fq[1] = 0;
							AlgorithmMap.put(charIndex, fq);//新增字符入map
						}
					}
				}
			}
 
			for (int i = 0; i < doc2.length(); i++) {
				char d2 = doc2.charAt(i);
				if(isHanZi(d2)){
					int charIndex = getGB2312Id(d2);
					if(charIndex != -1){
						int[] fq = AlgorithmMap.get(charIndex);
						if(fq != null && fq.length == 2){
							fq[1]++;
						}else {
							fq = new int[2];
							fq[0] = 0;
							fq[1] = 1;
							AlgorithmMap.put(charIndex, fq);
						}
					}
				}
			}
			
			Iterator<Integer> iterator = AlgorithmMap.keySet().iterator();
			double sqdoc1 = 0;
			double sqdoc2 = 0;
			double denominator = 0; 
			while(iterator.hasNext()){
				int[] c = AlgorithmMap.get(iterator.next());
				denominator += c[0]*c[1];
				sqdoc1 += c[0]*c[0];
				sqdoc2 += c[1]*c[1];
			}
			
			return denominator / Math.sqrt(sqdoc1*sqdoc2);//余弦计算
		} else {
			throw new NullPointerException(" the Document is null or have not cahrs!!");
		}
	}
 
	public static boolean isHanZi(char ch) {
		// 判断是否汉字
		return (ch >= 0x4E00 && ch <= 0x9FA5);
		/*if (ch >= 0x4E00 && ch <= 0x9FA5) {//汉字
			return true;
		}else{
			String str = "" + ch;
			boolean isNum = str.matches("[0-9]+"); 
			return isNum;
		}*/
		/*if(Character.isLetterOrDigit(ch)){
			String str = "" + ch;
			if (str.matches("[0-9a-zA-Z\\u4e00-\\u9fa5]+")){//非乱码
                return true;
            }else return false;
		}else return false;*/
	}
 
	/**
	 * 根据输入的Unicode字符，获取它的GB2312编码或者ascii编码，
	 * 
	 * @param ch 输入的GB2312中文字符或者ASCII字符(128个)
	 * @return ch在GB2312中的位置，-1表示该字符不认识
	 */
	public static short getGB2312Id(char ch) {
		try {
			byte[] buffer = Character.toString(ch).getBytes("GB2312");
			if (buffer.length != 2) {
				// 正常情况下buffer应该是两个字节，否则说明ch不属于GB2312编码，故返回'?'，此时说明不认识该字符
				return -1;
			}
			int b0 = (int) (buffer[0] & 0x0FF) - 161; // 编码从A1开始，因此减去0xA1=161
			int b1 = (int) (buffer[1] & 0x0FF) - 161; 
			return (short) (b0 * 94 + b1);// 第一个字符和最后一个字符没有汉字，因此每个区只收16*6-2=94个汉字
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return -1;
	}
	//List<Word>
	public static String  GuessYouLike(){
		List<Word> l1=MyWordDB.allWord();
		List<Word> l2=WordDB.allWord();
		ArrayList<String> l3=new ArrayList<String>();
		String s1="",s2="";
		int k=0;    
		for(int i=l1.size()-1;i>=0;i--) {
			//之所以从用户最近输入的查询
			
			s1=l1.get(i).getWordsKey();//用户个人的
			for(int j=0;j<l2.size();j++) {
				s2=l2.get(i).getWordsKey();
				if(Cosine.getSimilarity(s1,s2)>0.8) {
					l3.add(k, s1);
					k++;
					System.out.println(l3.get(k-1));
					return l3.get(k-1);
					//因为数据库中数据不足，如果人为输入了相似的值，会全部取到
					//所以，在此先返回相似0.8以上的
					//后续可以改成 return List<String>
				}
			}
		}
		return s1;
}
	public static void main(String[] args) {
//		String str1="宝石";
//		String str2="啊";
//		long start=System.currentTimeMillis();  
//		double Similarity=Cosine.getSimilarity(str1, str2);
//		System.out.println("用时:"+(System.currentTimeMillis()-start)); 
//		System.out.println(Similarity);
		GuessYouLike();
}}
