/**
 * 
 */
package me.ledkk.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Ledkk
 *	序列化相关的工具方法
 */
public class SerializableUtils {
	
	/**
	 * 将对象obj序列化到out中
	 * @param out
	 * @param obj
	 * @throws IOException 
	 */
	public static void write(ByteArrayOutputStream out , Object obj ) throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(obj);
	}
	
	/**
	 * 从objs数组中反序列化出对象Object
	 * @param objs
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object read(byte[] objs) throws IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(objs));
		return ois.readObject();
	}
	
	/**
	 * 从objs数组中反序列化出对应的类型T的对象
	 * @param objs
	 * @param t
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static <T> T read(byte[] objs,Class<T> t) throws IOException, ClassNotFoundException{
		Object obj = read(objs);
		return (T) obj;
	}
}
