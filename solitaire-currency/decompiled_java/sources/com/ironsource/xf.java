package com.ironsource;

import android.util.Log;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.vp;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class xf {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static xf f16187b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private vb f16188a;

    private xf() {
    }

    private static xf a() {
        if (f16187b == null) {
            f16187b = new xf();
        }
        return f16187b;
    }

    public static void a(pb pbVar, vf vfVar) {
        if (pbVar != null) {
            try {
                a().f16188a = new vb(pbVar, vfVar);
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
        }
    }

    public static void a(vp.a aVar) {
        a(aVar, new HashMap());
    }

    public static void a(vp.a aVar, Map<String, Object> map) {
        vb vbVar = a().f16188a;
        if (vbVar == null) {
            Log.d(nb.f14103a, nb.U);
            return;
        }
        if (map != null) {
            map.put("eventid", Integer.valueOf(aVar.f15960b));
        }
        vbVar.a(aVar.f15959a, map);
    }
}
