package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import h9.p;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.s1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.i;
import s9.j;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: FoldingFeatureObserver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FoldingFeatureObserver {

    @NotNull
    private final Executor executor;

    @Nullable
    private b2 job;

    @Nullable
    private OnFoldingFeatureChangeListener onFoldingFeatureChangeListener;

    @NotNull
    private final WindowInfoTracker windowInfoTracker;

    /* JADX INFO: compiled from: FoldingFeatureObserver.kt */
    public interface OnFoldingFeatureChangeListener {
        void onFoldingFeatureChange(@NotNull FoldingFeature foldingFeature);
    }

    /* JADX INFO: renamed from: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1, reason: invalid class name */
    /* JADX INFO: compiled from: FoldingFeatureObserver.kt */
    @f(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1", f = "FoldingFeatureObserver.kt", l = {97}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Activity activity, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return FoldingFeatureObserver.this.new AnonymousClass1(this.$activity, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                final h<WindowLayoutInfo> hVarWindowLayoutInfo = FoldingFeatureObserver.this.windowInfoTracker.windowLayoutInfo(this.$activity);
                final FoldingFeatureObserver foldingFeatureObserver = FoldingFeatureObserver.this;
                h hVarP = j.p(new h<FoldingFeature>() { // from class: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1

                    /* JADX INFO: renamed from: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Collect.kt */
                    public static final class AnonymousClass2 implements i<WindowLayoutInfo> {
                        final /* synthetic */ i $this_unsafeFlow$inlined;
                        final /* synthetic */ FoldingFeatureObserver this$0;

                        /* JADX INFO: renamed from: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                        @f(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2", f = "FoldingFeatureObserver.kt", l = {138}, m = "emit")
                        public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(d dVar) {
                                super(dVar);
                            }

                            @Override // kotlin.coroutines.jvm.internal.a
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(i iVar, FoldingFeatureObserver foldingFeatureObserver) {
                            this.$this_unsafeFlow$inlined = iVar;
                            this.this$0 = foldingFeatureObserver;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // s9.i
                        @org.jetbrains.annotations.Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public java.lang.Object emit(androidx.window.layout.WindowLayoutInfo r5, @org.jetbrains.annotations.NotNull z8.d r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = (androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = new androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = a9.b.e()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                v8.u.b(r6)
                                goto L4a
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                v8.u.b(r6)
                                s9.i r6 = r4.$this_unsafeFlow$inlined
                                androidx.window.layout.WindowLayoutInfo r5 = (androidx.window.layout.WindowLayoutInfo) r5
                                androidx.slidingpanelayout.widget.FoldingFeatureObserver r2 = r4.this$0
                                androidx.window.layout.FoldingFeature r5 = androidx.slidingpanelayout.widget.FoldingFeatureObserver.access$getFoldingFeature(r2, r5)
                                if (r5 != 0) goto L41
                                goto L4a
                            L41:
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L4a
                                return r1
                            L4a:
                                v8.k0 r5 = v8.k0.f35197a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                        }
                    }

                    @Override // s9.h
                    @Nullable
                    public Object collect(@NotNull i<? super FoldingFeature> iVar, @NotNull d dVar) {
                        Object objCollect = hVarWindowLayoutInfo.collect(new AnonymousClass2(iVar, foldingFeatureObserver), dVar);
                        return objCollect == a9.d.e() ? objCollect : k0.f35197a;
                    }
                });
                final FoldingFeatureObserver foldingFeatureObserver2 = FoldingFeatureObserver.this;
                i<FoldingFeature> iVar = new i<FoldingFeature>() { // from class: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1
                    @Override // s9.i
                    @Nullable
                    public Object emit(FoldingFeature foldingFeature, @NotNull d<? super k0> dVar) {
                        k0 k0Var;
                        FoldingFeature foldingFeature2 = foldingFeature;
                        FoldingFeatureObserver.OnFoldingFeatureChangeListener onFoldingFeatureChangeListener = foldingFeatureObserver2.onFoldingFeatureChangeListener;
                        if (onFoldingFeatureChangeListener == null) {
                            k0Var = null;
                        } else {
                            onFoldingFeatureChangeListener.onFoldingFeatureChange(foldingFeature2);
                            k0Var = k0.f35197a;
                        }
                        return k0Var == a9.d.e() ? k0Var : k0.f35197a;
                    }
                };
                this.label = 1;
                if (hVarP.collect(iVar, this) == objE) {
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

    public FoldingFeatureObserver(@NotNull WindowInfoTracker windowInfoTracker, @NotNull Executor executor) {
        t.i(windowInfoTracker, "windowInfoTracker");
        t.i(executor, "executor");
        this.windowInfoTracker = windowInfoTracker;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FoldingFeature getFoldingFeature(WindowLayoutInfo windowLayoutInfo) {
        Object next;
        Iterator<T> it = windowLayoutInfo.getDisplayFeatures().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((DisplayFeature) next) instanceof FoldingFeature) {
                break;
            }
        }
        if (next instanceof FoldingFeature) {
            return (FoldingFeature) next;
        }
        return null;
    }

    public final void registerLayoutStateChangeCallback(@NotNull Activity activity) {
        t.i(activity, "activity");
        b2 b2Var = this.job;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.job = k.d(p0.a(s1.b(this.executor)), null, null, new AnonymousClass1(activity, null), 3, null);
    }

    public final void setOnFoldingFeatureChangeListener(@NotNull OnFoldingFeatureChangeListener onFoldingFeatureChangeListener) {
        t.i(onFoldingFeatureChangeListener, "onFoldingFeatureChangeListener");
        this.onFoldingFeatureChangeListener = onFoldingFeatureChangeListener;
    }

    public final void unregisterLayoutStateChangeCallback() {
        b2 b2Var = this.job;
        if (b2Var == null) {
            return;
        }
        b2.a.a(b2Var, null, 1, null);
    }
}
