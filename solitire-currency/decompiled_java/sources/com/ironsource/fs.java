package com.ironsource;

import android.os.Handler;
import android.os.Message;
import com.ironsource.sdk.utils.IronSourceStorageUtils;

/* JADX INFO: loaded from: classes4.dex */
class fs implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f12172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final oa f12173b;

    fs(oa oaVar, Handler handler) {
        this.f12173b = oaVar;
        this.f12172a = handler;
    }

    Message a() {
        return new Message();
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        int iB;
        zf zfVar = new zf(this.f12173b.b().getParent(), this.f12173b.b().getName());
        Message messageA = a();
        messageA.obj = zfVar;
        String strA = a(zfVar.getParent());
        if (strA == null) {
            iB = 1020;
        } else {
            pa paVarCall = a(new oa(zfVar, this.f12173b.e(), this.f12173b.a(), this.f12173b.c(), this.f12173b.f(), this.f12173b.d()), strA, 3L).call();
            iB = paVarCall.b() == 200 ? 1016 : paVarCall.b();
        }
        messageA.what = iB;
        this.f12172a.sendMessage(messageA);
    }

    jc a(oa oaVar, String str, long j10) {
        return new jc(oaVar, str, j10);
    }

    String a(String str) {
        return IronSourceStorageUtils.makeDir(str);
    }
}
