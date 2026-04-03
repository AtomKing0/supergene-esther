package com.ironsource;

import android.app.Activity;
import android.content.Context;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.qf;

/* JADX INFO: loaded from: classes4.dex */
public class n5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static n5 f14077a;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14078a;

        static {
            int[] iArr = new int[qf.a.values().length];
            f14078a = iArr;
            try {
                iArr[qf.a.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14078a[qf.a.Device.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14078a[qf.a.Controller.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static n5 a() {
        n5 n5Var = f14077a;
        return n5Var == null ? new n5() : n5Var;
    }

    public boolean a(Activity activity) {
        if (a.f14078a[dj.e().b().ordinal()] != 3) {
            return false;
        }
        try {
            com.ironsource.sdk.controller.v vVar = (com.ironsource.sdk.controller.v) qi.a((Context) activity).a().j();
            if (vVar == null) {
                return true;
            }
            vVar.k("back");
            return true;
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return false;
        }
    }
}
