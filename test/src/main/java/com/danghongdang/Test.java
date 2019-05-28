package com.danghongdang;

/**
 * Created by danghongdang on 16-7-12.
 */
public class Test {

    public static void main(String args[]) {
        String a = "1";
        String sql = "1111" + a;
    }
    
    //    public static void main(String[] args) {
//        DataInputStream dis = null;
//        DataOutputStream dos = null;
//        try {
//            File inFile = new File("/Users/zhanghongzhang/Downloads/26136982-_-_128-_-_19548b2f2bca1e0e62becd274520c89f.uc!");
//            File outFile = new File("/Users/zhanghongzhang/Downloads/1.mp3");
//
//            dis = new DataInputStream(new FileInputStream(inFile));
//            dos = new DataOutputStream(new FileOutputStream(outFile));
//            byte[] b = new byte[1024];
//            int len;
//            while ((len = dis.read(b)) != -1) {
//                for (int i = 0; i < len; i++) {
//                    b[i] ^= 0xa3;
//                }
//                dos.write(b, 0, len);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (dos != null) {
//                try {
//                    dos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (dis != null) {
//                try {
//                    dis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
