package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.unit.Dp;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f20971a = Dp.m3673constructorimpl(4);

    public static final class a extends v implements q<RowScope, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f20972g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f20973h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ long f20974i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f20975j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, long j10, int i10) {
            super(3);
            this.f20972g = str;
            this.f20973h = str2;
            this.f20974i = j10;
            this.f20975j = i10;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@NotNull RowScope OutlinedButton, @Nullable Composer composer, int i10) {
            t.i(OutlinedButton, "$this$OutlinedButton");
            if ((i10 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1553541117, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastCTA.<anonymous> (VastCTA.kt:37)");
            }
            String str = this.f20972g;
            composer.startReplaceableGroup(640085894);
            if (str != null) {
                String str2 = this.f20972g;
                int i11 = this.f20975j;
                Modifier.Companion companion = Modifier.Companion;
                l.i.a(str2, null, SizeKt.m440size3ABfNKs(ClipKt.clip(companion, RoundedCornerShapeKt.m646RoundedCornerShape0680j_4(h.f20971a)), Dp.m3673constructorimpl(36)), null, null, null, null, 0.0f, null, 0, composer, ((i11 >> 3) & 14) | 48, 1016);
                SpacerKt.Spacer(SizeKt.m445width3ABfNKs(companion, h.f20971a), composer, 6);
                k0 k0Var = k0.f35197a;
            }
            composer.endReplaceableGroup();
            String str3 = this.f20973h;
            long j10 = this.f20974i;
            int i12 = this.f20975j;
            TextKt.m1218TextfLXpl1I(str3, null, j10, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, null, null, composer, ((i12 >> 6) & 14) | ((i12 >> 3) & 896), 3072, 57338);
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

    public static final class b extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Modifier f20976g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f20977h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f20978i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ long f20979j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f20980k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f20981l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f20982m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Modifier modifier, String str, String str2, long j10, h9.a<k0> aVar, int i10, int i11) {
            super(2);
            this.f20976g = modifier;
            this.f20977h = str;
            this.f20978i = str2;
            this.f20979j = j10;
            this.f20980k = aVar;
            this.f20981l = i10;
            this.f20982m = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            h.b(this.f20976g, this.f20977h, this.f20978i, this.f20979j, this.f20980k, composer, this.f20981l | 1, this.f20982m);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r23, @org.jetbrains.annotations.Nullable java.lang.String r24, @org.jetbrains.annotations.NotNull java.lang.String r25, long r26, @org.jetbrains.annotations.NotNull h9.a<v8.k0> r28, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h.b(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, long, h9.a, androidx.compose.runtime.Composer, int, int):void");
    }
}
