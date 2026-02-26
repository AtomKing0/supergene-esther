package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import com.google.android.gms.drive.DriveFile;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.m;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    public static final class a extends v implements h9.q<m, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f19871g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f19872h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ long f19873i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ long f19874j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f19875k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ long f19876l;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.l$a$a, reason: collision with other inner class name */
        public static final class C0405a extends v implements h9.q<RowScope, Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ m f19877g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ long f19878h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ TextStyle f19879i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ int f19880j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0405a(m mVar, long j10, TextStyle textStyle, int i10) {
                super(3);
                this.f19877g = mVar;
                this.f19878h = j10;
                this.f19879i = textStyle;
                this.f19880j = i10;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void a(@NotNull RowScope TextButton, @Nullable Composer composer, int i10) {
                kotlin.jvm.internal.t.i(TextButton, "$this$TextButton");
                if ((i10 & 81) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-291791758, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton.<anonymous>.<anonymous>.<anonymous> (CountdownButton.kt:83)");
                }
                TextKt.m1218TextfLXpl1I(((m.c) this.f19877g).a(), null, 0L, this.f19878h, null, null, null, 0L, null, TextAlign.m3586boximpl(TextAlign.Companion.m3593getCentere0LSkKk()), 0L, 0, false, 1, null, this.f19879i, composer, (this.f19880j >> 9) & 7168, 3072, 24054);
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
        public a(h9.a<k0> aVar, boolean z10, long j10, long j11, int i10, long j12) {
            super(3);
            this.f19871g = aVar;
            this.f19872h = z10;
            this.f19873i = j10;
            this.f19874j = j11;
            this.f19875k = i10;
            this.f19876l = j12;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@NotNull m buttonPart, @Nullable Composer composer, int i10) {
            int i11;
            kotlin.jvm.internal.t.i(buttonPart, "buttonPart");
            if ((i10 & 14) == 0) {
                i11 = (composer.changed(buttonPart) ? 4 : 2) | i10;
            } else {
                i11 = i10;
            }
            if ((i11 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1264027403, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton.<anonymous>.<anonymous> (CountdownButton.kt:55)");
            }
            TextStyle h62 = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getH6();
            if (buttonPart instanceof m.a) {
                composer.startReplaceableGroup(1614446682);
                composer.endReplaceableGroup();
            } else if (buttonPart instanceof m.b) {
                composer.startReplaceableGroup(1614447018);
                m.b bVar = (m.b) buttonPart;
                Painter painterE = bVar.e();
                long jD = bVar.d();
                Shape shapeB = bVar.b();
                long jA = bVar.a();
                String strC = bVar.c();
                h9.a<k0> aVar = this.f19871g;
                boolean z10 = this.f19872h;
                long j10 = this.f19873i;
                long j11 = this.f19874j;
                int i12 = this.f19875k;
                int i13 = ((i12 >> 3) & 112) | 8 | (i12 & 7168);
                int i14 = i12 << 3;
                p.a(painterE, aVar, null, z10, strC, j10, j11, jD, shapeB, jA, composer, i13 | (i14 & 458752) | (i14 & 3670016), 4);
                composer.endReplaceableGroup();
            } else if (buttonPart instanceof m.c) {
                composer.startReplaceableGroup(1614447638);
                h9.a<k0> aVar2 = this.f19871g;
                boolean z11 = this.f19872h;
                ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                long j12 = this.f19873i;
                int i15 = this.f19875k;
                ButtonColors buttonColorsM910textButtonColorsRGew2ao = buttonDefaults.m910textButtonColorsRGew2ao(0L, j12, j12, composer, ((i15 >> 6) & 896) | ((i15 >> 9) & 112) | (ButtonDefaults.$stable << 9), 1);
                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -291791758, true, new C0405a(buttonPart, this.f19876l, h62, this.f19875k));
                int i16 = this.f19875k;
                ButtonKt.TextButton(aVar2, null, z11, null, null, null, null, buttonColorsM910textButtonColorsRGew2ao, null, composableLambda, composer, ((i16 >> 6) & 14) | DriveFile.MODE_READ_WRITE | ((i16 >> 3) & 896), 378);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1614448237);
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(m mVar, Composer composer, Integer num) {
            a(mVar, composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class b extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ m f19881g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Modifier f19882h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f19883i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ boolean f19884j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ long f19885k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ long f19886l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ long f19887m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i f19888n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ int f19889o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ int f19890p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(m mVar, Modifier modifier, h9.a<k0> aVar, boolean z10, long j10, long j11, long j12, com.moloco.sdk.internal.ortb.model.i iVar, int i10, int i11) {
            super(2);
            this.f19881g = mVar;
            this.f19882h = modifier;
            this.f19883i = aVar;
            this.f19884j = z10;
            this.f19885k = j10;
            this.f19886l = j11;
            this.f19887m = j12;
            this.f19888n = iVar;
            this.f19889o = i10;
            this.f19890p = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            l.a(this.f19881g, this.f19882h, this.f19883i, this.f19884j, this.f19885k, this.f19886l, this.f19887m, this.f19888n, composer, this.f19889o | 1, this.f19890p);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x022d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011a  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(@org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.m r24, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r25, @org.jetbrains.annotations.NotNull h9.a<v8.k0> r26, boolean r27, long r28, long r30, long r32, @org.jetbrains.annotations.Nullable com.moloco.sdk.internal.ortb.model.i r34, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            Method dump skipped, instruction units count: 695
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.l.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.m, androidx.compose.ui.Modifier, h9.a, boolean, long, long, long, com.moloco.sdk.internal.ortb.model.i, androidx.compose.runtime.Composer, int, int):void");
    }
}
