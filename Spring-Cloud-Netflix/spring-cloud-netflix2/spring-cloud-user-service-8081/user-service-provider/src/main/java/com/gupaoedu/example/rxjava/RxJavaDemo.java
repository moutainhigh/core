package com.gupaoedu.example.rxjava;

import rx.Observable;
import rx.Observer;
import rx.functions.Action0;
import rx.functions.Func0;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class RxJavaDemo {

    // ReactiveX Java  响应式编程框架(android）
    // Java stream() java8
    //观察者模式
    public static void main(String[] args) {
        final String[] datas=new String[]{"登录","进入课堂","上课","答疑"};

        final Action0 onComplated=new Action0() {
            @Override
            public void call() {
                System.out.println("on Complated");
            }
        };
        //老师（被观察者）
        Observable<String> observable=Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                Observable observable1=Observable.from(datas);
                return observable1.doOnCompleted(onComplated);
            }
        });
        //学生(观察者)
        Observer observer=new Observer() {
            @Override
            public void onCompleted() {
                System.out.println("Observer: onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Observer: onError");
            }

            @Override
            public void onNext(Object o) {
                System.out.println("on Next:"+o);
            }
        };
        observable.subscribe(observer); //建立订阅关系

        observable.toBlocking().toFuture(); //建立订阅关系
    }
}
