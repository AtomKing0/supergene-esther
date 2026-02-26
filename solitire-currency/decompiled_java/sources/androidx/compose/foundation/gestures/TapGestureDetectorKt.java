package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.k;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: TapGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TapGestureDetectorKt {

    @NotNull
    private static final q<PressGestureScope, Offset, z8.d<? super k0>, Object> NoPressGesture = new TapGestureDetectorKt$NoPressGesture$1(null);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDownOnPass$1, reason: invalid class name */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", l = {244}, m = "awaitFirstDownOnPass")
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
            return TapGestureDetectorKt.awaitFirstDownOnPass(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2, reason: invalid class name */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2", f = "TapGestureDetector.kt", l = {191}, m = "invokeSuspend")
    static final class AnonymousClass2 extends k implements p<AwaitPointerEventScope, z8.d<? super PointerInputChange>, Object> {
        final /* synthetic */ PointerInputChange $firstUp;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PointerInputChange pointerInputChange, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$firstUp = pointerInputChange;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$firstUp, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super PointerInputChange> dVar) {
            return ((AnonymousClass2) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0047 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0058 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0048 -> B:13:0x004e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r9.label
                r2 = 1
                if (r1 == 0) goto L21
                if (r1 != r2) goto L19
                long r3 = r9.J$0
                java.lang.Object r1 = r9.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                v8.u.b(r10)
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                goto L4e
            L19:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L21:
                v8.u.b(r10)
                java.lang.Object r10 = r9.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
                androidx.compose.ui.input.pointer.PointerInputChange r1 = r9.$firstUp
                long r3 = r1.getUptimeMillis()
                androidx.compose.ui.platform.ViewConfiguration r1 = r10.getViewConfiguration()
                long r5 = r1.getDoubleTapMinTimeMillis()
                long r3 = r3 + r5
                r1 = r10
                r10 = r9
            L39:
                r10.L$0 = r1
                r10.J$0 = r3
                r10.label = r2
                r5 = 0
                r6 = 0
                java.lang.Object r5 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r1, r5, r10, r2, r6)
                if (r5 != r0) goto L48
                return r0
            L48:
                r8 = r0
                r0 = r10
                r10 = r5
                r4 = r3
                r3 = r1
                r1 = r8
            L4e:
                androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
                long r6 = r10.getUptimeMillis()
                int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r6 < 0) goto L59
                return r10
            L59:
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L39
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", l = {174}, m = "consumeUntilUp")
    static final class C08501 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08501(z8.d<? super C08501> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.consumeUntilUp(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2", f = "TapGestureDetector.kt", l = {206}, m = "invokeSuspend")
    static final class C08512 extends l implements p<PointerInputScope, z8.d<? super k0>, Object> {
        final /* synthetic */ q<PressGestureScope, Offset, z8.d<? super k0>, Object> $onPress;
        final /* synthetic */ h9.l<Offset, k0> $onTap;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TapGestureDetector.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1", f = "TapGestureDetector.kt", l = {208}, m = "invokeSuspend")
        static final class AnonymousClass1 extends l implements p<o0, z8.d<? super k0>, Object> {
            final /* synthetic */ PointerInputScope $$this$forEachGesture;
            final /* synthetic */ q<PressGestureScope, Offset, z8.d<? super k0>, Object> $onPress;
            final /* synthetic */ h9.l<Offset, k0> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1", f = "TapGestureDetector.kt", l = {210, 216}, m = "invokeSuspend")
            static final class C00441 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
                final /* synthetic */ o0 $$this$coroutineScope;
                final /* synthetic */ q<PressGestureScope, Offset, z8.d<? super k0>, Object> $onPress;
                final /* synthetic */ h9.l<Offset, k0> $onTap;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: TapGestureDetector.kt */
                @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1$1", f = "TapGestureDetector.kt", l = {213}, m = "invokeSuspend")
                static final class C00451 extends l implements p<o0, z8.d<? super k0>, Object> {
                    final /* synthetic */ PointerInputChange $down;
                    final /* synthetic */ q<PressGestureScope, Offset, z8.d<? super k0>, Object> $onPress;
                    final /* synthetic */ PressGestureScopeImpl $pressScope;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C00451(q<? super PressGestureScope, ? super Offset, ? super z8.d<? super k0>, ? extends Object> qVar, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, z8.d<? super C00451> dVar) {
                        super(2, dVar);
                        this.$onPress = qVar;
                        this.$pressScope = pressGestureScopeImpl;
                        this.$down = pointerInputChange;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                        return new C00451(this.$onPress, this.$pressScope, this.$down, dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object objE = a9.d.e();
                        int i10 = this.label;
                        if (i10 == 0) {
                            u.b(obj);
                            q<PressGestureScope, Offset, z8.d<? super k0>, Object> qVar = this.$onPress;
                            PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                            Offset offsetM1356boximpl = Offset.m1356boximpl(this.$down.m2873getPositionF1C5BW0());
                            this.label = 1;
                            if (qVar.invoke(pressGestureScopeImpl, offsetM1356boximpl, this) == objE) {
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
                        return ((C00451) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00441(q<? super PressGestureScope, ? super Offset, ? super z8.d<? super k0>, ? extends Object> qVar, o0 o0Var, PressGestureScopeImpl pressGestureScopeImpl, h9.l<? super Offset, k0> lVar, z8.d<? super C00441> dVar) {
                    super(2, dVar);
                    this.$onPress = qVar;
                    this.$$this$coroutineScope = o0Var;
                    this.$pressScope = pressGestureScopeImpl;
                    this.$onTap = lVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    C00441 c00441 = new C00441(this.$onPress, this.$$this$coroutineScope, this.$pressScope, this.$onTap, dVar);
                    c00441.L$0 = obj;
                    return c00441;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                    return ((C00441) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
                }

                /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
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
                        r2 = 2
                        r3 = 0
                        r4 = 1
                        if (r1 == 0) goto L23
                        if (r1 == r4) goto L1b
                        if (r1 != r2) goto L13
                        v8.u.b(r13)
                        goto L61
                    L13:
                        java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r13.<init>(r0)
                        throw r13
                    L1b:
                        java.lang.Object r1 = r12.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        v8.u.b(r13)
                        goto L37
                    L23:
                        v8.u.b(r13)
                        java.lang.Object r13 = r12.L$0
                        r1 = r13
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        r12.L$0 = r1
                        r12.label = r4
                        r13 = 0
                        java.lang.Object r13 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r1, r13, r12, r4, r3)
                        if (r13 != r0) goto L37
                        return r0
                    L37:
                        androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                        r13.consume()
                        h9.q<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, z8.d<? super v8.k0>, java.lang.Object> r4 = r12.$onPress
                        h9.q r5 = androidx.compose.foundation.gestures.TapGestureDetectorKt.access$getNoPressGesture$p()
                        if (r4 == r5) goto L56
                        kotlinx.coroutines.o0 r6 = r12.$$this$coroutineScope
                        r7 = 0
                        r8 = 0
                        androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1$1 r9 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1$1
                        h9.q<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, z8.d<? super v8.k0>, java.lang.Object> r4 = r12.$onPress
                        androidx.compose.foundation.gestures.PressGestureScopeImpl r5 = r12.$pressScope
                        r9.<init>(r4, r5, r13, r3)
                        r10 = 3
                        r11 = 0
                        kotlinx.coroutines.i.d(r6, r7, r8, r9, r10, r11)
                    L56:
                        r12.L$0 = r3
                        r12.label = r2
                        java.lang.Object r13 = androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(r1, r12)
                        if (r13 != r0) goto L61
                        return r0
                    L61:
                        androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                        if (r13 != 0) goto L6b
                        androidx.compose.foundation.gestures.PressGestureScopeImpl r13 = r12.$pressScope
                        r13.cancel()
                        goto L82
                    L6b:
                        r13.consume()
                        androidx.compose.foundation.gestures.PressGestureScopeImpl r0 = r12.$pressScope
                        r0.release()
                        h9.l<androidx.compose.ui.geometry.Offset, v8.k0> r0 = r12.$onTap
                        if (r0 == 0) goto L82
                        long r1 = r13.m2873getPositionF1C5BW0()
                        androidx.compose.ui.geometry.Offset r13 = androidx.compose.ui.geometry.Offset.m1356boximpl(r1)
                        r0.invoke(r13)
                    L82:
                        v8.k0 r13 = v8.k0.f35197a
                        return r13
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.C08512.AnonymousClass1.C00441.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(PressGestureScopeImpl pressGestureScopeImpl, PointerInputScope pointerInputScope, q<? super PressGestureScope, ? super Offset, ? super z8.d<? super k0>, ? extends Object> qVar, h9.l<? super Offset, k0> lVar, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$pressScope = pressGestureScopeImpl;
                this.$$this$forEachGesture = pointerInputScope;
                this.$onPress = qVar;
                this.$onTap = lVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$pressScope, this.$$this$forEachGesture, this.$onPress, this.$onTap, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    o0 o0Var = (o0) this.L$0;
                    this.$pressScope.reset();
                    PointerInputScope pointerInputScope = this.$$this$forEachGesture;
                    C00441 c00441 = new C00441(this.$onPress, o0Var, this.$pressScope, this.$onTap, null);
                    this.label = 1;
                    if (pointerInputScope.awaitPointerEventScope(c00441, this) == objE) {
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
        /* JADX WARN: Multi-variable type inference failed */
        C08512(PressGestureScopeImpl pressGestureScopeImpl, q<? super PressGestureScope, ? super Offset, ? super z8.d<? super k0>, ? extends Object> qVar, h9.l<? super Offset, k0> lVar, z8.d<? super C08512> dVar) {
            super(2, dVar);
            this.$pressScope = pressGestureScopeImpl;
            this.$onPress = qVar;
            this.$onTap = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C08512 c08512 = new C08512(this.$pressScope, this.$onPress, this.$onTap, dVar);
            c08512.L$0 = obj;
            return c08512;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
            return ((C08512) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$pressScope, (PointerInputScope) this.L$0, this.$onPress, this.$onTap, null);
                this.label = 1;
                if (p0.f(anonymousClass1, this) == objE) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", f = "TapGestureDetector.kt", l = {92}, m = "invokeSuspend")
    static final class C08522 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ h9.l<Offset, k0> $onDoubleTap;
        final /* synthetic */ h9.l<Offset, k0> $onLongPress;
        final /* synthetic */ q<PressGestureScope, Offset, z8.d<? super k0>, Object> $onPress;
        final /* synthetic */ h9.l<Offset, k0> $onTap;
        final /* synthetic */ PointerInputScope $this_detectTapGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TapGestureDetector.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", f = "TapGestureDetector.kt", l = {93}, m = "invokeSuspend")
        static final class AnonymousClass1 extends l implements p<PointerInputScope, z8.d<? super k0>, Object> {
            final /* synthetic */ o0 $$this$coroutineScope;
            final /* synthetic */ h9.l<Offset, k0> $onDoubleTap;
            final /* synthetic */ h9.l<Offset, k0> $onLongPress;
            final /* synthetic */ q<PressGestureScope, Offset, z8.d<? super k0>, Object> $onPress;
            final /* synthetic */ h9.l<Offset, k0> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1", f = "TapGestureDetector.kt", l = {94, 106, 117, 127, IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, 158}, m = "invokeSuspend")
            static final class C00461 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
                final /* synthetic */ o0 $$this$coroutineScope;
                final /* synthetic */ h9.l<Offset, k0> $onDoubleTap;
                final /* synthetic */ h9.l<Offset, k0> $onLongPress;
                final /* synthetic */ q<PressGestureScope, Offset, z8.d<? super k0>, Object> $onPress;
                final /* synthetic */ h9.l<Offset, k0> $onTap;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                long J$0;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;

                /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: TapGestureDetector.kt */
                @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$1", f = "TapGestureDetector.kt", l = {98}, m = "invokeSuspend")
                static final class C00471 extends l implements p<o0, z8.d<? super k0>, Object> {
                    final /* synthetic */ PointerInputChange $down;
                    final /* synthetic */ q<PressGestureScope, Offset, z8.d<? super k0>, Object> $onPress;
                    final /* synthetic */ PressGestureScopeImpl $pressScope;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C00471(q<? super PressGestureScope, ? super Offset, ? super z8.d<? super k0>, ? extends Object> qVar, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, z8.d<? super C00471> dVar) {
                        super(2, dVar);
                        this.$onPress = qVar;
                        this.$pressScope = pressGestureScopeImpl;
                        this.$down = pointerInputChange;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                        return new C00471(this.$onPress, this.$pressScope, this.$down, dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object objE = a9.d.e();
                        int i10 = this.label;
                        if (i10 == 0) {
                            u.b(obj);
                            q<PressGestureScope, Offset, z8.d<? super k0>, Object> qVar = this.$onPress;
                            PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                            Offset offsetM1356boximpl = Offset.m1356boximpl(this.$down.m2873getPositionF1C5BW0());
                            this.label = 1;
                            if (qVar.invoke(pressGestureScopeImpl, offsetM1356boximpl, this) == objE) {
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
                        return ((C00471) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                    }
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$2, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: TapGestureDetector.kt */
                @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$2", f = "TapGestureDetector.kt", l = {107}, m = "invokeSuspend")
                static final class C00482 extends k implements p<AwaitPointerEventScope, z8.d<? super PointerInputChange>, Object> {
                    private /* synthetic */ Object L$0;
                    int label;

                    C00482(z8.d<? super C00482> dVar) {
                        super(2, dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                        C00482 c00482 = new C00482(dVar);
                        c00482.L$0 = obj;
                        return c00482;
                    }

                    @Override // h9.p
                    @Nullable
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super PointerInputChange> dVar) {
                        return ((C00482) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
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
                            obj = TapGestureDetectorKt.waitForUpOrCancellation(awaitPointerEventScope, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            u.b(obj);
                        }
                        return obj;
                    }
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$3, reason: invalid class name */
                /* JADX INFO: compiled from: TapGestureDetector.kt */
                @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$3", f = "TapGestureDetector.kt", l = {135}, m = "invokeSuspend")
                static final class AnonymousClass3 extends l implements p<o0, z8.d<? super k0>, Object> {
                    final /* synthetic */ q<PressGestureScope, Offset, z8.d<? super k0>, Object> $onPress;
                    final /* synthetic */ PressGestureScopeImpl $pressScope;
                    final /* synthetic */ PointerInputChange $secondDown;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass3(q<? super PressGestureScope, ? super Offset, ? super z8.d<? super k0>, ? extends Object> qVar, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, z8.d<? super AnonymousClass3> dVar) {
                        super(2, dVar);
                        this.$onPress = qVar;
                        this.$pressScope = pressGestureScopeImpl;
                        this.$secondDown = pointerInputChange;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                        return new AnonymousClass3(this.$onPress, this.$pressScope, this.$secondDown, dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object objE = a9.d.e();
                        int i10 = this.label;
                        if (i10 == 0) {
                            u.b(obj);
                            q<PressGestureScope, Offset, z8.d<? super k0>, Object> qVar = this.$onPress;
                            PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                            Offset offsetM1356boximpl = Offset.m1356boximpl(this.$secondDown.m2873getPositionF1C5BW0());
                            this.label = 1;
                            if (qVar.invoke(pressGestureScopeImpl, offsetM1356boximpl, this) == objE) {
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
                        return ((AnonymousClass3) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                    }
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$4, reason: invalid class name */
                /* JADX INFO: compiled from: TapGestureDetector.kt */
                @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$4", f = "TapGestureDetector.kt", l = {141}, m = "invokeSuspend")
                static final class AnonymousClass4 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
                    final /* synthetic */ h9.l<Offset, k0> $onDoubleTap;
                    final /* synthetic */ h9.l<Offset, k0> $onTap;
                    final /* synthetic */ PressGestureScopeImpl $pressScope;
                    final /* synthetic */ n0<PointerInputChange> $upOrCancel;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass4(PressGestureScopeImpl pressGestureScopeImpl, h9.l<? super Offset, k0> lVar, h9.l<? super Offset, k0> lVar2, n0<PointerInputChange> n0Var, z8.d<? super AnonymousClass4> dVar) {
                        super(2, dVar);
                        this.$pressScope = pressGestureScopeImpl;
                        this.$onDoubleTap = lVar;
                        this.$onTap = lVar2;
                        this.$upOrCancel = n0Var;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                        AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$pressScope, this.$onDoubleTap, this.$onTap, this.$upOrCancel, dVar);
                        anonymousClass4.L$0 = obj;
                        return anonymousClass4;
                    }

                    @Override // h9.p
                    @Nullable
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                        return ((AnonymousClass4) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
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
                            obj = TapGestureDetectorKt.waitForUpOrCancellation(awaitPointerEventScope, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            u.b(obj);
                        }
                        PointerInputChange pointerInputChange = (PointerInputChange) obj;
                        if (pointerInputChange != null) {
                            pointerInputChange.consume();
                            this.$pressScope.release();
                            this.$onDoubleTap.invoke(Offset.m1356boximpl(pointerInputChange.m2873getPositionF1C5BW0()));
                            return k0.f35197a;
                        }
                        this.$pressScope.cancel();
                        h9.l<Offset, k0> lVar = this.$onTap;
                        if (lVar == null) {
                            return null;
                        }
                        lVar.invoke(Offset.m1356boximpl(this.$upOrCancel.f29834a.m2873getPositionF1C5BW0()));
                        return k0.f35197a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00461(PressGestureScopeImpl pressGestureScopeImpl, q<? super PressGestureScope, ? super Offset, ? super z8.d<? super k0>, ? extends Object> qVar, o0 o0Var, h9.l<? super Offset, k0> lVar, h9.l<? super Offset, k0> lVar2, h9.l<? super Offset, k0> lVar3, z8.d<? super C00461> dVar) {
                    super(2, dVar);
                    this.$pressScope = pressGestureScopeImpl;
                    this.$onPress = qVar;
                    this.$$this$coroutineScope = o0Var;
                    this.$onLongPress = lVar;
                    this.$onDoubleTap = lVar2;
                    this.$onTap = lVar3;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    C00461 c00461 = new C00461(this.$pressScope, this.$onPress, this.$$this$coroutineScope, this.$onLongPress, this.$onDoubleTap, this.$onTap, dVar);
                    c00461.L$0 = obj;
                    return c00461;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                    return ((C00461) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:23:0x009e  */
                /* JADX WARN: Removed duplicated region for block: B:26:0x00b4  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x00bd  */
                /* JADX WARN: Removed duplicated region for block: B:31:0x00df A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:32:0x00e0  */
                /* JADX WARN: Removed duplicated region for block: B:35:0x00e9 A[Catch: PointerEventTimeoutCancellationException -> 0x00fa, TryCatch #0 {PointerEventTimeoutCancellationException -> 0x00fa, blocks: (B:33:0x00e3, B:35:0x00e9, B:36:0x00ef), top: B:84:0x00e3 }] */
                /* JADX WARN: Removed duplicated region for block: B:36:0x00ef A[Catch: PointerEventTimeoutCancellationException -> 0x00fa, TRY_LEAVE, TryCatch #0 {PointerEventTimeoutCancellationException -> 0x00fa, blocks: (B:33:0x00e3, B:35:0x00e9, B:36:0x00ef), top: B:84:0x00e3 }] */
                /* JADX WARN: Removed duplicated region for block: B:41:0x0101  */
                /* JADX WARN: Removed duplicated region for block: B:44:0x011f A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:48:0x012b  */
                /* JADX WARN: Removed duplicated region for block: B:59:0x015e  */
                /* JADX WARN: Removed duplicated region for block: B:62:0x0173  */
                /* JADX WARN: Removed duplicated region for block: B:71:0x01bb  */
                /* JADX WARN: Removed duplicated region for block: B:74:0x01ce  */
                /* JADX WARN: Removed duplicated region for block: B:77:0x01e8 A[RETURN] */
                @Override // kotlin.coroutines.jvm.internal.a
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
                    /*
                        Method dump skipped, instruction units count: 516
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.C08522.AnonymousClass1.C00461.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(PressGestureScopeImpl pressGestureScopeImpl, q<? super PressGestureScope, ? super Offset, ? super z8.d<? super k0>, ? extends Object> qVar, o0 o0Var, h9.l<? super Offset, k0> lVar, h9.l<? super Offset, k0> lVar2, h9.l<? super Offset, k0> lVar3, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$pressScope = pressGestureScopeImpl;
                this.$onPress = qVar;
                this.$$this$coroutineScope = o0Var;
                this.$onLongPress = lVar;
                this.$onDoubleTap = lVar2;
                this.$onTap = lVar3;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$pressScope, this.$onPress, this.$$this$coroutineScope, this.$onLongPress, this.$onDoubleTap, this.$onTap, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                    C00461 c00461 = new C00461(this.$pressScope, this.$onPress, this.$$this$coroutineScope, this.$onLongPress, this.$onDoubleTap, this.$onTap, null);
                    this.label = 1;
                    if (pointerInputScope.awaitPointerEventScope(c00461, this) == objE) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08522(PointerInputScope pointerInputScope, q<? super PressGestureScope, ? super Offset, ? super z8.d<? super k0>, ? extends Object> qVar, h9.l<? super Offset, k0> lVar, h9.l<? super Offset, k0> lVar2, h9.l<? super Offset, k0> lVar3, z8.d<? super C08522> dVar) {
            super(2, dVar);
            this.$this_detectTapGestures = pointerInputScope;
            this.$onPress = qVar;
            this.$onLongPress = lVar;
            this.$onDoubleTap = lVar2;
            this.$onTap = lVar3;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C08522 c08522 = new C08522(this.$this_detectTapGestures, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, dVar);
            c08522.L$0 = obj;
            return c08522;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                o0 o0Var = (o0) this.L$0;
                PressGestureScopeImpl pressGestureScopeImpl = new PressGestureScopeImpl(this.$this_detectTapGestures);
                PointerInputScope pointerInputScope = this.$this_detectTapGestures;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(pressGestureScopeImpl, this.$onPress, o0Var, this.$onLongPress, this.$onDoubleTap, this.$onTap, null);
                this.label = 1;
                if (ForEachGestureKt.forEachGesture(pointerInputScope, anonymousClass1, this) == objE) {
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
            return ((C08522) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", l = {262, 277}, m = "waitForUpOrCancellation")
    static final class C08531 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08531(z8.d<? super C08531> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.waitForUpOrCancellation(null, this);
        }
    }

    @Nullable
    public static final Object awaitFirstDown(@NotNull AwaitPointerEventScope awaitPointerEventScope, boolean z10, @NotNull z8.d<? super PointerInputChange> dVar) {
        return awaitFirstDownOnPass(awaitPointerEventScope, PointerEventPass.Main, z10, dVar);
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z10, z8.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return awaitFirstDown(awaitPointerEventScope, z10, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0076 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004d -> B:18:0x0050). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object awaitFirstDownOnPass(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r9, @org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.PointerEventPass r10, boolean r11, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.input.pointer.PointerInputChange> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r12
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDownOnPass$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDownOnPass$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDownOnPass$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            boolean r9 = r0.Z$0
            java.lang.Object r10 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r10 = (androidx.compose.ui.input.pointer.PointerEventPass) r10
            java.lang.Object r11 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            v8.u.b(r12)
            r8 = r11
            r11 = r9
            r9 = r8
            goto L50
        L36:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3e:
            v8.u.b(r12)
        L41:
            r0.L$0 = r9
            r0.L$1 = r10
            r0.Z$0 = r11
            r0.label = r3
            java.lang.Object r12 = r9.awaitPointerEvent(r10, r0)
            if (r12 != r1) goto L50
            return r1
        L50:
            androidx.compose.ui.input.pointer.PointerEvent r12 = (androidx.compose.ui.input.pointer.PointerEvent) r12
            java.util.List r2 = r12.getChanges()
            int r4 = r2.size()
            r5 = 0
            r6 = r5
        L5c:
            if (r6 >= r4) goto L76
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r11 == 0) goto L6b
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDown(r7)
            goto L6f
        L6b:
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r7)
        L6f:
            if (r7 != 0) goto L73
            r2 = r5
            goto L77
        L73:
            int r6 = r6 + 1
            goto L5c
        L76:
            r2 = r3
        L77:
            if (r2 == 0) goto L41
            java.util.List r9 = r12.getChanges()
            java.lang.Object r9 = r9.get(r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDownOnPass(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.ui.input.pointer.PointerEventPass, boolean, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object awaitSecondDown(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, z8.d<? super PointerInputChange> dVar) {
        return awaitPointerEventScope.withTimeoutOrNull(awaitPointerEventScope.getViewConfiguration().getDoubleTapTimeoutMillis(), new AnonymousClass2(pointerInputChange, null), dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052 A[LOOP:0: B:19:0x0050->B:20:0x0052, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a A[EDGE_INSN: B:31:0x007a->B:27:0x007a BREAK  A[LOOP:1: B:22:0x0067->B:26:0x0077], SYNTHETIC] */
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
    public static final java.lang.Object consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, z8.d<? super v8.k0> r9) {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.C08501
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.C08501) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r8 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            v8.u.b(r9)
            goto L44
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            v8.u.b(r9)
        L38:
            r0.L$0 = r8
            r0.label = r3
            r9 = 0
            java.lang.Object r9 = androidx.compose.ui.input.pointer.b.t(r8, r9, r0, r3, r9)
            if (r9 != r1) goto L44
            return r1
        L44:
            androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
            java.util.List r2 = r9.getChanges()
            int r4 = r2.size()
            r5 = 0
            r6 = r5
        L50:
            if (r6 >= r4) goto L5e
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            r7.consume()
            int r6 = r6 + 1
            goto L50
        L5e:
            java.util.List r9 = r9.getChanges()
            int r2 = r9.size()
            r4 = r5
        L67:
            if (r4 >= r2) goto L7a
            java.lang.Object r6 = r9.get(r4)
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            boolean r6 = r6.getPressed()
            if (r6 == 0) goto L77
            r5 = r3
            goto L7a
        L77:
            int r4 = r4 + 1
            goto L67
        L7a:
            if (r5 != 0) goto L38
            v8.k0 r8 = v8.k0.f35197a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, z8.d):java.lang.Object");
    }

    @Nullable
    public static final Object detectTapAndPress(@NotNull PointerInputScope pointerInputScope, @NotNull q<? super PressGestureScope, ? super Offset, ? super z8.d<? super k0>, ? extends Object> qVar, @Nullable h9.l<? super Offset, k0> lVar, @NotNull z8.d<? super k0> dVar) {
        Object objForEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new C08512(new PressGestureScopeImpl(pointerInputScope), qVar, lVar, null), dVar);
        return objForEachGesture == a9.d.e() ? objForEachGesture : k0.f35197a;
    }

    public static /* synthetic */ Object detectTapAndPress$default(PointerInputScope pointerInputScope, q qVar, h9.l lVar, z8.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            qVar = NoPressGesture;
        }
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        return detectTapAndPress(pointerInputScope, qVar, lVar, dVar);
    }

    @Nullable
    public static final Object detectTapGestures(@NotNull PointerInputScope pointerInputScope, @Nullable h9.l<? super Offset, k0> lVar, @Nullable h9.l<? super Offset, k0> lVar2, @NotNull q<? super PressGestureScope, ? super Offset, ? super z8.d<? super k0>, ? extends Object> qVar, @Nullable h9.l<? super Offset, k0> lVar3, @NotNull z8.d<? super k0> dVar) {
        Object objF = p0.f(new C08522(pointerInputScope, qVar, lVar2, lVar, lVar3, null), dVar);
        return objF == a9.d.e() ? objF : k0.f35197a;
    }

    public static /* synthetic */ Object detectTapGestures$default(PointerInputScope pointerInputScope, h9.l lVar, h9.l lVar2, q qVar, h9.l lVar3, z8.d dVar, int i10, Object obj) {
        h9.l lVar4 = (i10 & 1) != 0 ? null : lVar;
        h9.l lVar5 = (i10 & 2) != 0 ? null : lVar2;
        if ((i10 & 4) != 0) {
            qVar = NoPressGesture;
        }
        return detectTapGestures(pointerInputScope, lVar4, lVar5, qVar, (i10 & 8) != 0 ? null : lVar3, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00df A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0071 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00bb -> B:48:0x00be). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object waitForUpOrCancellation(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r13, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.input.pointer.PointerInputChange> r14) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(androidx.compose.ui.input.pointer.AwaitPointerEventScope, z8.d):java.lang.Object");
    }
}
