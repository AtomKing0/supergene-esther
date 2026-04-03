package io.sentry.protocol;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.protocol.Geo;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class User implements h2 {

    @Nullable
    private Map<String, String> data;

    @Nullable
    private String email;

    @Nullable
    private Geo geo;

    @Nullable
    private String id;

    @Nullable
    private String ipAddress;

    @Deprecated
    @Nullable
    private String name;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private String username;

    public static final class Deserializer implements x1<User> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public User deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            User user = new User();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "username":
                        user.username = l3Var.o0();
                        break;
                    case "id":
                        user.id = l3Var.o0();
                        break;
                    case "geo":
                        user.geo = new Geo.Deserializer().deserialize(l3Var, w0Var);
                        break;
                    case "data":
                        user.data = io.sentry.util.c.b((Map) l3Var.A0());
                        break;
                    case "name":
                        user.name = l3Var.o0();
                        break;
                    case "email":
                        user.email = l3Var.o0();
                        break;
                    case "ip_address":
                        user.ipAddress = l3Var.o0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            user.setUnknown(concurrentHashMap);
            l3Var.k();
            return user;
        }
    }

    public static final class JsonKeys {
        public static final String DATA = "data";
        public static final String EMAIL = "email";
        public static final String GEO = "geo";
        public static final String ID = "id";
        public static final String IP_ADDRESS = "ip_address";
        public static final String NAME = "name";
        public static final String USERNAME = "username";
    }

    public User() {
    }

    public User(@NotNull User user) {
        this.email = user.email;
        this.username = user.username;
        this.id = user.id;
        this.ipAddress = user.ipAddress;
        this.name = user.name;
        this.geo = user.geo;
        this.data = io.sentry.util.c.b(user.data);
        this.unknown = io.sentry.util.c.b(user.unknown);
    }

    public static User fromMap(@NotNull Map<String, Object> map, @NotNull SentryOptions sentryOptions) {
        Object value;
        User user = new User();
        ConcurrentHashMap concurrentHashMap = null;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            value = entry.getValue();
            String key = entry.getKey();
            key.hashCode();
            switch (key) {
                case "username":
                    user.username = value instanceof String ? (String) value : null;
                    break;
                case "id":
                    user.id = value instanceof String ? (String) value : null;
                    break;
                case "geo":
                    Map map2 = value instanceof Map ? (Map) value : null;
                    if (map2 != null) {
                        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                        for (Map.Entry entry2 : map2.entrySet()) {
                            if (!(entry2.getKey() instanceof String) || entry2.getValue() == null) {
                                sentryOptions.getLogger().c(SentryLevel.WARNING, "Invalid key type in gep map.", new Object[0]);
                            } else {
                                concurrentHashMap2.put((String) entry2.getKey(), entry2.getValue());
                            }
                        }
                        user.geo = Geo.fromMap(concurrentHashMap2);
                        break;
                    } else {
                        break;
                    }
                    break;
                case "data":
                    Map map3 = value instanceof Map ? (Map) value : null;
                    if (map3 != null) {
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        for (Map.Entry entry3 : map3.entrySet()) {
                            if (!(entry3.getKey() instanceof String) || entry3.getValue() == null) {
                                sentryOptions.getLogger().c(SentryLevel.WARNING, "Invalid key or null value in data map.", new Object[0]);
                            } else {
                                concurrentHashMap3.put((String) entry3.getKey(), entry3.getValue().toString());
                            }
                        }
                        user.data = concurrentHashMap3;
                        break;
                    } else {
                        break;
                    }
                    break;
                case "name":
                    user.name = value instanceof String ? (String) value : null;
                    break;
                case "email":
                    user.email = value instanceof String ? (String) value : null;
                    break;
                case "ip_address":
                    user.ipAddress = value instanceof String ? (String) value : null;
                    break;
                default:
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    concurrentHashMap.put(entry.getKey(), entry.getValue());
                    break;
            }
        }
        user.unknown = concurrentHashMap;
        return user;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || User.class != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return w.a(this.email, user.email) && w.a(this.id, user.id) && w.a(this.username, user.username) && w.a(this.ipAddress, user.ipAddress);
    }

    @Nullable
    public Map<String, String> getData() {
        return this.data;
    }

    @Nullable
    public String getEmail() {
        return this.email;
    }

    @Nullable
    public Geo getGeo() {
        return this.geo;
    }

    @Nullable
    public String getId() {
        return this.id;
    }

    @Nullable
    public String getIpAddress() {
        return this.ipAddress;
    }

    @Deprecated
    @Nullable
    public String getName() {
        return this.name;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return w.b(this.email, this.id, this.username, this.ipAddress);
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.email != null) {
            m3Var.e("email").g(this.email);
        }
        if (this.id != null) {
            m3Var.e("id").g(this.id);
        }
        if (this.username != null) {
            m3Var.e("username").g(this.username);
        }
        if (this.ipAddress != null) {
            m3Var.e(JsonKeys.IP_ADDRESS).g(this.ipAddress);
        }
        if (this.name != null) {
            m3Var.e("name").g(this.name);
        }
        if (this.geo != null) {
            m3Var.e(JsonKeys.GEO);
            this.geo.serialize(m3Var, w0Var);
        }
        if (this.data != null) {
            m3Var.e("data").o(w0Var, this.data);
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

    public void setData(@Nullable Map<String, String> map) {
        this.data = io.sentry.util.c.b(map);
    }

    public void setEmail(@Nullable String str) {
        this.email = str;
    }

    public void setGeo(@Nullable Geo geo) {
        this.geo = geo;
    }

    public void setId(@Nullable String str) {
        this.id = str;
    }

    public void setIpAddress(@Nullable String str) {
        this.ipAddress = str;
    }

    @Deprecated
    public void setName(@Nullable String str) {
        this.name = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setUsername(@Nullable String str) {
        this.username = str;
    }
}
