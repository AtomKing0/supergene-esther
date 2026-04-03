package com.iab.omid.library.ironsrc.walking.async;

import com.iab.omid.library.ironsrc.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class e extends a {
    public e(b.InterfaceC0240b interfaceC0240b, HashSet<String> hashSet, JSONObject jSONObject, long j10) {
        super(interfaceC0240b, hashSet, jSONObject, j10);
    }

    private void b(String str) {
        com.iab.omid.library.ironsrc.internal.c cVarC = com.iab.omid.library.ironsrc.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.ironsrc.adsession.a aVar : cVarC.b()) {
                if (this.f10886c.contains(aVar.getAdSessionId())) {
                    aVar.getAdSessionStatePublisher().a(str, this.f10888e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        return this.f10887d.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.iab.omid.library.ironsrc.walking.async.b, android.os.AsyncTask
    /* JADX INFO: renamed from: a */
    public void onPostExecute(String str) {
        b(str);
        super.onPostExecute(str);
    }
}
