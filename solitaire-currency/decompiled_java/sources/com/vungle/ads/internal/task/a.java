package com.vungle.ads.internal.task;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.util.q;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.n;
import v8.p;

/* JADX INFO: compiled from: CleanupJob.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.vungle.ads.internal.task.b {

    @NotNull
    private static final String AD_ID_KEY = "AD_ID_KEY";

    @NotNull
    public static final C0531a Companion = new C0531a(null);

    @NotNull
    public static final String TAG = "CleanupJob";

    @NotNull
    private final Context context;

    @NotNull
    private final q pathProvider;

    /* JADX INFO: renamed from: com.vungle.ads.internal.task.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CleanupJob.kt */
    public static final class C0531a {
        private C0531a() {
        }

        public /* synthetic */ C0531a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public static /* synthetic */ d makeJobInfo$default(C0531a c0531a, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = null;
            }
            return c0531a.makeJobInfo(str);
        }

        @NotNull
        public final d makeJobInfo(@Nullable String str) {
            d priority = new d(a.TAG).setPriority(0);
            Bundle bundle = new Bundle();
            if (str != null) {
                bundle.putString(a.AD_ID_KEY, str);
            }
            return priority.setExtras(bundle).setUpdateCurrent(str == null);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class b extends v implements h9.a<com.vungle.ads.internal.persistence.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.persistence.b, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.persistence.b invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.persistence.b.class);
        }
    }

    public a(@NotNull Context context, @NotNull q pathProvider) {
        t.i(context, "context");
        t.i(pathProvider, "pathProvider");
        this.context = context;
        this.pathProvider = pathProvider;
    }

    private final void checkIfSdkUpgraded() {
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        v8.l lVarB = n.b(p.f35201a, new b(this.context));
        int i10 = m4103checkIfSdkUpgraded$lambda3(lVarB).getInt("VERSION_CODE", -1);
        if (i10 < 70402) {
            if (i10 < 70000) {
                dropV6Data();
            }
            if (i10 < 70100) {
                dropV700Data();
            }
            if (i10 < 70301) {
                dropV730TempData();
            }
            m4103checkIfSdkUpgraded$lambda3(lVarB).put("VERSION_CODE", 70402).apply();
        }
    }

    /* JADX INFO: renamed from: checkIfSdkUpgraded$lambda-3, reason: not valid java name */
    private static final com.vungle.ads.internal.persistence.b m4103checkIfSdkUpgraded$lambda3(v8.l<com.vungle.ads.internal.persistence.b> lVar) {
        return lVar.getValue();
    }

    private final void dropV6Data() {
        com.vungle.ads.internal.util.p.Companion.d(TAG, "CleanupJob: drop old files data");
        int i10 = Build.VERSION.SDK_INT;
        File file = new File(this.context.getNoBackupFilesDir(), "vungle_db");
        if (file.exists()) {
            com.vungle.ads.internal.util.i.delete(file);
            com.vungle.ads.internal.util.i.delete(new File(file.getPath() + "-journal"));
        } else {
            this.context.deleteDatabase("vungle_db");
        }
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("com.vungle.sdk", 0);
        String string = sharedPreferences.getString("cache_path", null);
        if (i10 >= 24) {
            this.context.deleteSharedPreferences("com.vungle.sdk");
        } else {
            sharedPreferences.edit().clear().apply();
        }
        File noBackupFilesDir = this.context.getNoBackupFilesDir();
        t.h(noBackupFilesDir, "{\n            context.noBackupFilesDir\n        }");
        com.vungle.ads.internal.util.i.delete(new File(noBackupFilesDir, "vungle_settings"));
        if (string != null) {
            com.vungle.ads.internal.util.i.delete(new File(string));
        }
    }

    private final void dropV700Data() {
        com.vungle.ads.internal.util.i.delete(new File(this.context.getApplicationInfo().dataDir, "vungle"));
    }

    private final void dropV730TempData() {
        try {
            com.vungle.ads.internal.util.i.delete(new File(this.pathProvider.getSharedPrefsDir(), "vungleSettings"));
            com.vungle.ads.internal.util.i.delete(new File(this.pathProvider.getSharedPrefsDir(), "failedTpatSet"));
        } catch (Exception e10) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "Failed to delete temp data", e10);
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final q getPathProvider() {
        return this.pathProvider;
    }

    @Override // com.vungle.ads.internal.task.b
    public int onRunJob(@NotNull Bundle bundle, @NotNull f jobRunner) {
        File downloadsDirForAd;
        t.i(bundle, "bundle");
        t.i(jobRunner, "jobRunner");
        File downloadDir = this.pathProvider.getDownloadDir();
        String string = bundle.getString(AD_ID_KEY);
        if (string == null || (downloadsDirForAd = this.pathProvider.getDownloadsDirForAd(string)) == null) {
            downloadsDirForAd = downloadDir;
        }
        com.vungle.ads.internal.util.p.Companion.d(TAG, "CleanupJob: Current directory snapshot");
        try {
            if (!t.d(downloadsDirForAd, downloadDir)) {
                com.vungle.ads.internal.util.i.delete(downloadsDirForAd);
                return 0;
            }
            checkIfSdkUpgraded();
            com.vungle.ads.internal.util.i.deleteContents(downloadsDirForAd);
            return 0;
        } catch (IOException unused) {
            return 1;
        }
    }
}
