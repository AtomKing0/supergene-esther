package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final h9.a<k0> f20961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final h9.a<k0> f20962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final h9.a<k0> f20963c;

    public f() {
        this(null, null, null, 7, null);
    }

    @Nullable
    public final h9.a<k0> a() {
        return this.f20962b;
    }

    @Nullable
    public final h9.a<k0> b() {
        return this.f20963c;
    }

    @Nullable
    public final h9.a<k0> c() {
        return this.f20961a;
    }

    public f(@Nullable h9.a<k0> aVar, @Nullable h9.a<k0> aVar2, @Nullable h9.a<k0> aVar3) {
        this.f20961a = aVar;
        this.f20962b = aVar2;
        this.f20963c = aVar3;
    }

    public /* synthetic */ f(h9.a aVar, h9.a aVar2, h9.a aVar3, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : aVar, (i10 & 2) != 0 ? null : aVar2, (i10 & 4) != 0 ? null : aVar3);
    }
}
