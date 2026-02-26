package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AccessibilityManager;
import h9.a;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: SnackbarHost.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SnackbarHostKt {
    private static final int SnackbarFadeInMillis = 150;
    private static final int SnackbarFadeOutMillis = 75;
    private static final int SnackbarInBetweenDelayMillis = 0;

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$3, reason: invalid class name */
    /* JADX INFO: compiled from: SnackbarHost.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ q<SnackbarData, Composer, Integer, k0> $content;
        final /* synthetic */ SnackbarData $current;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(SnackbarData snackbarData, Modifier modifier, q<? super SnackbarData, ? super Composer, ? super Integer, k0> qVar, int i10, int i11) {
            super(2);
            this.$current = snackbarData;
            this.$modifier = modifier;
            this.$content = qVar;
            this.$$changed = i10;
            this.$$default = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SnackbarHostKt.FadeInFadeOutWithScale(this.$current, this.$modifier, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarHostKt$SnackbarHost$1, reason: invalid class name */
    /* JADX INFO: compiled from: SnackbarHost.kt */
    @f(c = "androidx.compose.material.SnackbarHostKt$SnackbarHost$1", f = "SnackbarHost.kt", l = {164}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ AccessibilityManager $accessibilityManager;
        final /* synthetic */ SnackbarData $currentSnackbarData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SnackbarData snackbarData, AccessibilityManager accessibilityManager, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$currentSnackbarData = snackbarData;
            this.$accessibilityManager = accessibilityManager;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(this.$currentSnackbarData, this.$accessibilityManager, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                SnackbarData snackbarData = this.$currentSnackbarData;
                if (snackbarData != null) {
                    long millis = SnackbarHostKt.toMillis(snackbarData.getDuration(), this.$currentSnackbarData.getActionLabel() != null, this.$accessibilityManager);
                    this.label = 1;
                    if (y0.a(millis, this) == objE) {
                        return objE;
                    }
                }
                return k0.f35197a;
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            this.$currentSnackbarData.dismiss();
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarHostKt$SnackbarHost$2, reason: invalid class name */
    /* JADX INFO: compiled from: SnackbarHost.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ SnackbarHostState $hostState;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ q<SnackbarData, Composer, Integer, k0> $snackbar;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(SnackbarHostState snackbarHostState, Modifier modifier, q<? super SnackbarData, ? super Composer, ? super Integer, k0> qVar, int i10, int i11) {
            super(2);
            this.$hostState = snackbarHostState;
            this.$modifier = modifier;
            this.$snackbar = qVar;
            this.$$changed = i10;
            this.$$default = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SnackbarHostKt.SnackbarHost(this.$hostState, this.$modifier, this.$snackbar, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: compiled from: SnackbarHost.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SnackbarDuration.values().length];
            iArr[SnackbarDuration.Indefinite.ordinal()] = 1;
            iArr[SnackbarDuration.Long.ordinal()] = 2;
            iArr[SnackbarDuration.Short.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarHostKt$animatedOpacity$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SnackbarHost.kt */
    static final class C09401 extends v implements a<k0> {
        public static final C09401 INSTANCE = new C09401();

        C09401() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarHostKt$animatedOpacity$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SnackbarHost.kt */
    @f(c = "androidx.compose.material.SnackbarHostKt$animatedOpacity$2", f = "SnackbarHost.kt", l = {350}, m = "invokeSuspend")
    static final class C09412 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ Animatable<Float, AnimationVector1D> $alpha;
        final /* synthetic */ AnimationSpec<Float> $animation;
        final /* synthetic */ a<k0> $onAnimationFinish;
        final /* synthetic */ boolean $visible;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09412(Animatable<Float, AnimationVector1D> animatable, boolean z10, AnimationSpec<Float> animationSpec, a<k0> aVar, d<? super C09412> dVar) {
            super(2, dVar);
            this.$alpha = animatable;
            this.$visible = z10;
            this.$animation = animationSpec;
            this.$onAnimationFinish = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C09412(this.$alpha, this.$visible, this.$animation, this.$onAnimationFinish, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                Animatable<Float, AnimationVector1D> animatable = this.$alpha;
                Float fC = b.c(this.$visible ? 1.0f : 0.0f);
                AnimationSpec<Float> animationSpec = this.$animation;
                this.label = 1;
                if (Animatable.animateTo$default(animatable, fC, animationSpec, null, null, this, 12, null) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            this.$onAnimationFinish.invoke();
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C09412) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarHostKt$animatedScale$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SnackbarHost.kt */
    @f(c = "androidx.compose.material.SnackbarHostKt$animatedScale$1", f = "SnackbarHost.kt", l = {363}, m = "invokeSuspend")
    static final class C09421 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animation;
        final /* synthetic */ Animatable<Float, AnimationVector1D> $scale;
        final /* synthetic */ boolean $visible;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09421(Animatable<Float, AnimationVector1D> animatable, boolean z10, AnimationSpec<Float> animationSpec, d<? super C09421> dVar) {
            super(2, dVar);
            this.$scale = animatable;
            this.$visible = z10;
            this.$animation = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C09421(this.$scale, this.$visible, this.$animation, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                Animatable<Float, AnimationVector1D> animatable = this.$scale;
                Float fC = b.c(this.$visible ? 1.0f : 0.8f);
                AnimationSpec<Float> animationSpec = this.$animation;
                this.label = 1;
                if (Animatable.animateTo$default(animatable, fC, animationSpec, null, null, this, 12, null) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C09421) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x020e A[LOOP:2: B:79:0x020c->B:80:0x020e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FadeInFadeOutWithScale(androidx.compose.material.SnackbarData r18, androidx.compose.ui.Modifier r19, h9.q<? super androidx.compose.material.SnackbarData, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarHostKt.FadeInFadeOutWithScale(androidx.compose.material.SnackbarData, androidx.compose.ui.Modifier, h9.q, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SnackbarHost(@org.jetbrains.annotations.NotNull androidx.compose.material.SnackbarHostState r12, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r13, @org.jetbrains.annotations.Nullable h9.q<? super androidx.compose.material.SnackbarData, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r14, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r15, int r16, int r17) {
        /*
            r1 = r12
            r4 = r16
            java.lang.String r0 = "hostState"
            kotlin.jvm.internal.t.i(r12, r0)
            r0 = 431012348(0x19b0b9fc, float:1.8273092E-23)
            r2 = r15
            androidx.compose.runtime.Composer r0 = r15.startRestartGroup(r0)
            r2 = r17 & 1
            if (r2 == 0) goto L17
            r2 = r4 | 6
            goto L27
        L17:
            r2 = r4 & 14
            if (r2 != 0) goto L26
            boolean r2 = r0.changed(r12)
            if (r2 == 0) goto L23
            r2 = 4
            goto L24
        L23:
            r2 = 2
        L24:
            r2 = r2 | r4
            goto L27
        L26:
            r2 = r4
        L27:
            r3 = r17 & 2
            if (r3 == 0) goto L2e
            r2 = r2 | 48
            goto L40
        L2e:
            r5 = r4 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L40
            r5 = r13
            boolean r6 = r0.changed(r13)
            if (r6 == 0) goto L3c
            r6 = 32
            goto L3e
        L3c:
            r6 = 16
        L3e:
            r2 = r2 | r6
            goto L41
        L40:
            r5 = r13
        L41:
            r6 = r17 & 4
            if (r6 == 0) goto L48
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L5a
        L48:
            r7 = r4 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L5a
            r7 = r14
            boolean r8 = r0.changed(r14)
            if (r8 == 0) goto L56
            r8 = 256(0x100, float:3.59E-43)
            goto L58
        L56:
            r8 = 128(0x80, float:1.8E-43)
        L58:
            r2 = r2 | r8
            goto L5b
        L5a:
            r7 = r14
        L5b:
            r8 = r2 & 731(0x2db, float:1.024E-42)
            r9 = 146(0x92, float:2.05E-43)
            if (r8 != r9) goto L6e
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L68
            goto L6e
        L68:
            r0.skipToGroupEnd()
            r2 = r5
            r3 = r7
            goto Laa
        L6e:
            if (r3 == 0) goto L73
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L74
        L73:
            r3 = r5
        L74:
            if (r6 == 0) goto L7e
            androidx.compose.material.ComposableSingletons$SnackbarHostKt r5 = androidx.compose.material.ComposableSingletons$SnackbarHostKt.INSTANCE
            h9.q r5 = r5.m981getLambda1$material_release()
            r11 = r5
            goto L7f
        L7e:
            r11 = r7
        L7f:
            androidx.compose.material.SnackbarData r5 = r12.getCurrentSnackbarData()
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalAccessibilityManager()
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.ui.platform.AccessibilityManager r6 = (androidx.compose.ui.platform.AccessibilityManager) r6
            androidx.compose.material.SnackbarHostKt$SnackbarHost$1 r7 = new androidx.compose.material.SnackbarHostKt$SnackbarHost$1
            r8 = 0
            r7.<init>(r5, r6, r8)
            r6 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect(r5, r7, r0, r6)
            androidx.compose.material.SnackbarData r5 = r12.getCurrentSnackbarData()
            r6 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 & 896(0x380, float:1.256E-42)
            r9 = r6 | r2
            r10 = 0
            r6 = r3
            r7 = r11
            r8 = r0
            FadeInFadeOutWithScale(r5, r6, r7, r8, r9, r10)
            r2 = r3
            r3 = r11
        Laa:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto Lb1
            goto Lbf
        Lb1:
            androidx.compose.material.SnackbarHostKt$SnackbarHost$2 r7 = new androidx.compose.material.SnackbarHostKt$SnackbarHost$2
            r0 = r7
            r1 = r12
            r4 = r16
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarHostKt.SnackbarHost(androidx.compose.material.SnackbarHostState, androidx.compose.ui.Modifier, h9.q, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final State<Float> animatedOpacity(AnimationSpec<Float> animationSpec, boolean z10, a<k0> aVar, Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(1016418159);
        if ((i11 & 4) != 0) {
            aVar = C09401.INSTANCE;
        }
        a<k0> aVar2 = aVar;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = AnimatableKt.Animatable$default(!z10 ? 1.0f : 0.0f, 0.0f, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Animatable animatable = (Animatable) objRememberedValue;
        EffectsKt.LaunchedEffect(Boolean.valueOf(z10), new C09412(animatable, z10, animationSpec, aVar2, null), composer, (i10 >> 3) & 14);
        State<Float> stateAsState = animatable.asState();
        composer.endReplaceableGroup();
        return stateAsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final State<Float> animatedScale(AnimationSpec<Float> animationSpec, boolean z10, Composer composer, int i10) {
        composer.startReplaceableGroup(2003504988);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = AnimatableKt.Animatable$default(!z10 ? 1.0f : 0.8f, 0.0f, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Animatable animatable = (Animatable) objRememberedValue;
        EffectsKt.LaunchedEffect(Boolean.valueOf(z10), new C09421(animatable, z10, animationSpec, null), composer, (i10 >> 3) & 14);
        State<Float> stateAsState = animatable.asState();
        composer.endReplaceableGroup();
        return stateAsState;
    }

    public static final long toMillis(@NotNull SnackbarDuration snackbarDuration, boolean z10, @Nullable AccessibilityManager accessibilityManager) {
        long j10;
        t.i(snackbarDuration, "<this>");
        int i10 = WhenMappings.$EnumSwitchMapping$0[snackbarDuration.ordinal()];
        if (i10 == 1) {
            j10 = Long.MAX_VALUE;
        } else if (i10 == 2) {
            j10 = 10000;
        } else {
            if (i10 != 3) {
                throw new v8.q();
            }
            j10 = 4000;
        }
        long j11 = j10;
        return accessibilityManager == null ? j11 : accessibilityManager.calculateRecommendedTimeoutMillis(j11, true, true, z10);
    }
}
