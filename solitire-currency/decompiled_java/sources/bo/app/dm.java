package bo.app;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class dm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONArray f2666d;

    public dm(String serializedCardJson) {
        kotlin.jvm.internal.t.i(serializedCardJson, "serializedCardJson");
        this.f2665c = false;
        this.f2663a = -1L;
        this.f2664b = -1L;
        this.f2666d = new JSONArray().put(new JSONObject(serializedCardJson));
    }

    public dm(JSONObject jsonObject) {
        kotlin.jvm.internal.t.i(jsonObject, "jsonObject");
        this.f2663a = jsonObject.optLong("last_card_updated_at", -1L);
        this.f2664b = jsonObject.optLong("last_full_sync_at", -1L);
        this.f2665c = jsonObject.optBoolean("full_sync", false);
        this.f2666d = jsonObject.optJSONArray("cards");
    }
}
