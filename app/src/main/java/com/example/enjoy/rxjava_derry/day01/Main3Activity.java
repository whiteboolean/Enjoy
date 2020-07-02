package com.example.enjoy.rxjava_derry.day01;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.enjoy.R;
import com.example.enjoy.databinding.ActivityMain3Binding;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class Main3Activity extends AppCompatActivity {

    private static final String TAG = "Main3Activity";
    private MyViewModel myViewModel;
    private ActivityMain3Binding binding;
    private ProgressBar progressBar;
    private ProgressDialog progressDialog;
    private static final String PATH = "http://img1.imgtn.bdimg.com/it/u=691908199,4002570274&fm=26&gp=0.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main3);
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);



        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                requestNetToUpdateImage();
//                rxTest();
                startActivity(new Intent(Main3Activity.this,MainActivity.class));
            }
        });


//        RxJavaPlugins.onAssembly(new Observable<Object>() {
//            @Override
//            protected void subscribeActual(Observer<? super Object> observer) {
//
//            }
//        });


    }



    /**
     * e: 发射器
     */

    private void rxTest() {



        Runnable runnable= new Runnable() {
            @Override
            public void run() {

            }
        };

        new Thread(runnable).start();

       Handler handler = new Handler();
       Message message = Message.obtain(handler,runnable);
       handler.sendMessage(message);





        Observable.just("1") //返回ObserverJust
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {

                        return s + "1";
                    }
                }).map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return "s";
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("第一个调用");
            }

            @Override
            public void onNext(String s) {
                System.out.println("next");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        }).start();


        //1.ObservableOnSubscribe
        ObservableOnSubscribe<String> observableOnSubscribe = new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("111");
            }
        };
        //2.function1
        Function<String, Integer> function1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                return null;
            }
        };
        //3.function2
        Function<Integer, String> function2 = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return null;
            }
        };

        //4.自定义 观察者
        Observer<Object> observer = new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "1.自定义观察者:new Observer()---onSubscribe()方法被调用");
            }

            @Override
            public void onNext(Object o) {
                Log.e(TAG, "4.自定义观察者:new Observer() ---onNext()方法被调用");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "5.自定义观察者:new Observer() ---onError()方法被调用");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "6.自定义观察者:new Observer() ---onComplete()方法被调用");
            }
        };


        Observable
                //new ObservableCreate<T>(source = observableOnSubscribe)
                .create(observableOnSubscribe)

                //返回new ObservableMap<T, R>(this, mapper)
                //1.this 就是 上面的new ObservableCreate<T>(source = observableOnSubscribe)
                //2.mapper = function1
                .map(function1) //即返回 new ObservableMap<T,R>(new ObservableCreate<T>(source),function1) --- 后面用"包裹A1[o]"代替

                //new ObservableMap<T,R>(this,mapper)
                //1.this 就是 上面的new Observable<T，R>(new ObservableCreate<T>(source = observableOnSubscribe) ,function1)
                //2.mapper = function2
                .map(function2)//即返回new ObservableMap<T,R>(new Observable<T，R>(new ObservableCreate<T>(source = observableOnSubscribe) ,function1),function2)-- 后面用"包裹A2[A1[o]]"代替

                //observer1 -- 自定义观察者 ，subscribe(observer) 有且只能有一个观察者
                .subscribe(observer);    //执行了 上面的 subscribeActual(observer) 方法

        //总结 --- 从上到下， 一步一步的打包包裹，打到最后一个observer


        /**
         *
         *
         * 下面来继续分析代码执行流程
         * 第一步就是打包裹，从上至下一层一层打包
         * 第二步从下往上来进行方法的执行分析
         * 来看打通整个流程的关键方法 ： subscribe(observer)方法 ，调用者为包裹A2[A1[o]]
         *
         * A2[A1[o]].subscribe(observer) --- >  A2[A1[o]].subscribeActual(observer)
         *
         * 这句代码实际调用的是上面对象A2[A1[o]] --- > 即new Observable<T，R>(new ObservableCreate<T>(source = observableOnSubscribe) ,function2)的实际订阅的方法
         *      @Override
         *         public void subscribeActual(Observer<? super U> t) {
         *              source.subscribe(new MapObserver<T, U>(t, function));
         *         }
         *         这里对参数进行一下解读 ：
         *         1.source是上一层包裹即 A1[o] = new ObservableMap<T,R>(new ObservableCreate<T>(source),function1)
         *         2.t即下一层的自定义观察者 = observer
         *         3.function 即为 我们自定义的function2
         *         4.总结：通过map操作符，把上层调用者订阅到 含有下层和当前层方法的一个 ObservableMap对象
         *
         *  source.subscribe(new MapObserver<T, U>(t, function))
         *  = A1[o].subscribe(new MapObserver<T,U>(t,function))
         *  = new ObservableMap<T,R>(new ObservableCreate<T>(source),function1).subscribe(new MapObserver<T,U>(t,function))
         *
         *  subscribeActual => A1[o].subscribe(new MapObserver<T,U>(observer,function2))
         *
         *
         *  这个方法会执行到上一层的实际订阅方法
         *      @Override
         *         public void subscribeActual(Observer<? super U> t) {
         *              source.subscribe(new MapObserver<T, U>(t, function));
         *         }
         *         参数解读：
         *         1.source是上一层的包裹即[o] = new ObservableCreate<T>(source = observableOnSubscribe)
         *         2.t即为了下一层的包装观察者对象
         *           t = new MapObserver<T,U>(observer,function2) ---
         *         3.function即为当前map的function1
         *
         *
         *   source.subscribe(new MapObserver<T,U>(new ObservableCreate<T>(source = observableOnSubscribe))
         *    = o.subscribe(new MapObserver<T,U>(new MapObserver<T,U>(observer,function2)),function1)
         *     = new ObservableCreate<T>(source = observableOnSubscribe).subscribe(new MapObserver<T,U>(new MapObserver<T,U>(observer,function2)),function1)
         *
         *
         *   继续分析
         *   这个方法会调用上一层的实际订阅方法
         *       @Override
         *     protected void subscribeActual(Observer<? super T> observer) {
         *         CreateEmitter<T> parent = new CreateEmitter<T>(observer);
         *         observer.onSubscribe(parent);
         *
         *         try {
         *             source.subscribe(parent);
         *         } catch (Throwable ex) {
         *             Exceptions.throwIfFatal(ex);
         *             parent.onError(ex);
         *         }
         *     }
         *
         *    参数分析：
         *    1.source是observableOnSubscribe - 即我们自定义的source
         *    2.observe : 即上一层subscribe()括号里面的参数  == new MapObserver<T,U>(new MapObserver<T,U>(observer,function2)),function1)
         *    3.****这里会触发我们的第一个方法！！！observer.onSubscribe(parent)
         *    4.parent = new CreateEmitter<T>(observer);
         *    5.source.subscribe(parent)  --->ObservableOnSubscribe.subscribe(new CreateEmitter<T>(new MapObserver<T,U>(observer,function2)),function1))
         *    6.这样就走到了我们第一个发射器 的onNext方法
         *
         *  继续分析
         *      自定义source
         *      public void subscribe(ObservableEmitter<String> e) throws Exception {
         *                 e.onNext("111");
         *             }
         *       e.onNext("11") 中的observableEmitter是个接口，e.onNext()方法要在他的实现类里面调用
         *        --->
         *           @Override
         *         public void onNext(T t) {
         *             if (t == null) {
         *                 onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
         *                 return;
         *             }
         *             if (!isDisposed()) {
         *                 observer.onNext(t);
         *             }
         *         }
         *      参数：
         *      1.observer : 即上一层subscribe()括号里面的参数 == new MapObserver<T,U>(new MapObserver<T,U>(observer,function2)),function1)
         *      2.new MapObserver<T,U>(new MapObserver<T,U>(observer,function2)),function1).onNext()
         *      3.MapObserver里面会调用 function1.onNext方法
         *      4.function2.onNext方法
         *      5.observer.onNext方法
         *      6.一层一层解包 最后会调用到Observer的onNext方法
         *
         *      总结 ：
         *      1.两次打包的过程
         *      2.第一次把上一个对象通过new ObserverXXX()
         *      [Observable.create() -- > return new ObservableCreate() ,包裹1
         *      Observable.create().map() -- > return new ObservableMap(包裹1) , 包裹2
         *      Observable.create().map().subscribeOn() --- > return new ObservableSubscribeOn(包裹2) , 包裹3
         *      Observable.create().map().subscribeOn().onObserver() --- > return new ObservableObserverOn(包裹3) ，包裹4
         *      ]进行打包，然后先输出自定义观察者的onSubscribe方法将上下游部分进行关联
         *
         *      3.然后第二次分别调用每一个上面包裹的subscribeActual方法，从下往上再次打包每一个 new MapObservable()
         *      4.r
         *
         *
         *
         *
         */

    }


    private void rxTest2() {

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });

        Observable.just("a,", "b", "c")
                .map(new Function<String, Observable<String>>() {
                    @Override
                    public Observable<String> apply(String s) throws Exception {
//                        return Observable.fromIterable(s);
                        return null;
                    }
                }).subscribe(new Consumer<Observable<String>>() {
            @Override
            public void accept(Observable<String> stringObservable) throws Exception {

            }
        }).isDisposed();
    }


    public final static <UD> ObservableTransformer<UD, UD> rxud() {
        return new ObservableTransformer<UD, UD>() {
            @Override
            public ObservableSource<UD> apply(Observable<UD> upstream) {
                Observable<UD> udObservable = upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
//                    udObservable.map(new Function<UD, UD>() {
//                        @Override
//                        public UD apply(UD ud) throws Exception {
//                            return null;
//                        }
//                    });
                return udObservable;
            }
        };
    }

    private void rxRequestNetToUpdateImage() {
        //起点
        Observable.just(PATH)
                .map(new Function<String, Bitmap>() {
                    @Override
                    public Bitmap apply(String s) throws Exception {
                        URL uri = new URL(PATH);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) uri.openConnection();
                        httpURLConnection.setConnectTimeout(5000);
                        int code = httpURLConnection.getResponseCode();
                        if (code == HttpURLConnection.HTTP_OK) {
                            InputStream inputStream = httpURLConnection.getInputStream();
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            return bitmap;
                        }
                        return null;
                    }
                })
                .map(new Function<Bitmap, Bitmap>() {
                    @Override
                    public Bitmap apply(Bitmap bitmap) throws Exception {
                        Bitmap bitmap1 = addTextWatermark(bitmap, "添加一个水印", 40, Color.RED, 10, 10, false, false);
                        return bitmap1;
                    }
                })
//                .map(new Function<Bitmap, Bitmap>() {
//                    @Override
//                    public Bitmap apply(Bitmap bitmap) throws Exception {
//                        Log.e(TAG, "添加一个日志");
//                        return null;
//                    }
//                })
//                .subscribeOn(Schedulers.io())
////                .observeOn(AndroidSchedulers.mainThread())
                .compose(Main3Activity.rxud())
                //终点
                .subscribe(new Observer<Bitmap>() {
                    //订阅开始
                    @Override
                    public void onSubscribe(Disposable d) {
                        progressDialog = new ProgressDialog(Main3Activity.this);
                        progressDialog.setTitle("更新图片中");
                        progressDialog.show();
                    }

                    //下一步
                    @Override
                    public void onNext(Bitmap s) {
                        binding.imageView.setImageBitmap(s);
                    }

                    //
                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        progressDialog.dismiss();
                    }
                });
    }


    /**
     * 给一张Bitmap添加水印文字。
     *
     * @param bitmap       源图片
     * @param content      水印文本
     * @param textSize     水印字体大小 ，单位pix。
     * @param color        水印字体颜色。
     * @param x            起始坐标x
     * @param y            起始坐标y
     * @param positionFlag 居左/居右
     * @param recycle      是否回收
     * @return 已经添加水印后的Bitmap。
     */
    public static Bitmap addTextWatermark(Bitmap bitmap, String content, int textSize, int color, float x, float y, boolean positionFlag, boolean recycle) {
        if (isEmptyBitmap(bitmap) || content == null)
            return null;
        Bitmap ret = bitmap.copy(bitmap.getConfig(), true);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Canvas canvas = new Canvas(ret);
        paint.setColor(color);
        paint.setTextSize(textSize);
        Rect bounds = new Rect();
        paint.getTextBounds(content, 0, content.length(), bounds);
        canvas.drawText(content, bitmap.getWidth() - x - bounds.width() - bounds.left, bitmap.getHeight() - bounds.height() - bounds.top - y, paint);

        if (positionFlag) {
            canvas.drawText(content, x, bitmap.getHeight() - bounds.height() - bounds.top - y, paint);

        } else {
            canvas.drawText(content, bitmap.getWidth() - x - bounds.width() - bounds.left, bitmap.getHeight() - bounds.height() - bounds.top - y, paint);

        }
        if (recycle && !bitmap.isRecycled())
            bitmap.recycle();
        return ret;
    }

    /**
     * Bitmap对象是否为空。
     */
    public static boolean isEmptyBitmap(Bitmap src) {
        return src == null || src.getWidth() == 0 || src.getHeight() == 0;
    }


    private void requestNetToUpdateImage() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("更新图片中");
        progressDialog.show();

        new Thread(() -> {
            try {
                URL uri = new URL(PATH);
                HttpURLConnection httpURLConnection = (HttpURLConnection) uri.openConnection();
                httpURLConnection.setConnectTimeout(5000);
                int code = httpURLConnection.getResponseCode();
                if (code == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    Message message = handler.obtainMessage();
                    message.obj = bitmap;
                    handler.sendMessage(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            Bitmap bitmap = (Bitmap) msg.obj;
            binding.imageView.setImageBitmap(bitmap);
            progressDialog.dismiss();
            return false;
        }
    });
}
