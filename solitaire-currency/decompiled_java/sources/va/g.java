package va;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: -ByteString.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final char[] f35254a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0047 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0081 A[EDGE_INSN: B:261:0x0081->B:55:0x0081 BREAK  A[LOOP:1: B:31:0x0051->B:59:0x0088, LOOP_LABEL: LOOP:0: B:3:0x0008->B:289:0x0008], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x00da A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x016a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0213 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int c(byte[] r19, int r20) {
        /*
            Method dump skipped, instruction units count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: va.g.c(byte[], int):int");
    }

    public static final void d(@NotNull ua.f fVar, @NotNull ua.c buffer, int i10, int i11) {
        t.i(fVar, "<this>");
        t.i(buffer, "buffer");
        buffer.write(fVar.g(), i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(char c10) {
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (!('a' <= c10 && c10 < 'g')) {
            c11 = 'A';
            if (!('A' <= c10 && c10 < 'G')) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c10);
            }
        }
        return (c10 - c11) + 10;
    }

    @NotNull
    public static final char[] f() {
        return f35254a;
    }
}
