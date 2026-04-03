package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final a0 f20836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f20839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final List<String> f20840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final List<String> f20841f;

    public c(@NotNull a0 resource, int i10, int i11, @Nullable String str, @NotNull List<String> clickTracking, @NotNull List<String> creativeViewTracking) {
        t.i(resource, "resource");
        t.i(clickTracking, "clickTracking");
        t.i(creativeViewTracking, "creativeViewTracking");
        this.f20836a = resource;
        this.f20837b = i10;
        this.f20838c = i11;
        this.f20839d = str;
        this.f20840e = clickTracking;
        this.f20841f = creativeViewTracking;
    }

    @Nullable
    public final String a() {
        return this.f20839d;
    }

    @NotNull
    public final List<String> b() {
        return this.f20840e;
    }

    @NotNull
    public final List<String> c() {
        return this.f20841f;
    }

    public final int d() {
        return this.f20838c;
    }

    @NotNull
    public final a0 e() {
        return this.f20836a;
    }

    public final int f() {
        return this.f20837b;
    }
}
