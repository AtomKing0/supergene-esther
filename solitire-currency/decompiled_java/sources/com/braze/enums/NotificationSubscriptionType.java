package com.braze.enums;

import com.braze.models.IPutIntoJson;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import n9.o;

/* JADX INFO: loaded from: classes2.dex */
public enum NotificationSubscriptionType implements IPutIntoJson<String> {
    OPTED_IN("opted_in"),
    SUBSCRIBED("subscribed"),
    UNSUBSCRIBED("unsubscribed");

    public static final Companion Companion = new Companion(null);
    private static final Map<String, NotificationSubscriptionType> map;
    private final String key;

    public static final class Companion {
        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final NotificationSubscriptionType fromValue(String str) {
            String lowerCase;
            Map map = NotificationSubscriptionType.map;
            if (str != null) {
                Locale US = Locale.US;
                t.h(US, "US");
                lowerCase = str.toLowerCase(US);
                t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase == null) {
                lowerCase = "";
            }
            Object obj = map.get(lowerCase);
            return (NotificationSubscriptionType) (obj != null ? obj : null);
        }

        private Companion() {
        }
    }

    static {
        NotificationSubscriptionType[] notificationSubscriptionTypeArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(o.e(q0.d(notificationSubscriptionTypeArrValues.length), 16));
        for (NotificationSubscriptionType notificationSubscriptionType : notificationSubscriptionTypeArrValues) {
            linkedHashMap.put(notificationSubscriptionType.key, notificationSubscriptionType);
        }
        map = linkedHashMap;
    }

    NotificationSubscriptionType(String str) {
        this.key = str;
    }

    @Override // com.braze.models.IPutIntoJson
    public String forJsonPut() {
        return this.key;
    }
}
