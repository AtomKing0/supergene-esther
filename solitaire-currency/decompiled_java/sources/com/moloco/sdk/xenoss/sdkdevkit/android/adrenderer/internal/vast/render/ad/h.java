package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.p;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public List<String> f20819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public List<String> f20820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final List<String> f20821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final n f20822d;

    public h(@Nullable List<String> list, @Nullable List<String> list2, @Nullable List<String> list3, @NotNull n vastTracker) {
        t.i(vastTracker, "vastTracker");
        this.f20819a = list;
        this.f20820b = list2;
        this.f20821c = list3;
        this.f20822d = vastTracker;
    }

    public final void a() {
        List<String> list = this.f20820b;
        if (list != null) {
            n.a.a(this.f20822d, list, null, null, null, 14, null);
            this.f20820b = null;
        }
    }

    public final void b(@Nullable z zVar) {
        List<String> list = this.f20821c;
        if (list != null) {
            n.a.a(this.f20822d, list, zVar, null, null, 12, null);
        }
    }

    public final boolean c() {
        List<String> list = this.f20819a;
        if (list == null) {
            return false;
        }
        n.a.a(this.f20822d, list, null, null, null, 14, null);
        this.f20819a = null;
        return true;
    }

    public /* synthetic */ h(List list, List list2, List list3, n nVar, int i10, kotlin.jvm.internal.k kVar) {
        this(list, list2, list3, (i10 & 8) != 0 ? p.a() : nVar);
    }
}
