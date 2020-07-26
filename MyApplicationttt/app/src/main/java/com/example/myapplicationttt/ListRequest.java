package com.example.myapplicationttt;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ListRequest {

    @GET("/jiekou/mains/p1.html")
    Observable<ListModel> requestList();
}
