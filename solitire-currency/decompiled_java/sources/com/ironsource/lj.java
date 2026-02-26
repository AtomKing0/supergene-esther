package com.ironsource;

import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class lj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static lj f13046c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashSet<ImpressionDataListener> f13047a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, List<String>> f13048b = new ConcurrentHashMap<>();

    lj() {
    }

    public static synchronized lj b() {
        if (f13046c == null) {
            f13046c = new lj();
        }
        return f13046c;
    }

    public HashSet<ImpressionDataListener> a() {
        return this.f13047a;
    }

    public ConcurrentHashMap<String, List<String>> c() {
        return this.f13048b;
    }

    public void d() {
        synchronized (this) {
            this.f13047a.clear();
        }
    }

    public void a(@NotNull ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.f13047a.add(impressionDataListener);
        }
    }

    public void b(@NotNull ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.f13047a.remove(impressionDataListener);
        }
    }

    public void a(String str, List<String> list) {
        this.f13048b.put(str, list);
    }
}
