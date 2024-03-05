package io.github.liuziyuan.retrofit.samples.global.config.api;

import io.github.liuziyuan.retrofit.core.annotation.InterceptorType;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitBuilder;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitInterceptor;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitUrlPrefix;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * <p><b>Base URLs should always end in {@code /}.</b>
 * <p><b>Endpoint values which contain a leading {@code /} are absolute.</b>
 *
 * @author liuziyuan
 */

// use @RetrofitUrlPrefix
@RetrofitBuilder(baseUrl = "${app.url.host}")
@RetrofitInterceptor(handler = LoggingInterceptor.class, type = InterceptorType.NETWORK)
@RetrofitUrlPrefix("${app.url.prefix}")
public interface HelloApi {
    /**
     * call hello API method of backend service
     *
     * @param message message
     * @return
     */
    @GET("hello/{message}")
    Call<HelloBean> hello(@Path("message") String message);



}
