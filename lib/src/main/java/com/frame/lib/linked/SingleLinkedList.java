package com.frame.lib.linked;

public class SingleLinkedList {

    //先初始化一个头节点，头节点不要动j
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode) {

        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        while (temp.next != null) {
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个
        temp.next = heroNode;

    }

    //
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，所以找辅助
        HeroNode temp = head;
        boolean flag = false; //flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode依然存在
                flag = true;
                break;
            }
            temp = temp.next; //后移
        }
        if (flag) { //说明编号存在，不能添加
            System.out.printf("准备插入的英雄的编号%d，已经存在，不能加入", heroNode.no);
            System.out.println("");
        } else {
            //可以插入
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    //修改节点的信息，根据编号来修改，即no编号不能改，
    //说明
    //1.根据newHeroNOde的no来修改
    public void update(HeroNode newHeroNode) {
        HeroNode temp = head;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp.next == null) {
                break;//已经遍历完链表
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } //没有找到
        else {
            System.out.printf("没有找到%d的节点，不能修改\n", newHeroNode.no);
        }

    }

    public void deleteNode(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;//是否找到该节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到该节点，无法删除");
        }


    }


    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            //判断是都到链表最后

            System.out.println(temp);
            temp = temp.next;

        }
    }

}


class SingleLinkedListDemo {

    public static void main(String[] args) {
        //测试
        HeroNode hero1 = new HeroNode(1, "宋江1", "及时雨1");
        HeroNode hero2 = new HeroNode(2, "松江2", "及时雨2");
        HeroNode hero3 = new HeroNode(3, "松江3", "及时雨3");
        HeroNode hero4 = new HeroNode(4, "松江4", "及时雨4");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero3);


        singleLinkedList.list();
        System.out.println("-------");
        HeroNode heroNode5 = new HeroNode(3, "大宋", "大几十");
        singleLinkedList.update(heroNode5);
        singleLinkedList.list();
        System.out.println("------");
        HeroNode heroNode6 = new HeroNode(3, "大宋", "大几十");
        singleLinkedList.deleteNode(heroNode6);
        singleLinkedList.list();

        System.out.println("----");
        System.out.println(getLength(singleLinkedList.getHead()));

        System.out.println("-------");
        System.out.println(findLastIndexNode(singleLinkedList.getHead(),2));

    }


    //将链表进行反转
    public static void reverseList(HeroNode head){
        //没有节点或者只有一个节点
        if (head.next ==null|| head.next.next==null){
            return ;
        }

        //指向当前节点的下一个节点
        HeroNode cur = head.next ;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");

        while (cur!=null){
            next = cur.next ;
        }

    }

    //查找单链表中的倒数第K个节点[新浪面试题]
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }

        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;

    }


    //方法：获取到单链表的节点的个数(如果是带头节点的链表，头节点不需要统计)

    public static int getLength(HeroNode head) {
        int count = 0;
        //带头节点的空链表
        while (head.next != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}


class HeroNode {

    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode(int no, String name, String nickName, HeroNode next) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
