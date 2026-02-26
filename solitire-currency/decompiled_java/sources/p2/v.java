package p2;

import a4.o0;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.OpusUtil;
import java.util.Collections;
import java.util.List;
import k2.o1;

/* JADX INFO: compiled from: FlacStreamMetadata.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f32533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f32534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f32535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f32536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f32537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f32538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f32539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f32540i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f32541j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final a f32542k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private final c3.a f32543l;

    /* JADX INFO: compiled from: FlacStreamMetadata.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f32544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f32545b;

        public a(long[] jArr, long[] jArr2) {
            this.f32544a = jArr;
            this.f32545b = jArr2;
        }
    }

    public v(byte[] bArr, int i10) {
        a4.b0 b0Var = new a4.b0(bArr);
        b0Var.p(i10 * 8);
        this.f32532a = b0Var.h(16);
        this.f32533b = b0Var.h(16);
        this.f32534c = b0Var.h(24);
        this.f32535d = b0Var.h(24);
        int iH = b0Var.h(20);
        this.f32536e = iH;
        this.f32537f = j(iH);
        this.f32538g = b0Var.h(3) + 1;
        int iH2 = b0Var.h(5) + 1;
        this.f32539h = iH2;
        this.f32540i = e(iH2);
        this.f32541j = b0Var.j(36);
        this.f32542k = null;
        this.f32543l = null;
    }

    private static int e(int i10) {
        if (i10 == 8) {
            return 1;
        }
        if (i10 == 12) {
            return 2;
        }
        if (i10 == 16) {
            return 4;
        }
        if (i10 != 20) {
            return i10 != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int j(int i10) {
        switch (i10) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case OpusUtil.SAMPLE_RATE /* 48000 */:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND /* 192000 */:
                return 3;
            default:
                return -1;
        }
    }

    public v a(List<f3.a> list) {
        return new v(this.f32532a, this.f32533b, this.f32534c, this.f32535d, this.f32536e, this.f32538g, this.f32539h, this.f32541j, this.f32542k, h(new c3.a(list)));
    }

    public v b(@Nullable a aVar) {
        return new v(this.f32532a, this.f32533b, this.f32534c, this.f32535d, this.f32536e, this.f32538g, this.f32539h, this.f32541j, aVar, this.f32543l);
    }

    public v c(List<String> list) {
        return new v(this.f32532a, this.f32533b, this.f32534c, this.f32535d, this.f32536e, this.f32538g, this.f32539h, this.f32541j, this.f32542k, h(h0.c(list)));
    }

    public long d() {
        long j10;
        long j11;
        int i10 = this.f32535d;
        if (i10 > 0) {
            j10 = (((long) i10) + ((long) this.f32534c)) / 2;
            j11 = 1;
        } else {
            int i11 = this.f32532a;
            j10 = ((((i11 != this.f32533b || i11 <= 0) ? 4096L : i11) * ((long) this.f32538g)) * ((long) this.f32539h)) / 8;
            j11 = 64;
        }
        return j10 + j11;
    }

    public long f() {
        long j10 = this.f32541j;
        return j10 == 0 ? C.TIME_UNSET : (j10 * 1000000) / ((long) this.f32536e);
    }

    public o1 g(byte[] bArr, @Nullable c3.a aVar) {
        bArr[4] = -128;
        int i10 = this.f32535d;
        if (i10 <= 0) {
            i10 = -1;
        }
        return new o1.b().e0(MimeTypes.AUDIO_FLAC).W(i10).H(this.f32538g).f0(this.f32536e).T(Collections.singletonList(bArr)).X(h(aVar)).E();
    }

    @Nullable
    public c3.a h(@Nullable c3.a aVar) {
        c3.a aVar2 = this.f32543l;
        return aVar2 == null ? aVar : aVar2.b(aVar);
    }

    public long i(long j10) {
        return o0.q((j10 * ((long) this.f32536e)) / 1000000, 0L, this.f32541j - 1);
    }

    private v(int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, @Nullable a aVar, @Nullable c3.a aVar2) {
        this.f32532a = i10;
        this.f32533b = i11;
        this.f32534c = i12;
        this.f32535d = i13;
        this.f32536e = i14;
        this.f32537f = j(i14);
        this.f32538g = i15;
        this.f32539h = i16;
        this.f32540i = e(i16);
        this.f32541j = j10;
        this.f32542k = aVar;
        this.f32543l = aVar2;
    }
}
