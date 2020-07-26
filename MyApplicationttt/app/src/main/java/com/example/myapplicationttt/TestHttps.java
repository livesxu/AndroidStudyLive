package com.example.myapplicationttt;

import android.util.AndroidException;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.Subject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestHttps {

    private static TestHttps testHttps = null;
    private TestHttps(){}

    private Retrofit retrofit;

    public static TestHttps getInstance() {

        if (testHttps == null) {

            synchronized (TestHttps.class) {

                if (testHttps == null) {

                    testHttps = new TestHttps();
                }
            }
        }
        return testHttps;
    }

    public Retrofit getRetrofit() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://dili.bdatu.com")
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

//            http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html
        }

        return retrofit;
    }

    void requestList(Observer observer) {

        ListRequest listRequest = getRetrofit().create(ListRequest.class);

        Observable<ListModel> observable = listRequest.requestList();

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//主线程
                .subscribe(observer);

    }
}
