package com.ironsource;

/* JADX INFO: loaded from: classes4.dex */
public class qf {

    public enum a {
        None,
        Device,
        Controller
    }

    public enum b {
        None,
        Loading,
        Loaded,
        Ready,
        Failed
    }

    public enum c {
        Web,
        Native,
        None
    }

    public enum d {
        MODE_0(0),
        MODE_1(1),
        MODE_2(2),
        MODE_3(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f14487a;

        d(int i10) {
            this.f14487a = i10;
        }

        public int a() {
            return this.f14487a;
        }
    }

    public enum e {
        Banner,
        Interstitial,
        RewardedVideo,
        NativeAd,
        None
    }
}
