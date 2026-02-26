package k2;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt;
import k2.h;

/* JADX INFO: compiled from: PercentageRating.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l2 extends y2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h.a<l2> f29274c = new h.a() { // from class: k2.k2
        @Override // k2.h.a
        public final h fromBundle(Bundle bundle) {
            return l2.e(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f29275b;

    public l2() {
        this.f29275b = -1.0f;
    }

    private static String c(int i10) {
        return Integer.toString(i10, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static l2 e(Bundle bundle) {
        a4.a.a(bundle.getInt(c(0), -1) == 1);
        float f10 = bundle.getFloat(c(1), -1.0f);
        return f10 == -1.0f ? new l2() : new l2(f10);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof l2) && this.f29275b == ((l2) obj).f29275b;
    }

    public int hashCode() {
        return e5.k.b(Float.valueOf(this.f29275b));
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(0), 1);
        bundle.putFloat(c(1), this.f29275b);
        return bundle;
    }

    public l2(@FloatRange(from = 0.0d, to = TextSelectionMouseDetectorKt.ClicksSlop) float f10) {
        a4.a.b(f10 >= 0.0f && f10 <= 100.0f, "percent must be in the range of [0, 100]");
        this.f29275b = f10;
    }
}
