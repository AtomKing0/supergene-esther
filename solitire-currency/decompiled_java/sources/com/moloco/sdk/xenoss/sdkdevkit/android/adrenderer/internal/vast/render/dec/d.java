package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.p;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f21276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public List<String> f21277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public List<String> f21278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public List<String> f21279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final i f21280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final n f21281f;

    public d(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @Nullable List<String> list, @Nullable List<String> list2, @Nullable List<String> list3, @NotNull i buttonTracker, @NotNull n vastTracker) {
        t.i(customUserEventBuilderService, "customUserEventBuilderService");
        t.i(buttonTracker, "buttonTracker");
        t.i(vastTracker, "vastTracker");
        this.f21276a = customUserEventBuilderService;
        this.f21277b = list;
        this.f21278c = list2;
        this.f21279d = list3;
        this.f21280e = buttonTracker;
        this.f21281f = vastTracker;
    }

    public final void a() {
        List<String> list = this.f21278c;
        if (list != null) {
            n.a.a(this.f21281f, list, null, null, null, 14, null);
            this.f21278c = null;
        }
    }

    public final void b(@NotNull a.AbstractC0481a.c.EnumC0483a buttonType) {
        t.i(buttonType, "buttonType");
        this.f21280e.j(buttonType);
    }

    public final void c(@NotNull a.AbstractC0481a.c button) {
        t.i(button, "button");
        this.f21280e.g(button);
    }

    public final void d(@NotNull a.AbstractC0481a.f position) {
        t.i(position, "position");
        List<String> list = this.f21277b;
        if (list != null) {
            n.a.b(this.f21281f, list, null, null, null, this.f21280e.p(), this.f21276a, position, 14, null);
            this.f21277b = null;
        }
    }

    public final void e() {
        List<String> list = this.f21279d;
        if (list != null) {
            n.a.a(this.f21281f, list, null, null, null, 14, null);
            this.f21279d = null;
        }
    }

    public /* synthetic */ d(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, List list, List list2, List list3, i iVar, n nVar, int i10, k kVar) {
        this(aVar, list, list2, list3, (i10 & 16) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.k.a() : iVar, (i10 & 32) != 0 ? p.a() : nVar);
    }
}
