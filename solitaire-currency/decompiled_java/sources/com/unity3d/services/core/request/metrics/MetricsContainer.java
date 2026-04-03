package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.Session;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.collections.w;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MetricsContainer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MetricsContainer {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String METRICS_CONTAINER = "m";

    @NotNull
    private static final String METRICS_CONTAINER_TAGS = "t";

    @NotNull
    private static final String METRIC_CONTAINER_API_LEVEL = "apil";

    @NotNull
    private static final String METRIC_CONTAINER_DEVICE_MAKE = "deviceMake";

    @NotNull
    private static final String METRIC_CONTAINER_DEVICE_MODEL = "deviceModel";

    @NotNull
    private static final String METRIC_CONTAINER_DEVICE_NAME = "deviceName";

    @NotNull
    private static final String METRIC_CONTAINER_GAME_ID = "gameId";

    @NotNull
    private static final String METRIC_CONTAINER_SAMPLE_RATE = "msr";

    @NotNull
    private static final String METRIC_CONTAINER_SESSION_TOKEN = "sTkn";

    @NotNull
    private static final String METRIC_CONTAINER_SHARED_SESSION_ID = "shSid";

    @NotNull
    private final String apiLevel;

    @NotNull
    private final MetricCommonTags commonTags;
    private final String deviceManufacturer;
    private final String deviceModel;
    private final String deviceName;
    private final String gameId;

    @NotNull
    private final String metricSampleRate;

    @NotNull
    private final List<Metric> metrics;

    @Nullable
    private final String sTkn;

    @NotNull
    private final String shSid;

    /* JADX INFO: compiled from: MetricsContainer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public MetricsContainer(@NotNull String metricSampleRate, @NotNull MetricCommonTags commonTags, @NotNull List<Metric> metrics, @Nullable String str) {
        t.i(metricSampleRate, "metricSampleRate");
        t.i(commonTags, "commonTags");
        t.i(metrics, "metrics");
        this.metricSampleRate = metricSampleRate;
        this.commonTags = commonTags;
        this.metrics = metrics;
        this.sTkn = str;
        this.shSid = Session.Default.getId();
        this.apiLevel = String.valueOf(Device.getApiLevel());
        this.deviceModel = Device.getModel();
        this.deviceName = Device.getDevice();
        this.deviceManufacturer = Device.getManufacturer();
        this.gameId = ClientProperties.getGameId();
    }

    @NotNull
    public final Map<String, Object> toMap() {
        List<Metric> list = this.metrics;
        ArrayList arrayList = new ArrayList(w.v(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Metric) it.next()).toMap());
        }
        Map mapC = q0.c();
        mapC.put(METRIC_CONTAINER_SAMPLE_RATE, this.metricSampleRate);
        mapC.put(METRICS_CONTAINER, arrayList);
        mapC.put(METRICS_CONTAINER_TAGS, this.commonTags.toMap());
        mapC.put(METRIC_CONTAINER_SHARED_SESSION_ID, this.shSid);
        mapC.put(METRIC_CONTAINER_API_LEVEL, this.apiLevel);
        String str = this.sTkn;
        if (str != null) {
            mapC.put(METRIC_CONTAINER_SESSION_TOKEN, str);
        }
        String deviceModel = this.deviceModel;
        if (deviceModel != null) {
            t.h(deviceModel, "deviceModel");
            mapC.put("deviceModel", deviceModel);
        }
        String deviceName = this.deviceName;
        if (deviceName != null) {
            t.h(deviceName, "deviceName");
            mapC.put(METRIC_CONTAINER_DEVICE_NAME, deviceName);
        }
        String deviceManufacturer = this.deviceManufacturer;
        if (deviceManufacturer != null) {
            t.h(deviceManufacturer, "deviceManufacturer");
            mapC.put(METRIC_CONTAINER_DEVICE_MAKE, deviceManufacturer);
        }
        String gameId = this.gameId;
        if (gameId != null) {
            t.h(gameId, "gameId");
            mapC.put("gameId", gameId);
        }
        return q0.b(mapC);
    }
}
