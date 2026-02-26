package com.applovin.impl;

import android.content.Intent;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.communicator.CommunicatorMessageImpl;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class u4 implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference f7528c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7526a = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f7529d = new LinkedHashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f7530e = new Object();

    u4(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        this.f7527b = str;
        this.f7528c = new WeakReference(appLovinCommunicatorSubscriber);
    }

    public AppLovinCommunicatorSubscriber a() {
        return (AppLovinCommunicatorSubscriber) this.f7528c.get();
    }

    public String b() {
        return this.f7527b;
    }

    public boolean c() {
        return this.f7526a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u4)) {
            return false;
        }
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber = (AppLovinCommunicatorSubscriber) this.f7528c.get();
        u4 u4Var = (u4) obj;
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber2 = (AppLovinCommunicatorSubscriber) u4Var.f7528c.get();
        if (b().equals(u4Var.b())) {
            if (appLovinCommunicatorSubscriber != null) {
                if (appLovinCommunicatorSubscriber.equals(appLovinCommunicatorSubscriber2)) {
                    return true;
                }
            } else if (appLovinCommunicatorSubscriber == appLovinCommunicatorSubscriber2) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.f7527b.hashCode();
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber = (AppLovinCommunicatorSubscriber) this.f7528c.get();
        return (iHashCode * 31) + (appLovinCommunicatorSubscriber != null ? appLovinCommunicatorSubscriber.hashCode() : 0);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        boolean z10;
        if (a() == null) {
            com.applovin.impl.sdk.n.h("AppLovinCommunicator", "Message received for GC'd subscriber");
            return;
        }
        CommunicatorMessageImpl communicatorMessageImpl = (CommunicatorMessageImpl) intent;
        synchronized (this.f7530e) {
            if (this.f7529d.contains(communicatorMessageImpl.getUniqueId())) {
                z10 = false;
            } else {
                this.f7529d.add(communicatorMessageImpl.getUniqueId());
                z10 = true;
            }
        }
        if (z10) {
            a().onMessageReceived((AppLovinCommunicatorMessage) communicatorMessageImpl);
        }
    }

    public void a(boolean z10) {
        this.f7526a = z10;
    }
}
