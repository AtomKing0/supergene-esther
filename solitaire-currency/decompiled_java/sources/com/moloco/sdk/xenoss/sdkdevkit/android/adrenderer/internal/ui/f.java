package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.profileinstaller.ProfileVerifier;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.m;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.c0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    public static final class a extends v implements h9.b<BoxScope, Boolean, Boolean, h9.a<? extends k0>, h9.l<? super a.AbstractC0481a.c, ? extends k0>, Boolean, c0, c0, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Alignment f19802g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ PaddingValues f19803h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ a.AbstractC0481a.c.EnumC0483a f19804i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f19805j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ m f19806k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f19807l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ long f19808m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ long f19809n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ long f19810o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i f19811p;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.f$a$a, reason: collision with other inner class name */
        public static final class C0399a extends v implements h9.q<AnimatedVisibilityScope, Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ a.AbstractC0481a.c.EnumC0483a f19812g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ h9.l<a.AbstractC0481a.c, k0> f19813h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ int f19814i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ int f19815j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ boolean f19816k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ m f19817l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ boolean f19818m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ int f19819n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final /* synthetic */ int f19820o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f19821p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f19822q;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            public final /* synthetic */ long f19823r;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public final /* synthetic */ long f19824s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            public final /* synthetic */ long f19825t;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i f19826u;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.f$a$a$a, reason: collision with other inner class name */
            public static final class C0400a extends v implements h9.q<Modifier, Composer, Integer, k0> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public final /* synthetic */ boolean f19827g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public final /* synthetic */ m f19828h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                public final /* synthetic */ boolean f19829i;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public final /* synthetic */ int f19830j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ int f19831k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public final /* synthetic */ h9.a<k0> f19832l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public final /* synthetic */ h9.a<k0> f19833m;

                /* JADX INFO: renamed from: n, reason: collision with root package name */
                public final /* synthetic */ int f19834n;

                /* JADX INFO: renamed from: o, reason: collision with root package name */
                public final /* synthetic */ int f19835o;

                /* JADX INFO: renamed from: p, reason: collision with root package name */
                public final /* synthetic */ long f19836p;

                /* JADX INFO: renamed from: q, reason: collision with root package name */
                public final /* synthetic */ long f19837q;

                /* JADX INFO: renamed from: r, reason: collision with root package name */
                public final /* synthetic */ long f19838r;

                /* JADX INFO: renamed from: s, reason: collision with root package name */
                public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i f19839s;

                /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.f$a$a$a$a, reason: collision with other inner class name */
                public static final class C0401a extends v implements h9.a<k0> {

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    public final /* synthetic */ h9.a<k0> f19840g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    public final /* synthetic */ h9.a<k0> f19841h;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C0401a(h9.a<k0> aVar, h9.a<k0> aVar2) {
                        super(0);
                        this.f19840g = aVar;
                        this.f19841h = aVar2;
                    }

                    public final void b() {
                        this.f19840g.invoke();
                        h9.a<k0> aVar = this.f19841h;
                        if (aVar != null) {
                            aVar.invoke();
                        }
                    }

                    @Override // h9.a
                    public /* bridge */ /* synthetic */ k0 invoke() {
                        b();
                        return k0.f35197a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0400a(boolean z10, m mVar, boolean z11, int i10, int i11, h9.a<k0> aVar, h9.a<k0> aVar2, int i12, int i13, long j10, long j11, long j12, com.moloco.sdk.internal.ortb.model.i iVar) {
                    super(3);
                    this.f19827g = z10;
                    this.f19828h = mVar;
                    this.f19829i = z11;
                    this.f19830j = i10;
                    this.f19831k = i11;
                    this.f19832l = aVar;
                    this.f19833m = aVar2;
                    this.f19834n = i12;
                    this.f19835o = i13;
                    this.f19836p = j10;
                    this.f19837q = j11;
                    this.f19838r = j12;
                    this.f19839s = iVar;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void a(@NotNull Modifier modifier, @Nullable Composer composer, int i10) {
                    int i11;
                    kotlin.jvm.internal.t.i(modifier, "modifier");
                    if ((i10 & 14) == 0) {
                        i11 = i10 | (composer.changed(modifier) ? 4 : 2);
                    } else {
                        i11 = i10;
                    }
                    if ((i11 & 91) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-239633113, i11, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.adCountdownButton.<anonymous>.<anonymous>.<anonymous> (AdCountdownButton.kt:66)");
                    }
                    m aVar = this.f19827g ? this.f19828h : new m.a(this.f19829i, this.f19830j, this.f19831k, null);
                    h9.a<k0> aVar2 = this.f19832l;
                    h9.a<k0> aVar3 = this.f19833m;
                    composer.startReplaceableGroup(511388516);
                    boolean zChanged = composer.changed(aVar2) | composer.changed(aVar3);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new C0401a(aVar2, aVar3);
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    composer.endReplaceableGroup();
                    boolean z10 = this.f19827g;
                    long j10 = this.f19836p;
                    long j11 = this.f19837q;
                    long j12 = this.f19838r;
                    com.moloco.sdk.internal.ortb.model.i iVar = this.f19839s;
                    int i12 = ((i11 << 3) & 112) | ((this.f19834n << 6) & 7168);
                    int i13 = this.f19835o;
                    int i14 = i13 << 6;
                    l.a(aVar, modifier, (h9.a) objRememberedValue, z10, j10, j11, j12, iVar, composer, ((i13 >> 3) & 29360128) | i12 | (i14 & 57344) | (i14 & 458752) | (i14 & 3670016), 0);
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
            public C0399a(a.AbstractC0481a.c.EnumC0483a enumC0483a, h9.l<? super a.AbstractC0481a.c, k0> lVar, int i10, int i11, boolean z10, m mVar, boolean z11, int i12, int i13, h9.a<k0> aVar, h9.a<k0> aVar2, long j10, long j11, long j12, com.moloco.sdk.internal.ortb.model.i iVar) {
                super(3);
                this.f19812g = enumC0483a;
                this.f19813h = lVar;
                this.f19814i = i10;
                this.f19815j = i11;
                this.f19816k = z10;
                this.f19817l = mVar;
                this.f19818m = z11;
                this.f19819n = i12;
                this.f19820o = i13;
                this.f19821p = aVar;
                this.f19822q = aVar2;
                this.f19823r = j10;
                this.f19824s = j11;
                this.f19825t = j12;
                this.f19826u = iVar;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void a(@NotNull AnimatedVisibilityScope AnimatedVisibility, @Nullable Composer composer, int i10) {
                kotlin.jvm.internal.t.i(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1799237255, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.adCountdownButton.<anonymous>.<anonymous> (AdCountdownButton.kt:61)");
                }
                t.c(Modifier.Companion, this.f19812g, this.f19813h, ComposableLambdaKt.composableLambda(composer, -239633113, true, new C0400a(this.f19816k, this.f19817l, this.f19818m, this.f19819n, this.f19820o, this.f19821p, this.f19822q, this.f19815j, this.f19814i, this.f19823r, this.f19824s, this.f19825t, this.f19826u)), composer, ((this.f19814i >> 15) & 112) | 3078 | ((this.f19815j >> 6) & 896), 0);
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
        public a(Alignment alignment, PaddingValues paddingValues, a.AbstractC0481a.c.EnumC0483a enumC0483a, int i10, m mVar, h9.a<k0> aVar, long j10, long j11, long j12, com.moloco.sdk.internal.ortb.model.i iVar) {
            super(10);
            this.f19802g = alignment;
            this.f19803h = paddingValues;
            this.f19804i = enumC0483a;
            this.f19805j = i10;
            this.f19806k = mVar;
            this.f19807l = aVar;
            this.f19808m = j10;
            this.f19809n = j11;
            this.f19810o = j12;
            this.f19811p = iVar;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@NotNull BoxScope boxScope, boolean z10, boolean z11, @NotNull h9.a<k0> onClick, @NotNull h9.l<? super a.AbstractC0481a.c, k0> onButtonRendered, boolean z12, int i10, int i11, @Nullable Composer composer, int i12) {
            int i13;
            kotlin.jvm.internal.t.i(boxScope, "$this$null");
            kotlin.jvm.internal.t.i(onClick, "onClick");
            kotlin.jvm.internal.t.i(onButtonRendered, "onButtonRendered");
            if ((i12 & 14) == 0) {
                i13 = (composer.changed(boxScope) ? 4 : 2) | i12;
            } else {
                i13 = i12;
            }
            if ((i12 & 112) == 0) {
                i13 |= composer.changed(z10) ? 32 : 16;
            }
            if ((i12 & 896) == 0) {
                i13 |= composer.changed(z11) ? 256 : 128;
            }
            if ((i12 & 7168) == 0) {
                i13 |= composer.changed(onClick) ? 2048 : 1024;
            }
            if ((57344 & i12) == 0) {
                i13 |= composer.changed(onButtonRendered) ? 16384 : 8192;
            }
            if ((458752 & i12) == 0) {
                i13 |= composer.changed(z12) ? 131072 : 65536;
            }
            if ((3670016 & i12) == 0) {
                i13 |= composer.changed(i10) ? 1048576 : 524288;
            }
            if ((i12 & 29360128) == 0) {
                i13 |= composer.changed(i11) ? 8388608 : 4194304;
            }
            int i14 = i13;
            if ((191739611 & i14) == 38347922 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1575255135, i14, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.adCountdownButton.<anonymous> (AdCountdownButton.kt:53)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z11, PaddingKt.padding(WindowInsetsPadding_androidKt.displayCutoutPadding(boxScope.align(Modifier.Companion, this.f19802g)), this.f19803h), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, 1799237255, true, new C0399a(this.f19804i, onButtonRendered, this.f19805j, i14, z10, this.f19806k, z12, i10, i11, onClick, this.f19807l, this.f19808m, this.f19809n, this.f19810o, this.f19811p)), composer, ((i14 >> 6) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.b
        public /* bridge */ /* synthetic */ k0 invoke(BoxScope boxScope, Boolean bool, Boolean bool2, h9.a<? extends k0> aVar, h9.l<? super a.AbstractC0481a.c, ? extends k0> lVar, Boolean bool3, c0 c0Var, c0 c0Var2, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), bool2.booleanValue(), aVar, lVar, bool3.booleanValue(), c0Var.g(), c0Var2.g(), composer, num.intValue());
            return k0.f35197a;
        }
    }

    @Composable
    @NotNull
    public static final h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> a(@NotNull Alignment alignment, @NotNull PaddingValues padding, long j10, long j11, long j12, @NotNull m afterCountdownButtonPart, @NotNull a.AbstractC0481a.c.EnumC0483a buttonType, @Nullable h9.a<k0> aVar, @Nullable com.moloco.sdk.internal.ortb.model.i iVar, @Nullable Composer composer, int i10) {
        kotlin.jvm.internal.t.i(alignment, "alignment");
        kotlin.jvm.internal.t.i(padding, "padding");
        kotlin.jvm.internal.t.i(afterCountdownButtonPart, "afterCountdownButtonPart");
        kotlin.jvm.internal.t.i(buttonType, "buttonType");
        composer.startReplaceableGroup(803707432);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(803707432, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.adCountdownButton (AdCountdownButton.kt:43)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 1575255135, true, new a(alignment, padding, buttonType, i10, afterCountdownButtonPart, aVar, j10, j11, j12, iVar));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }
}
