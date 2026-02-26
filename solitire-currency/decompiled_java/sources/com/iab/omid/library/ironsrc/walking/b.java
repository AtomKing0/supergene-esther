package com.iab.omid.library.ironsrc.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.ironsrc.walking.async.b;
import com.iab.omid.library.ironsrc.walking.async.d;
import com.iab.omid.library.ironsrc.walking.async.e;
import com.iab.omid.library.ironsrc.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class b implements b.InterfaceC0240b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f10895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.ironsrc.walking.async.c f10896b;

    public b(com.iab.omid.library.ironsrc.walking.async.c cVar) {
        this.f10896b = cVar;
    }

    @Override // com.iab.omid.library.ironsrc.walking.async.b.InterfaceC0240b
    @VisibleForTesting
    public JSONObject a() {
        return this.f10895a;
    }

    public void b() {
        this.f10896b.b(new d(this));
    }

    @Override // com.iab.omid.library.ironsrc.walking.async.b.InterfaceC0240b
    @VisibleForTesting
    public void a(JSONObject jSONObject) {
        this.f10895a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j10) {
        this.f10896b.b(new f(this, hashSet, jSONObject, j10));
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j10) {
        this.f10896b.b(new e(this, hashSet, jSONObject, j10));
    }
}
