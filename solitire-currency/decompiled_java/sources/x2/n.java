package x2;

import a4.c0;
import androidx.media3.extractor.mp4.Atom;
import androidx.media3.extractor.mp4.Sniffer;
import java.io.IOException;

/* JADX INFO: compiled from: Sniffer.java */
/* JADX INFO: loaded from: classes2.dex */
final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f35857a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, Atom.TYPE_avc1, Atom.TYPE_hvc1, Atom.TYPE_hev1, Atom.TYPE_av01, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, Sniffer.BRAND_QUICKTIME, 1297305174, 1684175153, 1769172332, 1885955686};

    private static boolean a(int i10, boolean z10) {
        if ((i10 >>> 8) == 3368816) {
            return true;
        }
        if (i10 == 1751476579 && z10) {
            return true;
        }
        for (int i11 : f35857a) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(p2.m mVar) throws IOException {
        return c(mVar, true, false);
    }

    private static boolean c(p2.m mVar, boolean z10, boolean z11) throws IOException {
        boolean z12;
        boolean z13;
        boolean z14;
        int i10;
        boolean z15;
        boolean z16;
        long length = mVar.getLength();
        long j10 = -1;
        int i11 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        long j11 = 4096;
        if (i11 != 0 && length <= 4096) {
            j11 = length;
        }
        int i12 = (int) j11;
        c0 c0Var = new c0(64);
        boolean z17 = false;
        int i13 = 0;
        boolean z18 = false;
        while (i13 < i12) {
            c0Var.L(8);
            if (!mVar.peekFully(c0Var.d(), z17 ? 1 : 0, 8, true)) {
                break;
            }
            long jF = c0Var.F();
            int iN = c0Var.n();
            if (jF == 1) {
                mVar.peekFully(c0Var.d(), 8, 8);
                c0Var.O(16);
                i10 = 16;
                jF = c0Var.w();
            } else {
                if (jF == 0) {
                    long length2 = mVar.getLength();
                    if (length2 != j10) {
                        jF = (length2 - mVar.getPeekPosition()) + ((long) 8);
                    }
                }
                i10 = 8;
            }
            long j12 = i10;
            if (jF < j12) {
                return z17;
            }
            i13 += i10;
            if (iN == 1836019574) {
                i12 += (int) jF;
                if (i11 != 0 && i12 > length) {
                    i12 = (int) length;
                }
            } else {
                if (iN == 1836019558 || iN == 1836475768) {
                    z12 = z17 ? 1 : 0;
                    z13 = true;
                    z14 = true;
                    break;
                }
                int i14 = i11;
                if ((((long) i13) + jF) - j12 >= i12) {
                    z12 = false;
                    z13 = true;
                    break;
                }
                int i15 = (int) (jF - j12);
                i13 += i15;
                if (iN != 1718909296) {
                    z15 = false;
                    z18 = z18;
                    if (i15 != 0) {
                        mVar.advancePeekPosition(i15);
                        z18 = z18;
                    }
                } else {
                    if (i15 < 8) {
                        return false;
                    }
                    c0Var.L(i15);
                    mVar.peekFully(c0Var.d(), 0, i15);
                    int i16 = i15 / 4;
                    int i17 = 0;
                    while (true) {
                        if (i17 >= i16) {
                            z16 = z18;
                            break;
                        }
                        if (i17 == 1) {
                            c0Var.Q(4);
                        } else if (a(c0Var.n(), z11)) {
                            z16 = true;
                            break;
                        }
                        i17++;
                    }
                    if (!z16) {
                        return false;
                    }
                    z15 = false;
                    z18 = z16;
                }
                z17 = z15;
                i11 = i14;
            }
            j10 = -1;
            z18 = z18;
        }
        z12 = z17 ? 1 : 0;
        z13 = true;
        z14 = z12 ? 1 : 0;
        return (z18 && z10 == z14) ? z13 : z12;
    }

    public static boolean d(p2.m mVar, boolean z10) throws IOException {
        return c(mVar, false, z10);
    }
}
