package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s;
import java.util.Comparator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements Comparator<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f20114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Long f20115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Integer f20116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final Integer f20117d;

    public b(double d10, @Nullable Long l10, @Nullable Integer num, @Nullable Integer num2) {
        this.f20114a = d10;
        this.f20115b = l10;
        this.f20116c = num;
        this.f20117d = num2;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(@NotNull s mf1, @NotNull s mf2) {
        t.i(mf1, "mf1");
        t.i(mf2, "mf2");
        v8.s sVarS = i.s(mf1, mf2, this.f20114a, this.f20115b, this.f20116c, this.f20117d);
        return t.k(((Number) sVarS.b()).intValue(), ((Number) sVarS.a()).intValue());
    }
}
