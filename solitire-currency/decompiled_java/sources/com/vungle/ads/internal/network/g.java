package com.vungle.ads.internal.network;

import androidx.annotation.VisibleForTesting;
import com.vungle.ads.internal.load.d;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.p;
import com.vungle.ads.internal.util.q;
import com.vungle.ads.o;
import com.vungle.ads.x1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.l;

/* JADX INFO: compiled from: TpatSender.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final String FAILED_TPATS = "FAILED_TPATS";
    private static final int MAX_RETRIES = 5;

    @NotNull
    private static final String TAG = "TpatSender";

    @Nullable
    private final String creativeId;

    @Nullable
    private final String eventId;

    @Nullable
    private final String placementId;

    @Nullable
    private final com.vungle.ads.internal.signals.b signalManager;

    @NotNull
    private final com.vungle.ads.internal.persistence.b tpatFilePreferences;

    @NotNull
    private final i vungleApiClient;

    /* JADX INFO: compiled from: TpatSender.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    public g(@NotNull i vungleApiClient, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull Executor ioExecutor, @NotNull q pathProvider, @Nullable com.vungle.ads.internal.signals.b bVar) {
        t.i(vungleApiClient, "vungleApiClient");
        t.i(ioExecutor, "ioExecutor");
        t.i(pathProvider, "pathProvider");
        this.vungleApiClient = vungleApiClient;
        this.placementId = str;
        this.creativeId = str2;
        this.eventId = str3;
        this.signalManager = bVar;
        this.tpatFilePreferences = com.vungle.ads.internal.persistence.b.Companion.get(ioExecutor, pathProvider, com.vungle.ads.internal.persistence.b.TPAT_FAILED_FILENAME);
    }

    private final HashMap<String, Integer> getStoredTpats() {
        HashMap<String, Integer> map;
        String string = this.tpatFilePreferences.getString(FAILED_TPATS);
        try {
            if (string != null) {
                a.C0607a c0607a = kotlinx.serialization.json.a.f30033d;
                fa.c cVarA = c0607a.a();
                KTypeProjection.Companion companion = KTypeProjection.Companion;
                KSerializer<Object> kSerializerB = l.b(cVarA, o0.l(HashMap.class, companion.invariant(o0.j(String.class)), companion.invariant(o0.j(Integer.TYPE))));
                t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                map = (HashMap) c0607a.b(kSerializerB, string);
            } else {
                map = new HashMap<>();
            }
            return map;
        } catch (Exception unused) {
            p.Companion.e(TAG, "Failed to decode stored tpats: " + string);
            return new HashMap<>();
        }
    }

    private final void saveStoredTpats(HashMap<String, Integer> map) {
        try {
            com.vungle.ads.internal.persistence.b bVar = this.tpatFilePreferences;
            a.C0607a c0607a = kotlinx.serialization.json.a.f30033d;
            fa.c cVarA = c0607a.a();
            KTypeProjection.Companion companion = KTypeProjection.Companion;
            KSerializer<Object> kSerializerB = l.b(cVarA, o0.l(HashMap.class, companion.invariant(o0.j(String.class)), companion.invariant(o0.j(Integer.TYPE))));
            t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            bVar.put(FAILED_TPATS, c0607a.c(kSerializerB, map)).apply();
        } catch (Exception unused) {
            p.Companion.e(TAG, "Failed to encode the about to storing tpats: " + map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: sendTpat$lambda-2, reason: not valid java name */
    public static final void m4066sendTpat$lambda2(g this$0, String url, String urlWithSessionId) {
        t.i(this$0, "this$0");
        t.i(url, "$url");
        t.i(urlWithSessionId, "$urlWithSessionId");
        HashMap<String, Integer> storedTpats = this$0.getStoredTpats();
        Integer num = storedTpats.get(url);
        if (num == null) {
            num = 0;
        }
        int iIntValue = num.intValue();
        d.b bVarPingTPAT = this$0.vungleApiClient.pingTPAT(urlWithSessionId);
        if (bVarPingTPAT == null) {
            if (iIntValue != 0) {
                storedTpats.remove(url);
                this$0.saveStoredTpats(storedTpats);
                return;
            }
            return;
        }
        if (!bVarPingTPAT.getErrorIsTerminal()) {
            if (iIntValue >= 5) {
                storedTpats.remove(url);
                this$0.saveStoredTpats(storedTpats);
                new x1(urlWithSessionId).logErrorNoReturnValue$vungle_ads_release();
            } else {
                storedTpats.put(url, Integer.valueOf(iIntValue + 1));
                this$0.saveStoredTpats(storedTpats);
            }
        }
        p.Companion.e(TAG, "TPAT failed with " + bVarPingTPAT.getDescription() + ", url:" + urlWithSessionId);
        if (bVarPingTPAT.getReason() == 29) {
            o.INSTANCE.logMetric$vungle_ads_release(Sdk$SDKMetric.b.NOTIFICATION_REDIRECT, (34 & 2) != 0 ? 0L : 0L, (34 & 4) != 0 ? null : this$0.placementId, (34 & 8) != 0 ? null : null, (34 & 16) != 0 ? null : null, (34 & 32) == 0 ? urlWithSessionId : null);
            return;
        }
        o.INSTANCE.logError$vungle_ads_release(Sdk$SDKError.b.TPAT_ERROR, "Fail to send " + urlWithSessionId + ", error: " + bVarPingTPAT.getDescription(), this$0.placementId, this$0.creativeId, this$0.eventId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: sendWinNotification$lambda-0, reason: not valid java name */
    public static final void m4067sendWinNotification$lambda0(g this$0, String url) {
        t.i(this$0, "this$0");
        t.i(url, "$url");
        d.b bVarPingTPAT = this$0.vungleApiClient.pingTPAT(url);
        if (bVarPingTPAT != null) {
            o.INSTANCE.logError$vungle_ads_release(Sdk$SDKError.b.AD_WIN_NOTIFICATION_ERROR, "Fail to send " + url + ", error: " + bVarPingTPAT.getDescription(), this$0.placementId, this$0.creativeId, this$0.eventId);
        }
    }

    @Nullable
    public final String getCreativeId() {
        return this.creativeId;
    }

    @Nullable
    public final String getEventId() {
        return this.eventId;
    }

    @Nullable
    public final String getPlacementId() {
        return this.placementId;
    }

    @Nullable
    public final com.vungle.ads.internal.signals.b getSignalManager() {
        return this.signalManager;
    }

    @NotNull
    public final i getVungleApiClient() {
        return this.vungleApiClient;
    }

    @VisibleForTesting
    @NotNull
    public final String injectSessionIdToUrl(@NotNull String url) {
        String uuid;
        t.i(url, "url");
        com.vungle.ads.internal.signals.b bVar = this.signalManager;
        if (bVar == null || (uuid = bVar.getUuid()) == null) {
            uuid = "";
        }
        if (!(uuid.length() > 0)) {
            return url;
        }
        String strQuote = Pattern.quote(com.vungle.ads.internal.l.SESSION_ID);
        t.h(strQuote, "quote(Constants.SESSION_ID)");
        return new p9.f(strQuote).b(url, uuid);
    }

    public final void resendStoredTpats$vungle_ads_release(@NotNull Executor executor) {
        t.i(executor, "executor");
        Iterator<Map.Entry<String, Integer>> it = getStoredTpats().entrySet().iterator();
        while (it.hasNext()) {
            sendTpat(it.next().getKey(), executor);
        }
    }

    public final void sendTpat(@NotNull final String url, @NotNull Executor executor) {
        t.i(url, "url");
        t.i(executor, "executor");
        final String strInjectSessionIdToUrl = injectSessionIdToUrl(url);
        executor.execute(new Runnable() { // from class: com.vungle.ads.internal.network.e
            @Override // java.lang.Runnable
            public final void run() {
                g.m4066sendTpat$lambda2(this.f24351a, url, strInjectSessionIdToUrl);
            }
        });
    }

    public final void sendTpats(@NotNull Iterable<String> urls, @NotNull Executor executor) {
        t.i(urls, "urls");
        t.i(executor, "executor");
        Iterator<String> it = urls.iterator();
        while (it.hasNext()) {
            sendTpat(it.next(), executor);
        }
    }

    public final void sendWinNotification(@NotNull String urlString, @NotNull Executor executor) {
        t.i(urlString, "urlString");
        t.i(executor, "executor");
        final String strInjectSessionIdToUrl = injectSessionIdToUrl(urlString);
        executor.execute(new Runnable() { // from class: com.vungle.ads.internal.network.f
            @Override // java.lang.Runnable
            public final void run() {
                g.m4067sendWinNotification$lambda0(this.f24354a, strInjectSessionIdToUrl);
            }
        });
    }

    public /* synthetic */ g(i iVar, String str, String str2, String str3, Executor executor, q qVar, com.vungle.ads.internal.signals.b bVar, int i10, k kVar) {
        this(iVar, str, str2, str3, executor, qVar, (i10 & 64) != 0 ? null : bVar);
    }
}
