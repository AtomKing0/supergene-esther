package ea;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StringOps.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final String[] f25502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final byte[] f25503b;

    static {
        String[] strArr = new String[93];
        for (int i10 = 0; i10 < 32; i10++) {
            strArr[i10] = "\\u" + e(i10 >> 12) + e(i10 >> 8) + e(i10 >> 4) + e(i10);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f25502a = strArr;
        byte[] bArr = new byte[93];
        for (int i11 = 0; i11 < 32; i11++) {
            bArr[i11] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        f25503b = bArr;
    }

    @NotNull
    public static final byte[] a() {
        return f25503b;
    }

    @NotNull
    public static final String[] b() {
        return f25502a;
    }

    public static final void c(@NotNull StringBuilder sb, @NotNull String value) {
        kotlin.jvm.internal.t.i(sb, "<this>");
        kotlin.jvm.internal.t.i(value, "value");
        sb.append('\"');
        int length = value.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = value.charAt(i11);
            String[] strArr = f25502a;
            if (cCharAt < strArr.length && strArr[cCharAt] != null) {
                sb.append((CharSequence) value, i10, i11);
                sb.append(strArr[cCharAt]);
                i10 = i11 + 1;
            }
        }
        if (i10 != 0) {
            sb.append((CharSequence) value, i10, value.length());
        } else {
            sb.append(value);
        }
        sb.append('\"');
    }

    @Nullable
    public static final Boolean d(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        if (p9.q.x(str, com.ironsource.mediationsdk.metadata.a.f13688g, true)) {
            return Boolean.TRUE;
        }
        if (p9.q.x(str, "false", true)) {
            return Boolean.FALSE;
        }
        return null;
    }

    private static final char e(int i10) {
        int i11 = i10 & 15;
        return (char) (i11 < 10 ? i11 + 48 : (i11 - 10) + 97);
    }
}
