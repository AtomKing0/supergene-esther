package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.k;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.m0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Transformable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransformableKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$awaitTwoDowns$1, reason: invalid class name */
    /* JADX INFO: compiled from: Transformable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", l = {160}, m = "awaitTwoDowns")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        boolean Z$0;
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
            return TransformableKt.awaitTwoDowns(null, false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transformable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", l = {96, 100}, m = "detectZoom")
    static final class C08541 extends kotlin.coroutines.jvm.internal.d {
        float F$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C08541(z8.d<? super C08541> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransformableKt.detectZoom(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$2, reason: invalid class name */
    /* JADX INFO: compiled from: Transformable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TransformableKt$detectZoom$2", f = "Transformable.kt", l = {97}, m = "invokeSuspend")
    static final class AnonymousClass2 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                this.label = 1;
                if (TransformableKt.awaitTwoDowns(awaitPointerEventScope, false, this) == objE) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$3, reason: invalid class name */
    /* JADX INFO: compiled from: Transformable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TransformableKt$detectZoom$3", f = "Transformable.kt", l = {101}, m = "invokeSuspend")
    static final class AnonymousClass3 extends l implements p<TransformScope, z8.d<? super k0>, Object> {
        final /* synthetic */ i0 $lockedToPanZoom;
        final /* synthetic */ m0 $pan;
        final /* synthetic */ State<Boolean> $panZoomLock;
        final /* synthetic */ i0 $pastTouchSlop;
        final /* synthetic */ kotlin.jvm.internal.k0 $rotation;
        final /* synthetic */ PointerInputScope $this_detectZoom;
        final /* synthetic */ float $touchSlop;
        final /* synthetic */ kotlin.jvm.internal.k0 $zoom;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: Transformable.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TransformableKt$detectZoom$3$1", f = "Transformable.kt", l = {103}, m = "invokeSuspend")
        static final class AnonymousClass1 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
            final /* synthetic */ TransformScope $$this$transform;
            final /* synthetic */ i0 $lockedToPanZoom;
            final /* synthetic */ m0 $pan;
            final /* synthetic */ State<Boolean> $panZoomLock;
            final /* synthetic */ i0 $pastTouchSlop;
            final /* synthetic */ kotlin.jvm.internal.k0 $rotation;
            final /* synthetic */ float $touchSlop;
            final /* synthetic */ kotlin.jvm.internal.k0 $zoom;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(i0 i0Var, kotlin.jvm.internal.k0 k0Var, kotlin.jvm.internal.k0 k0Var2, m0 m0Var, float f10, i0 i0Var2, State<Boolean> state, TransformScope transformScope, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$pastTouchSlop = i0Var;
                this.$zoom = k0Var;
                this.$rotation = k0Var2;
                this.$pan = m0Var;
                this.$touchSlop = f10;
                this.$lockedToPanZoom = i0Var2;
                this.$panZoomLock = state;
                this.$$this$transform = transformScope;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$pastTouchSlop, this.$zoom, this.$rotation, this.$pan, this.$touchSlop, this.$lockedToPanZoom, this.$panZoomLock, this.$$this$transform, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:66:0x0142, code lost:
            
                if (r8 == false) goto L67;
             */
            /* JADX WARN: Path cross not found for [B:52:0x0102, B:45:0x00eb], limit reached: 76 */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x0112  */
            /* JADX WARN: Removed duplicated region for block: B:60:0x0126  */
            /* JADX WARN: Removed duplicated region for block: B:69:0x0053 A[SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0031 -> B:12:0x0034). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
                /*
                    Method dump skipped, instruction units count: 327
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.AnonymousClass3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PointerInputScope pointerInputScope, i0 i0Var, kotlin.jvm.internal.k0 k0Var, kotlin.jvm.internal.k0 k0Var2, m0 m0Var, float f10, i0 i0Var2, State<Boolean> state, z8.d<? super AnonymousClass3> dVar) {
            super(2, dVar);
            this.$this_detectZoom = pointerInputScope;
            this.$pastTouchSlop = i0Var;
            this.$zoom = k0Var;
            this.$rotation = k0Var2;
            this.$pan = m0Var;
            this.$touchSlop = f10;
            this.$lockedToPanZoom = i0Var2;
            this.$panZoomLock = state;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$this_detectZoom, this.$pastTouchSlop, this.$zoom, this.$rotation, this.$pan, this.$touchSlop, this.$lockedToPanZoom, this.$panZoomLock, dVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull TransformScope transformScope, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass3) create(transformScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                TransformScope transformScope = (TransformScope) this.L$0;
                PointerInputScope pointerInputScope = this.$this_detectZoom;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$pastTouchSlop, this.$zoom, this.$rotation, this.$pan, this.$touchSlop, this.$lockedToPanZoom, this.$panZoomLock, transformScope, null);
                this.label = 1;
                if (pointerInputScope.awaitPointerEventScope(anonymousClass1, this) == objE) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transformable.kt */
    static final class C08552 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ boolean $lockRotationOnZoomPan;
        final /* synthetic */ TransformableState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08552(TransformableState transformableState, boolean z10, boolean z11) {
            super(3);
            this.$state = transformableState;
            this.$lockRotationOnZoomPan = z10;
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
            composer.startReplaceableGroup(1509335853);
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$state, composer, 0);
            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(this.$lockRotationOnZoomPan), composer, 0);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new TransformableKt$transformable$2$block$1$1(stateRememberUpdatedState2, stateRememberUpdatedState, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier modifierPointerInput = this.$enabled ? SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, k0.f35197a, (p<? super PointerInputScope, ? super z8.d<? super k0>, ? extends Object>) objRememberedValue) : Modifier.Companion;
            composer.endReplaceableGroup();
            return modifierPointerInput;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r5v6, types: [T, androidx.compose.ui.input.pointer.PointerId] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0062 -> B:19:0x0067). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object awaitTwoDowns(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, boolean r18, z8.d<? super v8.k0> r19) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.awaitTwoDowns(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, z8.d):java.lang.Object");
    }

    static /* synthetic */ Object awaitTwoDowns$default(AwaitPointerEventScope awaitPointerEventScope, boolean z10, z8.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return awaitTwoDowns(awaitPointerEventScope, z10, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object detectZoom(androidx.compose.ui.input.pointer.PointerInputScope r22, androidx.compose.runtime.State<java.lang.Boolean> r23, androidx.compose.runtime.State<? extends androidx.compose.foundation.gestures.TransformableState> r24, z8.d<? super v8.k0> r25) {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.detectZoom(androidx.compose.ui.input.pointer.PointerInputScope, androidx.compose.runtime.State, androidx.compose.runtime.State, z8.d):java.lang.Object");
    }

    @NotNull
    public static final Modifier transformable(@NotNull Modifier modifier, @NotNull TransformableState state, boolean z10, boolean z11) {
        t.i(modifier, "<this>");
        t.i(state, "state");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TransformableKt$transformable$$inlined$debugInspectorInfo$1(state, z11, z10) : InspectableValueKt.getNoInspectorInfo(), new C08552(state, z10, z11));
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            z11 = true;
        }
        return transformable(modifier, transformableState, z10, z11);
    }
}
