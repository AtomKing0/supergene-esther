package androidx.browser.trusted;

import androidx.annotation.NonNull;
import androidx.concurrent.futures.ResolvableFuture;

/* JADX INFO: loaded from: classes.dex */
class FutureUtils {
    private FutureUtils() {
    }

    @NonNull
    static <T> com.google.common.util.concurrent.m<T> immediateFailedFuture(@NonNull Throwable th) {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        resolvableFutureCreate.setException(th);
        return resolvableFutureCreate;
    }
}
