package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.k;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: PointerInteropFilter.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PointerInteropFilter_androidKt {

    /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1, reason: invalid class name */
    /* JADX INFO: compiled from: PointerInteropFilter.android.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1", f = "PointerInteropFilter.android.kt", l = {343}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<PointerInputScope, z8.d<? super k0>, Object> {
        final /* synthetic */ h9.l<MotionEvent, k0> $watcher;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PointerInteropFilter.android.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1$1", f = "PointerInteropFilter.android.kt", l = {345}, m = "invokeSuspend")
        static final class C01221 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
            final /* synthetic */ h9.l<MotionEvent, k0> $watcher;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01221(h9.l<? super MotionEvent, k0> lVar, z8.d<? super C01221> dVar) {
                super(2, dVar);
                this.$watcher = lVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                C01221 c01221 = new C01221(this.$watcher, dVar);
                c01221.L$0 = obj;
                return c01221;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                return ((C01221) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0033 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0034 -> B:13:0x0039). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = a9.b.e()
                    int r1 = r6.label
                    r2 = 1
                    if (r1 == 0) goto L1e
                    if (r1 != r2) goto L16
                    java.lang.Object r1 = r6.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                    v8.u.b(r7)
                    r3 = r1
                    r1 = r0
                    r0 = r6
                    goto L39
                L16:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L1e:
                    v8.u.b(r7)
                    java.lang.Object r7 = r6.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
                    r1 = r7
                    r7 = r6
                L27:
                    androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                    r7.L$0 = r1
                    r7.label = r2
                    java.lang.Object r3 = r1.awaitPointerEvent(r3, r7)
                    if (r3 != r0) goto L34
                    return r0
                L34:
                    r5 = r0
                    r0 = r7
                    r7 = r3
                    r3 = r1
                    r1 = r5
                L39:
                    androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
                    android.view.MotionEvent r7 = r7.getMotionEvent$ui_release()
                    if (r7 == 0) goto L46
                    h9.l<android.view.MotionEvent, v8.k0> r4 = r0.$watcher
                    r4.invoke(r7)
                L46:
                    r7 = r0
                    r0 = r1
                    r1 = r3
                    goto L27
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt.AnonymousClass1.C01221.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(h9.l<? super MotionEvent, k0> lVar, z8.d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$watcher = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$watcher, dVar);
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
                pointerInputScope.setInterceptOutOfBoundsChildEvents(true);
                C01221 c01221 = new C01221(this.$watcher, null);
                this.label = 1;
                if (pointerInputScope.awaitPointerEventScope(c01221, this) == objE) {
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

    /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$pointerInteropFilter$2, reason: invalid class name */
    /* JADX INFO: compiled from: PointerInteropFilter.android.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ h9.l<MotionEvent, Boolean> $onTouchEvent;
        final /* synthetic */ RequestDisallowInterceptTouchEvent $requestDisallowInterceptTouchEvent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(h9.l<? super MotionEvent, Boolean> lVar, RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent) {
            super(3);
            this.$onTouchEvent = lVar;
            this.$requestDisallowInterceptTouchEvent = requestDisallowInterceptTouchEvent;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(374375707);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new PointerInteropFilter();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            PointerInteropFilter pointerInteropFilter = (PointerInteropFilter) objRememberedValue;
            pointerInteropFilter.setOnTouchEvent(this.$onTouchEvent);
            pointerInteropFilter.setRequestDisallowInterceptTouchEvent(this.$requestDisallowInterceptTouchEvent);
            composer.endReplaceableGroup();
            return pointerInteropFilter;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$pointerInteropFilter$3, reason: invalid class name */
    /* JADX INFO: compiled from: PointerInteropFilter.android.kt */
    static final class AnonymousClass3 extends v implements h9.l<MotionEvent, Boolean> {
        final /* synthetic */ AndroidViewHolder $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AndroidViewHolder androidViewHolder) {
            super(1);
            this.$view = androidViewHolder;
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull MotionEvent motionEvent) {
            boolean zDispatchTouchEvent;
            t.i(motionEvent, "motionEvent");
            switch (motionEvent.getActionMasked()) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    zDispatchTouchEvent = this.$view.dispatchTouchEvent(motionEvent);
                    break;
                default:
                    zDispatchTouchEvent = this.$view.dispatchGenericMotionEvent(motionEvent);
                    break;
            }
            return Boolean.valueOf(zDispatchTouchEvent);
        }
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier motionEventSpy(@NotNull Modifier modifier, @NotNull h9.l<? super MotionEvent, k0> watcher) {
        t.i(modifier, "<this>");
        t.i(watcher, "watcher");
        return SuspendingPointerInputFilterKt.pointerInput(modifier, watcher, new AnonymousClass1(watcher, null));
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier pointerInteropFilter(@NotNull Modifier modifier, @NotNull AndroidViewHolder view) {
        t.i(modifier, "<this>");
        t.i(view, "view");
        PointerInteropFilter pointerInteropFilter = new PointerInteropFilter();
        pointerInteropFilter.setOnTouchEvent(new AnonymousClass3(view));
        RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent = new RequestDisallowInterceptTouchEvent();
        pointerInteropFilter.setRequestDisallowInterceptTouchEvent(requestDisallowInterceptTouchEvent);
        view.setOnRequestDisallowInterceptTouchEvent$ui_release(requestDisallowInterceptTouchEvent);
        return modifier.then(pointerInteropFilter);
    }

    public static /* synthetic */ Modifier pointerInteropFilter$default(Modifier modifier, RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent, h9.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            requestDisallowInterceptTouchEvent = null;
        }
        return pointerInteropFilter(modifier, requestDisallowInterceptTouchEvent, lVar);
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier pointerInteropFilter(@NotNull Modifier modifier, @Nullable RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent, @NotNull h9.l<? super MotionEvent, Boolean> onTouchEvent) {
        t.i(modifier, "<this>");
        t.i(onTouchEvent, "onTouchEvent");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PointerInteropFilter_androidKt$pointerInteropFilter$$inlined$debugInspectorInfo$1(requestDisallowInterceptTouchEvent, onTouchEvent) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(onTouchEvent, requestDisallowInterceptTouchEvent));
    }
}
