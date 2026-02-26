package androidx.compose.foundation;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.m0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.e0;
import s9.x;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Magnifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MagnifierKt {

    @NotNull
    private static final SemanticsPropertyKey<h9.a<Offset>> MagnifierPositionInRoot = new SemanticsPropertyKey<>("MagnifierPositionInRoot", null, 2, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierKt$magnifier$1, reason: invalid class name */
    /* JADX INFO: compiled from: Magnifier.kt */
    public static final class AnonymousClass1 extends v implements h9.l<Density, Offset> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Offset invoke(Density density) {
            return Offset.m1356boximpl(m213invoketuRUvjQ(density));
        }

        /* JADX INFO: renamed from: invoke-tuRUvjQ, reason: not valid java name */
        public final long m213invoketuRUvjQ(@NotNull Density density) {
            t.i(density, "$this$null");
            return Offset.Companion.m1382getUnspecifiedF1C5BW0();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4, reason: invalid class name */
    /* JADX INFO: compiled from: Magnifier.kt */
    static final class AnonymousClass4 extends v implements h9.q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ h9.l<Density, Offset> $magnifierCenter;
        final /* synthetic */ h9.l<DpSize, k0> $onSizeChanged;
        final /* synthetic */ PlatformMagnifierFactory $platformMagnifierFactory;
        final /* synthetic */ h9.l<Density, Offset> $sourceCenter;
        final /* synthetic */ MagnifierStyle $style;
        final /* synthetic */ float $zoom;

        /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: Magnifier.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.MagnifierKt$magnifier$4$1", f = "Magnifier.kt", l = {365}, m = "invokeSuspend")
        static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {
            final /* synthetic */ MutableState<Offset> $anchorPositionInRoot$delegate;
            final /* synthetic */ Density $density;
            final /* synthetic */ State<Boolean> $isMagnifierShown$delegate;
            final /* synthetic */ x<k0> $onNeedsUpdate;
            final /* synthetic */ PlatformMagnifierFactory $platformMagnifierFactory;
            final /* synthetic */ State<Offset> $sourceCenterInRoot$delegate;
            final /* synthetic */ MagnifierStyle $style;
            final /* synthetic */ State<h9.l<Density, Offset>> $updatedMagnifierCenter$delegate;
            final /* synthetic */ State<h9.l<DpSize, k0>> $updatedOnSizeChanged$delegate;
            final /* synthetic */ State<Float> $updatedZoom$delegate;
            final /* synthetic */ View $view;
            final /* synthetic */ float $zoom;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Magnifier.kt */
            @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.MagnifierKt$magnifier$4$1$1", f = "Magnifier.kt", l = {}, m = "invokeSuspend")
            static final class C00341 extends kotlin.coroutines.jvm.internal.l implements h9.p<k0, z8.d<? super k0>, Object> {
                final /* synthetic */ PlatformMagnifier $magnifier;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00341(PlatformMagnifier platformMagnifier, z8.d<? super C00341> dVar) {
                    super(2, dVar);
                    this.$magnifier = platformMagnifier;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new C00341(this.$magnifier, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    a9.d.e();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                    this.$magnifier.updateContent();
                    return k0.f35197a;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull k0 k0Var, @Nullable z8.d<? super k0> dVar) {
                    return ((C00341) create(k0Var, dVar)).invokeSuspend(k0.f35197a);
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Magnifier.kt */
            static final class AnonymousClass2 extends v implements h9.a<k0> {
                final /* synthetic */ MutableState<Offset> $anchorPositionInRoot$delegate;
                final /* synthetic */ Density $density;
                final /* synthetic */ State<Boolean> $isMagnifierShown$delegate;
                final /* synthetic */ PlatformMagnifier $magnifier;
                final /* synthetic */ m0 $previousSize;
                final /* synthetic */ State<Offset> $sourceCenterInRoot$delegate;
                final /* synthetic */ State<h9.l<Density, Offset>> $updatedMagnifierCenter$delegate;
                final /* synthetic */ State<h9.l<DpSize, k0>> $updatedOnSizeChanged$delegate;
                final /* synthetic */ State<Float> $updatedZoom$delegate;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass2(PlatformMagnifier platformMagnifier, Density density, State<Boolean> state, State<Offset> state2, State<? extends h9.l<? super Density, Offset>> state3, MutableState<Offset> mutableState, State<Float> state4, m0 m0Var, State<? extends h9.l<? super DpSize, k0>> state5) {
                    super(0);
                    this.$magnifier = platformMagnifier;
                    this.$density = density;
                    this.$isMagnifierShown$delegate = state;
                    this.$sourceCenterInRoot$delegate = state2;
                    this.$updatedMagnifierCenter$delegate = state3;
                    this.$anchorPositionInRoot$delegate = mutableState;
                    this.$updatedZoom$delegate = state4;
                    this.$previousSize = m0Var;
                    this.$updatedOnSizeChanged$delegate = state5;
                }

                @Override // h9.a
                public /* bridge */ /* synthetic */ k0 invoke() {
                    invoke2();
                    return k0.f35197a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (!AnonymousClass4.m223invoke$lambda10(this.$isMagnifierShown$delegate)) {
                        this.$magnifier.dismiss();
                        return;
                    }
                    PlatformMagnifier platformMagnifier = this.$magnifier;
                    long jM229invoke$lambda8 = AnonymousClass4.m229invoke$lambda8(this.$sourceCenterInRoot$delegate);
                    Object objInvoke = AnonymousClass4.m226invoke$lambda4(this.$updatedMagnifierCenter$delegate).invoke(this.$density);
                    MutableState<Offset> mutableState = this.$anchorPositionInRoot$delegate;
                    long jM1377unboximpl = ((Offset) objInvoke).m1377unboximpl();
                    platformMagnifier.mo237updateWko1d7g(jM229invoke$lambda8, OffsetKt.m1386isSpecifiedk4lQ0M(jM1377unboximpl) ? Offset.m1372plusMKHz9U(AnonymousClass4.m222invoke$lambda1(mutableState), jM1377unboximpl) : Offset.Companion.m1382getUnspecifiedF1C5BW0(), AnonymousClass4.m227invoke$lambda5(this.$updatedZoom$delegate));
                    long jMo236getSizeYbymL2g = this.$magnifier.mo236getSizeYbymL2g();
                    m0 m0Var = this.$previousSize;
                    Density density = this.$density;
                    State<h9.l<DpSize, k0>> state = this.$updatedOnSizeChanged$delegate;
                    if (IntSize.m3831equalsimpl0(jMo236getSizeYbymL2g, m0Var.f29833a)) {
                        return;
                    }
                    m0Var.f29833a = jMo236getSizeYbymL2g;
                    h9.l lVarM228invoke$lambda6 = AnonymousClass4.m228invoke$lambda6(state);
                    if (lVarM228invoke$lambda6 != null) {
                        lVarM228invoke$lambda6.invoke(DpSize.m3759boximpl(density.mo294toDpSizekrfVVM(IntSizeKt.m3843toSizeozmzZPI(jMo236getSizeYbymL2g))));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(PlatformMagnifierFactory platformMagnifierFactory, MagnifierStyle magnifierStyle, View view, Density density, float f10, x<k0> xVar, State<? extends h9.l<? super DpSize, k0>> state, State<Boolean> state2, State<Offset> state3, State<? extends h9.l<? super Density, Offset>> state4, MutableState<Offset> mutableState, State<Float> state5, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$platformMagnifierFactory = platformMagnifierFactory;
                this.$style = magnifierStyle;
                this.$view = view;
                this.$density = density;
                this.$zoom = f10;
                this.$onNeedsUpdate = xVar;
                this.$updatedOnSizeChanged$delegate = state;
                this.$isMagnifierShown$delegate = state2;
                this.$sourceCenterInRoot$delegate = state3;
                this.$updatedMagnifierCenter$delegate = state4;
                this.$anchorPositionInRoot$delegate = mutableState;
                this.$updatedZoom$delegate = state5;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$platformMagnifierFactory, this.$style, this.$view, this.$density, this.$zoom, this.$onNeedsUpdate, this.$updatedOnSizeChanged$delegate, this.$isMagnifierShown$delegate, this.$sourceCenterInRoot$delegate, this.$updatedMagnifierCenter$delegate, this.$anchorPositionInRoot$delegate, this.$updatedZoom$delegate, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                PlatformMagnifier platformMagnifier;
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    platformMagnifier = (PlatformMagnifier) this.L$0;
                    try {
                        u.b(obj);
                        platformMagnifier.dismiss();
                        return k0.f35197a;
                    } catch (Throwable th) {
                        th = th;
                        platformMagnifier.dismiss();
                        throw th;
                    }
                }
                u.b(obj);
                o0 o0Var = (o0) this.L$0;
                PlatformMagnifier platformMagnifierCreate = this.$platformMagnifierFactory.create(this.$style, this.$view, this.$density, this.$zoom);
                m0 m0Var = new m0();
                long jMo236getSizeYbymL2g = platformMagnifierCreate.mo236getSizeYbymL2g();
                Density density = this.$density;
                h9.l lVarM228invoke$lambda6 = AnonymousClass4.m228invoke$lambda6(this.$updatedOnSizeChanged$delegate);
                if (lVarM228invoke$lambda6 != null) {
                    lVarM228invoke$lambda6.invoke(DpSize.m3759boximpl(density.mo294toDpSizekrfVVM(IntSizeKt.m3843toSizeozmzZPI(jMo236getSizeYbymL2g))));
                }
                m0Var.f29833a = jMo236getSizeYbymL2g;
                s9.j.D(s9.j.G(this.$onNeedsUpdate, new C00341(platformMagnifierCreate, null)), o0Var);
                try {
                    s9.h hVarSnapshotFlow = SnapshotStateKt.snapshotFlow(new AnonymousClass2(platformMagnifierCreate, this.$density, this.$isMagnifierShown$delegate, this.$sourceCenterInRoot$delegate, this.$updatedMagnifierCenter$delegate, this.$anchorPositionInRoot$delegate, this.$updatedZoom$delegate, m0Var, this.$updatedOnSizeChanged$delegate));
                    this.L$0 = platformMagnifierCreate;
                    this.label = 1;
                    if (s9.j.k(hVarSnapshotFlow, this) == objE) {
                        return objE;
                    }
                    platformMagnifier = platformMagnifierCreate;
                    platformMagnifier.dismiss();
                    return k0.f35197a;
                } catch (Throwable th2) {
                    th = th2;
                    platformMagnifier = platformMagnifierCreate;
                    platformMagnifier.dismiss();
                    throw th;
                }
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$2, reason: invalid class name */
        /* JADX INFO: compiled from: Magnifier.kt */
        static final class AnonymousClass2 extends v implements h9.l<LayoutCoordinates, k0> {
            final /* synthetic */ MutableState<Offset> $anchorPositionInRoot$delegate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(MutableState<Offset> mutableState) {
                super(1);
                this.$anchorPositionInRoot$delegate = mutableState;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull LayoutCoordinates it) {
                t.i(it, "it");
                AnonymousClass4.m224invoke$lambda2(this.$anchorPositionInRoot$delegate, LayoutCoordinatesKt.positionInRoot(it));
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$3, reason: invalid class name */
        /* JADX INFO: compiled from: Magnifier.kt */
        static final class AnonymousClass3 extends v implements h9.l<DrawScope, k0> {
            final /* synthetic */ x<k0> $onNeedsUpdate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(x<k0> xVar) {
                super(1);
                this.$onNeedsUpdate = xVar;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DrawScope drawBehind) {
                t.i(drawBehind, "$this$drawBehind");
                this.$onNeedsUpdate.a(k0.f35197a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$4, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Magnifier.kt */
        static final class C00354 extends v implements h9.l<SemanticsPropertyReceiver, k0> {
            final /* synthetic */ State<Offset> $sourceCenterInRoot$delegate;

            /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$4$1, reason: invalid class name */
            /* JADX INFO: compiled from: Magnifier.kt */
            static final class AnonymousClass1 extends v implements h9.a<Offset> {
                final /* synthetic */ State<Offset> $sourceCenterInRoot$delegate;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(State<Offset> state) {
                    super(0);
                    this.$sourceCenterInRoot$delegate = state;
                }

                @Override // h9.a
                public /* bridge */ /* synthetic */ Offset invoke() {
                    return Offset.m1356boximpl(m230invokeF1C5BW0());
                }

                /* JADX INFO: renamed from: invoke-F1C5BW0, reason: not valid java name */
                public final long m230invokeF1C5BW0() {
                    return AnonymousClass4.m229invoke$lambda8(this.$sourceCenterInRoot$delegate);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00354(State<Offset> state) {
                super(1);
                this.$sourceCenterInRoot$delegate = state;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                t.i(semantics, "$this$semantics");
                semantics.set(MagnifierKt.getMagnifierPositionInRoot(), new AnonymousClass1(this.$sourceCenterInRoot$delegate));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(h9.l<? super Density, Offset> lVar, h9.l<? super Density, Offset> lVar2, float f10, h9.l<? super DpSize, k0> lVar3, PlatformMagnifierFactory platformMagnifierFactory, MagnifierStyle magnifierStyle) {
            super(3);
            this.$sourceCenter = lVar;
            this.$magnifierCenter = lVar2;
            this.$zoom = f10;
            this.$onSizeChanged = lVar3;
            this.$platformMagnifierFactory = platformMagnifierFactory;
            this.$style = magnifierStyle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-1, reason: not valid java name */
        public static final long m222invoke$lambda1(MutableState<Offset> mutableState) {
            return mutableState.getValue().m1377unboximpl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-10, reason: not valid java name */
        public static final boolean m223invoke$lambda10(State<Boolean> state) {
            return state.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-2, reason: not valid java name */
        public static final void m224invoke$lambda2(MutableState<Offset> mutableState, long j10) {
            mutableState.setValue(Offset.m1356boximpl(j10));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-3, reason: not valid java name */
        public static final h9.l<Density, Offset> m225invoke$lambda3(State<? extends h9.l<? super Density, Offset>> state) {
            return (h9.l) state.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-4, reason: not valid java name */
        public static final h9.l<Density, Offset> m226invoke$lambda4(State<? extends h9.l<? super Density, Offset>> state) {
            return (h9.l) state.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-5, reason: not valid java name */
        public static final float m227invoke$lambda5(State<Float> state) {
            return state.getValue().floatValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-6, reason: not valid java name */
        public static final h9.l<DpSize, k0> m228invoke$lambda6(State<? extends h9.l<? super DpSize, k0>> state) {
            return (h9.l) state.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-8, reason: not valid java name */
        public static final long m229invoke$lambda8(State<Offset> state) {
            return state.getValue().m1377unboximpl();
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-454877003);
            View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m1356boximpl(Offset.Companion.m1382getUnspecifiedF1C5BW0()), null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue;
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$sourceCenter, composer, 0);
            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(this.$magnifierCenter, composer, 0);
            State stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(Float.valueOf(this.$zoom), composer, 0);
            State stateRememberUpdatedState4 = SnapshotStateKt.rememberUpdatedState(this.$onSizeChanged, composer, 0);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new MagnifierKt$magnifier$4$sourceCenterInRoot$2$1(density, stateRememberUpdatedState, mutableState));
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            State state = (State) objRememberedValue2;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new MagnifierKt$magnifier$4$isMagnifierShown$2$1(state));
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            State state2 = (State) objRememberedValue3;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = e0.b(1, 0, r9.a.DROP_OLDEST, 2, null);
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceableGroup();
            x xVar = (x) objRememberedValue4;
            float f10 = this.$platformMagnifierFactory.getCanUpdateZoom() ? 0.0f : this.$zoom;
            MagnifierStyle magnifierStyle = this.$style;
            EffectsKt.LaunchedEffect(new Object[]{view, density, Float.valueOf(f10), magnifierStyle, Boolean.valueOf(t.d(magnifierStyle, MagnifierStyle.Companion.getTextDefault()))}, (h9.p<? super o0, ? super z8.d<? super k0>, ? extends Object>) new AnonymousClass1(this.$platformMagnifierFactory, this.$style, view, density, this.$zoom, xVar, stateRememberUpdatedState4, state2, state, stateRememberUpdatedState2, mutableState, stateRememberUpdatedState3, null), composer, 8);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(DrawModifierKt.drawBehind(OnGloballyPositionedModifierKt.onGloballyPositioned(composed, new AnonymousClass2(mutableState)), new AnonymousClass3(xVar)), false, new C00354(state), 1, null);
            composer.endReplaceableGroup();
            return modifierSemantics$default;
        }
    }

    @NotNull
    public static final SemanticsPropertyKey<h9.a<Offset>> getMagnifierPositionInRoot() {
        return MagnifierPositionInRoot;
    }

    @ChecksSdkIntAtLeast(api = 28)
    public static final boolean isPlatformMagnifierSupported(int i10) {
        return i10 >= 28;
    }

    public static /* synthetic */ boolean isPlatformMagnifierSupported$default(int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = Build.VERSION.SDK_INT;
        }
        return isPlatformMagnifierSupported(i10);
    }

    @RequiresApi(28)
    @SuppressLint({"ModifierInspectorInfo"})
    @NotNull
    public static final Modifier magnifier(@NotNull Modifier modifier, @NotNull h9.l<? super Density, Offset> sourceCenter, @NotNull h9.l<? super Density, Offset> magnifierCenter, float f10, @NotNull MagnifierStyle style, @Nullable h9.l<? super DpSize, k0> lVar, @NotNull PlatformMagnifierFactory platformMagnifierFactory) {
        t.i(modifier, "<this>");
        t.i(sourceCenter, "sourceCenter");
        t.i(magnifierCenter, "magnifierCenter");
        t.i(style, "style");
        t.i(platformMagnifierFactory, "platformMagnifierFactory");
        return ComposedModifierKt.composed$default(modifier, null, new AnonymousClass4(sourceCenter, magnifierCenter, f10, lVar, platformMagnifierFactory, style), 1, null);
    }

    public static /* synthetic */ Modifier magnifier$default(Modifier modifier, h9.l lVar, h9.l lVar2, float f10, MagnifierStyle magnifierStyle, h9.l lVar3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar2 = AnonymousClass1.INSTANCE;
        }
        h9.l lVar4 = lVar2;
        if ((i10 & 4) != 0) {
            f10 = Float.NaN;
        }
        float f11 = f10;
        if ((i10 & 8) != 0) {
            magnifierStyle = MagnifierStyle.Companion.getDefault();
        }
        MagnifierStyle magnifierStyle2 = magnifierStyle;
        if ((i10 & 16) != 0) {
            lVar3 = null;
        }
        return magnifier(modifier, lVar, lVar4, f11, magnifierStyle2, lVar3);
    }

    @ExperimentalFoundationApi
    @NotNull
    public static final Modifier magnifier(@NotNull Modifier modifier, @NotNull h9.l<? super Density, Offset> sourceCenter, @NotNull h9.l<? super Density, Offset> magnifierCenter, float f10, @NotNull MagnifierStyle style, @Nullable h9.l<? super DpSize, k0> lVar) {
        t.i(modifier, "<this>");
        t.i(sourceCenter, "sourceCenter");
        t.i(magnifierCenter, "magnifierCenter");
        t.i(style, "style");
        h9.l magnifierKt$magnifier$$inlined$debugInspectorInfo$1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new MagnifierKt$magnifier$$inlined$debugInspectorInfo$1(sourceCenter, magnifierCenter, f10, style) : InspectableValueKt.getNoInspectorInfo();
        Modifier modifierMagnifier = Modifier.Companion;
        if (isPlatformMagnifierSupported$default(0, 1, null)) {
            modifierMagnifier = magnifier(modifierMagnifier, sourceCenter, magnifierCenter, f10, style, lVar, PlatformMagnifierFactory.Companion.getForCurrentPlatform());
        }
        return InspectableValueKt.inspectableWrapper(modifier, magnifierKt$magnifier$$inlined$debugInspectorInfo$1, modifierMagnifier);
    }
}
