package io.github.liuziyuan.retrofit.spring.boot.web.samples.api;

import com.google.common.util.concurrent.ListenableFuture;
import io.github.liuziyuan.retrofit.core.annotation.InterceptorType;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitBuilder;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitInterceptor;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitUrlPrefix;
import io.github.liuziyuan.retrofit.spring.boot.web.samples.domain.HelloBean;
import io.reactivex.rxjava3.core.Observable;
import okhttp3.ResponseBody;
import reactor.core.publisher.Mono;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Path;

import java.util.concurrent.CompletableFuture;

/**
 * <p><b>Base URLs should always end in {@code /}.</b>
 * <p><b>Endpoint values which contain a leading {@code /} are absolute.</b>
 *
 * @author liuziyuan
 */

// use @RetrofitUrlPrefix
@RetrofitBuilder(baseUrl = "${app.url.host}")
@RetrofitUrlPrefix("${app.url.prefix}")
public interface HelloApi {
    /**
     * call hello API method of backend service
     *
     * @param message message
     * @return
     */
    @GET("hello/{message}")
    Mono<HelloBean> hello(@Path("message") String message);

    @GET("hello/{message}")
    Observable<HelloBean> hello2(@Path("message") String message);

}