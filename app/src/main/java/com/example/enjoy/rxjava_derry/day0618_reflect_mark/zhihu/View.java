package com.example.enjoy.rxjava_derry.day0618_reflect_mark.zhihu;

/**
 * 静态内部类不会随着外部类的加载而加载 ,只有静态内部类的静态成员被调用时才会进行加载 ,
 * 这样既保证的惰性初始化（Lazy-Initialazation），又由JVM保证了多线程并发访问的正确性。
 */
public class View {
    private OnLongClickListener onLongClickListener;
    private OnClickListener onClickListener;


    public static View getInstance(){
        return Instance.getInstance;
    }

    public static class Instance {
        public static View getInstance = new View();
    }

    public interface OnClickListener {
        void onClick();
    }

    public interface OnLongClickListener {
        void onLongClick();
    }

    public OnLongClickListener getOnLongClickListener() {
        return onLongClickListener;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        defaultRun();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        defaultRun();
    }

    public OnClickListener getOnClickListener() {
        return onClickListener;
    }

    /**
     * 模拟系统调用
     */
    void defaultRun() {
        if (getOnClickListener() != null) {
            getOnClickListener().onClick();
        }
        if (getOnLongClickListener() != null) {
            getOnLongClickListener().onLongClick();
        }
    }

}
