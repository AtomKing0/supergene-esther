package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import h9.w;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.y;
import v8.c0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final w<Context, WebView, Integer, y<Boolean>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, r, Dp, Boolean, View> f18982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final h9.p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> f18984d;

    public static final class a extends v implements h9.p<Composer, Integer, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<? extends k0>, ? super h9.l<? super a.AbstractC0481a.c, ? extends k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f18985g = new a();

        public a() {
            super(2);
        }

        @Composable
        @NotNull
        public final h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            composer.startReplaceableGroup(478047689);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(478047689, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.AdWebViewOptions.<init>.<anonymous> (AdOptions.kt:20)");
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

    public d() {
        this(0, null, 0, null, 15, null);
    }

    @NotNull
    public final w<Context, WebView, Integer, y<Boolean>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, r, Dp, Boolean, View> a() {
        return this.f18982b;
    }

    public final int b() {
        return this.f18981a;
    }

    @NotNull
    public final h9.p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> c() {
        return this.f18984d;
    }

    public final int d() {
        return this.f18983c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(int i10, @NotNull w<? super Context, ? super WebView, ? super Integer, ? super y<Boolean>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super r, ? super Dp, ? super Boolean, ? extends View> adWebViewRenderer, int i11, @NotNull h9.p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> decClose) {
        kotlin.jvm.internal.t.i(adWebViewRenderer, "adWebViewRenderer");
        kotlin.jvm.internal.t.i(decClose, "decClose");
        this.f18981a = i10;
        this.f18982b = adWebViewRenderer;
        this.f18983c = i11;
        this.f18984d = decClose;
    }

    public /* synthetic */ d(int i10, w wVar, int i11, h9.p pVar, int i12, kotlin.jvm.internal.k kVar) {
        this((i12 & 1) != 0 ? 5 : i10, (i12 & 2) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b.d(0L, null, 3, null) : wVar, (i12 & 4) != 0 ? 5 : i11, (i12 & 8) != 0 ? a.f18985g : pVar);
    }
}
