package com.applovin.impl;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.applovin.impl.n6;
import com.applovin.impl.sdk.utils.StringUtils;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m6 implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f5878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f5879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Integer f5880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Integer f5881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer f5882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f5883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f5884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f5885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f5886i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f5887j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f5888k;

    public m6(com.applovin.impl.sdk.j jVar) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(com.applovin.impl.sdk.j.n());
        this.f5879b = defaultSharedPreferences;
        this.f5888k = new ArrayList();
        this.f5878a = jVar;
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        this.f5880c = a(n4.f6394p.a());
        this.f5881d = a(n4.f6395q.a());
        this.f5882e = h();
        this.f5883f = (String) o4.a(n4.f6397s, (Object) null, defaultSharedPreferences, false);
        this.f5884g = (String) o4.a(n4.f6398t, (Object) null, defaultSharedPreferences, false);
        this.f5885h = (String) o4.a(n4.f6399u, (Object) null, defaultSharedPreferences, false);
        this.f5886i = (String) o4.a(n4.f6401w, (Object) null, defaultSharedPreferences, false);
        this.f5887j = (String) o4.a(n4.f6403y, (Object) null, defaultSharedPreferences, false);
        c(this.f5884g);
    }

    private Integer h() {
        String strA = n4.f6396r.a();
        if (this.f5879b.contains(strA)) {
            Integer num = (Integer) o4.a(strA, null, Integer.class, this.f5879b, false);
            if (num != null) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    return num;
                }
                this.f5878a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5878a.I().b("TcfManager", "Integer value (" + num + ") for " + strA + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
            Long l10 = (Long) o4.a(strA, null, Long.class, this.f5879b, false);
            if (l10 != null) {
                if (l10.longValue() == 1 || l10.longValue() == 0) {
                    return Integer.valueOf(l10.intValue());
                }
                this.f5878a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5878a.I().b("TcfManager", "Long value (" + l10 + ") for " + strA + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
            Boolean bool = (Boolean) o4.a(strA, null, Boolean.class, this.f5879b, false);
            if (bool != null) {
                return Integer.valueOf(bool.booleanValue() ? 1 : 0);
            }
            String str = (String) o4.a(strA, null, String.class, this.f5879b, false);
            if (str != null) {
                if ("1".equals(str) || com.ironsource.mediationsdk.metadata.a.f13688g.equals(str)) {
                    return 1;
                }
                if ("0".equals(str) || "false".equals(str)) {
                    return 0;
                }
                this.f5878a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5878a.I().b("TcfManager", "String value (" + str + ") for " + strA + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
        }
        return null;
    }

    public void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f5888k.add(((v2) it.next()).t());
        }
        d(this.f5885h);
        b(this.f5884g);
    }

    public boolean b() {
        return p6.a(this.f5884g);
    }

    public String c() {
        return this.f5884g;
    }

    public String d() {
        return k6.a(this.f5880c);
    }

    public Integer e() {
        return this.f5880c;
    }

    public Integer f() {
        return this.f5881d;
    }

    public Integer g() {
        return this.f5882e;
    }

    public List i() {
        return this.f5888k;
    }

    public String j() {
        return a("CMP Name", d()) + a("CMP SDK ID", this.f5880c) + a("CMP SDK Version", this.f5881d) + a(n4.f6396r.a(), this.f5882e) + a(n4.f6397s.a(), this.f5883f) + a(n4.f6398t.a(), this.f5884g);
    }

    public String k() {
        return this.f5883f;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str == null) {
            this.f5878a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5878a.I().a("TcfManager", "SharedPreferences are cleared - setting all stored TC data to null");
            }
            a();
            return;
        }
        if (str.equals(n4.f6394p.a())) {
            this.f5880c = a(str);
            this.f5878a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5878a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f5880c);
            }
            this.f5878a.K0();
            return;
        }
        if (str.equals(n4.f6395q.a())) {
            this.f5881d = a(str);
            this.f5878a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5878a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f5881d);
                return;
            }
            return;
        }
        if (str.equals(n4.f6396r.a())) {
            this.f5882e = h();
            this.f5878a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5878a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f5882e);
                return;
            }
            return;
        }
        if (str.equals(n4.f6397s.a())) {
            this.f5883f = (String) o4.a(str, (Object) null, String.class, sharedPreferences);
            this.f5878a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5878a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f5883f);
            }
            this.f5878a.K0();
            return;
        }
        if (str.equals(n4.f6398t.a())) {
            this.f5884g = (String) o4.a(str, (Object) null, String.class, sharedPreferences);
            this.f5878a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5878a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f5884g);
            }
            c(this.f5884g);
            b(this.f5884g);
            return;
        }
        if (str.equals(n4.f6399u.a())) {
            this.f5885h = (String) o4.a(str, (Object) null, String.class, sharedPreferences);
            this.f5878a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5878a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f5885h);
            }
            d(this.f5885h);
            return;
        }
        if (str.equals(n4.f6400v.a())) {
            String str2 = (String) o4.a(str, (Object) null, String.class, sharedPreferences);
            this.f5878a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5878a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str2);
                return;
            }
            return;
        }
        if (str.equals(n4.f6401w.a())) {
            this.f5886i = (String) o4.a(str, (Object) null, String.class, sharedPreferences);
            this.f5878a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5878a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f5886i);
                return;
            }
            return;
        }
        if (str.equals(n4.f6402x.a())) {
            String str3 = (String) o4.a(str, (Object) null, String.class, sharedPreferences);
            this.f5878a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5878a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str3);
                return;
            }
            return;
        }
        if (str.equals(n4.f6403y.a())) {
            this.f5887j = (String) o4.a(str, (Object) null, String.class, sharedPreferences);
            this.f5878a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5878a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f5887j);
                return;
            }
            return;
        }
        if (str.contains(OTIABTCFKeys.IABTCF_PUBLISHERRESTRICTIONS)) {
            String str4 = (String) o4.a(str, (Object) null, String.class, sharedPreferences);
            this.f5878a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5878a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str4);
            }
        }
    }

    public Boolean b(int i10) {
        String str = this.f5886i;
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(p6.a(str, i10 - 1));
    }

    public Boolean c(int i10) {
        String str = this.f5887j;
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(p6.a(str, i10 - 1));
    }

    public Boolean d(int i10) {
        String str = this.f5885h;
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(p6.a(str, i10 - 1));
    }

    private void b(String str) {
        for (n6 n6Var : this.f5888k) {
            if (n6Var.f() == n6.a.ATP_NETWORK && n6Var.d() != null) {
                n6Var.a(p6.a(n6Var.d().intValue(), str));
            }
        }
    }

    private void c(String str) {
        this.f5878a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f5878a.I().a("TcfManager", "Attempting to update consent from Additional Consent string: " + str);
        }
        Boolean boolA = p6.a(1301, str);
        if (boolA != null) {
            if (boolA.booleanValue()) {
                this.f5878a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5878a.I().a("TcfManager", "Found AppLovin ID in the list of consented ATP IDs - setting user consent to true");
                }
                l0.b(true, com.applovin.impl.sdk.j.n());
            } else {
                this.f5878a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5878a.I().a("TcfManager", "Could not find AppLovin ID in the list of consented ATP IDs - setting user consent to false");
                }
                l0.b(false, com.applovin.impl.sdk.j.n());
            }
            this.f5878a.K0();
            return;
        }
        this.f5878a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f5878a.I().a("TcfManager", "AC string is not valid or AppLovin was not listed on the CMP flow - no consent update");
        }
    }

    private void d(String str) {
        if (str != null) {
            for (n6 n6Var : this.f5888k) {
                if (n6Var.f() == n6.a.TCF_VENDOR && n6Var.d() != null) {
                    n6Var.a(Boolean.valueOf(p6.a(str, n6Var.d().intValue() - 1)));
                }
            }
            return;
        }
        Iterator it = this.f5888k.iterator();
        while (it.hasNext()) {
            ((n6) it.next()).a(null);
        }
    }

    public Boolean a(int i10) {
        return p6.a(i10, this.f5884g);
    }

    private Integer a(String str) {
        if (this.f5879b.contains(str)) {
            Integer num = (Integer) o4.a(str, null, Integer.class, this.f5879b, false);
            if (num != null) {
                return num;
            }
            Long l10 = (Long) o4.a(str, null, Long.class, this.f5879b, false);
            if (l10 != null && l10.longValue() >= -2147483648L && l10.longValue() <= 2147483647L) {
                return Integer.valueOf(l10.intValue());
            }
            String str2 = (String) o4.a(str, null, String.class, this.f5879b, false);
            if (str2 != null) {
                if (StringUtils.isNumeric(str2)) {
                    return Integer.valueOf(Integer.parseInt(str2));
                }
                this.f5878a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5878a.I().b("TcfManager", "String value (" + str2 + ") for " + str + " is not numeric - storing value as null");
                }
            }
        }
        return null;
    }

    private void a() {
        this.f5880c = null;
        this.f5882e = null;
        this.f5883f = null;
        this.f5884g = null;
        this.f5885h = null;
        Iterator it = this.f5888k.iterator();
        while (it.hasNext()) {
            ((n6) it.next()).a(null);
        }
    }

    private String a(String str, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(str);
        sb.append(" - ");
        sb.append(obj != null ? obj.toString() : "No value set");
        return sb.toString();
    }
}
