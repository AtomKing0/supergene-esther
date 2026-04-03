package b3;

import b3.v;
import java.util.List;

/* JADX INFO: compiled from: MediaCodecSelector.java */
/* JADX INFO: loaded from: classes2.dex */
public interface q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f2055a = new q() { // from class: b3.p
        @Override // b3.q
        public final List getDecoderInfos(String str, boolean z10, boolean z11) {
            return v.s(str, z10, z11);
        }
    };

    List<n> getDecoderInfos(String str, boolean z10, boolean z11) throws v.c;
}
