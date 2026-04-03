package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.m;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoroutineAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CoroutineAdapterKt {
    @NotNull
    public static final <T> m<T> asListenableFuture(@NotNull final v0<? extends T> v0Var, @Nullable final Object obj) {
        t.i(v0Var, "<this>");
        m<T> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.privacysandbox.ads.adservices.java.internal.a
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return CoroutineAdapterKt.asListenableFuture$lambda$0(v0Var, obj, completer);
            }
        });
        t.h(future, "getFuture { completer ->…        }\n    }\n    tag\n}");
        return future;
    }

    public static /* synthetic */ m asListenableFuture$default(v0 v0Var, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return asListenableFuture(v0Var, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object asListenableFuture$lambda$0(v0 this_asListenableFuture, Object obj, CallbackToFutureAdapter.Completer completer) {
        t.i(this_asListenableFuture, "$this_asListenableFuture");
        t.i(completer, "completer");
        this_asListenableFuture.J(new CoroutineAdapterKt$asListenableFuture$1$1(completer, this_asListenableFuture));
        return obj;
    }
}
