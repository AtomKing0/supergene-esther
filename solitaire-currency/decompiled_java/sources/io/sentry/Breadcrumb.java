package io.sentry;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.webkit.ProxyConfig;
import com.applovin.sdk.AppLovinEventTypes;
import io.sentry.SentryLevel;
import io.sentry.protocol.Response;
import io.sentry.util.n0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Breadcrumb implements h2, Comparable<Breadcrumb> {

    @Nullable
    private String category;

    @NotNull
    private Map<String, Object> data;

    @Nullable
    private SentryLevel level;

    @Nullable
    private String message;

    @NotNull
    private final Long nanos;

    @Nullable
    private String origin;

    @Nullable
    private Date timestamp;

    @Nullable
    private final Long timestampMs;

    @Nullable
    private String type;

    @Nullable
    private Map<String, Object> unknown;

    public static final class a implements x1<Breadcrumb> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Breadcrumb deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            Date dateD = n.d();
            Map concurrentHashMap = new ConcurrentHashMap();
            String strO0 = null;
            String strO02 = null;
            String strO03 = null;
            String strO04 = null;
            SentryLevel sentryLevelDeserialize = null;
            ConcurrentHashMap concurrentHashMap2 = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "origin":
                        strO04 = l3Var.o0();
                        break;
                    case "data":
                        Map mapB = io.sentry.util.c.b((Map) l3Var.A0());
                        if (mapB == null) {
                            break;
                        } else {
                            concurrentHashMap = mapB;
                            break;
                        }
                        break;
                    case "type":
                        strO02 = l3Var.o0();
                        break;
                    case "category":
                        strO03 = l3Var.o0();
                        break;
                    case "timestamp":
                        Date dateF = l3Var.F(w0Var);
                        if (dateF == null) {
                            break;
                        } else {
                            dateD = dateF;
                            break;
                        }
                        break;
                    case "level":
                        try {
                            sentryLevelDeserialize = new SentryLevel.a().deserialize(l3Var, w0Var);
                            break;
                        } catch (Exception e10) {
                            w0Var.a(SentryLevel.ERROR, e10, "Error when deserializing SentryLevel", new Object[0]);
                            break;
                        }
                        break;
                    case "message":
                        strO0 = l3Var.o0();
                        break;
                    default:
                        if (concurrentHashMap2 == null) {
                            concurrentHashMap2 = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap2, strC);
                        break;
                }
            }
            Breadcrumb breadcrumb = new Breadcrumb(dateD);
            breadcrumb.message = strO0;
            breadcrumb.type = strO02;
            breadcrumb.data = concurrentHashMap;
            breadcrumb.category = strO03;
            breadcrumb.origin = strO04;
            breadcrumb.level = sentryLevelDeserialize;
            breadcrumb.setUnknown(concurrentHashMap2);
            l3Var.k();
            return breadcrumb;
        }
    }

    public Breadcrumb(@NotNull Date date) {
        this.data = new ConcurrentHashMap();
        this.nanos = Long.valueOf(System.nanoTime());
        this.timestamp = date;
        this.timestampMs = null;
    }

    @NotNull
    public static Breadcrumb debug(@NotNull String str) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("debug");
        breadcrumb.setMessage(str);
        breadcrumb.setLevel(SentryLevel.DEBUG);
        return breadcrumb;
    }

    @NotNull
    public static Breadcrumb error(@NotNull String str) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("error");
        breadcrumb.setMessage(str);
        breadcrumb.setLevel(SentryLevel.ERROR);
        return breadcrumb;
    }

    public static Breadcrumb fromMap(@NotNull Map<String, Object> map, @NotNull SentryOptions sentryOptions) {
        Object value;
        Date dateA;
        Date dateD = n.d();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        SentryLevel sentryLevelValueOf = null;
        ConcurrentHashMap concurrentHashMap2 = null;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            value = entry.getValue();
            String key = entry.getKey();
            key.hashCode();
            switch (key) {
                case "origin":
                    if (!(value instanceof String)) {
                        str4 = null;
                        break;
                    } else {
                        str4 = (String) value;
                        break;
                    }
                    break;
                case "data":
                    Map map2 = value instanceof Map ? (Map) value : null;
                    if (map2 == null) {
                        break;
                    } else {
                        for (Map.Entry entry2 : map2.entrySet()) {
                            if (!(entry2.getKey() instanceof String) || entry2.getValue() == null) {
                                sentryOptions.getLogger().c(SentryLevel.WARNING, "Invalid key or null value in data map.", new Object[0]);
                            } else {
                                concurrentHashMap.put((String) entry2.getKey(), entry2.getValue());
                            }
                        }
                        break;
                    }
                    break;
                case "type":
                    if (!(value instanceof String)) {
                        str2 = null;
                        break;
                    } else {
                        str2 = (String) value;
                        break;
                    }
                    break;
                case "category":
                    if (!(value instanceof String)) {
                        str3 = null;
                        break;
                    } else {
                        str3 = (String) value;
                        break;
                    }
                    break;
                case "timestamp":
                    if ((value instanceof String) && (dateA = k3.a((String) value, sentryOptions.getLogger())) != null) {
                        dateD = dateA;
                        break;
                    } else {
                        break;
                    }
                    break;
                case "level":
                    String str5 = value instanceof String ? (String) value : null;
                    if (str5 == null) {
                        break;
                    } else {
                        try {
                            sentryLevelValueOf = SentryLevel.valueOf(str5.toUpperCase(Locale.ROOT));
                        } catch (Exception unused) {
                        }
                        break;
                    }
                    break;
                case "message":
                    if (!(value instanceof String)) {
                        str = null;
                        break;
                    } else {
                        str = (String) value;
                        break;
                    }
                    break;
                default:
                    if (concurrentHashMap2 == null) {
                        concurrentHashMap2 = new ConcurrentHashMap();
                    }
                    concurrentHashMap2.put(entry.getKey(), entry.getValue());
                    break;
            }
        }
        Breadcrumb breadcrumb = new Breadcrumb(dateD);
        breadcrumb.message = str;
        breadcrumb.type = str2;
        breadcrumb.data = concurrentHashMap;
        breadcrumb.category = str3;
        breadcrumb.origin = str4;
        breadcrumb.level = sentryLevelValueOf;
        breadcrumb.setUnknown(concurrentHashMap2);
        return breadcrumb;
    }

    @NotNull
    public static Breadcrumb graphqlDataFetcher(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("graphql");
        breadcrumb.setCategory("graphql.fetcher");
        if (str != null) {
            breadcrumb.setData("path", str);
        }
        if (str2 != null) {
            breadcrumb.setData("field", str2);
        }
        if (str3 != null) {
            breadcrumb.setData("type", str3);
        }
        if (str4 != null) {
            breadcrumb.setData("object_type", str4);
        }
        return breadcrumb;
    }

    @NotNull
    public static Breadcrumb graphqlDataLoader(@NotNull Iterable<?> iterable, @Nullable Class<?> cls, @Nullable Class<?> cls2, @Nullable String str) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("graphql");
        breadcrumb.setCategory("graphql.data_loader");
        ArrayList arrayList = new ArrayList();
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        breadcrumb.setData("keys", arrayList);
        if (cls != null) {
            breadcrumb.setData("key_type", cls.getName());
        }
        if (cls2 != null) {
            breadcrumb.setData("value_type", cls2.getName());
        }
        if (str != null) {
            breadcrumb.setData("name", str);
        }
        return breadcrumb;
    }

    @NotNull
    public static Breadcrumb graphqlOperation(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("graphql");
        if (str != null) {
            breadcrumb.setData("operation_name", str);
        }
        if (str2 != null) {
            breadcrumb.setData("operation_type", str2);
            breadcrumb.setCategory(str2);
        } else {
            breadcrumb.setCategory("graphql.operation");
        }
        if (str3 != null) {
            breadcrumb.setData("operation_id", str3);
        }
        return breadcrumb;
    }

    @NotNull
    public static Breadcrumb http(@NotNull String str, @NotNull String str2) {
        Breadcrumb breadcrumb = new Breadcrumb();
        n0.a aVarC = io.sentry.util.n0.c(str);
        breadcrumb.setType(ProxyConfig.MATCH_HTTP);
        breadcrumb.setCategory(ProxyConfig.MATCH_HTTP);
        if (aVarC.c() != null) {
            breadcrumb.setData("url", aVarC.c());
        }
        breadcrumb.setData("method", str2.toUpperCase(Locale.ROOT));
        if (aVarC.b() != null) {
            breadcrumb.setData("http.query", aVarC.b());
        }
        if (aVarC.a() != null) {
            breadcrumb.setData("http.fragment", aVarC.a());
        }
        return breadcrumb;
    }

    @NotNull
    public static Breadcrumb info(@NotNull String str) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("info");
        breadcrumb.setMessage(str);
        breadcrumb.setLevel(SentryLevel.INFO);
        return breadcrumb;
    }

    @Nullable
    private static SentryLevel levelFromHttpStatusCode(@NotNull Integer num) {
        if (io.sentry.util.n.a(num.intValue())) {
            return SentryLevel.WARNING;
        }
        if (io.sentry.util.n.b(num.intValue())) {
            return SentryLevel.ERROR;
        }
        return null;
    }

    @NotNull
    public static Breadcrumb navigation(@NotNull String str, @NotNull String str2) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setCategory(NotificationCompat.CATEGORY_NAVIGATION);
        breadcrumb.setType(NotificationCompat.CATEGORY_NAVIGATION);
        breadcrumb.setData(TypedValues.TransitionType.S_FROM, str);
        breadcrumb.setData(TypedValues.TransitionType.S_TO, str2);
        return breadcrumb;
    }

    @NotNull
    public static Breadcrumb query(@NotNull String str) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("query");
        breadcrumb.setMessage(str);
        return breadcrumb;
    }

    @NotNull
    public static Breadcrumb transaction(@NotNull String str) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("default");
        breadcrumb.setCategory("sentry.transaction");
        breadcrumb.setMessage(str);
        return breadcrumb;
    }

    @NotNull
    public static Breadcrumb ui(@NotNull String str, @NotNull String str2) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("default");
        breadcrumb.setCategory("ui." + str);
        breadcrumb.setMessage(str2);
        return breadcrumb;
    }

    @NotNull
    public static Breadcrumb user(@NotNull String str, @NotNull String str2) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("user");
        breadcrumb.setCategory(str);
        breadcrumb.setMessage(str2);
        return breadcrumb;
    }

    @NotNull
    public static Breadcrumb userInteraction(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        return userInteraction(str, str2, str3, Collections.emptyMap());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Breadcrumb.class != obj.getClass()) {
            return false;
        }
        Breadcrumb breadcrumb = (Breadcrumb) obj;
        return getTimestamp().getTime() == breadcrumb.getTimestamp().getTime() && io.sentry.util.w.a(this.message, breadcrumb.message) && io.sentry.util.w.a(this.type, breadcrumb.type) && io.sentry.util.w.a(this.category, breadcrumb.category) && io.sentry.util.w.a(this.origin, breadcrumb.origin) && this.level == breadcrumb.level;
    }

    @Nullable
    public String getCategory() {
        return this.category;
    }

    @ApiStatus.Internal
    @NotNull
    public Map<String, Object> getData() {
        return this.data;
    }

    @Nullable
    public SentryLevel getLevel() {
        return this.level;
    }

    @Nullable
    public String getMessage() {
        return this.message;
    }

    @Nullable
    public String getOrigin() {
        return this.origin;
    }

    @NotNull
    public Date getTimestamp() {
        Date date = this.timestamp;
        if (date != null) {
            return (Date) date.clone();
        }
        Long l10 = this.timestampMs;
        if (l10 == null) {
            throw new IllegalStateException("No timestamp set for breadcrumb");
        }
        Date dateE = n.e(l10.longValue());
        this.timestamp = dateE;
        return dateE;
    }

    @Nullable
    public String getType() {
        return this.type;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public int hashCode() {
        return io.sentry.util.w.b(this.timestamp, this.message, this.type, this.category, this.origin, this.level);
    }

    public void removeData(@Nullable String str) {
        if (str == null) {
            return;
        }
        this.data.remove(str);
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("timestamp").o(w0Var, getTimestamp());
        if (this.message != null) {
            m3Var.e("message").g(this.message);
        }
        if (this.type != null) {
            m3Var.e("type").g(this.type);
        }
        m3Var.e("data").o(w0Var, this.data);
        if (this.category != null) {
            m3Var.e("category").g(this.category);
        }
        if (this.origin != null) {
            m3Var.e("origin").g(this.origin);
        }
        if (this.level != null) {
            m3Var.e(AppLovinEventTypes.USER_COMPLETED_LEVEL).o(w0Var, this.level);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.unknown.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    public void setCategory(@Nullable String str) {
        this.category = str;
    }

    public void setData(@Nullable String str, @Nullable Object obj) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            removeData(str);
        } else {
            this.data.put(str, obj);
        }
    }

    public void setLevel(@Nullable SentryLevel sentryLevel) {
        this.level = sentryLevel;
    }

    public void setMessage(@Nullable String str) {
        this.message = str;
    }

    public void setOrigin(@Nullable String str) {
        this.origin = str;
    }

    public void setType(@Nullable String str) {
        this.type = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    @NotNull
    public static Breadcrumb userInteraction(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull Map<String, Object> map) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("user");
        breadcrumb.setCategory("ui." + str);
        if (str2 != null) {
            breadcrumb.setData("view.id", str2);
        }
        if (str3 != null) {
            breadcrumb.setData("view.class", str3);
        }
        if (str4 != null) {
            breadcrumb.setData("view.tag", str4);
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            breadcrumb.getData().put(entry.getKey(), entry.getValue());
        }
        breadcrumb.setLevel(SentryLevel.INFO);
        return breadcrumb;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull Breadcrumb breadcrumb) {
        return this.nanos.compareTo(breadcrumb.nanos);
    }

    @Nullable
    public Object getData(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.data.get(str);
    }

    public Breadcrumb(long j10) {
        this.data = new ConcurrentHashMap();
        this.nanos = Long.valueOf(System.nanoTime());
        this.timestampMs = Long.valueOf(j10);
        this.timestamp = null;
    }

    Breadcrumb(@NotNull Breadcrumb breadcrumb) {
        this.data = new ConcurrentHashMap();
        this.nanos = Long.valueOf(System.nanoTime());
        this.timestamp = breadcrumb.timestamp;
        this.timestampMs = breadcrumb.timestampMs;
        this.message = breadcrumb.message;
        this.type = breadcrumb.type;
        this.category = breadcrumb.category;
        this.origin = breadcrumb.origin;
        Map<String, Object> mapB = io.sentry.util.c.b(breadcrumb.data);
        if (mapB != null) {
            this.data = mapB;
        }
        this.unknown = io.sentry.util.c.b(breadcrumb.unknown);
        this.level = breadcrumb.level;
    }

    @NotNull
    public static Breadcrumb userInteraction(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull Map<String, Object> map) {
        return userInteraction(str, str2, str3, null, map);
    }

    @NotNull
    public static Breadcrumb http(@NotNull String str, @NotNull String str2, @Nullable Integer num) {
        Breadcrumb breadcrumbHttp = http(str, str2);
        if (num != null) {
            breadcrumbHttp.setData(Response.JsonKeys.STATUS_CODE, num);
            breadcrumbHttp.setLevel(levelFromHttpStatusCode(num));
        }
        return breadcrumbHttp;
    }

    public Breadcrumb() {
        this(System.currentTimeMillis());
    }

    public Breadcrumb(@Nullable String str) {
        this();
        this.message = str;
    }
}
