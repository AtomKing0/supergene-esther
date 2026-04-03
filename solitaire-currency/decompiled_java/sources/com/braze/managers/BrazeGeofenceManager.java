package com.braze.managers;

import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import bo.app.ab;
import bo.app.ba;
import bo.app.bb;
import bo.app.cb;
import bo.app.d9;
import bo.app.db;
import bo.app.e00;
import bo.app.eb;
import bo.app.fb;
import bo.app.gb;
import bo.app.h00;
import bo.app.hb;
import bo.app.ib;
import bo.app.ic;
import bo.app.jb;
import bo.app.jc;
import bo.app.kb;
import bo.app.kc;
import bo.app.kf;
import bo.app.lb;
import bo.app.lc;
import bo.app.mb;
import bo.app.mc;
import bo.app.nb;
import bo.app.ob;
import bo.app.oc;
import bo.app.of;
import bo.app.pb;
import bo.app.pc;
import bo.app.qa;
import bo.app.qb;
import bo.app.ra;
import bo.app.rb;
import bo.app.rc;
import bo.app.rz;
import bo.app.sa;
import bo.app.sb;
import bo.app.sd;
import bo.app.tb;
import bo.app.tf;
import bo.app.tz;
import bo.app.ub;
import bo.app.v00;
import bo.app.vb;
import bo.app.vb0;
import bo.app.wb;
import bo.app.wz;
import bo.app.xb;
import bo.app.xz;
import bo.app.z9;
import bo.app.za;
import bo.app.zd;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.GeofenceTransitionType;
import com.braze.location.IBrazeGeofenceApi;
import com.braze.location.IBrazeLocationApi;
import com.braze.models.BrazeGeofence;
import com.braze.models.IBrazeLocation;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.PermissionUtils;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.d0;
import kotlin.collections.z;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.json.JSONException;
import org.json.JSONObject;
import p9.q;
import v8.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class BrazeGeofenceManager {
    public static final Companion Companion = new Companion(null);
    private final Context applicationContext;
    private final qa brazeGeofenceApi;
    private rc brazeGeofenceReEligibilityManager;
    private final List<BrazeGeofence> brazeGeofences;
    private final sd brazeLocationApi;
    private final h00 brazeManager;
    private final BrazeConfigurationProvider configurationProvider;
    private final ReentrantLock geofenceListLock;
    private IBrazeLocation geofenceRequestLocation;
    private final SharedPreferences geofenceStorageSharedPreferences;
    private final PendingIntent geofenceTransitionPendingIntent;
    private boolean isGeofencesEnabled;
    private int maxNumToRegister;
    private final vb0 serverConfigStorageProvider;

    public static final class Companion {
        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final String getGeofenceSharedPreferencesName(String apiKey) {
            t.i(apiKey, "apiKey");
            return "com.appboy.managers.geofences.storage." + apiKey;
        }

        public final boolean getGeofencesEnabledFromConfiguration(BrazeConfigurationProvider configurationProvider) {
            t.i(configurationProvider, "configurationProvider");
            return configurationProvider.isGeofencesEnabled();
        }

        public final boolean getGeofencesEnabledFromServerConfig(vb0 serverConfigStorageProvider) {
            t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
            if (!serverConfigStorageProvider.B()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) c.f8083a, 6, (Object) null);
                return false;
            }
            if (serverConfigStorageProvider.A()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) a.f8081a, 6, (Object) null);
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) b.f8082a, 6, (Object) null);
            return false;
        }

        public final int getMaxNumToRegister(vb0 serverConfigStorageProvider) {
            t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
            if (serverConfigStorageProvider.k() > 0) {
                return serverConfigStorageProvider.k();
            }
            return 20;
        }

        public final List<BrazeGeofence> retrieveBrazeGeofencesFromLocalStorage(SharedPreferences sharedPreferences) {
            t.i(sharedPreferences, "sharedPreferences");
            ArrayList arrayList = new ArrayList();
            Map<String, ?> all = sharedPreferences.getAll();
            if (all == null || all.isEmpty()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) d.f8084a, 7, (Object) null);
                return arrayList;
            }
            Set<String> setKeySet = all.keySet();
            if (setKeySet.isEmpty()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) e.f8085a, 6, (Object) null);
                return arrayList;
            }
            for (String str : setKeySet) {
                String string = sharedPreferences.getString(str, null);
                if (string != null) {
                    try {
                    } catch (JSONException e10) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new g(string), 4, (Object) null);
                    } catch (Exception e11) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (h9.a) new h(string), 4, (Object) null);
                    }
                    if (!q.z(string)) {
                        arrayList.add(new BrazeGeofence(new JSONObject(string)));
                    }
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new f(str), 6, (Object) null);
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    public BrazeGeofenceManager(Context context, String apiKey, h00 brazeManager, BrazeConfigurationProvider configurationProvider, vb0 serverConfigStorageProvider, v00 internalIEventMessenger) {
        t.i(context, "context");
        t.i(apiKey, "apiKey");
        t.i(brazeManager, "brazeManager");
        t.i(configurationProvider, "configurationProvider");
        t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        t.i(internalIEventMessenger, "internalIEventMessenger");
        this.brazeManager = brazeManager;
        this.configurationProvider = configurationProvider;
        this.serverConfigStorageProvider = serverConfigStorageProvider;
        qa qaVar = new qa();
        this.brazeGeofenceApi = qaVar;
        this.brazeLocationApi = new sd(context, zd.f4429c.a(configurationProvider), configurationProvider);
        this.applicationContext = context.getApplicationContext();
        this.geofenceListLock = new ReentrantLock();
        Companion companion = Companion;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(companion.getGeofenceSharedPreferencesName(apiKey), 0);
        t.h(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.geofenceStorageSharedPreferences = sharedPreferences;
        this.brazeGeofences = d0.R0(companion.retrieveBrazeGeofencesFromLocalStorage(sharedPreferences));
        this.geofenceTransitionPendingIntent = qaVar.a(context);
        this.brazeGeofenceReEligibilityManager = new rc(context, apiKey, serverConfigStorageProvider, internalIEventMessenger);
        if (companion.getGeofencesEnabledFromServerConfig(serverConfigStorageProvider) && isGeofencesEnabledFromEnvironment(context) && qaVar.a()) {
            z10 = true;
        }
        this.isGeofencesEnabled = z10;
        this.maxNumToRegister = companion.getMaxNumToRegister(serverConfigStorageProvider);
        if (!qaVar.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) ra.f3758a, 6, (Object) null);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) sa.f3843a, 6, (Object) null);
        setUpGeofences(true);
    }

    public final boolean analyticsEnabledForGeofenceId(String geofenceId, GeofenceTransitionType geofenceTransitionType) {
        t.i(geofenceId, "geofenceId");
        t.i(geofenceTransitionType, "geofenceTransitionType");
        ReentrantLock reentrantLock = this.geofenceListLock;
        reentrantLock.lock();
        try {
            BrazeGeofence brazeGeofenceForGeofenceId = getBrazeGeofenceForGeofenceId(geofenceId);
            if (brazeGeofenceForGeofenceId != null) {
                if (geofenceTransitionType == GeofenceTransitionType.ENTER) {
                    return brazeGeofenceForGeofenceId.getAnalyticsEnabledEnter();
                }
                if (geofenceTransitionType == GeofenceTransitionType.EXIT) {
                    return brazeGeofenceForGeofenceId.getAnalyticsEnabledExit();
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void configureFromServerConfig(bo.app.fb0 r14) {
        /*
            r13 = this;
            java.lang.String r0 = "serverConfig"
            kotlin.jvm.internal.t.i(r14, r0)
            boolean r1 = r14.f2798i
            com.braze.support.BrazeLogger r10 = com.braze.support.BrazeLogger.INSTANCE
            bo.app.ta r7 = new bo.app.ta
            r7.<init>(r1)
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 7
            r9 = 0
            r2 = r10
            r3 = r13
            com.braze.support.BrazeLogger.brazelog$default(r2, r3, r4, r5, r6, r7, r8, r9)
            r11 = 1
            r12 = 0
            if (r1 == 0) goto L33
            android.content.Context r1 = r13.applicationContext
            java.lang.String r2 = "applicationContext"
            kotlin.jvm.internal.t.h(r1, r2)
            boolean r1 = r13.isGeofencesEnabledFromEnvironment(r1)
            if (r1 == 0) goto L33
            bo.app.qa r1 = r13.brazeGeofenceApi
            boolean r1 = r1.a()
            if (r1 == 0) goto L33
            r1 = r11
            goto L34
        L33:
            r1 = r12
        L34:
            boolean r2 = r13.isGeofencesEnabled
            if (r1 == r2) goto L63
            r13.isGeofencesEnabled = r1
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.I
            bo.app.ua r7 = new bo.app.ua
            r7.<init>(r13)
            r5 = 0
            r6 = 0
            r8 = 6
            r9 = 0
            r2 = r10
            r3 = r13
            com.braze.support.BrazeLogger.brazelog$default(r2, r3, r4, r5, r6, r7, r8, r9)
            boolean r1 = r13.isGeofencesEnabled
            if (r1 == 0) goto L5d
            r13.setUpGeofences(r12)
            com.braze.configuration.BrazeConfigurationProvider r1 = r13.configurationProvider
            boolean r1 = r1.isAutomaticGeofenceRequestsEnabled()
            if (r1 == 0) goto L72
            r13.requestGeofenceRefresh(r11)
            goto L72
        L5d:
            android.app.PendingIntent r1 = r13.geofenceTransitionPendingIntent
            r13.tearDownGeofences(r1)
            goto L72
        L63:
            bo.app.va r7 = new bo.app.va
            r7.<init>(r1)
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 7
            r9 = 0
            r2 = r10
            r3 = r13
            com.braze.support.BrazeLogger.brazelog$default(r2, r3, r4, r5, r6, r7, r8, r9)
        L72:
            int r1 = r14.f2796g
            if (r1 < 0) goto L88
            r13.maxNumToRegister = r1
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.I
            bo.app.wa r7 = new bo.app.wa
            r7.<init>(r13)
            r5 = 0
            r6 = 0
            r8 = 6
            r9 = 0
            r2 = r10
            r3 = r13
            com.braze.support.BrazeLogger.brazelog$default(r2, r3, r4, r5, r6, r7, r8, r9)
        L88:
            bo.app.rc r1 = r13.brazeGeofenceReEligibilityManager
            r1.getClass()
            kotlin.jvm.internal.t.i(r14, r0)
            int r0 = r14.f2794e
            if (r0 < 0) goto La6
            r1.f3769g = r0
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.I
            bo.app.ac r7 = new bo.app.ac
            r7.<init>(r0)
            r5 = 0
            r6 = 0
            r8 = 6
            r9 = 0
            r2 = r10
            r3 = r1
            com.braze.support.BrazeLogger.brazelog$default(r2, r3, r4, r5, r6, r7, r8, r9)
        La6:
            int r14 = r14.f2795f
            if (r14 < 0) goto Lbc
            r1.f3770h = r14
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.I
            bo.app.bc r7 = new bo.app.bc
            r7.<init>(r14)
            r5 = 0
            r6 = 0
            r8 = 6
            r9 = 0
            r2 = r10
            r3 = r1
            com.braze.support.BrazeLogger.brazelog$default(r2, r3, r4, r5, r6, r7, r8, r9)
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.managers.BrazeGeofenceManager.configureFromServerConfig(bo.app.fb0):void");
    }

    public final BrazeGeofence getBrazeGeofenceForGeofenceId(String geofenceId) {
        Object next;
        t.i(geofenceId, "geofenceId");
        ReentrantLock reentrantLock = this.geofenceListLock;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.brazeGeofences.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (t.d(((BrazeGeofence) next).getId(), geofenceId)) {
                    break;
                }
            }
            return (BrazeGeofence) next;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final List<BrazeGeofence> getBrazeGeofences() {
        return this.brazeGeofences;
    }

    public final int getMaxNumToRegister() {
        return this.maxNumToRegister;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void initializeGeofences() {
        /*
            r9 = this;
            com.braze.support.BrazeLogger r8 = com.braze.support.BrazeLogger.INSTANCE
            bo.app.xa r5 = bo.app.xa.f4256a
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 7
            r7 = 0
            r0 = r8
            r1 = r9
            com.braze.support.BrazeLogger.brazelog$default(r0, r1, r2, r3, r4, r5, r6, r7)
            com.braze.managers.BrazeGeofenceManager$Companion r0 = com.braze.managers.BrazeGeofenceManager.Companion
            bo.app.vb0 r1 = r9.serverConfigStorageProvider
            boolean r0 = r0.getGeofencesEnabledFromServerConfig(r1)
            r1 = 1
            if (r0 == 0) goto L30
            android.content.Context r0 = r9.applicationContext
            java.lang.String r2 = "applicationContext"
            kotlin.jvm.internal.t.h(r0, r2)
            boolean r0 = r9.isGeofencesEnabledFromEnvironment(r0)
            if (r0 == 0) goto L30
            bo.app.qa r0 = r9.brazeGeofenceApi
            boolean r0 = r0.a()
            if (r0 == 0) goto L30
            r0 = r1
            goto L31
        L30:
            r0 = 0
        L31:
            r9.isGeofencesEnabled = r0
            com.braze.configuration.BrazeConfigurationProvider r0 = r9.configurationProvider
            boolean r0 = r0.isAutomaticGeofenceRequestsEnabled()
            if (r0 == 0) goto L3f
            r9.requestGeofenceRefresh(r1)
            goto L4b
        L3f:
            bo.app.ya r5 = bo.app.ya.f4347a
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 7
            r7 = 0
            r0 = r8
            r1 = r9
            com.braze.support.BrazeLogger.brazelog$default(r0, r1, r2, r3, r4, r5, r6, r7)
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.managers.BrazeGeofenceManager.initializeGeofences():void");
    }

    public final boolean isGeofencesEnabled() {
        return this.isGeofencesEnabled;
    }

    public final boolean isGeofencesEnabledFromEnvironment(Context context) {
        boolean z10;
        t.i(context, "context");
        if (!Companion.getGeofencesEnabledFromConfiguration(this.configurationProvider)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) za.f4419a, 7, (Object) null);
            return false;
        }
        if (!PermissionUtils.hasPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) ab.f2365a, 6, (Object) null);
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29 && !PermissionUtils.hasPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) bb.f2438a, 6, (Object) null);
            return false;
        }
        t.i(context, "context");
        int iIsGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        if (iIsGooglePlayServicesAvailable == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) com.braze.support.h.f8120a, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) wz.f4233a, 7, (Object) null);
            z10 = true;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) com.braze.support.h.f8120a, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new xz(iIsGooglePlayServicesAvailable), 7, (Object) null);
            z10 = false;
        }
        if (!z10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) cb.f2497a, 7, (Object) null);
            return false;
        }
        if (!this.brazeGeofenceApi.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) db.f2638a, 7, (Object) null);
            return false;
        }
        try {
            Class.forName("com.google.android.gms.location.LocationServices", false, BrazeGeofenceManager.class.getClassLoader());
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) fb.f2789a, 7, (Object) null);
            return true;
        } catch (Exception unused) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) eb.f2720a, 7, (Object) null);
            return false;
        }
    }

    public void onLocationRequestComplete(IBrazeLocation iBrazeLocation) {
        if (iBrazeLocation == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) hb.f2967a, 7, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new gb(iBrazeLocation), 7, (Object) null);
        requestGeofenceRefresh(iBrazeLocation);
        this.brazeGeofenceReEligibilityManager.a(DateTimeUtils.nowInSeconds());
    }

    public void postGeofenceReport(String id, GeofenceTransitionType transitionType) {
        k0 k0Var;
        t.i(id, "geofenceId");
        t.i(transitionType, "transitionType");
        if (!this.isGeofencesEnabled) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) ib.f3041a, 6, (Object) null);
            return;
        }
        z9 z9Var = ba.f2429g;
        String string = transitionType.toString();
        Locale US = Locale.US;
        t.h(US, "US");
        String eventType = string.toLowerCase(US);
        t.h(eventType, "this as java.lang.String).toLowerCase(locale)");
        z9Var.getClass();
        t.i(id, "id");
        t.i(eventType, "eventType");
        e00 geofenceEvent = z9Var.a(new d9(id, eventType));
        if (geofenceEvent != null) {
            if (analyticsEnabledForGeofenceId(id, transitionType)) {
                ((tf) this.brazeManager).a(geofenceEvent);
            }
            BrazeGeofence brazeGeofenceForGeofenceId = getBrazeGeofenceForGeofenceId(id);
            if (brazeGeofenceForGeofenceId != null && this.brazeGeofenceReEligibilityManager.a(DateTimeUtils.nowInSeconds(), brazeGeofenceForGeofenceId, transitionType)) {
                tf tfVar = (tf) this.brazeManager;
                tfVar.getClass();
                t.i(geofenceEvent, "geofenceEvent");
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) tfVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) kf.f3247a, 7, (Object) null);
                tfVar.a(new tz(tfVar.f3924f, tfVar.f3923e.getBaseUrlForRequests(), geofenceEvent));
            }
            k0Var = k0.f35197a;
        } else {
            k0Var = null;
        }
        if (k0Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) null, false, (h9.a) new jb(id, transitionType), 6, (Object) null);
        }
    }

    public void registerGeofences(List<BrazeGeofence> geofenceList) {
        BrazeGeofenceManager brazeGeofenceManager = this;
        t.i(geofenceList, "geofenceList");
        List<BrazeGeofence> brazeGeofenceList = d0.R0(geofenceList);
        if (!brazeGeofenceManager.isGeofencesEnabled) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) kb.f3237a, 6, (Object) null);
            return;
        }
        if (brazeGeofenceManager.geofenceRequestLocation != null) {
            for (BrazeGeofence brazeGeofence : brazeGeofenceList) {
                IBrazeLocation iBrazeLocation = brazeGeofenceManager.geofenceRequestLocation;
                if (iBrazeLocation != null) {
                    double latitude = iBrazeLocation.getLatitude();
                    double longitude = iBrazeLocation.getLongitude();
                    double latitude2 = brazeGeofence.getLatitude();
                    double longitude2 = brazeGeofence.getLongitude();
                    double radians = Math.toRadians(latitude2 - latitude);
                    double radians2 = Math.toRadians(longitude2 - longitude);
                    double d10 = 2;
                    brazeGeofence.setDistanceFromGeofenceRefresh(Math.asin(Math.sqrt((Math.cos(Math.toRadians(latitude2)) * Math.cos(Math.toRadians(latitude)) * Math.pow(Math.sin(radians2 / d10), 2.0d)) + Math.pow(Math.sin(radians / d10), 2.0d))) * 1.2742E7d);
                }
                brazeGeofenceManager = this;
            }
            z.z(brazeGeofenceList);
        }
        ReentrantLock reentrantLock = this.geofenceListLock;
        reentrantLock.lock();
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new lb(brazeGeofenceList), 7, (Object) null);
            SharedPreferences.Editor editorEdit = this.geofenceStorageSharedPreferences.edit();
            editorEdit.clear();
            this.brazeGeofences.clear();
            Iterator it = brazeGeofenceList.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BrazeGeofence brazeGeofence2 = (BrazeGeofence) it.next();
                if (i10 == this.maxNumToRegister) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new mb(this), 7, (Object) null);
                    break;
                }
                this.brazeGeofences.add(brazeGeofence2);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new nb(brazeGeofence2), 7, (Object) null);
                editorEdit.putString(brazeGeofence2.getId(), brazeGeofence2.forJsonPut().toString());
                i10++;
            }
            editorEdit.apply();
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ob(this), 7, (Object) null);
            k0 k0Var = k0.f35197a;
            reentrantLock.unlock();
            rc rcVar = this.brazeGeofenceReEligibilityManager;
            rcVar.getClass();
            t.i(brazeGeofenceList, "brazeGeofenceList");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it2 = brazeGeofenceList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.add(((BrazeGeofence) it2.next()).getId());
            }
            HashSet<String> hashSet = new HashSet(rcVar.f3765c.keySet());
            SharedPreferences.Editor editorEdit2 = rcVar.f3764b.edit();
            for (String reEligibilityId : hashSet) {
                t.h(reEligibilityId, "reEligibilityId");
                if (linkedHashSet.contains(rcVar.a(reEligibilityId))) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) rcVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new pc(reEligibilityId), 7, (Object) null);
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) rcVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new oc(reEligibilityId), 7, (Object) null);
                    rcVar.f3765c.remove(reEligibilityId);
                    editorEdit2.remove(reEligibilityId);
                }
            }
            editorEdit2.apply();
            setUpGeofences(true);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void registerGeofencesWithGooglePlay(List<BrazeGeofence> geofenceList, PendingIntent geofenceRequestIntent) {
        t.i(geofenceList, "geofenceList");
        t.i(geofenceRequestIntent, "geofenceRequestIntent");
        qa qaVar = this.brazeGeofenceApi;
        Context context = this.applicationContext;
        t.h(context, "applicationContext");
        qaVar.getClass();
        t.i(context, "context");
        t.i(geofenceList, "geofenceList");
        t.i(geofenceRequestIntent, "geofenceRequestIntent");
        IBrazeGeofenceApi iBrazeGeofenceApi = qaVar.f3695a;
        if (iBrazeGeofenceApi != null) {
            iBrazeGeofenceApi.registerGeofences(context, geofenceList, geofenceRequestIntent);
        }
    }

    public void requestGeofenceRefresh(IBrazeLocation location) {
        t.i(location, "location");
        if (!this.isGeofencesEnabled) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) pb.f3616a, 7, (Object) null);
            return;
        }
        this.geofenceRequestLocation = location;
        if (location != null) {
            tf tfVar = (tf) this.brazeManager;
            tfVar.getClass();
            t.i(location, "location");
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) tfVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) of.f3561a, 7, (Object) null);
            tfVar.a(new rz(tfVar.f3924f, tfVar.f3923e.getBaseUrlForRequests(), location));
        }
    }

    public final void requestSingleLocationUpdateFromGooglePlay() {
        sd sdVar = this.brazeLocationApi;
        rb manualLocationUpdateCallback = new rb(this);
        sdVar.getClass();
        t.i(manualLocationUpdateCallback, "manualLocationUpdateCallback");
        IBrazeLocationApi iBrazeLocationApi = sdVar.f3849a;
        if (iBrazeLocationApi != null) {
            iBrazeLocationApi.requestSingleLocationUpdate(manualLocationUpdateCallback);
        }
    }

    public final void setUpGeofences(boolean z10) {
        if (!this.isGeofencesEnabled) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) sb.f3845a, 7, (Object) null);
            return;
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new tb(z10), 6, (Object) null);
        PendingIntent pendingIntent = this.geofenceTransitionPendingIntent;
        if (pendingIntent == null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) ub.f4004a, 7, (Object) null);
            return;
        }
        if (z10) {
            ReentrantLock reentrantLock = this.geofenceListLock;
            reentrantLock.lock();
            try {
                registerGeofencesWithGooglePlay(this.brazeGeofences, pendingIntent);
                k0 k0Var = k0.f35197a;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void tearDownGeofences(PendingIntent intent) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) vb.f4101a, 7, (Object) null);
        if (intent != null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) wb.f4188a, 7, (Object) null);
            qa qaVar = this.brazeGeofenceApi;
            Context applicationContext = this.applicationContext;
            t.h(applicationContext, "applicationContext");
            qaVar.getClass();
            t.i(applicationContext, "applicationContext");
            t.i(intent, "intent");
            IBrazeGeofenceApi iBrazeGeofenceApi = qaVar.f3695a;
            if (iBrazeGeofenceApi != null) {
                iBrazeGeofenceApi.teardownGeofences(applicationContext, intent);
            }
        }
        ReentrantLock reentrantLock = this.geofenceListLock;
        reentrantLock.lock();
        try {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) xb.f4258a, 7, (Object) null);
            this.geofenceStorageSharedPreferences.edit().clear().apply();
            this.brazeGeofences.clear();
            k0 k0Var = k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void requestGeofenceRefresh(boolean z10) {
        if (!this.isGeofencesEnabled) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) qb.f3699a, 7, (Object) null);
            return;
        }
        rc rcVar = this.brazeGeofenceReEligibilityManager;
        long jNowInSeconds = DateTimeUtils.nowInSeconds() - rcVar.f3767e;
        if (!z10 && rcVar.f3769g > jNowInSeconds) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) rcVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ic(jNowInSeconds, rcVar), 7, (Object) null);
            return;
        }
        if (z10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) rcVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new jc(jNowInSeconds), 7, (Object) null);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) rcVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new kc(jNowInSeconds, rcVar), 7, (Object) null);
        }
        if (rcVar.f3766d.compareAndSet(false, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) rcVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) lc.f3324a, 7, (Object) null);
            requestSingleLocationUpdateFromGooglePlay();
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) rcVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) mc.f3407a, 7, (Object) null);
        }
    }
}
