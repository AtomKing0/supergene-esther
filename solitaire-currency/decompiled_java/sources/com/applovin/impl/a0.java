package com.applovin.impl;

import com.applovin.impl.g5;
import com.applovin.impl.i5;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a0 implements i5.b, g5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f4667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f4668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private y f4669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4670d;

    public interface a {
        void a(b bVar, String str);

        void a(y yVar, String str);
    }

    public enum b {
        APP_DETAILS_NOT_FOUND,
        INVALID_DEVELOPER_URI,
        APPADSTXT_NOT_FOUND,
        MISSING_APPLOVIN_ENTRIES,
        MISSING_NON_APPLOVIN_ENTRIES
    }

    public a0(com.applovin.impl.sdk.j jVar, a aVar) {
        this.f4667a = jVar;
        this.f4668b = aVar;
    }

    public void a() {
        y yVar = this.f4669c;
        if (yVar != null) {
            this.f4668b.a(yVar, this.f4670d);
        } else {
            this.f4667a.j0().a(new i5(this.f4667a, this));
        }
    }

    @Override // com.applovin.impl.i5.b
    public void a(String str) {
        this.f4667a.j0().a(new g5(this.f4667a, str, this));
    }

    @Override // com.applovin.impl.i5.b
    public void a(b bVar) {
        this.f4668b.a(bVar, (String) null);
    }

    @Override // com.applovin.impl.g5.b
    public void a(String str, String str2) {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        for (String str3 : str.split("\n")) {
            String strTrim = str3.split("#", 2)[0].trim();
            if (StringUtils.isValidString(strTrim)) {
                z zVar = new z(strTrim, i10);
                if (zVar.h()) {
                    String strB = zVar.b();
                    List arrayList2 = map.containsKey(strB) ? (List) map.get(strB) : new ArrayList();
                    if (arrayList2 != null) {
                        arrayList2.add(zVar);
                        map.put(strB, arrayList2);
                    }
                } else {
                    arrayList.add(zVar);
                }
            }
            i10++;
        }
        this.f4669c = new y(map, arrayList);
        this.f4670d = str2;
        this.f4667a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f4667a.I().a("AppAdsTxtService", "app-ads.txt fetched: " + this.f4669c);
        }
        this.f4668b.a(this.f4669c, str2);
    }

    @Override // com.applovin.impl.g5.b
    public void a(b bVar, String str) {
        this.f4668b.a(bVar, str);
    }
}
