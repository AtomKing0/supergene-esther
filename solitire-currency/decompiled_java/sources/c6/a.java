package c6;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import t5.c;

/* JADX INFO: compiled from: DataCollectionConfigStorage.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f4598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f4599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4600d;

    public a(Context context, String str, c cVar) {
        Context contextA = a(context);
        this.f4597a = contextA;
        this.f4598b = contextA.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f4599c = cVar;
        this.f4600d = c();
    }

    private static Context a(Context context) {
        return Build.VERSION.SDK_INT < 24 ? context : ContextCompat.createDeviceProtectedStorageContext(context);
    }

    private boolean c() {
        return this.f4598b.contains("firebase_data_collection_default_enabled") ? this.f4598b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    private boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f4597a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f4597a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public synchronized boolean b() {
        return this.f4600d;
    }
}
