package n3;

import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.text.cea.Cea608Decoder;
import k2.o1;

/* JADX INFO: compiled from: SubtitleDecoderFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public interface l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f31671a = new a();

    /* JADX INFO: compiled from: SubtitleDecoderFactory.java */
    class a implements l {
        a() {
        }

        @Override // n3.l
        public boolean a(o1 o1Var) {
            String str = o1Var.f29347l;
            return MimeTypes.TEXT_VTT.equals(str) || MimeTypes.TEXT_SSA.equals(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_SUBRIP.equals(str) || MimeTypes.APPLICATION_TX3G.equals(str) || MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_MP4CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_DVBSUBS.equals(str) || MimeTypes.APPLICATION_PGS.equals(str) || "text/x-exoplayer-cues".equals(str);
        }

        @Override // n3.l
        public j b(o1 o1Var) {
            String str = o1Var.f29347l;
            if (str != null) {
                switch (str) {
                    case "application/dvbsubs":
                        return new p3.a(o1Var.f29349n);
                    case "application/pgs":
                        return new q3.a();
                    case "application/x-mp4-vtt":
                        return new w3.a();
                    case "text/vtt":
                        return new w3.h();
                    case "application/x-quicktime-tx3g":
                        return new v3.a(o1Var.f29349n);
                    case "text/x-ssa":
                        return new s3.a(o1Var.f29349n);
                    case "application/x-mp4-cea-608":
                    case "application/cea-608":
                        return new o3.a(str, o1Var.D, Cea608Decoder.MIN_DATA_CHANNEL_TIMEOUT_MS);
                    case "text/x-exoplayer-cues":
                        return new g();
                    case "application/cea-708":
                        return new o3.c(o1Var.D, o1Var.f29349n);
                    case "application/x-subrip":
                        return new t3.a();
                    case "application/ttml+xml":
                        return new u3.c();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(o1 o1Var);

    j b(o1 o1Var);
}
