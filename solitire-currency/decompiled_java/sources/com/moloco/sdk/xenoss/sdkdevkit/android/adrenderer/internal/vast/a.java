package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import java.util.Comparator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.s;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Comparator<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Integer f20112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Integer f20113b;

    public a(@Nullable Integer num, @Nullable Integer num2) {
        this.f20112a = num;
        this.f20113b = num2;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g c12, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g c22) {
        t.i(c12, "c1");
        t.i(c22, "c2");
        s sVarV = i.v(c12, c22, this.f20112a, this.f20113b);
        return t.k(((Number) sVarV.b()).intValue(), ((Number) sVarV.a()).intValue());
    }
}
