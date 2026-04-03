package m;

import androidx.media3.common.MimeTypes;
import java.util.Set;
import kotlin.collections.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ExifUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Set<String> f31117a = z0.h(MimeTypes.IMAGE_JPEG, MimeTypes.IMAGE_WEBP, "image/heic", MimeTypes.IMAGE_HEIF);

    /* JADX INFO: compiled from: ExifUtils.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31118a;

        static {
            int[] iArr = new int[l.values().length];
            iArr[l.RESPECT_PERFORMANCE.ordinal()] = 1;
            iArr[l.IGNORE.ordinal()] = 2;
            iArr[l.RESPECT_ALL.ordinal()] = 3;
            f31118a = iArr;
        }
    }

    public static final boolean a(@NotNull j jVar) {
        return jVar.a() > 0;
    }

    public static final boolean b(@NotNull j jVar) {
        return jVar.a() == 90 || jVar.a() == 270;
    }

    public static final boolean c(@NotNull l lVar, @Nullable String str) {
        int i10 = a.f31118a[lVar.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                return false;
            }
            if (i10 != 3) {
                throw new v8.q();
            }
        } else if (str == null || !f31117a.contains(str)) {
            return false;
        }
        return true;
    }
}
