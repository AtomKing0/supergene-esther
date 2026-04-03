package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.view.View;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class w implements t {

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerImpl$isVisibleFlow$1", f = "ViewVisibilityTracker.kt", l = {36}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<r9.r<? super Boolean>, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21515j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f21516k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ View f21517l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f21517l = view;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = new a(this.f21517l, dVar);
            aVar.f21516k = obj;
            return aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull r9.r<? super Boolean> rVar, @Nullable z8.d<? super v8.k0> dVar) {
            return ((a) create(rVar, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f21515j;
            if (i10 == 0) {
                v8.u.b(obj);
                r9.r rVar = (r9.r) this.f21516k;
                View view = this.f21517l;
                this.f21515j = 1;
                if (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.a.i(rVar, view, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return v8.k0.f35197a;
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t
    @NotNull
    public s9.h<Boolean> a(@NotNull View view) {
        kotlin.jvm.internal.t.i(view, "view");
        return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.a.g(s9.j.j(new a(view, null)));
    }
}
