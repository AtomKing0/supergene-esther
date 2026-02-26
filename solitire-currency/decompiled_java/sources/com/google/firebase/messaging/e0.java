package com.google.firebase.messaging;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.ironsource.ad;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import u5.j;

/* JADX INFO: compiled from: GmsRpc.java */
/* JADX INFO: loaded from: classes3.dex */
class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i5.e f10390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j0 f10391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rpc f10392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final w5.b<f6.i> f10393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final w5.b<u5.j> f10394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final x5.e f10395f;

    e0(i5.e eVar, j0 j0Var, w5.b<f6.i> bVar, w5.b<u5.j> bVar2, x5.e eVar2) {
        this(eVar, j0Var, new Rpc(eVar.j()), bVar, bVar2, eVar2);
    }

    private static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private Task<String> d(Task<Bundle> task) {
        return task.continueWith(new androidx.media3.exoplayer.dash.offline.a(), new Continuation() { // from class: com.google.firebase.messaging.d0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return this.f10381a.i(task2);
            }
        });
    }

    private String e() {
        try {
            return b(MessageDigest.getInstance(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1).digest(this.f10390a.l().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    @AnyThread
    private String g(Bundle bundle) throws IOException {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("unregistered");
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString("error");
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string3 != null) {
            throw new IOException(string3);
        }
        Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    static boolean h(String str) {
        return "SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String i(Task task) throws Exception {
        return g((Bundle) task.getResult(IOException.class));
    }

    private void j(String str, String str2, Bundle bundle) throws ExecutionException, InterruptedException {
        j.a aVarB;
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("gmp_app_id", this.f10390a.m().c());
        bundle.putString("gmsv", Integer.toString(this.f10391b.d()));
        bundle.putString(ad.f11278z, Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f10391b.a());
        bundle.putString("app_ver_name", this.f10391b.b());
        bundle.putString("firebase-app-name-hash", e());
        try {
            String strB = ((com.google.firebase.installations.g) Tasks.await(this.f10395f.a(false))).b();
            if (TextUtils.isEmpty(strB)) {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", strB);
            }
        } catch (InterruptedException | ExecutionException e10) {
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e10);
        }
        bundle.putString("appid", (String) Tasks.await(this.f10395f.getId()));
        bundle.putString("cliv", "fcm-23.4.1");
        u5.j jVar = this.f10394e.get();
        f6.i iVar = this.f10393d.get();
        if (jVar == null || iVar == null || (aVarB = jVar.b("fire-iid")) == j.a.NONE) {
            return;
        }
        bundle.putString("Firebase-Client-Log-Type", Integer.toString(aVarB.a()));
        bundle.putString("Firebase-Client", iVar.getUserAgent());
    }

    private Task<Bundle> k(String str, String str2, Bundle bundle) {
        try {
            j(str, str2, bundle);
            return this.f10392c.send(bundle);
        } catch (InterruptedException | ExecutionException e10) {
            return Tasks.forException(e10);
        }
    }

    Task<?> c() {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return d(k(j0.c(this.f10390a), ProxyConfig.MATCH_ALL_SCHEMES, bundle));
    }

    Task<String> f() {
        return d(k(j0.c(this.f10390a), ProxyConfig.MATCH_ALL_SCHEMES, new Bundle()));
    }

    Task<?> l(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        return d(k(str, "/topics/" + str2, bundle));
    }

    Task<?> m(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        bundle.putString("delete", "1");
        return d(k(str, "/topics/" + str2, bundle));
    }

    @VisibleForTesting
    e0(i5.e eVar, j0 j0Var, Rpc rpc, w5.b<f6.i> bVar, w5.b<u5.j> bVar2, x5.e eVar2) {
        this.f10390a = eVar;
        this.f10391b = j0Var;
        this.f10392c = rpc;
        this.f10393d = bVar;
        this.f10394e = bVar2;
        this.f10395f = eVar2;
    }
}
