package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.a;
import h9.l;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
final class ModalBottomSheetKt$ModalBottomSheetLayout$1 extends v implements q<BoxWithConstraintsScope, Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ o0 $scope;
    final /* synthetic */ long $scrimColor;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ ModalBottomSheetState $sheetState;

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    static final class AnonymousClass4 extends v implements l<SemanticsPropertyReceiver, k0> {
        final /* synthetic */ o0 $scope;
        final /* synthetic */ ModalBottomSheetState $sheetState;

        /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: ModalBottomSheet.kt */
        static final class AnonymousClass1 extends v implements a<Boolean> {
            final /* synthetic */ o0 $scope;
            final /* synthetic */ ModalBottomSheetState $sheetState;

            /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: ModalBottomSheet.kt */
            @f(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$1$1", f = "ModalBottomSheet.kt", l = {363}, m = "invokeSuspend")
            static final class C01011 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
                final /* synthetic */ ModalBottomSheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01011(ModalBottomSheetState modalBottomSheetState, d<? super C01011> dVar) {
                    super(2, dVar);
                    this.$sheetState = modalBottomSheetState;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                    return new C01011(this.$sheetState, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.label;
                    if (i10 == 0) {
                        u.b(obj);
                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                        this.label = 1;
                        if (modalBottomSheetState.hide(this) == objE) {
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
                    return ((C01011) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ModalBottomSheetState modalBottomSheetState, o0 o0Var) {
                super(0);
                this.$sheetState = modalBottomSheetState;
                this.$scope = o0Var;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final Boolean invoke() {
                if (this.$sheetState.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                    k.d(this.$scope, null, null, new C01011(this.$sheetState, null), 3, null);
                }
                return Boolean.TRUE;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$2, reason: invalid class name */
        /* JADX INFO: compiled from: ModalBottomSheet.kt */
        static final class AnonymousClass2 extends v implements a<Boolean> {
            final /* synthetic */ o0 $scope;
            final /* synthetic */ ModalBottomSheetState $sheetState;

            /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: ModalBottomSheet.kt */
            @f(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$2$1", f = "ModalBottomSheet.kt", l = {370}, m = "invokeSuspend")
            static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
                final /* synthetic */ ModalBottomSheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(ModalBottomSheetState modalBottomSheetState, d<? super AnonymousClass1> dVar) {
                    super(2, dVar);
                    this.$sheetState = modalBottomSheetState;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                    return new AnonymousClass1(this.$sheetState, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.label;
                    if (i10 == 0) {
                        u.b(obj);
                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                        this.label = 1;
                        if (modalBottomSheetState.expand$material_release(this) == objE) {
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
                    return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(ModalBottomSheetState modalBottomSheetState, o0 o0Var) {
                super(0);
                this.$sheetState = modalBottomSheetState;
                this.$scope = o0Var;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final Boolean invoke() {
                if (this.$sheetState.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Expanded).booleanValue()) {
                    k.d(this.$scope, null, null, new AnonymousClass1(this.$sheetState, null), 3, null);
                }
                return Boolean.TRUE;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$3, reason: invalid class name */
        /* JADX INFO: compiled from: ModalBottomSheet.kt */
        static final class AnonymousClass3 extends v implements a<Boolean> {
            final /* synthetic */ o0 $scope;
            final /* synthetic */ ModalBottomSheetState $sheetState;

            /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: ModalBottomSheet.kt */
            @f(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$3$1", f = "ModalBottomSheet.kt", l = {377}, m = "invokeSuspend")
            static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
                final /* synthetic */ ModalBottomSheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(ModalBottomSheetState modalBottomSheetState, d<? super AnonymousClass1> dVar) {
                    super(2, dVar);
                    this.$sheetState = modalBottomSheetState;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                    return new AnonymousClass1(this.$sheetState, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.label;
                    if (i10 == 0) {
                        u.b(obj);
                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                        this.label = 1;
                        if (modalBottomSheetState.halfExpand$material_release(this) == objE) {
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
                    return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(ModalBottomSheetState modalBottomSheetState, o0 o0Var) {
                super(0);
                this.$sheetState = modalBottomSheetState;
                this.$scope = o0Var;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final Boolean invoke() {
                if (this.$sheetState.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.HalfExpanded).booleanValue()) {
                    k.d(this.$scope, null, null, new AnonymousClass1(this.$sheetState, null), 3, null);
                }
                return Boolean.TRUE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(ModalBottomSheetState modalBottomSheetState, o0 o0Var) {
            super(1);
            this.$sheetState = modalBottomSheetState;
            this.$scope = o0Var;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            invoke2(semanticsPropertyReceiver);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
            t.i(semantics, "$this$semantics");
            if (this.$sheetState.isVisible()) {
                SemanticsPropertiesKt.dismiss$default(semantics, null, new AnonymousClass1(this.$sheetState, this.$scope), 1, null);
                if (this.$sheetState.getCurrentValue() == ModalBottomSheetValue.HalfExpanded) {
                    SemanticsPropertiesKt.expand$default(semantics, null, new AnonymousClass2(this.$sheetState, this.$scope), 1, null);
                } else if (this.$sheetState.getHasHalfExpandedState$material_release()) {
                    SemanticsPropertiesKt.collapse$default(semantics, null, new AnonymousClass3(this.$sheetState, this.$scope), 1, null);
                }
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$5, reason: invalid class name */
    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    static final class AnonymousClass5 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $sheetContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass5(q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar, int i10) {
            super(2);
            this.$sheetContent = qVar;
            this.$$dirty = i10;
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
            q<ColumnScope, Composer, Integer, k0> qVar = this.$sheetContent;
            int i11 = (this.$$dirty << 9) & 7168;
            composer.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion;
            int i12 = i11 >> 3;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, (i12 & 112) | (i12 & 14));
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            a<ComposeUiNode> constructor = companion2.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(companion);
            int i13 = ((((i11 << 3) & 112) << 9) & 7168) | 6;
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composer);
            Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl, density, companion2.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
            composer.enableReusing();
            qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, Integer.valueOf((i13 >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-1163856341);
            if (((i13 >> 9) & 14 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                qVar.invoke(ColumnScopeInstance.INSTANCE, composer, Integer.valueOf(((i11 >> 6) & 112) | 6));
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ModalBottomSheetKt$ModalBottomSheetLayout$1(ModalBottomSheetState modalBottomSheetState, int i10, Shape shape, long j10, long j11, float f10, p<? super Composer, ? super Integer, k0> pVar, long j12, o0 o0Var, q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar) {
        super(3);
        this.$sheetState = modalBottomSheetState;
        this.$$dirty = i10;
        this.$sheetShape = shape;
        this.$sheetBackgroundColor = j10;
        this.$sheetContentColor = j11;
        this.$sheetElevation = f10;
        this.$content = pVar;
        this.$scrimColor = j12;
        this.$scope = o0Var;
        this.$sheetContent = qVar;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
        invoke(boxWithConstraintsScope, composer, num.intValue());
        return k0.f35197a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull BoxWithConstraintsScope BoxWithConstraints, @Nullable Composer composer, int i10) {
        int i11;
        float f10;
        t.i(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((i10 & 14) == 0) {
            i11 = i10 | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if ((i11 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        float fM3640getMaxHeightimpl = Constraints.m3640getMaxHeightimpl(BoxWithConstraints.mo371getConstraintsmsEJaDk());
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        Modifier.Companion companion2 = Modifier.Companion;
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
        p<Composer, Integer, k0> pVar = this.$content;
        int i12 = this.$$dirty;
        long j10 = this.$scrimColor;
        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
        o0 o0Var = this.$scope;
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
        a<ComposeUiNode> constructor = companion3.getConstructor();
        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierFillMaxSize$default);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composer);
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion3.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
        composer.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composer.startReplaceableGroup(-402723888);
        pVar.mo4invoke(composer, Integer.valueOf((i12 >> 24) & 14));
        ModalBottomSheetKt.m1065Scrim3JVO9M(j10, new ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1(modalBottomSheetState, o0Var), modalBottomSheetState.getTargetValue() != ModalBottomSheetValue.Hidden, composer, (i12 >> 21) & 14);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        Modifier modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), this.$sheetState.getNestedScrollConnection$material_release(), null, 2, null);
        Object obj = this.$sheetState;
        Object objValueOf = Float.valueOf(fM3640getMaxHeightimpl);
        ModalBottomSheetState modalBottomSheetState2 = this.$sheetState;
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(obj) | composer.changed(objValueOf);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == companion.getEmpty()) {
            f10 = fM3640getMaxHeightimpl;
            objRememberedValue2 = new ModalBottomSheetKt$ModalBottomSheetLayout$1$2$1(modalBottomSheetState2, f10);
            composer.updateRememberedValue(objRememberedValue2);
        } else {
            f10 = fM3640getMaxHeightimpl;
        }
        composer.endReplaceableGroup();
        Modifier modifierBottomSheetSwipeable = ModalBottomSheetKt.bottomSheetSwipeable(OffsetKt.offset(modifierNestedScroll$default, (l) objRememberedValue2), this.$sheetState, f10, mutableState);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged2 = composer.changed(mutableState);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = new ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1(mutableState);
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceableGroup();
        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierBottomSheetSwipeable, (l) objRememberedValue3), false, new AnonymousClass4(this.$sheetState, this.$scope), 1, null);
        Shape shape = this.$sheetShape;
        long j11 = this.$sheetBackgroundColor;
        long j12 = this.$sheetContentColor;
        float f11 = this.$sheetElevation;
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1793508390, true, new AnonymousClass5(this.$sheetContent, this.$$dirty));
        int i13 = this.$$dirty;
        SurfaceKt.m1147SurfaceFjzlyU(modifierSemantics$default, shape, j11, j12, null, f11, composableLambda, composer, ((i13 >> 6) & 112) | 1572864 | ((i13 >> 9) & 896) | ((i13 >> 9) & 7168) | ((i13 << 3) & 458752), 16);
    }
}
