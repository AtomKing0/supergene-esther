package m2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.provider.Settings;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.extractor.OpusUtil;
import com.google.common.collect.a0;
import com.google.common.collect.i1;
import com.google.common.collect.y;
import com.ironsource.v8;
import java.util.Arrays;
import k2.o1;

/* JADX INFO: compiled from: AudioCapabilities.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f31266c = new f(new int[]{2}, 8);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f f31267d = new f(new int[]{2, 5, 6}, 8);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.google.common.collect.a0<Integer, Integer> f31268e = new a0.a().f(5, 6).f(17, 6).f(7, 6).f(18, 6).f(6, 8).f(8, 8).f(14, 8).c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f31269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f31270b;

    /* JADX INFO: compiled from: AudioCapabilities.java */
    @RequiresApi(29)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final AudioAttributes f31271a = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

        /* JADX WARN: Multi-variable type inference failed */
        @DoNotInline
        public static int[] a() {
            y.a aVarK = com.google.common.collect.y.k();
            i1 it = f.f31268e.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(OpusUtil.SAMPLE_RATE).build(), f31271a)) {
                    aVarK.a(Integer.valueOf(iIntValue));
                }
            }
            aVarK.a(2);
            return g5.e.k(aVarK.k());
        }

        @DoNotInline
        public static int b(int i10, int i11) {
            for (int i12 = 8; i12 > 0; i12--) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i10).setSampleRate(i11).setChannelMask(a4.o0.D(i12)).build(), f31271a)) {
                    return i12;
                }
            }
            return 0;
        }
    }

    public f(@Nullable int[] iArr, int i10) {
        if (iArr != null) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f31269a = iArrCopyOf;
            Arrays.sort(iArrCopyOf);
        } else {
            this.f31269a = new int[0];
        }
        this.f31270b = i10;
    }

    private static boolean b() {
        if (a4.o0.f214a >= 17) {
            String str = a4.o0.f216c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static f c(Context context) {
        return d(context, a4.o0.E0(context, null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static f d(Context context, @Nullable Intent intent) {
        return (b() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) ? f31267d : (a4.o0.f214a < 29 || !(a4.o0.r0(context) || a4.o0.m0(context))) ? (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? f31266c : new f(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8)) : new f(a.a(), 8);
    }

    private static int e(int i10) {
        int i11 = a4.o0.f214a;
        if (i11 <= 28) {
            if (i10 == 7) {
                i10 = 8;
            } else if (i10 == 3 || i10 == 4 || i10 == 5) {
                i10 = 6;
            }
        }
        if (i11 <= 26 && "fugu".equals(a4.o0.f215b) && i10 == 1) {
            i10 = 2;
        }
        return a4.o0.D(i10);
    }

    private static int g(int i10, int i11) {
        return a4.o0.f214a >= 29 ? a.b(i10, i11) : ((Integer) a4.a.e(f31268e.getOrDefault(Integer.valueOf(i10), 0))).intValue();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Arrays.equals(this.f31269a, fVar.f31269a) && this.f31270b == fVar.f31270b;
    }

    @Nullable
    public Pair<Integer, Integer> f(o1 o1Var) {
        int iD = a4.x.d((String) a4.a.e(o1Var.f29347l), o1Var.f29344i);
        if (!f31268e.containsKey(Integer.valueOf(iD))) {
            return null;
        }
        if (iD == 18 && !i(18)) {
            iD = 6;
        } else if (iD == 8 && !i(8)) {
            iD = 7;
        }
        if (!i(iD)) {
            return null;
        }
        int iG = o1Var.f29360y;
        if (iG == -1 || iD == 18) {
            int i10 = o1Var.f29361z;
            if (i10 == -1) {
                i10 = OpusUtil.SAMPLE_RATE;
            }
            iG = g(iD, i10);
        } else if (iG > this.f31270b) {
            return null;
        }
        int iE = e(iG);
        if (iE == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iD), Integer.valueOf(iE));
    }

    public boolean h(o1 o1Var) {
        return f(o1Var) != null;
    }

    public int hashCode() {
        return this.f31270b + (Arrays.hashCode(this.f31269a) * 31);
    }

    public boolean i(int i10) {
        return Arrays.binarySearch(this.f31269a, i10) >= 0;
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f31270b + ", supportedEncodings=" + Arrays.toString(this.f31269a) + v8.i.f15839e;
    }
}
