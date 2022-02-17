package io.github.liuziyuan.retrofit.samples.retrofitbuilder.api;

import io.github.liuziyuan.retrofit.extension.BaseOkHttpClientBuilder;
import okhttp3.OkHttpClient;

import java.time.Duration;

/**
 * @author liuziyuan
 */
public class OkHttpClientBuilder extends BaseOkHttpClientBuilder {
    @Override
    public OkHttpClient.Builder buildOkHttpClientBuilder(OkHttpClient.Builder builder) {
        return builder.connectTimeout(Duration.ofMillis(30000));
    }
}
