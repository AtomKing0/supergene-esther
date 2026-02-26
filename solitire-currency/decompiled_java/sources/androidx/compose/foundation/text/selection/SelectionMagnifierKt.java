package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import h9.l;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.i;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: SelectionMagnifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionMagnifierKt {

    @NotNull
    private static final SpringSpec<Offset> MagnifierSpringSpec;
    private static final long OffsetDisplacementThreshold;

    @NotNull
    private static final AnimationVector2D UnspecifiedAnimationVector2D = new AnimationVector2D(Float.NaN, Float.NaN);

    @NotNull
    private static final TwoWayConverter<Offset, AnimationVector2D> UnspecifiedSafeOffsetVectorConverter = VectorConvertersKt.TwoWayConverter(SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1.INSTANCE, SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2.INSTANCE);

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionMagnifierKt$animatedSelectionMagnifier$1, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionMagnifier.kt */
    static final class AnonymousClass1 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ h9.a<Offset> $magnifierCenter;
        final /* synthetic */ l<h9.a<Offset>, Modifier> $platformMagnifier;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionMagnifierKt$animatedSelectionMagnifier$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SelectionMagnifier.kt */
        static final class C00731 extends v implements h9.a<Offset> {
            final /* synthetic */ State<Offset> $animatedCenter$delegate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00731(State<Offset> state) {
                super(0);
                this.$animatedCenter$delegate = state;
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ Offset invoke() {
                return Offset.m1356boximpl(m787invokeF1C5BW0());
            }

            /* JADX INFO: renamed from: invoke-F1C5BW0, reason: not valid java name */
            public final long m787invokeF1C5BW0() {
                return AnonymousClass1.m786invoke$lambda0(this.$animatedCenter$delegate);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(h9.a<Offset> aVar, l<? super h9.a<Offset>, ? extends Modifier> lVar) {
            super(3);
            this.$magnifierCenter = aVar;
            this.$platformMagnifier = lVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
        public static final long m786invoke$lambda0(State<Offset> state) {
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
            composer.startReplaceableGroup(759876635);
            Modifier modifierInvoke = this.$platformMagnifier.invoke(new C00731(SelectionMagnifierKt.rememberAnimatedMagnifierPosition(this.$magnifierCenter, composer, 0)));
            composer.endReplaceableGroup();
            return modifierInvoke;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SelectionMagnifier.kt */
    @f(c = "androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1", f = "SelectionMagnifier.kt", l = {88}, m = "invokeSuspend")
    static final class C09121 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ Animatable<Offset, AnimationVector2D> $animatable;
        final /* synthetic */ State<Offset> $targetValue$delegate;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SelectionMagnifier.kt */
        static final class C00741 extends v implements h9.a<Offset> {
            final /* synthetic */ State<Offset> $targetValue$delegate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00741(State<Offset> state) {
                super(0);
                this.$targetValue$delegate = state;
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ Offset invoke() {
                return Offset.m1356boximpl(m788invokeF1C5BW0());
            }

            /* JADX INFO: renamed from: invoke-F1C5BW0, reason: not valid java name */
            public final long m788invokeF1C5BW0() {
                return SelectionMagnifierKt.m782rememberAnimatedMagnifierPosition$lambda1(this.$targetValue$delegate);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09121(State<Offset> state, Animatable<Offset, AnimationVector2D> animatable, d<? super C09121> dVar) {
            super(2, dVar);
            this.$targetValue$delegate = state;
            this.$animatable = animatable;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            C09121 c09121 = new C09121(this.$targetValue$delegate, this.$animatable, dVar);
            c09121.L$0 = obj;
            return c09121;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                final o0 o0Var = (o0) this.L$0;
                h hVarSnapshotFlow = SnapshotStateKt.snapshotFlow(new C00741(this.$targetValue$delegate));
                final Animatable<Offset, AnimationVector2D> animatable = this.$animatable;
                i<Offset> iVar = new i<Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionMagnifierKt.rememberAnimatedMagnifierPosition.1.2
                    @Override // s9.i
                    public /* bridge */ /* synthetic */ Object emit(Offset offset, d dVar) {
                        return m789emit3MmeM6k(offset.m1377unboximpl(), dVar);
                    }

                    @Nullable
                    /* JADX INFO: renamed from: emit-3MmeM6k, reason: not valid java name */
                    public final Object m789emit3MmeM6k(long j10, @NotNull d<? super k0> dVar) {
                        if (OffsetKt.m1386isSpecifiedk4lQ0M(animatable.getValue().m1377unboximpl()) && OffsetKt.m1386isSpecifiedk4lQ0M(j10)) {
                            if (!(Offset.m1368getYimpl(animatable.getValue().m1377unboximpl()) == Offset.m1368getYimpl(j10))) {
                                b2 b2VarD = k.d(o0Var, null, null, new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2(animatable, j10, null), 3, null);
                                return b2VarD == a9.d.e() ? b2VarD : k0.f35197a;
                            }
                        }
                        Object objSnapTo = animatable.snapTo(Offset.m1356boximpl(j10), dVar);
                        return objSnapTo == a9.d.e() ? objSnapTo : k0.f35197a;
                    }
                };
                this.label = 1;
                if (hVarSnapshotFlow.collect(iVar, this) == objE) {
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
            return ((C09121) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    static {
        long jOffset = OffsetKt.Offset(0.01f, 0.01f);
        OffsetDisplacementThreshold = jOffset;
        MagnifierSpringSpec = new SpringSpec<>(0.0f, 0.0f, Offset.m1356boximpl(jOffset), 3, null);
    }

    @NotNull
    public static final Modifier animatedSelectionMagnifier(@NotNull Modifier modifier, @NotNull h9.a<Offset> magnifierCenter, @NotNull l<? super h9.a<Offset>, ? extends Modifier> platformMagnifier) {
        t.i(modifier, "<this>");
        t.i(magnifierCenter, "magnifierCenter");
        t.i(platformMagnifier, "platformMagnifier");
        return ComposedModifierKt.composed$default(modifier, null, new AnonymousClass1(magnifierCenter, platformMagnifier), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final State<Offset> rememberAnimatedMagnifierPosition(h9.a<Offset> aVar, Composer composer, int i10) {
        composer.startReplaceableGroup(-1589795249);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(aVar);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        State state = (State) objRememberedValue;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Animatable(Offset.m1356boximpl(m782rememberAnimatedMagnifierPosition$lambda1(state)), UnspecifiedSafeOffsetVectorConverter, Offset.m1356boximpl(OffsetDisplacementThreshold));
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        Animatable animatable = (Animatable) objRememberedValue2;
        EffectsKt.LaunchedEffect(k0.f35197a, new C09121(state, animatable, null), composer, 0);
        State<Offset> stateAsState = animatable.asState();
        composer.endReplaceableGroup();
        return stateAsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: rememberAnimatedMagnifierPosition$lambda-1, reason: not valid java name */
    public static final long m782rememberAnimatedMagnifierPosition$lambda1(State<Offset> state) {
        return state.getValue().m1377unboximpl();
    }
}
