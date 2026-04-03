package bo.app;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public enum k00 {
    CONTENT_CARD_SYNC("content_cards/sync"),
    FEATURE_FLAG_SYNC("feature_flags/sync"),
    V3_DATA("data"),
    TEMPLATE_REQUEST(com.vungle.ads.internal.model.b.KEY_TEMPLATE),
    PUSH_DELIVERY_EVENTS("push/delivery_events"),
    GEOFENCE_REFRESH("geofence/request"),
    GEOFENCE_REPORT("geofence/report"),
    PUSH_REDELIVER("push/redeliver"),
    SDK_DEBUGGER_INIT("debugger/init"),
    SDK_DEBUGGER_LOG("debugger/log"),
    DUST_CONFIG("dust/config");


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j00 f3188b = new j00();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f3189c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3202a;

    static {
        k00[] k00VarArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(n9.o.e(kotlin.collections.q0.d(k00VarArrValues.length), 16));
        for (k00 k00Var : k00VarArrValues) {
            linkedHashMap.put(k00Var.f3202a, k00Var);
        }
        f3189c = linkedHashMap;
    }

    k00(String str) {
        this.f3202a = str;
    }
}
