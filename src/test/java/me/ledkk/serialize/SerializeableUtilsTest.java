/**
 * 
 */
package me.ledkk.serialize;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

import junit.framework.TestCase;

/**
 * @author Ledkk
 *
 */
public class SerializeableUtilsTest extends TestCase{
	
	public void testSerizlizeableObject() throws IOException, ClassNotFoundException{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		TempObject obj = new TempObject("abc", new byte[]{1,2,3,4});
		SerializableUtils.write(out, obj);
		Object o = SerializableUtils.read(out.toByteArray());
		System.out.println(o);
		TempObject to = SerializableUtils.read(out.toByteArray(), TempObject.class);
		System.out.println(to);
		System.out.println(to.getA()+"   "+ to.getB());
	}
	
	
	
	static class TempObject implements Serializable{
		private static final long serialVersionUID = 1L;
		private String a;
		private transient byte[] b;
		
		public TempObject() {
			super();
		}

		public TempObject(String a, byte[] b) {
			super();
			this.a = a;
			this.b = b;
		}
		
		
		public String getA() {
			return a;
		}

		public void setA(String a) {
			this.a = a;
		}

		public byte[] getB() {
			return b;
		}

		public void setB(byte[] b) {
			this.b = b;
		}

		@Override
		public String toString() {
			return "TempObject [a=" + a + "]";
		}
		
		
	}
}
