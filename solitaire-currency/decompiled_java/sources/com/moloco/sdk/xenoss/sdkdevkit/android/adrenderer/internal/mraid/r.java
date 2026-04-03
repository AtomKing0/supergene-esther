package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.graphics.Rect;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f19604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final Rect f19605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final Rect f19606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final Rect f19607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final Rect f19608e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final Rect f19609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final Rect f19610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final Rect f19611h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final Rect f19612i;

    public r(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.t.h(applicationContext, "context.applicationContext");
        this.f19604a = applicationContext;
        this.f19605b = new Rect();
        this.f19606c = new Rect();
        this.f19607d = new Rect();
        this.f19608e = new Rect();
        this.f19609f = new Rect();
        this.f19610g = new Rect();
        this.f19611h = new Rect();
        this.f19612i = new Rect();
    }

    public final void a(int i10, int i11) {
        this.f19605b.set(0, 0, i10, i11);
        c(this.f19605b, this.f19606c);
    }

    public final void b(int i10, int i11, int i12, int i13) {
        this.f19609f.set(i10, i11, i12 + i10, i13 + i11);
        c(this.f19609f, this.f19610g);
    }

    public final void c(Rect rect, Rect rect2) {
        a aVar = a.f19505a;
        rect2.set(aVar.c(rect.left, this.f19604a), aVar.c(rect.top, this.f19604a), aVar.c(rect.right, this.f19604a), aVar.c(rect.bottom, this.f19604a));
    }

    @NotNull
    public final Rect d() {
        return this.f19610g;
    }

    public final void e(int i10, int i11, int i12, int i13) {
        this.f19611h.set(i10, i11, i12 + i10, i13 + i11);
        c(this.f19611h, this.f19612i);
    }

    public final void f(int i10, int i11, int i12, int i13) {
        this.f19607d.set(i10, i11, i12 + i10, i13 + i11);
        c(this.f19607d, this.f19608e);
    }

    @NotNull
    public final Rect g() {
        return this.f19612i;
    }

    @NotNull
    public final Rect h() {
        return this.f19608e;
    }

    @NotNull
    public final Rect i() {
        return this.f19606c;
    }
}
