
import java.util.Arrays;
public class GoodHash2 {
    public static void main(String args[]){
        String a="cecs328";
        int i = 32767;
        
        byte[] stringbyte = a.getBytes();
        byte[] bite=fourByte(i);
        System.out.println(Arrays.toString(stringbyte));
        toHash(bite);
    }
    public static void toHash(byte[] array){
    	int total=0;
        for(int i=0; i<=array.length-1;i++){
            int temp=array[array.length-1-i];
            for(int j=0; j< i; j++){
                temp=(temp<<5)- temp;
            }
            System.out.println(temp);
            total+=temp;
        }
        System.out.println(total+"=TOTAL");
        byte[] bitey=fourByte(total);
        System.out.println(Arrays.toString(bitey));
        System.out.println(ByteInt(bitey));
    }
    public static byte[] fourByte(int a){
		byte[] four=new byte[4];
		for(int i=0; i<4;i++){
			four[3-i]= (byte)a;
			a=(a>>8);
		}
    	return four;
    }
    public static int ByteInt(byte[] a){
    	int[] convert=new int[4];
    	int total=0;
    	for(int i=0;i<4;i++){
    		convert[i]=a[i];
    		if(convert[i]<0){
    			convert[i]=a[i] & 0xff;
    		}
    		System.out.println(convert[i]);
    		convert[i]=convert[i]<<(8*i);
    		System.out.println(convert[i]);
    		total+=convert[i];
    	}
    	return total;
    }

}