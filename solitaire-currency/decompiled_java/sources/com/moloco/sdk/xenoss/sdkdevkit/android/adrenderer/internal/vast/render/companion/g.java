package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion;

import androidx.compose.runtime.internal.StabilityInferred;
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
@StabilityInferred(parameters = 0)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f20876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public List<String> f20877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public List<String> f20878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final i f20879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final n f20880e;

    public g(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @Nullable List<String> list, @Nullable List<String> list2, @NotNull i buttonTracker, @NotNull n vastTracker) {
        t.i(customUserEventBuilderService, "customUserEventBuilderService");
        t.i(buttonTracker, "buttonTracker");
        t.i(vastTracker, "vastTracker");
        this.f20876a = customUserEventBuilderService;
        this.f20877b = list;
        this.f20878c = list2;
        this.f20879d = buttonTracker;
        this.f20880e = vastTracker;
    }

    public final void a() {
        List<String> list = this.f20878c;
        if (list != null) {
            n.a.a(this.f20880e, list, null, null, null, 14, null);
            this.f20878c = null;
        }
    }

    public final void b(@NotNull a.AbstractC0481a.c.EnumC0483a buttonType) {
        t.i(buttonType, "buttonType");
        this.f20879d.j(buttonType);
    }

    public final void c(@NotNull a.AbstractC0481a.c button) {
        t.i(button, "button");
        this.f20879d.g(button);
    }

    public final void d(@NotNull a.AbstractC0481a.f lastClickPosition) {
        t.i(lastClickPosition, "lastClickPosition");
        List<String> list = this.f20877b;
        if (list != null) {
            n.a.b(this.f20880e, list, null, null, null, this.f20879d.p(), this.f20876a, lastClickPosition, 14, null);
            this.f20877b = null;
        }
    }

    public /* synthetic */ g(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, List list, List list2, i iVar, n nVar, int i10, k kVar) {
        this(aVar, list, list2, (i10 & 8) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.k.a() : iVar, (i10 & 16) != 0 ? p.a() : nVar);
    }
}
