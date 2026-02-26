package com.braze.support;

import bo.app.d00;
import com.braze.support.BrazeLogger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.collections.q0;
import kotlin.jvm.internal.t;
import p9.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8121a = BrazeLogger.INSTANCE.getBrazeLogTag("HttpUtils");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f8122b = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);

    public static final Long a(String str) {
        Long lValueOf;
        try {
            Double dI = o.i(str);
            if (dI != null) {
                lValueOf = Long.valueOf((long) (dI.doubleValue() * 1000));
            } else {
                Date date = f8122b.parse(str);
                if (date == null) {
                    return null;
                }
                lValueOf = Long.valueOf(date.getTime() - DateTimeUtils.nowInMilliseconds());
            }
            return lValueOf;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f8121a, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new d00(str), 8, (Object) null);
            return null;
        }
    }

    public static final LinkedHashMap a(Map map) {
        t.i(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (((String) entry.getKey()) != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(q0.d(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            t.f(key);
            Locale US = Locale.US;
            t.h(US, "US");
            String lowerCase = ((String) key).toLowerCase(US);
            t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            linkedHashMap2.put(lowerCase, entry2.getValue());
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(q0.d(linkedHashMap2.size()));
        for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
            linkedHashMap3.put(entry3.getKey(), d0.r0((Iterable) entry3.getValue(), null, null, null, 0, null, null, 63, null));
        }
        return linkedHashMap3;
    }
}
