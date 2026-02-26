package com.applovin.impl;

import android.net.Uri;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DateFormat f5889a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Random f5890b = new Random(System.currentTimeMillis());

    public static void a(e7 e7Var, AppLovinAdLoadListener appLovinAdLoadListener, f7 f7Var, int i10, com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
        }
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(i10);
        }
        Set setA = a(e7Var, jVar);
        if (CollectionUtils.isEmpty(setA)) {
            return;
        }
        a(setA, f7Var, jVar);
    }

    public static boolean b(a7 a7Var) {
        n7 n7VarO1;
        List listG;
        return (a7Var == null || (n7VarO1 = a7Var.o1()) == null || (listG = n7VarO1.g()) == null || listG.isEmpty()) ? false : true;
    }

    public static f7 c(a7 a7Var) {
        if (b(a7Var) || a(a7Var)) {
            return null;
        }
        return f7.GENERAL_WRAPPER_ERROR;
    }

    private static String b() {
        DateFormat dateFormat = f5889a;
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat.format(new Date());
    }

    public static boolean a(a7 a7Var) {
        d7 d7VarF1;
        i7 i7VarE;
        if (a7Var == null || (d7VarF1 = a7Var.f1()) == null || (i7VarE = d7VarF1.e()) == null) {
            return false;
        }
        return i7VarE.c() != null || StringUtils.isValidString(i7VarE.b());
    }

    public static boolean b(b8 b8Var) {
        if (b8Var != null) {
            return b8Var.b("Wrapper") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
    }

    public static Uri a(String str, long j10, Uri uri, f7 f7Var, com.applovin.impl.sdk.j jVar) {
        if (URLUtil.isValidUrl(str)) {
            try {
                String string = Integer.toString(f7Var.b());
                String strReplace = str.replace("[ERRORCODE]", string).replace("[REASON]", string);
                if (j10 >= 0) {
                    strReplace = strReplace.replace("[CONTENTPLAYHEAD]", a(j10));
                }
                if (uri != null) {
                    strReplace = strReplace.replace("[ASSETURI]", uri.toString());
                }
                return Uri.parse(strReplace.replace("[CACHEBUSTING]", a()).replace("[TIMESTAMP]", b()));
            } catch (Throwable th) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("VastUtils", "Unable to replace macros in URL string " + str, th);
                }
                jVar.A().a("VastUtils", th);
                return null;
            }
        }
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().b("VastUtils", "Unable to replace macros in invalid URL string.");
        }
        return null;
    }

    private static String a(long j10) {
        if (j10 <= 0) {
            return "00:00:00.000";
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long hours = timeUnit.toHours(j10);
        long minutes = timeUnit.toMinutes(j10);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        return String.format(Locale.US, "%02d:%02d:%02d.000", Long.valueOf(hours), Long.valueOf(minutes % timeUnit2.toSeconds(1L)), Long.valueOf(j10 % timeUnit2.toSeconds(1L)));
    }

    private static String a() {
        return Integer.toString(f5890b.nextInt(89999999) + 10000000);
    }

    public static void a(Set set, com.applovin.impl.sdk.j jVar) {
        a(set, -1L, (Uri) null, f7.UNSPECIFIED, jVar);
    }

    public static void a(Set set, f7 f7Var, com.applovin.impl.sdk.j jVar) {
        a(set, -1L, (Uri) null, f7Var, jVar);
    }

    public static void a(Set set, long j10, Uri uri, f7 f7Var, com.applovin.impl.sdk.j jVar) {
        if (jVar != null) {
            if (set == null || set.isEmpty()) {
                return;
            }
            Iterator it = set.iterator();
            while (it.hasNext()) {
                k7 k7Var = (k7) it.next();
                Uri uriA = a(k7Var.c(), j10, uri, f7Var, jVar);
                if (uriA != null) {
                    jVar.X().a(com.applovin.impl.sdk.network.d.b().d(uriA.toString()).a(false).b(k7Var.d()).a(), false);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
    }

    public static void a(b8 b8Var, Map map, e7 e7Var, com.applovin.impl.sdk.j jVar) {
        List<b8> listA;
        if (jVar == null) {
            throw new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
        }
        if (b8Var == null) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("VastUtils", "Unable to render event trackers; null node provided");
                return;
            }
            return;
        }
        if (map == null) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("VastUtils", "Unable to render event trackers; null event trackers provided");
                return;
            }
            return;
        }
        b8 b8VarC = b8Var.c("TrackingEvents");
        if (b8VarC == null || (listA = b8VarC.a("Tracking")) == null) {
            return;
        }
        for (b8 b8Var2 : listA) {
            String str = (String) b8Var2.a().get(NotificationCompat.CATEGORY_EVENT);
            if (StringUtils.isValidString(str)) {
                k7 k7VarA = k7.a(b8Var2, e7Var, jVar);
                if (k7VarA != null) {
                    Set set = (Set) map.get(str);
                    if (set != null) {
                        set.add(k7VarA);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(k7VarA);
                        map.put(str, hashSet);
                    }
                }
            } else {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().b("VastUtils", "Could not find event for tracking node = " + b8Var2);
                }
            }
        }
    }

    public static void a(List list, Set set, e7 e7Var, com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("Unable to render trackers. No sdk specified.");
        }
        if (list == null) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("VastUtils", "Unable to render trackers; null nodes provided");
                return;
            }
            return;
        }
        if (set == null) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("VastUtils", "Unable to render trackers; null trackers provided");
                return;
            }
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k7 k7VarA = k7.a((b8) it.next(), e7Var, jVar);
            if (k7VarA != null) {
                set.add(k7VarA);
            }
        }
    }

    public static boolean a(b8 b8Var) {
        if (b8Var != null) {
            return b8Var.b("InLine") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
    }

    public static String a(e7 e7Var) {
        b8 b8VarB;
        if (e7Var != null) {
            List listA = e7Var.a();
            int size = e7Var.a().size();
            if (size <= 0 || (b8VarB = ((b8) listA.get(size - 1)).b("VASTAdTagURI")) == null) {
                return null;
            }
            return b8VarB.d();
        }
        throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
    }

    public static String a(b8 b8Var, String str, String str2) {
        b8 b8VarC = b8Var.c(str);
        if (b8VarC != null) {
            String strD = b8VarC.d();
            if (StringUtils.isValidString(strD)) {
                return strD;
            }
        }
        return str2;
    }

    private static Set a(e7 e7Var, com.applovin.impl.sdk.j jVar) {
        List listA;
        if (e7Var == null) {
            return null;
        }
        List<b8> listA2 = e7Var.a();
        HashSet hashSet = new HashSet(listA2.size());
        for (b8 b8Var : listA2) {
            b8 b8VarB = b8Var.b("Wrapper");
            if (b8VarB == null) {
                b8VarB = b8Var.b("InLine");
            }
            if (b8VarB != null) {
                listA = b8VarB.a("Error");
            } else {
                listA = b8Var.a("Error");
            }
            hashSet = a(hashSet, listA, e7Var, jVar);
        }
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().a("VastUtils", "Retrieved " + hashSet.size() + " top level error trackers: " + hashSet);
        }
        return hashSet;
    }

    private static HashSet a(HashSet hashSet, List list, e7 e7Var, com.applovin.impl.sdk.j jVar) {
        if (list == null) {
            return hashSet;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k7 k7VarA = k7.a((b8) it.next(), e7Var, jVar);
            if (k7VarA != null) {
                hashSet.add(k7VarA);
            }
        }
        return hashSet;
    }
}
