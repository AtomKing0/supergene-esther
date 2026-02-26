package com.moloco.sdk.internal.services.init;

import android.content.SharedPreferences;
import androidx.annotation.VisibleForTesting;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f18735a = a.f18736a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f18736a = new a();

        @NotNull
        public final f a(@NotNull SharedPreferences sharedPreferences) {
            t.i(sharedPreferences, "sharedPreferences");
            return new g(sharedPreferences, com.moloco.sdk.internal.scheduling.c.a().getIo(), com.moloco.sdk.acm.a.f17293a);
        }
    }

    @VisibleForTesting(otherwise = 5)
    @Nullable
    Object a(@NotNull z8.d<? super k0> dVar);

    @Nullable
    Object b(@NotNull com.moloco.sdk.internal.services.init.a aVar, @NotNull z8.d<? super com.moloco.sdk.i> dVar);

    @Nullable
    Object c(@NotNull com.moloco.sdk.internal.services.init.a aVar, @NotNull com.moloco.sdk.i iVar, @NotNull z8.d<? super k0> dVar);

    @Nullable
    Object d(@NotNull com.moloco.sdk.internal.services.init.a aVar, @NotNull z8.d<? super k0> dVar);
}
