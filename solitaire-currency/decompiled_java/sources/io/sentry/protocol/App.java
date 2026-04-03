package io.sentry.protocol;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class App implements h2 {
    public static final String TYPE = "app";

    @Nullable
    private String appBuild;

    @Nullable
    private String appIdentifier;

    @Nullable
    private String appName;

    @Nullable
    private Date appStartTime;

    @Nullable
    private String appVersion;

    @Nullable
    private String buildType;

    @Nullable
    private String deviceAppHash;

    @Nullable
    private Boolean inForeground;

    @Nullable
    private Boolean isSplitApks;

    @Nullable
    private Map<String, String> permissions;

    @Nullable
    private List<String> splitNames;

    @Nullable
    private String startType;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private List<String> viewNames;

    public static final class Deserializer implements x1<App> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public App deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            App app = new App();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "split_names":
                        List<String> list = (List) l3Var.A0();
                        if (list == null) {
                            break;
                        } else {
                            app.setSplitNames(list);
                            break;
                        }
                        break;
                    case "device_app_hash":
                        app.deviceAppHash = l3Var.o0();
                        break;
                    case "start_type":
                        app.startType = l3Var.o0();
                        break;
                    case "view_names":
                        List<String> list2 = (List) l3Var.A0();
                        if (list2 == null) {
                            break;
                        } else {
                            app.setViewNames(list2);
                            break;
                        }
                        break;
                    case "app_version":
                        app.appVersion = l3Var.o0();
                        break;
                    case "in_foreground":
                        app.inForeground = l3Var.H();
                        break;
                    case "build_type":
                        app.buildType = l3Var.o0();
                        break;
                    case "app_identifier":
                        app.appIdentifier = l3Var.o0();
                        break;
                    case "app_start_time":
                        app.appStartTime = l3Var.F(w0Var);
                        break;
                    case "permissions":
                        app.permissions = io.sentry.util.c.b((Map) l3Var.A0());
                        break;
                    case "app_name":
                        app.appName = l3Var.o0();
                        break;
                    case "app_build":
                        app.appBuild = l3Var.o0();
                        break;
                    case "is_split_apks":
                        app.isSplitApks = l3Var.H();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            app.setUnknown(concurrentHashMap);
            l3Var.k();
            return app;
        }
    }

    public static final class JsonKeys {
        public static final String APP_BUILD = "app_build";
        public static final String APP_IDENTIFIER = "app_identifier";
        public static final String APP_NAME = "app_name";
        public static final String APP_PERMISSIONS = "permissions";
        public static final String APP_START_TIME = "app_start_time";
        public static final String APP_VERSION = "app_version";
        public static final String BUILD_TYPE = "build_type";
        public static final String DEVICE_APP_HASH = "device_app_hash";
        public static final String IN_FOREGROUND = "in_foreground";
        public static final String IS_SPLIT_APKS = "is_split_apks";
        public static final String SPLIT_NAMES = "split_names";
        public static final String START_TYPE = "start_type";
        public static final String VIEW_NAMES = "view_names";
    }

    public App() {
    }

    App(@NotNull App app) {
        this.appBuild = app.appBuild;
        this.appIdentifier = app.appIdentifier;
        this.appName = app.appName;
        this.appStartTime = app.appStartTime;
        this.appVersion = app.appVersion;
        this.buildType = app.buildType;
        this.deviceAppHash = app.deviceAppHash;
        this.permissions = io.sentry.util.c.b(app.permissions);
        this.inForeground = app.inForeground;
        this.viewNames = io.sentry.util.c.a(app.viewNames);
        this.startType = app.startType;
        this.isSplitApks = app.isSplitApks;
        this.splitNames = app.splitNames;
        this.unknown = io.sentry.util.c.b(app.unknown);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || App.class != obj.getClass()) {
            return false;
        }
        App app = (App) obj;
        return w.a(this.appIdentifier, app.appIdentifier) && w.a(this.appStartTime, app.appStartTime) && w.a(this.deviceAppHash, app.deviceAppHash) && w.a(this.buildType, app.buildType) && w.a(this.appName, app.appName) && w.a(this.appVersion, app.appVersion) && w.a(this.appBuild, app.appBuild) && w.a(this.permissions, app.permissions) && w.a(this.inForeground, app.inForeground) && w.a(this.viewNames, app.viewNames) && w.a(this.startType, app.startType) && w.a(this.isSplitApks, app.isSplitApks) && w.a(this.splitNames, app.splitNames);
    }

    @Nullable
    public String getAppBuild() {
        return this.appBuild;
    }

    @Nullable
    public String getAppIdentifier() {
        return this.appIdentifier;
    }

    @Nullable
    public String getAppName() {
        return this.appName;
    }

    @Nullable
    public Date getAppStartTime() {
        Date date = this.appStartTime;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    @Nullable
    public String getAppVersion() {
        return this.appVersion;
    }

    @Nullable
    public String getBuildType() {
        return this.buildType;
    }

    @Nullable
    public String getDeviceAppHash() {
        return this.deviceAppHash;
    }

    @Nullable
    public Boolean getInForeground() {
        return this.inForeground;
    }

    @Nullable
    public Map<String, String> getPermissions() {
        return this.permissions;
    }

    @Nullable
    public Boolean getSplitApks() {
        return this.isSplitApks;
    }

    @Nullable
    public List<String> getSplitNames() {
        return this.splitNames;
    }

    @Nullable
    public String getStartType() {
        return this.startType;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public List<String> getViewNames() {
        return this.viewNames;
    }

    public int hashCode() {
        return w.b(this.appIdentifier, this.appStartTime, this.deviceAppHash, this.buildType, this.appName, this.appVersion, this.appBuild, this.permissions, this.inForeground, this.viewNames, this.startType, this.isSplitApks, this.splitNames);
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.appIdentifier != null) {
            m3Var.e(JsonKeys.APP_IDENTIFIER).g(this.appIdentifier);
        }
        if (this.appStartTime != null) {
            m3Var.e(JsonKeys.APP_START_TIME).o(w0Var, this.appStartTime);
        }
        if (this.deviceAppHash != null) {
            m3Var.e(JsonKeys.DEVICE_APP_HASH).g(this.deviceAppHash);
        }
        if (this.buildType != null) {
            m3Var.e(JsonKeys.BUILD_TYPE).g(this.buildType);
        }
        if (this.appName != null) {
            m3Var.e(JsonKeys.APP_NAME).g(this.appName);
        }
        if (this.appVersion != null) {
            m3Var.e(JsonKeys.APP_VERSION).g(this.appVersion);
        }
        if (this.appBuild != null) {
            m3Var.e(JsonKeys.APP_BUILD).g(this.appBuild);
        }
        Map<String, String> map = this.permissions;
        if (map != null && !map.isEmpty()) {
            m3Var.e(JsonKeys.APP_PERMISSIONS).o(w0Var, this.permissions);
        }
        if (this.inForeground != null) {
            m3Var.e(JsonKeys.IN_FOREGROUND).p(this.inForeground);
        }
        if (this.viewNames != null) {
            m3Var.e(JsonKeys.VIEW_NAMES).o(w0Var, this.viewNames);
        }
        if (this.startType != null) {
            m3Var.e(JsonKeys.START_TYPE).g(this.startType);
        }
        if (this.isSplitApks != null) {
            m3Var.e(JsonKeys.IS_SPLIT_APKS).p(this.isSplitApks);
        }
        List<String> list = this.splitNames;
        if (list != null && !list.isEmpty()) {
            m3Var.e(JsonKeys.SPLIT_NAMES).o(w0Var, this.splitNames);
        }
        Map<String, Object> map2 = this.unknown;
        if (map2 != null) {
            for (String str : map2.keySet()) {
                m3Var.e(str).o(w0Var, this.unknown.get(str));
            }
        }
        m3Var.k();
    }

    public void setAppBuild(@Nullable String str) {
        this.appBuild = str;
    }

    public void setAppIdentifier(@Nullable String str) {
        this.appIdentifier = str;
    }

    public void setAppName(@Nullable String str) {
        this.appName = str;
    }

    public void setAppStartTime(@Nullable Date date) {
        this.appStartTime = date;
    }

    public void setAppVersion(@Nullable String str) {
        this.appVersion = str;
    }

    public void setBuildType(@Nullable String str) {
        this.buildType = str;
    }

    public void setDeviceAppHash(@Nullable String str) {
        this.deviceAppHash = str;
    }

    public void setInForeground(@Nullable Boolean bool) {
        this.inForeground = bool;
    }

    public void setPermissions(@Nullable Map<String, String> map) {
        this.permissions = map;
    }

    public void setSplitApks(@Nullable Boolean bool) {
        this.isSplitApks = bool;
    }

    public void setSplitNames(@Nullable List<String> list) {
        this.splitNames = list;
    }

    public void setStartType(@Nullable String str) {
        this.startType = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setViewNames(@Nullable List<String> list) {
        this.viewNames = list;
    }
}
