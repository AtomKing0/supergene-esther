package com.ironsource;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.ironsource.fc;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class hc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ra f12464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final gc f12465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final hl f12466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ce f12467e = el.N().f();

    class a implements hn {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ hn f12468a;

        /* JADX INFO: renamed from: com.ironsource.hc$a$a, reason: collision with other inner class name */
        class C0257a extends JSONObject {
            C0257a() throws JSONException {
                put("lastReferencedTime", System.currentTimeMillis());
            }
        }

        a(hn hnVar) {
            this.f12468a = hnVar;
        }

        @Override // com.ironsource.hn
        public void a(zf zfVar) {
            this.f12468a.a(zfVar);
            try {
                hc.this.f12466d.a(zfVar.getName(), new C0257a());
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
        }

        @Override // com.ironsource.hn
        public void a(zf zfVar, rf rfVar) {
            this.f12468a.a(zfVar, rfVar);
        }
    }

    public hc(Context context, ra raVar, gc gcVar, hl hlVar) {
        this.f12463a = context;
        this.f12464b = raVar;
        this.f12465c = gcVar;
        this.f12466d = hlVar;
    }

    public void b(zf zfVar) throws Exception {
        if (zfVar.exists()) {
            ArrayList<zf> filesInFolderRecursive = IronSourceStorageUtils.getFilesInFolderRecursive(zfVar);
            if (!(IronSourceStorageUtils.deleteFolderContentRecursive(zfVar) && zfVar.delete())) {
                throw new Exception("Failed to delete folder");
            }
            this.f12466d.a(filesInFolderRecursive);
        }
    }

    public JSONObject c(zf zfVar) throws Exception {
        if (zfVar.exists()) {
            return IronSourceStorageUtils.buildFilesMapOfDirectory(zfVar, this.f12466d.b());
        }
        throw new Exception("Folder does not exist");
    }

    public long d(zf zfVar) throws Exception {
        if (zfVar.exists()) {
            return IronSourceStorageUtils.getTotalSizeOfDir(zfVar);
        }
        throw new Exception("Folder does not exist");
    }

    public void a(zf zfVar) throws Exception {
        if (zfVar.exists()) {
            if (!zfVar.delete()) {
                throw new Exception("Failed to delete file");
            }
            this.f12466d.a(zfVar.getName());
        }
    }

    public void a(zf zfVar, String str, int i10, int i11, hn hnVar) throws Exception {
        if (TextUtils.isEmpty(str)) {
            throw new Exception(fc.a.f12094a);
        }
        if (this.f12467e.a(this.f12464b.a()) <= 0) {
            throw new Exception(x8.A);
        }
        if (!r8.h(this.f12463a)) {
            throw new Exception(x8.C);
        }
        this.f12465c.a(zfVar.getPath(), new a(hnVar));
        if (!zfVar.exists()) {
            this.f12464b.a(zfVar, str, i10, i11, this.f12465c);
            return;
        }
        Message message = new Message();
        message.obj = zfVar;
        message.what = 1015;
        this.f12465c.sendMessage(message);
    }

    public void a(zf zfVar, JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            throw new Exception("Missing attributes to update");
        }
        if (!zfVar.exists()) {
            throw new Exception("File does not exist");
        }
        if (!this.f12466d.b(zfVar.getName(), jSONObject)) {
            throw new Exception("Failed to update attribute");
        }
    }
}
