package com.applovin.impl;

import androidx.media3.common.MimeTypes;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e7 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final List f5143f = Arrays.asList(MimeTypes.VIDEO_MP4, "video/webm", MimeTypes.VIDEO_H263, MimeTypes.VIDEO_MATROSKA);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f5144a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JSONObject f5146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JSONObject f5147d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List f5145b = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f5148e = System.currentTimeMillis();

    public e7(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        this.f5144a = jVar;
        this.f5146c = jSONObject;
        this.f5147d = jSONObject2;
    }

    public List a() {
        return this.f5145b;
    }

    public JSONObject b() {
        return this.f5146c;
    }

    public long c() {
        return this.f5148e;
    }

    public int d() {
        return this.f5145b.size();
    }

    public JSONObject e() {
        return this.f5147d;
    }

    public List f() {
        List<String> listExplode = CollectionUtils.explode(JsonUtils.getString(this.f5146c, "vast_preferred_video_types", null));
        return !listExplode.isEmpty() ? listExplode : f5143f;
    }

    public int g() {
        return z6.a(JsonUtils.getInt(this.f5146c, "video_completion_percent", -1));
    }
}
