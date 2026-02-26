package com.ironsource;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface s7 {
    Map<String, Object> a(AdData adData);

    void a(AdData adData, @NotNull BiddingDataCallback biddingDataCallback);
}
