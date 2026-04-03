package v2;

import java.io.IOException;
import k2.j2;
import p2.m;

/* JADX INFO: compiled from: EbmlProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b {
    void a(int i10, int i11, m mVar) throws IOException;

    void endMasterElement(int i10) throws j2;

    void floatElement(int i10, double d10) throws j2;

    int getElementType(int i10);

    void integerElement(int i10, long j10) throws j2;

    boolean isLevel1Element(int i10);

    void startMasterElement(int i10, long j10, long j11) throws j2;

    void stringElement(int i10, String str) throws j2;
}
