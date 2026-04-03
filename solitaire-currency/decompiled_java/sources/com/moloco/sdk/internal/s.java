package com.moloco.sdk.internal;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f18351a = ColorKt.Color(4278354171L);

    public static final class a extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Modifier f18352g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f18353h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f18354i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ long f18355j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ long f18356k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f18357l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f18358m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ int f18359n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Modifier modifier, String str, String str2, long j10, long j11, h9.a<k0> aVar, int i10, int i11) {
            super(2);
            this.f18352g = modifier;
            this.f18353h = str;
            this.f18354i = str2;
            this.f18355j = j10;
            this.f18356k = j11;
            this.f18357l = aVar;
            this.f18358m = i10;
            this.f18359n = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            s.c(this.f18352g, this.f18353h, this.f18354i, this.f18355j, this.f18356k, this.f18357l, composer, this.f18358m | 1, this.f18359n);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class b extends kotlin.jvm.internal.v implements h9.u<BoxScope, Boolean, m0<? extends i.a>, h9.l<? super a.AbstractC0481a.c, ? extends k0>, h9.a<? extends k0>, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Alignment f18360g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ PaddingValues f18361h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f18362i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f18363j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ long f18364k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ long f18365l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f18366m;

        public static final class a extends kotlin.jvm.internal.v implements h9.q<AnimatedVisibilityScope, Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ h9.l<a.AbstractC0481a.c, k0> f18367g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ int f18368h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ State<i.a> f18369i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ String f18370j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ String f18371k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ long f18372l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ long f18373m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f18374n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final /* synthetic */ int f18375o;

            /* JADX INFO: renamed from: com.moloco.sdk.internal.s$b$a$a, reason: collision with other inner class name */
            public static final class C0323a extends kotlin.jvm.internal.v implements h9.q<Modifier, Composer, Integer, k0> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public final /* synthetic */ String f18376g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public final /* synthetic */ String f18377h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                public final /* synthetic */ long f18378i;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public final /* synthetic */ long f18379j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ h9.a<k0> f18380k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public final /* synthetic */ int f18381l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public final /* synthetic */ int f18382m;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0323a(String str, String str2, long j10, long j11, h9.a<k0> aVar, int i10, int i11) {
                    super(3);
                    this.f18376g = str;
                    this.f18377h = str2;
                    this.f18378i = j10;
                    this.f18379j = j11;
                    this.f18380k = aVar;
                    this.f18381l = i10;
                    this.f18382m = i11;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void a(@NotNull Modifier it, @Nullable Composer composer, int i10) {
                    int i11;
                    kotlin.jvm.internal.t.i(it, "it");
                    if ((i10 & 14) == 0) {
                        i11 = i10 | (composer.changed(it) ? 4 : 2);
                    } else {
                        i11 = i10;
                    }
                    if ((i11 & 91) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1676203776, i11, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous>.<anonymous>.<anonymous> (MolocoVastCTA.kt:71)");
                    }
                    String str = this.f18376g;
                    String str2 = this.f18377h;
                    long j10 = this.f18378i;
                    long j11 = this.f18379j;
                    h9.a<k0> aVar = this.f18380k;
                    int i12 = this.f18381l;
                    s.c(it, str, str2, j10, j11, aVar, composer, ((this.f18382m << 3) & 458752) | (i11 & 14) | ((i12 >> 12) & 112) | (i12 & 896) | (i12 & 7168) | (i12 & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                @Override // h9.q
                public /* bridge */ /* synthetic */ k0 invoke(Modifier modifier, Composer composer, Integer num) {
                    a(modifier, composer, num.intValue());
                    return k0.f35197a;
                }
            }

            /* JADX INFO: renamed from: com.moloco.sdk.internal.s$b$a$b, reason: collision with other inner class name */
            public static final class C0324b extends kotlin.jvm.internal.v implements h9.q<Modifier, Composer, Integer, k0> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public final /* synthetic */ String f18383g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public final /* synthetic */ String f18384h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                public final /* synthetic */ long f18385i;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public final /* synthetic */ long f18386j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ h9.a<k0> f18387k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public final /* synthetic */ int f18388l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public final /* synthetic */ int f18389m;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0324b(String str, String str2, long j10, long j11, h9.a<k0> aVar, int i10, int i11) {
                    super(3);
                    this.f18383g = str;
                    this.f18384h = str2;
                    this.f18385i = j10;
                    this.f18386j = j11;
                    this.f18387k = aVar;
                    this.f18388l = i10;
                    this.f18389m = i11;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void a(@NotNull Modifier it, @Nullable Composer composer, int i10) {
                    int i11;
                    kotlin.jvm.internal.t.i(it, "it");
                    if ((i10 & 14) == 0) {
                        i11 = i10 | (composer.changed(it) ? 4 : 2);
                    } else {
                        i11 = i10;
                    }
                    if ((i11 & 91) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(357526633, i11, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous>.<anonymous>.<anonymous> (MolocoVastCTA.kt:86)");
                    }
                    String str = this.f18383g;
                    String str2 = this.f18384h;
                    long j10 = this.f18385i;
                    long j11 = this.f18386j;
                    h9.a<k0> aVar = this.f18387k;
                    int i12 = this.f18388l;
                    s.c(it, str, str2, j10, j11, aVar, composer, ((this.f18389m << 3) & 458752) | (i11 & 14) | ((i12 >> 12) & 112) | (i12 & 896) | (i12 & 7168) | (i12 & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                @Override // h9.q
                public /* bridge */ /* synthetic */ k0 invoke(Modifier modifier, Composer composer, Integer num) {
                    a(modifier, composer, num.intValue());
                    return k0.f35197a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(h9.l<? super a.AbstractC0481a.c, k0> lVar, int i10, State<? extends i.a> state, String str, String str2, long j10, long j11, h9.a<k0> aVar, int i11) {
                super(3);
                this.f18367g = lVar;
                this.f18368h = i10;
                this.f18369i = state;
                this.f18370j = str;
                this.f18371k = str2;
                this.f18372l = j10;
                this.f18373m = j11;
                this.f18374n = aVar;
                this.f18375o = i11;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void a(@NotNull AnimatedVisibilityScope AnimatedVisibility, @Nullable Composer composer, int i10) {
                kotlin.jvm.internal.t.i(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1562460200, i10, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous>.<anonymous> (MolocoVastCTA.kt:55)");
                }
                i.a aVarC = b.c(this.f18369i);
                if (aVarC instanceof i.a.C0434a) {
                    composer.startReplaceableGroup(-1828335674);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.t.c(null, a.AbstractC0481a.c.EnumC0483a.CTA, this.f18367g, ComposableLambdaKt.composableLambda(composer, -1676203776, true, new C0323a(this.f18370j, this.f18371k, this.f18372l, this.f18373m, this.f18374n, this.f18375o, this.f18368h)), composer, ((this.f18368h >> 3) & 896) | 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarC instanceof i.a.c) {
                    composer.startReplaceableGroup(-1828335108);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.t.c(null, a.AbstractC0481a.c.EnumC0483a.CTA, this.f18367g, ComposableLambdaKt.composableLambda(composer, 357526633, true, new C0324b(this.f18370j, this.f18371k, this.f18372l, this.f18373m, this.f18374n, this.f18375o, this.f18368h)), composer, ((this.f18368h >> 3) & 896) | 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarC instanceof i.a.b) {
                    composer.startReplaceableGroup(-1828334545);
                    composer.endReplaceableGroup();
                } else if (aVarC instanceof i.a.d) {
                    composer.startReplaceableGroup(-1828334487);
                    composer.endReplaceableGroup();
                } else if (aVarC == null) {
                    composer.startReplaceableGroup(-1828334452);
                    composer.endReplaceableGroup();
                } else {
                    composer.startReplaceableGroup(-1828334429);
                    composer.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // h9.q
            public /* bridge */ /* synthetic */ k0 invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                a(animatedVisibilityScope, composer, num.intValue());
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Alignment alignment, PaddingValues paddingValues, String str, String str2, long j10, long j11, int i10) {
            super(7);
            this.f18360g = alignment;
            this.f18361h = paddingValues;
            this.f18362i = str;
            this.f18363j = str2;
            this.f18364k = j10;
            this.f18365l = j11;
            this.f18366m = i10;
        }

        public static final i.a c(State<? extends i.a> state) {
            return state.getValue();
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void b(@NotNull BoxScope boxScope, boolean z10, @NotNull m0<? extends i.a> currentAdPartFlow, @NotNull h9.l<? super a.AbstractC0481a.c, k0> onButtonRendered, @NotNull h9.a<k0> onCTA, @Nullable Composer composer, int i10) {
            kotlin.jvm.internal.t.i(boxScope, "$this$null");
            kotlin.jvm.internal.t.i(currentAdPartFlow, "currentAdPartFlow");
            kotlin.jvm.internal.t.i(onButtonRendered, "onButtonRendered");
            kotlin.jvm.internal.t.i(onCTA, "onCTA");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1780811600, i10, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous> (MolocoVastCTA.kt:47)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z10, PaddingKt.padding(WindowInsetsPadding_androidKt.displayCutoutPadding(boxScope.align(Modifier.Companion, this.f18360g)), this.f18361h), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, 1562460200, true, new a(onButtonRendered, i10, SnapshotStateKt.collectAsState(currentAdPartFlow, null, composer, 8, 1), this.f18362i, this.f18363j, this.f18364k, this.f18365l, onCTA, this.f18366m)), composer, ((i10 >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.u
        public /* bridge */ /* synthetic */ k0 invoke(BoxScope boxScope, Boolean bool, m0<? extends i.a> m0Var, h9.l<? super a.AbstractC0481a.c, ? extends k0> lVar, h9.a<? extends k0> aVar, Composer composer, Integer num) {
            b(boxScope, bool.booleanValue(), m0Var, lVar, aVar, composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final long a() {
        return f18351a;
    }

    @Composable
    @NotNull
    public static final h9.u<BoxScope, Boolean, m0<? extends i.a>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, Composer, Integer, k0> b(@Nullable Alignment alignment, @Nullable PaddingValues paddingValues, @Nullable String str, long j10, long j11, @Nullable String str2, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-1689381278);
        Alignment bottomEnd = (i11 & 1) != 0 ? Alignment.Companion.getBottomEnd() : alignment;
        PaddingValues paddingValuesM392PaddingValues0680j_4 = (i11 & 2) != 0 ? PaddingKt.m392PaddingValues0680j_4(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.a()) : paddingValues;
        String strStringResource = (i11 & 4) != 0 ? StringResources_androidKt.stringResource(com.moloco.sdk.r.f18867a, composer, 0) : str;
        long jM1635getWhite0d7_KjU = (i11 & 8) != 0 ? Color.Companion.m1635getWhite0d7_KjU() : j10;
        long j12 = (i11 & 16) != 0 ? f18351a : j11;
        String str3 = (i11 & 32) != 0 ? null : str2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1689381278, i10, -1, "com.moloco.sdk.internal.molocoCTAButton (MolocoVastCTA.kt:40)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 1780811600, true, new b(bottomEnd, paddingValuesM392PaddingValues0680j_4, str3, strStringResource, jM1635getWhite0d7_KjU, j12, i10));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x028a  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(androidx.compose.ui.Modifier r34, java.lang.String r35, java.lang.String r36, long r37, long r39, h9.a<v8.k0> r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            Method dump skipped, instruction units count: 673
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.s.c(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, long, long, h9.a, androidx.compose.runtime.Composer, int, int):void");
    }
}
