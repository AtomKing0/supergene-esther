package com.iab.omid.library.vungle.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.vungle.walking.async.b;
import com.iab.omid.library.vungle.walking.async.d;
import com.iab.omid.library.vungle.walking.async.e;
import com.iab.omid.library.vungle.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class b implements b.InterfaceC0248b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f11158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.vungle.walking.async.c f11159b;

    public b(com.iab.omid.library.vungle.walking.async.c cVar) {
        this.f11159b = cVar;
    }

    @Override // com.iab.omid.library.vungle.walking.async.b.InterfaceC0248b
    @VisibleForTesting
    public JSONObject a() {
        return this.f11158a;
    }

    public void b() {
        this.f11159b.b(new d(this));
    }

    @Override // com.iab.omid.library.vungle.walking.async.b.InterfaceC0248b
    @VisibleForTesting
    public void a(JSONObject jSONObject) {
        this.f11158a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j10) {
        this.f11159b.b(new f(this, hashSet, jSONObject, j10));
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j10) {
        this.f11159b.b(new e(this, hashSet, jSONObject, j10));
    }
}
