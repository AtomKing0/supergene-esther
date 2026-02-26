package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class n4 implements w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final c5 f14075a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14076a;

        static {
            int[] iArr = new int[u1.values().length];
            try {
                iArr[u1.LOAD_AD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[u1.LOAD_AD_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[u1.LOAD_AD_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[u1.LOAD_AD_FAILED_WITH_REASON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[u1.AUCTION_SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[u1.AUCTION_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[u1.AUCTION_FAILED_NO_CANDIDATES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[u1.LOAD_AD_NO_FILL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[u1.AD_OPENED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[u1.AD_CLOSED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[u1.SHOW_AD.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[u1.SHOW_AD_FAILED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[u1.AD_CLICKED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[u1.AD_REWARDED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[u1.RELOAD_AD_FAILED_WITH_REASON.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[u1.RELOAD_AD_SUCCESS.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[u1.AD_LEFT_APPLICATION.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            f14076a = iArr;
        }
    }

    public n4(@NotNull c5 auctionData) {
        kotlin.jvm.internal.t.i(auctionData, "auctionData");
        this.f14075a = auctionData;
    }

    private final boolean b(u1 u1Var) {
        switch (a.f14076a[u1Var.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return true;
            default:
                return false;
        }
    }

    @Override // com.ironsource.w1
    @NotNull
    public Map<String, Object> a(@NotNull u1 event) {
        kotlin.jvm.internal.t.i(event, "event");
        HashMap map = new HashMap();
        JSONObject jSONObjectH = this.f14075a.h();
        if (jSONObjectH.length() > 0) {
            map.put("genericParams", jSONObjectH);
        }
        if (b(event)) {
            map.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(this.f14075a.i()));
            if (!TextUtils.isEmpty(this.f14075a.f())) {
                map.put(IronSourceConstants.AUCTION_FALLBACK, this.f14075a.f());
            }
        }
        if (!TextUtils.isEmpty(this.f14075a.g())) {
            map.put("auctionId", this.f14075a.g());
        }
        return map;
    }
}
