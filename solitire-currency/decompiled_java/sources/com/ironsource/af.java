package com.ironsource;

import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface af<T> {

    public static final class a implements af<ISDemandOnlyInterstitialListener> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private ze f11285a = new ze();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final Map<String, ze> f11286b = new HashMap();

        @Override // com.ironsource.af
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ISDemandOnlyInterstitialListener a(@NotNull String instanceId) {
            kotlin.jvm.internal.t.i(instanceId, "instanceId");
            ze zeVar = this.f11286b.get(instanceId);
            return zeVar != null ? zeVar : this.f11285a;
        }

        @Override // com.ironsource.af
        public void a(@NotNull ISDemandOnlyInterstitialListener listener) {
            kotlin.jvm.internal.t.i(listener, "listener");
            this.f11285a.a(listener);
            Iterator<T> it = this.f11286b.keySet().iterator();
            while (it.hasNext()) {
                ze zeVar = this.f11286b.get((String) it.next());
                if (zeVar != null) {
                    zeVar.a(listener);
                }
            }
        }

        @Override // com.ironsource.af
        public void a(@NotNull String instanceId, @NotNull ISDemandOnlyInterstitialListener listener) {
            kotlin.jvm.internal.t.i(instanceId, "instanceId");
            kotlin.jvm.internal.t.i(listener, "listener");
            if (!this.f11286b.containsKey(instanceId)) {
                this.f11286b.put(instanceId, new ze(listener));
                return;
            }
            ze zeVar = this.f11286b.get(instanceId);
            if (zeVar != null) {
                zeVar.a(listener);
            }
        }
    }

    public static final class b implements af<ISDemandOnlyRewardedVideoListener> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private cf f11287a = new cf();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final Map<String, cf> f11288b = new HashMap();

        @Override // com.ironsource.af
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ISDemandOnlyRewardedVideoListener a(@NotNull String instanceId) {
            kotlin.jvm.internal.t.i(instanceId, "instanceId");
            cf cfVar = this.f11288b.get(instanceId);
            return cfVar != null ? cfVar : this.f11287a;
        }

        @Override // com.ironsource.af
        public void a(@NotNull ISDemandOnlyRewardedVideoListener listener) {
            kotlin.jvm.internal.t.i(listener, "listener");
            this.f11287a.a(listener);
            Iterator<T> it = this.f11288b.keySet().iterator();
            while (it.hasNext()) {
                cf cfVar = this.f11288b.get((String) it.next());
                if (cfVar != null) {
                    cfVar.a(listener);
                }
            }
        }

        @Override // com.ironsource.af
        public void a(@NotNull String instanceId, @NotNull ISDemandOnlyRewardedVideoListener listener) {
            kotlin.jvm.internal.t.i(instanceId, "instanceId");
            kotlin.jvm.internal.t.i(listener, "listener");
            if (!this.f11288b.containsKey(instanceId)) {
                this.f11288b.put(instanceId, new cf(listener));
                return;
            }
            cf cfVar = this.f11288b.get(instanceId);
            if (cfVar != null) {
                cfVar.a(listener);
            }
        }
    }

    T a(@NotNull String str);

    void a(T t10);

    void a(@NotNull String str, T t10);
}
