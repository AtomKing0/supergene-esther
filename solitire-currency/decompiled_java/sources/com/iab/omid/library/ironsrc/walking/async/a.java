package com.iab.omid.library.ironsrc.walking.async;

import com.iab.omid.library.ironsrc.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final HashSet<String> f10886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f10887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final long f10888e;

    public a(b.InterfaceC0240b interfaceC0240b, HashSet<String> hashSet, JSONObject jSONObject, long j10) {
        super(interfaceC0240b);
        this.f10886c = new HashSet<>(hashSet);
        this.f10887d = jSONObject;
        this.f10888e = j10;
    }
}
