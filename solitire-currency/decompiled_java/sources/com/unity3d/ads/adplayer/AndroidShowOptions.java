package com.unity3d.ads.adplayer;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidShowOptions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidShowOptions implements ShowOptions {

    @NotNull
    private final Context context;

    @Nullable
    private final Map<String, Object> unityAdsShowOptions;

    public AndroidShowOptions(@NotNull Context context, @Nullable Map<String, ? extends Object> map) {
        t.i(context, "context");
        this.context = context;
        this.unityAdsShowOptions = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AndroidShowOptions copy$default(AndroidShowOptions androidShowOptions, Context context, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            context = androidShowOptions.context;
        }
        if ((i10 & 2) != 0) {
            map = androidShowOptions.unityAdsShowOptions;
        }
        return androidShowOptions.copy(context, map);
    }

    @NotNull
    public final Context component1() {
        return this.context;
    }

    @Nullable
    public final Map<String, Object> component2() {
        return this.unityAdsShowOptions;
    }

    @NotNull
    public final AndroidShowOptions copy(@NotNull Context context, @Nullable Map<String, ? extends Object> map) {
        t.i(context, "context");
        return new AndroidShowOptions(context, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidShowOptions)) {
            return false;
        }
        AndroidShowOptions androidShowOptions = (AndroidShowOptions) obj;
        return t.d(this.context, androidShowOptions.context) && t.d(this.unityAdsShowOptions, androidShowOptions.unityAdsShowOptions);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final Map<String, Object> getUnityAdsShowOptions() {
        return this.unityAdsShowOptions;
    }

    public int hashCode() {
        int iHashCode = this.context.hashCode() * 31;
        Map<String, Object> map = this.unityAdsShowOptions;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    @NotNull
    public String toString() {
        return "AndroidShowOptions(context=" + this.context + ", unityAdsShowOptions=" + this.unityAdsShowOptions + ')';
    }
}
