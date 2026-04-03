package androidx.compose.animation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import h9.l;
import h9.p;
import h9.q;
import h9.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
final class AnimatedContentKt$AnimatedContent$5$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ r<AnimatedVisibilityScope, S, Composer, Integer, k0> $content;
    final /* synthetic */ SnapshotStateList<S> $currentlyVisible;
    final /* synthetic */ AnimatedContentScope<S> $rootScope;
    final /* synthetic */ S $stateForContent;
    final /* synthetic */ Transition<S> $this_AnimatedContent;
    final /* synthetic */ l<AnimatedContentScope<S>, ContentTransform> $transitionSpec;

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedContent.kt */
    static final class AnonymousClass1 extends v implements q<MeasureScope, Measurable, Constraints, MeasureResult> {
        final /* synthetic */ ContentTransform $specOnEnter;

        /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AnimatedContent.kt */
        static final class C00281 extends v implements l<Placeable.PlacementScope, k0> {
            final /* synthetic */ Placeable $placeable;
            final /* synthetic */ ContentTransform $specOnEnter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00281(Placeable placeable, ContentTransform contentTransform) {
                super(1);
                this.$placeable = placeable;
                this.$specOnEnter = contentTransform;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Placeable.PlacementScope layout) {
                t.i(layout, "$this$layout");
                layout.place(this.$placeable, 0, 0, this.$specOnEnter.getTargetContentZIndex());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ContentTransform contentTransform) {
            super(3);
            this.$specOnEnter = contentTransform;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
            return m6invoke3p2s80s(measureScope, measurable, constraints.m3647unboximpl());
        }

        @NotNull
        /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
        public final MeasureResult m6invoke3p2s80s(@NotNull MeasureScope layout, @NotNull Measurable measurable, long j10) {
            t.i(layout, "$this$layout");
            t.i(measurable, "measurable");
            Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(j10);
            return MeasureScope.CC.p(layout, placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight(), null, new C00281(placeableMo2987measureBRTryo0, this.$specOnEnter), 4, null);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedContent.kt */
    static final class AnonymousClass3<S> extends v implements l<S, Boolean> {
        final /* synthetic */ S $stateForContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(S s10) {
            super(1);
            this.$stateForContent = s10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.l
        @NotNull
        public final Boolean invoke(S s10) {
            return Boolean.valueOf(t.d(s10, this.$stateForContent));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedContent.kt */
    static final class AnonymousClass4 extends v implements q<AnimatedVisibilityScope, Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ r<AnimatedVisibilityScope, S, Composer, Integer, k0> $content;
        final /* synthetic */ SnapshotStateList<S> $currentlyVisible;
        final /* synthetic */ AnimatedContentScope<S> $rootScope;
        final /* synthetic */ S $stateForContent;

        /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: AnimatedContent.kt */
        static final class AnonymousClass1 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
            final /* synthetic */ SnapshotStateList<S> $currentlyVisible;
            final /* synthetic */ AnimatedContentScope<S> $rootScope;
            final /* synthetic */ S $stateForContent;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SnapshotStateList<S> snapshotStateList, S s10, AnimatedContentScope<S> animatedContentScope) {
                super(1);
                this.$currentlyVisible = snapshotStateList;
                this.$stateForContent = s10;
                this.$rootScope = animatedContentScope;
            }

            @Override // h9.l
            @NotNull
            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
                t.i(DisposableEffect, "$this$DisposableEffect");
                final SnapshotStateList<S> snapshotStateList = this.$currentlyVisible;
                final S s10 = this.$stateForContent;
                final AnimatedContentScope<S> animatedContentScope = this.$rootScope;
                return new DisposableEffectResult() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$4$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        snapshotStateList.remove(s10);
                        animatedContentScope.getTargetSizeMap$animation_release().remove(s10);
                    }
                };
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(AnimatedContentScope<S> animatedContentScope, S s10, r<? super AnimatedVisibilityScope, ? super S, ? super Composer, ? super Integer, k0> rVar, int i10, SnapshotStateList<S> snapshotStateList) {
            super(3);
            this.$rootScope = animatedContentScope;
            this.$stateForContent = s10;
            this.$content = rVar;
            this.$$dirty = i10;
            this.$currentlyVisible = snapshotStateList;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
            invoke(animatedVisibilityScope, composer, num.intValue());
            return k0.f35197a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@NotNull AnimatedVisibilityScope AnimatedVisibility, @Nullable Composer composer, int i10) {
            t.i(AnimatedVisibility, "$this$AnimatedVisibility");
            if ((i10 & 14) == 0) {
                i10 |= composer.changed(AnimatedVisibility) ? 4 : 2;
            }
            if ((i10 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            int i11 = i10 & 14;
            EffectsKt.DisposableEffect(AnimatedVisibility, new AnonymousClass1(this.$currentlyVisible, this.$stateForContent, this.$rootScope), composer, i11);
            this.$rootScope.getTargetSizeMap$animation_release().put(this.$stateForContent, ((AnimatedVisibilityScopeImpl) AnimatedVisibility).getTargetSize$animation_release());
            this.$content.invoke(AnimatedVisibility, this.$stateForContent, composer, Integer.valueOf(i11 | ((this.$$dirty >> 9) & 896)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AnimatedContentKt$AnimatedContent$5$1(Transition<S> transition, S s10, int i10, l<? super AnimatedContentScope<S>, ContentTransform> lVar, AnimatedContentScope<S> animatedContentScope, r<? super AnimatedVisibilityScope, ? super S, ? super Composer, ? super Integer, k0> rVar, SnapshotStateList<S> snapshotStateList) {
        super(2);
        this.$this_AnimatedContent = transition;
        this.$stateForContent = s10;
        this.$$dirty = i10;
        this.$transitionSpec = lVar;
        this.$rootScope = animatedContentScope;
        this.$content = rVar;
        this.$currentlyVisible = snapshotStateList;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i10) {
        if ((i10 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        l<AnimatedContentScope<S>, ContentTransform> lVar = this.$transitionSpec;
        Object obj = this.$rootScope;
        composer.startReplaceableGroup(-492369756);
        ContentTransform contentTransformRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (contentTransformRememberedValue == companion.getEmpty()) {
            contentTransformRememberedValue = lVar.invoke(obj);
            composer.updateRememberedValue(contentTransformRememberedValue);
        }
        composer.endReplaceableGroup();
        ContentTransform contentTransform = (ContentTransform) contentTransformRememberedValue;
        Boolean boolValueOf = Boolean.valueOf(t.d(this.$this_AnimatedContent.getSegment().getTargetState(), this.$stateForContent));
        l<AnimatedContentScope<S>, ContentTransform> lVar2 = this.$transitionSpec;
        Object obj2 = this.$rootScope;
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(boolValueOf);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == companion.getEmpty()) {
            objRememberedValue = lVar2.invoke(obj2).getInitialContentExit();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        ExitTransition exitTransition = (ExitTransition) objRememberedValue;
        S s10 = this.$stateForContent;
        Transition<S> transition = this.$this_AnimatedContent;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new AnimatedContentScope.ChildData(t.d(s10, transition.getTargetState()));
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        AnimatedContentScope.ChildData childData = (AnimatedContentScope.ChildData) objRememberedValue2;
        EnterTransition targetContentEnter = contentTransform.getTargetContentEnter();
        Modifier modifierLayout = LayoutModifierKt.layout(Modifier.Companion, new AnonymousClass1(contentTransform));
        childData.setTarget(t.d(this.$stateForContent, this.$this_AnimatedContent.getTargetState()));
        AnimatedVisibilityKt.AnimatedVisibility(this.$this_AnimatedContent, new AnonymousClass3(this.$stateForContent), modifierLayout.then(childData), targetContentEnter, exitTransition, ComposableLambdaKt.composableLambda(composer, -1816907410, true, new AnonymousClass4(this.$rootScope, this.$stateForContent, this.$content, this.$$dirty, this.$currentlyVisible)), composer, 196608 | (this.$$dirty & 14), 0);
    }
}
