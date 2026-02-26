package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final x f21624a = new x();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Map<Integer, i> f21625b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21626c = 8;

    public final int a(@NotNull i wv) {
        kotlin.jvm.internal.t.i(wv, "wv");
        int iHashCode = wv.hashCode();
        f21625b.put(Integer.valueOf(iHashCode), wv);
        return iHashCode;
    }

    public final void c(int i10) {
        f21625b.remove(Integer.valueOf(i10));
    }
}
