package com.iab.omid.library.applovin.walking.async;

import com.iab.omid.library.applovin.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final HashSet<String> f10761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f10762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final long f10763e;

    public a(b.InterfaceC0237b interfaceC0237b, HashSet<String> hashSet, JSONObject jSONObject, long j10) {
        super(interfaceC0237b);
        this.f10761c = new HashSet<>(hashSet);
        this.f10762d = jSONObject;
        this.f10763e = j10;
    }
}
