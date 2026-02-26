package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import h9.p;
import java.util.List;
import kotlin.coroutines.jvm.internal.k;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: DragGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DragGestureDetectorKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1, reason: invalid class name */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", l = {754}, m = "awaitLongPressOrCancellation")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
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
            return DragGestureDetectorKt.awaitLongPressOrCancellation(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2, reason: invalid class name */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2", f = "DragGestureDetector.kt", l = {755}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ n0<PointerInputChange> $currentDown;
        final /* synthetic */ n0<PointerInputChange> $longPress;
        final /* synthetic */ PointerInputScope $this_awaitLongPressOrCancellation;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: DragGestureDetector.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2$1", f = "DragGestureDetector.kt", l = {758, 775}, m = "invokeSuspend")
        static final class AnonymousClass1 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
            final /* synthetic */ n0<PointerInputChange> $currentDown;
            final /* synthetic */ n0<PointerInputChange> $longPress;
            int I$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(n0<PointerInputChange> n0Var, n0<PointerInputChange> n0Var2, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$currentDown = n0Var;
                this.$longPress = n0Var2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentDown, this.$longPress, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0088  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00c2 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:43:0x00c3  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x00d2  */
            /* JADX WARN: Removed duplicated region for block: B:52:0x00e6  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x00f7  */
            /* JADX WARN: Removed duplicated region for block: B:63:0x012c  */
            /* JADX WARN: Removed duplicated region for block: B:76:0x015e  */
            /* JADX WARN: Removed duplicated region for block: B:78:0x00e3 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:82:0x0079 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:85:0x00ae A[SYNTHETIC] */
            /* JADX WARN: Type inference failed for: r12v6 */
            /* JADX WARN: Type inference failed for: r12v8, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v8, types: [T, androidx.compose.ui.input.pointer.PointerInputChange] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00c3 -> B:44:0x00c5). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
                /*
                    Method dump skipped, instruction units count: 353
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PointerInputScope pointerInputScope, n0<PointerInputChange> n0Var, n0<PointerInputChange> n0Var2, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$this_awaitLongPressOrCancellation = pointerInputScope;
            this.$currentDown = n0Var;
            this.$longPress = n0Var2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new AnonymousClass2(this.$this_awaitLongPressOrCancellation, this.$currentDown, this.$longPress, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = this.$this_awaitLongPressOrCancellation;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentDown, this.$longPress, null);
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

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$3, reason: invalid class name */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    static final class AnonymousClass3 extends v implements h9.a<k0> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$4, reason: invalid class name */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    static final class AnonymousClass4 extends v implements h9.a<k0> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        AnonymousClass4() {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5, reason: invalid class name */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5", f = "DragGestureDetector.kt", l = {224}, m = "invokeSuspend")
    static final class AnonymousClass5 extends l implements p<PointerInputScope, z8.d<? super k0>, Object> {
        final /* synthetic */ p<PointerInputChange, Offset, k0> $onDrag;
        final /* synthetic */ h9.a<k0> $onDragCancel;
        final /* synthetic */ h9.a<k0> $onDragEnd;
        final /* synthetic */ h9.l<Offset, k0> $onDragStart;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: DragGestureDetector.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1", f = "DragGestureDetector.kt", l = {225, 229, 241}, m = "invokeSuspend")
        static final class AnonymousClass1 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
            final /* synthetic */ p<PointerInputChange, Offset, k0> $onDrag;
            final /* synthetic */ h9.a<k0> $onDragCancel;
            final /* synthetic */ h9.a<k0> $onDragEnd;
            final /* synthetic */ h9.l<Offset, k0> $onDragStart;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: DragGestureDetector.kt */
            static final class C00371 extends v implements p<PointerInputChange, Offset, k0> {
                final /* synthetic */ m0 $overSlop;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00371(m0 m0Var) {
                    super(2);
                    this.$overSlop = m0Var;
                }

                @Override // h9.p
                /* JADX INFO: renamed from: invoke */
                public /* bridge */ /* synthetic */ k0 mo4invoke(PointerInputChange pointerInputChange, Offset offset) {
                    m264invokeUv8p0NA(pointerInputChange, offset.m1377unboximpl());
                    return k0.f35197a;
                }

                /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
                public final void m264invokeUv8p0NA(@NotNull PointerInputChange change, long j10) {
                    t.i(change, "change");
                    change.consume();
                    this.$overSlop.f29833a = j10;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: DragGestureDetector.kt */
            static final class AnonymousClass2 extends v implements h9.l<PointerInputChange, k0> {
                final /* synthetic */ p<PointerInputChange, Offset, k0> $onDrag;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass2(p<? super PointerInputChange, ? super Offset, k0> pVar) {
                    super(1);
                    this.$onDrag = pVar;
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(PointerInputChange pointerInputChange) {
                    invoke2(pointerInputChange);
                    return k0.f35197a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PointerInputChange it) {
                    t.i(it, "it");
                    this.$onDrag.mo4invoke(it, Offset.m1356boximpl(PointerEventKt.positionChange(it)));
                    it.consume();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(h9.l<? super Offset, k0> lVar, p<? super PointerInputChange, ? super Offset, k0> pVar, h9.a<k0> aVar, h9.a<k0> aVar2, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$onDragStart = lVar;
                this.$onDrag = pVar;
                this.$onDragCancel = aVar;
                this.$onDragEnd = aVar2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x007d A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0090  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00cb  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x00d1  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007e -> B:20:0x0081). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
                /*
                    Method dump skipped, instruction units count: 217
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.AnonymousClass5.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass5(h9.l<? super Offset, k0> lVar, p<? super PointerInputChange, ? super Offset, k0> pVar, h9.a<k0> aVar, h9.a<k0> aVar2, z8.d<? super AnonymousClass5> dVar) {
            super(2, dVar);
            this.$onDragStart = lVar;
            this.$onDrag = pVar;
            this.$onDragCancel = aVar;
            this.$onDragEnd = aVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, dVar);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass5) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, null);
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    static final class C08283 extends v implements h9.a<k0> {
        public static final C08283 INSTANCE = new C08283();

        C08283() {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    static final class C08294 extends v implements h9.a<k0> {
        public static final C08294 INSTANCE = new C08294();

        C08294() {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", f = "DragGestureDetector.kt", l = {276, 280, 284}, m = "invokeSuspend")
    static final class C08305 extends l implements p<PointerInputScope, z8.d<? super k0>, Object> {
        final /* synthetic */ p<PointerInputChange, Offset, k0> $onDrag;
        final /* synthetic */ h9.a<k0> $onDragCancel;
        final /* synthetic */ h9.a<k0> $onDragEnd;
        final /* synthetic */ h9.l<Offset, k0> $onDragStart;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: DragGestureDetector.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1", f = "DragGestureDetector.kt", l = {286}, m = "invokeSuspend")
        static final class AnonymousClass1 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
            final /* synthetic */ PointerInputChange $drag;
            final /* synthetic */ p<PointerInputChange, Offset, k0> $onDrag;
            final /* synthetic */ h9.a<k0> $onDragCancel;
            final /* synthetic */ h9.a<k0> $onDragEnd;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: DragGestureDetector.kt */
            static final class C00381 extends v implements h9.l<PointerInputChange, k0> {
                final /* synthetic */ p<PointerInputChange, Offset, k0> $onDrag;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00381(p<? super PointerInputChange, ? super Offset, k0> pVar) {
                    super(1);
                    this.$onDrag = pVar;
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(PointerInputChange pointerInputChange) {
                    invoke2(pointerInputChange);
                    return k0.f35197a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PointerInputChange it) {
                    t.i(it, "it");
                    this.$onDrag.mo4invoke(it, Offset.m1356boximpl(PointerEventKt.positionChange(it)));
                    it.consume();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(PointerInputChange pointerInputChange, h9.a<k0> aVar, h9.a<k0> aVar2, p<? super PointerInputChange, ? super Offset, k0> pVar, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$drag = pointerInputChange;
                this.$onDragEnd = aVar;
                this.$onDragCancel = aVar2;
                this.$onDrag = pVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$drag, this.$onDragEnd, this.$onDragCancel, this.$onDrag, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                AwaitPointerEventScope awaitPointerEventScope;
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                    long jM2872getIdJ3iCeTQ = this.$drag.m2872getIdJ3iCeTQ();
                    C00381 c00381 = new C00381(this.$onDrag);
                    this.L$0 = awaitPointerEventScope2;
                    this.label = 1;
                    Object objM258dragjO51t88 = DragGestureDetectorKt.m258dragjO51t88(awaitPointerEventScope2, jM2872getIdJ3iCeTQ, c00381, this);
                    if (objM258dragjO51t88 == objE) {
                        return objE;
                    }
                    awaitPointerEventScope = awaitPointerEventScope2;
                    obj = objM258dragjO51t88;
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    u.b(obj);
                }
                if (((Boolean) obj).booleanValue()) {
                    List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                    int size = changes.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        PointerInputChange pointerInputChange = changes.get(i11);
                        if (PointerEventKt.changedToUp(pointerInputChange)) {
                            pointerInputChange.consume();
                        }
                    }
                    this.$onDragEnd.invoke();
                } else {
                    this.$onDragCancel.invoke();
                }
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08305(h9.l<? super Offset, k0> lVar, h9.a<k0> aVar, h9.a<k0> aVar2, p<? super PointerInputChange, ? super Offset, k0> pVar, z8.d<? super C08305> dVar) {
            super(2, dVar);
            this.$onDragStart = lVar;
            this.$onDragCancel = aVar;
            this.$onDragEnd = aVar2;
            this.$onDrag = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C08305 c08305 = new C08305(this.$onDragStart, this.$onDragCancel, this.$onDragEnd, this.$onDrag, dVar);
            c08305.L$0 = obj;
            return c08305;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
            return ((C08305) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x005d A[Catch: CancellationException -> 0x0017, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0017, blocks: (B:7:0x0012, B:14:0x0025, B:25:0x0058, B:27:0x005d, B:22:0x004d), top: B:34:0x000a }] */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r11.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L31
                if (r1 == r5) goto L29
                if (r1 == r4) goto L21
                if (r1 != r3) goto L19
                v8.u.b(r12)     // Catch: java.util.concurrent.CancellationException -> L17
                goto L82
            L17:
                r12 = move-exception
                goto L85
            L19:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L21:
                java.lang.Object r1 = r11.L$0
                androidx.compose.ui.input.pointer.PointerInputScope r1 = (androidx.compose.ui.input.pointer.PointerInputScope) r1
                v8.u.b(r12)     // Catch: java.util.concurrent.CancellationException -> L17
                goto L58
            L29:
                java.lang.Object r1 = r11.L$0
                androidx.compose.ui.input.pointer.PointerInputScope r1 = (androidx.compose.ui.input.pointer.PointerInputScope) r1
                v8.u.b(r12)
                goto L4b
            L31:
                v8.u.b(r12)
                java.lang.Object r12 = r11.L$0
                androidx.compose.ui.input.pointer.PointerInputScope r12 = (androidx.compose.ui.input.pointer.PointerInputScope) r12
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$down$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$down$1
                r1.<init>(r2)
                r11.L$0 = r12
                r11.label = r5
                java.lang.Object r1 = r12.awaitPointerEventScope(r1, r11)
                if (r1 != r0) goto L48
                return r0
            L48:
                r10 = r1
                r1 = r12
                r12 = r10
            L4b:
                androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
                r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> L17
                r11.label = r4     // Catch: java.util.concurrent.CancellationException -> L17
                java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.access$awaitLongPressOrCancellation(r1, r12, r11)     // Catch: java.util.concurrent.CancellationException -> L17
                if (r12 != r0) goto L58
                return r0
            L58:
                r5 = r12
                androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5     // Catch: java.util.concurrent.CancellationException -> L17
                if (r5 == 0) goto L82
                h9.l<androidx.compose.ui.geometry.Offset, v8.k0> r12 = r11.$onDragStart     // Catch: java.util.concurrent.CancellationException -> L17
                long r6 = r5.m2873getPositionF1C5BW0()     // Catch: java.util.concurrent.CancellationException -> L17
                androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m1356boximpl(r6)     // Catch: java.util.concurrent.CancellationException -> L17
                r12.invoke(r4)     // Catch: java.util.concurrent.CancellationException -> L17
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1 r12 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1     // Catch: java.util.concurrent.CancellationException -> L17
                h9.a<v8.k0> r6 = r11.$onDragEnd     // Catch: java.util.concurrent.CancellationException -> L17
                h9.a<v8.k0> r7 = r11.$onDragCancel     // Catch: java.util.concurrent.CancellationException -> L17
                h9.p<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, v8.k0> r8 = r11.$onDrag     // Catch: java.util.concurrent.CancellationException -> L17
                r9 = 0
                r4 = r12
                r4.<init>(r5, r6, r7, r8, r9)     // Catch: java.util.concurrent.CancellationException -> L17
                r11.L$0 = r2     // Catch: java.util.concurrent.CancellationException -> L17
                r11.label = r3     // Catch: java.util.concurrent.CancellationException -> L17
                java.lang.Object r12 = r1.awaitPointerEventScope(r12, r11)     // Catch: java.util.concurrent.CancellationException -> L17
                if (r12 != r0) goto L82
                return r0
            L82:
                v8.k0 r12 = v8.k0.f35197a
                return r12
            L85:
                h9.a<v8.k0> r0 = r11.$onDragCancel
                r0.invoke()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.C08305.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    static final class C08323 extends v implements h9.a<k0> {
        public static final C08323 INSTANCE = new C08323();

        C08323() {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    static final class C08334 extends v implements h9.a<k0> {
        public static final C08334 INSTANCE = new C08334();

        C08334() {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5", f = "DragGestureDetector.kt", l = {575}, m = "invokeSuspend")
    static final class C08345 extends l implements p<PointerInputScope, z8.d<? super k0>, Object> {
        final /* synthetic */ h9.a<k0> $onDragCancel;
        final /* synthetic */ h9.a<k0> $onDragEnd;
        final /* synthetic */ h9.l<Offset, k0> $onDragStart;
        final /* synthetic */ p<PointerInputChange, Float, k0> $onHorizontalDrag;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: DragGestureDetector.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1", f = "DragGestureDetector.kt", l = {576, 578, 589}, m = "invokeSuspend")
        static final class AnonymousClass1 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
            final /* synthetic */ h9.a<k0> $onDragCancel;
            final /* synthetic */ h9.a<k0> $onDragEnd;
            final /* synthetic */ h9.l<Offset, k0> $onDragStart;
            final /* synthetic */ p<PointerInputChange, Float, k0> $onHorizontalDrag;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: DragGestureDetector.kt */
            static final class C00391 extends v implements h9.l<PointerInputChange, k0> {
                final /* synthetic */ p<PointerInputChange, Float, k0> $onHorizontalDrag;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00391(p<? super PointerInputChange, ? super Float, k0> pVar) {
                    super(1);
                    this.$onHorizontalDrag = pVar;
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(PointerInputChange pointerInputChange) {
                    invoke2(pointerInputChange);
                    return k0.f35197a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PointerInputChange it) {
                    t.i(it, "it");
                    this.$onHorizontalDrag.mo4invoke(it, Float.valueOf(Offset.m1367getXimpl(PointerEventKt.positionChange(it))));
                    it.consume();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(h9.l<? super Offset, k0> lVar, p<? super PointerInputChange, ? super Float, k0> pVar, h9.a<k0> aVar, h9.a<k0> aVar2, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$onDragStart = lVar;
                this.$onHorizontalDrag = pVar;
                this.$onDragEnd = aVar;
                this.$onDragCancel = aVar2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x00aa  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00b0  */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
                /*
                    r12 = this;
                    java.lang.Object r0 = a9.b.e()
                    int r1 = r12.label
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L32
                    if (r1 == r4) goto L2a
                    if (r1 == r3) goto L1e
                    if (r1 != r2) goto L16
                    v8.u.b(r13)
                    goto La2
                L16:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                L1e:
                    java.lang.Object r1 = r12.L$1
                    kotlin.jvm.internal.k0 r1 = (kotlin.jvm.internal.k0) r1
                    java.lang.Object r3 = r12.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                    v8.u.b(r13)
                    goto L6d
                L2a:
                    java.lang.Object r1 = r12.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                    v8.u.b(r13)
                    goto L48
                L32:
                    v8.u.b(r13)
                    java.lang.Object r13 = r12.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
                    r12.L$0 = r13
                    r12.label = r4
                    r1 = 0
                    java.lang.Object r1 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r13, r1, r12)
                    if (r1 != r0) goto L45
                    return r0
                L45:
                    r11 = r1
                    r1 = r13
                    r13 = r11
                L48:
                    androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                    kotlin.jvm.internal.k0 r10 = new kotlin.jvm.internal.k0
                    r10.<init>()
                    long r5 = r13.m2872getIdJ3iCeTQ()
                    int r7 = r13.m2876getTypeT8wyACA()
                    androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1$drag$1 r8 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1$drag$1
                    r8.<init>(r10)
                    r12.L$0 = r1
                    r12.L$1 = r10
                    r12.label = r3
                    r4 = r1
                    r9 = r12
                    java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m249awaitHorizontalPointerSlopOrCancellationgDDlDlE(r4, r5, r7, r8, r9)
                    if (r13 != r0) goto L6b
                    return r0
                L6b:
                    r3 = r1
                    r1 = r10
                L6d:
                    androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                    if (r13 == 0) goto Lb5
                    h9.l<androidx.compose.ui.geometry.Offset, v8.k0> r4 = r12.$onDragStart
                    long r5 = r13.m2873getPositionF1C5BW0()
                    androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.m1356boximpl(r5)
                    r4.invoke(r5)
                    h9.p<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, v8.k0> r4 = r12.$onHorizontalDrag
                    float r1 = r1.f29829a
                    java.lang.Float r1 = kotlin.coroutines.jvm.internal.b.c(r1)
                    r4.mo4invoke(r13, r1)
                    long r4 = r13.m2872getIdJ3iCeTQ()
                    androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1$1 r13 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1$1
                    h9.p<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, v8.k0> r1 = r12.$onHorizontalDrag
                    r13.<init>(r1)
                    r1 = 0
                    r12.L$0 = r1
                    r12.L$1 = r1
                    r12.label = r2
                    java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m259horizontalDragjO51t88(r3, r4, r13, r12)
                    if (r13 != r0) goto La2
                    return r0
                La2:
                    java.lang.Boolean r13 = (java.lang.Boolean) r13
                    boolean r13 = r13.booleanValue()
                    if (r13 == 0) goto Lb0
                    h9.a<v8.k0> r13 = r12.$onDragEnd
                    r13.invoke()
                    goto Lb5
                Lb0:
                    h9.a<v8.k0> r13 = r12.$onDragCancel
                    r13.invoke()
                Lb5:
                    v8.k0 r13 = v8.k0.f35197a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.C08345.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08345(h9.l<? super Offset, k0> lVar, p<? super PointerInputChange, ? super Float, k0> pVar, h9.a<k0> aVar, h9.a<k0> aVar2, z8.d<? super C08345> dVar) {
            super(2, dVar);
            this.$onDragStart = lVar;
            this.$onHorizontalDrag = pVar;
            this.$onDragEnd = aVar;
            this.$onDragCancel = aVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C08345 c08345 = new C08345(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, dVar);
            c08345.L$0 = obj;
            return c08345;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
            return ((C08345) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, null);
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    static final class C08363 extends v implements h9.a<k0> {
        public static final C08363 INSTANCE = new C08363();

        C08363() {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    static final class C08374 extends v implements h9.a<k0> {
        public static final C08374 INSTANCE = new C08374();

        C08374() {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5", f = "DragGestureDetector.kt", l = {431}, m = "invokeSuspend")
    static final class C08385 extends l implements p<PointerInputScope, z8.d<? super k0>, Object> {
        final /* synthetic */ h9.a<k0> $onDragCancel;
        final /* synthetic */ h9.a<k0> $onDragEnd;
        final /* synthetic */ h9.l<Offset, k0> $onDragStart;
        final /* synthetic */ p<PointerInputChange, Float, k0> $onVerticalDrag;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: DragGestureDetector.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$1", f = "DragGestureDetector.kt", l = {432, 434, 442}, m = "invokeSuspend")
        static final class AnonymousClass1 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
            final /* synthetic */ h9.a<k0> $onDragCancel;
            final /* synthetic */ h9.a<k0> $onDragEnd;
            final /* synthetic */ h9.l<Offset, k0> $onDragStart;
            final /* synthetic */ p<PointerInputChange, Float, k0> $onVerticalDrag;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: DragGestureDetector.kt */
            static final class C00401 extends v implements h9.l<PointerInputChange, k0> {
                final /* synthetic */ p<PointerInputChange, Float, k0> $onVerticalDrag;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00401(p<? super PointerInputChange, ? super Float, k0> pVar) {
                    super(1);
                    this.$onVerticalDrag = pVar;
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(PointerInputChange pointerInputChange) {
                    invoke2(pointerInputChange);
                    return k0.f35197a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PointerInputChange it) {
                    t.i(it, "it");
                    this.$onVerticalDrag.mo4invoke(it, Float.valueOf(Offset.m1368getYimpl(PointerEventKt.positionChange(it))));
                    it.consume();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(h9.l<? super Offset, k0> lVar, p<? super PointerInputChange, ? super Float, k0> pVar, h9.a<k0> aVar, h9.a<k0> aVar2, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$onDragStart = lVar;
                this.$onVerticalDrag = pVar;
                this.$onDragEnd = aVar;
                this.$onDragCancel = aVar2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onDragStart, this.$onVerticalDrag, this.$onDragEnd, this.$onDragCancel, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x00aa  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00b0  */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
                /*
                    r12 = this;
                    java.lang.Object r0 = a9.b.e()
                    int r1 = r12.label
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L32
                    if (r1 == r4) goto L2a
                    if (r1 == r3) goto L1e
                    if (r1 != r2) goto L16
                    v8.u.b(r13)
                    goto La2
                L16:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                L1e:
                    java.lang.Object r1 = r12.L$1
                    kotlin.jvm.internal.k0 r1 = (kotlin.jvm.internal.k0) r1
                    java.lang.Object r3 = r12.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                    v8.u.b(r13)
                    goto L6d
                L2a:
                    java.lang.Object r1 = r12.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                    v8.u.b(r13)
                    goto L48
                L32:
                    v8.u.b(r13)
                    java.lang.Object r13 = r12.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
                    r12.L$0 = r13
                    r12.label = r4
                    r1 = 0
                    java.lang.Object r1 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r13, r1, r12)
                    if (r1 != r0) goto L45
                    return r0
                L45:
                    r11 = r1
                    r1 = r13
                    r13 = r11
                L48:
                    androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                    kotlin.jvm.internal.k0 r10 = new kotlin.jvm.internal.k0
                    r10.<init>()
                    long r5 = r13.m2872getIdJ3iCeTQ()
                    int r7 = r13.m2876getTypeT8wyACA()
                    androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$1$drag$1 r8 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$1$drag$1
                    r8.<init>(r10)
                    r12.L$0 = r1
                    r12.L$1 = r10
                    r12.label = r3
                    r4 = r1
                    r9 = r12
                    java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m255awaitVerticalPointerSlopOrCancellationgDDlDlE(r4, r5, r7, r8, r9)
                    if (r13 != r0) goto L6b
                    return r0
                L6b:
                    r3 = r1
                    r1 = r10
                L6d:
                    androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                    if (r13 == 0) goto Lb5
                    h9.l<androidx.compose.ui.geometry.Offset, v8.k0> r4 = r12.$onDragStart
                    long r5 = r13.m2873getPositionF1C5BW0()
                    androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.m1356boximpl(r5)
                    r4.invoke(r5)
                    h9.p<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, v8.k0> r4 = r12.$onVerticalDrag
                    float r1 = r1.f29829a
                    java.lang.Float r1 = kotlin.coroutines.jvm.internal.b.c(r1)
                    r4.mo4invoke(r13, r1)
                    long r4 = r13.m2872getIdJ3iCeTQ()
                    androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$1$1 r13 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$1$1
                    h9.p<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, v8.k0> r1 = r12.$onVerticalDrag
                    r13.<init>(r1)
                    r1 = 0
                    r12.L$0 = r1
                    r12.L$1 = r1
                    r12.label = r2
                    java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m262verticalDragjO51t88(r3, r4, r13, r12)
                    if (r13 != r0) goto La2
                    return r0
                La2:
                    java.lang.Boolean r13 = (java.lang.Boolean) r13
                    boolean r13 = r13.booleanValue()
                    if (r13 == 0) goto Lb0
                    h9.a<v8.k0> r13 = r12.$onDragEnd
                    r13.invoke()
                    goto Lb5
                Lb0:
                    h9.a<v8.k0> r13 = r12.$onDragCancel
                    r13.invoke()
                Lb5:
                    v8.k0 r13 = v8.k0.f35197a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.C08385.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08385(h9.l<? super Offset, k0> lVar, p<? super PointerInputChange, ? super Float, k0> pVar, h9.a<k0> aVar, h9.a<k0> aVar2, z8.d<? super C08385> dVar) {
            super(2, dVar);
            this.$onDragStart = lVar;
            this.$onVerticalDrag = pVar;
            this.$onDragEnd = aVar;
            this.$onDragCancel = aVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C08385 c08385 = new C08385(this.$onDragStart, this.$onVerticalDrag, this.$onDragEnd, this.$onDragCancel, dVar);
            c08385.L$0 = obj;
            return c08385;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
            return ((C08385) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onDragStart, this.$onVerticalDrag, this.$onDragEnd, this.$onDragCancel, null);
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

    static {
        float fM3673constructorimpl = Dp.m3673constructorimpl((float) 0.125d);
        mouseSlop = fM3673constructorimpl;
        float fM3673constructorimpl2 = Dp.m3673constructorimpl(18);
        defaultTouchSlop = fM3673constructorimpl2;
        mouseToTouchSlopRatio = fM3673constructorimpl / fM3673constructorimpl2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cb, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11) != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:22:0x006c). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: awaitDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m246awaitDragOrCancellationrnUCldI(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m246awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, z8.d):java.lang.Object");
    }

    /* JADX INFO: renamed from: awaitDragOrUp-jO51t88, reason: not valid java name */
    private static final Object m247awaitDragOrUpjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j10, h9.l<? super PointerInputChange, Boolean> lVar, z8.d<? super PointerInputChange> dVar) {
        PointerInputChange pointerInputChange;
        while (true) {
            int i10 = 0;
            r.c(0);
            PointerInputChange pointerInputChange2 = null;
            Object objT = androidx.compose.ui.input.pointer.b.t(awaitPointerEventScope, null, dVar, 1, null);
            r.c(1);
            PointerEvent pointerEvent = (PointerEvent) objT;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i11);
                if (PointerId.m2860equalsimpl0(pointerInputChange.m2872getIdJ3iCeTQ(), j10)) {
                    break;
                }
                i11++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i10 >= size2) {
                        break;
                    }
                    PointerInputChange pointerInputChange4 = changes2.get(i10);
                    if (pointerInputChange4.getPressed()) {
                        pointerInputChange2 = pointerInputChange4;
                        break;
                    }
                    i10++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange2;
                if (pointerInputChange5 == null) {
                    return pointerInputChange3;
                }
                j10 = pointerInputChange5.m2872getIdJ3iCeTQ();
            } else if (lVar.invoke(pointerInputChange3).booleanValue()) {
                return pointerInputChange3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d8, code lost:
    
        if ((!(androidx.compose.ui.geometry.Offset.m1367getXimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)) == 0.0f)) != false) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:22:0x006c). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: awaitHorizontalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m248awaitHorizontalDragOrCancellationrnUCldI(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m248awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x011c -> B:60:0x0168). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x015b -> B:56:0x015e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0182 -> B:60:0x0168). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m249awaitHorizontalPointerSlopOrCancellationgDDlDlE(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, int r22, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, v8.k0> r23, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m249awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, h9.p, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0120 -> B:60:0x016c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x015f -> B:56:0x0162). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0186 -> B:60:0x016c). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m250awaitHorizontalTouchSlopOrCancellationjO51t88(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, v8.k0> r22, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m250awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, h9.p, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [T, androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v4, types: [androidx.compose.ui.input.pointer.PointerInputChange] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object awaitLongPressOrCancellation(androidx.compose.ui.input.pointer.PointerInputScope r8, androidx.compose.ui.input.pointer.PointerInputChange r9, z8.d<? super androidx.compose.ui.input.pointer.PointerInputChange> r10) {
        /*
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r8 = r0.L$1
            kotlin.jvm.internal.n0 r8 = (kotlin.jvm.internal.n0) r8
            java.lang.Object r9 = r0.L$0
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            v8.u.b(r10)     // Catch: kotlinx.coroutines.d3 -> L64
            goto L6d
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            v8.u.b(r10)
            kotlin.jvm.internal.n0 r10 = new kotlin.jvm.internal.n0
            r10.<init>()
            kotlin.jvm.internal.n0 r2 = new kotlin.jvm.internal.n0
            r2.<init>()
            r2.f29834a = r9
            androidx.compose.ui.platform.ViewConfiguration r5 = r8.getViewConfiguration()
            long r5 = r5.getLongPressTimeoutMillis()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2 r7 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2     // Catch: kotlinx.coroutines.d3 -> L63
            r7.<init>(r8, r2, r10, r3)     // Catch: kotlinx.coroutines.d3 -> L63
            r0.L$0 = r9     // Catch: kotlinx.coroutines.d3 -> L63
            r0.L$1 = r10     // Catch: kotlinx.coroutines.d3 -> L63
            r0.label = r4     // Catch: kotlinx.coroutines.d3 -> L63
            java.lang.Object r8 = kotlinx.coroutines.f3.c(r5, r7, r0)     // Catch: kotlinx.coroutines.d3 -> L63
            if (r8 != r1) goto L6d
            return r1
        L63:
            r8 = r10
        L64:
            T r8 = r8.f29834a
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L6c
            r3 = r9
            goto L6d
        L6c:
            r3 = r8
        L6d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitLongPressOrCancellation(androidx.compose.ui.input.pointer.PointerInputScope, androidx.compose.ui.input.pointer.PointerInputChange, z8.d):java.lang.Object");
    }

    /* JADX WARN: Path cross not found for [B:53:0x0132, B:57:0x0153], limit reached: 71 */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0156 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0115 -> B:68:0x017f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x016f -> B:64:0x0176). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m251awaitPointerSlopOrCancellationgDDlDlE(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, int r22, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super androidx.compose.ui.geometry.Offset, v8.k0> r23, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m251awaitPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, h9.p, z8.d):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cc, code lost:
    
        r21.mo4invoke(r15, java.lang.Float.valueOf(r8 - (java.lang.Math.signum(r8) * r3)));
     */
    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-pn7EDYM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.lang.Object m252awaitPointerSlopOrCancellationpn7EDYM(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, int r20, h9.p<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, v8.k0> r21, h9.l<? super androidx.compose.ui.geometry.Offset, java.lang.Float> r22, z8.d<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m252awaitPointerSlopOrCancellationpn7EDYM(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, h9.p, h9.l, z8.d):java.lang.Object");
    }

    @Nullable
    /* JADX INFO: renamed from: awaitTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    public static final Object m253awaitTouchSlopOrCancellationjO51t88(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j10, @NotNull p<? super PointerInputChange, ? super Offset, k0> pVar, @NotNull z8.d<? super PointerInputChange> dVar) {
        return m251awaitPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, j10, PointerType.Companion.m2938getTouchT8wyACA(), pVar, dVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d8, code lost:
    
        if ((!(androidx.compose.ui.geometry.Offset.m1368getYimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)) == 0.0f)) != false) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:22:0x006c). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: awaitVerticalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m254awaitVerticalDragOrCancellationrnUCldI(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m254awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x011c -> B:60:0x0168). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x015b -> B:56:0x015e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0182 -> B:60:0x0168). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m255awaitVerticalPointerSlopOrCancellationgDDlDlE(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, int r22, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, v8.k0> r23, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m255awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, h9.p, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0120 -> B:60:0x016c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x015f -> B:56:0x0162). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0186 -> B:60:0x016c). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m256awaitVerticalTouchSlopOrCancellationjO51t88(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, v8.k0> r22, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m256awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, h9.p, z8.d):java.lang.Object");
    }

    @Nullable
    public static final Object detectDragGestures(@NotNull PointerInputScope pointerInputScope, @NotNull h9.l<? super Offset, k0> lVar, @NotNull h9.a<k0> aVar, @NotNull h9.a<k0> aVar2, @NotNull p<? super PointerInputChange, ? super Offset, k0> pVar, @NotNull z8.d<? super k0> dVar) {
        Object objForEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new AnonymousClass5(lVar, pVar, aVar2, aVar, null), dVar);
        return objForEachGesture == a9.d.e() ? objForEachGesture : k0.f35197a;
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, h9.l lVar, h9.a aVar, h9.a aVar2, p pVar, z8.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = C08262.INSTANCE;
        }
        h9.l lVar2 = lVar;
        if ((i10 & 2) != 0) {
            aVar = AnonymousClass3.INSTANCE;
        }
        h9.a aVar3 = aVar;
        if ((i10 & 4) != 0) {
            aVar2 = AnonymousClass4.INSTANCE;
        }
        return detectDragGestures(pointerInputScope, lVar2, aVar3, aVar2, pVar, dVar);
    }

    @Nullable
    public static final Object detectDragGesturesAfterLongPress(@NotNull PointerInputScope pointerInputScope, @NotNull h9.l<? super Offset, k0> lVar, @NotNull h9.a<k0> aVar, @NotNull h9.a<k0> aVar2, @NotNull p<? super PointerInputChange, ? super Offset, k0> pVar, @NotNull z8.d<? super k0> dVar) {
        Object objForEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new C08305(lVar, aVar2, aVar, pVar, null), dVar);
        return objForEachGesture == a9.d.e() ? objForEachGesture : k0.f35197a;
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, h9.l lVar, h9.a aVar, h9.a aVar2, p pVar, z8.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = C08272.INSTANCE;
        }
        h9.l lVar2 = lVar;
        if ((i10 & 2) != 0) {
            aVar = C08283.INSTANCE;
        }
        h9.a aVar3 = aVar;
        if ((i10 & 4) != 0) {
            aVar2 = C08294.INSTANCE;
        }
        return detectDragGesturesAfterLongPress(pointerInputScope, lVar2, aVar3, aVar2, pVar, dVar);
    }

    @Nullable
    public static final Object detectHorizontalDragGestures(@NotNull PointerInputScope pointerInputScope, @NotNull h9.l<? super Offset, k0> lVar, @NotNull h9.a<k0> aVar, @NotNull h9.a<k0> aVar2, @NotNull p<? super PointerInputChange, ? super Float, k0> pVar, @NotNull z8.d<? super k0> dVar) {
        Object objForEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new C08345(lVar, pVar, aVar, aVar2, null), dVar);
        return objForEachGesture == a9.d.e() ? objForEachGesture : k0.f35197a;
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, h9.l lVar, h9.a aVar, h9.a aVar2, p pVar, z8.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = C08312.INSTANCE;
        }
        h9.l lVar2 = lVar;
        if ((i10 & 2) != 0) {
            aVar = C08323.INSTANCE;
        }
        h9.a aVar3 = aVar;
        if ((i10 & 4) != 0) {
            aVar2 = C08334.INSTANCE;
        }
        return detectHorizontalDragGestures(pointerInputScope, lVar2, aVar3, aVar2, pVar, dVar);
    }

    @Nullable
    public static final Object detectVerticalDragGestures(@NotNull PointerInputScope pointerInputScope, @NotNull h9.l<? super Offset, k0> lVar, @NotNull h9.a<k0> aVar, @NotNull h9.a<k0> aVar2, @NotNull p<? super PointerInputChange, ? super Float, k0> pVar, @NotNull z8.d<? super k0> dVar) {
        Object objForEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new C08385(lVar, pVar, aVar, aVar2, null), dVar);
        return objForEachGesture == a9.d.e() ? objForEachGesture : k0.f35197a;
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, h9.l lVar, h9.a aVar, h9.a aVar2, p pVar, z8.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = C08352.INSTANCE;
        }
        h9.l lVar2 = lVar;
        if ((i10 & 2) != 0) {
            aVar = C08363.INSTANCE;
        }
        h9.a aVar3 = aVar;
        if ((i10 & 4) != 0) {
            aVar2 = C08374.INSTANCE;
        }
        return detectVerticalDragGestures(pointerInputScope, lVar2, aVar3, aVar2, pVar, dVar);
    }

    /* JADX INFO: renamed from: drag-VnAYq1g, reason: not valid java name */
    private static final Object m257dragVnAYq1g(AwaitPointerEventScope awaitPointerEventScope, long j10, h9.l<? super PointerInputChange, k0> lVar, h9.l<? super PointerInputChange, Float> lVar2, h9.l<? super PointerInputChange, Boolean> lVar3, z8.d<? super Boolean> dVar) {
        PointerInputChange pointerInputChange;
        long jM2872getIdJ3iCeTQ = j10;
        if (m260isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), jM2872getIdJ3iCeTQ)) {
            return Boolean.FALSE;
        }
        while (true) {
            r.c(0);
            PointerInputChange pointerInputChange2 = null;
            Object objT = androidx.compose.ui.input.pointer.b.t(awaitPointerEventScope, null, dVar, 1, null);
            r.c(1);
            PointerEvent pointerEvent = (PointerEvent) objT;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i10);
                if (PointerId.m2860equalsimpl0(pointerInputChange.m2872getIdJ3iCeTQ(), jM2872getIdJ3iCeTQ)) {
                    break;
                }
                i10++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 != null) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            break;
                        }
                        PointerInputChange pointerInputChange4 = changes2.get(i);
                        if (pointerInputChange4.getPressed()) {
                            pointerInputChange2 = pointerInputChange4;
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange5 = pointerInputChange2;
                    if (pointerInputChange5 == null) {
                        pointerInputChange2 = pointerInputChange3;
                    } else {
                        jM2872getIdJ3iCeTQ = pointerInputChange5.m2872getIdJ3iCeTQ();
                    }
                } else {
                    if (((lVar2.invoke(pointerInputChange3).floatValue() == 0.0f ? 1 : 0) ^ 1) != 0) {
                        pointerInputChange2 = pointerInputChange3;
                    } else {
                        continue;
                    }
                }
            }
            if (pointerInputChange2 == null) {
                return Boolean.FALSE;
            }
            if (lVar3.invoke(pointerInputChange2).booleanValue()) {
                return Boolean.FALSE;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                return Boolean.TRUE;
            }
            lVar.invoke(pointerInputChange2);
            jM2872getIdJ3iCeTQ = pointerInputChange2.m2872getIdJ3iCeTQ();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0048 -> B:18:0x004b). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: drag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m258dragjO51t88(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r4, long r5, @org.jetbrains.annotations.NotNull h9.l<? super androidx.compose.ui.input.pointer.PointerInputChange, v8.k0> r7, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$1
            h9.l r4 = (h9.l) r4
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            v8.u.b(r8)
            r7 = r4
            r4 = r5
            goto L4b
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            v8.u.b(r8)
        L3e:
            r0.L$0 = r4
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = m246awaitDragOrCancellationrnUCldI(r4, r5, r0)
            if (r8 != r1) goto L4b
            return r1
        L4b:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L55
            r4 = 0
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.b.a(r4)
            return r4
        L55:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r8)
            if (r5 == 0) goto L60
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.b.a(r3)
            return r4
        L60:
            r7.invoke(r8)
            long r5 = r8.m2872getIdJ3iCeTQ()
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m258dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, h9.l, z8.d):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f5, code lost:
    
        if ((!(androidx.compose.ui.geometry.Offset.m1367getXimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r13)) == 0.0f)) != false) goto L52;
     */
    /* JADX WARN: Path cross not found for [B:46:0x00e4, B:35:0x00bb], limit reached: 67 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0082 -> B:23:0x0088). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: horizontalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m259horizontalDragjO51t88(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, long r19, @org.jetbrains.annotations.NotNull h9.l<? super androidx.compose.ui.input.pointer.PointerInputChange, v8.k0> r21, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Boolean> r22) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m259horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, h9.l, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    public static final boolean m260isPointerUpDmW0f2w(PointerEvent pointerEvent, long j10) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i10);
            if (PointerId.m2860equalsimpl0(pointerInputChange.m2872getIdJ3iCeTQ(), j10)) {
                break;
            }
            i10++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z10 = true;
        }
        return true ^ z10;
    }

    /* JADX INFO: renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m261pointerSlopE8SPZFQ(@NotNull ViewConfiguration pointerSlop, int i10) {
        t.i(pointerSlop, "$this$pointerSlop");
        return PointerType.m2931equalsimpl0(i10, PointerType.Companion.m2936getMouseT8wyACA()) ? pointerSlop.getTouchSlop() * mouseToTouchSlopRatio : pointerSlop.getTouchSlop();
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f5, code lost:
    
        if ((!(androidx.compose.ui.geometry.Offset.m1368getYimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r13)) == 0.0f)) != false) goto L52;
     */
    /* JADX WARN: Path cross not found for [B:46:0x00e4, B:35:0x00bb], limit reached: 67 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0082 -> B:23:0x0088). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: verticalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m262verticalDragjO51t88(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, long r19, @org.jetbrains.annotations.NotNull h9.l<? super androidx.compose.ui.input.pointer.PointerInputChange, v8.k0> r21, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Boolean> r22) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m262verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, h9.l, z8.d):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    static final class C08262 extends v implements h9.l<Offset, k0> {
        public static final C08262 INSTANCE = new C08262();

        C08262() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Offset offset) {
            m263invokek4lQ0M(offset.m1377unboximpl());
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m263invokek4lQ0M(long j10) {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    static final class C08272 extends v implements h9.l<Offset, k0> {
        public static final C08272 INSTANCE = new C08272();

        C08272() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Offset offset) {
            m265invokek4lQ0M(offset.m1377unboximpl());
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m265invokek4lQ0M(long j10) {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    static final class C08312 extends v implements h9.l<Offset, k0> {
        public static final C08312 INSTANCE = new C08312();

        C08312() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Offset offset) {
            m266invokek4lQ0M(offset.m1377unboximpl());
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m266invokek4lQ0M(long j10) {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    static final class C08352 extends v implements h9.l<Offset, k0> {
        public static final C08352 INSTANCE = new C08352();

        C08352() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Offset offset) {
            m267invokek4lQ0M(offset.m1377unboximpl());
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m267invokek4lQ0M(long j10) {
        }
    }
}
