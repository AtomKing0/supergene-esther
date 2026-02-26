package e3;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: EventMessageEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f24737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataOutputStream f24738b;

    public c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f24737a = byteArrayOutputStream;
        this.f24738b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(a aVar) {
        this.f24737a.reset();
        try {
            b(this.f24738b, aVar.f24731a);
            String str = aVar.f24732b;
            if (str == null) {
                str = "";
            }
            b(this.f24738b, str);
            this.f24738b.writeLong(aVar.f24733c);
            this.f24738b.writeLong(aVar.f24734d);
            this.f24738b.write(aVar.f24735e);
            this.f24738b.flush();
            return this.f24737a.toByteArray();
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }
}
