package com.iab.omid.library.unity3d.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.unity3d.walking.async.b;
import com.iab.omid.library.unity3d.walking.async.d;
import com.iab.omid.library.unity3d.walking.async.e;
import com.iab.omid.library.unity3d.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class b implements b.InterfaceC0244b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f11023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.unity3d.walking.async.c f11024b;

    public b(com.iab.omid.library.unity3d.walking.async.c cVar) {
        this.f11024b = cVar;
    }

    @Override // com.iab.omid.library.unity3d.walking.async.b.InterfaceC0244b
    @VisibleForTesting
    public JSONObject a() {
        return this.f11023a;
    }

    public void b() {
        this.f11024b.b(new d(this));
    }

    @Override // com.iab.omid.library.unity3d.walking.async.b.InterfaceC0244b
    @VisibleForTesting
    public void a(JSONObject jSONObject) {
        this.f11023a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j10) {
        this.f11024b.b(new f(this, hashSet, jSONObject, j10));
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j10) {
        this.f11024b.b(new e(this, hashSet, jSONObject, j10));
    }
}
