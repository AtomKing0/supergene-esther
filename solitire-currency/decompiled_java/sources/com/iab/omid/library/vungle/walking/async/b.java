package com.iab.omid.library.vungle.walking.async;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends AsyncTask<Object, Void, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f11152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final InterfaceC0248b f11153b;

    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: renamed from: com.iab.omid.library.vungle.walking.async.b$b, reason: collision with other inner class name */
    public interface InterfaceC0248b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(InterfaceC0248b interfaceC0248b) {
        this.f11153b = interfaceC0248b;
    }

    public void a(a aVar) {
        this.f11152a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.f11152a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
