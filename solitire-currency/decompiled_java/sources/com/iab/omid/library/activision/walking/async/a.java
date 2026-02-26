package com.iab.omid.library.activision.walking.async;

import com.iab.omid.library.activision.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final HashSet<String> f10626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f10627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final long f10628e;

    public a(b.InterfaceC0233b interfaceC0233b, HashSet<String> hashSet, JSONObject jSONObject, long j10) {
        super(interfaceC0233b);
        this.f10626c = new HashSet<>(hashSet);
        this.f10627d = jSONObject;
        this.f10628e = j10;
    }
}
