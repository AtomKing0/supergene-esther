package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import h9.a;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: LongPressTextDragObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LongPressTextDragObserverKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2, reason: invalid class name */
    /* JADX INFO: compiled from: LongPressTextDragObserver.kt */
    @f(c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2", f = "LongPressTextDragObserver.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, d<? super b2>, Object> {
        final /* synthetic */ TextDragObserver $observer;
        final /* synthetic */ PointerInputScope $this_detectDownAndDragGesturesWithObserver;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: LongPressTextDragObserver.kt */
        @f(c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2$1", f = "LongPressTextDragObserver.kt", l = {82}, m = "invokeSuspend")
        static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
            final /* synthetic */ TextDragObserver $observer;
            final /* synthetic */ PointerInputScope $this_detectDownAndDragGesturesWithObserver;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$this_detectDownAndDragGesturesWithObserver = pointerInputScope;
                this.$observer = textDragObserver;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new AnonymousClass1(this.$this_detectDownAndDragGesturesWithObserver, this.$observer, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    PointerInputScope pointerInputScope = this.$this_detectDownAndDragGesturesWithObserver;
                    TextDragObserver textDragObserver = this.$observer;
                    this.label = 1;
                    if (LongPressTextDragObserverKt.detectPreDragGesturesWithObserver(pointerInputScope, textDragObserver, this) == objE) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: LongPressTextDragObserver.kt */
        @f(c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2$2", f = "LongPressTextDragObserver.kt", l = {85}, m = "invokeSuspend")
        static final class C00602 extends l implements p<o0, d<? super k0>, Object> {
            final /* synthetic */ TextDragObserver $observer;
            final /* synthetic */ PointerInputScope $this_detectDownAndDragGesturesWithObserver;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00602(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, d<? super C00602> dVar) {
                super(2, dVar);
                this.$this_detectDownAndDragGesturesWithObserver = pointerInputScope;
                this.$observer = textDragObserver;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new C00602(this.$this_detectDownAndDragGesturesWithObserver, this.$observer, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    PointerInputScope pointerInputScope = this.$this_detectDownAndDragGesturesWithObserver;
                    TextDragObserver textDragObserver = this.$observer;
                    this.label = 1;
                    if (LongPressTextDragObserverKt.detectDragGesturesWithObserver(pointerInputScope, textDragObserver, this) == objE) {
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
                return ((C00602) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$this_detectDownAndDragGesturesWithObserver = pointerInputScope;
            this.$observer = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_detectDownAndDragGesturesWithObserver, this.$observer, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            o0 o0Var = (o0) this.L$0;
            k.d(o0Var, null, null, new AnonymousClass1(this.$this_detectDownAndDragGesturesWithObserver, this.$observer, null), 3, null);
            return k.d(o0Var, null, null, new C00602(this.$this_detectDownAndDragGesturesWithObserver, this.$observer, null), 3, null);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super b2> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDragGesturesAfterLongPressWithObserver$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LongPressTextDragObserver.kt */
    static final class C09022 extends v implements h9.l<Offset, k0> {
        final /* synthetic */ TextDragObserver $observer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09022(TextDragObserver textDragObserver) {
            super(1);
            this.$observer = textDragObserver;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Offset offset) {
            m680invokek4lQ0M(offset.m1377unboximpl());
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m680invokek4lQ0M(long j10) {
            this.$observer.mo711onStartk4lQ0M(j10);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDragGesturesAfterLongPressWithObserver$3, reason: invalid class name */
    /* JADX INFO: compiled from: LongPressTextDragObserver.kt */
    static final class AnonymousClass3 extends v implements a<k0> {
        final /* synthetic */ TextDragObserver $observer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(TextDragObserver textDragObserver) {
            super(0);
            this.$observer = textDragObserver;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$observer.onStop();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDragGesturesAfterLongPressWithObserver$4, reason: invalid class name */
    /* JADX INFO: compiled from: LongPressTextDragObserver.kt */
    static final class AnonymousClass4 extends v implements a<k0> {
        final /* synthetic */ TextDragObserver $observer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(TextDragObserver textDragObserver) {
            super(0);
            this.$observer = textDragObserver;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$observer.onCancel();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDragGesturesAfterLongPressWithObserver$5, reason: invalid class name */
    /* JADX INFO: compiled from: LongPressTextDragObserver.kt */
    static final class AnonymousClass5 extends v implements p<PointerInputChange, Offset, k0> {
        final /* synthetic */ TextDragObserver $observer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(TextDragObserver textDragObserver) {
            super(2);
            this.$observer = textDragObserver;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(PointerInputChange pointerInputChange, Offset offset) {
            m681invokeUv8p0NA(pointerInputChange, offset.m1377unboximpl());
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
        public final void m681invokeUv8p0NA(@NotNull PointerInputChange pointerInputChange, long j10) {
            t.i(pointerInputChange, "<anonymous parameter 0>");
            this.$observer.mo710onDragk4lQ0M(j10);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDragGesturesWithObserver$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LongPressTextDragObserver.kt */
    static final class C09032 extends v implements h9.l<Offset, k0> {
        final /* synthetic */ TextDragObserver $observer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09032(TextDragObserver textDragObserver) {
            super(1);
            this.$observer = textDragObserver;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Offset offset) {
            m682invokek4lQ0M(offset.m1377unboximpl());
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m682invokek4lQ0M(long j10) {
            this.$observer.mo711onStartk4lQ0M(j10);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDragGesturesWithObserver$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LongPressTextDragObserver.kt */
    static final class C09043 extends v implements a<k0> {
        final /* synthetic */ TextDragObserver $observer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09043(TextDragObserver textDragObserver) {
            super(0);
            this.$observer = textDragObserver;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$observer.onStop();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDragGesturesWithObserver$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LongPressTextDragObserver.kt */
    static final class C09054 extends v implements a<k0> {
        final /* synthetic */ TextDragObserver $observer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09054(TextDragObserver textDragObserver) {
            super(0);
            this.$observer = textDragObserver;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$observer.onCancel();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDragGesturesWithObserver$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LongPressTextDragObserver.kt */
    static final class C09065 extends v implements p<PointerInputChange, Offset, k0> {
        final /* synthetic */ TextDragObserver $observer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09065(TextDragObserver textDragObserver) {
            super(2);
            this.$observer = textDragObserver;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(PointerInputChange pointerInputChange, Offset offset) {
            m683invokeUv8p0NA(pointerInputChange, offset.m1377unboximpl());
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
        public final void m683invokeUv8p0NA(@NotNull PointerInputChange pointerInputChange, long j10) {
            t.i(pointerInputChange, "<anonymous parameter 0>");
            this.$observer.mo710onDragk4lQ0M(j10);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LongPressTextDragObserver.kt */
    @f(c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2", f = "LongPressTextDragObserver.kt", l = {98}, m = "invokeSuspend")
    static final class C09072 extends l implements p<PointerInputScope, d<? super k0>, Object> {
        final /* synthetic */ TextDragObserver $observer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: LongPressTextDragObserver.kt */
        @f(c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2$1", f = "LongPressTextDragObserver.kt", l = {99, 103}, m = "invokeSuspend")
        static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.k implements p<AwaitPointerEventScope, d<? super k0>, Object> {
            final /* synthetic */ TextDragObserver $observer;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TextDragObserver textDragObserver, d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$observer = textDragObserver;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$observer, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable d<? super k0> dVar) {
                return ((AnonymousClass1) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0060 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x009f  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x0094 A[SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005e -> B:17:0x0061). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
                /*
                    r16 = this;
                    r0 = r16
                    java.lang.Object r1 = a9.b.e()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 0
                    r5 = 0
                    r6 = 1
                    if (r2 == 0) goto L33
                    if (r2 == r6) goto L29
                    if (r2 != r3) goto L21
                    java.lang.Object r2 = r0.L$1
                    androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
                    java.lang.Object r7 = r0.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
                    v8.u.b(r17)
                    r9 = r17
                    r8 = r0
                    goto L61
                L21:
                    java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                    java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                    r1.<init>(r2)
                    throw r1
                L29:
                    java.lang.Object r2 = r0.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                    v8.u.b(r17)
                    r7 = r17
                    goto L45
                L33:
                    v8.u.b(r17)
                    java.lang.Object r2 = r0.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                    r0.L$0 = r2
                    r0.label = r6
                    java.lang.Object r7 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r2, r5, r0, r6, r4)
                    if (r7 != r1) goto L45
                    return r1
                L45:
                    androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
                    androidx.compose.foundation.text.TextDragObserver r8 = r0.$observer
                    long r9 = r7.m2873getPositionF1C5BW0()
                    r8.mo709onDownk4lQ0M(r9)
                    r8 = r0
                    r15 = r7
                    r7 = r2
                    r2 = r15
                L54:
                    r8.L$0 = r7
                    r8.L$1 = r2
                    r8.label = r3
                    java.lang.Object r9 = androidx.compose.ui.input.pointer.b.t(r7, r4, r8, r6, r4)
                    if (r9 != r1) goto L61
                    return r1
                L61:
                    androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
                    java.util.List r9 = r9.getChanges()
                    int r10 = r9.size()
                    r11 = r5
                L6c:
                    if (r11 >= r10) goto L94
                    java.lang.Object r12 = r9.get(r11)
                    androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
                    long r13 = r12.m2872getIdJ3iCeTQ()
                    long r3 = r2.m2872getIdJ3iCeTQ()
                    boolean r3 = androidx.compose.ui.input.pointer.PointerId.m2860equalsimpl0(r13, r3)
                    if (r3 == 0) goto L8a
                    boolean r3 = r12.getPressed()
                    if (r3 == 0) goto L8a
                    r3 = r6
                    goto L8b
                L8a:
                    r3 = r5
                L8b:
                    if (r3 == 0) goto L8f
                    r3 = r6
                    goto L95
                L8f:
                    int r11 = r11 + 1
                    r3 = 2
                    r4 = 0
                    goto L6c
                L94:
                    r3 = r5
                L95:
                    if (r3 != 0) goto L9f
                    androidx.compose.foundation.text.TextDragObserver r1 = r8.$observer
                    r1.onUp()
                    v8.k0 r1 = v8.k0.f35197a
                    return r1
                L9f:
                    r3 = 2
                    r4 = 0
                    goto L54
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.LongPressTextDragObserverKt.C09072.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09072(TextDragObserver textDragObserver, d<? super C09072> dVar) {
            super(2, dVar);
            this.$observer = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            C09072 c09072 = new C09072(this.$observer, dVar);
            c09072.L$0 = obj;
            return c09072;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
            return ((C09072) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$observer, null);
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

    @Nullable
    public static final Object detectDownAndDragGesturesWithObserver(@NotNull PointerInputScope pointerInputScope, @NotNull TextDragObserver textDragObserver, @NotNull d<? super k0> dVar) {
        Object objF = p0.f(new AnonymousClass2(pointerInputScope, textDragObserver, null), dVar);
        return objF == a9.d.e() ? objF : k0.f35197a;
    }

    @Nullable
    public static final Object detectDragGesturesAfterLongPressWithObserver(@NotNull PointerInputScope pointerInputScope, @NotNull TextDragObserver textDragObserver, @NotNull d<? super k0> dVar) {
        Object objDetectDragGesturesAfterLongPress = DragGestureDetectorKt.detectDragGesturesAfterLongPress(pointerInputScope, new C09022(textDragObserver), new AnonymousClass3(textDragObserver), new AnonymousClass4(textDragObserver), new AnonymousClass5(textDragObserver), dVar);
        return objDetectDragGesturesAfterLongPress == a9.d.e() ? objDetectDragGesturesAfterLongPress : k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object detectDragGesturesWithObserver(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, d<? super k0> dVar) {
        Object objDetectDragGestures = DragGestureDetectorKt.detectDragGestures(pointerInputScope, new C09032(textDragObserver), new C09043(textDragObserver), new C09054(textDragObserver), new C09065(textDragObserver), dVar);
        return objDetectDragGestures == a9.d.e() ? objDetectDragGestures : k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object detectPreDragGesturesWithObserver(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, d<? super k0> dVar) {
        Object objForEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new C09072(textDragObserver, null), dVar);
        return objForEachGesture == a9.d.e() ? objForEachGesture : k0.f35197a;
    }
}
