package x2;

import a4.c0;
import a4.t;
import androidx.annotation.Nullable;
import androidx.media3.extractor.mp4.Atom;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: compiled from: PsshAtomUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: compiled from: PsshAtomUtil.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UUID f35846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f35847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final byte[] f35848c;

        public a(UUID uuid, int i10, byte[] bArr) {
            this.f35846a = uuid;
            this.f35847b = i10;
            this.f35848c = bArr;
        }
    }

    public static byte[] a(UUID uuid, @Nullable byte[] bArr) {
        return b(uuid, null, bArr);
    }

    public static byte[] b(UUID uuid, @Nullable UUID[] uuidArr, @Nullable byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(Atom.TYPE_pssh);
        byteBufferAllocate.putInt(uuidArr != null ? 16777216 : 0);
        byteBufferAllocate.putLong(uuid.getMostSignificantBits());
        byteBufferAllocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            byteBufferAllocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                byteBufferAllocate.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && bArr.length != 0) {
            byteBufferAllocate.putInt(bArr.length);
            byteBufferAllocate.put(bArr);
        }
        return byteBufferAllocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    @Nullable
    private static a d(byte[] bArr) {
        c0 c0Var = new c0(bArr);
        if (c0Var.f() < 32) {
            return null;
        }
        c0Var.P(0);
        if (c0Var.n() != c0Var.a() + 4 || c0Var.n() != 1886614376) {
            return null;
        }
        int iC = x2.a.c(c0Var.n());
        if (iC > 1) {
            t.i("PsshAtomUtil", "Unsupported pssh version: " + iC);
            return null;
        }
        UUID uuid = new UUID(c0Var.w(), c0Var.w());
        if (iC == 1) {
            c0Var.Q(c0Var.H() * 16);
        }
        int iH = c0Var.H();
        if (iH != c0Var.a()) {
            return null;
        }
        byte[] bArr2 = new byte[iH];
        c0Var.j(bArr2, 0, iH);
        return new a(uuid, iC, bArr2);
    }

    @Nullable
    public static byte[] e(byte[] bArr, UUID uuid) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return null;
        }
        if (uuid.equals(aVarD.f35846a)) {
            return aVarD.f35848c;
        }
        t.i("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + aVarD.f35846a + ".");
        return null;
    }

    @Nullable
    public static UUID f(byte[] bArr) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return null;
        }
        return aVarD.f35846a;
    }

    public static int g(byte[] bArr) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return -1;
        }
        return aVarD.f35847b;
    }
}
