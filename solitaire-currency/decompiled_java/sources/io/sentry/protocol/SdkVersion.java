package io.sentry.protocol;

import io.sentry.SentryLevel;
import io.sentry.a7;
import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.protocol.SentryPackage;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SdkVersion implements h2 {

    @Nullable
    private Set<String> deserializedIntegrations;

    @Nullable
    private Set<SentryPackage> deserializedPackages;

    @NotNull
    private String name;

    @Nullable
    private Map<String, Object> unknown;

    @NotNull
    private String version;

    public static final class Deserializer implements x1<SdkVersion> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public SdkVersion deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            l3Var.h();
            String strE0 = null;
            String strE02 = null;
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "name":
                        strE0 = l3Var.e0();
                        break;
                    case "version":
                        strE02 = l3Var.e0();
                        break;
                    case "packages":
                        List listD0 = l3Var.D0(w0Var, new SentryPackage.Deserializer());
                        if (listD0 == null) {
                            break;
                        } else {
                            arrayList.addAll(listD0);
                            break;
                        }
                        break;
                    case "integrations":
                        List list = (List) l3Var.A0();
                        if (list == null) {
                            break;
                        } else {
                            arrayList2.addAll(list);
                            break;
                        }
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        l3Var.r0(w0Var, map, strC);
                        break;
                }
            }
            l3Var.k();
            if (strE0 == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"name\"");
                w0Var.b(SentryLevel.ERROR, "Missing required field \"name\"", illegalStateException);
                throw illegalStateException;
            }
            if (strE02 == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"version\"");
                w0Var.b(SentryLevel.ERROR, "Missing required field \"version\"", illegalStateException2);
                throw illegalStateException2;
            }
            SdkVersion sdkVersion = new SdkVersion(strE0, strE02);
            sdkVersion.deserializedPackages = new CopyOnWriteArraySet(arrayList);
            sdkVersion.deserializedIntegrations = new CopyOnWriteArraySet(arrayList2);
            sdkVersion.setUnknown(map);
            return sdkVersion;
        }
    }

    public static final class JsonKeys {
        public static final String INTEGRATIONS = "integrations";
        public static final String NAME = "name";
        public static final String PACKAGES = "packages";
        public static final String VERSION = "version";
    }

    public SdkVersion(@NotNull String str, @NotNull String str2) {
        this.name = (String) w.c(str, "name is required.");
        this.version = (String) w.c(str2, "version is required.");
    }

    @NotNull
    public static SdkVersion updateSdkVersion(@Nullable SdkVersion sdkVersion, @NotNull String str, @NotNull String str2) {
        w.c(str, "name is required.");
        w.c(str2, "version is required.");
        if (sdkVersion == null) {
            return new SdkVersion(str, str2);
        }
        sdkVersion.setName(str);
        sdkVersion.setVersion(str2);
        return sdkVersion;
    }

    public void addIntegration(@NotNull String str) {
        a7.d().a(str);
    }

    public void addPackage(@NotNull String str, @NotNull String str2) {
        a7.d().b(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SdkVersion.class != obj.getClass()) {
            return false;
        }
        SdkVersion sdkVersion = (SdkVersion) obj;
        return this.name.equals(sdkVersion.name) && this.version.equals(sdkVersion.version);
    }

    @NotNull
    public Set<String> getIntegrationSet() {
        Set<String> set = this.deserializedIntegrations;
        return set != null ? set : a7.d().e();
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public Set<SentryPackage> getPackageSet() {
        Set<SentryPackage> set = this.deserializedPackages;
        return set != null ? set : a7.d().f();
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @NotNull
    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return w.b(this.name, this.version);
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("name").g(this.name);
        m3Var.e("version").g(this.version);
        Set<SentryPackage> packageSet = getPackageSet();
        Set<String> integrationSet = getIntegrationSet();
        if (!packageSet.isEmpty()) {
            m3Var.e(JsonKeys.PACKAGES).o(w0Var, packageSet);
        }
        if (!integrationSet.isEmpty()) {
            m3Var.e(JsonKeys.INTEGRATIONS).o(w0Var, integrationSet);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.unknown.get(str));
            }
        }
        m3Var.k();
    }

    public void setName(@NotNull String str) {
        this.name = (String) w.c(str, "name is required.");
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setVersion(@NotNull String str) {
        this.version = (String) w.c(str, "version is required.");
    }
}
