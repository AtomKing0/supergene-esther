package com.iab.omid.library.activision.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.activision.walking.async.b;
import com.iab.omid.library.activision.walking.async.d;
import com.iab.omid.library.activision.walking.async.e;
import com.iab.omid.library.activision.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class b implements b.InterfaceC0233b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f10635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.activision.walking.async.c f10636b;

    public b(com.iab.omid.library.activision.walking.async.c cVar) {
        this.f10636b = cVar;
    }

    @Override // com.iab.omid.library.activision.walking.async.b.InterfaceC0233b
    @VisibleForTesting
    public JSONObject a() {
        return this.f10635a;
    }

    public void b() {
        this.f10636b.b(new d(this));
    }

    @Override // com.iab.omid.library.activision.walking.async.b.InterfaceC0233b
    @VisibleForTesting
    public void a(JSONObject jSONObject) {
        this.f10635a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j10) {
        this.f10636b.b(new f(this, hashSet, jSONObject, j10));
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j10) {
        this.f10636b.b(new e(this, hashSet, jSONObject, j10));
    }
}
