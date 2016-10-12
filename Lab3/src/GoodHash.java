import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class GoodHash {
	public static void main(String[] args) {
		String s = "cecs328";
		byte[] stringbyte = s.getBytes(StandardCharsets.UTF_8); // String to byte array JAVA 7+
		byte[] intbyte = intToByteArray(683870835);
		byte[] intbyte2 = intToByteArray(32767);
		
		System.out.println("Hash func value: "+goodHashFunc(stringbyte));
	}
	//goodHashFunc returns a hashcode based on the bytes of the object.
	public static int goodHashFunc(byte[] b){
		System.out.println(Arrays.toString(b));
		int m= b.length;
		int total=0;
		for(int i=0; i<m; i++){
            int temp= b[m-1-i] & 0xff; //&0xff changes the byte from signed to unsigned
            for(int j=0; j< i; j++){
                temp = (temp << 5)- temp;
                //bitshifts temp value. equivalent to multiplication by 31^i
            }
            System.out.println(total);
            total+=temp;
        }
		return total;
	}
	//converts int to byte array
	public static final byte[] intToByteArray(int value) {
	    return new byte[] {
	            (byte)(value >>> 24),
	            (byte)(value >>> 16),
	            (byte)(value >>> 8),
	            (byte)value};
	}
}
