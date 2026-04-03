package com.applovin.communicator;

import android.content.Context;
import com.applovin.impl.communicator.MessagingServiceImpl;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.t4;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class AppLovinCommunicator {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static AppLovinCommunicator f4660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f4661f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f4662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private n f4663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final t4 f4664c = new t4();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MessagingServiceImpl f4665d = new MessagingServiceImpl();

    public static AppLovinCommunicator getInstance() {
        return getInstance(j.n());
    }

    public void a(j jVar) {
        this.f4662a = jVar;
        this.f4663b = jVar.I();
        a("Attached SDK instance: " + jVar + "...");
    }

    public AppLovinCommunicatorMessagingService getMessagingService() {
        return this.f4665d;
    }

    public boolean hasSubscriber(String str) {
        return this.f4664c.a(str);
    }

    public boolean respondsToTopic(String str) {
        return this.f4662a.r().a(str);
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        subscribe(appLovinCommunicatorSubscriber, Collections.singletonList(str));
    }

    public String toString() {
        return "AppLovinCommunicator{sdk=" + this.f4662a + '}';
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        unsubscribe(appLovinCommunicatorSubscriber, Collections.singletonList(str));
    }

    @Deprecated
    public static AppLovinCommunicator getInstance(Context context) {
        synchronized (f4661f) {
            if (f4660e == null) {
                f4660e = new AppLovinCommunicator();
            }
        }
        return f4660e;
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String str : list) {
            if (this.f4664c.a(appLovinCommunicatorSubscriber, str)) {
                this.f4665d.maybeSendStickyMessages(str);
            } else {
                a("Unable to subscribe " + appLovinCommunicatorSubscriber + " to topic: " + str);
            }
        }
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String str : list) {
            a("Unsubscribing " + appLovinCommunicatorSubscriber + " from topic: " + str);
            this.f4664c.b(appLovinCommunicatorSubscriber, str);
        }
    }

    private void a(String str) {
        if (this.f4663b == null || !n.a()) {
            return;
        }
        this.f4663b.a("AppLovinCommunicator", str);
    }
}
