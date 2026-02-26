package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.iab.omid.library.ironsrc.Omid;
import com.iab.omid.library.ironsrc.adsession.AdEvents;
import com.iab.omid.library.ironsrc.adsession.AdSession;
import com.iab.omid.library.ironsrc.adsession.AdSessionConfiguration;
import com.iab.omid.library.ironsrc.adsession.AdSessionContext;
import com.iab.omid.library.ironsrc.adsession.CreativeType;
import com.iab.omid.library.ironsrc.adsession.ImpressionType;
import com.iab.omid.library.ironsrc.adsession.Owner;
import com.iab.omid.library.ironsrc.adsession.Partner;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class zm {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f16437d = "Ironsrc";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f16438e = "7";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f16439f = Omid.getVersion();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f16440g = "omidVersion";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f16441h = "omidPartnerName";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f16442i = "omidPartnerVersion";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f16443j = "omidActiveAdSessions";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f16444k = "Invalid OMID impressionOwner";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f16445l = "Invalid OMID videoEventsOwner";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f16446m = "Missing OMID impressionOwner";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f16447n = "Missing OMID videoEventsOwner";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f16448o = "OMID has not been activated";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f16449p = "Missing OMID creativeType";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f16450q = "Missing adview id in OMID params";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f16451r = "No adview found with the provided adViewId";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f16452s = "OMID Session has already started";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f16453t = "OMID Session has not started";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Partner f16454a = Partner.createPartner(f16437d, f16438e);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16456c = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, AdSession> f16455b = new HashMap<>();

    static class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final String f16457i = "isolateVerificationScripts";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final String f16458j = "impressionOwner";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final String f16459k = "videoEventsOwner";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final String f16460l = "customReferenceData";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final String f16461m = "creativeType";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final String f16462n = "impressionType";

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f16463o = "adViewId";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f16464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Owner f16465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Owner f16466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f16467d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ImpressionType f16468e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CreativeType f16469f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f16470g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Owner f16471h;

        public static a a(JSONObject jSONObject) throws IllegalArgumentException {
            a aVar = new a();
            aVar.f16464a = jSONObject.optBoolean("isolateVerificationScripts", false);
            String strOptString = jSONObject.optString("impressionOwner", "");
            if (TextUtils.isEmpty(strOptString)) {
                throw new IllegalArgumentException(zm.f16446m);
            }
            try {
                aVar.f16465b = Owner.valueOf(strOptString.toUpperCase(Locale.getDefault()));
                String strOptString2 = jSONObject.optString("videoEventsOwner", "");
                if (TextUtils.isEmpty(strOptString)) {
                    throw new IllegalArgumentException(zm.f16447n);
                }
                try {
                    aVar.f16466c = Owner.valueOf(strOptString2.toUpperCase(Locale.getDefault()));
                    aVar.f16467d = jSONObject.optString("customReferenceData", "");
                    aVar.f16469f = b(jSONObject);
                    aVar.f16468e = c(jSONObject);
                    aVar.f16470g = e(jSONObject);
                    aVar.f16471h = d(jSONObject);
                    return aVar;
                } catch (IllegalArgumentException e10) {
                    i9.d().a(e10);
                    throw new IllegalArgumentException("Invalid OMID videoEventsOwner " + strOptString2);
                }
            } catch (IllegalArgumentException e11) {
                i9.d().a(e11);
                throw new IllegalArgumentException("Invalid OMID impressionOwner " + strOptString);
            }
        }

        private static CreativeType b(JSONObject jSONObject) throws IllegalArgumentException {
            String strOptString = jSONObject.optString("creativeType", "");
            if (TextUtils.isEmpty(strOptString)) {
                throw new IllegalArgumentException(zm.f16449p + strOptString);
            }
            for (CreativeType creativeType : CreativeType.values()) {
                if (strOptString.equalsIgnoreCase(creativeType.toString())) {
                    return creativeType;
                }
            }
            throw new IllegalArgumentException(zm.f16449p + strOptString);
        }

        private static ImpressionType c(JSONObject jSONObject) throws IllegalArgumentException {
            String strOptString = jSONObject.optString("impressionType", "");
            if (TextUtils.isEmpty(strOptString)) {
                throw new IllegalArgumentException(zm.f16449p + strOptString);
            }
            for (ImpressionType impressionType : ImpressionType.values()) {
                if (strOptString.equalsIgnoreCase(impressionType.toString())) {
                    return impressionType;
                }
            }
            throw new IllegalArgumentException(zm.f16449p + strOptString);
        }

        private static Owner d(JSONObject jSONObject) throws IllegalArgumentException {
            String strOptString = jSONObject.optString("videoEventsOwner", "");
            Owner owner = Owner.NONE;
            try {
                return Owner.valueOf(strOptString.toUpperCase(Locale.getDefault()));
            } catch (IllegalArgumentException e10) {
                i9.d().a(e10);
                return owner;
            }
        }

        private static String e(JSONObject jSONObject) throws IllegalArgumentException {
            String strOptString = jSONObject.optString("adViewId", "");
            if (!TextUtils.isEmpty(strOptString)) {
                return strOptString;
            }
            throw new IllegalArgumentException(zm.f16450q + strOptString);
        }
    }

    private AdSession a(a aVar, hg hgVar) throws IllegalArgumentException {
        AdSession adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(aVar.f16469f, aVar.f16468e, aVar.f16465b, aVar.f16466c, aVar.f16464a), AdSessionContext.createHtmlAdSessionContext(this.f16454a, hgVar.getPresentingView(), null, aVar.f16467d));
        adSessionCreateAdSession.registerAdView(hgVar.getPresentingView());
        return adSessionCreateAdSession;
    }

    public void b(JSONObject jSONObject) throws IllegalStateException {
        a(jSONObject);
        String strOptString = jSONObject.optString("adViewId");
        AdSession adSession = this.f16455b.get(strOptString);
        if (adSession == null) {
            throw new IllegalStateException(f16453t);
        }
        adSession.finish();
        this.f16455b.remove(strOptString);
    }

    public void c(JSONObject jSONObject) throws IllegalStateException, IllegalArgumentException {
        a(jSONObject);
        AdSession adSession = this.f16455b.get(jSONObject.optString("adViewId"));
        if (adSession == null) {
            throw new IllegalStateException(f16453t);
        }
        AdEvents adEventsCreateAdEvents = AdEvents.createAdEvents(adSession);
        if (jSONObject.optBoolean("signalLoaded")) {
            adEventsCreateAdEvents.loaded();
        }
        adEventsCreateAdEvents.impressionOccurred();
    }

    public void d(JSONObject jSONObject) throws IllegalStateException, IllegalArgumentException {
        a(a.a(jSONObject));
    }

    public wp a() {
        wp wpVar = new wp();
        wpVar.b(f16440g, SDKUtils.encodeString(f16439f));
        wpVar.b(f16441h, SDKUtils.encodeString(f16437d));
        wpVar.b(f16442i, SDKUtils.encodeString(f16438e));
        wpVar.b(f16443j, SDKUtils.encodeString(Arrays.toString(this.f16455b.keySet().toArray())));
        return wpVar;
    }

    public void a(Context context) throws IllegalArgumentException {
        if (this.f16456c) {
            return;
        }
        Omid.activate(context);
        this.f16456c = true;
    }

    public void a(a aVar) throws IllegalStateException, IllegalArgumentException {
        if (!this.f16456c) {
            throw new IllegalStateException(f16448o);
        }
        if (TextUtils.isEmpty(aVar.f16470g)) {
            throw new IllegalStateException(f16450q);
        }
        String str = aVar.f16470g;
        if (this.f16455b.containsKey(str)) {
            throw new IllegalStateException(f16452s);
        }
        hg hgVarA = pf.a().a(str);
        if (hgVarA == null) {
            throw new IllegalStateException(f16451r);
        }
        AdSession adSessionA = a(aVar, hgVarA);
        adSessionA.start();
        this.f16455b.put(str, adSessionA);
    }

    private void a(JSONObject jSONObject) throws IllegalStateException {
        if (!this.f16456c) {
            throw new IllegalStateException(f16448o);
        }
        if (jSONObject == null) {
            throw new IllegalStateException(f16453t);
        }
    }
}
