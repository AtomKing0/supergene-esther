package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.IntentUtils;
import com.braze.support.WebContentUtils;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p9.r;
import v8.s;

/* JADX INFO: loaded from: classes2.dex */
public final class re0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ee0 f3779e = new ee0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f3780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f3781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f3782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f3783d;

    public re0(Context context, String apiKey) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(apiKey, "apiKey");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.storage.triggers.local_assets." + apiKey, 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…ey, Context.MODE_PRIVATE)");
        this.f3780a = sharedPreferences;
        this.f3781b = f3779e.a(sharedPreferences);
        this.f3782c = new LinkedHashMap();
        this.f3783d = new File(context.getCacheDir().getPath() + "/ab_triggers");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v18, types: [T, java.lang.Object, java.lang.String] */
    public final String a(s70 remotePath) {
        Long lA;
        String lastPathSegment;
        int iJ0;
        kotlin.jvm.internal.t.i(remotePath, "remotePath");
        String remoteAssetUrl = remotePath.f3837b;
        int iOrdinal = remotePath.f3836a.ordinal();
        if (iOrdinal == 0) {
            String localHtmlUrlFromRemoteUrl = WebContentUtils.getLocalHtmlUrlFromRemoteUrl(this.f3783d, remoteAssetUrl);
            if (localHtmlUrlFromRemoteUrl == null || p9.q.z(localHtmlUrlFromRemoteUrl)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ge0(remoteAssetUrl), 7, (Object) null);
                return null;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new fe0(localHtmlUrlFromRemoteUrl, remoteAssetUrl), 6, (Object) null);
            return localHtmlUrlFromRemoteUrl;
        }
        if (iOrdinal != 1 && iOrdinal != 2) {
            throw new v8.q();
        }
        ee0 ee0Var = f3779e;
        kotlin.jvm.internal.t.i(remoteAssetUrl, "remoteAssetUrl");
        kotlin.jvm.internal.n0 n0Var = new kotlin.jvm.internal.n0();
        n0Var.f29834a = "";
        Uri uri = Uri.parse(remoteAssetUrl);
        if (uri != null && (lastPathSegment = uri.getLastPathSegment()) != null && lastPathSegment.length() != 0 && (iJ0 = r.j0(lastPathSegment, '.', 0, false, 6, null)) > -1) {
            ?? Substring = lastPathSegment.substring(iJ0);
            kotlin.jvm.internal.t.h(Substring, "this as java.lang.String).substring(startIndex)");
            n0Var.f29834a = Substring;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) ee0Var, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new zd0(remoteAssetUrl, n0Var), 6, (Object) null);
        }
        String str = IntentUtils.getRequestCode() + ((String) n0Var.f29834a);
        try {
            String string = this.f3783d.toString();
            kotlin.jvm.internal.t.h(string, "triggeredAssetDirectory.toString()");
            s sVarDownloadFileToPath$default = BrazeFileUtils.downloadFileToPath$default(string, remoteAssetUrl, str, null, 8, null);
            File file = (File) sVarDownloadFileToPath$default.a();
            Map map = (Map) sVarDownloadFileToPath$default.b();
            String str2 = (String) map.get("expires");
            if (str2 != null && (lA = com.braze.support.i.a(str2)) != null && lA.longValue() <= 0) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ie0(remoteAssetUrl, map), 7, (Object) null);
                return null;
            }
            Uri uriFromFile = Uri.fromFile(file);
            if (uriFromFile != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new je0(remoteAssetUrl, uriFromFile), 6, (Object) null);
                return uriFromFile.getPath();
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ke0(remoteAssetUrl), 7, (Object) null);
            return null;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new he0(remoteAssetUrl), 4, (Object) null);
            return null;
        }
    }

    public final Map a(k10 triggeredAction) {
        kotlin.jvm.internal.t.i(triggeredAction, "triggeredAction");
        if (!((bh0) triggeredAction).f2454c) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new le0(triggeredAction), 7, (Object) null);
            return kotlin.collections.r0.g();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = triggeredAction.a().iterator();
        while (it.hasNext()) {
            String str = ((s70) it.next()).f3837b;
            String path = (String) this.f3781b.get(str);
            if (path != null) {
                kotlin.jvm.internal.t.i(path, "path");
                if (new File(path).exists()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new me0(path, str), 7, (Object) null);
                    this.f3782c.put(str, path);
                    linkedHashMap.put(str, path);
                }
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new ne0(str), 6, (Object) null);
        }
        if (linkedHashMap.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new oe0(triggeredAction), 6, (Object) null);
        }
        return linkedHashMap;
    }
}
