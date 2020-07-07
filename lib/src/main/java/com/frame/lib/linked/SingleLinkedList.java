package com.frame.lib.linked;

public class SingleLinkedList {

    //先初始化一个头节点，头节点不要动j
    private HeroNode head = new HeroNode(0,"","");

    public void add(HeroNode heroNode){

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


    public void list(){
        if (head.next==null){
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


class SingleLinkedListDemo{

    public static void main(String[] args) {
        //测试
        HeroNode hero1 = new HeroNode(1,"宋江1","及时雨");
        HeroNode hero2 = new HeroNode(1,"松江2","及时雨");
        HeroNode hero3 = new HeroNode(1,"松江3","及时雨");
        HeroNode hero4 = new HeroNode(1,"松江4","及时雨");
        HeroNode hero5 = new HeroNode(1,"松江5","及时雨");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero5);

        singleLinkedList.list();

    }

}



class HeroNode{

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
