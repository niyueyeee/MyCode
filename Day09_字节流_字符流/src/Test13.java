import java.io.*;
import java.util.Scanner;

/**
 * @authro niyueyeee
 * @create 2019-01-19 上午 10:52
 */
public class Test13 {
    public static void main(String[] args) throws IOException {
        File dir = new File("D:/ccc");
        System.out.println(IOUtils.getLength(dir));
        Scanner sc = new Scanner(System.in);
        //获取目录
        File srcDir = IOUtils.getDir();
        //获取要复制的文件类型
        System.out.println("请输入要复制的文件的类型: ");
        String type = sc.nextLine();
        System.out.println("你要复制 " + type + " 类型的文件,请输入保存这些文件的目录: ");
        File destDir = IOUtils.getDir();

        IOUtils.copyTypeFiles(srcDir, type, destDir);
    }

    public static void test03() throws IOException {
        //获取源目录
        File srcDir = IOUtils.getDir();
        //获取目标目录
        File destDir = IOUtils.getDir();
        IOUtils.cutDir2Dir(srcDir, destDir);
    }

    //测试copyDir2Dir方法
    public static void test02() throws IOException {
        //获取源目录
        File srcDir = IOUtils.getDir();
        //获取目标目录
        File destDir = IOUtils.getDir();
        IOUtils.copyDir2Dir(srcDir, destDir);
    }

    //测试copyTypeFiles方法
    public static void test01() throws IOException {
        //测试copyTypeFiles方法
        Scanner sc = new Scanner(System.in);
        //获取目录
        File srcDir = IOUtils.getDir();
        //获取要复制的文件类型
        System.out.println("请输入要复制的文件的类型: ");
        String type = sc.nextLine();
        System.out.println("你要复制 " + type + " 类型的文件,请输入保存这些文件的目录: ");
        File destDir = IOUtils.getDir();

        IOUtils.copyTypeFiles(srcDir, type, destDir);
    }

    private static class IOUtils {
        private IOUtils() {

        }

        /*
            3.定义方法,完成指定目录的剪切(包含指定目录中的所有内容),复制后生成的目录格式和源目录一样
         */
        public static void cutDir2Dir(File srcDir, File destDir) throws IOException {
            //1.在目标文件夹中创建原文件夹
            File newDir = new File(destDir, srcDir.getName());
            if (!newDir.exists()) {
                newDir.mkdirs();
            }
            //2.获取原文件夹中所有的文件和文件夹,存储在File数组中
            File[] files = srcDir.listFiles();
            //如果源文件夹中没有内容,直接返回
            if (files == null || files.length == 0) {
                srcDir.delete();
                return;
            }
            //3.遍历数组
            for (File file : files) {
                //4.如果是文件就复制文件
                if (file.isFile()) {
                    //5.如果是文件夹就递归调用
                    copyFile2Dir(file, newDir);
                } else {
                    cutDir2Dir(file, newDir);
                }
            }
            //把文件夹删除
            deleteDir(srcDir);
        }

        /*
            2.定义方法,完成指定目录的复制(包含指定目录中的所有内容),复制后生成的目录格式和源目录一样
         */
        public static void copyDir2Dir(File srcDir, File destDir) throws IOException {
            //1.在目标文件夹中创建原文件夹
            File newDir = new File(destDir, srcDir.getName());
            if (!newDir.exists()) {
                newDir.mkdirs();
            }
            //2.获取原文件夹中所有的文件和文件夹,存储在File数组中
            File[] files = srcDir.listFiles();
            //如果源文件夹中没有内容,直接返回
            if (files == null || files.length == 0) {
                return;
            }
            //3.遍历数组
            for (File file : files) {
                //4.如果是文件就复制文件
                if (file.isFile()) {
                    copyFile2Dir(file, newDir);
                    //5.如果是文件夹就递归调用
                } else {
                    copyDir2Dir(file, newDir);
                }
            }
        }

        /*
            1.定义一个方法,完成指定目录(包含子目录)中指类型定文件的复制,
                还要给出存储该类型文件的目标位置
         */
        public static void copyTypeFiles(File srcDir, String type, File destDir) throws IOException {
            //给定的目标文件夹不存在,则创建
            if (!destDir.exists()) {
                destDir.mkdirs();
            }
            File[] files = srcDir.listFiles();
            //如果源文件夹中没有内容,直接返回
            if (files == null || files.length == 0) {
                return;
            }
            //遍历
            for (File file : files) {
                if (file.isFile()) {
                    //是文件
                    if (file.getName().toLowerCase().endsWith(type.toLowerCase())) {
                        //调用复制文件的方法
                        copyFile2Dir(file, destDir);
                    }
                } else {
                    copyTypeFiles(file, type, destDir);
                }
            }
        }

        /*
            复制文件
            File file: 源文件
            File dir: 存储文件的目录
         */
        public static void copyFile2Dir(File file, File dir) throws IOException {
            InputStream is = new FileInputStream(file);
            byte[] bs = new byte[1024 * 10];
            int len = 0;
            //创建目标文件
            File destFile = new File(dir, file.getName());
            OutputStream os = new FileOutputStream(destFile);
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            is.close();
            os.close();
        }

        //键盘录入获取一个文件夹路径
        public static File getDir() {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一个文件夹路径:");
            while (true) {
                //获取当前输入的字符串
                String strDir = sc.nextLine();
                //将获取的字符串封装成File对象
                File dir = new File(strDir);
                //如果路径不存在
                if (!dir.exists()) {
                    //提示重新录入
                    System.out.println("您输入的路径不存在,请重新输入: ");
                } else {
                    //如果存在,且是目录
                    if (dir.isDirectory()) {
                        //返回目录
                        return dir;
                    }
                    //如果存在,不是目录,提示重新输入
                    System.out.println("您输入的不是文件夹路径,请重新输入: ");
                }
            }
        }

        /*
            删除给定的文件夹dir(包含里面的所有的内容)
         */
        public static boolean deleteDir(File dir) {
            //获取dir目录中的内容
            File[] files = dir.listFiles();
            if (files == null || files.length == 0) {
                //如果dir中没内容,直接删除
                return dir.delete();
            }
            for (File file : files) {
                //如果是文件
                if (file.isFile()) {
                    //删除该文件
                    file.delete();
                }
                //如果是目录
                if (file.isDirectory()) {
                    //递归调用
                    deleteDir(file);
                }
            }
            //当前文件夹中的所有文件都删除后,要把当前文件夹删除
            return dir.delete();
        }

        /*
           获取给定的文件夹dir的长度
        */
        public static long getLength(File dir) {
            long size = 0L;
            //获取dir目录中的内容
            File[] files = dir.listFiles();
            if (files == null) {
                return size;
            }
            for (File file : files) {
                //如果是文件
                if (file.isFile()) {
                    size += file.length();
                } else {
                    //如果是目录
                    size += getLength(file);
                }
            }
            return size;
        }

    }

}