package com.ironsource;

import android.adservices.measurement.MeasurementManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.ironsource.n3;
import com.ironsource.qf;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.v8;
import java.util.concurrent.Executors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class l3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f12954a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f12955b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f12956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final qf.e f12957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final String f12958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final JSONObject f12959d;

        public a(@NotNull String name, @NotNull qf.e productType, @NotNull String demandSourceName, @NotNull JSONObject params) {
            kotlin.jvm.internal.t.i(name, "name");
            kotlin.jvm.internal.t.i(productType, "productType");
            kotlin.jvm.internal.t.i(demandSourceName, "demandSourceName");
            kotlin.jvm.internal.t.i(params, "params");
            this.f12956a = name;
            this.f12957b = productType;
            this.f12958c = demandSourceName;
            this.f12959d = params;
        }

        public static /* synthetic */ a a(a aVar, String str, qf.e eVar, String str2, JSONObject jSONObject, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = aVar.f12956a;
            }
            if ((i10 & 2) != 0) {
                eVar = aVar.f12957b;
            }
            if ((i10 & 4) != 0) {
                str2 = aVar.f12958c;
            }
            if ((i10 & 8) != 0) {
                jSONObject = aVar.f12959d;
            }
            return aVar.a(str, eVar, str2, jSONObject);
        }

        @NotNull
        public final qf.e b() {
            return this.f12957b;
        }

        @NotNull
        public final String c() {
            return this.f12958c;
        }

        @NotNull
        public final JSONObject d() {
            return this.f12959d;
        }

        @NotNull
        public final String e() {
            return this.f12958c;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.t.d(this.f12956a, aVar.f12956a) && this.f12957b == aVar.f12957b && kotlin.jvm.internal.t.d(this.f12958c, aVar.f12958c) && kotlin.jvm.internal.t.d(this.f12959d.toString(), aVar.f12959d.toString());
        }

        @NotNull
        public final String f() {
            return this.f12956a;
        }

        @NotNull
        public final JSONObject g() {
            return this.f12959d;
        }

        @NotNull
        public final qf.e h() {
            return this.f12957b;
        }

        public int hashCode() {
            return super.hashCode();
        }

        @NotNull
        public final JSONObject i() throws JSONException {
            JSONObject jSONObjectPut = new JSONObject(this.f12959d.toString()).put(v8.h.f15803m, this.f12957b).put("demandSourceName", this.f12958c);
            kotlin.jvm.internal.t.h(jSONObjectPut, "JSONObject(params.toStri…eName\", demandSourceName)");
            return jSONObjectPut;
        }

        @NotNull
        public String toString() {
            return "CallbackResult(name=" + this.f12956a + ", productType=" + this.f12957b + ", demandSourceName=" + this.f12958c + ", params=" + this.f12959d + ')';
        }

        @NotNull
        public final a a(@NotNull String name, @NotNull qf.e productType, @NotNull String demandSourceName, @NotNull JSONObject params) {
            kotlin.jvm.internal.t.i(name, "name");
            kotlin.jvm.internal.t.i(productType, "productType");
            kotlin.jvm.internal.t.i(demandSourceName, "demandSourceName");
            kotlin.jvm.internal.t.i(params, "params");
            return new a(name, productType, demandSourceName, params);
        }

        @NotNull
        public final String a() {
            return this.f12956a;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.ironsource.sdk.controller.androidSandbox.AndroidSandboxJSHandler$handleAttributionClick$1", f = "AndroidSandboxJSHandler.kt", l = {80}, m = "invokeSuspend")
    static final class c extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12960a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MeasurementManager f12962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Uri f12963d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ MotionEvent f12964e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(MeasurementManager measurementManager, Uri uri, MotionEvent motionEvent, z8.d<? super c> dVar) {
            super(2, dVar);
            this.f12962c = measurementManager;
            this.f12963d = uri;
            this.f12964e = motionEvent;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((c) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return l3.this.new c(this.f12962c, this.f12963d, this.f12964e, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f12960a;
            if (i10 == 0) {
                v8.u.b(obj);
                l3 l3Var = l3.this;
                MeasurementManager measurementManager = this.f12962c;
                Uri uri = this.f12963d;
                kotlin.jvm.internal.t.h(uri, "uri");
                MotionEvent motionEvent = this.f12964e;
                this.f12960a = 1;
                if (l3Var.a(measurementManager, uri, motionEvent, this) == objE) {
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

    @kotlin.coroutines.jvm.internal.f(c = "com.ironsource.sdk.controller.androidSandbox.AndroidSandboxJSHandler$handleAttributionImpression$1", f = "AndroidSandboxJSHandler.kt", l = {60}, m = "invokeSuspend")
    static final class d extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12965a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MeasurementManager f12967c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Uri f12968d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(MeasurementManager measurementManager, Uri uri, z8.d<? super d> dVar) {
            super(2, dVar);
            this.f12967c = measurementManager;
            this.f12968d = uri;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((d) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return l3.this.new d(this.f12967c, this.f12968d, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f12965a;
            if (i10 == 0) {
                v8.u.b(obj);
                l3 l3Var = l3.this;
                MeasurementManager measurementManager = this.f12967c;
                Uri uri = this.f12968d;
                kotlin.jvm.internal.t.h(uri, "uri");
                this.f12965a = 1;
                if (l3Var.a(measurementManager, uri, null, this) == objE) {
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

    static {
        String name = b.class.getName();
        kotlin.jvm.internal.t.h(name, "this::class.java.name");
        f12955b = name;
    }

    private final a a(Context context, n3.a aVar) {
        MeasurementManager measurementManagerA = g1.a(context);
        if (measurementManagerA == null) {
            Logger.i(f12955b, "could not obtain measurement manager");
            return a(aVar, "could not obtain measurement manager");
        }
        try {
            if (aVar instanceof n3.a.b) {
                return a(aVar, measurementManagerA);
            }
            if (aVar instanceof n3.a.C0261a) {
                return a((n3.a.C0261a) aVar, measurementManagerA);
            }
            throw new v8.q();
        } catch (Exception e10) {
            i9.d().a(e10);
            return a(aVar, "failed to handle attribution, message: " + e10.getMessage());
        }
    }

    @NotNull
    public final a a(@NotNull Context context, @NotNull n3 message) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(message, "message");
        if (message instanceof n3.a) {
            return a(context, (n3.a) message);
        }
        throw new v8.q();
    }

    private final a a(n3.a.C0261a c0261a, MeasurementManager measurementManager) throws InterruptedException {
        Uri uri = Uri.parse(c0261a.getUrl());
        long jUptimeMillis = SystemClock.uptimeMillis();
        kotlinx.coroutines.j.b(null, new c(measurementManager, uri, MotionEvent.obtain(jUptimeMillis, jUptimeMillis, c0261a.m(), c0261a.n().c(), c0261a.n().d(), c0261a.o()), null), 1, null);
        return a(c0261a);
    }

    private final a a(n3.a aVar) throws JSONException {
        JSONObject params = new JSONObject().put("params", new JSONObject().put("type", aVar instanceof n3.a.C0261a ? w8.f16021d : "impression"));
        String strC = aVar.c();
        qf.e eVarB = aVar.b();
        String strD = aVar.d();
        kotlin.jvm.internal.t.h(params, "params");
        return new a(strC, eVarB, strD, params);
    }

    private final a a(n3.a aVar, MeasurementManager measurementManager) throws InterruptedException {
        kotlinx.coroutines.j.b(null, new d(measurementManager, Uri.parse(aVar.getUrl()), null), 1, null);
        return a(aVar);
    }

    private final a a(n3 n3Var, String str) throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("reason", str).put("type", n3Var instanceof n3.a.C0261a ? w8.f16021d : "impression");
        String strA = n3Var.a();
        qf.e eVarB = n3Var.b();
        String strD = n3Var.d();
        JSONObject jSONObjectPut2 = new JSONObject().put("params", jSONObjectPut);
        kotlin.jvm.internal.t.h(jSONObjectPut2, "JSONObject().put(\"params\", payload)");
        return new a(strA, eVarB, strD, jSONObjectPut2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public final Object a(MeasurementManager measurementManager, Uri uri, MotionEvent motionEvent, z8.d<? super v8.k0> dVar) throws Throwable {
        z8.i iVar = new z8.i(a9.c.c(dVar));
        measurementManager.registerSource(uri, motionEvent, Executors.newSingleThreadExecutor(), m3.a(iVar));
        Object objA = iVar.a();
        if (objA == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objA == a9.d.e() ? objA : v8.k0.f35197a;
    }
}
