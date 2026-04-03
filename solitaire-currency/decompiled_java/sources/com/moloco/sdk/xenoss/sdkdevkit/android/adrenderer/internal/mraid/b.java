package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.VisibleForTesting;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.y;
import v8.c0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public static h9.w<? super Context, ? super WebView, ? super Integer, ? super y<Boolean>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, ? super Dp, ? super Boolean, ? extends View> f19509d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public static h9.a<k0> f19511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public static c f19512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public static com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r f19513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public static h9.a<k0> f19514i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f19506a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static WeakReference<j> f19507b = new WeakReference<>(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static WeakReference<Activity> f19508c = new WeakReference<>(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static h9.p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> f19510e = a.f19515g;

    public static final class a extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<? extends k0>, ? super h9.l<? super a.AbstractC0481a.c, ? extends k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f19515g = new a();

        public a() {
            super(2);
        }

        @Composable
        @NotNull
        public final h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            composer.startReplaceableGroup(39427356);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(39427356, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivityDataHolder.closeButton.<anonymous> (MraidActivity.kt:259)");
            }
            h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> bVarB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o.b(null, null, 0L, 0L, 0L, null, null, null, composer, 0, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return bVarB;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<? extends k0>, ? super h9.l<? super a.AbstractC0481a.c, ? extends k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, ? extends k0> mo4invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    @Nullable
    public final c a() {
        return f19512g;
    }

    public final void b(@Nullable Activity activity) {
        f19508c = new WeakReference<>(activity);
    }

    public final void c(@Nullable c cVar) {
        f19512g = cVar;
    }

    public final void d(@Nullable j jVar) {
        f19507b = new WeakReference<>(jVar);
    }

    public final void e(@Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r rVar) {
        f19513h = rVar;
    }

    public final void f(@Nullable h9.a<k0> aVar) {
        f19511f = aVar;
    }

    public final void g(@NotNull h9.p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> pVar) {
        kotlin.jvm.internal.t.i(pVar, "<set-?>");
        f19510e = pVar;
    }

    public final void h(@Nullable h9.w<? super Context, ? super WebView, ? super Integer, ? super y<Boolean>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, ? super Dp, ? super Boolean, ? extends View> wVar) {
        f19509d = wVar;
    }

    @NotNull
    public final h9.p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> i() {
        return f19510e;
    }

    public final void j(@Nullable h9.a<k0> aVar) {
        f19514i = aVar;
    }

    @Nullable
    public final h9.w<Context, WebView, Integer, y<Boolean>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, Dp, Boolean, View> k() {
        return f19509d;
    }

    @Nullable
    public final h9.a<k0> l() {
        return f19511f;
    }

    @Nullable
    public final h9.a<k0> m() {
        return f19514i;
    }

    @Nullable
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r n() {
        return f19513h;
    }

    @Nullable
    public final Activity o() {
        return f19508c.get();
    }

    @Nullable
    public final j p() {
        return f19507b.get();
    }
}
