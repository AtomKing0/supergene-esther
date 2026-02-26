package com.braze.configuration;

import android.content.Context;
import android.content.res.Resources;
import bo.app.al;
import bo.app.bl;
import bo.app.cl;
import bo.app.dl;
import bo.app.wk;
import bo.app.xk;
import bo.app.yk;
import bo.app.zk;
import com.braze.support.BrazeLogger;
import com.braze.support.PackageUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import p9.q;
import p9.r;

/* JADX INFO: loaded from: classes2.dex */
public class CachedConfigurationProvider {
    public static final wk Companion = new wk();
    private final Map<String, Object> configurationCache;
    private Context context;
    private final String resourcePackageName;
    private RuntimeAppConfigurationProvider runtimeAppConfigurationProvider;
    private boolean shouldUseConfigurationCache;

    public CachedConfigurationProvider(Context context, boolean z10, RuntimeAppConfigurationProvider runtimeAppConfigurationProvider) {
        t.i(context, "context");
        t.i(runtimeAppConfigurationProvider, "runtimeAppConfigurationProvider");
        this.context = context;
        this.shouldUseConfigurationCache = z10;
        this.runtimeAppConfigurationProvider = runtimeAppConfigurationProvider;
        Map<String, Object> mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        t.h(mapSynchronizedMap, "synchronizedMap(HashMap())");
        this.configurationCache = mapSynchronizedMap;
        this.resourcePackageName = PackageUtils.getResourcePackageName(this.context);
    }

    private final String getFallbackConfigKey(String str) {
        if (r.P(str, "braze", false, 2, null)) {
            return q.G(str, "braze", "appboy", false, 4, null);
        }
        return null;
    }

    private final int getResourceIdentifier(String str, xk xkVar) {
        if (str == null) {
            return 0;
        }
        return this.context.getResources().getIdentifier(str, xkVar.f4288a, this.resourcePackageName);
    }

    public final boolean getBooleanValue(String primaryKey, boolean z10) {
        t.i(primaryKey, "primaryKey");
        Object configurationValue = getConfigurationValue(xk.BOOLEAN, primaryKey, Boolean.valueOf(z10));
        t.g(configurationValue, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) configurationValue).booleanValue();
    }

    public final Integer getColorValue(String primaryKey) {
        t.i(primaryKey, "primaryKey");
        return (Integer) getConfigurationValue(xk.COLOR, primaryKey, null);
    }

    public final Map<String, Object> getConfigurationCache() {
        return this.configurationCache;
    }

    public final Object getConfigurationValue(xk type, String key, Object obj) {
        t.i(type, "type");
        t.i(key, "key");
        return (this.shouldUseConfigurationCache && this.configurationCache.containsKey(key)) ? this.configurationCache.get(key) : this.runtimeAppConfigurationProvider.containsKey(key) ? getRuntimeConfigurationValue(type, key, obj) : getResourceConfigurationValue(type, key, obj);
    }

    public final int getDrawableValue(String primaryKey, int i10) {
        t.i(primaryKey, "primaryKey");
        Object configurationValue = getConfigurationValue(xk.DRAWABLE_IDENTIFIER, primaryKey, Integer.valueOf(i10));
        t.g(configurationValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) configurationValue).intValue();
    }

    public final int getIntValue(String primaryKey, int i10) {
        t.i(primaryKey, "primaryKey");
        Object configurationValue = getConfigurationValue(xk.INTEGER, primaryKey, Integer.valueOf(i10));
        t.g(configurationValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) configurationValue).intValue();
    }

    public final Object getResourceConfigurationValue(xk type, String key, Object obj) {
        t.i(type, "type");
        t.i(key, "key");
        Object resourceValue = readResourceValue(type, key, obj);
        this.configurationCache.put(key, resourceValue);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new yk(key, resourceValue), 7, (Object) null);
        return resourceValue;
    }

    public final RuntimeAppConfigurationProvider getRuntimeAppConfigurationProvider() {
        return this.runtimeAppConfigurationProvider;
    }

    public final Object getRuntimeConfigurationValue(xk type, String key, Object obj) {
        Object objValueOf;
        t.i(type, "type");
        t.i(key, "key");
        int iOrdinal = type.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            objValueOf = Integer.valueOf(obj == null ? this.runtimeAppConfigurationProvider.getIntValue(key, 0) : this.runtimeAppConfigurationProvider.getIntValue(key, ((Integer) obj).intValue()));
        } else if (iOrdinal == 2) {
            RuntimeAppConfigurationProvider runtimeAppConfigurationProvider = this.runtimeAppConfigurationProvider;
            t.g(obj, "null cannot be cast to non-null type kotlin.Boolean");
            objValueOf = Boolean.valueOf(runtimeAppConfigurationProvider.getBooleanValue(key, ((Boolean) obj).booleanValue()));
        } else if (iOrdinal == 3) {
            objValueOf = this.runtimeAppConfigurationProvider.getStringValue(key, (String) obj);
        } else if (iOrdinal == 4) {
            objValueOf = Integer.valueOf(getResourceIdentifier(this.runtimeAppConfigurationProvider.getStringValue(key, ""), xk.DRAWABLE_IDENTIFIER));
        } else {
            if (iOrdinal != 5) {
                throw new v8.q();
            }
            RuntimeAppConfigurationProvider runtimeAppConfigurationProvider2 = this.runtimeAppConfigurationProvider;
            t.g(obj, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String?>");
            objValueOf = runtimeAppConfigurationProvider2.getStringSetValue(key, (Set) obj);
        }
        this.configurationCache.put(key, objValueOf);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new zk(key, objValueOf), 7, (Object) null);
        return objValueOf;
    }

    public final Set<String> getStringSetValue(String primaryKey, Set<String> set) {
        t.i(primaryKey, "primaryKey");
        Object configurationValue = getConfigurationValue(xk.STRING_ARRAY, primaryKey, set);
        return configurationValue == null ? set : (Set) configurationValue;
    }

    public final String getStringValue(String primaryKey, String str) {
        t.i(primaryKey, "primaryKey");
        return (String) getConfigurationValue(xk.STRING, primaryKey, str);
    }

    public final Object getValueFromResources(xk type, int i10) {
        t.i(type, "type");
        Resources resources = this.context.getResources();
        int iOrdinal = type.ordinal();
        if (iOrdinal == 0) {
            return Integer.valueOf(resources.getInteger(i10));
        }
        if (iOrdinal == 1) {
            return Integer.valueOf(resources.getColor(i10));
        }
        if (iOrdinal == 2) {
            return Boolean.valueOf(resources.getBoolean(i10));
        }
        if (iOrdinal == 3) {
            String string = resources.getString(i10);
            t.h(string, "resources.getString(resourceId)");
            return string;
        }
        if (iOrdinal == 4) {
            return Integer.valueOf(i10);
        }
        if (iOrdinal != 5) {
            throw new v8.q();
        }
        String[] stringArray = resources.getStringArray(i10);
        t.h(stringArray, "resources.getStringArray(resourceId)");
        return new HashSet(v.n(Arrays.copyOf(stringArray, stringArray.length)));
    }

    public final Object readResourceValue(xk type, String key, Object obj) {
        int resourceIdentifier;
        t.i(type, "type");
        t.i(key, "key");
        try {
            resourceIdentifier = getResourceIdentifier(key, type);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) bl.f2464a, 4, (Object) null);
        }
        if (resourceIdentifier != 0) {
            return getValueFromResources(type, resourceIdentifier);
        }
        String fallbackConfigKey = getFallbackConfigKey(key);
        if (fallbackConfigKey == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new al(key, obj), 7, (Object) null);
            return obj;
        }
        int resourceIdentifier2 = getResourceIdentifier(fallbackConfigKey, type);
        if (resourceIdentifier2 != 0) {
            return getValueFromResources(type, resourceIdentifier2);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new cl(type, key, obj), 7, (Object) null);
        return obj;
    }

    public final void resetCache$android_sdk_base_release() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) dl.f2662a, 7, (Object) null);
        this.configurationCache.clear();
    }

    public /* synthetic */ CachedConfigurationProvider(Context context, boolean z10, RuntimeAppConfigurationProvider runtimeAppConfigurationProvider, int i10, k kVar) {
        this(context, (i10 & 2) != 0 ? true : z10, (i10 & 4) != 0 ? new RuntimeAppConfigurationProvider(context) : runtimeAppConfigurationProvider);
    }
}
