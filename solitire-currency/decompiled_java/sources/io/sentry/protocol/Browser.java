package io.sentry.protocol;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Browser implements h2 {
    public static final String TYPE = "browser";

    @Nullable
    private String name;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private String version;

    public static final class Deserializer implements x1<Browser> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public Browser deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            Browser browser = new Browser();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("name")) {
                    browser.name = l3Var.o0();
                } else if (strC.equals("version")) {
                    browser.version = l3Var.o0();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    l3Var.r0(w0Var, concurrentHashMap, strC);
                }
            }
            browser.setUnknown(concurrentHashMap);
            l3Var.k();
            return browser;
        }
    }

    public static final class JsonKeys {
        public static final String NAME = "name";
        public static final String VERSION = "version";
    }

    public Browser() {
    }

    Browser(@NotNull Browser browser) {
        this.name = browser.name;
        this.version = browser.version;
        this.unknown = io.sentry.util.c.b(browser.unknown);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Browser.class != obj.getClass()) {
            return false;
        }
        Browser browser = (Browser) obj;
        return w.a(this.name, browser.name) && w.a(this.version, browser.version);
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return w.b(this.name, this.version);
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.name != null) {
            m3Var.e("name").g(this.name);
        }
        if (this.version != null) {
            m3Var.e("version").g(this.version);
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

    public void setName(@Nullable String str) {
        this.name = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setVersion(@Nullable String str) {
        this.version = str;
    }
}
