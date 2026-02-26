package u2;

import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: MotionPhotoDescription.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f34505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f34506b;

    /* JADX INFO: compiled from: MotionPhotoDescription.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f34507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f34508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f34509c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f34510d;

        public a(String str, String str2, long j10, long j11) {
            this.f34507a = str;
            this.f34508b = str2;
            this.f34509c = j10;
            this.f34510d = j11;
        }
    }

    public b(long j10, List<a> list) {
        this.f34505a = j10;
        this.f34506b = list;
    }

    @Nullable
    public i3.b a(long j10) {
        long j11;
        if (this.f34506b.size() < 2) {
            return null;
        }
        long j12 = j10;
        long j13 = -1;
        long j14 = -1;
        long j15 = -1;
        long j16 = -1;
        boolean z10 = false;
        for (int size = this.f34506b.size() - 1; size >= 0; size--) {
            a aVar = this.f34506b.get(size);
            boolean zEquals = MimeTypes.VIDEO_MP4.equals(aVar.f34507a) | z10;
            if (size == 0) {
                j12 -= aVar.f34510d;
                j11 = 0;
            } else {
                j11 = j12 - aVar.f34509c;
            }
            long j17 = j12;
            j12 = j11;
            if (!zEquals || j12 == j17) {
                z10 = zEquals;
            } else {
                j16 = j17 - j12;
                j15 = j12;
                z10 = false;
            }
            if (size == 0) {
                j13 = j12;
                j14 = j17;
            }
        }
        if (j15 == -1 || j16 == -1 || j13 == -1 || j14 == -1) {
            return null;
        }
        return new i3.b(j13, j14, this.f34505a, j15, j16);
    }
}
