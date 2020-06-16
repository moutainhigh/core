package dom.gupaoedu.vip.pattern.composite.demo.safe;

import java.util.ArrayList;
import java.util.List;

/**
 * 2、树枝节点:定义树枝节点的行为,存储子节点,组合树枝节点和叶子节点形成一个树形结构;
 */
public class Folder extends Directory {
    // 存放同一对象，叶子节点跟节点都要实现Directory
    private List<Directory> dirs;

    // 用level进行标记
    private Integer level;

    public Folder(String name, Integer level) {
        super(name);
        this.level = level;
        this.dirs = new ArrayList<Directory>();
    }

    @Override
    public void show() {
        System.out.println(this.name);
        for (Directory dir : this.dirs) {
            //控制显示格式
            if (this.level != null) {
                for (int i = 0; i < this.level; i++) {
                    //打印空格控制格式
                    System.out.print("  ");
                }
                for (int i = 0; i < this.level; i++) {
                    //每一行开始打印一个+号
                    if (i == 0) {
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            //打印名称
            dir.show();
        }
    }

    public boolean add(Directory dir) {
        return this.dirs.add(dir);
    }

    public boolean remove(Directory dir) {
        return this.dirs.remove(dir);
    }

    public Directory get(int index) {
        return this.dirs.get(index);
    }

    public void list() {
        for (Directory dir : this.dirs) {
            System.out.println(dir.name);
        }
    }

}