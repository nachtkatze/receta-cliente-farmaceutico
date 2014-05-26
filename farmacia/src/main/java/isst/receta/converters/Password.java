package isst.receta.converters;

import java.security.MessageDigest;

public class Password {
	
	public static String cifrar(String password) throws Exception{
		MessageDigest msgDigest = null;
		String hashValue = null;
		msgDigest = MessageDigest.getInstance("SHA-1");
		msgDigest.reset();
		msgDigest.update(password.getBytes());
		byte byteData[] = msgDigest.digest();
		
		StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	
        hashValue=hexString.toString();
		System.out.println("El hash de la pass "+password+"es "+hashValue);
		return hashValue;
		
	}

}
