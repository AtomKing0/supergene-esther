package com.applovin.impl.sdk;

import com.applovin.impl.l4;
import com.applovin.impl.sdk.g;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.z6;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NativeCrashReporter implements g.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f6899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f6900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final NativeCrashReporter f6901c = new NativeCrashReporter();

    private NativeCrashReporter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(g.b bVar) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "ad_unit_id", bVar.a());
        JsonUtils.putString(jSONObject, "ad_format", bVar.g());
        JsonUtils.putString(jSONObject, "network_name", bVar.c());
        JsonUtils.putString(jSONObject, "adapter_class", bVar.b());
        JsonUtils.putString(jSONObject, "adapter_version", bVar.d());
        JsonUtils.putString(jSONObject, "bcode", bVar.e());
        JsonUtils.putString(jSONObject, "creative_id", bVar.f());
        JsonUtils.putString(jSONObject, "operation", bVar.i().toString());
        updateAdInfo(bVar.h(), jSONObject.toString());
    }

    private native void disable();

    private native void enable(String str, int[] iArr, boolean z10);

    private native void removeAdInfo(int i10);

    private native void updateAdInfo(int i10, String str);

    public static void a(j jVar) {
        if (jVar == null) {
            return;
        }
        if (!((Boolean) jVar.a(l4.f5596a4)).booleanValue() && !z6.i(j.n())) {
            if (f6900b) {
                try {
                    g gVarL = jVar.l();
                    NativeCrashReporter nativeCrashReporter = f6901c;
                    gVarL.a(nativeCrashReporter);
                    nativeCrashReporter.disable();
                    return;
                } catch (Throwable th) {
                    jVar.I();
                    if (n.a()) {
                        jVar.I().a("NativeCrashReporter", "Failed to disable native crash reporter", th);
                    }
                    jVar.A().a("NativeCrashReporter", "disableInstance", th);
                    return;
                }
            }
            return;
        }
        if (a()) {
            List listC = jVar.c(l4.f5603b4);
            int[] iArr = new int[listC.size()];
            for (int i10 = 0; i10 < listC.size(); i10++) {
                try {
                    iArr[i10] = Integer.parseInt((String) listC.get(i10));
                } catch (NumberFormatException unused) {
                }
            }
            File file = new File(j.n().getCacheDir(), "al-reports");
            if (file.exists()) {
                a(file, jVar);
            } else if (!file.mkdir()) {
                jVar.I();
                if (n.a()) {
                    jVar.I().b("NativeCrashReporter", "Failed to create reports directory");
                    return;
                }
                return;
            }
            try {
                NativeCrashReporter nativeCrashReporter2 = f6901c;
                nativeCrashReporter2.enable(file.getAbsolutePath(), iArr, ((Boolean) jVar.a(l4.f5611c4)).booleanValue());
                HashSet hashSet = new HashSet();
                hashSet.add(g.c.LOADING);
                hashSet.add(g.c.LOAD);
                hashSet.add(g.c.SHOW);
                hashSet.add(g.c.CLICK);
                hashSet.add(g.c.SHOW_ERROR);
                hashSet.add(g.c.DESTROY);
                jVar.l().a(nativeCrashReporter2, hashSet);
            } catch (Throwable th2) {
                jVar.I();
                if (n.a()) {
                    jVar.I().a("NativeCrashReporter", "Failed to enable native crash reporter", th2);
                }
                jVar.A().a("NativeCrashReporter", "enableInstance", th2);
            }
        }
    }

    private static boolean a() {
        if (!f6899a) {
            f6899a = true;
            try {
                System.loadLibrary("applovin-native-crash-reporter");
                f6900b = true;
            } catch (Throwable th) {
                n.b("NativeCrashReporter", "Failed to load native crash reporter library", th);
            }
        }
        return f6900b;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.io.File r16, com.applovin.impl.sdk.j r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.NativeCrashReporter.a(java.io.File, com.applovin.impl.sdk.j):void");
    }

    @Override // com.applovin.impl.sdk.g.d
    public void a(final g.b bVar) {
        if (bVar.i() == g.c.DESTROY) {
            removeAdInfo(bVar.h());
        } else {
            z6.a(new Runnable() { // from class: com.applovin.impl.sdk.z
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7385a.b(bVar);
                }
            });
        }
    }
}
