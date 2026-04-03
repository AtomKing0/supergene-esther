package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import h9.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p;
import kotlinx.coroutines.t1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import z8.g;
import z8.h;

/* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SuspendingPointerInputFilter extends PointerInputFilter implements PointerInputModifier, PointerInputScope, Density {
    private final /* synthetic */ Density $$delegate_0;
    private long boundsSize;

    @NotNull
    private o0 coroutineScope;

    @NotNull
    private PointerEvent currentEvent;

    @NotNull
    private final MutableVector<PointerEventHandlerCoroutine<?>> dispatchingPointerHandlers;
    private boolean interceptOutOfBoundsChildEvents;

    @Nullable
    private PointerEvent lastPointerEvent;

    @NotNull
    private final MutableVector<PointerEventHandlerCoroutine<?>> pointerHandlers;

    @NotNull
    private final ViewConfiguration viewConfiguration;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
    final class PointerEventHandlerCoroutine<R> implements AwaitPointerEventScope, Density, z8.d<R> {
        private final /* synthetic */ SuspendingPointerInputFilter $$delegate_0;

        @NotNull
        private PointerEventPass awaitPass;

        @NotNull
        private final z8.d<R> completion;

        @NotNull
        private final g context;

        @Nullable
        private o<? super PointerEvent> pointerAwaiter;
        final /* synthetic */ SuspendingPointerInputFilter this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public PointerEventHandlerCoroutine(@NotNull SuspendingPointerInputFilter suspendingPointerInputFilter, z8.d<? super R> completion) {
            t.i(completion, "completion");
            this.this$0 = suspendingPointerInputFilter;
            this.completion = completion;
            this.$$delegate_0 = suspendingPointerInputFilter;
            this.awaitPass = PointerEventPass.Main;
            this.context = h.f37608a;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        @Nullable
        public Object awaitPointerEvent(@NotNull PointerEventPass pointerEventPass, @NotNull z8.d<? super PointerEvent> dVar) throws Throwable {
            p pVar = new p(a9.c.c(dVar), 1);
            pVar.C();
            this.awaitPass = pointerEventPass;
            this.pointerAwaiter = pVar;
            Object objZ = pVar.z();
            if (objZ == a9.d.e()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return objZ;
        }

        public final void cancel(@Nullable Throwable th) {
            o<? super PointerEvent> oVar = this.pointerAwaiter;
            if (oVar != null) {
                oVar.b(th);
            }
            this.pointerAwaiter = null;
        }

        @Override // z8.d
        @NotNull
        public g getContext() {
            return this.context;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        @NotNull
        public PointerEvent getCurrentEvent() {
            return this.this$0.currentEvent;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc */
        public long mo2790getExtendedTouchPaddingNHjbRc() {
            return this.this$0.mo2895getExtendedTouchPaddingNHjbRc();
        }

        @Override // androidx.compose.ui.unit.Density
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /* JADX INFO: renamed from: getSize-YbymL2g */
        public long mo2791getSizeYbymL2g() {
            return this.this$0.boundsSize;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        @NotNull
        public ViewConfiguration getViewConfiguration() {
            return this.this$0.getViewConfiguration();
        }

        public final void offerPointerEvent(@NotNull PointerEvent event, @NotNull PointerEventPass pass) {
            o<? super PointerEvent> oVar;
            t.i(event, "event");
            t.i(pass, "pass");
            if (pass != this.awaitPass || (oVar = this.pointerAwaiter) == null) {
                return;
            }
            this.pointerAwaiter = null;
            oVar.resumeWith(v8.t.b(event));
        }

        @Override // z8.d
        public void resumeWith(@NotNull Object obj) {
            MutableVector mutableVector = this.this$0.pointerHandlers;
            SuspendingPointerInputFilter suspendingPointerInputFilter = this.this$0;
            synchronized (mutableVector) {
                suspendingPointerInputFilter.pointerHandlers.remove(this);
                k0 k0Var = k0.f35197a;
            }
            this.completion.resumeWith(obj);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: roundToPx--R2X_6o */
        public int mo289roundToPxR2X_6o(long j10) {
            return this.$$delegate_0.mo289roundToPxR2X_6o(j10);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: roundToPx-0680j_4 */
        public int mo290roundToPx0680j_4(float f10) {
            return this.$$delegate_0.mo290roundToPx0680j_4(f10);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toDp-GaN1DYA */
        public float mo291toDpGaN1DYA(long j10) {
            return this.$$delegate_0.mo291toDpGaN1DYA(j10);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public float mo292toDpu2uoSUM(float f10) {
            return this.$$delegate_0.mo292toDpu2uoSUM(f10);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toDpSize-k-rfVVM */
        public long mo294toDpSizekrfVVM(long j10) {
            return this.$$delegate_0.mo294toDpSizekrfVVM(j10);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toPx--R2X_6o */
        public float mo295toPxR2X_6o(long j10) {
            return this.$$delegate_0.mo295toPxR2X_6o(j10);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toPx-0680j_4 */
        public float mo296toPx0680j_4(float f10) {
            return this.$$delegate_0.mo296toPx0680j_4(f10);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        @NotNull
        public Rect toRect(@NotNull DpRect dpRect) {
            t.i(dpRect, "<this>");
            return this.$$delegate_0.toRect(dpRect);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toSize-XkaWNTQ */
        public long mo297toSizeXkaWNTQ(long j10) {
            return this.$$delegate_0.mo297toSizeXkaWNTQ(j10);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toSp-0xMU5do */
        public long mo298toSp0xMU5do(float f10) {
            return this.$$delegate_0.mo298toSp0xMU5do(f10);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public long mo299toSpkPz2Gy4(float f10) {
            return this.$$delegate_0.mo299toSpkPz2Gy4(f10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r12v0, types: [long] */
        /* JADX WARN: Type inference failed for: r12v1, types: [kotlinx.coroutines.b2] */
        /* JADX WARN: Type inference failed for: r12v3, types: [kotlinx.coroutines.b2] */
        /* JADX WARN: Type inference failed for: r12v7 */
        /* JADX WARN: Type inference failed for: r12v8 */
        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public <T> java.lang.Object withTimeout(long r12, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super z8.d<? super T>, ? extends java.lang.Object> r14, @org.jetbrains.annotations.NotNull z8.d<? super T> r15) {
            /*
                r11 = this;
                boolean r0 = r15 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1
                if (r0 == 0) goto L13
                r0 = r15
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1
                r0.<init>(r11, r15)
            L18:
                java.lang.Object r15 = r0.result
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.label
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L38
                if (r2 != r3) goto L30
                java.lang.Object r12 = r0.L$0
                kotlinx.coroutines.b2 r12 = (kotlinx.coroutines.b2) r12
                v8.u.b(r15)     // Catch: java.lang.Throwable -> L2e
                goto L75
            L2e:
                r13 = move-exception
                goto L79
            L30:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L38:
                v8.u.b(r15)
                r5 = 0
                int r15 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
                if (r15 > 0) goto L57
                kotlinx.coroutines.o<? super androidx.compose.ui.input.pointer.PointerEvent> r15 = r11.pointerAwaiter
                if (r15 == 0) goto L57
                v8.t$a r2 = v8.t.f35208b
                androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException r2 = new androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
                r2.<init>(r12)
                java.lang.Object r2 = v8.u.a(r2)
                java.lang.Object r2 = v8.t.b(r2)
                r15.resumeWith(r2)
            L57:
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter r15 = r11.this$0
                kotlinx.coroutines.o0 r5 = r15.getCoroutineScope()
                r6 = 0
                r7 = 0
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1 r8 = new androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1
                r8.<init>(r12, r11, r4)
                r9 = 3
                r10 = 0
                kotlinx.coroutines.b2 r12 = kotlinx.coroutines.i.d(r5, r6, r7, r8, r9, r10)
                r0.L$0 = r12     // Catch: java.lang.Throwable -> L2e
                r0.label = r3     // Catch: java.lang.Throwable -> L2e
                java.lang.Object r15 = r14.mo4invoke(r11, r0)     // Catch: java.lang.Throwable -> L2e
                if (r15 != r1) goto L75
                return r1
            L75:
                kotlinx.coroutines.b2.a.a(r12, r4, r3, r4)
                return r15
            L79:
                kotlinx.coroutines.b2.a.a(r12, r4, r3, r4)
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputFilter.PointerEventHandlerCoroutine.withTimeout(long, h9.p, z8.d):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public <T> java.lang.Object withTimeoutOrNull(long r5, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super z8.d<? super T>, ? extends java.lang.Object> r7, @org.jetbrains.annotations.NotNull z8.d<? super T> r8) {
            /*
                r4 = this;
                boolean r0 = r8 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                if (r0 == 0) goto L13
                r0 = r8
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                r0.<init>(r4, r8)
            L18:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                v8.u.b(r8)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3d
                goto L3e
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                v8.u.b(r8)
                r0.label = r3     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3d
                java.lang.Object r8 = r4.withTimeout(r5, r7, r0)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3d
                if (r8 != r1) goto L3e
                return r1
            L3d:
                r8 = 0
            L3e:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputFilter.PointerEventHandlerCoroutine.withTimeoutOrNull(long, h9.p, z8.d):java.lang.Object");
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public float mo293toDpu2uoSUM(int i10) {
            return this.$$delegate_0.mo293toDpu2uoSUM(i10);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public long mo300toSpkPz2Gy4(int i10) {
            return this.$$delegate_0.mo300toSpkPz2Gy4(i10);
        }
    }

    /* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEventPass.values().length];
            iArr[PointerEventPass.Initial.ordinal()] = 1;
            iArr[PointerEventPass.Final.ordinal()] = 2;
            iArr[PointerEventPass.Main.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ SuspendingPointerInputFilter(ViewConfiguration viewConfiguration, Density density, int i10, k kVar) {
        this(viewConfiguration, (i10 & 2) != 0 ? DensityKt.Density$default(1.0f, 0.0f, 2, null) : density);
    }

    private final void dispatchPointerEvent(PointerEvent pointerEvent, PointerEventPass pointerEventPass) {
        MutableVector<PointerEventHandlerCoroutine<?>> mutableVector;
        int size;
        synchronized (this.pointerHandlers) {
            MutableVector<PointerEventHandlerCoroutine<?>> mutableVector2 = this.dispatchingPointerHandlers;
            mutableVector2.addAll(mutableVector2.getSize(), this.pointerHandlers);
        }
        try {
            int i10 = WhenMappings.$EnumSwitchMapping$0[pointerEventPass.ordinal()];
            if (i10 == 1 || i10 == 2) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector3 = this.dispatchingPointerHandlers;
                int size2 = mutableVector3.getSize();
                if (size2 > 0) {
                    PointerEventHandlerCoroutine<?>[] content = mutableVector3.getContent();
                    int i11 = 0;
                    do {
                        content[i11].offerPointerEvent(pointerEvent, pointerEventPass);
                        i11++;
                    } while (i11 < size2);
                }
            } else if (i10 == 3 && (size = (mutableVector = this.dispatchingPointerHandlers).getSize()) > 0) {
                int i12 = size - 1;
                PointerEventHandlerCoroutine<?>[] content2 = mutableVector.getContent();
                do {
                    content2[i12].offerPointerEvent(pointerEvent, pointerEventPass);
                    i12--;
                } while (i12 >= 0);
            }
        } finally {
            this.dispatchingPointerHandlers.clear();
        }
    }

    private final void forEachCurrentPointerHandler(PointerEventPass pointerEventPass, l<? super PointerEventHandlerCoroutine<?>, k0> lVar) {
        MutableVector<PointerEventHandlerCoroutine<?>> mutableVector;
        int size;
        synchronized (this.pointerHandlers) {
            try {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector2 = this.dispatchingPointerHandlers;
                mutableVector2.addAll(mutableVector2.getSize(), this.pointerHandlers);
                r.b(1);
            } catch (Throwable th) {
                r.b(1);
                r.a(1);
                throw th;
            }
        }
        r.a(1);
        try {
            int i10 = WhenMappings.$EnumSwitchMapping$0[pointerEventPass.ordinal()];
            if (i10 == 1 || i10 == 2) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector3 = this.dispatchingPointerHandlers;
                int size2 = mutableVector3.getSize();
                if (size2 > 0) {
                    PointerEventHandlerCoroutine<?>[] content = mutableVector3.getContent();
                    int i11 = 0;
                    do {
                        lVar.invoke(content[i11]);
                        i11++;
                    } while (i11 < size2);
                }
            } else if (i10 == 3 && (size = (mutableVector = this.dispatchingPointerHandlers).getSize()) > 0) {
                int i12 = size - 1;
                PointerEventHandlerCoroutine<?>[] content2 = mutableVector.getContent();
                do {
                    lVar.invoke(content2[i12]);
                    i12--;
                } while (i12 >= 0);
            }
        } finally {
            r.b(1);
            this.dispatchingPointerHandlers.clear();
            r.a(1);
        }
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    @Nullable
    public <R> Object awaitPointerEventScope(@NotNull h9.p<? super AwaitPointerEventScope, ? super z8.d<? super R>, ? extends Object> pVar, @NotNull z8.d<? super R> dVar) throws Throwable {
        p pVar2 = new p(a9.c.c(dVar), 1);
        pVar2.C();
        PointerEventHandlerCoroutine pointerEventHandlerCoroutine = new PointerEventHandlerCoroutine(this, pVar2);
        synchronized (this.pointerHandlers) {
            this.pointerHandlers.add(pointerEventHandlerCoroutine);
            z8.d<k0> dVarA = z8.f.a(pVar, pointerEventHandlerCoroutine, pointerEventHandlerCoroutine);
            t.a aVar = v8.t.f35208b;
            dVarA.resumeWith(v8.t.b(k0.f35197a));
        }
        pVar2.m(new SuspendingPointerInputFilter$awaitPointerEventScope$2$2(pointerEventHandlerCoroutine));
        Object objZ = pVar2.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, h9.p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, h9.p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @NotNull
    public final o0 getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc */
    public long mo2895getExtendedTouchPaddingNHjbRc() {
        long jMo297toSizeXkaWNTQ = mo297toSizeXkaWNTQ(getViewConfiguration().mo3104getMinimumTouchTargetSizeMYxV2XQ());
        long jM2893getSizeYbymL2g = m2893getSizeYbymL2g();
        return SizeKt.Size(Math.max(0.0f, Size.m1436getWidthimpl(jMo297toSizeXkaWNTQ) - IntSize.m3833getWidthimpl(jM2893getSizeYbymL2g)) / 2.0f, Math.max(0.0f, Size.m1433getHeightimpl(jMo297toSizeXkaWNTQ) - IntSize.m3832getHeightimpl(jM2893getSizeYbymL2g)) / 2.0f);
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter, androidx.compose.ui.input.pointer.PointerInputScope
    public boolean getInterceptOutOfBoundsChildEvents() {
        return this.interceptOutOfBoundsChildEvents;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    @NotNull
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public void onCancel() {
        boolean z10;
        PointerEvent pointerEvent = this.lastPointerEvent;
        if (pointerEvent == null) {
            return;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i10 = 0;
        while (true) {
            z10 = true;
            if (i10 >= size) {
                break;
            }
            if (!(true ^ changes.get(i10).getPressed())) {
                z10 = false;
                break;
            }
            i10++;
        }
        if (z10) {
            return;
        }
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        ArrayList arrayList = new ArrayList(changes2.size());
        int size2 = changes2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            PointerInputChange pointerInputChange = changes2.get(i11);
            arrayList.add(new PointerInputChange(pointerInputChange.m2872getIdJ3iCeTQ(), pointerInputChange.getUptimeMillis(), pointerInputChange.m2873getPositionF1C5BW0(), false, pointerInputChange.getUptimeMillis(), pointerInputChange.m2873getPositionF1C5BW0(), pointerInputChange.getPressed(), pointerInputChange.getPressed(), 0, 0L, 768, (k) null));
        }
        PointerEvent pointerEvent2 = new PointerEvent(arrayList);
        this.currentEvent = pointerEvent2;
        dispatchPointerEvent(pointerEvent2, PointerEventPass.Initial);
        dispatchPointerEvent(pointerEvent2, PointerEventPass.Main);
        dispatchPointerEvent(pointerEvent2, PointerEventPass.Final);
        this.lastPointerEvent = null;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo2894onPointerEventH0pRuoY(@NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pass, long j10) {
        kotlin.jvm.internal.t.i(pointerEvent, "pointerEvent");
        kotlin.jvm.internal.t.i(pass, "pass");
        this.boundsSize = j10;
        if (pass == PointerEventPass.Initial) {
            this.currentEvent = pointerEvent;
        }
        dispatchPointerEvent(pointerEvent, pass);
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                z10 = true;
                break;
            } else if (!PointerEventKt.changedToUpIgnoreConsumed(changes.get(i10))) {
                break;
            } else {
                i10++;
            }
        }
        if (!(!z10)) {
            pointerEvent = null;
        }
        this.lastPointerEvent = pointerEvent;
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public int mo289roundToPxR2X_6o(long j10) {
        return this.$$delegate_0.mo289roundToPxR2X_6o(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public int mo290roundToPx0680j_4(float f10) {
        return this.$$delegate_0.mo290roundToPx0680j_4(f10);
    }

    public final void setCoroutineScope(@NotNull o0 o0Var) {
        kotlin.jvm.internal.t.i(o0Var, "<set-?>");
        this.coroutineScope = o0Var;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public void setInterceptOutOfBoundsChildEvents(boolean z10) {
        this.interceptOutOfBoundsChildEvents = z10;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public float mo291toDpGaN1DYA(long j10) {
        return this.$$delegate_0.mo291toDpGaN1DYA(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo292toDpu2uoSUM(float f10) {
        return this.$$delegate_0.mo292toDpu2uoSUM(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public long mo294toDpSizekrfVVM(long j10) {
        return this.$$delegate_0.mo294toDpSizekrfVVM(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public float mo295toPxR2X_6o(long j10) {
        return this.$$delegate_0.mo295toPxR2X_6o(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public float mo296toPx0680j_4(float f10) {
        return this.$$delegate_0.mo296toPx0680j_4(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    @NotNull
    public Rect toRect(@NotNull DpRect dpRect) {
        kotlin.jvm.internal.t.i(dpRect, "<this>");
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public long mo297toSizeXkaWNTQ(long j10) {
        return this.$$delegate_0.mo297toSizeXkaWNTQ(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public long mo298toSp0xMU5do(float f10) {
        return this.$$delegate_0.mo298toSp0xMU5do(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo299toSpkPz2Gy4(float f10) {
        return this.$$delegate_0.mo299toSpkPz2Gy4(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo293toDpu2uoSUM(int i10) {
        return this.$$delegate_0.mo293toDpu2uoSUM(i10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo300toSpkPz2Gy4(int i10) {
        return this.$$delegate_0.mo300toSpkPz2Gy4(i10);
    }

    public SuspendingPointerInputFilter(@NotNull ViewConfiguration viewConfiguration, @NotNull Density density) {
        kotlin.jvm.internal.t.i(viewConfiguration, "viewConfiguration");
        kotlin.jvm.internal.t.i(density, "density");
        this.viewConfiguration = viewConfiguration;
        this.$$delegate_0 = density;
        this.currentEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
        this.pointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.dispatchingPointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.boundsSize = IntSize.Companion.m3838getZeroYbymL2g();
        this.coroutineScope = t1.f29982a;
    }

    public static /* synthetic */ void getCoroutineScope$annotations() {
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputModifier
    @NotNull
    public PointerInputFilter getPointerInputFilter() {
        return this;
    }
}
