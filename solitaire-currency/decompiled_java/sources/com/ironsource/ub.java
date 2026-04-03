package com.ironsource;

import android.util.Pair;
import com.ironsource.he;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class ub implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15577e = "Content-Type";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f15578f = "application/json";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private he f15579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f15580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f15581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList<kb> f15582d;

    public ub(he heVar, String str, String str2, ArrayList<kb> arrayList) {
        this.f15579a = heVar;
        this.f15580b = str;
        this.f15581c = str2;
        this.f15582d = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        he.a aVarA;
        he.a aVar = new he.a(this.f15582d);
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair("Content-Type", "application/json"));
            vo voVarB = ff.b(this.f15581c, this.f15580b, arrayList);
            aVarA = aVar.a(voVarB.a()).a(voVarB.f15931a);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("EventsSender failed to send events - " + e10.getLocalizedMessage());
            aVarA = aVar.a(e10 instanceof ym).a(e10);
        }
        he heVar = this.f15579a;
        if (heVar != null) {
            heVar.a(aVarA);
        }
    }
}
