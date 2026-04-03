package bo.app;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public final class vc0 extends ByteArrayOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wc0 f4109a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vc0(wc0 wc0Var, int i10) {
        super(i10);
        this.f4109a = wc0Var;
    }

    @Override // java.io.ByteArrayOutputStream
    public final String toString() {
        int i10 = ((ByteArrayOutputStream) this).count;
        if (i10 > 0) {
            int i11 = i10 - 1;
            if (((ByteArrayOutputStream) this).buf[i11] == 13) {
                i10 = i11;
            }
        }
        try {
            return new String(((ByteArrayOutputStream) this).buf, 0, i10, this.f4109a.f4193b.name());
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }
}
