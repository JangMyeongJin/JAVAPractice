package practice;

public class PriceTest {

	public static void main(String[] args) {
		int price = 3;
		int money = 20;
		int count = 4;
		
		long total = 0;
        
        for(int i=1; i<count+1; i++){
            total += price*i;
            System.out.println(price + "	" + i + "	" + total);
        }
        
       

	}

}
