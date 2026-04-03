package u3;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.common.collect.c0;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: TextEmphasis.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f34519d = Pattern.compile("\\s+");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final c0<String> f34520e = c0.s(TtmlNode.TEXT_EMPHASIS_AUTO, "none");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final c0<String> f34521f = c0.t(TtmlNode.TEXT_EMPHASIS_MARK_DOT, TtmlNode.TEXT_EMPHASIS_MARK_SESAME, TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final c0<String> f34522g = c0.s(TtmlNode.TEXT_EMPHASIS_MARK_FILLED, "open");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final c0<String> f34523h = c0.t(TtmlNode.ANNOTATION_POSITION_AFTER, TtmlNode.ANNOTATION_POSITION_BEFORE, TtmlNode.ANNOTATION_POSITION_OUTSIDE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f34524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f34526c;

    private b(int i10, int i11, int i12) {
        this.f34524a = i10;
        this.f34525b = i11;
        this.f34526c = i12;
    }

    @Nullable
    public static b a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        String strE = e5.c.e(str.trim());
        if (strE.isEmpty()) {
            return null;
        }
        return b(c0.n(TextUtils.split(strE, f34519d)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static u3.b b(com.google.common.collect.c0<java.lang.String> r9) {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.b.b(com.google.common.collect.c0):u3.b");
    }
}
