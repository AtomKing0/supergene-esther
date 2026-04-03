package c3;

import androidx.media3.common.MimeTypes;
import k2.o1;

/* JADX INFO: compiled from: MetadataDecoderFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f4494a = new a();

    /* JADX INFO: compiled from: MetadataDecoderFactory.java */
    class a implements d {
        a() {
        }

        @Override // c3.d
        public boolean a(o1 o1Var) {
            String str = o1Var.f29347l;
            return MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str) || MimeTypes.APPLICATION_ICY.equals(str) || MimeTypes.APPLICATION_AIT.equals(str);
        }

        @Override // c3.d
        public c b(o1 o1Var) {
            String str = o1Var.f29347l;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new d3.b();
                    case "application/x-icy":
                        return new g3.a();
                    case "application/id3":
                        return new h3.h();
                    case "application/x-emsg":
                        return new e3.b();
                    case "application/x-scte35":
                        return new j3.c();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(o1 o1Var);

    c b(o1 o1Var);
}
