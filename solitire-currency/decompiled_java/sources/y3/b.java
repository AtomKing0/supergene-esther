package y3;

import a4.o0;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: CaptionStyleCompat.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f36504g = new b(-1, ViewCompat.MEASURED_STATE_MASK, 0, 0, -1, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f36505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f36506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f36507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f36508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f36509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final Typeface f36510f;

    public b(int i10, int i11, int i12, int i13, int i14, @Nullable Typeface typeface) {
        this.f36505a = i10;
        this.f36506b = i11;
        this.f36507c = i12;
        this.f36508d = i13;
        this.f36509e = i14;
        this.f36510f = typeface;
    }

    @RequiresApi(19)
    public static b a(CaptioningManager.CaptionStyle captionStyle) {
        return o0.f214a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    @RequiresApi(19)
    private static b b(CaptioningManager.CaptionStyle captionStyle) {
        return new b(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @RequiresApi(21)
    private static b c(CaptioningManager.CaptionStyle captionStyle) {
        return new b(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f36504g.f36505a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f36504g.f36506b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f36504g.f36507c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f36504g.f36508d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f36504g.f36509e, captionStyle.getTypeface());
    }
}
