package androidx.media3.extractor.text.ttml;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.common.collect.c0;
import e5.c;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
final class TextEmphasis {
    public static final int MARK_SHAPE_AUTO = -1;
    public static final int POSITION_OUTSIDE = -2;
    public final int markFill;
    public final int markShape;
    public final int position;
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");
    private static final c0<String> SINGLE_STYLE_VALUES = c0.s(TtmlNode.TEXT_EMPHASIS_AUTO, "none");
    private static final c0<String> MARK_SHAPE_VALUES = c0.t(TtmlNode.TEXT_EMPHASIS_MARK_DOT, TtmlNode.TEXT_EMPHASIS_MARK_SESAME, TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE);
    private static final c0<String> MARK_FILL_VALUES = c0.s(TtmlNode.TEXT_EMPHASIS_MARK_FILLED, "open");
    private static final c0<String> POSITION_VALUES = c0.t(TtmlNode.ANNOTATION_POSITION_AFTER, TtmlNode.ANNOTATION_POSITION_BEFORE, TtmlNode.ANNOTATION_POSITION_OUTSIDE);

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
    }

    private TextEmphasis(int i10, int i11, int i12) {
        this.markShape = i10;
        this.markFill = i11;
        this.position = i12;
    }

    @Nullable
    public static TextEmphasis parse(@Nullable String str) {
        if (str == null) {
            return null;
        }
        String strE = c.e(str.trim());
        if (strE.isEmpty()) {
            return null;
        }
        return parseWords(c0.n(TextUtils.split(strE, WHITESPACE_PATTERN)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static androidx.media3.extractor.text.ttml.TextEmphasis parseWords(com.google.common.collect.c0<java.lang.String> r9) {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TextEmphasis.parseWords(com.google.common.collect.c0):androidx.media3.extractor.text.ttml.TextEmphasis");
    }
}
