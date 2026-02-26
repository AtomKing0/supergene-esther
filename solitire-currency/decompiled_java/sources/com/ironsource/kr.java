package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public enum kr {
    Off(0),
    CurrentlyLoadedAds(1),
    CurrentlyLoadedAdsAndFullHistory(2);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f12896b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12901a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final kr a(int i10) {
            kr krVar;
            kr[] krVarArrValues = kr.values();
            int length = krVarArrValues.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    krVar = null;
                    break;
                }
                krVar = krVarArrValues[i11];
                if (krVar.f12901a == i10) {
                    break;
                }
                i11++;
            }
            return krVar == null ? kr.CurrentlyLoadedAds : krVar;
        }
    }

    kr(int i10) {
        this.f12901a = i10;
    }

    public final int b() {
        return this.f12901a;
    }
}
