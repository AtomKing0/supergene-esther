package com.applovin.impl;

import android.content.IntentFilter;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class t4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f7435a = new HashSet(32);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f7436b = new Object();

    public boolean a(String str) {
        synchronized (this.f7436b) {
            Iterator it = this.f7435a.iterator();
            while (it.hasNext()) {
                if (str.equals(((u4) it.next()).b())) {
                    return true;
                }
            }
            return false;
        }
    }

    public void b(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        u4 u4VarA;
        if (StringUtils.isValidString(str)) {
            synchronized (this.f7436b) {
                u4VarA = a(str, appLovinCommunicatorSubscriber);
            }
            if (u4VarA != null) {
                u4VarA.a(false);
                AppLovinBroadcastManager.unregisterReceiver(u4VarA);
            }
        }
    }

    public boolean a(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        if (appLovinCommunicatorSubscriber != null && StringUtils.isValidString(str)) {
            synchronized (this.f7436b) {
                u4 u4VarA = a(str, appLovinCommunicatorSubscriber);
                if (u4VarA != null) {
                    com.applovin.impl.sdk.n.h("AppLovinCommunicator", "Attempting to re-subscribe subscriber (" + appLovinCommunicatorSubscriber + ") to topic (" + str + ")");
                    if (!u4VarA.c()) {
                        u4VarA.a(true);
                        AppLovinBroadcastManager.registerReceiver(u4VarA, new IntentFilter(str));
                    }
                    return true;
                }
                u4 u4Var = new u4(str, appLovinCommunicatorSubscriber);
                this.f7435a.add(u4Var);
                AppLovinBroadcastManager.registerReceiver(u4Var, new IntentFilter(str));
                return true;
            }
        }
        com.applovin.impl.sdk.n.h("AppLovinCommunicator", "Unable to subscribe - invalid subscriber (" + appLovinCommunicatorSubscriber + ") or topic (" + str + ")");
        return false;
    }

    private u4 a(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        for (u4 u4Var : this.f7435a) {
            if (str.equals(u4Var.b()) && appLovinCommunicatorSubscriber.equals(u4Var.a())) {
                return u4Var;
            }
        }
        return null;
    }
}
