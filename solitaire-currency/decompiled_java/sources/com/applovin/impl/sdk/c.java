package com.applovin.impl.sdk;

import android.os.SystemClock;
import android.text.TextUtils;
import com.applovin.impl.a2;
import com.applovin.impl.a7;
import com.applovin.impl.d4;
import com.applovin.impl.f6;
import com.applovin.impl.l4;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.w4;
import com.applovin.impl.y1;
import com.applovin.sdk.AppLovinAdType;
import com.unity3d.services.UnityAdsConstants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final File f7000b = new File(j.n().getFilesDir(), "al/persisted-ads");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f7001a;

    public static class a implements d4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AppLovinAdType f7003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f7004c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f7005d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f7006e;

        public a(String str, AppLovinAdType appLovinAdType, boolean z10, long j10, long j11) {
            this.f7002a = str;
            this.f7003b = appLovinAdType;
            this.f7004c = z10;
            this.f7005d = j10;
            this.f7006e = j11;
        }

        protected boolean a(Object obj) {
            return obj instanceof a;
        }

        public long b() {
            return this.f7006e;
        }

        public long c() {
            return this.f7005d;
        }

        public String d() {
            return this.f7002a + "_" + this.f7003b;
        }

        public String e() {
            return this.f7002a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.a(this)) {
                return false;
            }
            String strE = e();
            String strE2 = aVar.e();
            if (strE != null ? !strE.equals(strE2) : strE2 != null) {
                return false;
            }
            AppLovinAdType appLovinAdTypeF = f();
            AppLovinAdType appLovinAdTypeF2 = aVar.f();
            return appLovinAdTypeF != null ? appLovinAdTypeF.equals(appLovinAdTypeF2) : appLovinAdTypeF2 == null;
        }

        public AppLovinAdType f() {
            return this.f7003b;
        }

        public boolean g() {
            return this.f7004c;
        }

        public int hashCode() {
            String strE = e();
            int iHashCode = strE == null ? 43 : strE.hashCode();
            AppLovinAdType appLovinAdTypeF = f();
            return ((iHashCode + 59) * 59) + (appLovinAdTypeF != null ? appLovinAdTypeF.hashCode() : 43);
        }

        public String toString() {
            return "AdPersistenceFileService.PersistedAdFilePath(id=" + e() + ", type=" + f() + ", isAdServerAd=" + g() + ", expiryTimeMillis=" + c() + ", appLaunchTimestamp=" + b() + ")";
        }

        public static a a(com.applovin.impl.sdk.ad.b bVar) {
            return a(bVar, 0L, 0L);
        }

        public static a a(com.applovin.impl.sdk.ad.b bVar, long j10, long j11) {
            if (bVar == null) {
                return null;
            }
            return new a(StringUtils.isValidString(bVar.I()) ? bVar.I() : UUID.randomUUID().toString(), bVar.getType(), bVar instanceof com.applovin.impl.sdk.ad.a, SystemClock.elapsedRealtime() + j10, j11);
        }

        public static a a(JSONObject jSONObject, j jVar) {
            String string = JsonUtils.getString(jSONObject, "id", "");
            String string2 = JsonUtils.getString(jSONObject, "type", "");
            Boolean bool = JsonUtils.getBoolean(jSONObject, "is_ad_server_ad", null);
            long j10 = JsonUtils.getLong(jSONObject, "expiry_time_millis", 0L);
            long j11 = JsonUtils.getLong(jSONObject, "app_launch_timestamp", 0L);
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || bool == null) {
                return null;
            }
            return new a(string, AppLovinAdType.fromString(string2), bool.booleanValue(), j10, j11);
        }

        @Override // com.applovin.impl.d4
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putString(jSONObject, "id", this.f7002a);
            JsonUtils.putString(jSONObject, "type", this.f7003b.toString());
            JsonUtils.putBoolean(jSONObject, "is_ad_server_ad", this.f7004c);
            JsonUtils.putLong(jSONObject, "expiry_time_millis", this.f7005d);
            JsonUtils.putLong(jSONObject, "app_launch_timestamp", this.f7006e);
            return jSONObject;
        }
    }

    public interface b {
        void a(a aVar);
    }

    /* JADX INFO: renamed from: com.applovin.impl.sdk.c$c, reason: collision with other inner class name */
    public interface InterfaceC0173c {
        void a(com.applovin.impl.sdk.ad.b bVar, String str);
    }

    public c(j jVar) {
        this.f7001a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.ad.b bVar, b bVar2) {
        a aVarA = a.a(bVar, ((Long) this.f7001a.a(l4.S0)).longValue(), j.m());
        File fileA = a(aVarA);
        if (fileA == null) {
            a("Could not persist incompatible ad", bVar, bVar2);
            return;
        }
        try {
            JSONObject jSONObjectA = bVar.a();
            if (jSONObjectA == null) {
                a("Could not serialize ad for persistence", bVar, bVar2);
                return;
            }
            if (this.f7001a.C().b((InputStream) new ByteArrayInputStream(jSONObjectA.toString().getBytes("UTF-8")), fileA, true)) {
                a(aVarA, bVar, bVar2);
            } else {
                a("Failed to write persisted ad to disk", bVar, bVar2);
            }
        } catch (Throwable th) {
            a("Ad could not be persisted", bVar, bVar2);
            this.f7001a.A().a("AdPersistenceFileService", th, CollectionUtils.map("error_message", "Ad could not be persisted"));
        }
    }

    public void b(final com.applovin.impl.sdk.ad.b bVar, final b bVar2) {
        if (b()) {
            this.f7001a.j0().a((w4) new f6(this.f7001a, "persistAd", new Runnable() { // from class: com.applovin.impl.sdk.c0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7007a.a(bVar, bVar2);
                }
            }), r5.b.CACHING);
        } else {
            a("Ad Persistence directory could not be created", bVar, bVar2);
        }
    }

    private boolean b() {
        File file = f7000b;
        if (file.exists()) {
            return true;
        }
        return file.mkdir();
    }

    public void b(a aVar) {
        File fileA = a(aVar);
        if (fileA != null) {
            fileA.delete();
        }
    }

    public void a(final a aVar, final InterfaceC0173c interfaceC0173c) {
        final File fileA = a(aVar);
        if (fileA != null && fileA.exists()) {
            this.f7001a.j0().a((w4) new f6(this.f7001a, "retrievePersistedAd", new Runnable() { // from class: com.applovin.impl.sdk.b0
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f6993a.a(fileA, interfaceC0173c, aVar);
                }
            }), r5.b.OTHER);
        } else {
            interfaceC0173c.a(null, "Persisted ad could not be retrieved: Retrieval failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(File file, InterfaceC0173c interfaceC0173c, a aVar) throws Throwable {
        com.applovin.impl.sdk.ad.b bVarA;
        String strF = this.f7001a.C().f(file);
        if (strF == null) {
            interfaceC0173c.a(null, "Persisted ad could not be retrieved: Read failed");
            return;
        }
        try {
            JSONObject jSONObjectJsonObjectFromJsonString = JsonUtils.jsonObjectFromJsonString(strF, new JSONObject());
            JsonUtils.putBoolean(JsonUtils.getJSONObject(jSONObjectJsonObjectFromJsonString, "full_response", new JSONObject()), "is_persisted_ad", true);
            if (aVar.g()) {
                bVarA = com.applovin.impl.sdk.ad.a.a(jSONObjectJsonObjectFromJsonString, this.f7001a);
            } else {
                bVarA = a7.a(jSONObjectJsonObjectFromJsonString, this.f7001a);
            }
            if (bVarA == null) {
                interfaceC0173c.a(null, "Persisted ad could not be retrieved: Deserialization failed");
            } else {
                interfaceC0173c.a(bVarA, null);
            }
        } catch (Throwable th) {
            interfaceC0173c.a(null, "Persisted ad could not be retrieved: Deserialization failed");
            this.f7001a.A().a("AdPersistenceFileService", th, CollectionUtils.map("error_message", "Persisted ad could not be retrieved: Deserialization failed"));
        }
    }

    private File a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new File(f7000b.getAbsolutePath() + UnityAdsConstants.DefaultUrls.AD_ASSET_PATH + aVar.d());
    }

    private void a(a aVar, com.applovin.impl.sdk.ad.b bVar, b bVar2) {
        if (bVar2 == null) {
            return;
        }
        this.f7001a.I();
        if (n.a()) {
            this.f7001a.I().a("AdPersistenceFileService", "Ad was persisted successfully");
        }
        bVar2.a(aVar);
        this.f7001a.g().a(y1.A, bVar);
    }

    private void a(String str, com.applovin.impl.sdk.ad.b bVar, b bVar2) {
        if (bVar2 == null) {
            return;
        }
        this.f7001a.I();
        if (n.a()) {
            this.f7001a.I().a("AdPersistenceFileService", str);
        }
        bVar2.a(null);
        Map mapB = a2.b(bVar);
        CollectionUtils.putStringIfValid("error_message", str, mapB);
        this.f7001a.g().d(y1.B, mapB);
    }

    public void a(List list) {
        File[] fileArrListFiles = f7000b.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        boolean z10 = false;
        for (File file : fileArrListFiles) {
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((a) it.next()).d().equals(file.getName())) {
                        z10 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z10) {
                file.delete();
            }
        }
    }

    public void a() {
        File[] fileArrListFiles;
        File file = f7000b;
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                file2.delete();
            }
        }
    }
}
