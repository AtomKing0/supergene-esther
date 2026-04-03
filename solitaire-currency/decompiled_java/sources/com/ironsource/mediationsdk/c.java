package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.dm;
import com.ironsource.environment.StringUtils;
import com.ironsource.i9;
import com.ironsource.ji;
import com.ironsource.kb;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.AdapterDebugInterface;
import com.ironsource.mediationsdk.adunit.adapter.BaseAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAPSDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.t8;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f13306k = "IronSource";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f13307l = "com.ironsource.adapters";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f13308m = "aps";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final c f13309n = new c();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Object f13310o = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f13315e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f13318h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private t8 f13319i = new t8();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final dm f13320j = new dm();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, AbstractAdapter> f13311a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, AdapterBaseWrapper> f13312b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConcurrentHashMap<String, List<String>> f13316f = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ConcurrentHashMap<IronSource.AD_UNIT, JSONObject> f13317g = new ConcurrentHashMap<>();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13321a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            f13321a = iArr;
            try {
                iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13321a[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13321a[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13321a[IronSource.AD_UNIT.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private String c(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        return ((uuid == null || ad_unit != IronSource.AD_UNIT.NATIVE_AD) ? "" : uuid.toString()) + "-" + ad_unit.toString() + "-" + networkSettings.getProviderName();
    }

    public AbstractAdapter a(NetworkSettings networkSettings) {
        return a(b(networkSettings), networkSettings.getProviderTypeForReflection());
    }

    public AdapterBaseInterface b(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        String strB = networkSettings.isCustomNetwork() ? b(networkSettings) : c(networkSettings, ad_unit, uuid);
        if (this.f13312b.containsKey(strB)) {
            return this.f13312b.get(strB).getAdapterBaseInterface();
        }
        AdapterBaseInterface adapterBaseInterfaceA = a(strB, networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkAdapterName(null) : networkSettings.getProviderTypeForReflection(), networkSettings);
        if (adapterBaseInterfaceA != null || networkSettings.isCustomNetwork()) {
            this.f13320j.a(this.f13312b.put(strB, new AdapterBaseWrapper(adapterBaseInterfaceA, networkSettings)));
            return adapterBaseInterfaceA;
        }
        int i10 = a.f13321a[ad_unit.ordinal()];
        AbstractAdapter abstractAdapterA = a(networkSettings, i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? null : networkSettings.getNativeAdSettings() : networkSettings.getBannerSettings() : networkSettings.getInterstitialSettings() : networkSettings.getRewardedVideoSettings(), false);
        if (abstractAdapterA != null) {
            u uVar = new u(abstractAdapterA);
            this.f13312b.put(strB, new AdapterBaseWrapper(uVar, networkSettings));
            return uVar;
        }
        String str = "error creating network adapter " + networkSettings.getProviderName();
        a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
        IronLog.INTERNAL.error(str);
        return null;
    }

    public ConcurrentHashMap<String, AdapterBaseWrapper> d() {
        return this.f13312b;
    }

    public void e() {
        this.f13311a.clear();
        this.f13312b.clear();
    }

    public static c b() {
        return f13309n;
    }

    public AbstractAdapter a(NetworkSettings networkSettings, JSONObject jSONObject, boolean z10) {
        String coreSDKVersion;
        String strB = b(networkSettings);
        String providerTypeForReflection = z10 ? "IronSource" : networkSettings.getProviderTypeForReflection();
        synchronized (f13310o) {
            if (this.f13311a.containsKey(strB)) {
                return this.f13311a.get(strB);
            }
            AbstractAdapter abstractAdapterA = a(strB, providerTypeForReflection);
            if (abstractAdapterA == null) {
                a(strB + " adapter was not loaded");
                return null;
            }
            abstractAdapterA.setProviderNetworkKey(networkSettings.getProviderNetworkKey());
            try {
                coreSDKVersion = abstractAdapterA.getCoreSDKVersion();
            } catch (Throwable th) {
                i9.d().a(th);
                String str = "error while retrieving coreSDKVersion " + abstractAdapterA.getProviderName() + ": " + th.getLocalizedMessage();
                a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                IronLog.INTERNAL.error(str);
                coreSDKVersion = "Unknown";
            }
            b(strB + " was allocated (adapter version: " + abstractAdapterA.getVersion() + ", sdk version: " + coreSDKVersion + ")");
            c(abstractAdapterA);
            this.f13320j.a(abstractAdapterA);
            a(abstractAdapterA);
            this.f13319i.a(abstractAdapterA, networkSettings);
            b(abstractAdapterA);
            a(jSONObject, abstractAdapterA, providerTypeForReflection);
            this.f13311a.put(strB, abstractAdapterA);
            return abstractAdapterA;
        }
    }

    public ConcurrentHashMap<String, List<String>> c() {
        return this.f13316f;
    }

    private AbstractAdapter a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.ironsource.adapters." + StringUtils.toLowerCase(str2) + "." + str2 + "Adapter");
            return (AbstractAdapter) cls.getMethod(IronSourceConstants.START_ADAPTER, String.class).invoke(cls, str);
        } catch (Exception e10) {
            String str3 = "Error while loading adapter - exception = " + e10.getLocalizedMessage();
            a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str3);
            a(str3);
            return null;
        }
    }

    private String b(NetworkSettings networkSettings) {
        return networkSettings.isMultipleInstances() ? networkSettings.getProviderDefaultInstance() : networkSettings.getProviderName();
    }

    private void c(AbstractAdapter abstractAdapter) {
        for (String str : this.f13316f.keySet()) {
            try {
                List<String> list = this.f13316f.get(str);
                IronSourceUtils.sendAutomationLog(abstractAdapter.getProviderName() + "Adapter setMetaData key = " + str + ", values = " + list);
                if (list != null) {
                    abstractAdapter.setMetaData(str, list);
                }
            } catch (Throwable th) {
                i9.d().a(th);
                String str2 = "error while setting metadata of " + abstractAdapter.getProviderName() + ": " + th.getLocalizedMessage();
                a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
                b(str2);
            }
        }
    }

    private AdapterBaseInterface a(String str, String str2, NetworkSettings networkSettings) {
        if (networkSettings.isCustomNetwork() && TextUtils.isEmpty(networkSettings.getCustomNetworkPackage())) {
            IronLog.INTERNAL.error("missing package definition for " + str);
            return null;
        }
        String str3 = (networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkPackage() : f13307l) + "." + str2;
        try {
            BaseAdapter baseAdapter = (BaseAdapter) Class.forName(str3).newInstance();
            IronLog.INTERNAL.info(str3 + " was allocated (adapter version: " + baseAdapter.getAdapterVersion() + ", sdk version: " + baseAdapter.getNetworkSDKVersion() + ")");
            a(baseAdapter);
            this.f13319i.a(baseAdapter, networkSettings);
            this.f13312b.put(str, new AdapterBaseWrapper(baseAdapter, networkSettings));
            return baseAdapter;
        } catch (Exception unused) {
            if (networkSettings.isCustomNetwork()) {
                String str4 = "failed to load " + str3;
                IronLog.INTERNAL.error(str4);
                a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str4);
            }
            return null;
        }
    }

    private void b(AbstractAdapter abstractAdapter) {
        Boolean bool = this.f13315e;
        if (bool != null) {
            try {
                abstractAdapter.setAdapterDebug(bool);
            } catch (Throwable th) {
                i9.d().a(th);
                String str = "error while setting adapterDebug of " + abstractAdapter.getProviderName() + ": " + th.getLocalizedMessage();
                a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                b(str);
            }
        }
    }

    private BaseAdAdapter<?, ?> a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        if (networkSettings.isCustomNetwork() && TextUtils.isEmpty(networkSettings.getCustomNetworkPackage())) {
            IronLog.INTERNAL.error("missing package definition for " + networkSettings.getProviderTypeForReflection());
            return null;
        }
        String str = (networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkPackage() : f13307l) + "." + (networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkAdapterName(ad_unit) : networkSettings.getProviderTypeForReflection());
        try {
            return (BaseAdAdapter) Class.forName(str).getConstructor(NetworkSettings.class).newInstance(networkSettings);
        } catch (Exception unused) {
            if (networkSettings.isCustomNetwork()) {
                String str2 = "failed to load " + str;
                IronLog.INTERNAL.error(str2);
                a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
            }
            return null;
        }
    }

    private void b(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "AdapterRepository: " + str, 0);
    }

    public BaseAdAdapter<?, ?> a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        BaseAdAdapter<?, ?> baseAdAdapterA = a(networkSettings, ad_unit);
        if (baseAdAdapterA != null || networkSettings.isCustomNetwork()) {
            return baseAdAdapterA;
        }
        AbstractAdapter abstractAdapterA = a(networkSettings);
        if (abstractAdapterA != null) {
            return com.ironsource.mediationsdk.a.a(abstractAdapterA, networkSettings, ad_unit, uuid);
        }
        String str = "error creating ad adapter " + networkSettings.getProviderName();
        a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
        IronLog.INTERNAL.error(str);
        return null;
    }

    public void b(String str, String str2) {
        this.f13313c = str;
        this.f13314d = str2;
    }

    private String a(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == null || TextUtils.isEmpty(ad_unit.toString())) {
            return "";
        }
        return ad_unit.toString().substring(0, 1).toUpperCase(Locale.getDefault()) + ad_unit.toString().substring(1);
    }

    public void b(boolean z10) {
        synchronized (f13310o) {
            this.f13319i.a(z10);
            this.f13319i.a(this.f13311a, this.f13312b);
        }
    }

    public ConcurrentHashMap<String, AbstractAdapter> a() {
        return this.f13311a;
    }

    private void a(int i10, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("reason", str);
            }
            ji.i().a(new kb(i10, jSONObject));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(AbstractAdapter abstractAdapter) {
        if (!StringUtils.toLowerCase(abstractAdapter.getProviderName()).equals(f13308m) || this.f13317g.size() == 0) {
            return;
        }
        for (IronSource.AD_UNIT ad_unit : this.f13317g.keySet()) {
            try {
                JSONObject jSONObject = this.f13317g.get(ad_unit);
                if (jSONObject != null && jSONObject.length() > 0 && (abstractAdapter instanceof SetAPSInterface)) {
                    ((SetAPSInterface) abstractAdapter).setAPSData(ad_unit, jSONObject);
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                String str = "error while setting aps data: " + e10.getLocalizedMessage();
                a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, str);
                b(str);
            }
        }
        this.f13317g.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, "APSData is empty");
            a("APSData is empty");
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            if (!this.f13311a.isEmpty()) {
                for (AbstractAdapter abstractAdapter : this.f13311a.values()) {
                    if (StringUtils.toLowerCase(abstractAdapter.getProviderName()).equals(f13308m) && (abstractAdapter instanceof SetAPSInterface)) {
                        ((SetAPSInterface) abstractAdapter).setAPSData(ad_unit, jSONObject2);
                        return;
                    }
                }
            }
            for (AdapterBaseWrapper adapterBaseWrapper : this.f13312b.values()) {
                if (StringUtils.toLowerCase(adapterBaseWrapper.getSettings().getProviderTypeForReflection()).equals(f13308m)) {
                    AdapterBaseInterface adapterBaseInterface = adapterBaseWrapper.getAdapterBaseInterface();
                    if (adapterBaseInterface != null) {
                        ((AdapterAPSDataInterface) adapterBaseInterface).setAPSData(ad_unit, jSONObject2);
                        return;
                    }
                    return;
                }
            }
            synchronized (f13310o) {
                this.f13317g.put(ad_unit, jSONObject2);
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            String str = "error while setting APSData: " + e10.getLocalizedMessage();
            a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, str);
            a(str);
        }
    }

    private void a(AdapterBaseInterface adapterBaseInterface) {
        Boolean bool = this.f13315e;
        if (bool == null || !(adapterBaseInterface instanceof AdapterDebugInterface)) {
            return;
        }
        try {
            ((AdapterDebugInterface) adapterBaseInterface).setAdapterDebug(bool.booleanValue());
        } catch (Exception e10) {
            i9.d().a(e10);
            String str = "error while setting adapterDebug of " + adapterBaseInterface.getClass().getSimpleName() + ": " + e10.getLocalizedMessage();
            a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
            b(str);
        }
    }

    public void a(@NotNull v vVar) {
        String str;
        if (vVar.allData().length() == 0) {
            str = "empty network data";
        } else {
            if (!TextUtils.isEmpty(vVar.a())) {
                this.f13320j.a(vVar);
                vVar.a(this.f13311a.values(), this.f13312b.values());
                vVar.b();
                if (StringUtils.toLowerCase(vVar.a()).equals(f13308m)) {
                    a(vVar.allData());
                    return;
                }
                return;
            }
            str = "empty network key";
        }
        a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, str);
        a(str);
    }

    private void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "AdapterRepository: " + str, 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0089 A[Catch: all -> 0x00de, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0013, B:7:0x0039, B:9:0x003f, B:13:0x004a, B:14:0x0079, B:15:0x0083, B:17:0x0089, B:19:0x009d, B:21:0x00a1, B:24:0x00a9, B:25:0x00dc, B:10:0x0045), top: B:34:0x0003, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r8, java.util.List<java.lang.String> r9) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.c.a(java.lang.String, java.util.List):void");
    }

    private void a(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
            if (!next.equalsIgnoreCase(ad_unit.toString())) {
                ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
                if (!next.equalsIgnoreCase(ad_unit.toString())) {
                    ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
                    if (next.equalsIgnoreCase(ad_unit.toString())) {
                    }
                }
            }
            a(ad_unit, jSONObjectOptJSONObject);
        }
    }

    private void a(JSONObject jSONObject, AbstractAdapter abstractAdapter, String str) {
        if (str.equalsIgnoreCase("IronSource") && this.f13318h.compareAndSet(false, true)) {
            b("SDK5 earlyInit  <" + str + ">");
            try {
                abstractAdapter.earlyInit(this.f13313c, this.f13314d, jSONObject);
            } catch (Exception e10) {
                i9.d().a(e10);
                String str2 = "error while calling early init for " + abstractAdapter.getProviderName() + ": " + e10.getLocalizedMessage();
                a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
                IronLog.INTERNAL.error(str2);
            }
        }
    }

    public void a(boolean z10) {
        synchronized (f13310o) {
            this.f13315e = Boolean.valueOf(z10);
            Iterator<AbstractAdapter> it = this.f13311a.values().iterator();
            while (it.hasNext()) {
                b(it.next());
            }
        }
    }

    public static boolean a(String str, AbstractAdapter abstractAdapter) {
        return (abstractAdapter == null || abstractAdapter.getProviderNetworkKey() == null || !abstractAdapter.getProviderNetworkKey().equalsIgnoreCase(str)) ? false : true;
    }

    public static boolean a(String str, AdapterBaseWrapper adapterBaseWrapper) {
        return (adapterBaseWrapper == null || adapterBaseWrapper.getSettings().getProviderNetworkKey() == null || !adapterBaseWrapper.getSettings().getProviderNetworkKey().equalsIgnoreCase(str)) ? false : true;
    }
}
