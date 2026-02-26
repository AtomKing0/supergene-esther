package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class xq implements kg {
    @Override // com.ironsource.kg
    public void a(@NotNull Context context, @NotNull String key, int i10) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(key, "key");
        IronSourceUtils.saveIntToSharedPrefs(context, key, i10);
    }

    @Override // com.ironsource.kg
    public int b(@NotNull Context context, @NotNull String key, int i10) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(key, "key");
        return IronSourceUtils.getIntFromSharedPrefs(context, key, i10);
    }

    @Override // com.ironsource.kg
    public void a(@NotNull Context context, @NotNull String key, long j10) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(key, "key");
        IronSourceUtils.saveLongToSharedPrefs(context, key, j10);
    }

    @Override // com.ironsource.kg
    public long b(@NotNull Context context, @NotNull String key, long j10) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(key, "key");
        return IronSourceUtils.getLongFromSharedPrefs(context, key, j10);
    }
}
