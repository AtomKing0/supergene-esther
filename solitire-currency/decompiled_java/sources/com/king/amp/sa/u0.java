package com.king.amp.sa;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.v8;
import com.king.amp.sa.v0;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: DownloadChunkExecutor.java */
/* JADX INFO: loaded from: classes4.dex */
public class u0 implements f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private ExecutorService f16978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private g1 f16979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private Map<String, Vector<v0>> f16980c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    AtomicBoolean f16981d = new AtomicBoolean(true);

    /* JADX INFO: compiled from: DownloadChunkExecutor.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16982a;

        static {
            int[] iArr = new int[v0.a.values().length];
            f16982a = iArr;
            try {
                iArr[v0.a.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16982a[v0.a.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16982a[v0.a.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: DownloadChunkExecutor.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f16983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f16984b;

        b(int i10, String str) {
            this.f16983a = i10;
            this.f16984b = str;
        }

        @NonNull
        public String toString() {
            return "{ error=" + this.f16983a + ", " + this.f16984b + "}";
        }
    }

    u0(@NonNull ExecutorService executorService, @NonNull g1 g1Var) {
        this.f16978a = null;
        this.f16978a = executorService;
        this.f16979b = g1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x019a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.king.amp.sa.u0.b c(@androidx.annotation.NonNull java.lang.String r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.amp.sa.u0.c(java.lang.String):com.king.amp.sa.u0$b");
    }

    private synchronized void e(@NonNull String str) {
        if (!this.f16980c.containsKey(str)) {
            Log.w("DownloadChunkExecutor", "Problem with removal, task [" + str + "] is not in list.");
            return;
        }
        Log.i("DownloadChunkExecutor", "Remove [" + str + v8.i.f15839e);
        Vector<v0> vector = this.f16980c.get(str);
        if (vector == null) {
            Log.w("DownloadChunkExecutor", "Problem with removal, task [" + str + "] is not in list.");
            return;
        }
        for (v0 v0Var : vector) {
            File file = new File(v0Var.a().f16960e);
            if (file.exists() && !file.delete()) {
                Log.w("DownloadChunkExecutor", "Failed to delete file: " + file.getAbsolutePath());
            }
            v0Var.c();
        }
        vector.removeAllElements();
        this.f16980c.remove(str);
    }

    @Override // com.king.amp.sa.f1
    public void a(@NonNull t0 t0Var, int i10, String str) throws Throwable {
        if (!this.f16981d.get()) {
            Log.w("DownloadChunkExecutor", "Unable to handle completion for " + t0Var.f16957b + ", stopped");
            return;
        }
        if (this.f16980c.isEmpty()) {
            Log.w("DownloadChunkExecutor", "Unable to handle completion " + t0Var.f16957b + ", tasks list is empty");
            return;
        }
        if (!this.f16980c.containsKey(t0Var.f16957b)) {
            Log.w("DownloadChunkExecutor", "Unable to handle completion, no tasks for " + t0Var.f16957b);
            return;
        }
        if (i10 != 0) {
            Log.w("DownloadChunkExecutor", "The task failed for " + t0Var.f16957b + " with error [" + i10 + ", " + str + "]. Stop, report and remove.");
            e(t0Var.f16957b);
            g1 g1Var = this.f16979b;
            if (g1Var != null) {
                g1Var.onHttpDownloadFailed(t0Var.f16957b, i10, str);
                return;
            }
            return;
        }
        Log.i("DownloadChunkExecutor", "Completion for " + t0Var);
        Vector<v0> vector = this.f16980c.get(t0Var.f16957b);
        if (vector == null) {
            Log.w("DownloadChunkExecutor", "Unable to handle completion, no tasks for " + t0Var.f16957b);
            return;
        }
        long j10 = 0;
        for (v0 v0Var : vector) {
            int i11 = a.f16982a[v0Var.b().ordinal()];
            if (i11 == 1 || i11 == 2) {
                return;
            }
            if (i11 == 3) {
                Log.e("DownloadChunkExecutor", "DownloadChunkTask FAILED: This should not happen!");
            }
            if (v0Var.a().f16965j > j10) {
                j10 = v0Var.a().f16965j;
            }
        }
        b bVarC = c(t0Var.f16957b);
        Log.i("DownloadChunkExecutor", "Longest chunk took " + j10 + "s to download.");
        e(t0Var.f16957b);
        if (bVarC == null) {
            g1 g1Var2 = this.f16979b;
            if (g1Var2 != null) {
                g1Var2.onHttpDownloadCompleted(t0Var.f16957b);
                return;
            }
            return;
        }
        g1 g1Var3 = this.f16979b;
        if (g1Var3 != null) {
            g1Var3.onHttpDownloadFailed(t0Var.f16957b, bVarC.f16983a, "Target file assembly failed. " + bVarC.f16984b);
        }
    }

    @Override // com.king.amp.sa.f1
    public void b(@NonNull String str, int i10, int i11) {
        if (!this.f16981d.get()) {
            Log.w("DownloadChunkExecutor", "Unable to handle data for " + str + ", stopped");
            return;
        }
        if (this.f16980c.isEmpty()) {
            Log.w("DownloadChunkExecutor", "Unable to handle data " + str + ", tasks list is empty");
            return;
        }
        if (this.f16980c.containsKey(str)) {
            g1 g1Var = this.f16979b;
            if (g1Var != null) {
                g1Var.onHttpDataReceived(str, i10, i11);
                return;
            }
            return;
        }
        Log.w("DownloadChunkExecutor", "Unable to handle data, no tasks for " + str);
    }

    public synchronized void d(@NonNull t0 t0Var) {
        Log.i("DownloadChunkExecutor", "Execute " + t0Var);
        if (!this.f16980c.containsKey(t0Var.f16957b)) {
            this.f16980c.put(t0Var.f16957b, new Vector<>());
        }
        Vector<v0> vector = this.f16980c.get(t0Var.f16957b);
        if (vector != null) {
            v0 v0Var = new v0(t0Var, this);
            vector.add(v0Var);
            this.f16978a.execute(v0Var);
        } else {
            Log.w("DownloadChunkExecutor", "Unable to find tasks for " + t0Var.f16957b);
        }
    }

    public void f() {
        Log.i("DownloadChunkExecutor", "Uninit");
        this.f16981d.set(false);
        Iterator<String> it = this.f16980c.keySet().iterator();
        while (it.hasNext()) {
            e(it.next());
        }
        this.f16980c.clear();
        this.f16979b = null;
        this.f16978a = null;
    }
}
