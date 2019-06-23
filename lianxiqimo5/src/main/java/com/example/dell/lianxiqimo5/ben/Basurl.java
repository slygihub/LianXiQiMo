package com.example.dell.lianxiqimo5.ben;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Basurl {
    String url="http://www.qubaobei.com/ios/cf/";
    @GET("dish_list.php?page=1&stage_id=1&limit=20")
    Observable<Bean>getdata();
}
