package com.iab.omid.library.vungle.walking.async;

import com.iab.omid.library.vungle.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final HashSet<String> f11149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f11150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final long f11151e;

    public a(b.InterfaceC0248b interfaceC0248b, HashSet<String> hashSet, JSONObject jSONObject, long j10) {
        super(interfaceC0248b);
        this.f11149c = new HashSet<>(hashSet);
        this.f11150d = jSONObject;
        this.f11151e = j10;
    }
}
