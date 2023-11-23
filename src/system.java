import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class system {
    public static void main(String[] args) {
        ArrayList<STUDENT>list = new ArrayList<>();
        loop:while (true) {
            //开局设置
            String title="学生管理";
            int totalWidth = 50; // 总宽度，根据需要调整
            int textWidth = title.length();
            int padding = (totalWidth - textWidth) / 2;
            //开局界面
            System.out.println("-".repeat(padding)+title+"-".repeat(padding));


            String[] options = {
                    "Option 1: 增加学生",
                    "Option 2: 删除学生",
                    "Option 3: 修改学生",
                    "Option 4: 查询学生",
                    "Option 5: 退出",
            };
            // 输出所有选项
            for (int i = 0; i < options.length; i++) {
                System.out.println(options[i]);
            }
            System.out.println("选择你的要求：");
            //用户选项
            Scanner sc= new Scanner(System.in);
            String choose=sc.next();
            switch (choose){
                case "1"->addS(list);
                case "2"->deleteS(list);
                case "3"->updateS(list);
                case "4"->findS(list);
                case "5"->{
                    System.out.println("退出");
                    break loop;
                }
                default->System.out.println("选项错误");
            }
        }

    }
    ArrayList<STUDENT> list = new ArrayList<>();

    //添加学生
    public static void addS(ArrayList<STUDENT> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入id");
        String id = sc.next();
        System.out.println("输入姓名");
        String name = sc.next();
        //创建STUDENT类来导入到list列表里面
        STUDENT stu = new STUDENT(id,name);
        //判断id是否唯一
        if(containID(list,id)){
            System.out.println("id已经存在！");
            return;
        }
        list.add(stu);
        System.out.println("添加成功！");
    }
    //删除
    public static void deleteS(ArrayList<STUDENT> list){
        System.out.println("选择要删除的学生id：");
        Scanner sc = new Scanner(System.in);
        String id =sc.next();
        if(containID(list,id)){
            System.out.println("删除成功");
            for (int i = 0; i < list.size(); i++) {
                if (containID(list,id)){
                    list.remove(i);
                    return;
                }
            }
        }else {
            System.out.println("id不存在");
        }
    }
    //修改
    public static void updateS(ArrayList<STUDENT> list){
        System.out.println("输入要修改的学生id：");
        Scanner sc=new Scanner(System.in);
        String id = sc.next();
        if(containID(list,id)){
            System.out.println("输入你要修改后的名字：");
            String name = sc.next();
            for (int i = 0; i < list.size(); i++) {
                if(containID(list,id)){
                    STUDENT stu = list.get(i);
                    stu.setName(name);
                    System.out.println("修改成功");
                    return;
                }
            }
        }else {
            System.out.println("不存在！");
        }
    }
    //查询
    public static void findS(ArrayList<STUDENT> list){
        if(list.size()==0){
            System.out.println("没有学生信息！");
            return;
        }
        System.out.println("id\t\t姓名");
        for (int i = 0; i < list.size(); i++) {
            //新建stu get来遍历list里面的内容
            STUDENT stu = list.get(i);
            //输出学生信息
            System.out.println(stu.getId()+"\t"+"\t"+stu.getName());
        }
    }
    //判断id唯一
    public static boolean containID(ArrayList<STUDENT>list,String id){
        for (int i = 0; i < list.size(); i++) {
            STUDENT s= list.get(i);
            String stuID = s.getId();
            if(stuID.equals(id)){
                return true;
            }
        }
        return false;
    }
}