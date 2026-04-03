package com.ironsource;

import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class gm {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f12317a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final String f12318b = "SDKPluginType";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final String f12319c = "sessionid";

        private a() {
        }
    }

    @NotNull
    public final Map<String, String> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String pluginType = ConfigFile.getConfigFile().getPluginType();
        if (pluginType != null) {
            linkedHashMap.put(a.f12318b, pluginType);
        }
        String sessionId = IronSourceUtils.getSessionId();
        if (sessionId != null) {
            linkedHashMap.put("sessionid", sessionId);
        }
        return linkedHashMap;
    }
}
