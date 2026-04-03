package com.unity3d.services;

import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.ExceptionExtensionsKt;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import h9.p;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.collections.r0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import o9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.r;
import v8.u;
import v8.y;
import z8.d;
import z8.g;

/* JADX INFO: compiled from: SDKErrorHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SDKErrorHandler implements l0 {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String UNITY_PACKAGE = "com.unity3d";

    @NotNull
    public static final String UNKNOWN_FILE = "unknown";

    @NotNull
    private final AlternativeFlowReader alternativeFlowReader;

    @NotNull
    private final k0 ioDispatcher;

    @NotNull
    private final l0.b key;

    @NotNull
    private final o0 scope;

    @NotNull
    private final SDKMetricsSender sdkMetricsSender;

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    /* JADX INFO: compiled from: SDKErrorHandler.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.SDKErrorHandler$sendDiagnostic$1, reason: invalid class name */
    /* JADX INFO: compiled from: SDKErrorHandler.kt */
    @f(c = "com.unity3d.services.SDKErrorHandler$sendDiagnostic$1", f = "SDKErrorHandler.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super v8.k0>, Object> {
        final /* synthetic */ String $name;
        final /* synthetic */ String $reason;
        final /* synthetic */ String $scopeName;
        final /* synthetic */ String $stackTrace;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, String str4, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$name = str;
            this.$reason = str2;
            this.$stackTrace = str3;
            this.$scopeName = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return SDKErrorHandler.this.new AnonymousClass1(this.$name, this.$reason, this.$stackTrace, this.$scopeName, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            SendDiagnosticEvent.DefaultImpls.invoke$default(SDKErrorHandler.this.sendDiagnosticEvent, this.$name, null, r0.j(y.a("reason", this.$reason), y.a("reason_debug", this.$stackTrace), y.a("coroutine_name", this.$scopeName)), null, null, 26, null);
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super v8.k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    public SDKErrorHandler(@NotNull k0 ioDispatcher, @NotNull AlternativeFlowReader alternativeFlowReader, @NotNull SendDiagnosticEvent sendDiagnosticEvent, @NotNull SDKMetricsSender sdkMetricsSender) {
        t.i(ioDispatcher, "ioDispatcher");
        t.i(alternativeFlowReader, "alternativeFlowReader");
        t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        t.i(sdkMetricsSender, "sdkMetricsSender");
        this.ioDispatcher = ioDispatcher;
        this.alternativeFlowReader = alternativeFlowReader;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.sdkMetricsSender = sdkMetricsSender;
        this.scope = p0.i(p0.a(ioDispatcher), new n0("SDKErrorHandler"));
        this.key = l0.N7;
    }

    private final String getShortenedStackTrace(Throwable th, int i10) {
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            t.h(string, "writer.toString()");
            return o.q(o.v(r.m0(r.b1(string).toString()), i10), "\n", null, null, 0, null, null, 62, null);
        } catch (Throwable unused) {
            return "";
        }
    }

    private final String retrieveCoroutineName(g gVar) {
        String strI0;
        n0 n0Var = (n0) gVar.get(n0.f29957b);
        return (n0Var == null || (strI0 = n0Var.I0()) == null) ? "unknown" : strI0;
    }

    private final void sendDiagnostic(String str, String str2, String str3, String str4) {
        kotlinx.coroutines.k.d(this.scope, null, null, new AnonymousClass1(str, str2, str4, str3, null), 3, null);
    }

    private final void sendMetric(Metric metric) {
        this.sdkMetricsSender.sendMetric(metric);
    }

    @Override // z8.g.b, z8.g
    public <R> R fold(R r10, @NotNull p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) l0.a.a(this, r10, pVar);
    }

    @Override // z8.g.b, z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> cVar) {
        return (E) l0.a.b(this, cVar);
    }

    @Override // kotlinx.coroutines.l0
    public void handleException(@NotNull g context, @NotNull Throwable exception) {
        t.i(context, "context");
        t.i(exception, "exception");
        String strRetrieveCoroutineName = retrieveCoroutineName(context);
        String str = exception instanceof NullPointerException ? "native_exception_npe" : exception instanceof OutOfMemoryError ? "native_exception_oom" : exception instanceof IllegalStateException ? "native_exception_ise" : exception instanceof SecurityException ? "native_exception_se" : exception instanceof RuntimeException ? "native_exception_re" : "native_exception";
        boolean zInvoke = this.alternativeFlowReader.invoke();
        String strRetrieveUnityCrashValue = ExceptionExtensionsKt.retrieveUnityCrashValue(exception);
        DeviceLog.error("Unity Ads SDK encountered an exception: " + strRetrieveUnityCrashValue);
        if (zInvoke) {
            sendDiagnostic(str, strRetrieveUnityCrashValue, strRetrieveCoroutineName, getShortenedStackTrace(exception, 15));
        } else {
            sendMetric(new Metric(str, strRetrieveUnityCrashValue, null, 4, null));
        }
    }

    @Override // z8.g.b, z8.g
    @NotNull
    public g minusKey(@NotNull g.c<?> cVar) {
        return l0.a.c(this, cVar);
    }

    @Override // z8.g
    @NotNull
    public g plus(@NotNull g gVar) {
        return l0.a.d(this, gVar);
    }

    @Override // z8.g.b
    @NotNull
    public l0.b getKey() {
        return this.key;
    }
}
