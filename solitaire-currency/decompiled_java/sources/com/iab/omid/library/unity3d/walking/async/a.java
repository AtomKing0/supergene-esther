package com.iab.omid.library.unity3d.walking.async;

import com.iab.omid.library.unity3d.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final HashSet<String> f11014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f11015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final long f11016e;

    public a(b.InterfaceC0244b interfaceC0244b, HashSet<String> hashSet, JSONObject jSONObject, long j10) {
        super(interfaceC0244b);
        this.f11014c = new HashSet<>(hashSet);
        this.f11015d = jSONObject;
        this.f11016e = j10;
    }
}
