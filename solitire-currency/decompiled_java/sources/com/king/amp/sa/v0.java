package com.king.amp.sa;

import android.util.Log;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: DownloadChunkTask.java */
/* JADX INFO: loaded from: classes4.dex */
public class v0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private t0 f16998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f1 f16999b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f17001d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f17002e = a.IDLE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f17000c = java.util.UUID.randomUUID().toString();

    /* JADX INFO: compiled from: DownloadChunkTask.java */
    public enum a {
        IDLE,
        LOADING,
        FAILED,
        READY
    }

    public v0(@NonNull t0 t0Var, @NonNull f1 f1Var) {
        this.f16999b = f1Var;
        this.f16998a = t0Var;
    }

    public t0 a() {
        return this.f16998a;
    }

    public a b() {
        return this.f17002e;
    }

    public void c() {
        if (this.f17001d) {
            Log.i("DownloadChunkTask", "Stop downloader for " + this.f16998a);
            this.f17001d = false;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != v0.class) {
            return false;
        }
        return ((v0) obj).f17000c.equals(this.f17000c);
    }

    public int hashCode() {
        return this.f17000c.hashCode();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:24|(8:341|25|(3:343|27|(1:29))|43|333|44|45|(2:349|46))|(4:352|49|(10:51|52|339|53|(3:356|55|56)(1:57)|283|284|(1:286)|287|288)(1:355)|47)|354|88|(5:347|90|91|337|92)(1:118)|324|119|(2:310|124)|128|283|284|(0)|287|288) */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0256, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0257, code lost:
    
        android.util.Log.w(r7, "Unable to close output stream", r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:217:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x03eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x036f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0364 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0391 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:314:0x03f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x042a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x039c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x041f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x03ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0337 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0342 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x03bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:357:? A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1081
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.amp.sa.v0.run():void");
    }
}
