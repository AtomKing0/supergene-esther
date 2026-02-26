package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13580c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13581d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, ArrayList<a>> f13582a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13583b;

    public enum a {
        ISAuctionPerformanceDidntAttemptToLoad,
        ISAuctionPerformanceFailedToLoad,
        ISAuctionPerformanceLoadedSuccessfully,
        ISAuctionPerformanceFailedToShow,
        ISAuctionPerformanceShowedSuccessfully,
        ISAuctionPerformanceNotPartOfWaterfall
    }

    public h(List<NetworkSettings> list, int i10) {
        this.f13583b = i10;
        for (NetworkSettings networkSettings : list) {
            this.f13582a.put(networkSettings.getProviderName(), new ArrayList<>());
        }
    }

    public String a(String str) {
        ArrayList<a> arrayList = this.f13582a.get(str);
        String string = "";
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<a> it = arrayList.iterator();
            StringBuilder sb = new StringBuilder();
            while (true) {
                sb.append(string);
                sb.append(it.next().ordinal());
                string = sb.toString();
                if (!it.hasNext()) {
                    break;
                }
                string = string + ",";
                sb = new StringBuilder();
            }
        }
        return string;
    }

    public void a(ConcurrentHashMap<String, a> concurrentHashMap) {
        if (this.f13583b == 0) {
            return;
        }
        for (String str : this.f13582a.keySet()) {
            a aVar = a.ISAuctionPerformanceNotPartOfWaterfall;
            if (concurrentHashMap.containsKey(str)) {
                aVar = concurrentHashMap.get(str);
            }
            ArrayList<a> arrayList = this.f13582a.get(str);
            if (this.f13583b != -1 && arrayList.size() == this.f13583b) {
                arrayList.remove(0);
            }
            arrayList.add(aVar);
        }
    }
}
