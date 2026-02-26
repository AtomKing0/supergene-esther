package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.k;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.h;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollableKt {

    @NotNull
    private static final ScrollScope NoOpScrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollableKt$NoOpScrollScope$1
        @Override // androidx.compose.foundation.gestures.ScrollScope
        public float scrollBy(float f10) {
            return f10;
        }
    };

    @NotNull
    private static final ProvidableModifierLocal<Boolean> ModifierLocalScrollableContainer = ModifierLocalKt.modifierLocalOf(ScrollableKt$ModifierLocalScrollableContainer$1.INSTANCE);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.ScrollableKt", f = "Scrollable.kt", l = {293}, m = "awaitScrollEvent")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(z8.d<? super AnonymousClass1> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScrollableKt.awaitScrollEvent(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Scrollable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1", f = "Scrollable.kt", l = {271}, m = "invokeSuspend")
    static final class C08461 extends l implements p<PointerInputScope, z8.d<? super k0>, Object> {
        final /* synthetic */ ScrollConfig $mouseWheelScrollConfig;
        final /* synthetic */ State<ScrollingLogic> $scrollingLogicState;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Scrollable.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1$1", f = "Scrollable.kt", l = {273}, m = "invokeSuspend")
        static final class C00431 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
            final /* synthetic */ ScrollConfig $mouseWheelScrollConfig;
            final /* synthetic */ State<ScrollingLogic> $scrollingLogicState;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00431(ScrollConfig scrollConfig, State<ScrollingLogic> state, z8.d<? super C00431> dVar) {
                super(2, dVar);
                this.$mouseWheelScrollConfig = scrollConfig;
                this.$scrollingLogicState = state;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                C00431 c00431 = new C00431(this.$mouseWheelScrollConfig, this.$scrollingLogicState, dVar);
                c00431.L$0 = obj;
                return c00431;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                return ((C00431) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0031 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0057 A[SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0032 -> B:13:0x0037). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
                /*
                    r10 = this;
                    java.lang.Object r0 = a9.b.e()
                    int r1 = r10.label
                    r2 = 1
                    if (r1 == 0) goto L1e
                    if (r1 != r2) goto L16
                    java.lang.Object r1 = r10.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                    v8.u.b(r11)
                    r3 = r1
                    r1 = r0
                    r0 = r10
                    goto L37
                L16:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r0)
                    throw r11
                L1e:
                    v8.u.b(r11)
                    java.lang.Object r11 = r10.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
                    r1 = r11
                    r11 = r10
                L27:
                    r11.L$0 = r1
                    r11.label = r2
                    java.lang.Object r3 = androidx.compose.foundation.gestures.ScrollableKt.access$awaitScrollEvent(r1, r11)
                    if (r3 != r0) goto L32
                    return r0
                L32:
                    r9 = r0
                    r0 = r11
                    r11 = r3
                    r3 = r1
                    r1 = r9
                L37:
                    androidx.compose.ui.input.pointer.PointerEvent r11 = (androidx.compose.ui.input.pointer.PointerEvent) r11
                    java.util.List r4 = r11.getChanges()
                    int r5 = r4.size()
                    r6 = 0
                    r7 = r6
                L43:
                    if (r7 >= r5) goto L57
                    java.lang.Object r8 = r4.get(r7)
                    androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                    boolean r8 = r8.isConsumed()
                    r8 = r8 ^ r2
                    if (r8 != 0) goto L54
                    r4 = r6
                    goto L58
                L54:
                    int r7 = r7 + 1
                    goto L43
                L57:
                    r4 = r2
                L58:
                    if (r4 == 0) goto L9c
                    androidx.compose.foundation.gestures.ScrollConfig r4 = r0.$mouseWheelScrollConfig
                    androidx.compose.runtime.State<androidx.compose.foundation.gestures.ScrollingLogic> r5 = r0.$scrollingLogicState
                    long r7 = r3.mo2791getSizeYbymL2g()
                    long r7 = r4.mo238calculateMouseWheelScroll8xgXZGE(r3, r11, r7)
                    java.lang.Object r4 = r5.getValue()
                    androidx.compose.foundation.gestures.ScrollingLogic r4 = (androidx.compose.foundation.gestures.ScrollingLogic) r4
                    float r5 = r4.m310toFloatk4lQ0M(r7)
                    float r5 = r4.reverseIfNeeded(r5)
                    androidx.compose.foundation.gestures.ScrollableState r4 = r4.getScrollableState()
                    float r4 = r4.dispatchRawDelta(r5)
                    r5 = 0
                    int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                    if (r4 != 0) goto L83
                    r4 = r2
                    goto L84
                L83:
                    r4 = r6
                L84:
                    if (r4 != 0) goto L9c
                    java.util.List r11 = r11.getChanges()
                    int r4 = r11.size()
                L8e:
                    if (r6 >= r4) goto L9c
                    java.lang.Object r5 = r11.get(r6)
                    androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
                    r5.consume()
                    int r6 = r6 + 1
                    goto L8e
                L9c:
                    r11 = r0
                    r0 = r1
                    r1 = r3
                    goto L27
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.C08461.C00431.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08461(ScrollConfig scrollConfig, State<ScrollingLogic> state, z8.d<? super C08461> dVar) {
            super(2, dVar);
            this.$mouseWheelScrollConfig = scrollConfig;
            this.$scrollingLogicState = state;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C08461 c08461 = new C08461(this.$mouseWheelScrollConfig, this.$scrollingLogicState, dVar);
            c08461.L$0 = obj;
            return c08461;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
            return ((C08461) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                C00431 c00431 = new C00431(this.$mouseWheelScrollConfig, this.$scrollingLogicState, null);
                this.label = 1;
                if (pointerInputScope.awaitPointerEventScope(c00431, this) == objE) {
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
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Scrollable.kt */
    static final class C08471 extends v implements p<Composer, Integer, PointerAwareDraggableState> {
        final /* synthetic */ ScrollDraggableState $draggableState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08471(ScrollDraggableState scrollDraggableState) {
            super(2);
            this.$draggableState = scrollDraggableState;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ PointerAwareDraggableState mo4invoke(Composer composer, Integer num) {
            return invoke(composer, num.intValue());
        }

        @Composable
        @NotNull
        public final PointerAwareDraggableState invoke(@Nullable Composer composer, int i10) {
            composer.startReplaceableGroup(498671830);
            ScrollDraggableState scrollDraggableState = this.$draggableState;
            composer.endReplaceableGroup();
            return scrollDraggableState;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$2, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable.kt */
    static final class AnonymousClass2 extends v implements h9.l<PointerInputChange, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull PointerInputChange down) {
            t.i(down, "down");
            return Boolean.valueOf(!PointerType.m2931equalsimpl0(down.m2876getTypeT8wyACA(), PointerType.Companion.m2936getMouseT8wyACA()));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$3, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable.kt */
    static final class AnonymousClass3 extends v implements h9.a<Boolean> {
        final /* synthetic */ State<ScrollingLogic> $scrollLogic;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(State<ScrollingLogic> state) {
            super(0);
            this.$scrollLogic = state;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(this.$scrollLogic.getValue().shouldScrollImmediately());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$4, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$4", f = "Scrollable.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass4 extends l implements q<o0, Float, z8.d<? super k0>, Object> {
        final /* synthetic */ MutableState<NestedScrollDispatcher> $nestedScrollDispatcher;
        final /* synthetic */ State<ScrollingLogic> $scrollLogic;
        /* synthetic */ float F$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: Scrollable.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$4$1", f = "Scrollable.kt", l = {258}, m = "invokeSuspend")
        static final class AnonymousClass1 extends l implements p<o0, z8.d<? super k0>, Object> {
            final /* synthetic */ State<ScrollingLogic> $scrollLogic;
            final /* synthetic */ float $velocity;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(State<ScrollingLogic> state, float f10, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$scrollLogic = state;
                this.$velocity = f10;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new AnonymousClass1(this.$scrollLogic, this.$velocity, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    ScrollingLogic value = this.$scrollLogic.getValue();
                    float f10 = this.$velocity;
                    this.label = 1;
                    if (value.onDragStopped(f10, this) == objE) {
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
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(MutableState<NestedScrollDispatcher> mutableState, State<ScrollingLogic> state, z8.d<? super AnonymousClass4> dVar) {
            super(3, dVar);
            this.$nestedScrollDispatcher = mutableState;
            this.$scrollLogic = state;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Object invoke(o0 o0Var, Float f10, z8.d<? super k0> dVar) {
            return invoke(o0Var, f10.floatValue(), dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            kotlinx.coroutines.k.d(this.$nestedScrollDispatcher.getValue().getCoroutineScope(), null, null, new AnonymousClass1(this.$scrollLogic, this.F$0, null), 3, null);
            return k0.f35197a;
        }

        @Nullable
        public final Object invoke(@NotNull o0 o0Var, float f10, @Nullable z8.d<? super k0> dVar) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$nestedScrollDispatcher, this.$scrollLogic, dVar);
            anonymousClass4.F$0 = f10;
            return anonymousClass4.invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableKt$scrollable$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Scrollable.kt */
    static final class C08482 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ OverscrollEffect $overscrollEffect;
        final /* synthetic */ boolean $reverseDirection;
        final /* synthetic */ ScrollableState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08482(Orientation orientation, ScrollableState scrollableState, boolean z10, MutableInteractionSource mutableInteractionSource, FlingBehavior flingBehavior, OverscrollEffect overscrollEffect, boolean z11) {
            super(3);
            this.$orientation = orientation;
            this.$state = scrollableState;
            this.$reverseDirection = z10;
            this.$interactionSource = mutableInteractionSource;
            this.$flingBehavior = flingBehavior;
            this.$overscrollEffect = overscrollEffect;
            this.$enabled = z11;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-629830927);
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(h.f37608a, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            o0 coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composer.endReplaceableGroup();
            Object[] objArr = {coroutineScope, this.$orientation, this.$state, Boolean.valueOf(this.$reverseDirection)};
            Orientation orientation = this.$orientation;
            ScrollableState scrollableState = this.$state;
            boolean z10 = this.$reverseDirection;
            composer.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i11 = 0; i11 < 4; i11++) {
                zChanged |= composer.changed(objArr[i11]);
            }
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new ContentInViewModifier(coroutineScope, orientation, scrollableState, z10);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            Modifier modifier = Modifier.Companion;
            Modifier modifierPointerScrollable = ScrollableKt.pointerScrollable(FocusableKt.focusGroup(modifier).then(((ContentInViewModifier) objRememberedValue2).getModifier()), this.$interactionSource, this.$orientation, this.$reverseDirection, this.$state, this.$flingBehavior, this.$overscrollEffect, this.$enabled, composer, 0);
            if (this.$enabled) {
                modifier = ModifierLocalScrollableContainerProvider.INSTANCE;
            }
            Modifier modifierThen = modifierPointerScrollable.then(modifier);
            composer.endReplaceableGroup();
            return modifierThen;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Scrollable.kt */
    public static final class C08491 implements NestedScrollConnection {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ State<ScrollingLogic> $scrollLogic;

        C08491(boolean z10, State<ScrollingLogic> state) {
            this.$enabled = z10;
            this.$scrollLogic = state;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        @org.jetbrains.annotations.Nullable
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object mo301onPostFlingRZ2iAVY(long r3, long r5, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.unit.Velocity> r7) {
            /*
                r2 = this;
                boolean r3 = r7 instanceof androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1
                if (r3 == 0) goto L13
                r3 = r7
                androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 r3 = (androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1) r3
                int r4 = r3.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r4 & r0
                if (r1 == 0) goto L13
                int r4 = r4 - r0
                r3.label = r4
                goto L18
            L13:
                androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 r3 = new androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1
                r3.<init>(r2, r7)
            L18:
                java.lang.Object r4 = r3.result
                java.lang.Object r7 = a9.b.e()
                int r0 = r3.label
                r1 = 1
                if (r0 == 0) goto L33
                if (r0 != r1) goto L2b
                long r5 = r3.J$0
                v8.u.b(r4)
                goto L4d
            L2b:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r4)
                throw r3
            L33:
                v8.u.b(r4)
                boolean r4 = r2.$enabled
                if (r4 == 0) goto L58
                androidx.compose.runtime.State<androidx.compose.foundation.gestures.ScrollingLogic> r4 = r2.$scrollLogic
                java.lang.Object r4 = r4.getValue()
                androidx.compose.foundation.gestures.ScrollingLogic r4 = (androidx.compose.foundation.gestures.ScrollingLogic) r4
                r3.J$0 = r5
                r3.label = r1
                java.lang.Object r4 = r4.m306doFlingAnimationQWom1Mo(r5, r3)
                if (r4 != r7) goto L4d
                return r7
            L4d:
                androidx.compose.ui.unit.Velocity r4 = (androidx.compose.ui.unit.Velocity) r4
                long r3 = r4.m3907unboximpl()
                long r3 = androidx.compose.ui.unit.Velocity.m3901minusAH228Gc(r5, r3)
                goto L5e
            L58:
                androidx.compose.ui.unit.Velocity$Companion r3 = androidx.compose.ui.unit.Velocity.Companion
                long r3 = r3.m3909getZero9UxMQ8M()
            L5e:
                androidx.compose.ui.unit.Velocity r3 = androidx.compose.ui.unit.Velocity.m3889boximpl(r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.C08491.mo301onPostFlingRZ2iAVY(long, long, z8.d):java.lang.Object");
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
        public long mo302onPostScrollDzOQY0M(long j10, long j11, int i10) {
            return this.$enabled ? this.$scrollLogic.getValue().m307performRawScrollMKHz9U(j11) : Offset.Companion.m1383getZeroF1C5BW0();
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
        public /* synthetic */ Object mo303onPreFlingQWom1Mo(long j10, z8.d dVar) {
            return androidx.compose.ui.input.nestedscroll.a.c(this, j10, dVar);
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
        public /* synthetic */ long mo304onPreScrollOzD1aCk(long j10, int i10) {
            return androidx.compose.ui.input.nestedscroll.a.d(this, j10, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0041 -> B:18:0x0044). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object awaitScrollEvent(androidx.compose.ui.input.pointer.AwaitPointerEventScope r5, z8.d<? super androidx.compose.ui.input.pointer.PointerEvent> r6) {
        /*
            boolean r0 = r6 instanceof androidx.compose.foundation.gestures.ScrollableKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1 r0 = (androidx.compose.foundation.gestures.ScrollableKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1 r0 = new androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            v8.u.b(r6)
            goto L44
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            v8.u.b(r6)
        L38:
            r0.L$0 = r5
            r0.label = r3
            r6 = 0
            java.lang.Object r6 = androidx.compose.ui.input.pointer.b.t(r5, r6, r0, r3, r6)
            if (r6 != r1) goto L44
            return r1
        L44:
            androidx.compose.ui.input.pointer.PointerEvent r6 = (androidx.compose.ui.input.pointer.PointerEvent) r6
            int r2 = r6.m2820getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r4 = r4.m2836getScroll7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m2827equalsimpl0(r2, r4)
            if (r2 == 0) goto L38
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.awaitScrollEvent(androidx.compose.ui.input.pointer.AwaitPointerEventScope, z8.d):java.lang.Object");
    }

    @NotNull
    public static final ProvidableModifierLocal<Boolean> getModifierLocalScrollableContainer() {
        return ModifierLocalScrollableContainer;
    }

    private static final Modifier mouseWheelScroll(Modifier modifier, State<ScrollingLogic> state, ScrollConfig scrollConfig) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, state, scrollConfig, new C08461(scrollConfig, state, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final Modifier pointerScrollable(Modifier modifier, MutableInteractionSource mutableInteractionSource, Orientation orientation, boolean z10, ScrollableState scrollableState, FlingBehavior flingBehavior, OverscrollEffect overscrollEffect, boolean z11, Composer composer, int i10) {
        composer.startReplaceableGroup(-2012025036);
        composer.startReplaceableGroup(-1730187034);
        FlingBehavior flingBehavior2 = flingBehavior == null ? ScrollableDefaults.INSTANCE.flingBehavior(composer, 6) : flingBehavior;
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new NestedScrollDispatcher(), null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new ScrollingLogic(orientation, z10, mutableState, scrollableState, flingBehavior2, overscrollEffect), composer, 0);
        Boolean boolValueOf = Boolean.valueOf(z11);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(boolValueOf);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = scrollableNestedScrollConnection(stateRememberUpdatedState, z11);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        NestedScrollConnection nestedScrollConnection = (NestedScrollConnection) objRememberedValue2;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = new ScrollDraggableState(stateRememberUpdatedState);
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceableGroup();
        Modifier modifierNestedScroll = NestedScrollModifierKt.nestedScroll(mouseWheelScroll(DraggableKt.draggable(modifier, new C08471((ScrollDraggableState) objRememberedValue3), AnonymousClass2.INSTANCE, orientation, (64 & 8) != 0 ? true : z11, (64 & 16) != 0 ? null : mutableInteractionSource, new AnonymousClass3(stateRememberUpdatedState), (64 & 64) != 0 ? new DraggableKt.AnonymousClass6(null) : null, (64 & 128) != 0 ? new DraggableKt.AnonymousClass7(null) : new AnonymousClass4(mutableState, stateRememberUpdatedState, null), (64 & 256) != 0 ? false : false), stateRememberUpdatedState, AndroidScrollable_androidKt.platformScrollConfig(composer, 0)), nestedScrollConnection, (NestedScrollDispatcher) mutableState.getValue());
        composer.endReplaceableGroup();
        return modifierNestedScroll;
    }

    @NotNull
    public static final Modifier scrollable(@NotNull Modifier modifier, @NotNull ScrollableState state, @NotNull Orientation orientation, boolean z10, boolean z11, @Nullable FlingBehavior flingBehavior, @Nullable MutableInteractionSource mutableInteractionSource) {
        t.i(modifier, "<this>");
        t.i(state, "state");
        t.i(orientation, "orientation");
        return scrollable(modifier, state, orientation, null, z10, z11, flingBehavior, mutableInteractionSource);
    }

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z10, boolean z11, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        boolean z12 = z10;
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        return scrollable(modifier, scrollableState, orientation, z12, z11, (i10 & 16) != 0 ? null : flingBehavior, (i10 & 32) != 0 ? null : mutableInteractionSource);
    }

    private static final NestedScrollConnection scrollableNestedScrollConnection(State<ScrollingLogic> state, boolean z10) {
        return new C08491(z10, state);
    }

    @ExperimentalFoundationApi
    @NotNull
    public static final Modifier scrollable(@NotNull Modifier modifier, @NotNull ScrollableState state, @NotNull Orientation orientation, @Nullable OverscrollEffect overscrollEffect, boolean z10, boolean z11, @Nullable FlingBehavior flingBehavior, @Nullable MutableInteractionSource mutableInteractionSource) {
        t.i(modifier, "<this>");
        t.i(state, "state");
        t.i(orientation, "orientation");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ScrollableKt$scrollable$$inlined$debugInspectorInfo$1(orientation, state, overscrollEffect, z10, z11, flingBehavior, mutableInteractionSource) : InspectableValueKt.getNoInspectorInfo(), new C08482(orientation, state, z11, mutableInteractionSource, flingBehavior, overscrollEffect, z10));
    }
}
