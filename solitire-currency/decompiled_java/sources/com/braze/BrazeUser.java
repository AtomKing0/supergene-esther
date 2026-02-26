package com.braze;

import bo.app.aj;
import bo.app.ak;
import bo.app.ba;
import bo.app.bj;
import bo.app.bk;
import bo.app.cj;
import bo.app.di;
import bo.app.dj;
import bo.app.dk;
import bo.app.e00;
import bo.app.ei;
import bo.app.ej;
import bo.app.ek;
import bo.app.fi;
import bo.app.fj;
import bo.app.fk;
import bo.app.gi;
import bo.app.gk;
import bo.app.h00;
import bo.app.hi;
import bo.app.hj;
import bo.app.hk;
import bo.app.ii;
import bo.app.ij;
import bo.app.ik;
import bo.app.j9;
import bo.app.ji;
import bo.app.jj;
import bo.app.jk;
import bo.app.ki;
import bo.app.kj;
import bo.app.kk;
import bo.app.l9;
import bo.app.li;
import bo.app.lj;
import bo.app.lk;
import bo.app.mi;
import bo.app.mj;
import bo.app.mk;
import bo.app.ni;
import bo.app.nj;
import bo.app.nk;
import bo.app.o9;
import bo.app.oi;
import bo.app.oj;
import bo.app.ok;
import bo.app.pj;
import bo.app.pk;
import bo.app.qa0;
import bo.app.qj;
import bo.app.qk;
import bo.app.r9;
import bo.app.ri;
import bo.app.rj;
import bo.app.rk;
import bo.app.s8;
import bo.app.si;
import bo.app.sj;
import bo.app.tf;
import bo.app.ti;
import bo.app.tj;
import bo.app.u9;
import bo.app.uh0;
import bo.app.ui;
import bo.app.uj;
import bo.app.uk;
import bo.app.v9;
import bo.app.vb0;
import bo.app.vi;
import bo.app.vj;
import bo.app.vk;
import bo.app.w9;
import bo.app.wi;
import bo.app.wj;
import bo.app.wn;
import bo.app.xi;
import bo.app.xj;
import bo.app.y00;
import bo.app.yi;
import bo.app.yj;
import bo.app.z9;
import bo.app.zc0;
import bo.app.zi;
import bo.app.zj;
import com.braze.enums.BrazeDateFormat;
import com.braze.enums.Gender;
import com.braze.enums.Month;
import com.braze.enums.NotificationSubscriptionType;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.ValidationUtils;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class BrazeUser {
    private final h00 brazeManager;
    private volatile String internalUserId;
    private final y00 locationManager;
    private final vb0 serverConfigStorageProvider;
    private final uh0 userCache;
    private final ReentrantLock userIdLock;

    public BrazeUser(uh0 userCache, h00 brazeManager, String internalUserId, y00 locationManager, vb0 serverConfigStorageProvider) {
        kotlin.jvm.internal.t.i(userCache, "userCache");
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        kotlin.jvm.internal.t.i(internalUserId, "internalUserId");
        kotlin.jvm.internal.t.i(locationManager, "locationManager");
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        this.userCache = userCache;
        this.brazeManager = brazeManager;
        this.internalUserId = internalUserId;
        this.locationManager = locationManager;
        this.serverConfigStorageProvider = serverConfigStorageProvider;
        this.userIdLock = new ReentrantLock();
    }

    public static /* synthetic */ boolean incrementCustomUserAttribute$default(BrazeUser brazeUser, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 1;
        }
        return brazeUser.incrementCustomUserAttribute(str, i10);
    }

    public static /* synthetic */ boolean setCustomAttribute$default(BrazeUser brazeUser, String str, Object obj, boolean z10, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return brazeUser.setCustomAttribute(str, obj, z10);
    }

    public final boolean addAlias(String alias, String label) {
        kotlin.jvm.internal.t.i(alias, "alias");
        kotlin.jvm.internal.t.i(label, "label");
        if (p9.q.z(alias)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) di.f2658a, 6, (Object) null);
            return false;
        }
        if (p9.q.z(label)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) ei.f2737a, 6, (Object) null);
            return false;
        }
        try {
            z9 z9Var = ba.f2429g;
            z9Var.getClass();
            kotlin.jvm.internal.t.i(alias, "alias");
            kotlin.jvm.internal.t.i(label, "label");
            e00 e00VarA = z9Var.a(new w9(alias, label));
            if (e00VarA != null) {
                return ((tf) this.brazeManager).a(e00VarA);
            }
            return false;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new fi(alias), 4, (Object) null);
            return false;
        }
    }

    public final boolean addToCustomAttributeArray(String key, String value) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(value, "value");
        try {
            if (!com.braze.support.d.a(key, this.serverConfigStorageProvider.a())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) gi.f2914a, 6, (Object) null);
                return false;
            }
            if (value == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) com.braze.support.d.f8115a, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) wn.f4221a, 6, (Object) null);
                return false;
            }
            String key2 = ValidationUtils.ensureBrazeFieldLength(key);
            String value2 = ValidationUtils.ensureBrazeFieldLength(value);
            z9 z9Var = ba.f2429g;
            z9Var.getClass();
            kotlin.jvm.internal.t.i(key2, "key");
            kotlin.jvm.internal.t.i(value2, "value");
            e00 e00VarA = z9Var.a(new s8(key2, value2));
            if (e00VarA == null) {
                return false;
            }
            return ((tf) this.brazeManager).a(e00VarA);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new hi(key), 4, (Object) null);
            return false;
        }
    }

    public final boolean addToSubscriptionGroup(String subscriptionGroupId) {
        kotlin.jvm.internal.t.i(subscriptionGroupId, "subscriptionGroupId");
        try {
            if (p9.q.z(subscriptionGroupId)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) ii.f3064a, 6, (Object) null);
                return false;
            }
            z9 z9Var = ba.f2429g;
            zc0 subscriptionGroupStatus = zc0.SUBSCRIBED;
            z9Var.getClass();
            kotlin.jvm.internal.t.i(subscriptionGroupId, "subscriptionGroupId");
            kotlin.jvm.internal.t.i(subscriptionGroupStatus, "subscriptionGroupStatus");
            e00 e00VarA = z9Var.a(new v9(subscriptionGroupId, subscriptionGroupStatus));
            if (e00VarA == null) {
                return true;
            }
            ((tf) this.brazeManager).a(e00VarA);
            return true;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new ji(subscriptionGroupId), 4, (Object) null);
            return false;
        }
    }

    public final String getUserId() {
        ReentrantLock reentrantLock = this.userIdLock;
        reentrantLock.lock();
        try {
            return this.internalUserId;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean incrementCustomUserAttribute(String key, int i10) {
        kotlin.jvm.internal.t.i(key, "key");
        try {
            if (!com.braze.support.d.a(key, this.serverConfigStorageProvider.a())) {
                return false;
            }
            String customUserAttributeKey = ValidationUtils.ensureBrazeFieldLength(key);
            z9 z9Var = ba.f2429g;
            z9Var.getClass();
            kotlin.jvm.internal.t.i(customUserAttributeKey, "customUserAttributeKey");
            e00 e00VarA = z9Var.a(new j9(customUserAttributeKey, i10));
            if (e00VarA == null) {
                return false;
            }
            return ((tf) this.brazeManager).a(e00VarA);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new ki(key, i10), 4, (Object) null);
            return false;
        }
    }

    public final boolean removeFromCustomAttributeArray(String key, String value) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(value, "value");
        try {
            if (!com.braze.support.d.a(key, this.serverConfigStorageProvider.a())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) li.f3337a, 6, (Object) null);
                return false;
            }
            if (value == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) com.braze.support.d.f8115a, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) wn.f4221a, 6, (Object) null);
                return false;
            }
            String key2 = ValidationUtils.ensureBrazeFieldLength(key);
            String value2 = ValidationUtils.ensureBrazeFieldLength(value);
            z9 z9Var = ba.f2429g;
            z9Var.getClass();
            kotlin.jvm.internal.t.i(key2, "key");
            kotlin.jvm.internal.t.i(value2, "value");
            e00 e00VarA = z9Var.a(new r9(key2, value2));
            if (e00VarA == null) {
                return false;
            }
            return ((tf) this.brazeManager).a(e00VarA);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new mi(key), 4, (Object) null);
            return false;
        }
    }

    public final boolean removeFromSubscriptionGroup(String subscriptionGroupId) {
        kotlin.jvm.internal.t.i(subscriptionGroupId, "subscriptionGroupId");
        try {
            if (p9.q.z(subscriptionGroupId)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) ni.f3491a, 6, (Object) null);
                return false;
            }
            z9 z9Var = ba.f2429g;
            zc0 subscriptionGroupStatus = zc0.UNSUBSCRIBED;
            z9Var.getClass();
            kotlin.jvm.internal.t.i(subscriptionGroupId, "subscriptionGroupId");
            kotlin.jvm.internal.t.i(subscriptionGroupStatus, "subscriptionGroupStatus");
            e00 e00VarA = z9Var.a(new v9(subscriptionGroupId, subscriptionGroupStatus));
            if (e00VarA == null) {
                return true;
            }
            ((tf) this.brazeManager).a(e00VarA);
            return true;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new oi(subscriptionGroupId), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCountry(String str) {
        if (str != null) {
            try {
                if (p9.q.z(str)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) ri.f3791a, 6, (Object) null);
                    return false;
                }
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new ti(str), 4, (Object) null);
                return false;
            }
        }
        kotlinx.coroutines.k.d(qa0.f3696a, null, null, new si(this, str, null), 3, null);
        return true;
    }

    public final boolean setCustomAttribute(String key, Object value, boolean z10) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(value, "value");
        if (!com.braze.support.d.a(key, this.serverConfigStorageProvider.a())) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) ui.f4025a, 6, (Object) null);
            return false;
        }
        String key2 = ValidationUtils.ensureBrazeFieldLength(key);
        Object objA = com.braze.support.d.f8115a.a(value, 0);
        if (objA == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new vi(key, value), 6, (Object) null);
            return false;
        }
        if (!(objA instanceof JSONObject) || !z10) {
            kotlinx.coroutines.k.d(qa0.f3696a, null, null, new xi(this, key2, objA, null), 3, null);
            return true;
        }
        z9 z9Var = ba.f2429g;
        JSONObject json = (JSONObject) objA;
        z9Var.getClass();
        kotlin.jvm.internal.t.i(key2, "key");
        kotlin.jvm.internal.t.i(json, "json");
        e00 e00VarA = z9Var.a(new o9(key2, json));
        if (e00VarA != null) {
            return ((tf) this.brazeManager).a(e00VarA);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new wi(key2, objA), 6, (Object) null);
        return false;
    }

    public final boolean setCustomAttributeArray(String key, String[] values) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(values, "values");
        try {
            if (!com.braze.support.d.a(key, this.serverConfigStorageProvider.a())) {
                return false;
            }
            String key2 = ValidationUtils.ensureBrazeFieldLength(key);
            kotlin.jvm.internal.t.i(values, "values");
            ArrayList arrayList = new ArrayList(values.length);
            for (String str : values) {
                arrayList.add(ValidationUtils.ensureBrazeFieldLength(str));
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            z9 z9Var = ba.f2429g;
            z9Var.getClass();
            kotlin.jvm.internal.t.i(key2, "key");
            e00 e00VarA = z9Var.a(new u9(key2, strArr));
            if (e00VarA == null) {
                return false;
            }
            return ((tf) this.brazeManager).a(e00VarA);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new yi(key), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomAttributeToSecondsFromEpoch(String key, long j10) {
        kotlin.jvm.internal.t.i(key, "key");
        return setCustomAttribute$default(this, key, DateTimeUtils.createDate(j10), false, 4, null);
    }

    public final boolean setCustomUserAttribute(String key, boolean z10) {
        kotlin.jvm.internal.t.i(key, "key");
        try {
            return setCustomAttribute$default(this, key, Boolean.valueOf(z10), false, 4, null);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new zi(key), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomUserAttributeToNow(String key) {
        kotlin.jvm.internal.t.i(key, "key");
        try {
            return setCustomAttributeToSecondsFromEpoch(key, DateTimeUtils.nowInSeconds());
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new hj(key), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomUserAttributeToSecondsFromEpoch(String key, long j10) {
        kotlin.jvm.internal.t.i(key, "key");
        try {
            return setCustomAttributeToSecondsFromEpoch(key, j10);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new ij(key, j10), 4, (Object) null);
            return false;
        }
    }

    public final boolean setDateOfBirth(int i10, Month month, int i11) {
        kotlin.jvm.internal.t.i(month, "month");
        try {
            kotlinx.coroutines.k.d(qa0.f3696a, null, null, new jj(this, DateTimeUtils.formatDate$default(DateTimeUtils.createDate(i10, month.getValue(), i11, (56 & 8) != 0 ? 0 : 0, (56 & 16) != 0 ? 0 : 0, (56 & 32) != 0 ? 0 : 0), BrazeDateFormat.SHORT, null, 2, null), null), 3, null);
            return true;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new kj(i10, month, i11), 4, (Object) null);
            return false;
        }
    }

    public final boolean setEmail(String str) {
        String string;
        if (str != null) {
            try {
                if (p9.q.z(str)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) lj.f3339a, 6, (Object) null);
                    return false;
                }
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new oj(str), 4, (Object) null);
                return false;
            }
        }
        if (str != null) {
            int length = str.length() - 1;
            int i10 = 0;
            boolean z10 = false;
            while (i10 <= length) {
                boolean z11 = kotlin.jvm.internal.t.k(str.charAt(!z10 ? i10 : length), 32) <= 0;
                if (z10) {
                    if (!z11) {
                        break;
                    }
                    length--;
                } else if (z11) {
                    i10++;
                } else {
                    z10 = true;
                }
            }
            string = str.subSequence(i10, length + 1).toString();
        } else {
            string = null;
        }
        if (string != null && !ValidationUtils.isValidEmailAddress(string)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new nj(str), 7, (Object) null);
            return false;
        }
        kotlinx.coroutines.k.d(qa0.f3696a, null, null, new mj(this, string, null), 3, null);
        return true;
    }

    public final boolean setEmailNotificationSubscriptionType(NotificationSubscriptionType emailNotificationSubscriptionType) {
        kotlin.jvm.internal.t.i(emailNotificationSubscriptionType, "emailNotificationSubscriptionType");
        try {
            kotlinx.coroutines.k.d(qa0.f3696a, null, null, new pj(this, emailNotificationSubscriptionType, null), 3, null);
            return true;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new qj(emailNotificationSubscriptionType), 4, (Object) null);
            return false;
        }
    }

    public final boolean setFirstName(String str) {
        if (str != null) {
            try {
                if (p9.q.z(str)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) rj.f3794a, 6, (Object) null);
                    return false;
                }
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new tj(str), 4, (Object) null);
                return false;
            }
        }
        kotlinx.coroutines.k.d(qa0.f3696a, null, null, new sj(this, str, null), 3, null);
        return true;
    }

    public final boolean setGender(Gender gender) {
        kotlin.jvm.internal.t.i(gender, "gender");
        try {
            kotlinx.coroutines.k.d(qa0.f3696a, null, null, new uj(this, gender, null), 3, null);
            return true;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new vj(gender), 4, (Object) null);
            return false;
        }
    }

    public final boolean setHomeCity(String str) {
        if (str != null) {
            try {
                if (p9.q.z(str)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) wj.f4214a, 6, (Object) null);
                    return false;
                }
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new yj(str), 4, (Object) null);
                return false;
            }
        }
        kotlinx.coroutines.k.d(qa0.f3696a, null, null, new xj(this, str, null), 3, null);
        return true;
    }

    public final boolean setLanguage(String str) {
        if (str != null) {
            try {
                if (p9.q.z(str)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) zj.f4448a, 6, (Object) null);
                    return false;
                }
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new bk(str), 4, (Object) null);
                return false;
            }
        }
        kotlinx.coroutines.k.d(qa0.f3696a, null, null, new ak(this, str, null), 3, null);
        return true;
    }

    public final boolean setLastName(String str) {
        if (str != null) {
            try {
                if (p9.q.z(str)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) dk.f2661a, 6, (Object) null);
                    return false;
                }
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new fk(str), 4, (Object) null);
                return false;
            }
        }
        kotlinx.coroutines.k.d(qa0.f3696a, null, null, new ek(this, str, null), 3, null);
        return true;
    }

    public final void setLocationCustomAttribute(String key, double d10, double d11) {
        kotlin.jvm.internal.t.i(key, "key");
        try {
            if (!com.braze.support.d.a(key, this.serverConfigStorageProvider.a())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) gk.f2916a, 6, (Object) null);
                return;
            }
            if (!ValidationUtils.isValidLocation(d10, d11)) {
                try {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new hk(d10, d11), 6, (Object) null);
                    return;
                } catch (Exception e10) {
                    e = e10;
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e, false, (h9.a) new ik(key, d10, d11), 4, (Object) null);
                    return;
                }
            }
            String key2 = ValidationUtils.ensureBrazeFieldLength(key);
            z9 z9Var = ba.f2429g;
            z9Var.getClass();
            kotlin.jvm.internal.t.i(key2, "key");
            e00 e00VarA = z9Var.a(new l9(key2, d10, d11));
            if (e00VarA != null) {
                ((tf) this.brazeManager).a(e00VarA);
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public final boolean setPhoneNumber(String str) {
        String string;
        if (str != null) {
            try {
                if (p9.q.z(str)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) jk.f3165a, 6, (Object) null);
                    return false;
                }
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new mk(str), 4, (Object) null);
                return false;
            }
        }
        if (str != null) {
            int length = str.length() - 1;
            int i10 = 0;
            boolean z10 = false;
            while (i10 <= length) {
                boolean z11 = kotlin.jvm.internal.t.k(str.charAt(!z10 ? i10 : length), 32) <= 0;
                if (z10) {
                    if (!z11) {
                        break;
                    }
                    length--;
                } else if (z11) {
                    i10++;
                } else {
                    z10 = true;
                }
            }
            string = str.subSequence(i10, length + 1).toString();
        } else {
            string = null;
        }
        if (string != null && !ValidationUtils.isValidPhoneNumber(string)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new lk(string), 6, (Object) null);
            return false;
        }
        kotlinx.coroutines.k.d(qa0.f3696a, null, null, new kk(this, string, null), 3, null);
        return true;
    }

    public final boolean setPushNotificationSubscriptionType(NotificationSubscriptionType pushNotificationSubscriptionType) {
        kotlin.jvm.internal.t.i(pushNotificationSubscriptionType, "pushNotificationSubscriptionType");
        try {
            kotlinx.coroutines.k.d(qa0.f3696a, null, null, new nk(this, pushNotificationSubscriptionType, null), 3, null);
            return true;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new ok(pushNotificationSubscriptionType), 4, (Object) null);
            return false;
        }
    }

    public final void setUserId(String userId) {
        kotlin.jvm.internal.t.i(userId, "userId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new uk(userId), 6, (Object) null);
        ReentrantLock reentrantLock = this.userIdLock;
        reentrantLock.lock();
        try {
            if (!kotlin.jvm.internal.t.d(this.internalUserId, "") && !kotlin.jvm.internal.t.d(this.internalUserId, userId)) {
                throw new IllegalArgumentException("setExternalId can not be used to change the external ID of a UserCache from a non-empty value to a new value. Was: [" + this.internalUserId + "], tried to change to: [" + userId + ']');
            }
            this.internalUserId = userId;
            kotlinx.coroutines.k.d(qa0.f3696a, null, null, new vk(this, userId, null), 3, null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean unsetCustomUserAttribute(String key) {
        kotlin.jvm.internal.t.i(key, "key");
        try {
            if (com.braze.support.d.a(key, this.serverConfigStorageProvider.a())) {
                kotlinx.coroutines.k.d(qa0.f3696a, null, null, new qk(this, key, null), 3, null);
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) pk.f3635a, 6, (Object) null);
            return false;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new rk(key), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String key, int i10) {
        kotlin.jvm.internal.t.i(key, "key");
        try {
            return setCustomAttribute$default(this, key, Integer.valueOf(i10), false, 4, null);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new aj(key), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String key, float f10) {
        kotlin.jvm.internal.t.i(key, "key");
        try {
            return setCustomAttribute$default(this, key, Float.valueOf(f10), false, 4, null);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new bj(key), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String key, long j10) {
        kotlin.jvm.internal.t.i(key, "key");
        try {
            return setCustomAttribute$default(this, key, Long.valueOf(j10), false, 4, null);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new cj(key), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String key, String value) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(value, "value");
        try {
            return setCustomAttribute$default(this, key, value, false, 4, null);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new dj(key), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String key, double d10) {
        kotlin.jvm.internal.t.i(key, "key");
        try {
            return setCustomAttribute$default(this, key, Double.valueOf(d10), false, 4, null);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new ej(key), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String key, JSONObject value, boolean z10) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(value, "value");
        try {
            return setCustomAttribute(key, value, z10);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new fj(key, value), 4, (Object) null);
            return false;
        }
    }
}
