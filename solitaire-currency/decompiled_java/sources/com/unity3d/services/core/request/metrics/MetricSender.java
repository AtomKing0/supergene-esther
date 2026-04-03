package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import com.unity3d.services.core.properties.InitializationStatusReader;
import h9.p;
import j9.c;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import p9.q;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: MetricSender.kt */
/* JADX INFO: loaded from: classes4.dex */
public class MetricSender extends MetricSenderBase implements IServiceComponent {

    @NotNull
    private final MetricCommonTags commonTags;

    @NotNull
    private final ISDKDispatchers dispatchers;

    @NotNull
    private final HttpClient httpClient;

    @Nullable
    private final String metricEndPoint;

    @NotNull
    private final String metricSampleRate;

    @NotNull
    private final o0 scope;
    private final String sessionToken;

    /* JADX INFO: renamed from: com.unity3d.services.core.request.metrics.MetricSender$sendMetrics$1, reason: invalid class name */
    /* JADX INFO: compiled from: MetricSender.kt */
    @f(c = "com.unity3d.services.core.request.metrics.MetricSender$sendMetrics$1", f = "MetricSender.kt", l = {65}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ List<Metric> $metrics;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<Metric> list, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$metrics = list;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return MetricSender.this.new AnonymousClass1(this.$metrics, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objExecute;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                String string = new JSONObject(new MetricsContainer(MetricSender.this.metricSampleRate, MetricSender.this.commonTags, this.$metrics, MetricSender.this.sessionToken).toMap()).toString();
                t.h(string, "JSONObject(container.toMap()).toString()");
                String metricEndPoint = MetricSender.this.getMetricEndPoint();
                if (metricEndPoint == null) {
                    metricEndPoint = "";
                }
                HttpRequest httpRequest = new HttpRequest(metricEndPoint, null, RequestType.POST, string, null, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131058, null);
                HttpClient httpClient = MetricSender.this.httpClient;
                this.label = 1;
                objExecute = httpClient.execute(httpRequest, this);
                if (objExecute == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                objExecute = obj;
            }
            HttpResponse httpResponse = (HttpResponse) objExecute;
            if (httpResponse.getStatusCode() / 100 == 2) {
                DeviceLog.debug("Metric " + this.$metrics + " sent to " + MetricSender.this.getMetricEndPoint());
            } else {
                DeviceLog.debug("Metric " + this.$metrics + " failed to send with response code: " + httpResponse.getStatusCode());
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetricSender(@NotNull Configuration configuration, @NotNull InitializationStatusReader initializationStatusReader) {
        super(initializationStatusReader);
        t.i(configuration, "configuration");
        t.i(initializationStatusReader, "initializationStatusReader");
        MetricCommonTags metricCommonTags = new MetricCommonTags();
        metricCommonTags.updateWithConfig(configuration);
        this.commonTags = metricCommonTags;
        this.metricSampleRate = String.valueOf(c.b(configuration.getMetricSampleRate()));
        this.sessionToken = configuration.getSessionToken();
        ISDKDispatchers iSDKDispatchers = (ISDKDispatchers) getServiceProvider().getRegistry().getService("", kotlin.jvm.internal.o0.b(ISDKDispatchers.class));
        this.dispatchers = iSDKDispatchers;
        this.httpClient = (HttpClient) getServiceProvider().getRegistry().getService("", kotlin.jvm.internal.o0.b(HttpClient.class));
        this.scope = p0.a(iSDKDispatchers.getIo());
        this.metricEndPoint = configuration.getMetricsUrl();
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    @Nullable
    public String getMetricEndPoint() {
        return this.metricEndPoint;
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    @NotNull
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendEvent(@NotNull String event, @Nullable String str, @NotNull Map<String, String> tags) {
        t.i(event, "event");
        t.i(tags, "tags");
        if (!(event.length() == 0)) {
            sendMetrics(kotlin.collections.u.e(new Metric(event, str, tags)));
            return;
        }
        DeviceLog.debug("Metric event not sent due to being null or empty: " + event);
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendMetric(@NotNull Metric metric) {
        t.i(metric, "metric");
        sendMetrics(kotlin.collections.u.e(metric));
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendMetrics(@NotNull List<Metric> metrics) {
        t.i(metrics, "metrics");
        if (metrics.isEmpty()) {
            DeviceLog.debug("Metrics event not send due to being empty");
            return;
        }
        String metricEndPoint = getMetricEndPoint();
        if (!(metricEndPoint == null || q.z(metricEndPoint))) {
            k.d(this.scope, new MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1(l0.N7, metrics), null, new AnonymousClass1(metrics, null), 2, null);
            return;
        }
        DeviceLog.debug("Metrics: " + metrics + " was not sent to null or empty endpoint: " + getMetricEndPoint());
    }

    public final void shutdown() {
        this.commonTags.shutdown();
    }
}
