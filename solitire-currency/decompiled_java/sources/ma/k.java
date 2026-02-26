package ma;

import ga.a0;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.q;

/* JADX INFO: compiled from: StatusLine.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f31498d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final a0 f31499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f31500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f31501c;

    /* JADX INFO: compiled from: StatusLine.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final k a(@NotNull String statusLine) throws IOException {
            a0 a0Var;
            int i10;
            String strSubstring;
            t.i(statusLine, "statusLine");
            if (q.K(statusLine, "HTTP/1.", false, 2, null)) {
                i10 = 9;
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException(t.r("Unexpected status line: ", statusLine));
                }
                int iCharAt = statusLine.charAt(7) - '0';
                if (iCharAt == 0) {
                    a0Var = a0.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException(t.r("Unexpected status line: ", statusLine));
                    }
                    a0Var = a0.HTTP_1_1;
                }
            } else {
                if (!q.K(statusLine, "ICY ", false, 2, null)) {
                    throw new ProtocolException(t.r("Unexpected status line: ", statusLine));
                }
                a0Var = a0.HTTP_1_0;
                i10 = 4;
            }
            int i11 = i10 + 3;
            if (statusLine.length() < i11) {
                throw new ProtocolException(t.r("Unexpected status line: ", statusLine));
            }
            try {
                String strSubstring2 = statusLine.substring(i10, i11);
                t.h(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                int i12 = Integer.parseInt(strSubstring2);
                if (statusLine.length() <= i11) {
                    strSubstring = "";
                } else {
                    if (statusLine.charAt(i11) != ' ') {
                        throw new ProtocolException(t.r("Unexpected status line: ", statusLine));
                    }
                    strSubstring = statusLine.substring(i10 + 4);
                    t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
                }
                return new k(a0Var, i12, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException(t.r("Unexpected status line: ", statusLine));
            }
        }
    }

    public k(@NotNull a0 protocol, int i10, @NotNull String message) {
        t.i(protocol, "protocol");
        t.i(message, "message");
        this.f31499a = protocol;
        this.f31500b = i10;
        this.f31501c = message;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f31499a == a0.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.f31500b);
        sb.append(' ');
        sb.append(this.f31501c);
        String string = sb.toString();
        t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
