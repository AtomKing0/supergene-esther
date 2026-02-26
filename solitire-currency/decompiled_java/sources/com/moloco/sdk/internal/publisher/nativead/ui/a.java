package com.moloco.sdk.internal.publisher.nativead.ui;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.p;
import h9.l;
import h9.q;
import h9.s;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f18238a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static s<BoxScope, Boolean, h9.a<k0>, Composer, Integer, k0> f18239b = ComposableLambdaKt.composableLambdaInstance(1019496058, false, C0320a.f18240g);

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.ui.a$a, reason: collision with other inner class name */
    public static final class C0320a extends v implements s<BoxScope, Boolean, h9.a<? extends k0>, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final C0320a f18240g = new C0320a();

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.ui.a$a$a, reason: collision with other inner class name */
        public static final class C0321a extends v implements l<SemanticsPropertyReceiver, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ String f18241g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0321a(String str) {
                super(1);
                this.f18241g = str;
            }

            public final void a(@NotNull SemanticsPropertyReceiver semantics) {
                t.i(semantics, "$this$semantics");
                String str = this.f18241g;
                SemanticsPropertiesKt.setContentDescription(semantics, str);
                SemanticsPropertiesKt.setTestTag(semantics, str);
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                a(semanticsPropertyReceiver);
                return k0.f35197a;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.ui.a$a$b */
        public static final class b extends v implements q<Boolean, Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f18242g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ int f18243h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(h9.a<k0> aVar, int i10) {
                super(3);
                this.f18242g = aVar;
                this.f18243h = i10;
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
                    ComposerKt.traceEventStart(1776469658, i10, -1, "com.moloco.sdk.internal.publisher.nativead.ui.ComposableSingletons$NativeVideoPlaybackControlUIKt.lambda-1.<anonymous>.<anonymous> (NativeVideoPlaybackControlUI.kt:29)");
                }
                p.a(PainterResources_androidKt.painterResource(z10 ? com.moloco.sdk.p.f18860h : com.moloco.sdk.p.f18861i, composer, 0), this.f18242g, null, false, "play/pause", Color.Companion.m1635getWhite0d7_KjU(), 0L, 0L, null, 0L, composer, ((this.f18243h >> 3) & 112) | 221192, 972);
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

        public C0320a() {
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
                ComposerKt.traceEventStart(1019496058, i11, -1, "com.moloco.sdk.internal.publisher.nativead.ui.ComposableSingletons$NativeVideoPlaybackControlUIKt.lambda-1.<anonymous> (NativeVideoPlaybackControlUI.kt:16)");
            }
            Modifier modifierM399padding3ABfNKs = PaddingKt.m399padding3ABfNKs(boxScope.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), Dp.m3673constructorimpl(4));
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed("playback_control_button");
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new C0321a("playback_control_button");
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            CrossfadeKt.Crossfade(Boolean.valueOf(z10), SemanticsModifierKt.semantics$default(modifierM399padding3ABfNKs, false, (l) objRememberedValue, 1, null), null, ComposableLambdaKt.composableLambda(composer, 1776469658, true, new b(onClick, i11)), composer, ((i11 >> 3) & 14) | 3072, 4);
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
        return f18239b;
    }
}
