package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.p;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public List<String> f21353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public List<String> f21354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final n f21355c;

    public b(@Nullable List<String> list, @Nullable List<String> list2, @NotNull n vastTracker) {
        t.i(vastTracker, "vastTracker");
        this.f21353a = list;
        this.f21354b = list2;
        this.f21355c = vastTracker;
    }

    public final void a(@Nullable Integer num, @Nullable String str) {
        List<String> list = this.f21353a;
        if (list != null) {
            this.f21355c.a(list, null, num, str);
            this.f21353a = null;
        }
    }

    public final void b(@Nullable Integer num, @Nullable String str) {
        List<String> list = this.f21354b;
        if (list != null) {
            this.f21355c.a(list, null, num, str);
            this.f21354b = null;
        }
    }

    public /* synthetic */ b(List list, List list2, n nVar, int i10, kotlin.jvm.internal.k kVar) {
        this(list, list2, (i10 & 4) != 0 ? p.a() : nVar);
    }
}
