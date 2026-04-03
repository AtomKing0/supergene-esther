package io.sentry.android.core.util;

import android.content.Context;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidLazyEvaluator.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private volatile T f27537a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final InterfaceC0581a<T> f27538b;

    /* JADX INFO: renamed from: io.sentry.android.core.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AndroidLazyEvaluator.java */
    public interface InterfaceC0581a<T> {
        @Nullable
        T a(@NotNull Context context);
    }

    public a(@NotNull InterfaceC0581a<T> interfaceC0581a) {
        this.f27538b = interfaceC0581a;
    }

    @Nullable
    public T a(@NotNull Context context) {
        if (this.f27537a == null) {
            synchronized (this) {
                if (this.f27537a == null) {
                    this.f27537a = this.f27538b.a(context);
                }
            }
        }
        return this.f27537a;
    }
}
