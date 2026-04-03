package com.braze;

import android.content.Context;
import bo.app.b1;
import bo.app.bi0;
import bo.app.c1;
import bo.app.ci0;
import bo.app.e1;
import bo.app.e50;
import bo.app.f1;
import bo.app.g1;
import bo.app.i1;
import bo.app.j1;
import bo.app.l10;
import bo.app.oe;
import bo.app.p00;
import bo.app.tf;
import bo.app.v00;
import bo.app.vw;
import bo.app.z00;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.FeedUpdatedEvent;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import v8.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Braze f8072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f8073c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(Braze braze, String str, String str2) {
        super(0);
        this.f8071a = str;
        this.f8072b = braze;
        this.f8073c = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        e50 e50Var;
        z00 z00Var;
        String str = this.f8071a;
        if (str == null || str.length() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8072b, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) b1.f2411a, 6, (Object) null);
        } else if (StringUtils.getByteSize(this.f8071a) > 997) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8072b, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new c1(this.f8071a), 6, (Object) null);
        } else {
            BrazeUser brazeUser = this.f8072b.brazeUser;
            if (brazeUser == null) {
                kotlin.jvm.internal.t.A("brazeUser");
                brazeUser = null;
            }
            String userId = brazeUser.getUserId();
            if (kotlin.jvm.internal.t.d(userId, this.f8071a)) {
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                BrazeLogger.brazelog$default(brazeLogger, (Object) this.f8072b, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new e1(this.f8071a), 6, (Object) null);
                String str2 = this.f8073c;
                if (str2 != null && !p9.q.z(str2)) {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this.f8072b, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new f1(this.f8073c), 7, (Object) null);
                    ((ci0) this.f8072b.getUdm$android_sdk_base_release()).f2566r.a(this.f8073c);
                }
            } else {
                vw vwVar = ((ci0) this.f8072b.getUdm$android_sdk_base_release()).f2559k;
                ReentrantLock reentrantLock = vwVar.f4151g;
                reentrantLock.lock();
                try {
                    reentrantLock.unlock();
                    ((ci0) this.f8072b.getUdm$android_sdk_base_release()).f2565q.b();
                    if (kotlin.jvm.internal.t.d(userId, "")) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8072b, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new g1(this.f8071a), 6, (Object) null);
                        e50 e50Var2 = this.f8072b.offlineUserStorageProvider;
                        if (e50Var2 == null) {
                            kotlin.jvm.internal.t.A("offlineUserStorageProvider");
                            e50Var2 = null;
                        }
                        e50Var2.a(this.f8071a);
                        BrazeUser brazeUser2 = this.f8072b.brazeUser;
                        if (brazeUser2 == null) {
                            kotlin.jvm.internal.t.A("brazeUser");
                            brazeUser2 = null;
                        }
                        brazeUser2.setUserId(this.f8071a);
                    } else {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8072b, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new i1(userId, this.f8071a), 6, (Object) null);
                        ((vw) this.f8072b.getExternalIEventMessenger$android_sdk_base_release()).b(FeedUpdatedEvent.class, new FeedUpdatedEvent(new ArrayList(), this.f8071a, false, DateTimeUtils.nowInSeconds()));
                    }
                    tf tfVar = ((ci0) this.f8072b.getUdm$android_sdk_base_release()).f2570v;
                    if (tfVar.f3927i.f3236a.getBoolean("appboy_sdk_disabled", false)) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) tfVar, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) oe.f3559a, 6, (Object) null);
                    } else {
                        tfVar.f3939u = null;
                        tfVar.f3921c.g();
                    }
                    ((ci0) this.f8072b.getUdm$android_sdk_base_release()).f2560l.a();
                    e50 e50Var3 = this.f8072b.offlineUserStorageProvider;
                    if (e50Var3 == null) {
                        kotlin.jvm.internal.t.A("offlineUserStorageProvider");
                        e50Var3 = null;
                    }
                    e50Var3.a(this.f8071a);
                    l10 udm$android_sdk_base_release = this.f8072b.getUdm$android_sdk_base_release();
                    Context context = this.f8072b.applicationContext;
                    e50 e50Var4 = this.f8072b.offlineUserStorageProvider;
                    if (e50Var4 == null) {
                        kotlin.jvm.internal.t.A("offlineUserStorageProvider");
                        e50Var = null;
                    } else {
                        e50Var = e50Var4;
                    }
                    BrazeConfigurationProvider configurationProvider$android_sdk_base_release = this.f8072b.getConfigurationProvider$android_sdk_base_release();
                    v00 externalIEventMessenger$android_sdk_base_release = this.f8072b.getExternalIEventMessenger$android_sdk_base_release();
                    p00 deviceIdProvider$android_sdk_base_release = this.f8072b.getDeviceIdProvider$android_sdk_base_release();
                    z00 z00Var2 = this.f8072b.registrationDataProvider;
                    if (z00Var2 == null) {
                        kotlin.jvm.internal.t.A("registrationDataProvider");
                        z00Var = null;
                    } else {
                        z00Var = z00Var2;
                    }
                    this.f8072b.setUserSpecificMemberVariablesAndStartDispatch(new ci0(context, e50Var, configurationProvider$android_sdk_base_release, externalIEventMessenger$android_sdk_base_release, deviceIdProvider$android_sdk_base_release, z00Var, this.f8072b.getPushDeliveryManager$android_sdk_base_release(), Braze.shouldMockNetworkRequestsAndDropEvents, Braze.areOutboundNetworkRequestsOffline, this.f8072b.getDeviceDataProvider(), Braze.Companion.getShouldRequestFrameworkListenToNetworkUpdates$android_sdk_base_release()));
                    String str3 = this.f8073c;
                    if (str3 != null && !p9.q.z(str3)) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8072b, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new j1(this.f8073c), 7, (Object) null);
                        ((ci0) this.f8072b.getUdm$android_sdk_base_release()).f2566r.a(this.f8073c);
                    }
                    ((ci0) this.f8072b.getUdm$android_sdk_base_release()).x().d();
                    ((ci0) this.f8072b.getUdm$android_sdk_base_release()).f2570v.b();
                    ci0 ci0Var = (ci0) udm$android_sdk_base_release;
                    ci0Var.getClass();
                    kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, null, null, new bi0(ci0Var, null), 3, null);
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
        }
        return k0.f35197a;
    }
}
