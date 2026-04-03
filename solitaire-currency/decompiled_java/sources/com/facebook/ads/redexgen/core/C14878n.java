package com.facebook.ads.redexgen.core;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8n, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14878n {
    public final AudioTrack.StreamEventCallback A00;
    public final Handler A01 = new Handler(Looper.myLooper());
    public final /* synthetic */ C2948mw A02;

    public C14878n(final C2948mw c2948mw) {
        this.A02 = c2948mw;
        this.A00 = new AudioTrack.StreamEventCallback() { // from class: com.facebook.ads.redexgen.X.8m
            public static String[] A02 = {"8abdE8ICHAnxwFMUcOcB2jRAyUCGhoJo", "eSG1FX4JUeB6EOGXBLLAS9lOPW1", "25OZd6V", "MAJYraeiFmbj", "mUQNxKLiPMNWcUO6nW3zZtqSV9cqGhZ8", "VvmkF0iz3WmQeVV4Hfojcs5Qu1q9OORp", "gntz5ah2KiglLn2nngo2Gr7V9oibD8w7", "BsUxp7JWgCvt"};

            @Override // android.media.AudioTrack.StreamEventCallback
            public final void onDataRequest(AudioTrack audioTrack, int i10) {
                if (audioTrack.equals(this.A00.A02.A0D) && this.A00.A02.A0I != null) {
                    C2948mw c2948mw2 = this.A00.A02;
                    String[] strArr = A02;
                    if (strArr[1].length() == strArr[2].length()) {
                        throw new RuntimeException();
                    }
                    A02[0] = "JFsW9FWtG581w4rAGivIJch2V9mOeS5l";
                    if (!c2948mw2.A0X) {
                        return;
                    }
                    this.A00.A02.A0I.AEN();
                }
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public final void onTearDown(AudioTrack audioTrack) {
                if (audioTrack.equals(this.A00.A02.A0D) && this.A00.A02.A0I != null) {
                    C14878n c14878n = this.A00;
                    String[] strArr = A02;
                    if (strArr[3].length() != strArr[7].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A02;
                    strArr2[3] = "n6LYwQPnbsiV";
                    strArr2[7] = "LQIZIXydZbX4";
                    if (!c14878n.A02.A0X) {
                        return;
                    }
                    this.A00.A02.A0I.AEN();
                }
            }
        };
    }

    public final void A00(AudioTrack audioTrack) {
        Handler handler = this.A01;
        Objects.requireNonNull(handler);
        audioTrack.registerStreamEventCallback(new ExecutorC14858l(handler), this.A00);
    }

    public final void A01(AudioTrack audioTrack) {
        audioTrack.unregisterStreamEventCallback(this.A00);
        this.A01.removeCallbacksAndMessages(null);
    }
}
