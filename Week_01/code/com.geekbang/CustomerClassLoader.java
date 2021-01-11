import java.io.*;
import java.lang.reflect.Method;

public class CustomerClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Class<?> hello = new CustomerClassLoader().findClass("Hello");
            Method declaredMethod = hello.getDeclaredMethod("hello");
            declaredMethod.invoke(hello.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {
        ByteArrayOutputStream outputStream = null;
        try {
            InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("Hello.xlass");
            int len;
            outputStream = new ByteArrayOutputStream();
            while ((len = inputStream.read()) != -1) {
                outputStream.write(len);
            }

            byte[] bytes = outputStream.toByteArray();
            for (int i = 0; i < bytes.length; i ++) {
                byte a = bytes[i];
                bytes[i] = (byte) (255 - a);
            }
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return null;
    }
}
