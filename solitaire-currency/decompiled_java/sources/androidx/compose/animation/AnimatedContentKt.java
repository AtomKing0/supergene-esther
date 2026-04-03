package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntSize;
import h9.l;
import h9.p;
import h9.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatedContentKt {

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedContent.kt */
    static final class AnonymousClass1<S> extends v implements l<AnimatedContentScope<S>, ContentTransform> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final ContentTransform invoke(@NotNull AnimatedContentScope<S> animatedContentScope) {
            t.i(animatedContentScope, "$this$null");
            return AnimatedContentKt.with(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m54scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$2, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedContent.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ r<AnimatedVisibilityScope, S, Composer, Integer, k0> $content;
        final /* synthetic */ Alignment $contentAlignment;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ S $targetState;
        final /* synthetic */ l<AnimatedContentScope<S>, ContentTransform> $transitionSpec;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(S s10, Modifier modifier, l<? super AnimatedContentScope<S>, ContentTransform> lVar, Alignment alignment, r<? super AnimatedVisibilityScope, ? super S, ? super Composer, ? super Integer, k0> rVar, int i10, int i11) {
            super(2);
            this.$targetState = s10;
            this.$modifier = modifier;
            this.$transitionSpec = lVar;
            this.$contentAlignment = alignment;
            this.$content = rVar;
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
            AnimatedContentKt.AnimatedContent(this.$targetState, this.$modifier, this.$transitionSpec, this.$contentAlignment, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$3, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedContent.kt */
    static final class AnonymousClass3<S> extends v implements l<AnimatedContentScope<S>, ContentTransform> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final ContentTransform invoke(@NotNull AnimatedContentScope<S> animatedContentScope) {
            t.i(animatedContentScope, "$this$null");
            return AnimatedContentKt.with(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m54scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$8, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedContent.kt */
    static final class AnonymousClass8 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ r<AnimatedVisibilityScope, S, Composer, Integer, k0> $content;
        final /* synthetic */ Alignment $contentAlignment;
        final /* synthetic */ l<S, Object> $contentKey;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Transition<S> $this_AnimatedContent;
        final /* synthetic */ l<AnimatedContentScope<S>, ContentTransform> $transitionSpec;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass8(Transition<S> transition, Modifier modifier, l<? super AnimatedContentScope<S>, ContentTransform> lVar, Alignment alignment, l<? super S, ? extends Object> lVar2, r<? super AnimatedVisibilityScope, ? super S, ? super Composer, ? super Integer, k0> rVar, int i10, int i11) {
            super(2);
            this.$this_AnimatedContent = transition;
            this.$modifier = modifier;
            this.$transitionSpec = lVar;
            this.$contentAlignment = alignment;
            this.$contentKey = lVar2;
            this.$content = rVar;
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
            AnimatedContentKt.AnimatedContent(this.$this_AnimatedContent, this.$modifier, this.$transitionSpec, this.$contentAlignment, this.$contentKey, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$SizeTransform$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnimatedContent.kt */
    static final class C07761 extends v implements p<IntSize, IntSize, SpringSpec<IntSize>> {
        public static final C07761 INSTANCE = new C07761();

        C07761() {
            super(2);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ SpringSpec<IntSize> mo4invoke(IntSize intSize, IntSize intSize2) {
            return m7invokeTemP2vQ(intSize.m3837unboximpl(), intSize2.m3837unboximpl());
        }

        @NotNull
        /* JADX INFO: renamed from: invoke-TemP2vQ, reason: not valid java name */
        public final SpringSpec<IntSize> m7invokeTemP2vQ(long j10, long j11) {
            return AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m3825boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 3, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.animation.ExperimentalAnimationApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <S> void AnimatedContent(S r16, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r17, @org.jetbrains.annotations.Nullable h9.l<? super androidx.compose.animation.AnimatedContentScope<S>, androidx.compose.animation.ContentTransform> r18, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment r19, @org.jetbrains.annotations.NotNull h9.r<? super androidx.compose.animation.AnimatedVisibilityScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r20, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(java.lang.Object, androidx.compose.ui.Modifier, h9.l, androidx.compose.ui.Alignment, h9.r, androidx.compose.runtime.Composer, int, int):void");
    }

    @ExperimentalAnimationApi
    @NotNull
    public static final SizeTransform SizeTransform(boolean z10, @NotNull p<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> sizeAnimationSpec) {
        t.i(sizeAnimationSpec, "sizeAnimationSpec");
        return new SizeTransformImpl(z10, sizeAnimationSpec);
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z10, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            pVar = C07761.INSTANCE;
        }
        return SizeTransform(z10, pVar);
    }

    @ExperimentalAnimationApi
    @NotNull
    public static final ContentTransform with(@NotNull EnterTransition enterTransition, @NotNull ExitTransition exit) {
        t.i(enterTransition, "<this>");
        t.i(exit, "exit");
        return new ContentTransform(enterTransition, exit, 0.0f, null, 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0162  */
    @androidx.compose.runtime.Composable
    @androidx.compose.animation.ExperimentalAnimationApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <S> void AnimatedContent(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.Transition<S> r22, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r23, @org.jetbrains.annotations.Nullable h9.l<? super androidx.compose.animation.AnimatedContentScope<S>, androidx.compose.animation.ContentTransform> r24, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment r25, @org.jetbrains.annotations.Nullable h9.l<? super S, ? extends java.lang.Object> r26, @org.jetbrains.annotations.NotNull h9.r<? super androidx.compose.animation.AnimatedVisibilityScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r27, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            Method dump skipped, instruction units count: 933
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(androidx.compose.animation.core.Transition, androidx.compose.ui.Modifier, h9.l, androidx.compose.ui.Alignment, h9.l, h9.r, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$4, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedContent.kt */
    static final class AnonymousClass4<S> extends v implements l<S, S> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        AnonymousClass4() {
            super(1);
        }

        @Override // h9.l
        public final S invoke(S s10) {
            return s10;
        }
    }
}
