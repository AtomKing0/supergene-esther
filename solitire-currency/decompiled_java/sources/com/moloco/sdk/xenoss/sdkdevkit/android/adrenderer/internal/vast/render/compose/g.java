package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import h9.s;
import h9.u;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s<BoxScope, Boolean, h9.a<k0>, Composer, Integer, k0> f20964a = b.f20904a.a();

    public static final class a extends v implements u<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, h9.l<? super Boolean, ? extends k0>, h9.a<? extends k0>, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ s<BoxScope, Boolean, h9.a<k0>, Composer, Integer, k0> f20965g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f20966h;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.g$a$a, reason: collision with other inner class name */
        public static final class C0449a extends v implements h9.a<k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i f20967g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f20968h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ h9.l<Boolean, k0> f20969i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ boolean f20970j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0449a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, h9.a<k0> aVar, h9.l<? super Boolean, k0> lVar, boolean z10) {
                super(0);
                this.f20967g = iVar;
                this.f20968h = aVar;
                this.f20969i = lVar;
                this.f20970j = z10;
            }

            public final void b() {
                if (this.f20967g instanceof i.a) {
                    this.f20968h.invoke();
                } else {
                    this.f20969i.invoke(Boolean.valueOf(!this.f20970j));
                }
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                b();
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(s<? super BoxScope, ? super Boolean, ? super h9.a<k0>, ? super Composer, ? super Integer, k0> sVar, int i10) {
            super(7);
            this.f20965g = sVar;
            this.f20966h = i10;
        }

        @Composable
        public final void a(@NotNull BoxScope boxScope, boolean z10, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i progress, @NotNull h9.l<? super Boolean, k0> onShouldPlay, @NotNull h9.a<k0> onShouldReplay, @Nullable Composer composer, int i10) {
            t.i(boxScope, "$this$null");
            t.i(progress, "progress");
            t.i(onShouldPlay, "onShouldPlay");
            t.i(onShouldReplay, "onShouldReplay");
            int i11 = (i10 & 14) == 0 ? (composer.changed(boxScope) ? 4 : 2) | i10 : i10;
            if ((i10 & 112) == 0) {
                i11 |= composer.changed(z10) ? 32 : 16;
            }
            if ((i10 & 896) == 0) {
                i11 |= composer.changed(progress) ? 256 : 128;
            }
            if ((i10 & 7168) == 0) {
                i11 |= composer.changed(onShouldPlay) ? 2048 : 1024;
            }
            if ((i10 & 57344) == 0) {
                i11 |= composer.changed(onShouldReplay) ? 16384 : 8192;
            }
            if ((374491 & i11) == 74898 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1279825651, i11, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultPlaybackControl.<anonymous> (PlaybackControl.kt:30)");
            }
            Object[] objArr = {progress, onShouldReplay, onShouldPlay, Boolean.valueOf(z10)};
            composer.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i12 = 0; i12 < 4; i12++) {
                zChanged |= composer.changed(objArr[i12]);
            }
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new C0449a(progress, onShouldReplay, onShouldPlay, z10);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            this.f20965g.invoke(boxScope, Boolean.valueOf(z10), (h9.a) objRememberedValue, composer, Integer.valueOf((i11 & 14) | (i11 & 112) | ((this.f20966h << 9) & 7168)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.u
        public /* bridge */ /* synthetic */ k0 invoke(BoxScope boxScope, Boolean bool, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, h9.l<? super Boolean, ? extends k0> lVar, h9.a<? extends k0> aVar, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), iVar, lVar, aVar, composer, num.intValue());
            return k0.f35197a;
        }
    }

    @Composable
    @NotNull
    public static final u<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, h9.l<? super Boolean, k0>, h9.a<k0>, Composer, Integer, k0> a(@Nullable s<? super BoxScope, ? super Boolean, ? super h9.a<k0>, ? super Composer, ? super Integer, k0> sVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(1756131298);
        if ((i11 & 1) != 0) {
            sVar = f20964a;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1756131298, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultPlaybackControl (PlaybackControl.kt:28)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1279825651, true, new a(sVar, i10));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }
}
