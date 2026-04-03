package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.webkit.ProxyConfig;
import com.ironsource.v8;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Store.java */
/* JADX INFO: loaded from: classes3.dex */
class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SharedPreferences f10499a;

    /* JADX INFO: compiled from: Store.java */
    static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f10500d = TimeUnit.DAYS.toMillis(7);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f10501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f10502b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f10503c;

        private a(String str, String str2, long j10) {
            this.f10501a = str;
            this.f10502b = str2;
            this.f10503c = j10;
        }

        static String a(String str, String str2, long j10) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put(v8.i.W, str2);
                jSONObject.put("timestamp", j10);
                return jSONObject.toString();
            } catch (JSONException e10) {
                Log.w("FirebaseMessaging", "Failed to encode token: " + e10);
                return null;
            }
        }

        static a c(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new a(str, null, 0L);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new a(jSONObject.getString("token"), jSONObject.getString(v8.i.W), jSONObject.getLong("timestamp"));
            } catch (JSONException e10) {
                Log.w("FirebaseMessaging", "Failed to parse token: " + e10);
                return null;
            }
        }

        boolean b(String str) {
            return System.currentTimeMillis() > this.f10503c + f10500d || !str.equals(this.f10502b);
        }
    }

    public z0(Context context) {
        this.f10499a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        a(context, "com.google.android.gms.appid-no-backup");
    }

    private void a(Context context, String str) {
        File file = new File(ContextCompat.getNoBackupFilesDir(context), str);
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || f()) {
                return;
            }
            Log.i("FirebaseMessaging", "App restored, clearing state");
            c();
        } catch (IOException e10) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e10.getMessage());
            }
        }
    }

    private String b(String str, String str2) {
        return str + "|T|" + str2 + "|" + ProxyConfig.MATCH_ALL_SCHEMES;
    }

    public synchronized void c() {
        this.f10499a.edit().clear().commit();
    }

    public synchronized void d(String str, String str2) {
        String strB = b(str, str2);
        SharedPreferences.Editor editorEdit = this.f10499a.edit();
        editorEdit.remove(strB);
        editorEdit.commit();
    }

    public synchronized a e(String str, String str2) {
        return a.c(this.f10499a.getString(b(str, str2), null));
    }

    public synchronized boolean f() {
        return this.f10499a.getAll().isEmpty();
    }

    public synchronized void g(String str, String str2, String str3, String str4) {
        String strA = a.a(str3, str4, System.currentTimeMillis());
        if (strA == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f10499a.edit();
        editorEdit.putString(b(str, str2), strA);
        editorEdit.commit();
    }
}
