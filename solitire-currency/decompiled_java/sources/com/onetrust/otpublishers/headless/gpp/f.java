package com.onetrust.otpublishers.headless.gpp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f23798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f23799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f23800c;

    public f(ArrayList arrayList) {
        this.f23800c = arrayList;
        b();
    }

    public static String a(HashMap map, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (map.containsKey(str)) {
                sb.append((String) map.get(str));
            } else {
                com.onetrust.otpublishers.headless.Internal.Helper.d.a("encodeToBitString: field not found ", str, "GPPHeader", 6);
            }
        }
        return sb.toString();
    }

    public final void b() {
        HashMap map = new HashMap();
        this.f23798a = map;
        map.put("Id", g.a(3, 6));
        this.f23798a.put("Version", g.a(1, 6));
        HashMap map2 = this.f23798a;
        List<Integer> list = this.f23800c;
        Collections.sort(list);
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 < list.size()) {
            int i11 = i10;
            while (i11 < list.size() - 1) {
                int i12 = i11 + 1;
                if (list.get(i11).intValue() + 1 == list.get(i12).intValue()) {
                    i11 = i12;
                }
            }
            int i13 = i11 + 1;
            arrayList.add(list.subList(i10, i13));
            i10 = i13;
        }
        String strA = g.a(arrayList.size(), 12);
        int iIntValue = 0;
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            if (((List) arrayList.get(i14)).size() == 1) {
                int iIntValue2 = ((Integer) ((List) arrayList.get(i14)).get(0)).intValue() - iIntValue;
                iIntValue = ((Integer) ((List) arrayList.get(i14)).get(0)).intValue();
                strA = strA + "0" + b.a(iIntValue2);
            } else {
                int iIntValue3 = ((Integer) ((List) arrayList.get(i14)).get(0)).intValue() - iIntValue;
                int iIntValue4 = ((Integer) ((List) arrayList.get(i14)).get(((List) arrayList.get(i14)).size() - 1)).intValue() - ((Integer) ((List) arrayList.get(i14)).get(0)).intValue();
                iIntValue = ((Integer) ((List) arrayList.get(i14)).get(((List) arrayList.get(i14)).size() - 1)).intValue();
                strA = strA + "1" + b.a(iIntValue3) + b.a(iIntValue4);
            }
        }
        map2.put("SectionIds", strA);
        this.f23799b = new String[]{"Id", "Version", "SectionIds"};
    }
}
