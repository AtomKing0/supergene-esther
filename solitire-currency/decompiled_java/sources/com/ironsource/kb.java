package com.ironsource;

import com.ironsource.k9;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class kb {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final String f12861e = "euid";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final String f12862f = "esat";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final String f12863g = "esfr";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int f12864h = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f12866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JSONObject f12868d;

    public kb(int i10, long j10, String str) throws JSONException {
        this(i10, j10, new JSONObject(str));
    }

    public String a() {
        return this.f12868d.toString();
    }

    public JSONObject b() {
        return this.f12868d;
    }

    public int c() {
        return this.f12865a;
    }

    public long d() {
        return this.f12866b;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        kb kbVar = (kb) obj;
        return this.f12865a == kbVar.f12865a && this.f12866b == kbVar.f12866b && this.f12867c == kbVar.f12867c && sj.a(this.f12868d, kbVar.f12868d);
    }

    public int hashCode() {
        return (((((this.f12865a * 31) + androidx.compose.animation.a.a(this.f12866b)) * 31) + this.f12868d.toString().hashCode()) * 31) + this.f12867c;
    }

    @NotNull
    public String toString() {
        return ("{\"eventId\":" + c() + ",\"timestamp\":" + d() + "," + a().substring(1) + "}").replace(",", "\n");
    }

    public kb(int i10, long j10, JSONObject jSONObject) {
        this.f12867c = 1;
        this.f12865a = i10;
        this.f12866b = j10;
        jSONObject = jSONObject == null ? new JSONObject() : jSONObject;
        this.f12868d = jSONObject;
        if (!jSONObject.has(f12861e)) {
            a(f12861e, UUID.randomUUID().toString());
        }
        if (jSONObject.has(f12862f)) {
            this.f12867c = jSONObject.optInt(f12862f, 1);
        } else {
            a(f12862f, Integer.valueOf(this.f12867c));
        }
    }

    public void a(int i10) {
        this.f12865a = i10;
    }

    public kb(int i10, JSONObject jSONObject) {
        this(i10, new k9.a().a(), jSONObject);
    }

    public void a(String str) {
        a(f12863g, str);
        int i10 = this.f12867c + 1;
        this.f12867c = i10;
        a(f12862f, Integer.valueOf(i10));
    }

    public void a(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        try {
            this.f12868d.put(str, obj);
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }
}
