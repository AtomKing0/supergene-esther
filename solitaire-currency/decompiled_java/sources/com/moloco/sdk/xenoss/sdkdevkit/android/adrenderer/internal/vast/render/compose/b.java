package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.media3.extractor.WavUtil;
import com.google.android.gms.drive.DriveFile;
import h9.q;
import h9.s;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f20904a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static s<BoxScope, Boolean, h9.a<k0>, Composer, Integer, k0> f20905b = ComposableLambdaKt.composableLambdaInstance(-1970835476, false, a.f20906g);

    public static final class a extends v implements s<BoxScope, Boolean, h9.a<? extends k0>, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f20906g = new a();

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.b$a$a, reason: collision with other inner class name */
        public static final class C0443a extends v implements q<Boolean, Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f20907g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ int f20908h;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.b$a$a$a, reason: collision with other inner class name */
            public static final class C0444a extends v implements q<RowScope, Composer, Integer, k0> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public final /* synthetic */ boolean f20909g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0444a(boolean z10) {
                    super(3);
                    this.f20909g = z10;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void a(@NotNull RowScope TextButton, @Nullable Composer composer, int i10) {
                    t.i(TextButton, "$this$TextButton");
                    if ((i10 & 81) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-919554769, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.ComposableSingletons$PlaybackControlKt.lambda-1.<anonymous>.<anonymous>.<anonymous> (PlaybackControl.kt:54)");
                    }
                    TextKt.m1218TextfLXpl1I(this.f20909g ? "Pause" : "Play", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer, 0, 0, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                @Override // h9.q
                public /* bridge */ /* synthetic */ k0 invoke(RowScope rowScope, Composer composer, Integer num) {
                    a(rowScope, composer, num.intValue());
                    return k0.f35197a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0443a(h9.a<k0> aVar, int i10) {
                super(3);
                this.f20907g = aVar;
                this.f20908h = i10;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void a(boolean z10, @Nullable Composer composer, int i10) {
                int i11;
                if ((i10 & 14) == 0) {
                    i11 = (composer.changed(z10) ? 4 : 2) | i10;
                } else {
                    i11 = i10;
                }
                if ((i11 & 91) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(170935244, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.ComposableSingletons$PlaybackControlKt.lambda-1.<anonymous>.<anonymous> (PlaybackControl.kt:53)");
                }
                ButtonKt.TextButton(this.f20907g, null, false, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer, -919554769, true, new C0444a(z10)), composer, ((this.f20908h >> 6) & 14) | DriveFile.MODE_READ_WRITE, 510);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // h9.q
            public /* bridge */ /* synthetic */ k0 invoke(Boolean bool, Composer composer, Integer num) {
                a(bool.booleanValue(), composer, num.intValue());
                return k0.f35197a;
            }
        }

        public a() {
            super(5);
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@NotNull BoxScope boxScope, boolean z10, @NotNull h9.a<k0> onClick, @Nullable Composer composer, int i10) {
            int i11;
            t.i(boxScope, "$this$null");
            t.i(onClick, "onClick");
            if ((i10 & 14) == 0) {
                i11 = (composer.changed(boxScope) ? 4 : 2) | i10;
            } else {
                i11 = i10;
            }
            if ((i10 & 112) == 0) {
                i11 |= composer.changed(z10) ? 32 : 16;
            }
            if ((i10 & 896) == 0) {
                i11 |= composer.changed(onClick) ? 256 : 128;
            }
            if ((i11 & 5851) == 1170 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1970835476, i11, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.ComposableSingletons$PlaybackControlKt.lambda-1.<anonymous> (PlaybackControl.kt:47)");
            }
            CrossfadeKt.Crossfade(Boolean.valueOf(z10), PaddingKt.m399padding3ABfNKs(boxScope.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), Dp.m3673constructorimpl(4)), null, ComposableLambdaKt.composableLambda(composer, 170935244, true, new C0443a(onClick, i11)), composer, ((i11 >> 3) & 14) | 3072, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.s
        public /* bridge */ /* synthetic */ k0 invoke(BoxScope boxScope, Boolean bool, h9.a<? extends k0> aVar, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), aVar, composer, num.intValue());
            return k0.f35197a;
        }
    }

    @NotNull
    public final s<BoxScope, Boolean, h9.a<k0>, Composer, Integer, k0> a() {
        return f20905b;
    }
}
