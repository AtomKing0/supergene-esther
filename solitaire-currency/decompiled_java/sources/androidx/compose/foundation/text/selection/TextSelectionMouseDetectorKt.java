package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import h9.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.k;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: TextSelectionMouseDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextSelectionMouseDetectorKt {
    public static final double ClicksSlop = 100.0d;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$awaitMouseEventDown$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextSelectionMouseDetector.kt */
    @f(c = "androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt", f = "TextSelectionMouseDetector.kt", l = {127}, m = "awaitMouseEventDown")
    static final class AnonymousClass1 extends d {
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
            return TextSelectionMouseDetectorKt.awaitMouseEventDown(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2, reason: invalid class name */
    /* JADX INFO: compiled from: TextSelectionMouseDetector.kt */
    @f(c = "androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2", f = "TextSelectionMouseDetector.kt", l = {87}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<PointerInputScope, z8.d<? super k0>, Object> {
        final /* synthetic */ MouseSelectionObserver $observer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TextSelectionMouseDetector.kt */
        @f(c = "androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1", f = "TextSelectionMouseDetector.kt", l = {90, 97, 112}, m = "invokeSuspend")
        static final class AnonymousClass1 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
            final /* synthetic */ MouseSelectionObserver $observer;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TextSelectionMouseDetector.kt */
            static final class C00831 extends v implements h9.l<PointerInputChange, k0> {
                final /* synthetic */ MouseSelectionObserver $observer;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00831(MouseSelectionObserver mouseSelectionObserver) {
                    super(1);
                    this.$observer = mouseSelectionObserver;
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(PointerInputChange pointerInputChange) {
                    invoke2(pointerInputChange);
                    return k0.f35197a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PointerInputChange it) {
                    t.i(it, "it");
                    if (this.$observer.mo714onExtendDragk4lQ0M(it.m2873getPositionF1C5BW0())) {
                        it.consume();
                    }
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TextSelectionMouseDetector.kt */
            static final class C00842 extends v implements h9.l<PointerInputChange, k0> {
                final /* synthetic */ MouseSelectionObserver $observer;
                final /* synthetic */ SelectionAdjustment $selectionMode;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00842(MouseSelectionObserver mouseSelectionObserver, SelectionAdjustment selectionAdjustment) {
                    super(1);
                    this.$observer = mouseSelectionObserver;
                    this.$selectionMode = selectionAdjustment;
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(PointerInputChange pointerInputChange) {
                    invoke2(pointerInputChange);
                    return k0.f35197a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PointerInputChange it) {
                    t.i(it, "it");
                    if (this.$observer.mo712onDrag3MmeM6k(it.m2873getPositionF1C5BW0(), this.$selectionMode)) {
                        it.consume();
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MouseSelectionObserver mouseSelectionObserver, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$observer = mouseSelectionObserver;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$observer, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0093  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00d6 -> B:14:0x0045). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
                /*
                    Method dump skipped, instruction units count: 218
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MouseSelectionObserver mouseSelectionObserver, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$observer = mouseSelectionObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$observer, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:18:0x0045). Please report as a decompilation issue!!! */
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
    public static final java.lang.Object awaitMouseEventDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r10, z8.d<? super androidx.compose.ui.input.pointer.PointerEvent> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$awaitMouseEventDown$1 r0 = (androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$awaitMouseEventDown$1 r0 = new androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$awaitMouseEventDown$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r10 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            v8.u.b(r11)
            goto L45
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            v8.u.b(r11)
        L38:
            androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r11 = r10.awaitPointerEvent(r11, r0)
            if (r11 != r1) goto L45
            return r1
        L45:
            androidx.compose.ui.input.pointer.PointerEvent r11 = (androidx.compose.ui.input.pointer.PointerEvent) r11
            int r2 = r11.m2818getButtonsry648PA()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEvent_androidKt.m2851isPrimaryPressedaHzCxE(r2)
            if (r2 == 0) goto L38
            java.util.List r2 = r11.getChanges()
            int r4 = r2.size()
            r5 = 0
            r6 = r5
        L5b:
            if (r6 >= r4) goto L82
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            int r8 = r7.m2876getTypeT8wyACA()
            androidx.compose.ui.input.pointer.PointerType$Companion r9 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r9 = r9.m2936getMouseT8wyACA()
            boolean r8 = androidx.compose.ui.input.pointer.PointerType.m2931equalsimpl0(r8, r9)
            if (r8 == 0) goto L7b
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDown(r7)
            if (r7 == 0) goto L7b
            r7 = r3
            goto L7c
        L7b:
            r7 = r5
        L7c:
            if (r7 != 0) goto L7f
            goto L83
        L7f:
            int r6 = r6 + 1
            goto L5b
        L82:
            r5 = r3
        L83:
            if (r5 == 0) goto L38
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt.awaitMouseEventDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, z8.d):java.lang.Object");
    }

    @Nullable
    public static final Object mouseSelectionDetector(@NotNull PointerInputScope pointerInputScope, @NotNull MouseSelectionObserver mouseSelectionObserver, @NotNull z8.d<? super k0> dVar) {
        Object objForEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new AnonymousClass2(mouseSelectionObserver, null), dVar);
        return objForEachGesture == a9.d.e() ? objForEachGesture : k0.f35197a;
    }
}
