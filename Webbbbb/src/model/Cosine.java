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
			
			//�������ַ����е������ַ��Լ����ֵ�������װ����AlgorithmMap��
			for (int i = 0; i < doc1.length(); i++) {
				char d1 = doc1.charAt(i);
				if(isHanZi(d1)){//�������ֲ�����
					int charIndex = getGB2312Id(d1);//�����ַ���Ӧ��GB2312����
					if(charIndex != -1){
						int[] fq = AlgorithmMap.get(charIndex);
						if(fq != null && fq.length == 2){
							fq[0]++;//���и��ַ�����1
						}else {
							fq = new int[2];
							fq[0] = 1;
							fq[1] = 0;
							AlgorithmMap.put(charIndex, fq);//�����ַ���map
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
			
			return denominator / Math.sqrt(sqdoc1*sqdoc2);//���Ҽ���
		} else {
			throw new NullPointerException(" the Document is null or have not cahrs!!");
		}
	}
 
	public static boolean isHanZi(char ch) {
		// �ж��Ƿ���
		return (ch >= 0x4E00 && ch <= 0x9FA5);
		/*if (ch >= 0x4E00 && ch <= 0x9FA5) {//����
			return true;
		}else{
			String str = "" + ch;
			boolean isNum = str.matches("[0-9]+"); 
			return isNum;
		}*/
		/*if(Character.isLetterOrDigit(ch)){
			String str = "" + ch;
			if (str.matches("[0-9a-zA-Z\\u4e00-\\u9fa5]+")){//������
                return true;
            }else return false;
		}else return false;*/
	}
 
	/**
	 * ���������Unicode�ַ�����ȡ����GB2312�������ascii���룬
	 * 
	 * @param ch �����GB2312�����ַ�����ASCII�ַ�(128��)
	 * @return ch��GB2312�е�λ�ã�-1��ʾ���ַ�����ʶ
	 */
	public static short getGB2312Id(char ch) {
		try {
			byte[] buffer = Character.toString(ch).getBytes("GB2312");
			if (buffer.length != 2) {
				// ���������bufferӦ���������ֽڣ�����˵��ch������GB2312���룬�ʷ���'?'����ʱ˵������ʶ���ַ�
				return -1;
			}
			int b0 = (int) (buffer[0] & 0x0FF) - 161; // �����A1��ʼ����˼�ȥ0xA1=161
			int b1 = (int) (buffer[1] & 0x0FF) - 161; 
			return (short) (b0 * 94 + b1);// ��һ���ַ������һ���ַ�û�к��֣����ÿ����ֻ��16*6-2=94������
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
			//֮���Դ��û��������Ĳ�ѯ
			
			s1=l1.get(i).getWordsKey();//�û����˵�
			for(int j=0;j<l2.size();j++) {
				s2=l2.get(i).getWordsKey();
				if(Cosine.getSimilarity(s1,s2)>0.8) {
					l3.add(k, s1);
					k++;
					System.out.println(l3.get(k-1));
					return l3.get(k-1);
					//��Ϊ���ݿ������ݲ��㣬�����Ϊ���������Ƶ�ֵ����ȫ��ȡ��
					//���ԣ��ڴ��ȷ�������0.8���ϵ�
					//�������Ըĳ� return List<String>
				}
			}
		}
		return s1;
}
	public static void main(String[] args) {
//		String str1="��ʯ";
//		String str2="��";
//		long start=System.currentTimeMillis();  
//		double Similarity=Cosine.getSimilarity(str1, str2);
//		System.out.println("��ʱ:"+(System.currentTimeMillis()-start)); 
//		System.out.println(Similarity);
		GuessYouLike();
}}
