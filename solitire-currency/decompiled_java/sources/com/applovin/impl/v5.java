package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v5 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AppLovinAdLoadListener f7618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a f7619h;

    private static final class a extends e7 {
        a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
            super(jSONObject, jSONObject2, jVar);
        }

        void a(b8 b8Var) {
            if (b8Var == null) {
                throw new IllegalArgumentException("No aggregated vast response specified");
            }
            this.f5145b.add(b8Var);
        }
    }

    private static final class b extends v5 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final String f7620i;

        b(String str, e7 e7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
            super(e7Var, appLovinAdLoadListener, jVar);
            this.f7620i = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            b8 b8VarB = b(this.f7620i);
            if (b8VarB != null) {
                a(b8VarB);
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Unable to process XML: " + this.f7620i);
            }
            c(this.f7620i);
            a(f7.XML_PARSING);
        }
    }

    private static final class c extends v5 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final JSONObject f7621i;

        c(e7 e7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
            super(e7Var, appLovinAdLoadListener, jVar);
            this.f7621i = e7Var.b();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Processing SDK JSON response...");
            }
            String string = JsonUtils.getString(this.f7621i, "xml", null);
            if (!StringUtils.isValidString(string)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7679c.b(this.f7678b, "No VAST response received.");
                }
                a(f7.NO_WRAPPER_RESPONSE);
                return;
            }
            if (string.length() >= ((Integer) this.f7677a.a(l4.f5675k4)).intValue()) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7679c.b(this.f7678b, "VAST response is over max length");
                }
                a(f7.XML_PARSING);
                return;
            }
            b8 b8VarB = b(string);
            if (b8VarB != null) {
                a(b8VarB);
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Unable to process XML: " + string);
            }
            c(string);
            a(f7.XML_PARSING);
        }
    }

    private static final class d extends v5 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final b8 f7622i;

        d(b8 b8Var, e7 e7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
            super(e7Var, appLovinAdLoadListener, jVar);
            if (b8Var == null) {
                throw new IllegalArgumentException("No response specified.");
            }
            if (e7Var == null) {
                throw new IllegalArgumentException("No context specified.");
            }
            if (appLovinAdLoadListener == null) {
                throw new IllegalArgumentException("No callback specified.");
            }
            this.f7622i = b8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Processing VAST Wrapper response...");
            }
            a(this.f7622i);
        }
    }

    v5(e7 e7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskProcessVastResponse", jVar);
        if (e7Var == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        this.f7618g = appLovinAdLoadListener;
        this.f7619h = (a) e7Var;
    }

    public static v5 a(JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        return new c(new a(jSONObject, jSONObject2, jVar), appLovinAdLoadListener, jVar);
    }

    protected b8 b(String str) {
        try {
            return c8.a(str, this.f7677a);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Failed to process VAST response", th);
            }
            a(f7.XML_PARSING);
            this.f7677a.A().a(this.f7678b, th);
            return null;
        }
    }

    protected void c(String str) {
        if (str == null) {
            return;
        }
        Iterator<String> it = StringUtils.getRegexMatches(StringUtils.match(str, (String) this.f7677a.a(l4.D4)), 1).iterator();
        while (it.hasNext()) {
            b8 b8VarB = b("<VAST>" + it.next() + "</VAST>");
            if (b8VarB != null) {
                this.f7619h.a(b8VarB);
            }
        }
    }

    public static v5 a(String str, JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        return new b(str, new a(jSONObject, jSONObject2, jVar), appLovinAdLoadListener, jVar);
    }

    public static v5 a(b8 b8Var, e7 e7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        return new d(b8Var, e7Var, appLovinAdLoadListener, jVar);
    }

    void a(b8 b8Var) {
        int iD = this.f7619h.d();
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Finished parsing XML at depth " + iD);
        }
        this.f7619h.a(b8Var);
        if (m7.b(b8Var)) {
            int iIntValue = ((Integer) this.f7677a.a(l4.f5683l4)).intValue();
            if (iD < iIntValue) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7679c.a(this.f7678b, "VAST response is wrapper. Resolving...");
                }
                this.f7677a.j0().a(new d6(this.f7619h, this.f7618g, this.f7677a));
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Reached beyond max wrapper depth of " + iIntValue);
            }
            a(f7.WRAPPER_LIMIT_REACHED);
            return;
        }
        if (m7.a(b8Var)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "VAST response is inline. Rendering ad...");
            }
            this.f7677a.j0().a(new y5(this.f7619h, this.f7618g, this.f7677a));
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.b(this.f7678b, "VAST response is an error");
        }
        a(f7.NO_WRAPPER_RESPONSE);
    }

    void a(f7 f7Var) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.b(this.f7678b, "Failed to process VAST response due to VAST error code " + f7Var);
        }
        m7.a(this.f7619h, this.f7618g, f7Var, -6, this.f7677a);
    }
}
