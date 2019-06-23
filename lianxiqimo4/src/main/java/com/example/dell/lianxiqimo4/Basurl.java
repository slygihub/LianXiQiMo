package com.example.dell.lianxiqimo4;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Basurl {
    String url="http://www.qubaobei.com/ios/cf/";
    @GET("dish_list.php?page=1&stage_id=1&limit=20")
    Observable<Ben>getData();
}
